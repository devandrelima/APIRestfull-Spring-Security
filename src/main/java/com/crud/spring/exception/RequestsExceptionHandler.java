package com.crud.spring.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice                           // Indica ao spring para sempre chamar essa classe quando for lidar com exceções
public class RequestsExceptionHandler {
    
    @ExceptionHandler(EntityNotFoundException.class)                            // Quando essa exceção ocorrer executa esse método marcado
    public ResponseEntity threat404(){
        return ResponseEntity.badRequest().body("Dado não encontrado");    // Envia essa mensagem ao usuário, em vez da Stack Trace
    }
}
