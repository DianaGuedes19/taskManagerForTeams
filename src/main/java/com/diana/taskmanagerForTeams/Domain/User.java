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

    @NotBlank
    @NotNull
    @NotEmpty
    @Size(min = 3, max = 20)
    private String username;

    @NotBlank
    @NotNull
    @NotEmpty
    @Pattern(
            regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{6,}$",
            message = "The password should be at least 6 characters, including letter, numbers and special characters"
    )
    private String password;

    @NotBlank
    @NotNull
    @NotEmpty
    private Role role;

    @NotBlank
    @NotNull
    @NotEmpty
    @ManyToMany(mappedBy = "users")
    private List<Team> teams;

}
