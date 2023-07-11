package com.favorites.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.favorites.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
