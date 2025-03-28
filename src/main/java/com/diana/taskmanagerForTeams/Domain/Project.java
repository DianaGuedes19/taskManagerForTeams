package com.diana.taskmanagerForTeams.Domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Project {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull (message = "Name cannot be null")
    @NotEmpty (message = "Name cannot be empty")
    @NotBlank (message = "Name cannot be empty")
    @Size(min = 3)
    @Pattern(
            regexp = "^[A-Za-z]+$",
            message = "The Title should only contain letters"
    )
    private String name;

    @NotBlank (message = "Name cannot be empty")
    @NotNull (message = "Name cannot be null")
    @NotEmpty (message = "Name cannot be empty")
    @Size(min = 20 , max = 150)
    private String description;


    @NotNull (message = "Team cannot be null")
    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;


    @NotNull (message = "Tasks cannot be null")
    @OneToMany(mappedBy = "project") // The mapped by is informing that the other class is responsible for the FK
    private List<Task> tasks;

    public Project(Long id, String name, String description, Team team, List<Task> tasks) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.team = team;
        this.tasks = tasks;
    }

    public Project() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull(message = "Name cannot be null") @NotEmpty(message = "Name cannot be empty") @NotBlank(message = "Name cannot be empty") @Size(min = 3) @Pattern(
            regexp = "^[A-Za-z]+$",
            message = "The Title should only contain letters"
    ) String getName() {
        return name;
    }

    public void setName(@NotNull(message = "Name cannot be null") @NotEmpty(message = "Name cannot be empty") @NotBlank(message = "Name cannot be empty") @Size(min = 3) @Pattern(
            regexp = "^[A-Za-z]+$",
            message = "The Title should only contain letters"
    ) String name) {
        this.name = name;
    }

    public @NotBlank(message = "Name cannot be empty") @NotNull(message = "Name cannot be null") @NotEmpty(message = "Name cannot be empty") @Size(min = 20, max = 150) String getDescription() {
        return description;
    }

    public void setDescription(@NotBlank(message = "Name cannot be empty") @NotNull(message = "Name cannot be null") @NotEmpty(message = "Name cannot be empty") @Size(min = 20, max = 150) String description) {
        this.description = description;
    }

    public @NotNull(message = "Team cannot be null") Team getTeam() {
        return team;
    }

    public void setTeam(@NotNull(message = "Team cannot be null") Team team) {
        this.team = team;
    }

    public @NotNull(message = "Tasks cannot be null") List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(@NotNull(message = "Tasks cannot be null") List<Task> tasks) {
        this.tasks = tasks;
    }
}
