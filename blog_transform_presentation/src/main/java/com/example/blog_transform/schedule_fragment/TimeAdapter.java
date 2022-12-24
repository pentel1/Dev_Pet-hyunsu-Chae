package com.example.blog_transform.schedule_fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.blog_transform.R;
import com.example.bolg_transform_data.Model.DataModel_example.Time;

import java.util.ArrayList;

public class TimeAdapter extends RecyclerView.Adapter<TimeAdapter.ViewHolder> {

    private ArrayList<Time> arraylist;

    public TimeAdapter(ArrayList<Time> arrayList) {
        this.arraylist = arrayList;
    }

    @NonNull
    @Override
    public TimeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.recycler_main_item_time, parent, false);
        TimeAdapter.ViewHolder vh = new TimeAdapter.ViewHolder(view);
        return vh;
    }


    @Override
    public void onBindViewHolder(@NonNull TimeAdapter.ViewHolder holder, int position) {
        holder.starttime.setText(arraylist.get(position).getStarttime());
        holder.swung.setText(arraylist.get(position).getSwung());
        holder.endtime.setText(arraylist.get(position).getEndtime());
    }

    @Override
    public int getItemCount() {
        return arraylist.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView starttime;
        TextView swung;
        TextView endtime;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            starttime = itemView.findViewById(R.id.starttime);
            swung = itemView.findViewById(R.id.swung);
            endtime = itemView.findViewById(R.id.endtime);

        }
    }
}