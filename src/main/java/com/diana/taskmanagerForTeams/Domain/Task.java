package com.diana.taskmanagerForTeams.Domain;

import com.diana.taskmanagerForTeams.Domain.Enum.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Task {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull (message = "Title cannot be null")
    @NotBlank (message = "Title cannot be empty")
    @NotEmpty (message = "Title cannot be empty")
    @Size(min = 4, max = 20)
    @Pattern(
            regexp = "^[A-Za-z]+$",
            message = "The Title should only contain letters"
    )
    private String title;

    @NotNull (message = "Description cannot be null")
    @NotBlank (message = "Description cannot be empty")
    @NotEmpty (message = "Description cannot be empty")
    @Size(min = 15 , max = 150)
    private String description;


    @NotNull (message = "Date cannot be null")
    @FutureOrPresent
    private LocalDate deadline;


    @NotNull (message = "Status cannot be null")
    @Enumerated(EnumType.STRING) // Save the value as text and not as number
    @Column(nullable = false) // Make it "obligate" to use
    private Status status;


    @NotNull  (message = "User cannot be null")
    @ManyToOne
    @JoinColumn(name = "assigned_user_id")
    private User userAssign;


    @NotNull  (message = "Project cannot be null")
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

}
