package com.diana.taskmanagerForTeams.DTO;

import com.diana.taskmanagerForTeams.Domain.Enum.Status;
import com.diana.taskmanagerForTeams.Domain.Project;
import com.diana.taskmanagerForTeams.Domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
public class TaskDTO {
    private Long id;
    private String title;
    private String description;
    private LocalDate deadline;
    private Status status;
    private User userAssign;
    private Project project;

    public TaskDTO(Long id, String title, String description, LocalDate deadline, Status status, Project project, User userAssign) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.status = status;
        this.project = project;
        this.userAssign = userAssign;
    }

    public TaskDTO() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public User getUserAssign() {
        return userAssign;
    }

    public void setUserAssign(User userAssign) {
        this.userAssign = userAssign;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
