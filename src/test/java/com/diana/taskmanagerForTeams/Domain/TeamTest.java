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
    @Test
    void shouldSetNameProperly() {
        // arrange
        List<User> users = spy(new ArrayList<>());
        List<Project> projects = spy(new ArrayList<>());

        // act
        Team team = new Team(3L, users, "Operations", projects);

        // assert
        assertEquals("Operations", team.getName());
    }

    @Test
    void shouldFailNameWithNumbers() {
        // arrange
        List<User> users = spy(new ArrayList<>());
        List<Project> projects = spy(new ArrayList<>());

        // act
        Team team = new Team(4L, users, "Team123", projects);

        // assert
        assertFalse(team.getName().matches("^[A-Za-z]+$")); }

    @Test
    void shouldFailNameWithLessThanFiveCharacters() {
        // arrange
        List<User> users = spy(new ArrayList<>());
        List<Project> projects = spy(new ArrayList<>());

        // act
        Team team = new Team(5L, users, "ABc", projects);

        // assert
        assertTrue(team.getName().length() < 5);
    }

    @Test
    void shouldSetAndGetAllFields() {
        // arrange
        Team team = new Team();
        List<User> users = new ArrayList<>();
        List<Project> projects = new ArrayList<>();

        // act
        team.setId(3L);
        team.setName("Support");
        team.setUsers(users);
        team.setProjects(projects);

        // assert
        assertEquals(3L, team.getId());
        assertEquals("Support", team.getName());
        assertEquals(users, team.getUsers());
        assertEquals(projects, team.getProjects());
    }

}