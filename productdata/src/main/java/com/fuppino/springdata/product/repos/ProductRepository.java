package com.fuppino.springdata.product.repos;

import org.springframework.data.repository.CrudRepository;

import com.fuppino.springdata.product.entity.Product;
import java.lang.String;
import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Integer> {
	List<Product> findByName(String name);
}