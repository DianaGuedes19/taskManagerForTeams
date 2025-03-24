package com.diana.taskmanagerForTeams.Repository;

import com.diana.taskmanagerForTeams.Domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long> {
}
