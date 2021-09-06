package ru.dao.UserDAO;

import org.springframework.stereotype.Repository;
import ru.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void add(User user) {
        String name = null;
        try {
            name = getUserByName(user.getName()).getName();
        } catch (Exception ignore) {

        }
        System.out.println("NAME " + name);
        if (name == null) {
            entityManager.persist(user);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }

    @Override
    public void update(User user) {
        entityManager.merge(user);
    }

    @Override
    public User getUserId(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void delete(long id) {
        entityManager.createQuery("DELETE FROM User u WHERE u.id=:id")
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public User getUserByName(String name) {
        return entityManager.createQuery("FROM User u WHERE u.name=:name", User.class)
                .setParameter("name", name)
                .getSingleResult();
    }
}
