package ru.service.RoleService;

import ru.model.Role;

import java.util.List;

public interface RoleService {

    void add(Role role);

    void delete(int id);

    void update(Role role);

    List<Role> listRole();

    Role getRoleById(int id);

    Role getRoleByName(String role);

}
