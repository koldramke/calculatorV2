package com.api.calculator.controllerTest;

import com.api.calculator.controller.CalculatorController;
import com.api.calculator.dataresponse.OperationResponse;
import com.api.calculator.service.CalculatorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculatorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testAdditionEndpoint() throws Exception {
        mockMvc.perform(get("/sum")
                .param("a", "2")
                .param("b", "3"))
                .andExpect(jsonPath("$.result").value("5"));
    }
}
