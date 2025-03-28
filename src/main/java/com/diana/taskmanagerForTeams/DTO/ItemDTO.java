package com.diana.taskmanagerForTeams.DTO;

import com.diana.taskmanagerForTeams.Domain.User;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ItemDTO {
    private Long id;
    private String title;
    private String description;
    private Boolean _purchase;
    private User userAssign;

    public ItemDTO(Long id, String title, String description, Boolean purchase, User userAssign) {
        this.id = id;
        this.title = title;
        this.description = description;
        this._purchase = purchase;
        this.userAssign = userAssign;
    }

    public ItemDTO() {

    }

}


