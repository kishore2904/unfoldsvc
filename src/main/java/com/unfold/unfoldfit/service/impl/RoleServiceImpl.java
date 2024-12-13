package com.unfold.unfoldfit.service.impl;

import com.unfold.unfoldfit.model.entity.Role;
import com.unfold.unfoldfit.repository.RoleRepository;
import com.unfold.unfoldfit.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;
    @Override
    public Role createRole(Role role) {
        return roleRepository.save(role);
    }
}
