package com.crud.spring.model.product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="product")                              // Conecta com essa tabela que está lá no BD.
@Entity(name="product")                             // Marca uma entidade (Representa uma tabela do BD).
@EqualsAndHashCode(of="id")
@Getter                                             // Cria todos os getters.
@Setter                                             // Cria todos os setters.
@AllArgsConstructor                                 // Cria construtor que recebe todos os parâmetros.
@NoArgsConstructor                                  // Cria construtor que não recebe nenhum parâmetro.
public class Product {
    @Id
    @GeneratedValue(strategy=GenerationType.UUID)   // Gera o Id de forma aleatória, automaticamente.
    private String id;
    private String name;
    private Integer price_in_cents;

    public Product(RequestProduct requestProduct){  // Esse construtor trata o objeto vindo do Postman para ser inserido no banco de dados
        this.name = requestProduct.name();
        this.price_in_cents = requestProduct.price_in_cents();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Product{");
        sb.append("name=").append(name);
        sb.append(", price_in_cents=").append(price_in_cents);
        sb.append('}');
        return sb.toString();
    }
}
