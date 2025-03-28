package com.diana.taskmanagerForTeams.Service;

import com.diana.taskmanagerForTeams.DTO.ItemDTO;
import com.diana.taskmanagerForTeams.Domain.Item;
import com.diana.taskmanagerForTeams.Domain.User;
import com.diana.taskmanagerForTeams.Mapper.ItemMapper;
import com.diana.taskmanagerForTeams.Repository.ItemRepository;


import java.util.List;
import java.util.stream.Collectors;


public class ItemImpl implements  ItemInterface{


    private final ItemRepository itemRepository;


    public ItemImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public ItemDTO createItem(ItemDTO itemDTO) {
        Item item = ItemMapper.mapToEntity(itemDTO);
        itemRepository.save(item);

        return ItemMapper.mapToDTO(item);
    }

    @Override
    public List<ItemDTO> getAllPlayers() {
        List <Item> items = itemRepository.findAll();
        return items.stream().map(ItemMapper::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public ItemDTO updateItems(ItemDTO itemDTO, Long id) {
        Item item = itemRepository.findById(id).orElseThrow(() -> new RuntimeException("Item not found " + id));
        item.setId(itemDTO.getId());
        item.setTitle(itemDTO.getTitle());
        item.set_purchase(itemDTO.get_purchase());
        item.setUserAssign(itemDTO.getUserAssign());

        Item itemUpdated = itemRepository.save(item);
        return ItemMapper.mapToDTO(itemUpdated);
    }

    @Override
    public void deleteItem(Long id) {
        Item item = itemRepository.findById(id).orElseThrow(() -> new RuntimeException("Item not found " + id));
        itemRepository.delete(item);
    }

    @Override
    public List<Item> findByUser(User user) {
        return itemRepository.findByUser(user);
    }

    @Override
    public long countItemsBoughtByUser(User user) {
       return itemRepository.countItemsBoughtByUser(user);
    }

    @Override
    public List<ItemDTO> findByUserAnd_purchaseTrue(User user) {
        List<Item> items = itemRepository.findByUserAnd_purchaseTrue(user);
        return items.stream()
                .map(ItemMapper::mapToDTO)
                .collect(Collectors.toList());
    }


}
