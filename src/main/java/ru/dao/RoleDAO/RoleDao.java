package ru.dao.RoleDAO;

import ru.model.Role;

import java.util.List;

public interface RoleDao {

    void add(Role role);

    List<Role> listRole();

    Role getRoleById(int id);

    Role getRoleByName(String role);
}
