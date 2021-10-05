package pl.coderslab.recipeapp.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
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
    private String preparation;
    @ManyToOne
    private User user;
}
