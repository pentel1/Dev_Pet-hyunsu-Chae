package com.example.blog_transform_domain.Repository;


import com.example.blog_transform_domain.Model.Schedule_Domain;
import com.example.blog_transform_domain.Model.TeamRoom_Domain;

import java.util.List;

public interface Repository {



    interface Schedule_Repository {
        Schedule_Domain getSchedule(String nickname);
        void setSchedule(Schedule_Domain schedule, String nickname);
    }

    interface RoomList {
        TeamRoom_Domain getRoomList();
        void addRoomList(String roomname);
    }

    interface ChatList
    {
        void WriteChat(String text);
        void UpdateChat(List<String> textlist);
        void remove(String text);
    }

}
