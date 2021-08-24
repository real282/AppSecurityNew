package web.controller;

import Service.UserServiceImp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UserController {

    @GetMapping(value = "/users")
    public String printCars(@RequestParam("count") int count, Model model) {
        UserServiceImp userService = new UserServiceImp();
        System.out.println(userService.getUser(count).toString());
        model.addAttribute("messages", userService.getUser(count));
        return "users";
    }
}
