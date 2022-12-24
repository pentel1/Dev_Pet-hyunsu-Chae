package com.example.bolg_transform_data.Model.DataModel;

import java.util.ArrayList;
import java.util.List;

public class Schedule_Entity {

    List<Integer> schedule;
    List<String> description;


    public Schedule_Entity() {
        schedule = new ArrayList<Integer>();
        description = new ArrayList<String>();
        for(int i = 0; i < 168; i++)
        {
            schedule.add(0);
            description.add("기본데이터");
        }
    }


    public Schedule_Entity(List<Integer> schedule, List<String> description) {
        this.schedule = schedule;
        this.description = description;
    }

    public List<Integer> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<Integer> schedule) {
        this.schedule = schedule;
    }

    public List<String> getDescription() {
        return description;
    }

    public void setDescription(List<String> description) {
        this.description = description;
    }
}
