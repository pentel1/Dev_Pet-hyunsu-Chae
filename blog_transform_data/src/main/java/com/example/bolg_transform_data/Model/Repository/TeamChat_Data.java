package com.example.bolg_transform_data.Model.Repository;

import java.util.List;

public class TeamChat_Data {

    List<String> teamlist;
    List<String> chat;
    List<String> time;

    public TeamChat_Data(List<String> teamlist, List<String> chat, List<String> time) {
        this.teamlist = teamlist;
        this.chat = chat;
        this.time = time;
    }

    public List<String> getTeamlist() {
        return teamlist;
    }

    public void setTeamlist(List<String> teamlist) {
        this.teamlist = teamlist;
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
