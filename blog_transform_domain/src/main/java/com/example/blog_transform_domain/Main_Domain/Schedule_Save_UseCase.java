package com.example.blog_transform_domain.Main_Domain;


import com.example.blog_transform_domain.Model.Schedule_Domain;
import com.example.blog_transform_domain.Repository.Repository;


import java.util.List;

public class Schedule_Save_UseCase implements Repository {

    List<Integer> schedule_data;
    List<String> description_data;
    String nickname;

    public Schedule_Save_UseCase(List<Integer> schedule, List<String> description, String nickname) {
        this.schedule_data = schedule;
        this.description_data = description;
        this.nickname = nickname;
       Schedule_Domain schedule_domain = new Schedule_Domain(schedule_data, description_data);
        setSchedule(schedule_domain, nickname);
    }



    public void setSchedule(Schedule_Domain schedule , String nickname)
    {

        /*
       Schedule_Data schedule_data = new Schedule_Data(new Mapper());
       schedule_data.setSchedule(schedule, nickname);

         */

    }


}
