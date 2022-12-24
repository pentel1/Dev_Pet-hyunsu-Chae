package com.example.blog_transform_domain.Model;

import java.util.List;

public class TeamList_Domain {

    List<String> teamlist;

    public TeamList_Domain(List<String> teamlist) {
        this.teamlist = teamlist;
    }

    public List<String> getTeamlist() {
        return teamlist;
    }

    public void setTeamlist(List<String> teamlist) {
        this.teamlist = teamlist;
    }
}
