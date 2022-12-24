package com.example.blog_transform.make;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.Log;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.blog_transform.R;
import com.example.bolg_transform_data.Model.DataModel_example.Make;

import java.util.ArrayList;
import java.util.List;

public class MakeAdapter extends RecyclerView.Adapter<MakeAdapter.ViewHolder> {

    private ArrayList<Make> arraylist;
    private Context context;
    static List<Integer> schedule;
    Make_Presenter presenter;


    public MakeAdapter(ArrayList<Make> arrayList, List<Integer> schedule) {
        this.arraylist = arrayList;
        this.schedule = schedule;
        presenter = new Make_Presenter(schedule);
    }

    @NonNull
    @Override
    public MakeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        View view = inflater.inflate(R.layout.recycler_make_item_schedule, parent, false);
        MakeAdapter.ViewHolder vh = new MakeAdapter.ViewHolder(view);
        return vh;
    }


    @Override
    public void onBindViewHolder(@NonNull MakeAdapter.ViewHolder holder, int position) {

        holder.day.setText(arraylist.get(position).getText());

        for (int i = 0; i < 24; i++) {
            holder.image[i].setTag(((position*24)+i)+"0");
            holder.image[i].setImageResource(arraylist.get(position).getImage()[i]);
            holder.image[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    presenter.imagechange(view, view.getTag() + "");
                }
            });

            holder.image[i].setOnDragListener(new DragListener());
            holder.image[i].setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {

                    ClipData.Item item = new ClipData.Item(
                            (CharSequence) view.getTag());

                    String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};
                    ClipData data = new ClipData(view.getTag() + "",
                            mimeTypes, item);
                    CustomShodowBuilder shadowBuilder = new CustomShodowBuilder(
                            view);


                    presenter.imagechange(view, view.getTag()+"");

                    view.startDragAndDrop(data, shadowBuilder, view, 0);

                    return false;
                }

            });
        }


    }

    @Override
    public int getItemCount() {
        return arraylist.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView day;
        ImageView image[];


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            day = itemView.findViewById(R.id.make_day);
            image = new ImageView[24];
            image[0] = itemView.findViewById(R.id.time_9_00);
            image[1] = itemView.findViewById(R.id.time_9_30);

            image[2] = itemView.findViewById(R.id.time_10_00);
            image[3] = itemView.findViewById(R.id.time_10_30);

            image[4] = itemView.findViewById(R.id.time_11_00);
            image[5] = itemView.findViewById(R.id.time_11_30);

            image[6] = itemView.findViewById(R.id.time_12_00);
            image[7] = itemView.findViewById(R.id.time_12_30);

            image[8] = itemView.findViewById(R.id.time_13_00);
            image[9] = itemView.findViewById(R.id.time_13_30);

            image[10] = itemView.findViewById(R.id.time_14_00);
            image[11] = itemView.findViewById(R.id.time_14_30);

            image[12] = itemView.findViewById(R.id.time_15_00);
            image[13] = itemView.findViewById(R.id.time_15_30);

            image[14] = itemView.findViewById(R.id.time_16_00);
            image[15] = itemView.findViewById(R.id.time_16_30);

            image[16] = itemView.findViewById(R.id.time_17_00);
            image[17] = itemView.findViewById(R.id.time_17_30);

            image[18] = itemView.findViewById(R.id.time_18_00);
            image[19] = itemView.findViewById(R.id.time_18_30);

            image[20] = itemView.findViewById(R.id.time_19_00);
            image[21] = itemView.findViewById(R.id.time_19_30);

            image[22] = itemView.findViewById(R.id.time_20_00);
            image[23] = itemView.findViewById(R.id.time_20_30);


        }
    }



    class DragListener implements View.OnDragListener {
        public boolean onDrag(View v, DragEvent event) {

            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    break;
                case DragEvent.ACTION_DRAG_ENTERED:
                    presenter.Drag_imagechange(v, v.getTag()+"");
                    break;
                case DragEvent.ACTION_DROP:

                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    break;
                case DragEvent.ACTION_DRAG_ENDED:
                default:
                    break;
            }
            return true;
        }

    }

    class CustomShodowBuilder extends View.DragShadowBuilder {

        int mWidth, mHeight;

        public CustomShodowBuilder(View v) {
            super(v);

            mWidth = v.getWidth();
            mHeight = v.getHeight();

        }

        public void onProvideShadowMetrics(Point outShadowSize, Point outShadowTouchPoint) {
            outShadowSize.set(mWidth, mHeight);
            outShadowTouchPoint.set(mWidth, mHeight);

        }

        public void onDrawShadow(Canvas canvas) {
            Paint p = new Paint();
            p.setColor(Color.RED);
            canvas.drawRect(0, 0, 0, 0, p);


        }

    }
}

