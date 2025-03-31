package com.diana.taskmanagerForTeams.Domain;

import com.diana.taskmanagerForTeams.Domain.Enum.Role;
import jakarta.persistence.*;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING) // Save the value as text and not as number
    private Role role;


    public User(Long id, String username, String email,  String password, Role role) {
        this.id = id;
        if(isUserNameInvalid(username)) throw new IllegalArgumentException("Invalid username!");
        this.username = username;
        if(isUserEmailInvalid(email)) throw new IllegalArgumentException("Invalid Email");
        this.email = email;
        if (isPasswordInvalid(password)) throw new IllegalArgumentException("Invalid password!");
        this.password = password;
        if (role == null) throw new IllegalArgumentException("Role cannot be null!");
        this.role = role;
    }

    public User() {

    }

    public boolean isUserNameInvalid (String username){
        return username==null || username.isBlank() || username.isEmpty() || username.matches("^[A-Za-z ]+$");
    }

    public boolean isUserEmailInvalid (String email){
        return email==null || email.isBlank() || email.isEmpty() || !email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }

    public  boolean isPasswordInvalid (String password){
        return password == null || password.isEmpty() || password.isBlank();
    }


    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}