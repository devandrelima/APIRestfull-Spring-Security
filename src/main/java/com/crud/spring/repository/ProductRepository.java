package com.crud.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.spring.model.product.Product;

// Os tipos do JpaRepository são respectivamente o tipo da entidade e o tipo de sua primary key
public interface ProductRepository extends JpaRepository<Product, String>{} 