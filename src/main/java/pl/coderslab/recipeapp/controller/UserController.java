package pl.coderslab.recipeapp.controller;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.recipeapp.model.User;
import pl.coderslab.recipeapp.service.UserService;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;


@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserController(UserService userService, BCryptPasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }


    @GetMapping("/dashboard")
    public String showDashboard(Model model, @AuthenticationPrincipal UserDetails customUser){
        model.addAttribute("userdetail",customUser);
        User user = userService.findByUserName(customUser.getUsername());
        model.addAttribute("user", user);
        return "user/userDashboard";
    }
    @GetMapping("/edit")
    public String editUser(Model model, @AuthenticationPrincipal UserDetails customUser){
        User user = userService.findByUserName(customUser.getUsername());
        model.addAttribute("user",user);
        return "user/editData";
    }
    @PostMapping("/edit")
    public String editUser(@Valid User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "user/editData";
        }
        userService.saveUser(user);
        return "redirect:/user/dashboard";
    }

}

