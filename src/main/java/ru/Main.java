package ru;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.config.dataBase.DBConfig;
import ru.model.User;
import ru.service.UserServiceImp;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DBConfig.class);

        UserServiceImp userService = context.getBean(UserServiceImp.class);

//        userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
//        userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
//        userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
//        userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

        DriverManagerDataSource managerDataSource = new DriverManagerDataSource();
        managerDataSource.setPassword("root");

//        List<User> users = userService.listUsers();
//        System.out.println(users.toString());
        System.out.println(userService.getUserId(2));

        userService.delete(3);

        context.close();
    }
}
