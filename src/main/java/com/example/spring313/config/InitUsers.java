package com.example.spring313.config;

import com.example.spring313.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.spring313.model.Role;
import com.example.spring313.model.User;
import com.example.spring313.service.UserService;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Configuration
public class InitUsers {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public InitUsers(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @Bean
    @PostConstruct
    public void addSomeUsers() {
        User admin = new User();
        User user = new User();


        roleService.addRole(new Role("ROLE_ADMIN"));
        roleService.addRole(new Role("ROLE_USER"));

        Set<Role> rolesForAdmin = new HashSet<>();
        rolesForAdmin.add(roleService.getRoleByName("ROLE_ADMIN"));
        rolesForAdmin.add(roleService.getRoleByName("ROLE_USER"));

        Set<Role> rolesForUser = new HashSet<>();
        rolesForUser.add(roleService.getRoleByName("ROLE_USER"));
        admin.setUsername("admin");
        admin.setPassword("admin");
        admin.setEmail("admin@mail.ru");
        admin.setRoles(rolesForAdmin);
        userService.addUser(admin);

        user.setUsername("user");
        user.setPassword("user");
        user.setEmail("user@mail.ru");
        user.setRoles(rolesForUser);
        userService.addUser(user);
    }
}
