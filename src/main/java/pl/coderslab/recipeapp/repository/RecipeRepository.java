package pl.coderslab.recipeapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.recipeapp.model.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

}
