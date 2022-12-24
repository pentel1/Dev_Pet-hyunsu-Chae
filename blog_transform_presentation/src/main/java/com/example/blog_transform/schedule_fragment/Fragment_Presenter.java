package com.example.blog_transform.schedule_fragment;

import android.content.Context;

import com.example.blog_transform.Main_Contract;
import com.example.blog_transform_domain.Main_Domain.Fragment_Usercase;
import com.example.bolg_transform_data.Model.DataModel_example.Time;

import java.util.ArrayList;

public class Fragment_Presenter implements Main_Contract.Fragment_Presenter {
    Context context;
    Fragment_Usercase usecase;

    public Fragment_Presenter(Context context, Fragment_Usercase usecase) {
        this.context = context;
        this.usecase = usecase;
    }

    @Override
    public ArrayList<Time> getTimeList_Data() {
        return null;
    }

    @Override
    public ArrayList<Time> getMainTime_Data() {
        return null;
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
