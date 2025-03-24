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
@NoArgsConstructor
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

}
