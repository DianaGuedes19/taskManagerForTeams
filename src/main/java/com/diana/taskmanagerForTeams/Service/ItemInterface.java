package com.diana.taskmanagerForTeams.Service;

import com.diana.taskmanagerForTeams.DTO.ItemDTO;
import com.diana.taskmanagerForTeams.Domain.Item;
import com.diana.taskmanagerForTeams.Domain.User;

import java.util.List;

public interface ItemInterface {
    ItemDTO createItem (ItemDTO itemDTO);
    List<ItemDTO> getAllPlayers ();
    ItemDTO updateItems (ItemDTO itemDTO, Long id);
    void deleteItem (Long id);
    List<Item> findByUser (User user);
    long countItemsBoughtByUser (User user);
    List<ItemDTO> findByUserAnd_purchaseTrue(User user);
}
