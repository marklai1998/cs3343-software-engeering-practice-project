package com.inventoryManagementSystem.Test;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;

import com.inventoryManagementSystem.CSVHelper;
import com.inventoryManagementSystem.PriceChange;
import com.inventoryManagementSystem.Product;

public class TestPriceChange {
	@Test
	public void testGetId_01() {

		GregorianCalendar gcalendar = new GregorianCalendar();

		gcalendar.set(2019, 10, 10);

		Date startDate = gcalendar.getTime();

		gcalendar.set(2019, 11, 10);
		Date endDate = gcalendar.getTime();

		PriceChange priceChange = new PriceChange(0, 0, 0.7, startDate, endDate);

		int result = priceChange.getId();

		assertEquals(0, result);
	}

	@Test
	public void testGetProductId_01() {

		GregorianCalendar gcalendar = new GregorianCalendar();

		gcalendar.set(2019, 10, 10);

		Date startDate = gcalendar.getTime();

		gcalendar.set(2019, 11, 10);
		Date endDate = gcalendar.getTime();

		PriceChange priceChange = new PriceChange(0, 0, 0.7, startDate, endDate);

		int result = priceChange.getProductId();

		assertEquals(0, result);
	}

	@Test
	public void testGetStartDate_01() {

		GregorianCalendar gcalendar = new GregorianCalendar();

		gcalendar.set(2019, 10, 10);

		Date startDate = gcalendar.getTime();

		gcalendar.set(2019, 11, 10);
		Date endDate = gcalendar.getTime();

		PriceChange priceChange = new PriceChange(0, 0, 0.7, startDate, endDate);

		Date result = priceChange.getStartDate();

		assertEquals(startDate, result);
	}

	@Test
	public void testGetEndDate_01() {

		GregorianCalendar gcalendar = new GregorianCalendar();

		gcalendar.set(2019, 10, 10);

		Date startDate = gcalendar.getTime();

		gcalendar.set(2019, 11, 10);
		Date endDate = gcalendar.getTime();

		PriceChange priceChange = new PriceChange(0, 0, 0.7, startDate, endDate);

		Date result = priceChange.getEndDate();

		assertEquals(endDate, result);
	}

	@Test
	public void testGetChangeRate_01() {

		GregorianCalendar gcalendar = new GregorianCalendar();

		gcalendar.set(2019, 10, 10);

		Date startDate = gcalendar.getTime();

		gcalendar.set(2019, 11, 10);
		Date endDate = gcalendar.getTime();

		PriceChange priceChange = new PriceChange(0, 0, 0.7, startDate, endDate);

		double result = priceChange.getChangeRate();

		assertEquals(0.7, result, 1);
	}

	@Test
	public void testChangeDataSet_01() throws ParseException {

		CSVHelper newDataSet = new CSVHelper("/com/inventoryManagementSystem/Data/testPriceChange.csv");
		PriceChange.changeDataSet(newDataSet);

		PriceChange[] result = PriceChange.getAllPriceChange();

		

		assertEquals(2, result.length);
	}

	@Test
	public void testGetPriceChange_01() throws ParseException {

		CSVHelper newDataSet = new CSVHelper("/com/inventoryManagementSystem/Data/testPriceChange.csv");
		PriceChange.changeDataSet(newDataSet);
		PriceChange result = PriceChange.getPriceChange(0);

		PriceChange expectedResult = new PriceChange(0, 0, 0.9, new SimpleDateFormat("dd/MM/yyyy").parse("10/11/2019"),
				new SimpleDateFormat("dd/MM/yyyy").parse("20/11/2019"));

		assertEquals(result.getId(), expectedResult.getId());

	}

	@Test
	public void testGetPriceChange_02() {

		Product product = new Product(0, "test", "test", 0, 0, 0);

		PriceChange[] result = PriceChange.getPriceChange(product);

		assertEquals(0, result.length);

	}

	@Test
	public void testGetPriceChange_03() throws ParseException {

		CSVHelper newDataSet = new CSVHelper("/com/inventoryManagementSystem/Data/testPriceChange.csv");
		PriceChange.changeDataSet(newDataSet);

		Product product = new Product(0, "test", "test", 0, 0, 0);

		PriceChange priceChange = new PriceChange(0, 0, 0.8, new SimpleDateFormat("dd/MM/yyyy").parse("10/11/2019"),
				new SimpleDateFormat("dd/MM/yyyy").parse("20/11/2020"));
		
		PriceChange.updatePriceChange(priceChange);
		PriceChange[] result = PriceChange.getPriceChange(product);

		assertEquals(1, result.length);

	}

	

	
	@Test
	public void testAddPriceChange_01() throws ParseException {

		CSVHelper newDataSet = new CSVHelper("/com/inventoryManagementSystem/Data/testCreatePriceChange.csv");
		PriceChange.changeDataSet(newDataSet);

		PriceChange priceChange = new PriceChange(2, 2, 0.5, new SimpleDateFormat("dd/MM/yyyy").parse("10/11/2019"),
				new SimpleDateFormat("dd/MM/yyyy").parse("20/11/2020"));
		
		PriceChange.addPriceChange(priceChange);
		PriceChange[] result = PriceChange.getAllPriceChange();

		assertEquals(0, result.length);

	}
	@Test
	public void testRemovePriceChange_01() {

		CSVHelper newDataSet = new CSVHelper("/com/inventoryManagementSystem/Data/testPriceChange.csv");
		PriceChange.changeDataSet(newDataSet);

		PriceChange.removePriceChange(2);

		PriceChange[] result = PriceChange.getAllPriceChange();

		assertEquals(2, result.length);

	}

	@Test
	public void testUpdatePriceChange_01() throws ParseException {

		CSVHelper newDataSet = new CSVHelper("/com/inventoryManagementSystem/Data/testPriceChange.csv");
		PriceChange.changeDataSet(newDataSet);

		PriceChange priceChange = new PriceChange(0, 0, 0.7, new SimpleDateFormat("dd/MM/yyyy").parse("10/11/2019"),
				new SimpleDateFormat("dd/MM/yyyy").parse("20/11/2019"));
		
		PriceChange.updatePriceChange(priceChange);

		PriceChange[] result = PriceChange.getAllPriceChange();

		assertEquals(0.7, result[0].getChangeRate(),1);

	}
}
