package com.diana.taskmanagerForTeams.Domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;

class TeamTest {

    @Test
    void shouldCreateValidTeam()  {
        //arrange
        List<User> mockUserList = spy(new ArrayList<>());
        List<Project> mockProjectList = spy(new ArrayList<>());


        //act
        Team team = new Team(1L,mockUserList,"Marketing",  mockProjectList);
        // Assert
        assertNotNull(team);
    }

}