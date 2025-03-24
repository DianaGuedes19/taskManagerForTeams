package com.diana.taskmanagerForTeams.Repository;

import com.diana.taskmanagerForTeams.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
