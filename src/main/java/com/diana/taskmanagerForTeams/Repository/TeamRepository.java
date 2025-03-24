package com.diana.taskmanagerForTeams.Repository;

import com.diana.taskmanagerForTeams.Domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team,Long> {
}
