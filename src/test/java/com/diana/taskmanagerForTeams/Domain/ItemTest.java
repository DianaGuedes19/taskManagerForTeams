package com.diana.taskmanagerForTeams.Domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class ItemTest {

    @Test
    void shouldCreateValidItem() throws Exception {
        //arrange
        User Diana = mock(User.class);
        //act
        Item item = new Item(1L,"Buy milk", false, Diana);
        // Assert
        assertNotNull(item);
    }

    @Test
    void shouldNotCreateCourseWithNullTitle() throws Exception {
        //arrange
        User Diana = mock(User.class);
        //act
        // Assert
        assertThrows(Exception.class, () -> new Item(1L,null, false, Diana));

    }

    @Test
    void shouldNotCreateCourseWithNullPurchase() throws Exception {
        //arrange
        User Diana = mock(User.class);
        //act
        // Assert
        assertThrows(Exception.class, () -> new Item(1L,"Buy milk", null, Diana));

    }

    @Test
    void shouldNotCreateCourseWithNullUser() throws Exception {
        //arrange
        //act
        // Assert
        assertThrows(Exception.class, () -> new Item(1L,"Buy milk", false, null));

    }

    @Test
    void shouldCallAllGettersAndSetters() {
        // arrange
        User mockUser = mock(User.class);
        Item item = new Item();

        // act
        item.setId(10L);
        item.setTitle("Bananas");
        item.set_purchase(true);
        item.setUserAssign(mockUser);

        // assert
        assertEquals(10L, item.getId());
        assertEquals("Bananas", item.getTitle());
        assertTrue(item.get_purchase());
        assertEquals(mockUser, item.getUserAssign());
    }
}