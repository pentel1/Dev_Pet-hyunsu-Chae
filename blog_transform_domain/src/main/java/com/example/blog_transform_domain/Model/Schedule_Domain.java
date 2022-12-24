package com.example.blog_transform_domain.Model;

import java.util.List;

public class Schedule_Domain {
    List<Integer> schedule;
    List<String> description;

    public Schedule_Domain(List<Integer> schedule, List<String> description) {
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
