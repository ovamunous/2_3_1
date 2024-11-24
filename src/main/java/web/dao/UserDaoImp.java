package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void addUser(User user) {
        em.persist(user);
    }

    @Override
    public void updateUser(User user) {
        em.merge(user);
    }

    @Override
    public void deleteUser(User user) {
        em.remove(em.contains(user) ? user : em.merge(user));
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getUsers() {
        return (List<User>) em.createQuery("from User").getResultList();
    }

    @Override
    public User getUserById(int id) {
        return em.find(User.class, id);
    }
}
