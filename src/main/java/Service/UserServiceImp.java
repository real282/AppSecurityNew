package Service;

import Dao.UserDao;
import Dao.UserDaoImp;
import Model.User;

import java.util.List;

public class UserServiceImp implements UserService {
    UserDao dao = new UserDaoImp();

    @Override
    public List<User> getUser(int count) {
        return dao.getUser(count);
    }
}
