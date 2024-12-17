package com.api.calculator.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.calculator.dataresponse.OperationResponse;
import com.api.calculator.service.CalculatorService;

import java.math.BigDecimal;
import java.util.Collections;

@RestController
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    // http GET "http://localhost:3000/sum?a=1&b=2"
    @GetMapping("/sum")
    public OperationResponse add(@RequestParam BigDecimal a, @RequestParam BigDecimal b) {
        BigDecimal result = calculatorService.add(a, b);
        return new OperationResponse(result);
    }

    @GetMapping("/sub")
    public OperationResponse subtract(@RequestParam BigDecimal a, @RequestParam BigDecimal b) {
        BigDecimal result = calculatorService.subtract(a, b);
        return new OperationResponse(result);
    }

    @GetMapping("/mul")
    public ResponseEntity<?> multiply(@RequestParam(value = "a") String aStr, @RequestParam(value = "b") String bStr) {
        try {
            BigDecimal a = new BigDecimal(aStr);
            BigDecimal b = new BigDecimal(bStr);
            BigDecimal result = calculatorService.multiply(a, b);
            return ResponseEntity.ok(new OperationResponse(result));
        } catch (NumberFormatException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Collections.singletonMap("error", "Invalid parameters"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.singletonMap("error", e.getMessage()));
        }
    }

    @GetMapping("/div")
    public ResponseEntity<?> divide(@RequestParam BigDecimal a, @RequestParam BigDecimal b) {
        try {
            BigDecimal result = calculatorService.divide(a, b);
            return ResponseEntity.ok(new OperationResponse(result));
        } catch (ArithmeticException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Collections.singletonMap("error", e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.singletonMap("error", "Unexpected error occurred."));
        }
    }

}
