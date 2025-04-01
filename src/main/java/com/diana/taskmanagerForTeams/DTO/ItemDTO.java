package com.diana.taskmanagerForTeams.DTO;

import com.diana.taskmanagerForTeams.Domain.User;



public class ItemDTO {
    private Long id;
    private String title;
    private Boolean purchase;
    private User userAssign;

    public ItemDTO(Long id, String title, Boolean purchase, User userAssign) {
        this.id = id;
        this.title = title;
        this.purchase = purchase;
        this.userAssign = userAssign;
    }

    public ItemDTO() {

    }

    // Getters and Setters
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


