package web.service;

import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import java.util.List;

public interface UserService{

    List<User> getAllUser();

    void save(User user);

    User show(int id);

    void deleteUser(int id);

    void update(User user);
}
