package com.diana.taskmanagerForTeams.Mapper;

import com.diana.taskmanagerForTeams.DTO.TeamDTO;
import com.diana.taskmanagerForTeams.Domain.Team;

public class TeamMapper {

    public TeamDTO mapToDTO (Team team){
        TeamDTO teamDTO = new TeamDTO();
        teamDTO.setId(team.getId());
        teamDTO.setName(team.getName());
        teamDTO.setUsers(team.getUsers());
        teamDTO.setProjects(team.getProjects());
        return teamDTO;
    }

    public Team mapToEntity (TeamDTO teamDTO){
        Team team = new Team();
        team.setId(teamDTO.getId());
        team.setName(teamDTO.getName());
        team.setUsers(teamDTO.getUsers());
        team.setProjects(teamDTO.getProjects());
        return team;
    }
}
