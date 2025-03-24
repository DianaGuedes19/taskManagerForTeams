package com.diana.taskmanagerForTeams.DTO;

import com.diana.taskmanagerForTeams.Domain.Task;
import com.diana.taskmanagerForTeams.Domain.Team;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProjectDTO {
    private Long id;
    private String name;
    private String description;
    private Team team;
    private List<Task> tasks;

}
