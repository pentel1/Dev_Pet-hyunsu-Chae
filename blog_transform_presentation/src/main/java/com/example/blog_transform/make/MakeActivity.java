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
import java.util.ArrayList;
import java.util.List;


public class MakeActivity extends AppCompatActivity {


        RecyclerView make_schedule;
        MakeAdapter make_adapter;

        List<Integer> schedule;
        Make_Presenter presenter;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_make_fixed_schedule);

            Toolbar toolbar = findViewById(R.id.make_toolbar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            schedule = new ArrayList<Integer>();
            presenter = new Make_Presenter(schedule);
            make_schedule = (RecyclerView) findViewById(R.id.make_schedule);


            ArrayList<String> list = new ArrayList<String>();
            ArrayList<Integer> image = new ArrayList<Integer>();

            for(int i = 0; i < 168; i++)
            {
                schedule.add(0);
            }

            for(int i = 0; i < 24; i++)
            {

                if( i == 0)
                {
                    image.add(R.drawable.make_time_start_notouch);

                }
                else if(i == 23)
                {
                    image.add(R.drawable.make_time_end_notouch);
                }
                else
                {
                    image.add(R.drawable.make_time_notouch);
                }


            }
            list.add("월");
            list.add("화");
            list.add("수");
            list.add("목");
            list.add("금");
            list.add("토");
            list.add("일");



            /* initiate adapter */
            make_adapter = new MakeAdapter(list, image, schedule);

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
                presenter.save();
                setResult(RESULT_OK);
                finish();
                break;
            case android.R.id.home:
                setResult(RESULT_CANCELED);
                finish();

                break;

        }
        return super.onOptionsItemSelected(item);
    }








}
