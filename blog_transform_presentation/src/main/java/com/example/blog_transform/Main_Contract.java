package com.example.blog_transform;

import android.view.View;

import com.example.blog_transform.schedule_fragment.TimeAdapter;

import java.util.ArrayList;
import java.util.List;

public interface  Main_Contract {

    interface Main_View {
        void show_View();
        void update_RoomList();
        void update_Schedule();
    }
    interface Main_Presenter {
        void RoomList_Touch(String roomname);
        void Make_Room();
    }

    interface Make_Presenter
    {
        void Touch_imagechange(View v, String viewtag);
        void Drag_imagechange(View v, String viewtag);

    }

    interface Fragment_Presenter
    {
        void Time_Touch();
        List<String> Make_maintime_list(List<String> day_timelist);
        List<String> Make_timelist(List<String> timelist, int position);
    }
    interface Fragment_ScheduleAdapter_Presenter
    {

    }
    interface Fragment_TimeAdapter_Presenter
    {

    }





}
