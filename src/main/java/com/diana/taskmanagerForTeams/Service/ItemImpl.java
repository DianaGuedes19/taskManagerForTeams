package com.diana.taskmanagerForTeams.Service;

import com.diana.taskmanagerForTeams.DTO.ItemDTO;
import com.diana.taskmanagerForTeams.Domain.Item;
import com.diana.taskmanagerForTeams.Domain.User;
import com.diana.taskmanagerForTeams.Mapper.ItemMapper;
import com.diana.taskmanagerForTeams.Repository.ItemRepository;
import com.diana.taskmanagerForTeams.Repository.UserRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemImpl implements  ItemInterface{


    private final ItemRepository itemRepository;
    private UserRepository userRepository;


    public ItemImpl(ItemRepository itemRepository, UserRepository userRepository) {
        this.itemRepository = itemRepository;
        this.userRepository = userRepository;
    }

    @Override
    public ItemDTO createItem(ItemDTO itemDTO) {
        Item item = ItemMapper.mapToEntity(itemDTO);

        User user = userRepository.findById(itemDTO.getUserAssign().getId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        item.setUserAssign(user);
        itemRepository.save(item);

        return ItemMapper.mapToDTO(item);
    }

    @Override
    public List<ItemDTO> getAllItens() {
        List <Item> items = itemRepository.findAll();
        return items.stream().map(ItemMapper::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public ItemDTO updateItems(ItemDTO itemDTO, Long id) {
        Item item = itemRepository.findById(id).orElseThrow(() -> new RuntimeException("Item not found " + id));
        item.setTitle(itemDTO.getTitle());
        item.setPurchase(itemDTO.getPurchase());
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
    public List<Item> findByUserAssign(User user) {
        return itemRepository.findByUserAssign(user);
    }

    @Override
    public long countItemsBoughtByUserAssign(User user) {
       return itemRepository.countItemsBoughtByUserAssign(user);
    }

    @Override
    public List<ItemDTO> findByUserAssignAndPurchaseTrue(User user) {
        List<Item> items = itemRepository.findByUserAssignAndPurchaseTrue(user);
        return items.stream()
                .map(ItemMapper::mapToDTO)
                .collect(Collectors.toList());
    }


}
