package com.example.blog_transform.teamroom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.blog_transform.R;
import com.example.bolg_transform_data.Model.DataModel_example.TeamList;

import java.util.ArrayList;

public class TeamListAdapter extends RecyclerView.Adapter<TeamListAdapter.ViewHolder> {

    private ArrayList<TeamList> arraylist;
    public TeamListAdapter(ArrayList<TeamList> arrayList) {
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
        holder.name.setText(arraylist.get(position).getName());




    }

    @Override
    public int getItemCount() {
        return arraylist.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.teamroom_teamlist);


        }
    }
}

