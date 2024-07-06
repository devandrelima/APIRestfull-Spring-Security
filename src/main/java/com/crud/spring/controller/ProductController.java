package com.crud.spring.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.spring.model.product.Product;
import com.crud.spring.model.product.RequestProduct;
import com.crud.spring.repository.ProductRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/product")
public class ProductController {
    
    @Autowired
    private ProductRepository repository;

    @GetMapping("/list")
    public ResponseEntity getAllProduts() {
        var allProduts = repository.findAll();                                          // Recupera os dados do banco de dados e guarda na variável
        
        return ResponseEntity.ok(allProduts);                                           // Se tudo Ok, retorna os dados                                                            
    }

    @PostMapping
    public ResponseEntity registerProduct(@RequestBody @Valid RequestProduct data) {    // Recebe e valida o dado do postman
        Product newProduct = new Product(data);                                         // Trata o dado que veio do postman para inserir no banco de dados 
        
        repository.save(newProduct);                                                    // Insere o produto no banco de dados 
        System.out.println(newProduct);         
        return ResponseEntity.ok().build();                                             // Se não colocar nada dentro do 'ok', precisa inserir o 'build' depois
    }
    
    @PutMapping
    @Transactional                                                                      // Permite executar mais de um comando no SQL
    public ResponseEntity updateProduct(@RequestBody @Valid RequestProduct data) {
        Optional<Product> optionalProduct = repository.findById(data.id());
        
        if(optionalProduct.isPresent()){
            Product product = optionalProduct.get();
            product.setName(data.name());                                               // Atualiza o nome no bando de dados
            product.setPrice_in_cents(data.price_in_cents());                           // Atualiza o preço no banco de dados
            return ResponseEntity.ok(product);
        } else {
            throw new EntityNotFoundException();
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteProduct(@PathVariable String id){
        Optional<Product> optionalProduct = repository.findById(id);

        if(optionalProduct.isPresent()){
            Product product = optionalProduct.get();
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else{
            throw new EntityNotFoundException();
        }
    }
    
}
