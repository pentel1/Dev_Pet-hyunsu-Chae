package com.example.blog_transform;

import android.view.View;

import com.example.blog_transform.schedule_fragment.TimeAdapter;

import java.util.ArrayList;
import java.util.List;

public interface  Main_Contract {

    interface Main_View {
        void show_View();
        void update_RoomList();
        void update_Fragment();
    }
    interface Main_Presenter {
        void RoomList_Touch();
        void Make_Room(String roomname);
    }

    interface Make_Presenter
    {
        void imagechange(View v, String viewtag);
        void Drag_imagechange(View v, String viewtag);

    }



    interface Fragment_View {
        void show_Fragment();
        void update_TimeList();
    }
    interface Fragment_Presenter
    {

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
