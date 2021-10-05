package pl.coderslab.recipeapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.recipeapp.repository.RecipeRepository;

@Controller
@RequestMapping("/recipes")
public class RecipeController {

    private RecipeRepository recipeRepository;

    public RecipeController(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @GetMapping("")
    public String showRecipeList(){
    recipeRepository.findAll();
    return "recipe/recipeList";
    }
}
