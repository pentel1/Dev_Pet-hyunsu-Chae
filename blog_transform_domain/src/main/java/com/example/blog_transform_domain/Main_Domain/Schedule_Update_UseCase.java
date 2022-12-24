package com.example.blog_transform_domain.Main_Domain;

import com.example.blog_transform_domain.Model.Schedule_Domain;
import com.example.blog_transform_domain.Repository.Repository;


import java.util.ArrayList;
import java.util.List;

public class Schedule_Update_UseCase implements Repository {

    List<Integer> schedule_list;
    List<String> decription_list;
    Schedule_Domain schedule_domain;

    public void Schedule_Save_UseCase(String nickname)
    {

        Schedule_Repository schedule_data = new Schedule_Repository() {
            @Override
            public Schedule_Domain getSchedule(String nickname) {
                return null;
            }

            @Override
            public void setSchedule(Schedule_Domain schedule, String nickname) {

            }
        };
        schedule_domain = schedule_data.getSchedule(nickname);
        schedule_list = schedule_domain.getSchedule();
        decription_list = schedule_domain.getDescription();


    }

    public List<String> getTimeList()
    {
        List<String> timelist = new ArrayList<>();
        for(int i = 0; i < 7; i++)
        {
            String start_time = "0";
            String end_time = "0";
            boolean flag = false;
            for(int j = 0; j < 24; j++)
            {
                if(schedule_list.get((i*24)+j) == 1 && !flag)
                {
                    if(j % 2 == 0)
                    {
                        start_time = ((j/2)+9)+":00";
                    }
                    else
                    {
                        start_time = ((j/2)+9)+":30";
                    }
                    timelist.add(start_time);
                    flag = true;
                }
                else if(schedule_list.get((i*24)+j)==0 && flag)
                {
                    if(j % 2 == 0)
                    {
                        end_time = ((j/2)+9)+":00";
                    }
                    else
                    {
                        end_time = ((j/2)+9)+":30";
                    }
                    timelist.add(end_time);
                    flag = false;
                }
            }
            if(flag)
            {
                timelist.add("21:00");
            }

        }
        return timelist;




    }
    public List<String> getDecription_list()
    {

        return null;
    }



}
