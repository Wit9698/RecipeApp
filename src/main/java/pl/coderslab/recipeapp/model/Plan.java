package pl.coderslab.recipeapp.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "plans")
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private LocalDateTime createdTime;
    @ManyToOne
    private User user;
    @ManyToMany
    private List <Recipe> recipes;
}
