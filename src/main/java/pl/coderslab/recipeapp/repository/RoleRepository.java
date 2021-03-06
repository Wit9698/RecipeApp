package pl.coderslab.recipeapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.recipeapp.model.Role;


public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(String name);
}
