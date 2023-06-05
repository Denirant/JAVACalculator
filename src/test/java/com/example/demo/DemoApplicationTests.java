package com.example.demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class DemoApplicationTests {

	@Test
	void sum(){
		Calculator calculator = new Calculator();
		assertEquals(4, calculator.add(2,2));
		assertEquals(10, calculator.add(5,5));
		assertEquals(15, calculator.add(3,12));
		assertEquals(1, calculator.add(12,-11));
	}

	@Test
	void mult(){
		Calculator calculator = new Calculator();
		assertEquals(4, calculator.mult(2,2));
		assertEquals(10, calculator.mult(5,2));
	}

	@Test
	void div(){
		Calculator calculator = new Calculator();
		assertEquals(5, calculator.div(25,5));
		assertEquals(10, calculator.div(100,10));
	}

	@Test
	void sub(){
		Calculator calculator = new Calculator();
		assertEquals(35, calculator.sub(40,5));
		assertEquals(10, calculator.sub(15,5));
	}
}
