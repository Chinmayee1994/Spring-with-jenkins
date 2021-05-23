package com.tcs.application.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.tcs.application.sevice.CalculatorService;

public class CalculatorServiceTest {

	@Test
	public void testAdd() {
		CalculatorService calculatorService = new CalculatorService();
		long expectResult = 30L;
		long actualValue = calculatorService.add(10L, 20L);
		assertEquals(expectResult, actualValue);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddWithNullValues() {
		CalculatorService calculatorService = new CalculatorService();
		calculatorService.add(null, 20L);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAddWithNullValuesWithWrongResult() {
		CalculatorService calculatorService = new CalculatorService();
		calculatorService.add(null, 20L);
	}
	@Test
	public void testSub() {
		CalculatorService calculatorService = new CalculatorService();
		long expectResult = 10L;
		long actualValue = calculatorService.add(10L, 20L);
		assertEquals(expectResult, actualValue);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testSubWithNullValuesWithWrongResult() {
		CalculatorService calculatorService = new CalculatorService();
		calculatorService.add(null, 20L);
	} 
	@Test(expected =ArithmeticException.class)
	public void testDevideWithNullValuesWithWrongResult() {
		CalculatorService calculatorService = new CalculatorService();
		calculatorService.add(20L, 0L);
	} 
}
