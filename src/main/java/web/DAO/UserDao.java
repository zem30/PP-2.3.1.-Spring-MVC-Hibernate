package web.DAO;

import web.model.User;

import java.util.List;

public interface UserDao {

    //Показывает всех User'ов
    List<User> getAllUser();

    //Добавляет User'а
    void add(User user);

    //Показывает информацию об 1 User'е
    User getUser(int id);

    //Удаляет User'а
    void deleteUser(int id);
}
