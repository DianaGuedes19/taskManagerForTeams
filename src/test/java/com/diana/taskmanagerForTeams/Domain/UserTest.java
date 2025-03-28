package com.diana.taskmanagerForTeams.Domain;

import com.diana.taskmanagerForTeams.Domain.Enum.Role;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @Test
    void shouldCreateValidUser() throws Exception {
        //arrange
        Role role = Role.MEMBERFREE;
        //act
        User user = new User(1L,"DianaGuedes19", "diana123", role);
        // Assert
        assertNotNull(user);
    }

    @Test
    void shouldNotCreateValidUserWithUserNull() throws Exception {
        //arrange
        Role role = Role.MEMBERFREE;
        //act
        // Assert
        assertThrows(Exception.class, () -> new User(1L,null, "diana123", role));
    }

    @Test
    void shouldNotCreateValidUserWithNullPassword() throws Exception {
        //arrange
        Role role = Role.MEMBERFREE;
        //act
        // Assert
        assertThrows(Exception.class, () -> new User(1L,"DianaGuedes19", null, role));
    }

    @Test
    void shouldNotCreateValidUserWithNullRole() throws Exception {
        //arrange
        //act
        // Assert
        assertThrows(Exception.class, () -> new User(1L,"DianaGuedes19", "diana123", null));
    }

    @Test
    void shouldCallAllGettersAndSetters() {
        // arrange
        Role role = Role.MEMBERFREE;
        User user = new User();

        // act
        user.setId(10L);
        user.setUsername("DianaGuedes19");
        user.setPassword("diana123");
        user.setRole(Role.MEMBERFREE);

        // assert
        assertEquals(10L, user.getId());
        assertEquals("DianaGuedes19", user.getUsername());
        assertEquals("diana123", user.getPassword());
        assertEquals(role, user.getRole());
    }
}