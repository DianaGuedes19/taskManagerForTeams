package com.diana.taskmanagerForTeams.Domain;

import com.diana.taskmanagerForTeams.Domain.Enum.Status;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDate;

public class Task {
    private Long id;
    private String title;
    private String description;
    private LocalDate deadline;

    @Enumerated(EnumType.STRING) // Save the value as text and not as number
    @Column(nullable = false) // Make it "obligate" to use
    private Status status;

    //User assignedUser (muitos-para-um);
    //Project project (muitos-para-um);

}
