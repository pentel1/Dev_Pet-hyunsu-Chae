package com.example.bolg_transform_data.Model.DataSource;

import androidx.annotation.NonNull;

import com.example.bolg_transform_data.Model.DataModel.Schedule_Entity;
import com.example.bolg_transform_data.Model.DataModel.TeamChat_Entity;
import com.example.bolg_transform_data.Model.DataModel.TeamList_Entity;
import com.example.bolg_transform_data.Model.DataModel.TeamRoom_Entity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class Remote_TeamChat {

    FirebaseFirestore db;

    public Remote_TeamChat() {
        db = FirebaseFirestore.getInstance();
    }

    public TeamChat_Entity getTeamChat(String roomname, String nickname)
    {
        Task<DocumentSnapshot> task = null;

        DocumentReference st = db.collection("Chat_Room").document(roomname).collection(nickname).document();
        task = st.get();
        while(!task.isComplete())
        {

        }
        TeamChat_Entity chatlist = task.getResult().toObject(TeamChat_Entity.class);

        return chatlist;

    }

    public void setTeamChat(TeamChat_Entity chatlist, String roomname, String nickname, TeamList_Entity teamlist)
    {
        for(int i = 0; i < teamlist.getTeamlist().size(); i++)
        {
            db.collection("Chat_Room").document(roomname).collection(nickname).document(teamlist.getTeamlist().get(i)).set(chatlist).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {

                }
            });
        }



    }

}
