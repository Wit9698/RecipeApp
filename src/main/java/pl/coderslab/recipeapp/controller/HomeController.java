package pl.coderslab.recipeapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.recipeapp.model.User;
import pl.coderslab.recipeapp.service.UserService;

import javax.validation.Valid;

@Controller
public class HomeController {

    private final UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "home/registration";
    }

    @PostMapping("/registration")
    public String showRegistrationForm(@Valid User user, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "home/registration";
        } else if(userService.findByUserName(user.getUsername()) != null){
            bindingResult.addError(new FieldError(user.toString(),"username","Username is already taken"));
        }else {
            user.setEnable(1);
            userService.saveUser(user);
            return "redirect:/login";
        }
        return "home/registration";
    }

    @GetMapping("/login")
    public String viewLoginPage() {
        return "home/login";
    }

    @RequestMapping("/")
    public String viewHomePage() {
        return "home/homepage";
    }

}