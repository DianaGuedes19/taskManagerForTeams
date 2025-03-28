package com.diana.taskmanagerForTeams.Domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor

public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank  (message = "Name cannot be empty")
    @NotNull (message = "Name cannot be null")
    @NotEmpty (message = "Name cannot be empty")
    @Size(min = 5)
    @Pattern(
            regexp = "^[A-Za-z]+$",
            message = "The name should only contain letters"
    )
    private String name;

    @NotNull (message = "User cannot be empty")
    @ManyToMany
    @JoinTable(name = "team_user",
            joinColumns = @JoinColumn(name = "team_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> users;


    @NotNull (message = "Project cannot be empty")
    @OneToMany(mappedBy = "team")
    private List<Project> projects;

    public Team(Long id, List<User> users, String name, List<Project> projects) {
        this.id = id;
        this.users = users;
        this.name = name;
        this.projects = projects;
    }

    public Team() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "Name cannot be empty") @NotNull(message = "Name cannot be null") @NotEmpty(message = "Name cannot be empty") @Size(min = 5) @Pattern(
            regexp = "^[A-Za-z]+$",
            message = "The name should only contain letters"
    ) String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Name cannot be empty") @NotNull(message = "Name cannot be null") @NotEmpty(message = "Name cannot be empty") @Size(min = 5) @Pattern(
            regexp = "^[A-Za-z]+$",
            message = "The name should only contain letters"
    ) String name) {
        this.name = name;
    }

    public @NotNull(message = "User cannot be empty") List<User> getUsers() {
        return users;
    }

    public void setUsers(@NotNull(message = "User cannot be empty") List<User> users) {
        this.users = users;
    }

    public @NotNull(message = "Project cannot be empty") List<Project> getProjects() {
        return projects;
    }

    public void setProjects(@NotNull(message = "Project cannot be empty") List<Project> projects) {
        this.projects = projects;
    }
}
