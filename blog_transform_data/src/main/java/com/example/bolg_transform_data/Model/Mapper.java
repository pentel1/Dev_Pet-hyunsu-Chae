package com.example.bolg_transform_data.Model;


import com.example.blog_transform_domain.Model.Schedule_Domain;
import com.example.blog_transform_domain.Model.TeamChat_Domain;
import com.example.blog_transform_domain.Model.TeamList_Domain;
import com.example.blog_transform_domain.Model.TeamRoom_Domain;
import com.example.bolg_transform_data.Model.DataModel.Schedule_Entity;
import com.example.bolg_transform_data.Model.DataModel.TeamChat_Entity;
import com.example.bolg_transform_data.Model.DataModel.TeamList_Entity;
import com.example.bolg_transform_data.Model.DataModel.TeamRoom_Entity;

public class Mapper {

    public Schedule_Domain schedule_Data_toDomain(Schedule_Entity schedule)
    {
        Schedule_Domain temp = new Schedule_Domain(schedule.getSchedule(), schedule.getDescription());

        return temp;
    }
    public Schedule_Entity schedule_Domain_toData(Schedule_Domain schedule)
    {
        Schedule_Entity temp = new Schedule_Entity(schedule.getSchedule(), schedule.getDescription());

        return temp;
    }



    public TeamList_Domain teamlist_Data_toDomain(TeamList_Entity teamlist)
    {
        TeamList_Domain temp = new TeamList_Domain(teamlist.getTeamlist());

        return temp;
    }
    public TeamList_Entity teamlist_Domain_toData(TeamList_Domain teamlist)
    {
        TeamList_Entity temp = new TeamList_Entity(teamlist.getTeamlist());

        return temp;
    }



    public TeamRoom_Domain teamroom_Data_toDomain(TeamRoom_Entity teamroom)
    {
        TeamRoom_Domain temp = new TeamRoom_Domain(teamroom.getRoomname());

        return temp;
    }
    public TeamRoom_Entity teamroom_Domain_toData(TeamRoom_Domain teamlist)
    {
        TeamRoom_Entity temp = new TeamRoom_Entity(teamlist.getRoomname());

        return temp;
    }



    public TeamChat_Domain teamchat_Data_toDomain(TeamChat_Entity teamchat)
    {
        TeamChat_Domain temp = new TeamChat_Domain(teamchat.getChat(), teamchat.getTime());

        return temp;
    }
    public TeamChat_Entity teamchat_Domain_toData(TeamChat_Domain teamchat)
    {
        TeamChat_Entity temp = new TeamChat_Entity(teamchat.getChat(), teamchat.getTime());

        return temp;
    }





}
