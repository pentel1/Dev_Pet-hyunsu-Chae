package com.example.blog_transform.teamroom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;

import androidx.recyclerview.widget.RecyclerView;

import com.example.blog_transform.R;

import java.util.List;

public class TeamRoomAdapter extends RecyclerView.Adapter<TeamRoomAdapter.ViewHolder> {

    private List<String> arraylist;
    boolean flag = true;
    public TeamRoomAdapter(List<String> arrayList) {
        this.arraylist = arrayList;
    }

    @NonNull
    @Override
    public TeamRoomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.recycler_teamroom_item_chatlist, parent, false);
        TeamRoomAdapter.ViewHolder vh = new TeamRoomAdapter.ViewHolder(view);
        return vh;
    }


    @Override
    public void onBindViewHolder(@NonNull TeamRoomAdapter.ViewHolder holder, int position) {
        holder.text.setText(arraylist.get(position));

        if(flag)
        {
            holder.text.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_START);
            ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.MATCH_PARENT);

            params.startToStart = ConstraintLayout.LayoutParams.PARENT_ID;
            params.bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID;
            params.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;
            params.endToEnd = ConstraintLayout.LayoutParams.START;
            holder.text.setLayoutParams(params);
            flag = false;
        }
        else
        {
            holder.text.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_END);
            ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.MATCH_PARENT);

            params.bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID;
            params.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;
            params.endToEnd = ConstraintLayout.LayoutParams.PARENT_ID;
            params.startToStart = ConstraintLayout.LayoutParams.END;


            holder.text.setLayoutParams(params);
            flag = true;
        }
        //ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT,ConstraintLayout.LayoutParams.WRAP_CONTENT);




    }

    @Override
    public int getItemCount() {
        return arraylist.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView text;
        ConstraintLayout chat_layout_move;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            text = itemView.findViewById(R.id.chat_list);
            chat_layout_move = itemView.findViewById(R.id.chat_layout);


        }
    }
}
