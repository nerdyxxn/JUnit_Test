package com.kh.yseolc.junit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculatorTest {
	@Test
	public void testSum() {
		Calculator c = new Calculator();
		double result = c.sum(123.1212121212121212,  234.3838383838);
		assertEquals(357.5050505050121, result, 0.1);   // (예상기대값, 결과값, 오차허용범위)
	}
}

