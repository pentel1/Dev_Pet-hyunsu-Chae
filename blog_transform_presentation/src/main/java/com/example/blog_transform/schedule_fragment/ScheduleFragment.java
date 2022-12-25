package com.example.blog_transform.schedule_fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.blog_transform.Main_Contract;
import com.example.blog_transform.R;

import java.util.ArrayList;
import java.util.List;

public class ScheduleFragment extends Fragment implements Main_Contract.Fragment_View {

    RecyclerView schedule_day;
    ScheduleAdapter schedule_adapter;
    List<String> timelist = null;

    public ScheduleFragment(List<String> timelist)
    {
        this.timelist = timelist;
    }
    public ScheduleFragment()
    {
        this.timelist = new ArrayList<String>();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_schedule, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        schedule_day = (RecyclerView) view.findViewById(R.id.schedule_day);


        //요일 리스트 생성
        List<String> list = new ArrayList<String>();
        list.add("월");
        list.add("화");
        list.add("수");
        list.add("목");
        list.add("금");
        list.add("토");
        list.add("일");


        if(timelist.size() == 0)
        {
            schedule_adapter = new ScheduleAdapter(list);
        }
        else
        {
            schedule_adapter = new ScheduleAdapter(list, timelist);
        }

        schedule_day.setAdapter(schedule_adapter);
        schedule_day.setLayoutManager(new LinearLayoutManager(view.getContext(), RecyclerView.HORIZONTAL, false));


    }

    private void init()
    {

    }

    @Override
    public void show_Fragment() {

    }

    @Override
    public void update_TimeList() {

    }

}
