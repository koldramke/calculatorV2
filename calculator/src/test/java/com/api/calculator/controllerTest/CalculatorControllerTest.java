package com.api.calculator.controllerTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculatorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void AddEndpointTestok() throws Exception {
        mockMvc.perform(get("/sum")
                .param("a", "202")
                .param("b", "312"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value("514"));

    }

    @Test
    public void AddEndpointTestfail() throws Exception {
        mockMvc.perform(get("/sum")
                .param("a", "5")
                .param("b", "6"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value("999"));

    }

    @Test
    public void SubEndpointTestOk() throws Exception {
        mockMvc.perform(get("/sub")
                .param("a", "20")
                .param("b", "5"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value("15"));
    }

    @Test
    public void SubEndpointTestFail() throws Exception {
        mockMvc.perform(get("/sub")
                .param("a", "32")
                .param("b", "32"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value("1"));
    }

    @Test
    public void MulEndpointTestOk() throws Exception {
        mockMvc.perform(get("/mul")
                .param("a", "4")
                .param("b", "6"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value("24"));
    }

    @Test
    public void MulEndpointTestFail() throws Exception {
        mockMvc.perform(get("/mul")
                .param("a", "3")
                .param("b", "7"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value("25"));
    }

    @Test
    public void DivEndpointTestOk() throws Exception {
        mockMvc.perform(get("/div")
                .param("a", "20")
                .param("b", "4"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(5.0));
    }

    @Test
    public void DivEndpointTestFail() throws Exception {
        mockMvc.perform(get("/div")
                .param("a", "15456")
                .param("b", "3"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value("10"));
    }

    @Test
    public void DivByZeroTest() throws Exception {
        mockMvc.perform(get("/div")
                .param("a", "20")
                .param("b", "0"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
        // .andExpect(jsonPath("$.error").value("ERROR: Division by zero is not
        // possible. Try again.."));
    }
}
