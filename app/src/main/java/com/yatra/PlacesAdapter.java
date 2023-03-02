package com.yatra;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PlacesAdapter extends RecyclerView.Adapter<PlacesAdapter.viewHolder> {
    ArrayList<Places> list;
    Context context;

    public static void filterList(List<Places> filteredList) {
    }

    /*public void FilteredList(List<PlacesModel> filteredList) {
        this.list = (ArrayList<PlacesModel>) filteredList;
        notifyDataSetChanged();
    }*/

    public PlacesAdapter(ArrayList<Places> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_place, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Places model = list.get(position);
        holder.imageView.setImageResource(model.getPic());
        holder.textView.setText(model.getText());


        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,DetailsActivity.class);
                intent.putExtra("ImageName",model.getPic());
                intent.putExtra("header",model.getText());
                intent.putExtra("desc",model.getDesc());
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {

        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.adv);
            textView = itemView.findViewById(R.id.tadv);

        }

        class ItemViewHolder extends RecyclerView.ViewHolder {

            private CardView cardView;


            public ItemViewHolder(@NonNull View itemView) {
                super(itemView);

                cardView = itemView.findViewById(R.id.cardview);

            }
        }
    }
}