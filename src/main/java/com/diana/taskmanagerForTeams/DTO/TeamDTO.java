package com.diana.taskmanagerForTeams.DTO;

import com.diana.taskmanagerForTeams.Domain.Project;
import com.diana.taskmanagerForTeams.Domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class TeamDTO {
    private Long id;
    private String name;
    private List<User> users;
    private List<Project> projects;

    public TeamDTO(Long id, String name, List<User> users, List<Project> projects) {
        this.id = id;
        this.name = name;
        this.users = users;
        this.projects = projects;
    }

    public TeamDTO() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
