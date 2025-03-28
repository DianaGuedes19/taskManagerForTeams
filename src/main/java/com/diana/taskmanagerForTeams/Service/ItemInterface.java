package com.diana.taskmanagerForTeams.Service;

import com.diana.taskmanagerForTeams.DTO.ItemDTO;

import java.util.List;

public interface ItemInterface {
    ItemDTO createItem (ItemDTO itemDTO);
    List<ItemDTO> getAllPlayers ();
    ItemDTO updateItems (ItemDTO itemDTO, Long id);
    ItemDTO deleteItem (Long id);

}
