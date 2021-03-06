package ru.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.model.Role;
import ru.model.User;
import ru.service.RoleService.RoleService;
import ru.service.UserService.UserService;

import java.util.HashSet;
import java.util.Set;


@Controller
@RequestMapping(value = "/")
public class UserController {


    private final UserService userService;
    private final RoleService roleService;


    @Autowired
    public UserController(UserService userService,
                          RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping(value = "/")
    public String loginPage() {
        return "redirect:/login";
    }

    //список со всеми пользователями
    @GetMapping("/list")
    public String printIndex(Model model) {
        model.addAttribute("messages", userService.listUsers());
        return "listUser";
    }

    //форма регистрации нового пользователя
    @GetMapping("/create")
    public String createUser(Model model) {
        model.addAttribute("User", new User());
        model.addAttribute("Roles", roleService.listRole());
        return "create";
    }

    //обработка кнопки с формы регистрации нового пользователя
    @PostMapping("/add")
    public String addUser(@ModelAttribute("user") User user,
                          @RequestParam("rolesArr") Integer[] rolesId) {
        Set<Role> setRole = new HashSet<>();
        for (int id : rolesId) {
            setRole.add(roleService.getRoleById(id));
        }
        user.setRoles(setRole);
        userService.add(user);
        return "redirect:/list";
    }

    //удаление пользователя
    @GetMapping("/delete={id}")
    public String deleteUser(@PathVariable("id") long id) {
        System.out.println("DELETE " + id);
        userService.delete(id);
        return "redirect:/list";
    }

    //страница с формой редактирования пользователя
    @GetMapping("/update={id}")
    public String update(@PathVariable("id") long id, Model model) {
        User user = userService.getUserId(id);
        user.setPassword("");
        model.addAttribute("User", user);
        model.addAttribute("Roles", roleService.listRole());
        return "update";
    }

    //обработка кнопки ОК из формы редактирования пользователя
    @PatchMapping("/edit")
    public String editUser(@ModelAttribute("user") User user,
                           @RequestParam("rolesArr") Integer[] rolesId) {
        Set<Role> setRole = new HashSet<>();
        for (int id : rolesId) {
            setRole.add(roleService.getRoleById(id));
        }
        user.setRoles(setRole);
        userService.update(user);
        return "redirect:/list";
    }

    //начальная страница юзера после логина
    @GetMapping("userPage")
    public String getInfo(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        return "userPage";
    }

    //начальная страница админа после логина
    @GetMapping("adminPage")
    public String getInfoAdmin(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        return "adminPage";
    }
}
