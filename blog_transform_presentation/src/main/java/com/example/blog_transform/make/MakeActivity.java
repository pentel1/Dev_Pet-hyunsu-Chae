package com.example.blog_transform.make;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.blog_transform.R;
import com.example.blog_transform_domain.Main_Domain.Schedule_Save_UseCase;
import com.example.bolg_transform_data.Model.DataModel_example.Make;
import java.util.ArrayList;
import java.util.List;


public class MakeActivity extends AppCompatActivity {


        RecyclerView make_schedule;
        MakeAdapter make_adapter;

        List<Integer> schedule;
        Schedule_Save_UseCase save;
        //Make_Presenter presenter;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_make_fixed_schedule);

            Toolbar toolbar = findViewById(R.id.make_toolbar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);


            schedule = new ArrayList<Integer>();


            make_schedule = (RecyclerView) findViewById(R.id.make_schedule);

            ArrayList<Make> list = new ArrayList<Make>();
            int image[] = new int[24];

            for(int i = 0; i < 24; i++)
            {
                if( i == 0)
                {
                    image[i] = R.drawable.make_time_start_notouch;

                }
                else if(i == 23)
                {
                    image[i] = R.drawable.make_time_end_notouch;
                }
                else
                {
                    image[i] = R.drawable.make_time_notouch;
                }


            }
            list.add(new Make("월", image));
            list.add(new Make("화", image));
            list.add(new Make("수", image));
            list.add(new Make("목", image));
            list.add(new Make("금", image));
            list.add(new Make("토", image));
            list.add(new Make("일", image));


            /* initiate adapter */
            make_adapter = new MakeAdapter(list, schedule);

            /* initiate recyclerview */
            make_schedule.setAdapter(make_adapter);


            make_schedule.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));


        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.make_toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_save:
                //presenter.save();

                break;
            case android.R.id.home:
                finish();

                break;

        }
        return super.onOptionsItemSelected(item);
    }








}
