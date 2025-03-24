package com.diana.taskmanagerForTeams.Domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

    @NotNull
    @NotEmpty
    @NotBlank
    @Size(min = 3)
    private String name;

    @NotBlank
    @NotNull
    @NotEmpty
    @Size(min = 20 , max = 150)
    private String description;

    @NotBlank
    @NotNull
    @NotEmpty
    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @NotBlank
    @NotNull
    @NotEmpty
    @OneToMany(mappedBy = "project") // The mapped by is informing that the other class is responsible for the FK
    private List<Task> tasks;

}
