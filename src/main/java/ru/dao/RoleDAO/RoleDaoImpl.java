package ru.dao.RoleDAO;

import org.springframework.stereotype.Repository;
import ru.model.Role;
import ru.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(Role role) {
        String nameRole = null;
        try {
            nameRole = getRoleByName(role.getRole()).getRole();
        } catch (Exception ignore) {

        }
        if (nameRole == null) {
            entityManager.persist(role);
        }
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

    @Override
    public Role getRoleByName(String role) {
        return entityManager.createQuery("FROM Role r WHERE r.role=:role", Role.class)
                .setParameter("role", role)
                .getSingleResult();
    }
}
