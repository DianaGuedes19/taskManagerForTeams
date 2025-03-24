package com.diana.taskmanagerForTeams.Domain;

import com.diana.taskmanagerForTeams.Domain.Enum.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Task {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @NotEmpty
    @Size(min = 4, max = 20)
    private String title;

    @NotNull
    @NotBlank
    @NotEmpty
    @Size(min = 15 , max = 150)
    private String description;

    @NotEmpty
    @NotNull
    @NotBlank
    private LocalDate deadline;


    @NotEmpty
    @NotNull
    @NotBlank
    @Enumerated(EnumType.STRING) // Save the value as text and not as number
    @Column(nullable = false) // Make it "obligate" to use
    private Status status;


    @NotEmpty
    @NotNull
    @NotBlank
    @ManyToOne
    @JoinColumn(name = "assigned_user_id")
    private User userAssign;


    @NotEmpty
    @NotNull
    @NotBlank
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

}
