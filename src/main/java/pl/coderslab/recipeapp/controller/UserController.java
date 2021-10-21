package pl.coderslab.recipeapp.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.recipeapp.model.Plan;
import pl.coderslab.recipeapp.model.User;
import pl.coderslab.recipeapp.repository.PlanRepository;
import pl.coderslab.recipeapp.repository.RecipeRepository;
import pl.coderslab.recipeapp.service.UserService;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final BCryptPasswordEncoder passwordEncoder;
    private final RecipeRepository recipeRepository;
    private final PlanRepository planRepository;

    public UserController(UserService userService, BCryptPasswordEncoder passwordEncoder, RecipeRepository recipeRepository, PlanRepository planRepository) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.recipeRepository = recipeRepository;
        this.planRepository = planRepository;
    }


    @GetMapping("/dashboard")
    public String showDashboard(Model model, @AuthenticationPrincipal UserDetails customUser){
        model.addAttribute("userdetail",customUser);
        User user = userService.findByUserName(customUser.getUsername());
        model.addAttribute("user", user);
        model.addAttribute("count", recipeRepository.countByUserId(user.getId()));
        model.addAttribute("countPlan", planRepository.countByUserId(user.getId()));
        List<Plan> plans = planRepository.findPlanByUserId(user.getId());
        Long recentId = plans.stream().map(it -> it.getId()).max(Long::compare).get();
        model.addAttribute("recentPlan", planRepository.findPlanById(recentId));
        return "user/userDashboard";
    }
    @GetMapping("/edit")
    public String editUser(Model model, @AuthenticationPrincipal UserDetails customUser){
        User user = userService.findByUserName(customUser.getUsername());
        model.addAttribute("user",user);
        return "user/editData";
    }
    @PostMapping("/edit")
    public String editUser(@Valid User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "user/editData";
        }
        userService.saveUser(user);
        return "redirect:/user/dashboard";
    }

}

