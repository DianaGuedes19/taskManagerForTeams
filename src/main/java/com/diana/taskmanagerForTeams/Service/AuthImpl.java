package com.diana.taskmanagerForTeams.Service;

import com.diana.taskmanagerForTeams.DTO.AuthResponse;
import com.diana.taskmanagerForTeams.DTO.LoginDTO;
import com.diana.taskmanagerForTeams.DTO.UserDTO;
import com.diana.taskmanagerForTeams.Domain.User;
import com.diana.taskmanagerForTeams.Mapper.UserMapper;
import com.diana.taskmanagerForTeams.Repository.UserRepository;
import com.diana.taskmanagerForTeams.Security.JwtUtil;
import com.diana.taskmanagerForTeams.Security.SecurityConfig;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;

@Service
public class AuthImpl implements AuthInterface{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public UserDTO register(UserDTO userDTO) {
       if (userRepository.findByEmail(userDTO.getEmail()).isPresent()) {throw new RuntimeException("Email alredy register!");}
        User user = UserMapper.userToDTO(userDTO);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return UserMapper.mapToDTO(user);
    }

    @Override
    public AuthResponse login(LoginDTO loginDTO) {
        // Verify if this email exists
        User user = userRepository.findByEmail(loginDTO.getEmail()).orElseThrow(() -> new RuntimeException("This is email is not register!"));

        // Verify is the password is the same from login and user
        if (!passwordEncoder.matches(loginDTO.getPassword(), user.getPassword())) {
            throw new RuntimeException("Wrong Password!")   ;
        }

        // Creating a Spring User only to pass to JwtUtil and generate token . This is not save, only used here
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                Collections.singleton(new SimpleGrantedAuthority("ROLE_" + user.getRole().name()))
        );
        // Generate JwtToken
        String token = jwtUtil.generateToken(userDetails);

        // Return token in AuthResponse
        return new AuthResponse(token);
    }
}
