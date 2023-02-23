package com.second.service_second_backend;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class CartControllertest {

    @Mock
    private CartRepository cartRepository;

    @InjectMocks
    private CartController cartController;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddCart() throws Exception {
         Cart cart = new Cart(1L,"Product 1","1.jpg","10","100.0","321321");
        
        when(cartRepository.save(cart)).thenReturn(cart);

        mockMvc.perform(MockMvcRequestBuilders.post("/cart/add")
                .content("{\"id\":1,\"name\":\"Product 1\",\"quantity\":\"10\",\"price\":\"100.0\"}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("{\"name\":\"Product 1\",\"quantity\":\"10\",\"price\":\"100.0\"}"));
    }


    @Test
    public void testDeleteById() throws Exception {
        Long id = 4L;
        mockMvc.perform(MockMvcRequestBuilders.delete("/cart/" + id)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Deleted"));
    }

    @Test
    public void testDeleteAllCart() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/cart/all")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("All Deleted"));
    }

}
