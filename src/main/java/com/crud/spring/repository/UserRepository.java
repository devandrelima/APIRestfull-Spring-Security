package com.crud.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.crud.spring.model.user.User;
import org.springframework.security.core.userdetails.UserDetails;


public interface UserRepository extends  JpaRepository<User, String>{
    UserDetails findByLogin(String login);
}
