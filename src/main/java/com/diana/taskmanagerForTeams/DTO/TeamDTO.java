package com.diana.taskmanagerForTeams.DTO;

import com.diana.taskmanagerForTeams.Domain.Project;
import com.diana.taskmanagerForTeams.Domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TeamDTO {
    private Long id;
    private String name;
    private List<User> users;
    private List<Project> projects;


}
