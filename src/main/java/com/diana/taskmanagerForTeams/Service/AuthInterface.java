package com.diana.taskmanagerForTeams.Service;

import com.diana.taskmanagerForTeams.DTO.AuthResponse;
import com.diana.taskmanagerForTeams.DTO.LoginDTO;
import com.diana.taskmanagerForTeams.DTO.UserDTO;

public interface AuthInterface {
    UserDTO register(UserDTO userDTO);
    AuthResponse login (LoginDTO loginDTO);
}
