package ru.dao.RoleDAO;

import ru.model.Role;

import java.util.List;

public interface RoleDao {

    void add(Role role);

    void delete (int id);

    void update (Role role);

    List<Role> listRole();

    Role getRoleById(int id);
}
