package com.crud.spring.model.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RequestProduct(
                    String id,

                    @NotBlank
                    String name, 
    
                    @NotNull
                    Integer price_in_cents) {} // Cria um "formato" válido para os dados que serão recebidos 
