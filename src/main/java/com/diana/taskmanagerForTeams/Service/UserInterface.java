package com.diana.taskmanagerForTeams.Service;

import com.diana.taskmanagerForTeams.DTO.UserDTO;
import com.diana.taskmanagerForTeams.Domain.User;

import java.util.List;
import java.util.Optional;

public interface UserInterface {
    Optional<User> findByEmail(String email);
    Optional<User> findUserByUsername (String username);
    List <UserDTO> findAllUsers();
    UserDTO updateUser (UserDTO userDTO, Long id);
//    void deleteUser (Long id);
}
