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

}
