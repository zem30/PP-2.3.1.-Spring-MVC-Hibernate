package web.DAO;

import web.model.User;

import java.util.List;

public interface UserDao {


    List<User> getAllUser();

    void save(User user);


    User show(int id);

    void update(User user);

    void deleteUser(int id);
}
