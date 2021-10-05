package pl.coderslab.recipeapp.model;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name= "recipes")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String ingredients;
    private String description;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
    private String preparationTime;
}
