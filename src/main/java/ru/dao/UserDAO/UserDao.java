package ru.dao.UserDAO;

import ru.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);

    List<User> listUsers();

    void update(User user);

    User getUserId(long id);

    void delete(long id);

    User getUserByName(String name);

}
