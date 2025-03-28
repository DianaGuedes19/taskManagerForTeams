package com.diana.taskmanagerForTeams.Domain;

import com.diana.taskmanagerForTeams.Domain.Enum.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "Users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank (message = "Username cannot be empty")
    @NotNull (message = "Username cannot be null")
    @NotEmpty (message = "Username cannot be empty")
    @Size(min = 3, max = 20)
    private String username;

    @NotBlank (message = "Password cannot be empty")
    @NotNull  (message = "Password cannot be null")
    @NotEmpty (message = "Password cannot be empty")
    @Pattern(
            regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{6,}$",
            message = "The password should be at least 6 characters, including letter, numbers and special characters"
    )
    private String password;


    @NotNull (message = "Role cannot be empty")
    @Enumerated(EnumType.STRING) // Save the value as text and not as number
    private Role role;

    @NotNull (message = "Teams cannot be empty")
    @ManyToMany(mappedBy = "users")
    private List<Team> teams;

    public User(Long id, String username, String password, Role role, List<Team> teams) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.teams = teams;
    }

    public User() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "Username cannot be empty") @NotNull(message = "Username cannot be null") @NotEmpty(message = "Username cannot be empty") @Size(min = 3, max = 20) String getUsername() {
        return username;
    }

    public void setUsername(@NotBlank(message = "Username cannot be empty") @NotNull(message = "Username cannot be null") @NotEmpty(message = "Username cannot be empty") @Size(min = 3, max = 20) String username) {
        this.username = username;
    }

    public @NotBlank(message = "Password cannot be empty") @NotNull(message = "Password cannot be null") @NotEmpty(message = "Password cannot be empty") @Pattern(
            regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{6,}$",
            message = "The password should be at least 6 characters, including letter, numbers and special characters"
    ) String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank(message = "Password cannot be empty") @NotNull(message = "Password cannot be null") @NotEmpty(message = "Password cannot be empty") @Pattern(
            regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{6,}$",
            message = "The password should be at least 6 characters, including letter, numbers and special characters"
    ) String password) {
        this.password = password;
    }

    public @NotNull(message = "Role cannot be empty") Role getRole() {
        return role;
    }

    public void setRole(@NotNull(message = "Role cannot be empty") Role role) {
        this.role = role;
    }

    public @NotNull(message = "Teams cannot be empty") List<Team> getTeams() {
        return teams;
    }

    public void setTeams(@NotNull(message = "Teams cannot be empty") List<Team> teams) {
        this.teams = teams;
    }
}
