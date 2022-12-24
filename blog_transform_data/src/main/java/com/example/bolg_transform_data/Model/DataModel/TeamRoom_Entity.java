package com.example.bolg_transform_data.Model.DataModel;

import java.util.ArrayList;
import java.util.List;

public class TeamRoom_Entity {


    List<String> roomname;

    public TeamRoom_Entity(List<String> roomname) {

        this.roomname = roomname;

    }

    public List<String> getRoomname() {
        return roomname;
    }

    public void setRoomname(List<String> roomname) {
        this.roomname = roomname;
    }

}
