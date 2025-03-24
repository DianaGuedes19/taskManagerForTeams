package com.diana.taskmanagerForTeams.Domain;

import com.diana.taskmanagerForTeams.Domain.Enum.Status;
import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
public class Task {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private LocalDate deadline;

    @Enumerated(EnumType.STRING) // Save the value as text and not as number
    @Column(nullable = false) // Make it "obligate" to use
    private Status status;

    //User assignedUser (muitos-para-um);

    @ManyToOne
    private Project project;

}
