package com.example.spring313.service;

import com.example.spring313.model.Role;
import java.util.List;

public interface RoleService {

    void addRole(Role role);

    List<Role> getAllRoles();

    Role getRoleByName(String name);
}
