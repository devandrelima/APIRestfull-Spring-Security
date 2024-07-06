package com.crud.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.crud.spring.repository.UserRepository;

@Service
public class AuthorizationService implements UserDetailsService{

    @Autowired
    UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {   // Faz com que o Spring Security possa consultar os usuários na tabela
        return repository.findByLogin(username);
    }
}