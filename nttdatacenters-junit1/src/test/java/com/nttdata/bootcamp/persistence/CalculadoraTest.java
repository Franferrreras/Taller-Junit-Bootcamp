package com.nttdata.bootcamp.persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import com.nttdata.bootcamp.model.Calculadora;

public class CalculadoraTest {

	@Test
	public void testSuma() {
		Calculadora calculadora = new Calculadora();
		Integer sum = calculadora.suma(1, 1);
		
		assertEquals(2, sum);
	}

}
