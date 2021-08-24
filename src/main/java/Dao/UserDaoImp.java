package Dao;

import Model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImp implements UserDao {

    public UserDaoImp() {

    }

    @Override
    public List<User> getUser(int count) {
        List<User> users = new ArrayList<>();
        return users;
    }
}
