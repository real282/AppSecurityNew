package ru.service;

import org.springframework.stereotype.Component;
import ru.model.User;

import java.util.List;


public interface UserService {
    void add(User user);

    List<User> listUsers();

    User getUserId(long id);

    void delete(long id);

    void update(User user);

}
