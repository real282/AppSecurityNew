package ru;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.model.Role;
import ru.model.User;
import ru.service.UserService.UserService;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class PrimaryInitUser {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public PrimaryInitUser(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void addAdmin() {
        System.out.println("add User");
        Set<Role> setRolesAdmin = new HashSet<>();
        setRolesAdmin.add(new Role("ROLE_ADMIN"));
        setRolesAdmin.add(new Role("ROLE_USER"));
        User admin = new User("ADMIN",
                passwordEncoder.encode("ADMIN"),
                "Roznin",
                "real282@mail.ru",
                setRolesAdmin);
        userService.add(admin);

        Set<Role> setRolesUser = new HashSet<>();
        setRolesUser.add(new Role("ROLE_USER"));
        User user = new User("USER",
                passwordEncoder.encode("USER"),
                "Petrov",
                "test@mail.ru",
                setRolesUser);
        userService.add(user);
    }

}
