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

import java.util.List;

public class RoomListAdapter extends RecyclerView.Adapter<RoomListAdapter.ViewHolder>{

    private List<String> arraylist;
    private Context context;
    private Main_Presenter presenter;

    public RoomListAdapter(List<String> arrayList) {
        this.arraylist = arrayList;

    }

    @NonNull
    @Override
    public RoomListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        presenter = new Main_Presenter(context);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.recycler_main_item_room, parent, false);
        RoomListAdapter.ViewHolder vh = new RoomListAdapter.ViewHolder(view);
        return vh;
    }


    @Override
    public void onBindViewHolder(@NonNull RoomListAdapter.ViewHolder holder, int position) {
        if(arraylist.get(position).equals("+"))
        {
            holder.name.setText(arraylist.get(position));
            holder.name.setTextSize(Dimension.SP,50);
            holder.name.setTextColor(Color.parseColor("#FFBE00"));
            holder.name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    presenter.RoomList_Touch();
                }
            });
        }
        else
        {
            holder.name.setText(arraylist.get(position));
            holder.name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    presenter.Make_Room(holder.name.getText()+"");
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
