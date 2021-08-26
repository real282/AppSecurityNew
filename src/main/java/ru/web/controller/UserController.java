package ru.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.model.User;
import ru.service.UserService;


@Controller
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(value = "/users")
    public String printCars(Model model) {
        System.out.println(userService.listUsers().toString());
        model.addAttribute("messages", userService.listUsers());
        return "users";
    }
}
