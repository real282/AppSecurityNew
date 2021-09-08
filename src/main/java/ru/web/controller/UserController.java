package ru.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.model.User;
import ru.service.UserService.UserService;


@Controller
@RequestMapping(value = "/")
public class UserController {


    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping(value = "/")
    public String loginPage() {
        return "login";
    }

    @GetMapping(value = "/list")
    public String printIndex(Model model) {
        model.addAttribute("messages", userService.listUsers());
        return "listUser";
    }

    @GetMapping(value = "/create")
    public String createUser(Model model) {
        model.addAttribute("User", new User());
        return "create";
    }

    @PostMapping(value = "/add")
    public String addUser(@ModelAttribute("user") User user, Model model) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.add(user);
        model.addAttribute("User", new User());
        return "create";
    }

    @GetMapping(value = "/delete={id}")
    public String deleteUser(@PathVariable("id") long id) {
        System.out.println("DELETE " + id);
        userService.delete(id);
        return "redirect:/list";
    }

    @GetMapping (value = "/update={id}")
    public String update(@PathVariable("id") long id, Model model) {
        model.addAttribute("User", userService.getUserId(id));
        return "AllPage/update";
    }

    @PostMapping(value = "/edit")
    public String editUser(@ModelAttribute("user") User user) {
        userService.update(user);
        return "redirect:/";
    }

    @GetMapping(value = "userPage")
    public String getInfo(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        return "userPage";
    }

    @GetMapping(value = "adminPage")
    public String getInfoAdmin(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        return "adminPage";
    }

}
