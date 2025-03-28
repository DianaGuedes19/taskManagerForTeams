package com.diana.taskmanagerForTeams.Controller;

import com.diana.taskmanagerForTeams.DTO.AuthResponse;
import com.diana.taskmanagerForTeams.DTO.LoginDTO;
import com.diana.taskmanagerForTeams.DTO.UserDTO;
import com.diana.taskmanagerForTeams.Service.AuthImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private AuthImpl AuthService;

    public AuthController(AuthImpl authService) {
        AuthService = authService;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UserDTO> registerUser (@RequestBody UserDTO userDTO){
        return new ResponseEntity<>(AuthService.register(userDTO), HttpStatus.OK);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<AuthResponse> loginUser (@RequestBody LoginDTO loginDTO){
        return new ResponseEntity<>(AuthService.login(loginDTO), HttpStatus.OK);
    }

}
