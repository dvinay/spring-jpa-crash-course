package com.fuppino.springdata;

import static org.junit.Assert.assertEquals;

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

}
