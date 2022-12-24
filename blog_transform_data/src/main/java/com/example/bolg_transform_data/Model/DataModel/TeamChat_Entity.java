package com.example.bolg_transform_data.Model.DataModel;

import java.util.List;

public class TeamChat_Entity {

    List<String> chat;
    List<String> time;

    public TeamChat_Entity(List<String> chat, List<String> time) {
        this.chat = chat;
        this.time = time;
    }


    public List<String> getChat() {
        return chat;
    }

    public void setChat(List<String> chat) {
        this.chat = chat;
    }

    public List<String> getTime() {
        return time;
    }

    public void setTime(List<String> time) {
        this.time = time;
    }
}
