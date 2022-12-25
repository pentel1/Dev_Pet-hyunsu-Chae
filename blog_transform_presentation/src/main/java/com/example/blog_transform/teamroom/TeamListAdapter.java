package com.example.blog_transform.teamroom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.blog_transform.R;

import java.util.List;

public class TeamListAdapter extends RecyclerView.Adapter<TeamListAdapter.ViewHolder> {

    private List<String> arraylist;
    public TeamListAdapter(List<String> arrayList) {
        this.arraylist = arrayList;
    }

    @NonNull
    @Override
    public TeamListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.recycler_teamroom_item_teamlist, parent, false);
        TeamListAdapter.ViewHolder vh = new TeamListAdapter.ViewHolder(view);
        return vh;
    }


    @Override
    public void onBindViewHolder(@NonNull TeamListAdapter.ViewHolder holder, int position) {
        holder.name.setText(arraylist.get(position));




    }

    @Override
    public int getItemCount() {
        return arraylist.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        RadioButton name;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.radioButton);


        }
    }
}

