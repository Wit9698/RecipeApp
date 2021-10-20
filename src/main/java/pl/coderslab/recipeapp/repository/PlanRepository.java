package pl.coderslab.recipeapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.recipeapp.model.Plan;

import java.util.List;

public interface PlanRepository extends JpaRepository<Plan, Long> {
    List<Plan> findPlanByUserId(long id);
    Plan findPlanById(long id);

}
