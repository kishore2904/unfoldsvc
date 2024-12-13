package com.unfold.unfoldfit.controller;

import com.unfold.unfoldfit.model.entity.Role;
import com.unfold.unfoldfit.service.RoleService;
import com.unfold.unfoldfit.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping(Constants.CREATE_ROLE)
    public Role createRole(@RequestBody Role role){
        return roleService.createRole(role);
    }
}
