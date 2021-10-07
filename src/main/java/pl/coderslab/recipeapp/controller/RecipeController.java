package pl.coderslab.recipeapp.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.recipeapp.model.Recipe;
import pl.coderslab.recipeapp.model.User;
import pl.coderslab.recipeapp.repository.RecipeRepository;
import pl.coderslab.recipeapp.service.UserService;

import java.time.LocalDateTime;

@Controller
public class RecipeController {

    private RecipeRepository recipeRepository;
    private  UserService userService;

    public RecipeController(RecipeRepository recipeRepository, UserService userService) {
        this.recipeRepository = recipeRepository;
        this.userService = userService;
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
    public String addRecipe(Recipe recipe,@AuthenticationPrincipal UserDetails customUser){
        recipe.setCreatedTime(LocalDateTime.now());
        User user = userService.findByUserName(customUser.getUsername());
        recipe.setUser(user);
        recipeRepository.save(recipe);
        return "redirect:/user/recipe/list";
    }
    @GetMapping("/user/recipe/delete/{id}")
    public String deleteRecipe(Model model, @PathVariable Long id){
        recipeRepository.delete(recipeRepository.findRecipeById(id));
        return "redirect:/user/recipe/list";
    }
}
