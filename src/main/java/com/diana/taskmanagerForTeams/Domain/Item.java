package com.diana.taskmanagerForTeams.Domain;

import jakarta.persistence.*;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Boolean purchase;

    @ManyToOne
    @JoinColumn(name = "assigned_user_id")
    private User userAssign;


    public Item(Long id, String title, Boolean purchase, User userAssign) {
        this.id = id;
        if (isTitleInvalid(title)) throw new IllegalArgumentException("Invalid Title!");
        this.title = title;

        if (purchase == null) throw new IllegalArgumentException("User cannot be null!");
        this.purchase = purchase;

        if (userAssign == null) throw new IllegalArgumentException("User cannot be null!");
        this.userAssign = userAssign;
    }

    public Item() {

    }

    public boolean isTitleInvalid(String title) {
        return title == null || title.isEmpty() || title.isBlank() ;
    }


    // Getter and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getPurchase() {
        return purchase;
    }

    public void setPurchase(Boolean purchase) {
        this.purchase = purchase;
    }

    public User getUserAssign() {
        return userAssign;
    }

    public void setUserAssign(User userAssign) {
        this.userAssign = userAssign;
    }
}