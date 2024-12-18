package com.unfold.unfoldfit.controller;

import com.unfold.unfoldfit.model.entity.Users;
import com.unfold.unfoldfit.service.UsersService;
import com.unfold.unfoldfit.utils.Constants;
import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class UserController {

    private final UsersService usersService;

    public UserController(UsersService usersService) {
        this.usersService = usersService;
    }

//    @PostConstruct
//    public void initRolesAndUser(){
//        usersService.initRolesAndUser();
//    }
    @PostMapping(Constants.REGISTER_NEW_USER)
    public Users registerNewUser(@RequestBody Users users){
        return usersService.requestNewUser(users);
    }

    @GetMapping("/forAdmin")
    @PreAuthorize("hasRole('Admin')")
    public String forAdmin(){
        return "For admin";
    }

    @GetMapping("/forUser")
    @PreAuthorize("hasRole('User')")
    public String forUser(){
        return "For User";
    }
}
