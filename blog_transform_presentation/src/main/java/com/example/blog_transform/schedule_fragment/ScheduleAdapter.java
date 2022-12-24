package com.example.blog_transform.schedule_fragment;

import android.content.Context;
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
import com.example.bolg_transform_data.Model.DataModel_example.Schedule;
import com.example.bolg_transform_data.Model.DataModel_example.Time;

import java.util.ArrayList;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ViewHolder> {

    private ArrayList<Schedule> arraylist;
    private ArrayList<Time> timelist;
    private ArrayList<Time> maintime;
    private Fragment_Presenter presenter;



    public ScheduleAdapter(ArrayList<Schedule> arrayList) {
        this.arraylist = arrayList;
    }

    public ScheduleAdapter(ArrayList<Schedule> arrayList, ArrayList<Time> timelist, ArrayList<Time> maintime, Fragment_Presenter presenter) {
        this.arraylist = arrayList;
        this.timelist = timelist;
        this.maintime = maintime;
        this.presenter = presenter;
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

        holder.textView.setText(arraylist.get(position).getText());

        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(holder.state == 0)
                {
                    holder.time.setAdapter(holder.timeAdapter);
                    Animation animation = AnimationUtils.loadAnimation(view.getContext(), R.anim.anime_visible);
                    holder.time.startAnimation(animation);

                }
                else if(holder.state == 1)
                {
                    holder.time.setAdapter(holder.mainAdapter);
                    Animation animation = AnimationUtils.loadAnimation(view.getContext(), R.anim.anime_visible);
                    holder.time.startAnimation(animation);
                }


            }
        });

    }

    @Override
    public int getItemCount() {
        return arraylist.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        private RecyclerView time;
        private TimeAdapter timeAdapter;
        private TimeAdapter mainAdapter;
        private int state;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = (TextView) itemView.findViewById(R.id.day);
            time = (RecyclerView) itemView.findViewById(R.id.item_time);
            state = 0; // maintime 이 출력되는 상태 0


            timelist = new ArrayList<Time>();
            maintime = new ArrayList<Time>();
            //timelist = presenter.getTimeList_Data();
            //maintime = presenter.getMainTime_Data();

            timelist.add(new Time("00:00", "~", "01:00"));
            timelist.add(new Time("00:00", "~", "01:00"));
            timelist.add(new Time("00:00", "~", "01:00"));
            timelist.add(new Time("00:00", "~", "01:00"));
            timelist.add(new Time("00:00", "~", "01:00"));
            timelist.add(new Time("00:00", "~", "01:00"));
            timelist.add(new Time("00:00", "~", "01:00"));
            timelist.add(new Time("00:00", "~", "01:00"));
            timelist.add(new Time("00:00", "~", "01:00"));
            timelist.add(new Time("00:00", "~", "01:00"));
            timelist.add(new Time("00:00", "~", "01:00"));
            timelist.add(new Time("00:00", "~", "01:00"));

            maintime= new ArrayList<Time>();
            maintime.add(new Time("00:00", "~", "01:00"));


            timeAdapter = new TimeAdapter(timelist);
            mainAdapter = new TimeAdapter(maintime);
            time.setAdapter(mainAdapter);
            time.setLayoutManager(new LinearLayoutManager(textView.getContext(), RecyclerView.VERTICAL, false));





        }
    }
}
