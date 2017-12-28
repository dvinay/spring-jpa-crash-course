package com.fuppino.springdata;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fuppino.springdata.product.ProductDataApplication;
import com.fuppino.springdata.product.entity.Product;
import com.fuppino.springdata.product.repos.ProductRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=ProductDataApplication.class)
public class ProductdataApplicationTests {

	@Autowired
	ProductRepository productRepository;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testCreateProduct() {
		Product product = new Product();
		product.setId(1);
		product.setName("IPhone");
		product.setDesc("IPhone X");
		product.setPrice(1000.00);
		productRepository.save(product);
		
	}
	
	@Test
	public void testReadProduct() {
		Product product = productRepository.findOne(1);
		assertEquals("testing findone operation : ", "IPhone", product.getName());
	}
	
	@Test
	public void testUpdateProduct() {
		Product product = productRepository.findOne(1);
		product.setPrice(1200.00);
		productRepository.save(product);
	}
	
	@Test
	public void testDeleteProduct() {
		productRepository.delete(1);
	}
	
	@Test
	public void testFindByNameProduct() {
		List<Product> products = productRepository.findByName("Watch");
		products.stream().forEach(System.out::println);
	}
	
	@Test
	public void testFindByNameAndDescProduct() {
		List<Product> products = productRepository.findByNameAndDesc("Watch","IWatch from Apple");
		products.stream().forEach(System.out::println);
	}
	
	@Test
	public void testFindByPriceGreaterThanProduct() {
		List<Product> products = productRepository.findByPriceGreaterThan(800.00);
		products.stream().forEach(System.out::println);
	}
	
	@Test
	public void testFindByDescContainsProduct() {
		List<Product> products = productRepository.findByDescContains("Apple");
		products.stream().forEach(System.out::println);
	}
	
	@Test
	public void testFindByPriceBetweenProduct() {
		List<Product> products = productRepository.findByPriceBetween(900.00, 1000.00);
		products.stream().forEach(System.out::println);
	}
	
	@Test
	public void testFindByDescLikeProduct() {
		List<Product> products = productRepository.findByDescLike("%Apple%");
		products.stream().forEach(System.out::println);
	}
	
	@Test
	public void testfindByIdInProduct() {
		List<Product> products = productRepository.findByIdIn(Arrays.asList(1,2,3));
		products.stream().forEach(System.out::println);
	}

}
