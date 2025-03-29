package com.diana.taskmanagerForTeams.Service;

import com.diana.taskmanagerForTeams.DTO.UserDTO;
import com.diana.taskmanagerForTeams.Domain.User;
import com.diana.taskmanagerForTeams.Mapper.UserMapper;
import com.diana.taskmanagerForTeams.Repository.UserRepository;
import com.diana.taskmanagerForTeams.Security.SecurityConfig;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthImpl implements AuthInterface{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDTO register(UserDTO userDTO) {
       if (userRepository.findByEmail(userDTO.getEmail()).isPresent()) {throw new RuntimeException("Email alredy register!");}
        User user = UserMapper.userToDTO(userDTO);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return UserMapper.mapToDTO(user);
    }
}
