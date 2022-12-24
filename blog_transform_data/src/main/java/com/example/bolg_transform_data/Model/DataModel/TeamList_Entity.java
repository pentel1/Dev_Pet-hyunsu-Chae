package com.example.bolg_transform_data.Model.DataModel;

import java.util.List;

public class TeamList_Entity {

    List<String> teamlist;

    public TeamList_Entity(List<String> teamlist) {
        this.teamlist = teamlist;
    }

    public List<String> getTeamlist() {
        return teamlist;
    }

    public void setTeamlist(List<String> teamlist) {
        this.teamlist = teamlist;
    }
}
