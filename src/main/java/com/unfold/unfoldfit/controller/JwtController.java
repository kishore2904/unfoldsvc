package com.unfold.unfoldfit.controller;

import com.unfold.unfoldfit.model.entity.JwtRequest;
import com.unfold.unfoldfit.model.entity.JwtResponse;
import com.unfold.unfoldfit.service.impl.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class JwtController {
    @Autowired
    private JwtService jwtService;

    @PostMapping(value = "/authenticate")
    public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws UsernameNotFoundException {
        return jwtService.createJwtToken(jwtRequest);
    }
}


