package pl.coderslab.recipeapp.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Collection;
import java.util.Set;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Please enter your name.")
    private String firstName;
    @NotEmpty(message = "Please enter your surname.")
    private String lastName;
    @NotEmpty(message = "Must be unique. You will use it for login.")
    @Column(nullable = false, unique = true, length = 60)
    private String username;
    @NotEmpty(message = "Please enter your email")
    @Email(message = "Please enter correct email format.")
    private String email;
    @NotEmpty(message = "Can not be empty")
    private String password;
    private int enable;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
    public User(String username, String password, Collection<? extends GrantedAuthority> authorities) {
    }
}
