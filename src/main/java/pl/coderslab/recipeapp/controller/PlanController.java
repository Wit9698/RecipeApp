package pl.coderslab.recipeapp.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.recipeapp.model.Plan;
import pl.coderslab.recipeapp.model.Recipe;
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
        model.addAttribute("recipes", recipeRepository.findRecipeByUserId(user.getId()));
        return "plan/addForm";
    }

    @PostMapping("/plan/add")
    public String addPlan(Model model,@Valid Plan plan, BindingResult bindingResult, @AuthenticationPrincipal UserDetails customUser){
        if(bindingResult.hasErrors()){
            User user = userService.findByUserName(customUser.getUsername());
            model.addAttribute("user", user);
            model.addAttribute("recipes", recipeRepository.findRecipeByUserId(user.getId()));
            return "plan/addForm";
        }else {
            plan.setCreatedTime(LocalDateTime.now());
            User user = userService.findByUserName(customUser.getUsername());
            plan.setUser(user);
            planRepository.save(plan);
            return "redirect:/user/plan/list";
        }
    }
    @GetMapping("/plan/delete/{id}")
    public String deletePlan(Model model, @PathVariable Long id){
        planRepository.delete(planRepository.findPlanById(id));
        return "redirect:/user/plan/list";
    }
    @GetMapping("/plan/details/{id}")
    public String showDetails(@PathVariable Long id, Model model,@AuthenticationPrincipal UserDetails customUser){
        User user = userService.findByUserName(customUser.getUsername());
        model.addAttribute("user", user);
        model.addAttribute("plan", planRepository.findPlanById(id));
        return "plan/details";
    }
    @GetMapping("/plan/edit/{id}")
    public String editPlan(@PathVariable long id, Model model,@AuthenticationPrincipal UserDetails customUser){
        User user = userService.findByUserName(customUser.getUsername());
        model.addAttribute("user", user);
        model.addAttribute("plan",planRepository.findPlanById(id));
        model.addAttribute("recipes", recipeRepository.findRecipeByUserId(user.getId()));
        return "plan/edit";
    }
    @PostMapping("/plan/edit/{id}")
    public String editPlan(@PathVariable long id, Model model, @Valid Plan plan, BindingResult bindingResult, @AuthenticationPrincipal UserDetails customUser){
        if(bindingResult.hasErrors()){
            model.addAttribute("plan",planRepository.findPlanById(id));
            User user = userService.findByUserName(customUser.getUsername());
            model.addAttribute("user", user);
            return "plan/edit";
        } else {
            User user = userService.findByUserName(customUser.getUsername());
            plan.setUser(user);
            planRepository.save(plan);
            return "redirect:/user/plan/list";
        }
    }

}
