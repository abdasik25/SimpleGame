package com.example.simplegame.holder;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.simplegame.R;

public class ItemViewHolder extends RecyclerView.ViewHolder {

   // public final ImageView handleView;
    public final TextView textView;

    public ItemViewHolder(View itemView) {
        super(itemView);
      //  handleView = itemView.findViewById(R.id.handle);
        textView = itemView.findViewById(R.id.text);
    }

}
