package ru;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.config.dataBase.DBConfig;
import ru.model.Role;
import ru.model.User;
import ru.service.UserServiceImp;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DBConfig.class);

        UserServiceImp userService = context.getBean(UserServiceImp.class);
        Set<Role> setRole = new HashSet<>();
        setRole.add(new Role("ADMIN"));
        User user = new User("ADMIN", "ADMIN", "Roznin", "real282@mail.ru", setRole);
        userService.add(user);

        context.close();
    }
}
