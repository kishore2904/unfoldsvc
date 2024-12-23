package com.unfold.unfoldfit.service.impl;

import com.unfold.unfoldfit.exception.NotFoundException;
import com.unfold.unfoldfit.model.entity.JwtRequest;
import com.unfold.unfoldfit.model.entity.JwtResponse;
import com.unfold.unfoldfit.model.entity.Users;
import com.unfold.unfoldfit.repository.UsersRepository;
import com.unfold.unfoldfit.utils.ErrorMessage;
import com.unfold.unfoldfit.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class JwtService implements UserDetailsService {

    private final UsersRepository usersRepository;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    // Constructor-based dependency injection
    @Autowired
    public JwtService(UsersRepository usersRepository,
                      JwtUtil jwtUtil,
                      @Lazy AuthenticationManager authenticationManager) {
        this.usersRepository = usersRepository;
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
    }

    public JwtResponse createJwtToken(JwtRequest jwtRequest) throws UsernameNotFoundException {
        String userName = jwtRequest.getUserName();
        String userPassword = jwtRequest.getUserPassword();
        authenticate(userName, userPassword);  // Authenticate the user
        final UserDetails userDetails = loadUserByUsername(userName);  // Load user details

        // Generate JWT token
        String newGeneratedToken = jwtUtil.generateToken(userDetails);

        // Get the user from the repository and return a response with the token
        Users users = usersRepository.findByEmailAddress(userName);
        if (users ==null){
            throw new NotFoundException(ErrorMessage.DATA_NOT_FOUND);
        }else {
            return new JwtResponse(users, newGeneratedToken);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Users users = usersRepository.findByEmailAddress(username);
        if(users==null){
            throw new NotFoundException(ErrorMessage.DATA_NOT_FOUND);
        }else {
            return new User(users.getUserName(), users.getPassword(), getAuthorities(users));
        }
    }

    private Set<SimpleGrantedAuthority> getAuthorities(Users users) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        users.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRole()));
        });
        return authorities;
    }

    private void authenticate(String userName, String userPassword) throws UsernameNotFoundException {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, userPassword));
        } catch (DisabledException e) {
            throw new UsernameNotFoundException("User is disabled", e);
        } catch (BadCredentialsException e) {
            throw new UsernameNotFoundException("Bad Credentials", e);
        }
    }
}
