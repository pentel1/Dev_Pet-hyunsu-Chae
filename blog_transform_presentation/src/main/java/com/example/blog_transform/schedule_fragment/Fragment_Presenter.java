package com.example.blog_transform.schedule_fragment;

import android.content.Context;
import android.util.Log;

import com.example.blog_transform.Main_Contract;



import java.util.ArrayList;
import java.util.List;

public class Fragment_Presenter implements Main_Contract.Fragment_Presenter {


    public Fragment_Presenter() {

    }


    @Override
    public List<String> Make_timelist(List<String> timelist, int position)
    {

        List<String> day_timelist = new ArrayList<String>();
        for(int i = 0; i < timelist.size(); i++)
        {

            if((timelist.get(i).charAt(0) + "").equals(position + ""))
            {
                String temp = timelist.get(i);
                day_timelist.add(temp.substring(1, temp.length()));
            }
        }

        return day_timelist;

    }

    @Override
    public List<String> Make_maintime_list(List<String> day_timelist)
    {
        List<String> maintime = new ArrayList<String>();
        if(day_timelist.size() > 0)
        {
            String temp_s1[] = day_timelist.get(0).split("/");
            String start_time = temp_s1[0];
            String temp_s2[] = day_timelist.get(day_timelist.size() - 1).split("/");
            String end_time = temp_s2[1];
            maintime.add(start_time + "/" + end_time);

        }
        return maintime;
    }

    @Override
    public void Time_Touch() {
        //추후 일정 설명을 추가할 생성을 위한 메소드
    }


}
