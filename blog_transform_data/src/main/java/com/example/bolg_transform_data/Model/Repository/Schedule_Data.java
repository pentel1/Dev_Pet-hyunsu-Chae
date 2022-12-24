package com.example.bolg_transform_data.Model.Repository;

import com.example.blog_transform_domain.Repository.Repository;
import com.example.blog_transform_domain.Model.Schedule_Domain;
import com.example.bolg_transform_data.Model.DataSource.Remote_Schedule;
import com.example.bolg_transform_data.Model.Mapper;

public class Schedule_Data implements Repository.Schedule_Repository {

    Mapper mapper;
    Remote_Schedule getschedule;

    public Schedule_Data() {
        mapper = new Mapper();
        getschedule = new Remote_Schedule();

    }

    @Override
    public Schedule_Domain getSchedule(String nickname) {
        Remote_Schedule getschedule = new Remote_Schedule();

        return mapper.schedule_Data_toDomain(getschedule.getSchedule(nickname));
    }

    @Override
    public void setSchedule(Schedule_Domain schedule, String nickname) {
        getschedule.setSchedule(mapper.schedule_Domain_toData(schedule), nickname);

    }
}
