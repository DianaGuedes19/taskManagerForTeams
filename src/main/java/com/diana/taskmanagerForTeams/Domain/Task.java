package com.diana.taskmanagerForTeams.Domain;

import java.time.LocalDate;

public class Task {
    private Long id;
    private String title;
    private String description;
    private LocalDate deadline;
    //private String status (PENDING, IN_PROGRESS, DONE);
    //User assignedUser (muitos-para-um);
    //Project project (muitos-para-um);

}
