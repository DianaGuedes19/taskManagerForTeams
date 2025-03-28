package com.diana.taskmanagerForTeams.Mapper;

import com.diana.taskmanagerForTeams.DTO.ItemDTO;
import com.diana.taskmanagerForTeams.Domain.Item;

public class ItemMapper {

    public ItemDTO mapToDTO (com.diana.taskmanagerForTeams.Domain.Item item){
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setId(item.getId());
        itemDTO.setTitle(item.getTitle());
        itemDTO.set_purchase(item.get_purchase());
        itemDTO.setUserAssign(item.getUserAssign());
        return itemDTO;
    }

    public Item mapToEntity (ItemDTO taskDTO){
        Item item = new Item();
        item.setId(taskDTO.getId());
        item.setTitle(taskDTO.getTitle());
        item.set_purchase(taskDTO.get_purchase());
        item.setUserAssign(taskDTO.getUserAssign());
        return item;
    }
}
