package com.diana.taskmanagerForTeams.Service;

import com.diana.taskmanagerForTeams.Domain.User;

import java.util.Optional;

public interface UserInterface {
    Optional<User> findByEmail(String email);
}
