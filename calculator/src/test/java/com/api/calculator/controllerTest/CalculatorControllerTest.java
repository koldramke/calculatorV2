package com.api.calculator.controllerTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest // Configura o teste somente para o controller
public class CalculatorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testAdditionEndpoint() throws Exception {
        mockMvc.perform(get("/api/v1/add")
                .param("a", "5")
                .param("b", "3"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value("8"));
    }
}
