package com.fuppino.springdata.product.repos;

import org.springframework.data.repository.CrudRepository;

import com.fuppino.springdata.product.entity.Product;
import java.lang.String;
import java.util.List;
import java.lang.Double;

public interface ProductRepository extends CrudRepository<Product, Integer> {
	List<Product> findByName(String name);

	List<Product> findByNameAndDesc(String name, String desc);

	List<Product> findByPriceGreaterThan(Double price);

	List<Product> findByDescContains(String desc);
	
	List<Product> findByPriceBetween(Double lowPrice, Double maxPrice);
	
	List<Product> findByDescLike(String desc);
	
	List<Product> findByIdIn(List<Integer> id);
}