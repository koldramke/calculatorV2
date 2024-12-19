package com.api.calculator.serviceTest;

import com.api.calculator.service.CalculatorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorServiceTest {

    private CalculatorService calculatorService;

    @BeforeEach
    public void setUp() {
        calculatorService = new CalculatorService();
    }

    @Test
    public void addTest() {
        BigDecimal result = calculatorService.add(new BigDecimal(987654321), new BigDecimal(123456789));
        assertEquals(new BigDecimal(1111111110), result);
    }

    @Test
    public void subTest() {
        BigDecimal result = calculatorService.subtract(new BigDecimal(987654321), new BigDecimal(123456789));
        assertEquals(new BigDecimal(864197532), result);
    }

    @Test
    public void mulTest() {
        BigDecimal result = calculatorService.multiply(new BigDecimal(123456789), new BigDecimal(987654321));
        assertEquals(new BigDecimal(121932631112635269L), result);
    }

    @Test
    public void divTest00() {
        BigDecimal result = calculatorService.divide(new BigDecimal(987654321), new BigDecimal(123456789));
        assertTrue(result.compareTo(new BigDecimal(8)) == 0);
    }

    @Test
    public void divTest01() {
        BigDecimal result = calculatorService.divide(new BigDecimal(8), new BigDecimal(2));
        assertTrue(result.compareTo(new BigDecimal(4)) == 0);
    }

    /*
     * @Test
     * public void divTest02() {
     * BigDecimal result = calculatorService.divide(new BigDecimal(951), new
     * BigDecimal(753));
     * assertTrue(result.compareTo(new BigDecimal(1)) == 0);
     * }
     */

    @Test
    public void divTest03() {
        BigDecimal result = calculatorService.divide(new BigDecimal(8), new BigDecimal(1));
        assertTrue(result.compareTo(new BigDecimal(8)) == 0);
    }

    @Test
    public void divByZeroTest() {
        assertThrows(ArithmeticException.class, () -> {
            calculatorService.divide(new BigDecimal(987654321), new BigDecimal(0));
        });
    }
}
