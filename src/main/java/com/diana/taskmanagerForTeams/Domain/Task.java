package com.diana.taskmanagerForTeams.Domain;

import com.diana.taskmanagerForTeams.Domain.Enum.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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

    public Task(Long id, String title, String description, LocalDate deadline, Status status, User userAssign, Project project) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.status = status;
        this.userAssign = userAssign;
        this.project = project;
    }

    public Task() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull(message = "Description cannot be null") @NotBlank(message = "Description cannot be empty") @NotEmpty(message = "Description cannot be empty") @Size(min = 15, max = 150) String getDescription() {
        return description;
    }

    public void setDescription(@NotNull(message = "Description cannot be null") @NotBlank(message = "Description cannot be empty") @NotEmpty(message = "Description cannot be empty") @Size(min = 15, max = 150) String description) {
        this.description = description;
    }

    public @NotNull(message = "Title cannot be null") @NotBlank(message = "Title cannot be empty") @NotEmpty(message = "Title cannot be empty") @Size(min = 4, max = 20) @Pattern(
            regexp = "^[A-Za-z]+$",
            message = "The Title should only contain letters"
    ) String getTitle() {
        return title;
    }

    public void setTitle(@NotNull(message = "Title cannot be null") @NotBlank(message = "Title cannot be empty") @NotEmpty(message = "Title cannot be empty") @Size(min = 4, max = 20) @Pattern(
            regexp = "^[A-Za-z]+$",
            message = "The Title should only contain letters"
    ) String title) {
        this.title = title;
    }

    public @NotNull(message = "Date cannot be null") @FutureOrPresent LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(@NotNull(message = "Date cannot be null") @FutureOrPresent LocalDate deadline) {
        this.deadline = deadline;
    }

    public @NotNull(message = "Status cannot be null") Status getStatus() {
        return status;
    }

    public void setStatus(@NotNull(message = "Status cannot be null") Status status) {
        this.status = status;
    }

    public @NotNull(message = "User cannot be null") User getUserAssign() {
        return userAssign;
    }

    public void setUserAssign(@NotNull(message = "User cannot be null") User userAssign) {
        this.userAssign = userAssign;
    }

    public @NotNull(message = "Project cannot be null") Project getProject() {
        return project;
    }

    public void setProject(@NotNull(message = "Project cannot be null") Project project) {
        this.project = project;
    }
}
