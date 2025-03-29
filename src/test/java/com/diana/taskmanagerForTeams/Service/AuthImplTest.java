package com.diana.taskmanagerForTeams.Service;

import com.diana.taskmanagerForTeams.DTO.AuthResponse;
import com.diana.taskmanagerForTeams.DTO.LoginDTO;
import com.diana.taskmanagerForTeams.DTO.UserDTO;
import com.diana.taskmanagerForTeams.Domain.User;
import com.diana.taskmanagerForTeams.Mapper.UserMapper;
import com.diana.taskmanagerForTeams.Repository.UserRepository;
import com.diana.taskmanagerForTeams.Security.JwtUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AuthImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private JwtUtil jwtUtil;

    @InjectMocks
    private AuthImpl authService;

    @Test
    void shouldRegisterUserSuccessfully() {
        // Arrange
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername("Diana");
        userDTO.setEmail("diana@email.com");
        userDTO.setPassword("12345");

        User user = UserMapper.userToDTO(userDTO);

        when(userRepository.findByEmail(userDTO.getEmail())).thenReturn(Optional.empty());
        when(passwordEncoder.encode("12345")).thenReturn("encoded123");
        when(userRepository.save(any(User.class))).thenReturn(user);

        // Act
        UserDTO result = authService.register(userDTO);

        // Assert
        assertNotNull(result);
        assertEquals("Diana", result.getUsername());
        assertEquals("diana@email.com", result.getEmail());
    }

    @Test
    void shouldLoginSuccessfullyAndReturnToken() {
        // Arrange
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setEmail("diana@email.com");
        loginDTO.setPassword("12345");

        User user = new User();
        user.setEmail("diana@email.com");
        user.setPassword("encodedPassword123");

        when(userRepository.findByEmail("diana@email.com")).thenReturn(Optional.of(user));
        when(passwordEncoder.matches("12345", "encodedPassword123")).thenReturn(true);
        when(jwtUtil.generateToken(any(UserDetails.class))).thenReturn("fake-jwt-token");

        // Act
        AuthResponse response = authService.login(loginDTO);

        // Assert
        assertNotNull(response);
        assertEquals("fake-jwt-token", response.getToken());
    }


}