package com.diana.taskmanagerForTeams.Repository;

import com.diana.taskmanagerForTeams.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail (String email);
    Optional<User> findUserByUsername(String username);
}
