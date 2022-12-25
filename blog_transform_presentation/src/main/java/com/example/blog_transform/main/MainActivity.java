package com.example.blog_transform.main;


import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
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
import com.example.blog_transform_domain.Main_Domain.Schedule_Make_UseCase;
import com.example.blog_transform_domain.Main_Domain.Schedule_Save_UseCase;


import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements Main_Contract.Main_View {

    Main_Presenter presenter;

    RecyclerView room_list;
    RoomListAdapter room_adapter;
    List<String> room;

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

        room = new ArrayList<String>();
        room.add("테스트 용 더미 방");
        room.add("+");

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
                Intent intent = new Intent(getApplicationContext(), MakeActivity.class);
                mStartForResult.launch(intent);
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


    public void show_View(List<String> timelist) {
        ScheduleFragment scheduleFragment = new ScheduleFragment(timelist);
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
    public void update_Schedule() {
        Schedule_Save_UseCase usecase = new Schedule_Save_UseCase();
        Schedule_Make_UseCase make_useCase = new Schedule_Make_UseCase(usecase.getSchedule_data(), usecase.getDescription_data());
        List<String> timelist = make_useCase.getTimeList();

        show_View(timelist);
    }


    ActivityResultLauncher<Intent> mStartForResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                //result.getResultCode()를 통하여 결과값 확인
                if(result.getResultCode() == RESULT_OK) {
                    update_Schedule();
                }
            }
    );



}

