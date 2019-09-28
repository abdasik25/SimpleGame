package com.example.simplegame.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.simplegame.R;
import com.example.simplegame.holder.ItemViewHolder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RecyclerListAdapter extends RecyclerView.Adapter<ItemViewHolder> implements ItemTouchHelperAdapter {

    private static final String[] STRINGS = new String[]{
            "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"
    };


    private final List<String> mItems = new ArrayList<>();

    public RecyclerListAdapter() {
        mItems.addAll(Arrays.asList(STRINGS));
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        switch (position) {
            case 0:
                holder.imageView.setImageResource(R.drawable.image_part_001);
                break;
            case 1:
                holder.imageView.setImageResource(R.drawable.image_part_002);
                break;
            case 2:
                holder.imageView.setImageResource(R.drawable.image_part_003);
                break;
            case 3:
                holder.imageView.setImageResource(R.drawable.image_part_004);
                break;
            case 4:
                holder.imageView.setImageResource(R.drawable.image_part_005);
                break;
            case 5:
                holder.imageView.setImageResource(R.drawable.image_part_006);
                break;
            case 6:
                holder.imageView.setImageResource(R.drawable.image_part_007);
                break;
            case 7:
                holder.imageView.setImageResource(R.drawable.image_part_008);
                break;
            case 8:
                holder.imageView.setImageResource(R.drawable.image_part_009);
                break;
            default:
                holder.imageView.setImageResource(R.drawable.ic_launcher_background);
                break;
        }

    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    @Override
    public void onItemDismiss(int position) {
        mItems.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        if (fromPosition < toPosition) {
            for (int i = fromPosition; i < toPosition; i++) {
                Collections.swap(mItems, i, i + 1);
            }
        } else {
            for (int i = fromPosition; i > toPosition; i--) {
                Collections.swap(mItems, i, i - 1);
            }
        }
        notifyItemMoved(fromPosition, toPosition);
    }

}
