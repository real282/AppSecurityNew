package ru.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.model.User;
import ru.service.UserService;


@Controller
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(value = "/")
    public String printCars(Model model) {
        model.addAttribute("messages", userService.listUsers());
        return "index";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/";
    }

    @GetMapping(value = "/delete={id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.delete(id);
        return "redirect:/";
    }

    @GetMapping(value = "/update={id}")
    public String update(@PathVariable("id") long id) {
        String str = "redirect:/update?id=" + id;
        return str;
    }

    @GetMapping(value = "/create")
    public String createUser() {
        return "create";
    }

}
