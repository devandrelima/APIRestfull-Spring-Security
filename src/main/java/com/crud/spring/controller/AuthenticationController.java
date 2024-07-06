package com.crud.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.spring.model.user.AuthenticationDto;
import com.crud.spring.model.user.LoginResponseDto;
import com.crud.spring.model.user.RegisterDto;
import com.crud.spring.model.user.User;
import com.crud.spring.repository.UserRepository;
import com.crud.spring.service.TokenService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository repository;

    @Autowired
    private TokenService tokenService;

    // Loga um usuário existente
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDto data){    // Permite que o Spring Security compare o login e senha informados com o que está no banco de dados
        var userNamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = this.authenticationManager.authenticate(userNamePassword);
        
        var token = tokenService.generateToken((User) auth.getPrincipal());     // Gera o token

        return ResponseEntity.ok(new LoginResponseDto(token));                  // Faz com que o usuário receba o token
    }

    // Registra novos usuários
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDto data){
        if(this.repository.findByLogin(data.login()) != null) return ResponseEntity.badRequest().build();
        
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password()); // Criptografa a senha
        User newUser = new User(data.login(), encryptedPassword, data.role());

        this.repository.save(newUser);

        return ResponseEntity.ok().build();
    }

}
