package pl.coderslab.recipeapp.model;
import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String nick;
    private String email;
    private String password;
    private int enable;

}
