package pl.coderslab.recipeapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.recipeapp.model.Plan;

public interface PlanRepository extends JpaRepository<Plan, Long> {

}
