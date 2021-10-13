package pl.coderslab.recipeapp.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
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
import java.time.LocalDateTime;

@Controller
@RequestMapping("/user")
public class PlanController {

    private final UserService userService;
    private final PlanRepository planRepository;
    private final RecipeRepository recipeRepository;

    public PlanController(UserService userService, PlanRepository planRepository, RecipeRepository recipeRepository) {
        this.userService = userService;
        this.planRepository = planRepository;
        this.recipeRepository = recipeRepository;
    }

    @GetMapping("/plan/list")
    public String showListOfPlans(@AuthenticationPrincipal UserDetails customUser, Model model){
        User user = userService.findByUserName(customUser.getUsername());
        model.addAttribute("user", user);
        model.addAttribute("plan", planRepository.findPlanByUserId(user.getId()));
        return "plan/list";
    }
    @GetMapping("/plan/add")
    public String addPlan(@AuthenticationPrincipal UserDetails customUser, Model model){
        User user = userService.findByUserName(customUser.getUsername());
        model.addAttribute("user", user);
        model.addAttribute("plan", new Plan());
        return "plan/addForm";
    }

    @PostMapping("/plan/add")
    public String addPlan(@Valid Plan plan, BindingResult bindingResult, @AuthenticationPrincipal UserDetails customUser){
        if(bindingResult.hasErrors()){
            return "plan/addForm";
        }else {
            plan.setCreatedTime(LocalDateTime.now());
            User user = userService.findByUserName(customUser.getUsername());
            plan.setUser(user);
            planRepository.save(plan);
            return "redirect:/user/plan/list";
        }
    }

}
