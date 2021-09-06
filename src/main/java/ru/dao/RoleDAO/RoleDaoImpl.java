package ru.dao.RoleDAO;

import org.springframework.stereotype.Repository;
import ru.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(Role role) {
        entityManager.persist(role);
    }

    @Override
    public void delete(int id) {
        entityManager.createQuery("DELETE FROM Role r WHERE r.id=:id")
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public void update(Role role) {
        entityManager.merge(role);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Role> listRole() {
        return entityManager.createQuery("FROM Role", Role.class).getResultList();
    }

    @Override
    public Role getRoleById(int id) {
        return entityManager.find(Role.class, id);
    }
}
