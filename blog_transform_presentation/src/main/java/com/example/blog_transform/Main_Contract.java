package com.example.blog_transform;

import android.view.View;

import com.example.blog_transform.schedule_fragment.TimeAdapter;
import com.example.bolg_transform_data.Model.DataModel_example.RoomList;
import com.example.bolg_transform_data.Model.DataModel_example.Time;

import java.util.ArrayList;
import java.util.List;

public interface  Main_Contract {

    interface Main_View {
        void show_View();
        void update_RoomList();
        void update_Fragment();
    }
    interface Main_Presenter {
        ArrayList<String> getRoomList_Data();
        void RoomList_Touch();
        ArrayList<Integer> getSchedule_value();
    }

    interface Make_Presenter
    {
        void imagechange(View v, String viewtag);
        void Drag_imagechange(View v, String viewtag);
        void save();
    }



    interface Fragment_View {
        void show_Fragment();
        void update_TimeList();
    }
    interface Fragment_Presenter
    {
        ArrayList<Time> getTimeList_Data();
        ArrayList<Time> getMainTime_Data();
        void Day_Touch();
        void Time_Touch();
        TimeAdapter Change_Adapter(int state, TimeAdapter time);
    }
    interface Fragment_ScheduleAdapter_Presenter
    {

    }
    interface Fragment_TimeAdapter_Presenter
    {

    }





}
