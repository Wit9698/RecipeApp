package pl.coderslab.recipeapp.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.recipeapp.model.User;
import pl.coderslab.recipeapp.repository.RecipeRepository;
import pl.coderslab.recipeapp.service.UserService;

@Controller
public class RecipeController {

    private RecipeRepository recipeRepository;
    private  UserService userService;

    public RecipeController(RecipeRepository recipeRepository, UserService userService) {
        this.recipeRepository = recipeRepository;
        this.userService = userService;
    }


    @GetMapping("/recipes")
    public String showRecipeList(){
    recipeRepository.findAll();
    return "recipe/recipeList";
    }

    @GetMapping("/user/recipe/list")
    public String showRecipeListAfterLogin(@AuthenticationPrincipal UserDetails customUser, Model model){
        User user = userService.findByUserName(customUser.getUsername());
        model.addAttribute("recipes",recipeRepository.findRecipeByUserId(user.getId()));
        model.addAttribute("user", user);
        return "recipe/list";
    }
    @GetMapping("/user/recipe/add")
    public String addRecipe(){
        return "recipe/addForm";
    }


}
