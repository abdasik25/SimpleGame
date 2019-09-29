package com.example.simplegame.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.simplegame.R;
import com.example.simplegame.util.GridMapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecyclerListAdapter extends RecyclerView.Adapter<RecyclerListAdapter.ItemViewHolder> implements ItemTouchHelperAdapter {

    private static List<Integer> INDEXES;

    private ItemViewHolder greenCell;

    public RecyclerListAdapter() {
        INDEXES = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            INDEXES.add(i, i);
        }
        Collections.shuffle(INDEXES);
        INDEXES.add(8);
    }

    public static void setINDEXES(List<Integer> INDEXES) {
        RecyclerListAdapter.INDEXES = INDEXES;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main, parent,
                false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        if (INDEXES.get(position) == 8) {
            greenCell = holder;
            holder.imageView.setImageResource(R.drawable.ic_launcher_background);
        } else {
            switch (INDEXES.get(position)) {
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
            }
        }

        if (INDEXES.get(position) != null && INDEXES.get(position) == (INDEXES.get(position) + 1)) {

        }
    }

    @Override
    public int getItemCount() {
        return INDEXES.size();
    }

    @Override
    public void onItemDismiss(int position) {
        notifyItemRemoved(position);
    }

    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        Collections.swap(INDEXES, fromPosition, toPosition);
        notifyDataSetChanged();

    }

    public void reshuffle() {

        List NEW_INDEXES = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            NEW_INDEXES.add(i, i);
        }
        Collections.shuffle(NEW_INDEXES);
        NEW_INDEXES.add(8);
        setINDEXES(NEW_INDEXES);
        notifyDataSetChanged();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;

        ItemViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
        }

        int makeDragFlags() {
            return GridMapper.isNeighbour(this.getAdapterPosition(), greenCell.getAdapterPosition());
        }
    }
}