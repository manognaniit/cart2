package com.niit.shoppingcart;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.model.Product;

public class TestCaseProduct {
	@Autowired
	ProductDAO productDAO;
	@Autowired
	Product product;
	AnnotationConfigApplicationContext context;
	@Before
	public void init(){
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcart");
		context.refresh();
	productDAO=(ProductDAO) context.getBean("productDAO");
	product= (Product) context.getBean("product");
	}
	@Test
	public void deleteProductTestCase(){
		product.setId("MOB_001");
		boolean flag =productDAO.delete(product);
		assertEquals("deleteProductTestCase",flag,false);
		
	}
	
	

	

}
