package com.diana.taskmanagerForTeams.DTO;

import com.diana.taskmanagerForTeams.Domain.User;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ItemDTO {
    private Long id;
    private String title;
    private Boolean _purchase;
    private User userAssign;

    public ItemDTO(Long id, String title, Boolean purchase, User userAssign) {
        this.id = id;
        this.title = title;
        this._purchase = purchase;
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

    public Boolean get_purchase() {
        return _purchase;
    }

    public void set_purchase(Boolean _purchase) {
        this._purchase = _purchase;
    }

    public User getUserAssign() {
        return userAssign;
    }

    public void setUserAssign(User userAssign) {
        this.userAssign = userAssign;
    }
}


