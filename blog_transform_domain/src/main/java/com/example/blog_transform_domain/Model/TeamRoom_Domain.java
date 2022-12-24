package com.example.blog_transform_domain.Model;

import java.util.List;

public class TeamRoom_Domain {


    List<String> roomname;

    public TeamRoom_Domain(List<String> roomname) {
        this.roomname = roomname;
    }

    public List<String> getRoomname() {
        return roomname;
    }

    public void setRoomname(List<String> roomname) {
        this.roomname = roomname;
    }
}
