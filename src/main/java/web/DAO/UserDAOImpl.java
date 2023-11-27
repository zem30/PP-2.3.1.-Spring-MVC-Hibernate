package web.DAO;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class UserDAOImpl implements UserDao {

    @PersistenceContext
    private static EntityManager entityManager;

    @Override
    @Transactional
    public List<User> getAllUser() {
        return entityManager.createQuery("SELECT user from User user", User.class).getResultList();
    }

    @Override
    @Transactional
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    @Transactional
    public User getUser(int id) {
        return entityManager.find(User.class,id);
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        entityManager.remove(id);
    }
}
