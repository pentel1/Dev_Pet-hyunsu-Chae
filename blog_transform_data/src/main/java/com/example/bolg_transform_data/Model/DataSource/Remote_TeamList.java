package com.example.bolg_transform_data.Model.DataSource;

import androidx.annotation.NonNull;

import com.example.bolg_transform_data.Model.DataModel.Schedule_Entity;
import com.example.bolg_transform_data.Model.DataModel.TeamList_Entity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

public class Remote_TeamList {

    FirebaseFirestore db;

    public Remote_TeamList() {
        db = FirebaseFirestore.getInstance();
    }


    public TeamList_Entity getTeamList(String roomname){
        Task<DocumentSnapshot> task = null;

        DocumentReference st = db.collection("Chat_Room").document(roomname);
        task = st.get();
        while(!task.isComplete())
        {

        }
        TeamList_Entity teamlist = task.getResult().toObject(TeamList_Entity.class);

        return teamlist;
    }

    public void addTeamList(TeamList_Entity teamlist, String roomname) {

        db.collection("Chat_Room").document(roomname).set(teamlist).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

            }
        });

    }

}
