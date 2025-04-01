package com.diana.taskmanagerForTeams.Service;

import com.diana.taskmanagerForTeams.DTO.ItemDTO;
import com.diana.taskmanagerForTeams.Domain.Item;
import com.diana.taskmanagerForTeams.Domain.User;

import java.util.List;

public interface ItemInterface {
    ItemDTO createItem (ItemDTO itemDTO);
    List<ItemDTO> getAllItens ();
    ItemDTO updateItems (ItemDTO itemDTO, Long id);
    void deleteItem (Long id);
    List<Item> findByUserAssign (User user);
    long countItemsBoughtByUserAssign (User user);
    List<ItemDTO> findByUserAssignAndPurchaseTrue(User user);
}
