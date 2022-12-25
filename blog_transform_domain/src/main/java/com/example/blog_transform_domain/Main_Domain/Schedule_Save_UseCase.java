package com.example.blog_transform_domain.Main_Domain;


import android.util.Log;

import com.example.blog_transform_domain.Model.Schedule_Domain;
import com.example.blog_transform_domain.Repository.Repository;


import java.util.ArrayList;
import java.util.List;

public class Schedule_Save_UseCase implements Repository {

    List<Integer> schedule_data;
    List<String> description_data;
    String nickname;
    static List<String> timelist;

    public Schedule_Save_UseCase(List<Integer> schedule, List<String> description, String nickname) {
        this.schedule_data = schedule;
        this.description_data = description;
        this.nickname = nickname;
        Schedule_Domain schedule_domain = new Schedule_Domain(schedule_data, description_data);
       //setSchedule(schedule_domain, nickname);
        timelist = new ArrayList<String>();
    }

    public Schedule_Save_UseCase() {

    }

    public static List<String> getTimelist() {
        return timelist;
    }

    public void setTimelist(List<String> timelist) {
        this.timelist = timelist;
    }

    public void getSchedule()
    {

        /*
       Schedule_Data schedule_data = new Schedule_Data(new Mapper());
       schedule_data.setSchedule(schedule, nickname);

         */

        for(int i = 0; i < 7; i++)
        {
            String start_time = i+"";
            String end_time = "0";
            boolean flag = false;
            for(int j = 0; j < 24; j++)
            {
                if(schedule_data.get((i*24)+j) == 1 && !flag)
                {
                    if(j % 2 == 0)
                    {
                        start_time += ((j/2)+9)+":00";
                    }
                    else
                    {
                        start_time += ((j/2)+9)+":30";
                    }

                    flag = true;
                }
                else if(schedule_data.get((i*24)+j)==0 && flag)
                {
                    if(j % 2 == 0)
                    {
                        end_time = ((j/2)+9)+":00";
                    }
                    else
                    {
                        end_time = ((j/2)+9)+":30";
                    }

                    flag = false;
                    timelist.add(start_time +"/" + end_time);
                    start_time = i+"";
                }
            }
            if(flag)
            {
                timelist.add(start_time +"/21:00");
            }


        }

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
