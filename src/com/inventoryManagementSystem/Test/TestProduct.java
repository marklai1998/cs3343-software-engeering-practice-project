package com.inventoryManagementSystem.Test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.inventoryManagementSystem.CSVHelper;
import com.inventoryManagementSystem.Product;

public class TestProduct {
	@Test
	public void testGetCost_01() {

		Product product = new Product(0, "test", "test", 100, 50, 10);

		double result = product.getCost();

		assertEquals(50, result, 1);
	}

	@Test
	public void testGetPrice_01() {

		Product product = new Product(0, "test", "test", 100, 50, 10);

		double result = product.getPrice();

		assertEquals(100, result, 1);
	}

	@Test
	public void testGetId_01() {

		Product product = new Product(0, "test", "test", 100, 50, 10);

		int result = product.getId();

		assertEquals(0, result);
	}

	@Test
	public void testGetStock_01() {

		Product product = new Product(0, "test", "test", 100, 50, 10);

		int result = product.getStock();

		assertEquals(10, result);
	}

	@Test
	public void testGetName_01() {

		Product product = new Product(0, "test", "test", 100, 50, 10);

		String result = product.getName();

		assertEquals("test", result);
	}

	@Test
	public void testGetDesription_01() {

		Product product = new Product(0, "test", "test", 100, 50, 10);

		String result = product.getDescription();

		assertEquals("test", result);
	}

	@Test
	public void testChangeDataSet_01() {

		CSVHelper newDataSet = new CSVHelper("/com/inventoryManagementSystem/Data/testProduct.csv");
		Product.changeDataSet(newDataSet);

		int result = Product.getAllProducts().length;

		assertEquals(3, result);
	}

	@Test
	public void testAddProduct_01() {

		CSVHelper newDataSet = new CSVHelper("/com/inventoryManagementSystem/Data/testProduct.csv");
		Product.changeDataSet(newDataSet);

		Product product = new Product(3, "test3", "test3", 100, 50, 10);

		Product.addProduct(product);

		int result = Product.getAllProducts().length;

		assertEquals(4, result);
	}

	@Test
	public void testRemoveProduct_01() {

		CSVHelper newDataSet = new CSVHelper("/com/inventoryManagementSystem/Data/testProduct.csv");
		Product.changeDataSet(newDataSet);

		Product.removeProduct(3);

		int result = Product.getAllProducts().length;

		assertEquals(3, result);
	}

	@Test
	public void testGetProduct_01() {

		CSVHelper newDataSet = new CSVHelper("/com/inventoryManagementSystem/Data/testProduct.csv");
		Product.changeDataSet(newDataSet);
		String result = 
				Product.getProduct(0).getName();

		assertEquals("test", result);
	}
	

	@Test
	public void testGetProduct_02() {

		CSVHelper newDataSet = new CSVHelper("/com/inventoryManagementSystem/Data/testProduct.csv");
		Product.changeDataSet(newDataSet);
		Product result = 
				Product.getProduct(-1);

		assertEquals(null, result);
	}

	@Test
	public void testGetProduct_03() {

		CSVHelper newDataSet = new CSVHelper("/com/inventoryManagementSystem/Data/testProduct.csv");
		Product.changeDataSet(newDataSet);
		int result = 
				Product.getProduct("test").getId();

		assertEquals(0, result);
	}
	

	@Test
	public void testGetProduct_04() {
		
		CSVHelper newDataSet = new CSVHelper("/com/inventoryManagementSystem/Data/testProduct.csv");
		Product.changeDataSet(newDataSet);
		Product result = 
				Product.getProduct("test0");

		assertEquals(null, result);
	}
	

	@Test
	public void testUpdateProduct_01() {
		
		CSVHelper newDataSet = new CSVHelper("/com/inventoryManagementSystem/Data/testProduct.csv");
		Product.changeDataSet(newDataSet);

		Product product = new Product(0, "test", "test", 150.0, 50.0, 10);
		
		Product.updateProduct(product);
		double result = 
				Product.getProduct(0).getPrice();

		assertEquals(150, result,1);
	}

	@Test
	public void testUpdateProduct_02() {
		
		CSVHelper newDataSet = new CSVHelper("/com/inventoryManagementSystem/Data/testProduct.csv");
		Product.changeDataSet(newDataSet);

		Product product = new Product(0, "test", "test", 100.0, 50.0, 10);
		
		Product.updateProduct(product);
		double result = 
				Product.getProduct(0).getPrice();

		assertEquals(100, result,1);
	}
}
