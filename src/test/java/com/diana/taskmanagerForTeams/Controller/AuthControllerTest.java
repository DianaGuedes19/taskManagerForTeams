package com.diana.taskmanagerForTeams.Controller;

import com.diana.taskmanagerForTeams.DTO.AuthResponse;
import com.diana.taskmanagerForTeams.DTO.ItemDTO;
import com.diana.taskmanagerForTeams.DTO.LoginDTO;
import com.diana.taskmanagerForTeams.DTO.UserDTO;
import com.diana.taskmanagerForTeams.Domain.User;
import com.diana.taskmanagerForTeams.Repository.UserRepository;
import com.diana.taskmanagerForTeams.Security.JwtUtil;
import com.diana.taskmanagerForTeams.Service.AuthImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AuthImpl authService;


    @Test
    void shourRegisterAnUser() throws Exception {
        User user = new User();
        user.setId(1L);
        user.setUsername("DianaGuedes");
        user.setEmail("dianaguedes@gmail.com");
        user.setPassword("diana123");

        UserDTO expectedDTO = new UserDTO();
        expectedDTO.setId(1L);
        expectedDTO.setUsername("DianaGuedes");
        expectedDTO.setEmail("dianaguedes@gmail.com");
        expectedDTO.setPassword("diana123");


        when(authService.register(any(UserDTO.class))).thenReturn(expectedDTO);


        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(expectedDTO);

        mockMvc.perform(post("/auth/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value("DianaGuedes"));
    }


    @Test
    void shouldLoginSuccessfullyAndReturnToken() throws Exception {
        // Arrange
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setEmail("diana@example.com");
        loginDTO.setPassword("diana123");

        AuthResponse response = new AuthResponse("fake-jwt-token");

        when(authService.login(any(LoginDTO.class))).thenReturn(response);

        ObjectMapper objectMapper = new ObjectMapper();
        String loginJson = objectMapper.writeValueAsString(loginDTO);

        // Act + Assert
        mockMvc.perform(post("/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(loginJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.token").value("fake-jwt-token"));
    }


}