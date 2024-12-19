package com.unfold.unfoldfit.controller;

import com.unfold.unfoldfit.model.entity.JwtRequest;
import com.unfold.unfoldfit.model.entity.JwtResponse;
import com.unfold.unfoldfit.service.impl.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class JwtController {
    @Autowired
    private JwtService jwtService;

    @PostMapping({"/authenticate"})
    public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws UsernameNotFoundException {
       return jwtService.createJwtToken(jwtRequest);

    }
}
