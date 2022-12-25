package com.example.blog_transform.teamroom;


import android.os.Bundle;
import android.util.DisplayMetrics;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.blog_transform.R;

import com.example.blog_transform.schedule_fragment.ScheduleFragment;
import com.example.blog_transform_domain.Main_Domain.Schedule_Make_UseCase;
import com.example.blog_transform_domain.Main_Domain.Schedule_Save_UseCase;


import java.util.ArrayList;
import java.util.List;


public class TeamRoomActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private ScheduleFragment scheduleFragment;

    private RecyclerView chat_list;
    private TeamRoomAdapter teamRoomAdapter;

    private int state;
    private LinearLayout increase_layout;

    private LinearLayout first_message_layout;
    private LinearLayout teamroom_increase_layout;
    private FrameLayout teamroom_schedule;

    private Toolbar toolbar;
    private ImageView open;

    private LinearLayout.LayoutParams params_open;
    private LinearLayout.LayoutParams params_close;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teamroom);

        toolbar = findViewById(R.id.teamroom_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        open = toolbar.findViewById(R.id.teamroom_chat_open);

        TextView room_name = toolbar.findViewById(R.id.teamroom_room_name);
        String name = getIntent().getStringExtra("Roomname_key");
        room_name.setText(name);

        state = 0;

        Schedule_Save_UseCase save_useCase = new Schedule_Save_UseCase();


        if(save_useCase.getSchedule_data() != null)
        {
            Schedule_Make_UseCase make_useCase = new Schedule_Make_UseCase(save_useCase.getSchedule_data(), save_useCase.getDescription_data());
            scheduleFragment = new ScheduleFragment(make_useCase.getTimeList());
        }
        else
        {
            scheduleFragment = new ScheduleFragment();
        }

        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.teamroom_schedule, scheduleFragment).commitAllowingStateLoss();




        increase_layout = findViewById(R.id.teamroom_increase_layout);

        chat_list = findViewById(R.id.teamroom_chat_list);
        first_message_layout = findViewById(R.id.first_message_layout);




        DisplayMetrics metrics = getResources().getDisplayMetrics();
        int widthPixels = metrics.widthPixels;
        int heightPixels = metrics.heightPixels / 11 * 10;

        params_open = new LinearLayout.LayoutParams(widthPixels, heightPixels);
        params_close = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        chat_list.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, true));



        RecyclerView listview;
        List<String> increase_list = new ArrayList<String>();

        increase_list.add("팀원 리스트");

        TeamListAdapter adapter = new TeamListAdapter(increase_list);

        listview = findViewById(R.id.drawer_menulist) ;
        listview.setAdapter(adapter) ;

        listview.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));



        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(state==0) {

                    List<String> increase_list = new ArrayList<String>();

                    increase_list.add("테스트용 더미 텍스트");
                    increase_list.add("짧은 텍스트");
                    increase_list.add("긴 텍스트                                     ");
                    teamRoomAdapter = new TeamRoomAdapter(increase_list);
                    chat_list.setAdapter(teamRoomAdapter);






                    increase_layout.setLayoutParams(params_open);

                    teamroom_schedule = findViewById(R.id.teamroom_schedule);
                    teamroom_increase_layout = findViewById(R.id.teamroom_increase_layout);

                    teamroom_schedule.setVisibility(View.GONE);
                    first_message_layout.setVisibility(View.GONE);
                    teamroom_increase_layout.setVisibility(View.VISIBLE);


                    state = 1;
                }
                else
                {
                    teamroom_schedule.setVisibility(View.VISIBLE);
                    first_message_layout.setVisibility(View.VISIBLE);
                    teamroom_increase_layout.setVisibility(View.GONE);



                    increase_layout.setLayoutParams(params_close);
                    scheduleFragment = new ScheduleFragment();
                    fragmentManager = getSupportFragmentManager();

                    transaction = fragmentManager.beginTransaction();
                    transaction.replace(R.id.teamroom_schedule, scheduleFragment).commitAllowingStateLoss();


                    state = 0;

                }

            }
        });






    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.teamroom_toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.teamlist_open:


                DrawerLayout draw = findViewById(R.id.teamlist_layout);
                draw.openDrawer(GravityCompat.END);
                break;
            case android.R.id.home:
                if(state==1)
                {
                    teamroom_schedule.setVisibility(View.VISIBLE);
                    first_message_layout.setVisibility(View.VISIBLE);
                    teamroom_increase_layout.setVisibility(View.GONE);


                    increase_layout.setLayoutParams(params_close);
                    scheduleFragment = new ScheduleFragment();
                    fragmentManager = getSupportFragmentManager();

                    transaction = fragmentManager.beginTransaction();
                    transaction.replace(R.id.teamroom_schedule, scheduleFragment).commitAllowingStateLoss();


                    state = 0;
                }
                else
                {
                    finish();
                }

                break;

        }
        return super.onOptionsItemSelected(item);
    }


}
