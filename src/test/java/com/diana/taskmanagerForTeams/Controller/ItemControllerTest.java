package com.diana.taskmanagerForTeams.Controller;

import com.diana.taskmanagerForTeams.DTO.ItemDTO;

import com.diana.taskmanagerForTeams.Domain.Item;
import com.diana.taskmanagerForTeams.Domain.User;
import com.diana.taskmanagerForTeams.Service.ItemImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(ItemController.class)
@AutoConfigureMockMvc(addFilters = false)
class ItemControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemImpl itemService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createItemShouldReturnCreatedItem() throws Exception {
        User user = new User();
        user.setId(1L);
        user.setUsername("DianaGuedes");
        user.setEmail("dianaguedes@gmail.com");
        user.setPassword("diana123");

        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setTitle("Bananas");
        itemDTO.setPurchase(false);
        itemDTO.setUserAssign(user);

        when(itemService.createItem(any(ItemDTO.class))).thenReturn(itemDTO);

        mockMvc.perform(post("/api/createItem")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(itemDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title").value("Bananas"));
    }

    @Test
    void getAllItensShouldReturnList() throws Exception {
        ItemDTO item = new ItemDTO();
        item.setTitle("Bananas");

        when(itemService.getAllItens()).thenReturn(Collections.singletonList(item));

        mockMvc.perform(get("/api/getAllItens"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Bananas"));
    }

    @Test
    void shouldUpdateItem() throws Exception {
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setTitle("Bananas");

        when(itemService.updateItems(any(ItemDTO.class), any(Long.class))).thenReturn(itemDTO);

        mockMvc.perform(put("/api/UpdateItens/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(itemDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Bananas"));
    }

    @Test
    void shouldDeleteItem() throws Exception {
        doNothing().when(itemService).deleteItem(1L);

        mockMvc.perform(delete("/api/deleteItem/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("Item Deleted"));
    }

    @Test
    void countItensBoughtShouldReturnCorrectCount() throws Exception {
        User user = new User();
        user.setId(1L);

        when(itemService.countItemsBoughtByUserAssign(any(User.class))).thenReturn(5L);

        mockMvc.perform(get("/api/countItemBought")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isOk())
                .andExpect(content().string("5"));
    }

    @Test
    void findByUserAssignAndPurchaseTrueShouldReturnList() throws Exception {
        User user = new User();
        user.setId(1L);

        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setTitle("Bananas");
        itemDTO.setPurchase(true);
        itemDTO.setUserAssign(user);

        when(itemService.findByUserAssignAndPurchaseTrue(any(User.class))).thenReturn(List.of(itemDTO));

        mockMvc.perform(get("/api/filterUserByPurchase")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Bananas"))
                .andExpect(jsonPath("$[0].purchase").value(true));
    }

    @Test
    void shouldReturnItemsByUserAssign() throws Exception {
        // Arrange
        User user = new User();
        user.setId(1L);
        user.setUsername("DianaGuedes");
        user.setEmail("dianaguedes@gmail.com");
        user.setPassword("1234");

        Item item = new Item();
        item.setId(1L);
        item.setTitle("Bananas");
        item.setPurchase(true);
        item.setUserAssign(user);

        List<Item> itemList = List.of(item);

        when(itemService.findByUserAssign(any(User.class))).thenReturn(itemList);

        // Act & Assert
        mockMvc.perform(get("/api/findUserAssign")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Bananas"))
                .andExpect(jsonPath("$[0].purchase").value(true));
    }

}