package com.example.blog_transform.make;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.blog_transform.Main_Contract;
import com.example.blog_transform.R;
import com.example.blog_transform_domain.Main_Domain.Schedule_Save_UseCase;

import java.util.ArrayList;
import java.util.List;

public class Make_Presenter implements Main_Contract.Make_Presenter {

    static List<Integer> schedule;
    Schedule_Save_UseCase usecase;
    static int state;


    public Make_Presenter(List<Integer> schedule) {
        this.schedule = schedule;
    }



    @Override
    public void Touch_imagechange(View v, String viewtag) {
        ImageView ig = (ImageView) v;
        String value = viewtag.substring(viewtag.length()-1, viewtag.length());
        int index = Integer.parseInt(viewtag.substring(0, viewtag.length()-1));
        if(value.equals("0")) {
            value = "1";
            ig.setTag(index+""+value);
            schedule.set(index, Integer.parseInt(value));
            if ((index % 24) == 0) {
                ig.setImageResource(R.drawable.make_time_start);

            } else if ((index % 24) == 23) {
                ig.setImageResource(R.drawable.make_time_end);

            } else {
                ig.setImageResource(R.drawable.make_time);

            }
        }

        else {
            value = "0";
            ig.setTag(index+""+value);
            schedule.set(index, Integer.parseInt(value));
            if ((index % 24) == 0) {
                ig.setImageResource(R.drawable.make_time_start_notouch);

            } else if ((index % 24) == 23) {

                ig.setImageResource(R.drawable.make_time_end_notouch);

            } else {

                ig.setImageResource(R.drawable.make_time_notouch);

            }
        }


    }

    @Override
    public void Drag_imagechange(View v, String viewtag) {
        ImageView ig = (ImageView) v;
        String value = viewtag.substring(viewtag.length()-1, viewtag.length());
        int index = Integer.parseInt(viewtag.substring(0, viewtag.length()-1));
        if(state == 1) {
            value = "1";
            ig.setTag(index+""+value);
            schedule.set(index, Integer.parseInt(value));
            if ((index % 24) == 0) {
                ig.setImageResource(R.drawable.make_time_start);
            } else if ((index % 24) == 23) {
                ig.setImageResource(R.drawable.make_time_end);
            } else {
                ig.setImageResource(R.drawable.make_time);
            }

        }
        else {
            value = "0";
            ig.setTag(index+""+value);
            schedule.set(index, Integer.parseInt(value));
            if ((index % 24) == 0) {
                ig.setImageResource(R.drawable.make_time_start_notouch);
            } else if ((index % 24) == 23) {
                ig.setImageResource(R.drawable.make_time_end_notouch);
            } else {
                ig.setImageResource(R.drawable.make_time_notouch);
            }
        }

    }


    public void save()
    {
        List<String> description = new ArrayList<String>();
        for(int i = 0; i < 168; i++)
        {

            description.add("초기값");
        }
        usecase = new Schedule_Save_UseCase(schedule, description, "pentel");


    }


    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
