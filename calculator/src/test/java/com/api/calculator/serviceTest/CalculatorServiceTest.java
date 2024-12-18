package com.api.calculator.serviceTest;

import com.api.calculator.service.CalculatorService;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorServiceTest {

    private final CalculatorService calculatorService = new CalculatorService();

    @Test
    public void testAddition() {
        BigDecimal a = new BigDecimal("5");
        BigDecimal b = new BigDecimal("3");
        BigDecimal result = calculatorService.add(a, b);

        assertEquals(new BigDecimal("8"), result);
    }

    @Test
    public void testSubtraction() {
        BigDecimal a = new BigDecimal("5");
        BigDecimal b = new BigDecimal("3");
        BigDecimal result = calculatorService.subtract(a, b);

        assertEquals(new BigDecimal("2"), result);
    }
}
