package web.DAO;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUser() {
        String SQL = "select User as us from User";
        return entityManager.createQuery(SQL, User.class).getResultList();
    }


    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public User show(int id) {
        return entityManager.find(User.class,id);
    }

    @Override
    public void update(User user) {
        entityManager.merge(user);
    }


    @Override
    public void deleteUser(int id) {
        entityManager.remove(id);
    }
}
