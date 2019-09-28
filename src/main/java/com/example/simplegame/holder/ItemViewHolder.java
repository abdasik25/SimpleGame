package com.example.simplegame.holder;

import android.view.View;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.simplegame.R;

public class ItemViewHolder extends RecyclerView.ViewHolder {

   // public final ImageView handleView;
   // public final TextView textView;
    public final ImageView imageView;

    public ItemViewHolder(View itemView) {
        super(itemView);
      //  handleView = itemView.findViewById(R.id.handle);
        //itemView = imageView.findViewById(R.id.)
        imageView = itemView.findViewById(R.id.text);
    }

}
