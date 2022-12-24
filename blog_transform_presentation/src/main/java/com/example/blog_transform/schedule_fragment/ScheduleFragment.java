package com.example.blog_transform.schedule_fragment;

import android.os.Bundle;
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
import com.example.bolg_transform_data.Model.DataModel_example.Schedule;

import java.util.ArrayList;

public class ScheduleFragment extends Fragment implements Main_Contract.Fragment_View {

    RecyclerView schedule_day;
    ScheduleAdapter schedule_adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {



        return inflater.inflate(R.layout.fragment_schedule, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        schedule_day = (RecyclerView) view.findViewById(R.id.schedule_day);


        //요일 리스트 생성
        ArrayList<Schedule> list = new ArrayList<Schedule>();
        list.add(new Schedule("월"));
        list.add(new Schedule("화"));
        list.add(new Schedule("수"));
        list.add(new Schedule("목"));
        list.add(new Schedule("금"));
        list.add(new Schedule("토"));
        list.add(new Schedule("일"));



        schedule_adapter = new ScheduleAdapter(list);


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
