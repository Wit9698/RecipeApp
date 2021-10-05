package pl.coderslab.recipeapp.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "plans")
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private LocalDateTime createdTime;
}
