package com.diana.taskmanagerForTeams.Controller;

import com.diana.taskmanagerForTeams.DTO.ItemDTO;
import com.diana.taskmanagerForTeams.Domain.Item;
import com.diana.taskmanagerForTeams.Domain.User;
import com.diana.taskmanagerForTeams.Service.ItemImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ItemController {

    private ItemImpl itemService;

    @Autowired
    public ItemController(ItemImpl itemService) {
        this.itemService = itemService;
    }

    @PostMapping("/createItem")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ItemDTO> createItem (@RequestBody ItemDTO itemDTO){
        return new ResponseEntity<>(itemService.createItem(itemDTO), HttpStatus.CREATED);
    }

    @GetMapping("/getAllItens")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<ItemDTO>> getAllItens (){
        return new ResponseEntity<>(itemService.getAllItens(), HttpStatus.OK);
    }

    @PutMapping("/UpdateItens/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ItemDTO> updateItens (@RequestBody ItemDTO itemDTO, @PathVariable Long id){
        return new ResponseEntity<>(itemService.updateItems(itemDTO,id),HttpStatus.OK);
    }

    @DeleteMapping("/deleteItem/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteItem ( @PathVariable Long id){
       itemService.deleteItem(id);
        return new ResponseEntity<>("Item Deleted", HttpStatus.OK);
    }

    @GetMapping("/findUserAssign")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Item>> findUserAssign (@RequestBody User user){
        return new ResponseEntity<>(itemService.findByUserAssign(user),HttpStatus.OK);
    }

    @GetMapping("/countItemBought")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Long> countItensBought (@RequestBody User user){
        Long count = itemService.countItemsBoughtByUserAssign(user);
        return new ResponseEntity<>(count,HttpStatus.OK);
    }

    @GetMapping("/filterUserByPurchase")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<ItemDTO>> findByUserAssignAndPurchaseTrue (@RequestBody User user){
        return new ResponseEntity<>(itemService.findByUserAssignAndPurchaseTrue(user),HttpStatus.OK);
    }


}
