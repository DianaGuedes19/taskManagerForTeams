package com.diana.taskmanagerForTeams.Controller;

import com.diana.taskmanagerForTeams.DTO.ItemDTO;
import com.diana.taskmanagerForTeams.Service.ItemImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<ItemDTO> createPlayer (@RequestBody ItemDTO itemDTO){
        return new ResponseEntity<>(itemService.createItem(itemDTO), HttpStatus.CREATED);
    }



}
