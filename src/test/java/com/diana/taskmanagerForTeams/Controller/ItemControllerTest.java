package com.diana.taskmanagerForTeams.Controller;

import com.diana.taskmanagerForTeams.DTO.ItemDTO;

import com.diana.taskmanagerForTeams.Domain.User;
import com.diana.taskmanagerForTeams.Service.ItemImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;



@WebMvcTest(ItemController.class)
class ItemControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemImpl itemService;

    @Test
    void createItemShouldReturnCreatedItem() throws Exception {
        User user = new User();
        user.setId(1L); // o ID deve existir na base de dados
        user.setUsername("DianaGuedes");
        user.setEmail("dianaguedes@gmail.com");
        user.setPassword("diana123");

        //input
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setTitle("Bananas");
        itemDTO.set_purchase(false);
        itemDTO.setUserAssign(user);

        //output
        ItemDTO expectedDTO = new ItemDTO();
        expectedDTO.setTitle("Bananas");
        expectedDTO.set_purchase(false);
        expectedDTO.setUserAssign(user);

        when(itemService.createItem(any(ItemDTO.class))).thenReturn(expectedDTO);


        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(itemDTO);

        mockMvc.perform(post("/api/createItem")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title").value("Bananas"));
    }

}