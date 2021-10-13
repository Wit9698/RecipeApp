package pl.coderslab.recipeapp.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.recipeapp.model.User;
import pl.coderslab.recipeapp.repository.PlanRepository;
import pl.coderslab.recipeapp.service.UserService;

@Controller
@RequestMapping("/user")
public class PlanController {

    private final UserService userService;
    private final PlanRepository planRepository;

    public PlanController(UserService userService, PlanRepository planRepository) {
        this.userService = userService;
        this.planRepository = planRepository;
    }

    @GetMapping("/plan/list")
    public String showListOfPlans(@AuthenticationPrincipal UserDetails customUser, Model model){
        User user = userService.findByUserName(customUser.getUsername());
        model.addAttribute("user", user);
        model.addAttribute("plan", planRepository.findPlanByUserId(user.getId()));
        return "plan/list";
    }
}
