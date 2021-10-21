package pl.coderslab.recipeapp.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.recipeapp.model.Plan;
import pl.coderslab.recipeapp.model.Recipe;
import pl.coderslab.recipeapp.model.User;
import pl.coderslab.recipeapp.repository.PlanRepository;
import pl.coderslab.recipeapp.repository.RecipeRepository;
import pl.coderslab.recipeapp.service.UserService;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class RecipeController {

    private final RecipeRepository recipeRepository;
    private  final UserService userService;
    private final PlanRepository planRepository;

    public RecipeController(RecipeRepository recipeRepository, UserService userService, PlanRepository planRepository) {
        this.recipeRepository = recipeRepository;
        this.userService = userService;
        this.planRepository = planRepository;
    }


    @GetMapping("/recipes")
    public String showRecipeList(Model model){
        model.addAttribute("recipe", recipeRepository.findAll());
    return "recipe/recipeList";
    }
    @GetMapping("/recipes/details/{id}")
    public String showRecipeList(Model model, @PathVariable Long id) {
        model.addAttribute("recipe", recipeRepository.findRecipeById(id));
        return "recipe/details";
    }
    @GetMapping("/user/recipe/list")
    public String showRecipeListAfterLogin(@AuthenticationPrincipal UserDetails customUser, Model model){
        User user = userService.findByUserName(customUser.getUsername());
        model.addAttribute("recipes",recipeRepository.findRecipeByUserId(user.getId()));
        model.addAttribute("user", user);
        return "recipe/list";
    }
    @GetMapping("/user/recipe/add")
    public String addRecipe(@AuthenticationPrincipal UserDetails customUser, Model model){
        User user = userService.findByUserName(customUser.getUsername());
        model.addAttribute("user", user);
        model.addAttribute("recipe", new Recipe());
        return "recipe/addForm";
    }

    @PostMapping("/user/recipe/add")
    public String addRecipe(Model model,@Valid Recipe recipe, BindingResult bindingResult, @AuthenticationPrincipal UserDetails customUser){
        if(bindingResult.hasErrors()){
            User user = userService.findByUserName(customUser.getUsername());
            model.addAttribute("user", user);
            return "recipe/addForm";
        }else {
            recipe.setCreatedTime(LocalDateTime.now());
            User user = userService.findByUserName(customUser.getUsername());
            recipe.setUser(user);
            recipeRepository.save(recipe);
            return "redirect:/user/recipe/list";
        }
    }
    @GetMapping("/user/recipe/delete/{id}")
    public String deleteRecipe(Model model, @PathVariable Long id){
        List<Plan> plansWithThisRecipe = planRepository.findPlanByRecipes(recipeRepository.findRecipeById(id));
        if(plansWithThisRecipe.isEmpty()){
            recipeRepository.delete(recipeRepository.findRecipeById(id));
        }else{
            return "redirect:/user/recipe/deleteinfo";
        }
        return "redirect:/user/recipe/list";
    }
    @RequestMapping("/user/recipe/deleteinfo")
    public String deleteInformation(Model model) {
        return "recipe/deleteinfo";
    }

    @GetMapping("user/recipe/edit/{id}")
    public String editRecipe(@PathVariable long id, Model model,@AuthenticationPrincipal UserDetails customUser){
        model.addAttribute("recipe",recipeRepository.findRecipeById(id));
        User user = userService.findByUserName(customUser.getUsername());
        model.addAttribute("user", user);
        return "recipe/edit";
    }
    @PostMapping("user/recipe/edit/{id}")
    public String editRecipe(@PathVariable long id, Model model,@Valid Recipe recipe,BindingResult bindingResult,@AuthenticationPrincipal UserDetails customUser){
        if(bindingResult.hasErrors()){
            model.addAttribute("recipe",recipeRepository.findRecipeById(id));
            User user = userService.findByUserName(customUser.getUsername());
            model.addAttribute("user", user);
            return "recipe/edit";
        } else {
            User user = userService.findByUserName(customUser.getUsername());
            recipe.setUser(user);
            recipe.setUpdatedTime(LocalDateTime.now());
            recipeRepository.save(recipe);
            return "redirect:/user/recipe/list";
        }
    }
    @GetMapping("user/recipe/details/{id}")
    public String showRecipeDetails(@PathVariable Long id, Model model, @AuthenticationPrincipal UserDetails customUser){
        model.addAttribute("recipe", recipeRepository.findRecipeById(id));
        User user = userService.findByUserName(customUser.getUsername());
        model.addAttribute("user", user);
        return "recipe/appDetails";
    }
}
