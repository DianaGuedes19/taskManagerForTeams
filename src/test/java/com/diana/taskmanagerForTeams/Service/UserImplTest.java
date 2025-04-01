package com.diana.taskmanagerForTeams.Service;

import com.diana.taskmanagerForTeams.DTO.UserDTO;
import com.diana.taskmanagerForTeams.Domain.Enum.Role;
import com.diana.taskmanagerForTeams.Domain.User;
import com.diana.taskmanagerForTeams.Mapper.UserMapper;
import com.diana.taskmanagerForTeams.Repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserImplTest {

    @Mock
    UserRepository userRepository = spy(UserRepository.class);

    private UserImpl userService;

    @BeforeEach
    void setup() {
        userService = new UserImpl(userRepository);
    }

    @Test
    void shouldReturnAllUsersAsDTO() {
        // Arrange
        User user1 = new User(1L, "DianaGuedes19", "dianaguedes@gmail.com", "1234", Role.ADMIN);
        User user2 = new User(2L, "MariaCerqueira10", "mariacerqueira@gmail.com", "abcd", Role.MEMBERFREE);
        List<User> users = List.of(user1, user2);

        when(userRepository.findAll()).thenReturn(users);

        // Act
        List<UserDTO> result = userService.findAllUsers();

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("DianaGuedes19", result.get(0).getUsername());
        assertEquals("MariaCerqueira10", result.get(1).getUsername());
    }

    @Test
    void shouldReturnTheUserOfAnEmail() {
        // Arrange
        String email = "dianaguedes@gmail.com";
        User user1 = new User(1L, "DianaGuedes19", "dianaguedes@gmail.com", "1234", Role.ADMIN);
        when(userRepository.findByEmail(email)).thenReturn(Optional.of(user1));

        // Act
        Optional<User> result = userService.findByEmail(email);

        // Assert
        assertEquals(email, result.get().getEmail());
    }

    @Test
    void shouldReturnTheUserOfAnUsername() {
        // Arrange
        String username = "DianaGuedes19";
        User user1 = new User(1L, "DianaGuedes19", "dianaguedes@gmail.com", "1234", Role.ADMIN);
        when(userRepository.findUserByUsername(username)).thenReturn(Optional.of(user1));

        // Act
        Optional<User> result = userService.findUserByUsername(username);

        // Assert
        assertEquals(username, result.get().getUsername());
    }

    @Test
    void shouldUpdateUser() {
        // Arrange
        Long userId = 1L;
        User user1 = new User(1L, "DianaGuedes19", "dianaguedes@gmail.com", "1234", Role.ADMIN);
        when(userRepository.findById(userId)).thenReturn(Optional.of(user1));
        when(userRepository.findById(1L)).thenReturn(Optional.of(user1));

        UserDTO updateDTO = new UserDTO();
        updateDTO.setUsername("DianaGuedes18");
        updateDTO.setEmail("dianaguedes@gmail.com");
        updateDTO.setRole(Role.ADMIN);

        when(userRepository.save(any(User.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // Act
        UserDTO updatedUserDTO = userService.updateUser(updateDTO, userId);

        // Assert
        assertNotNull(updatedUserDTO);
        assertEquals("DianaGuedes18", updatedUserDTO.getUsername());
        assertEquals("dianaguedes@gmail.com", updatedUserDTO.getEmail());
    }



}