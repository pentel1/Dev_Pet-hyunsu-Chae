package com.example.blog_transform.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;


import com.example.blog_transform.Main_Contract;
import com.example.blog_transform.R;
import com.example.blog_transform.make.MakeActivity;
import com.example.blog_transform.schedule_fragment.ScheduleFragment;
import com.example.bolg_transform_data.Model.DataModel_example.RoomList;
import com.example.bolg_transform_data.Model.DataSource.Remote_Schedule;


import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements Main_Contract.Main_View {

    Main_Presenter presenter;

    RecyclerView room_list;
    RoomListAdapter room_adapter;
    ArrayList<RoomList> room;

    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new Main_Presenter(this);

        init();

    }

    private void init()
    {
        Toolbar toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);

        room_list = (RecyclerView) findViewById(R.id.room_list);


        //room = presenter.getRoomList_Data();
        room = new ArrayList<RoomList>();
        room.add(new RoomList("방 이름"));
        room.add(new RoomList("스마일게이트 윈터 데브 캠프 팀 dev_pet"));
        room.add(new RoomList("테스트용으로 진짜 긴 방 제목이 필요해요 띄어쓰기도없이넘겨볼게요."));
        room.add(new RoomList("테스트용으로 진짜 긴 방 제목이 필요해요 띄어쓰기도없이넘겨볼게요."));
        room.add(new RoomList("테스트용으로 진짜 긴 방 제목이 필요해요 띄어쓰기도없이넘겨볼게요."));
        room.add(new RoomList("+"));

        show_View();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_make:
                /*
                Dialog select_schedule = new Dialog(this);       // Dialog 초기화
                select_schedule.requestWindowFeature(Window.FEATURE_NO_TITLE); // 타이틀 제거
                select_schedule.setContentView(R.layout.dialog_select_schedule);
                select_schedule.show();

                ImageView schedule = select_schedule.findViewById(R.id.select_schedule);
                ImageView calender = select_schedule.findViewById(R.id.select_calender);

                 */




                Intent intent = new Intent(getApplicationContext(), MakeActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void show_View() {
        ScheduleFragment scheduleFragment = new ScheduleFragment();
        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.main_shedule, scheduleFragment).commitAllowingStateLoss();

        room_adapter = new RoomListAdapter(room);
        room_list.setAdapter(room_adapter);
        room_list.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));

    }

    @Override
    public void update_RoomList() {

    }


    @Override
    public void update_Fragment() {

    }


}

