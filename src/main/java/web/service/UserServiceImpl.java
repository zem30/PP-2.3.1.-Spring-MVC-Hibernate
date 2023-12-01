package web.service;

import org.springframework.stereotype.Service;
import web.DAO.UserDao;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public User show(int id) {
        return userDao.show(id);
    }

    @Override
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }
}
