package com.crud.spring.service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.crud.spring.model.user.User;

@Service
public class TokenService {
    @Value("${api.security.token.secret}")
    private String secret;                                      // Puxa da(s) variável(is) de ambiente da máquina que está o programa

    public String generateToken(User user){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);    // Forma única de criar token de nossa aplicação, extremamente sigiloso
            
            String token = JWT.create()
                .withIssuer("andre-api")                 // Informa quem cria o token
                .withSubject(user.getLogin())                   // Informa o usuário que está recebendo o token
                .withExpiresAt(genExperirationDate())           // Tempo de expiração do token
                .sign(algorithm);
            
            return token;
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Error while generating token ", exception);
        }
    }

    public String validateToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            
            return JWT.require(algorithm)
                .withIssuer("andre-api")
                .build()
                .verify(token)
                .getSubject();

        } catch (JWTVerificationException exception) {
            return "";
        }
    }

    private Instant genExperirationDate(){                       // Cria o tempo de expiração baseado no fuso horário do Brasil
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}