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
    public void addEndpointTestOk() throws Exception {
        int a = 987654321;
        int b = 123456789;
        mockMvc.perform(get("/sum")
                .param("a", String.valueOf(a))
                .param("b", String.valueOf(b)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(1111111110));
    }

    @Test
    public void addEndpointTestFail() throws Exception {
        int a = 1000000000;
        int b = 2000000000;
        mockMvc.perform(get("/sum")
                .param("a", String.valueOf(a))
                .param("b", String.valueOf(b)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(999999999));
    }

    @Test
    public void subEndpointTestOk() throws Exception {
        int a = 987654321;
        int b = 123456789;
        mockMvc.perform(get("/sub")
                .param("a", String.valueOf(a))
                .param("b", String.valueOf(b)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(864197532));
    }

    @Test
    public void subEndpointTestFail() throws Exception {
        int a = 1000000000;
        int b = 1000000000;

        mockMvc.perform(get("/sub")
                .param("a", String.valueOf(a))
                .param("b", String.valueOf(b)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(1));
    }

    @Test
    public void mulEndpointTestOk() throws Exception {
        int a = 12345;
        int b = 6789;

        mockMvc.perform(get("/mul")
                .param("a", String.valueOf(a))
                .param("b", String.valueOf(b)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(83810205));
    }

    @Test
    public void mulEndpointTestFail() throws Exception {
        int a = 123456789;
        int b = 987654321;

        mockMvc.perform(get("/mul")
                .param("a", String.valueOf(a))
                .param("b", String.valueOf(b)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(999999999));
    }

    @Test
    public void divEndpointTestOk00() throws Exception {
        int a = 9;
        int b = 5;

        mockMvc.perform(get("/div")
                .param("a", String.valueOf(a))
                .param("b", String.valueOf(b)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(1.8));
    }

    @Test
    public void divEndpointTestOk01() throws Exception {
        int a = 951;
        int b = 753;

        mockMvc.perform(get("/div")
                .param("a", String.valueOf(a))
                .param("b", String.valueOf(b)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(1.26));
    }

    @Test
    public void divEndpointTestFail() throws Exception {
        int a = 15456;
        int b = 3;

        mockMvc.perform(get("/div")
                .param("a", String.valueOf(a))
                .param("b", String.valueOf(b)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(10));
    }

    @Test
    public void divByZeroTestOk() throws Exception {
        int a = 98765;
        int b = 0;

        mockMvc.perform(get("/div")
                .param("a", String.valueOf(a))
                .param("b", String.valueOf(b)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
        // .andExpect(jsonPath("$.error").value("ERROR: Division by zero is not
        // possible. Try again.."));
    }
}
