package com.example.blog_transform_domain.Main_Domain;

import com.example.blog_transform_domain.Repository.Repository;


import java.util.ArrayList;
import java.util.List;

public class Schedule_Make_UseCase implements Repository {

    List<Integer> schedule_list;
    List<String> decription_list;


    static List<String> timelist;

    public Schedule_Make_UseCase(List<Integer> schedule_list, List<String> decription_list) {
        this.schedule_list = schedule_list;
        this.decription_list = decription_list;
    }
    public Schedule_Make_UseCase()
    {

    }

    public List<String> getTimeList() {
        List<String> timelist = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            String start_time = i + "";
            String end_time = "0";
            boolean flag = false;
            for (int j = 0; j < 24; j++) {
                if (schedule_list.get((i * 24) + j) == 1 && !flag) {
                    if (j % 2 == 0) {
                        start_time += ((j / 2) + 9) + ":00";
                    } else {
                        start_time += ((j / 2) + 9) + ":30";
                    }

                    flag = true;
                } else if (schedule_list.get((i * 24) + j) == 0 && flag) {
                    if (j % 2 == 0) {
                        end_time = ((j / 2) + 9) + ":00";
                    } else {
                        end_time = ((j / 2) + 9) + ":30";
                    }

                    flag = false;
                    timelist.add(start_time + "/" + end_time);
                    start_time = i + "";
                }
            }
            if (flag) {
                timelist.add(start_time + "/21:00");
            }

        }
        return timelist;
    }

    public List<String> getDecription_list()
    {

        return null;
    }



}
