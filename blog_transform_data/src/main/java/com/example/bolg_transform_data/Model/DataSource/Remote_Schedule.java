package com.example.bolg_transform_data.Model.DataSource;

import android.util.Log;

import androidx.annotation.NonNull;


import com.example.bolg_transform_data.Model.DataModel.Schedule_Entity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class Remote_Schedule {

    FirebaseFirestore db;
    String TAG = "테스트\t\t\t";


    public Remote_Schedule() {
        db = FirebaseFirestore.getInstance();
    }

    public Schedule_Entity getSchedule(String nickname){
        Task<DocumentSnapshot> task = null;

        DocumentReference st = db.collection(nickname).document("Schedule");
        task = st.get();
        while(!task.isComplete())
        {

        }
        Schedule_Entity schedule = task.getResult().toObject(Schedule_Entity.class);

        return schedule;
    }

    public void setSchedule(Schedule_Entity schedule , String nickname)
    {
        db.collection(nickname).document("Schedule").set(schedule).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Log.e(TAG, "데이터 저장 성공" + task.getResult());
            }
        });

    }

}
