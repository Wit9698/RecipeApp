package pl.coderslab.recipeapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "plans")
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Please enter plan name")
    private String name;
    @NotEmpty(message = "Please enter short description")
    private String description;
    private LocalDateTime createdTime;
    @ManyToOne
    private User user;
    @ManyToMany
    private List <Recipe> recipes;
}
