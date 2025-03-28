package com.diana.taskmanagerForTeams.DTO;

import com.diana.taskmanagerForTeams.Domain.Enum.Role;
import com.diana.taskmanagerForTeams.Domain.Team;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class UserDTO {
    private Long id;
    private String username;
    private String password;
    private Role role;
    private List<Team> teams;

    public UserDTO(Long id, String username, String password, Role role, List<Team> teams) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.teams = teams;
    }

    public UserDTO() {
        ;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }
}
