package com.example.blog_transform_domain.Main_Domain;


import com.example.blog_transform_domain.Repository.Repository;


import java.util.ArrayList;
import java.util.List;

public class Schedule_Save_UseCase implements Repository {

    static List<Integer> schedule_data;
    static List<String> description_data;
    String nickname;

    public Schedule_Save_UseCase(List<Integer> schedule, List<String> description, String nickname) {
        this.schedule_data = schedule;
        this.description_data = description;
        this.nickname = nickname;
       //Schedule_Domain schedule_domain = new Schedule_Domain(schedule_data, description_data);
       //setSchedule(schedule_domain, nickname);
    }

    public Schedule_Save_UseCase() {

    }




    public List<Integer> getSchedule_data()
    {
        return schedule_data;
    }

    public List<String> getDescription_data()
    {
        return description_data;
    }


}
