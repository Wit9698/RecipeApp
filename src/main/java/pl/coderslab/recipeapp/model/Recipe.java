package pl.coderslab.recipeapp.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name= "recipes")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Please enter recipe name")
    private String name;
    @NotEmpty(message = "Will be easier if u give some more details :)")
    private String ingredients;
    @NotEmpty(message = "Enter short description")
    private String description;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
    @Min(value = 1, message = "must be greater than 1")
    private String preparationTime;
    @NotEmpty(message = "A detailed description is necessary")
    private String preparation;
    @ManyToOne
    private User user;
}
