package com.diana.taskmanagerForTeams.Mapper;

import com.diana.taskmanagerForTeams.DTO.ItemDTO;
import com.diana.taskmanagerForTeams.Domain.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper {

    public static ItemDTO mapToDTO (com.diana.taskmanagerForTeams.Domain.Item item){
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setId(item.getId());
        itemDTO.setTitle(item.getTitle());
        itemDTO.setPurchase(item.getPurchase());
        itemDTO.setUserAssign(item.getUserAssign());
        return itemDTO;
    }

    public static Item mapToEntity (ItemDTO taskDTO){
        Item item = new Item();
        item.setId(taskDTO.getId());
        item.setTitle(taskDTO.getTitle());
        item.setPurchase(taskDTO.getPurchase());
        item.setUserAssign(taskDTO.getUserAssign());
        return item;
    }
}
