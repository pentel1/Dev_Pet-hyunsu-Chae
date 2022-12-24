package com.example.bolg_transform_data.Model.Repository;

import com.example.bolg_transform_data.Model.DataModel.Schedule_Entity;

public class TeamRoom_Data {


    String roomname;
    String first_message;

    public TeamRoom_Data(Schedule_Entity schedule, String roomname, String first_message) {

        this.roomname = roomname;
        this.first_message = first_message;
    }



    public String getRoomname() {
        return roomname;
    }

    public void setRoomname(String roomname) {
        this.roomname = roomname;
    }

    public String getFirst_message() {
        return first_message;
    }

    public void setFirst_message(String first_message) {
        this.first_message = first_message;
    }
}
