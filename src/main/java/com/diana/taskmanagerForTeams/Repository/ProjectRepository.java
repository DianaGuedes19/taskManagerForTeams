package com.diana.taskmanagerForTeams.Repository;

import com.diana.taskmanagerForTeams.Domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project,Long> {
}
