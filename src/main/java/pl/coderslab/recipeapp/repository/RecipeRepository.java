package pl.coderslab.recipeapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.recipeapp.model.Recipe;


import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    List<Recipe> findRecipeByUserId(long id);
    Recipe findRecipeById(Long id);
    Long countByUserId(long id);
}
