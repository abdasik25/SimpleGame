package com.example.simplegame.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.simplegame.R;
import com.example.simplegame.util.GridMapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RecyclerListAdapter extends RecyclerView.Adapter<RecyclerListAdapter.ItemViewHolder> implements ItemTouchHelperAdapter {

    private static final String[] STRINGS = new String[]{
            "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"
    };

    private static List<Integer> INDEXES;

    private ItemViewHolder greenCell;

    private final List<String> mItems;

    public RecyclerListAdapter() {
        INDEXES = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            INDEXES.add(i, i);
        }
        mItems = new ArrayList<>();
        mItems.addAll(Arrays.asList(STRINGS));
        Collections.shuffle(INDEXES);
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main, parent,
                false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        if (position == 8) {
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
             Collections.swap(mItems, fromPosition, toPosition);
           notifyItemMoved(fromPosition, toPosition);
           }
       else {
           Collections.swap(mItems, toPosition, fromPosition);
           notifyItemMoved(toPosition, fromPosition);
       }
//        } else {
//            for (int i = fromPosition; i > toPosition; i--) {
//                Collections.swap(mItems, i, i - 1);
//            }
//        }

    //    Collections.swap(mItems, fromPosition, toPosition);
       // notifyDataSetChanged();
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
