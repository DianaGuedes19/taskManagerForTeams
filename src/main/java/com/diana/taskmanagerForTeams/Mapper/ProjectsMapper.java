package com.diana.taskmanagerForTeams.Mapper;
import com.diana.taskmanagerForTeams.DTO.ProjectsDTO;
import com.diana.taskmanagerForTeams.Domain.Project;

public class ProjectsMapper {

    public static ProjectsDTO mapToDTO(Project project) {
        ProjectsDTO projectDTO = new ProjectsDTO();
        projectDTO.setId(project.getId());
        projectDTO.setName(project.getName());
        projectDTO.setDescription(project.getDescription());
        projectDTO.setTasks(project.getTasks());
        projectDTO.setTeam(project.getTeam());
        return projectDTO;

    }

    public static Project mapToEntity (ProjectsDTO projectsDTO){
        Project project = new Project();
        project.setId(projectsDTO.getId());
        project.setName(projectsDTO.getName());
        project.setDescription(projectsDTO.getDescription());
        project.setTeam(projectsDTO.getTeam());
        project.setTasks(projectsDTO.getTasks());
        return project;
    }
}
