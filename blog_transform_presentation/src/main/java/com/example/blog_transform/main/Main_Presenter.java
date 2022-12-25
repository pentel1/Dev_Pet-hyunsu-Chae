package com.example.blog_transform.main;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.example.blog_transform.Main_Contract;
import com.example.blog_transform.R;
import com.example.blog_transform.teamroom.TeamRoomActivity;
import com.example.blog_transform_domain.Main_Domain.Schedule_Update_UseCase;

public class Main_Presenter  implements Main_Contract.Main_Presenter{

    Context context;
    Schedule_Update_UseCase usecase;

    public Main_Presenter(Context context) {
        this.context = context;
        this.usecase = new Schedule_Update_UseCase();
    }



    @Override
    public void RoomList_Touch() {
        Dialog make_room = new Dialog(context);       // Dialog 초기화
        make_room.requestWindowFeature(Window.FEATURE_NO_TITLE); // 타이틀 제거
        make_room.setContentView(R.layout.dialog_make_room);
        EditText editText = make_room.findViewById(R.id.dialog_make_room_name);
        Button button = make_room.findViewById(R.id.dialog_make_room_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, TeamRoomActivity.class);
                intent.putExtra("Roomname_key",editText.getText().toString());
                context.startActivity(intent);
                make_room.cancel();
            }
        });
        make_room.show();

    }

    @Override
    public void Make_Room(String roomname)
    {
        Intent intent = new Intent(context, TeamRoomActivity.class);
        intent.putExtra("Roomname_key", roomname);
        context.startActivity(intent);
    }


}
