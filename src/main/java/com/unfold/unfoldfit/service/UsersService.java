package com.unfold.unfoldfit.service;


import com.unfold.unfoldfit.model.entity.Users;

public interface UsersService {

    Users requestNewUser(Users users);

    void initRolesAndUser();
}
