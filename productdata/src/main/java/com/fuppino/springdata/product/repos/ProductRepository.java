package com.fuppino.springdata.product.repos;

import org.springframework.data.repository.CrudRepository;

import com.fuppino.springdata.product.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}