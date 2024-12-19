package com.unfold.unfoldfit.service.impl;

import com.unfold.unfoldfit.exception.InvalidInputException;
import com.unfold.unfoldfit.model.entity.Role;
import com.unfold.unfoldfit.model.entity.Users;
import com.unfold.unfoldfit.repository.RoleRepository;
import com.unfold.unfoldfit.repository.UsersRepository;
import com.unfold.unfoldfit.service.UsersService;
import com.unfold.unfoldfit.utils.ErrorMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Slf4j
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Users requestNewUser(Users users) {
        if (usersRepository.findByUserName(users.getUserName()) != null) {
            throw new InvalidInputException(ErrorMessage.USER_NAME_ALREADY_EXIST);
        }
        Role role = roleRepository.findById("Admin").get();
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);
        users.setRoles(roleSet);
        users.setPassword(getEncodedPassword(users.getPassword()));
        return usersRepository.save(users);
    }

    public void initRolesAndUser(){
        Role adminRole = new Role();
        adminRole.setRole("Admin");
        adminRole.setRoleDescription("Admin role");

        Role userRole = new Role();
        userRole.setRole("User");
        userRole.setRoleDescription("User role");

        Users adminUser = new Users();
        adminUser.setUserName("admin");
        adminUser.setPassword(getEncodedPassword("password"));
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRoles(adminRoles);
        usersRepository.save(adminUser);
    }
    public String getEncodedPassword(String password){
        return passwordEncoder.encode(password);
    }
}
