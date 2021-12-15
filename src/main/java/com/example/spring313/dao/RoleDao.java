package com.example.spring313.dao;

import com.example.spring313.model.Role;

import java.util.List;

public interface RoleDao {

    void addRole(Role role);

    List<Role> getAllRoles();

    Role getRoleByName(String name);
}
