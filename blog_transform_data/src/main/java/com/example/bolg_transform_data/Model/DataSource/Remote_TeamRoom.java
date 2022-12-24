package com.example.bolg_transform_data.Model.DataSource;

import androidx.annotation.NonNull;

import com.example.bolg_transform_data.Model.DataModel.TeamRoom_Entity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

public class Remote_TeamRoom{

    FirebaseFirestore db;

    public Remote_TeamRoom() {
        db = FirebaseFirestore.getInstance();
    }


    public TeamRoom_Entity getRoomList(String nickname) {

        Task<DocumentSnapshot> task = null;

        DocumentReference st = db.collection(nickname).document("RoomID");
        task = st.get();
        while(!task.isComplete())
        {

        }
        TeamRoom_Entity roomlist = task.getResult().toObject(TeamRoom_Entity.class);

        return roomlist;
    }


    public void addRoomList(List<String> roomname, String nickname) {

        db.collection(nickname).document("RoomID").set(roomname).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

            }
        });

    }
}
