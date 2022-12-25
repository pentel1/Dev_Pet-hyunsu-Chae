package com.example.blog_transform.schedule_fragment;

import android.content.Context;

import com.example.blog_transform.Main_Contract;



import java.util.ArrayList;

public class Fragment_Presenter implements Main_Contract.Fragment_Presenter {
    Context context;


    public Fragment_Presenter(Context context) {
        this.context = context;
    }



    @Override
    public void Day_Touch() {

    }

    @Override
    public void Time_Touch() {

    }

    @Override
    public TimeAdapter Change_Adapter(int state, TimeAdapter timeadapter) {
        if(state == 0)
        {
            return timeadapter;


        }
        else
        {
            return timeadapter;
        }

    }
}
