package com.example.bolg_transform_data.Model.Repository;

import java.util.List;

public class TeamList_Data {

    List<String> teamlist;

    public TeamList_Data(List<String> teamlist) {
        this.teamlist = teamlist;
    }

    public List<String> getTeamlist() {
        return teamlist;
    }

    public void setTeamlist(List<String> teamlist) {
        this.teamlist = teamlist;
    }
}
