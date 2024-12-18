package com.api.calculator.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.calculator.dataresponse.OperationResponse;
import com.api.calculator.service.CalculatorService;

import java.math.BigDecimal;
import java.util.Map;

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
    public OperationResponse multiply(@RequestParam BigDecimal a, @RequestParam BigDecimal b) {
        BigDecimal result = calculatorService.multiply(a, b);
        return new OperationResponse(result);
    }

    @GetMapping("/div")
    public ResponseEntity<?> divide(@RequestParam BigDecimal a, @RequestParam BigDecimal b) {
        if (b.compareTo(BigDecimal.ZERO) == 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", "ERROR: Division by zero is not possible. Try again.."));
        }
        return ResponseEntity.ok(Map.of("result", a.divide(b)));
    }

}
