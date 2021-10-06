package pl.coderslab.recipeapp.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.recipeapp.model.User;
import pl.coderslab.recipeapp.service.UserService;

import javax.validation.Valid;


@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
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

