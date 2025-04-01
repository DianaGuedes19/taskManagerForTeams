package com.diana.taskmanagerForTeams.Controller;

import com.diana.taskmanagerForTeams.DTO.UserDTO;
import com.diana.taskmanagerForTeams.Domain.User;
import com.diana.taskmanagerForTeams.Service.UserImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserImpl userService;

    public UserController(UserImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/getAllUsers")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<UserDTO>> getAllUsers (){
        return new ResponseEntity<>(userService.findAllUsers(),HttpStatus.OK);
    }

    @GetMapping ("/findByEmail")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<User> findUserByEmail (@RequestParam String email){
        return ResponseEntity.of(userService.findByEmail(email));
    }

    @GetMapping ("/findByUsername")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<User> findUserByUsername (@RequestParam String username){
        return ResponseEntity.of(userService.findUserByUsername(username));
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UserDTO> updatePlayer (@RequestBody UserDTO userDTO, @PathVariable Long id){
        return new ResponseEntity<>(userService.updateUser(userDTO,id),HttpStatus.OK);
    }



}
