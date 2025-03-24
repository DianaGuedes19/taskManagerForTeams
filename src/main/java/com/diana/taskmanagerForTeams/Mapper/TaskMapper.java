package com.diana.taskmanagerForTeams.Mapper;

import com.diana.taskmanagerForTeams.DTO.TaskDTO;
import com.diana.taskmanagerForTeams.Domain.Task;

public class TaskMapper {

    public TaskDTO mapToDTO (Task task){
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setId(task.getId());
        taskDTO.setTitle(task.getTitle());
        taskDTO.setDescription(task.getDescription());
        taskDTO.setDeadline(task.getDeadline());
        taskDTO.setStatus(task.getStatus());
        taskDTO.setUserAssign(task.getUserAssign());
        taskDTO.setProject(task.getProject());
        return taskDTO;
    }

    public Task mapToEntity (TaskDTO taskDTO){
        Task task = new Task();
        task.setId(taskDTO.getId());
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setDeadline(taskDTO.getDeadline());
        task.setStatus(taskDTO.getStatus());
        task.setUserAssign(taskDTO.getUserAssign());
        task.setProject(taskDTO.getProject());
        return task;
    }
}
