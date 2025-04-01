package com.diana.taskmanagerForTeams.Controller;

import com.diana.taskmanagerForTeams.DTO.UserDTO;
import com.diana.taskmanagerForTeams.Domain.Enum.Role;
import com.diana.taskmanagerForTeams.Domain.User;
import com.diana.taskmanagerForTeams.Service.UserImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
@AutoConfigureMockMvc(addFilters = false)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserImpl userService;

    @Test
    void shouldReturnAllUsers() throws Exception {
        UserDTO user = new UserDTO();
        user.setUsername("DianaGuedes");

        when(userService.findAllUsers()).thenReturn(List.of(user));

        mockMvc.perform(get("/user/getAllUsers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].username").value("DianaGuedes"));
    }

    @Test
    void shouldReturnUserByEmail() throws Exception {
        User user = new User(1L, "DianaGuedes", "diana@gmail.com", "1234", Role.ADMIN);
        when(userService.findByEmail("diana@gmail.com")).thenReturn(Optional.of(user));

        mockMvc.perform(get("/user/findByEmail")
                        .param("email", "diana@gmail.com"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value("diana@gmail.com"));
    }

    @Test
    void shouldReturnUserByUsername() throws Exception {
        User user = new User(1L, "DianaGuedes", "diana@gmail.com", "1234", Role.ADMIN);
        when(userService.findUserByUsername("DianaGuedes")).thenReturn(Optional.of(user));

        mockMvc.perform(get("/user/findByUsername")
                        .param("username", "DianaGuedes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value("DianaGuedes"));
    }

    @Test
    void shouldUpdateUser() throws Exception {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername("DianaGuedes");
        userDTO.setEmail("diana@gmail.com");
        userDTO.setPassword("12345");
        userDTO.setRole(Role.ADMIN);

        when(userService.updateUser(any(UserDTO.class), eq(1L))).thenReturn(userDTO);

        String json = new ObjectMapper().writeValueAsString(userDTO);

        mockMvc.perform(put("/user/update/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value("DianaGuedes"));
    }

}