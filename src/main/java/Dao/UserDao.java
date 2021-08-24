package Dao;

import Model.User;

import java.util.List;

public interface UserDao {
    List<User> getUser(int count);
}
