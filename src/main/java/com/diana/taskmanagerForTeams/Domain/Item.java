package com.diana.taskmanagerForTeams.Domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Boolean _purchase;

    @ManyToOne
    @JoinColumn(name = "assigned_user_id")
    private User userAssign;


    public Item(Long id, String title, Boolean _purchase, User userAssign) {
        this.id = id;
        if (isTitleInvalid(title)) throw new IllegalArgumentException("Invalid Title!");
        this.title = title;

        if (_purchase == null) throw new IllegalArgumentException("User cannot be null!");
        this._purchase = _purchase;

        if (userAssign == null) throw new IllegalArgumentException("User cannot be null!");
        this.userAssign = userAssign;
    }

    public Item() {

    }

    public boolean isTitleInvalid(String title) {
        return title == null || title.isEmpty() || title.isBlank() || !title.matches("^[A-Za-z]+$");
    }

}