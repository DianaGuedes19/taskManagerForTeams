package com.diana.taskmanagerForTeams.Service;

import com.diana.taskmanagerForTeams.DTO.ItemDTO;
import com.diana.taskmanagerForTeams.Domain.Enum.Role;
import com.diana.taskmanagerForTeams.Domain.Item;
import com.diana.taskmanagerForTeams.Domain.User;
import com.diana.taskmanagerForTeams.Mapper.ItemMapper;
import com.diana.taskmanagerForTeams.Repository.ItemRepository;
import com.diana.taskmanagerForTeams.Repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ItemImplTest {

    @Mock
    ItemRepository itemRepository = spy(ItemRepository.class);
    UserRepository userRepository = spy(UserRepository.class);

    private ItemImpl itemService;

    @BeforeEach
    void setup() {
        itemService = new ItemImpl(itemRepository,userRepository);
    }

    @Test
    void shouldCreateAndSaveItem() throws Exception {
        // Arrange

        User user = new User();
        user.setId(1L);
        user.setUsername("Diana");
        user.setEmail("diana@gmail.com");
        user.setPassword("1234");
        user.setRole(Role.ADMIN);

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setTitle("Bananas");
        itemDTO.setPurchase(true);
        itemDTO.setUserAssign(user);


        Item itemEntity = ItemMapper.mapToEntity(itemDTO);

        when(itemRepository.save(any(Item.class))).thenReturn(itemEntity);

        // Act
        ItemDTO result = itemService.createItem(itemDTO);

        // Assert
        assertNotNull(result);
        assertEquals("Bananas", result.getTitle());
        assertTrue(result.getPurchase());
    }

    @Test
    void shouldGetAllItems() throws Exception {

        // Arrange
        User user = mock(User.class);
        Item item1 = new Item(1L, "Leite", true, user);
        Item item2 = new Item(2L, "Arroz", false, user);
        List<Item> items = List.of(item1, item2);
        when(itemRepository.findAll()).thenReturn(items);

        // Act
        List<ItemDTO> result = itemService.getAllItens();

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());

    }

    @Test
    void shouldUpdateOneItem() throws Exception {

        // Arrange
        User user = mock(User.class);
        Item item1 = new Item(1L, "Leite", true, user);
        when(itemRepository.findById(1L)).thenReturn(Optional.of(item1));

        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setId(1L);
        itemDTO.setTitle("Banana");
        itemDTO.setPurchase(true);
        itemDTO.setUserAssign(user);

        Item newItem = new Item(1L, "Banana", true, user);
        when(itemRepository.save(item1)).thenReturn(newItem);

        // Act
        ItemDTO result = itemService.updateItems(itemDTO, 1L);

        // Assert
        assertNotNull(newItem);
        assertEquals("Banana", newItem.getTitle());

    }

    @Test
    void shouldDeleteOneItem() throws Exception {

        // Arrange
        User user = mock(User.class);
        Item item1 = new Item(1L, "Leite", true, user);
        when(itemRepository.findById(1L)).thenReturn(Optional.of(item1));


        // Act
       itemService.deleteItem(1L);

        // Assert
        verify(itemRepository, times(1)).delete(item1);
    }

    @Test
    void shouldReturnItensByUser() throws Exception {

        // Arrange
        User user = new User();
        Item item1 = new Item(1L, "Leite", true, user);
        List<Item> items = List.of(item1);
        when(itemRepository.findByUserAssign(user)).thenReturn(items);

        // Act

        List<Item> result = itemService.findByUserAssign(user);

        // Assert
        assertNotNull(result);
        assertEquals(1, result.size());
    }

    @Test
    void shouldReturnTheNumberOfItensByUser() throws Exception {

        // Arrange
        User user = new User();
        Item item1 = new Item(1L, "Leite", true, user);
        Item item2 = new Item(1L, "Banana", true, user);
        List<Item> items = List.of(item1,item2);
        when(itemRepository.countItemsBoughtByUserAssign(user)).thenReturn((long) items.size());

        // Act
        Long result = itemService.countItemsBoughtByUserAssign(user);

        // Assert
        assertNotNull(result);
        assertEquals(2L, result);
    }

    @Test
    void shouldReturnPurchasedItemsByUser() {
        // Arrange
        User user = new User();
        Item item1 = new Item(1L, "Pão", true, user);
        Item item2 = new Item(2L, "Queijo", true, user);

        List<Item> purchasedItems = List.of(item1, item2);

        when(itemRepository.findByUserAssignAndPurchaseTrue(user)).thenReturn(purchasedItems);

        // Act
        List<ItemDTO> result = itemService.findByUserAssignAndPurchaseTrue(user);

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
    }

}