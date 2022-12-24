package com.example.blog_transform.main;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.blog_transform.R;
import com.example.blog_transform.teamroom.TeamRoomActivity;
import com.example.bolg_transform_data.Model.DataModel_example.RoomList;

import java.util.ArrayList;

public class RoomListAdapter extends RecyclerView.Adapter<RoomListAdapter.ViewHolder>{

    private ArrayList<RoomList> arraylist;
    private Context context;

    public RoomListAdapter(ArrayList<RoomList> arrayList) {
        this.arraylist = arrayList;
    }

    @NonNull
    @Override
    public RoomListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.recycler_main_item_room, parent, false);
        RoomListAdapter.ViewHolder vh = new RoomListAdapter.ViewHolder(view);
        return vh;
    }


    @Override
    public void onBindViewHolder(@NonNull RoomListAdapter.ViewHolder holder, int position) {
        if(arraylist.get(position).getText().equals("+"))
        {
            holder.name.setText(arraylist.get(position).getText());
            holder.name.setTextSize(Dimension.SP,50);
            holder.name.setTextColor(Color.parseColor("#FFBE00"));
            holder.name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


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
            });
        }
        else
        {
            holder.name.setText(arraylist.get(position).getText());
            holder.name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, TeamRoomActivity.class);
                    intent.putExtra("Roomname_key",holder.name.getText());
                    context.startActivity(intent);
                }
            });
        }



    }

    @Override
    public int getItemCount() {
        return arraylist.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        Button name;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.roomname);


        }
    }
}
