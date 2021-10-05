package pl.coderslab.recipeapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.recipeapp.model.User;
import pl.coderslab.recipeapp.service.UserService;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "home/registration";
    }

    @PostMapping("/registration")
    public String showRegistrationForm(User user){
        user.setEnable(1);
        userService.saveUser(user);
        return  "redirect:/home";
    }

    @GetMapping("/login")
    public String viewLoginPage() {
        return "home/login";
    }
}
// if (result.hasErrors()) {
//         return "registration";
//         }
//         User userExists = userService.findByUserName(user.getUsername());
//         if (userExists != null) {
//         return "registration";
//         }
//         userService.saveUser(user);
//         return "redirect:/login";
//
//         }
