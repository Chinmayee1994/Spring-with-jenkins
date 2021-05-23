package com.tcs.application.sevice;

public class CalculatorService {

	public long add(Long a, Long b) {

		if (a == null || b == null) {
			throw new IllegalArgumentException(a+" and "+b+" can't be null");
		}																			
		long sum = a + b;
		return sum;
	}

	public long subtract(Long a, Long b) {
		if (a == null || b == null) {
			throw new IllegalArgumentException(a+" and "+b+" can't be null");
		}
		long sub = a - b;
		return sub;
	}

	public double divide(Long a, Long b) {
		if (a == null || b == null) {
			throw new IllegalArgumentException(a+" and "+b+" can't be null");
		}
		double mul = a * b;
		return mul;
	}

	public double multiply(Long a, Long b) {
		if (a == null || b == null) {
			throw new IllegalArgumentException(a+" and "+b+" can't be null");
		}
		double div = a / b;
		return div;
	}

}