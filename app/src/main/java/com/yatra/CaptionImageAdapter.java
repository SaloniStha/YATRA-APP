package com.yatra;

import android.graphics.drawable.Drawable;
import android.location.GnssAntennaInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

public class CaptionImageAdapter extends RecyclerView.Adapter<CaptionImageAdapter.ViewHolder> {
    private String[] captions;
    private int[] imageIds;
    private Listener listener;

    public CaptionImageAdapter(String[] captions, int[] imageIds) {
        this.captions = captions;
        this.imageIds = imageIds;
    }

    interface Listener {
        void onClick(int position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;
        private Listener listener;

        interface Listener {
            void onClick(int position);
        }

        public ViewHolder(CardView v) {
            super(v);
            cardView = v;
        }
    }

    @NonNull
    @Override
    public CaptionImageAdapter.ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        CardView cardView= (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_place,parent,false);
        return new ViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
    CardView cardView=holder.cardView;
    ImageView imageView=cardView.findViewById(R.id.adv);
        Drawable drawable= ContextCompat.getDrawable(cardView.getContext(),imageIds[position]);
        imageView.setImageDrawable(drawable);
        TextView textView=cardView.findViewById(R.id.tadv);
        textView.setText(captions[position]);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listener!=null){
                    listener.onClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return captions.length;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }
}
