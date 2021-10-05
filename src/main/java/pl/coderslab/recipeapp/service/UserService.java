package pl.coderslab.recipeapp.service;

import pl.coderslab.recipeapp.model.User;


public interface UserService {
    User findByUserName(String name);
    void saveUser(User user);

}
