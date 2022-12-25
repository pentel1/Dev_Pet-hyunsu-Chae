package com.example.blog_transform.schedule_fragment;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.blog_transform.R;

import java.util.ArrayList;
import java.util.List;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ViewHolder> {

    private List<String> day;
    private List<String> timelist = null;
    private List<String> day_timelist = null;
    private TimeAdapter timeAdapter;
    private TimeAdapter mainAdapter;


    public ScheduleAdapter(List<String> arrayList) {
        this.day = arrayList;
        this.timelist = new ArrayList<>();
    }

    public ScheduleAdapter(List<String> arrayList, List<String> timelist) {
        this.day = arrayList;
        this.timelist = timelist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.recycler_main_item_day, parent, false);
        ScheduleAdapter.ViewHolder vh = new ScheduleAdapter.ViewHolder(view);
        return vh;
    }


    @Override
    public void onBindViewHolder(@NonNull ScheduleAdapter.ViewHolder holder, int position) {
        holder.textView.setText(day.get(position));

        day_timelist = new ArrayList<String>();
        TimeAdapter t_adapter = new TimeAdapter(day_timelist);
        TimeAdapter m_adapter = new TimeAdapter(day_timelist);

        List<String> maintime = new ArrayList<String>();


        for(int i = 0; i < timelist.size(); i++)
        {
            if((timelist.get(i).charAt(0) + "").equals(position + ""))
            {
                String temp = timelist.get(i);
                day_timelist.add(temp.substring(1, temp.length()));
            }
        }

        if(day_timelist.size() > 0)
        {
            t_adapter = new TimeAdapter(day_timelist);
            String temp_s1[] = day_timelist.get(0).split("/");
            String start_time = temp_s1[0];
            String temp_s2[] = day_timelist.get(day_timelist.size() - 1).split("/");
            String end_time = temp_s2[1];
            maintime.add(start_time + "/" + end_time);
            m_adapter = new TimeAdapter(maintime);
            holder.time.setAdapter(m_adapter);
        }

        TimeAdapter finalT_adapter = t_adapter;
        TimeAdapter finalM_adapter = m_adapter;

        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (holder.state == 0) {
                    holder.time.setAdapter(finalT_adapter);
                    Animation animation = AnimationUtils.loadAnimation(view.getContext(), R.anim.anime_visible);
                    holder.time.startAnimation(animation);
                    holder.state = 1;

                } else if (holder.state == 1) {
                    holder.time.setAdapter(finalM_adapter);
                    Animation animation = AnimationUtils.loadAnimation(view.getContext(), R.anim.anime_visible);
                    holder.time.startAnimation(animation);
                    holder.state = 0;

                }


            }
        });

    }

    @Override
    public int getItemCount() {
        return day.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        private RecyclerView time;
        private int state;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = (TextView) itemView.findViewById(R.id.day);
            time = (RecyclerView) itemView.findViewById(R.id.item_time);
            state = 0; // maintime 이 출력되는 상태 0

            timeAdapter = new TimeAdapter(new ArrayList<String>());
            mainAdapter = new TimeAdapter(new ArrayList<String>());


            time.setAdapter(mainAdapter);
            time.setLayoutManager(new LinearLayoutManager(textView.getContext(), RecyclerView.VERTICAL, false));


        }
    }
}
