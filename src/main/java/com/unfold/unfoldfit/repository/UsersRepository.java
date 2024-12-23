package com.unfold.unfoldfit.repository;

import com.unfold.unfoldfit.model.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository  extends JpaRepository<Users,String> {
    Users findByEmailAddress(String emailAddress);

}
