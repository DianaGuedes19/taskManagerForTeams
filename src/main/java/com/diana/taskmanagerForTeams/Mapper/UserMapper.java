package com.diana.taskmanagerForTeams.Mapper;

import com.diana.taskmanagerForTeams.DTO.UserDTO;
import com.diana.taskmanagerForTeams.Domain.User;

public class UserMapper {

    public static UserDTO mapToDTO (User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setRole(user.getRole());
        userDTO.setEmail(user.getEmail());
        return userDTO;
    }

    public static User userToDTO (UserDTO userDTO){
        User user = new User();
        user.setId(userDTO.getId());
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setRole(userDTO.getRole());
        user.setEmail(userDTO.getEmail());
        return user;
    }
}
