package com.fuppino.springdata.product.repos;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.fuppino.springdata.product.entity.Product;

public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> { 
	List<Product> findByName(String name);

	List<Product> findByNameAndDesc(String name, String desc);

	List<Product> findByPriceGreaterThan(Double price);

	List<Product> findByDescContains(String desc);
	
	List<Product> findByPriceBetween(Double lowPrice, Double maxPrice);
	
	List<Product> findByDescLike(String desc);
	
	List<Product> findByIdIn(List<Integer> id);
}