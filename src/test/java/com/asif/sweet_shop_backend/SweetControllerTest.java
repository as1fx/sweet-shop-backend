package com.asif.sweet_shop_backend;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import tools.jackson.databind.ObjectMapper;

import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
public class SweetControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp(){
        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .build();
    }

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldAddSweet() throws Exception {
        Map<String, Object> sweet = Map.of(
                "name", "Rasgulla",
                "category", "Milk",
                "price", 10.0,
                "quantity", 100
        );

        mockMvc.perform(post("/api/sweets")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(sweet)))
                .andExpect(status().isCreated());
    }

    @Test
    void shouldGetAllSweets() throws Exception {
        mockMvc.perform(get("/api/sweets"))
                .andExpect(status().isOk());
    }

    @Test
    void shouldSearchSweets() throws Exception {
        mockMvc.perform(get("/api/sweets/search")
                        .param("name", "Rasgulla"))
                .andExpect(status().isOk());
    }

    @Test
    void shouldUpdateSweet() throws Exception {
        Map<String, Object> sweet = Map.of(
                "name", "Updated Sweet",
                "category", "Dry",
                "price", 20.0,
                "quantity", 50
        );

        mockMvc.perform(put("/api/sweets/2")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(sweet)))
                .andExpect(status().isOk());
    }

    @Test
    void shouldDeleteSweet() throws Exception {
        mockMvc.perform(delete("/api/sweets/1"))
                .andExpect(status().isNoContent());
    }
}
