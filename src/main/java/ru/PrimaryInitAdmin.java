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
public class PrimaryInitAdmin {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public PrimaryInitAdmin(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void addAdmin() {
        System.out.println("add ADMIN");
        Set<Role> setRoles = new HashSet<>();
        setRoles.add(new Role("ADMIN"));
        setRoles.add(new Role("USER"));
        User admin = new User("ADMIN", passwordEncoder.encode("ADMIN"), "Roznin", "real282@mail.ru", setRoles);
        userService.add(admin);
    }
}
