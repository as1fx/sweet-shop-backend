package com.example.sweetshop.inventory;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class InventoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldPurchaseSweet() throws Exception {
        mockMvc.perform(post("/api/sweets/1/purchase"))
                .andExpect(status().isOk());
    }

    @Test
    void shouldRestockSweet() throws Exception {
        mockMvc.perform(post("/api/sweets/1/restock"))
                .andExpect(status().isOk());
    }
}
