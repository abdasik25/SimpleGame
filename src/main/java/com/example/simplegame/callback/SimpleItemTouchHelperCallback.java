package com.example.simplegame.callback;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.example.simplegame.adapter.ItemTouchHelperAdapter;


public class SimpleItemTouchHelperCallback extends ItemTouchHelper.Callback {

    //enable drag after long press
    private static final boolean IS_LONG_PRESS_DRAG_ENABLED = true;
    //enable swipe after touch wherever in view
    private static final boolean IS_ITEM_VIEW_SWIPE_ENABLED = true;

    private final ItemTouchHelperAdapter mAdapter;

    public SimpleItemTouchHelperCallback(ItemTouchHelperAdapter adapter) {
        mAdapter = adapter;
    }


    @Override
    public int getMovementFlags(@NonNull RecyclerView recyclerView,
                                @NonNull RecyclerView.ViewHolder viewHolder) {
        int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        int swipeFlags = ItemTouchHelper.START | ItemTouchHelper.END;
        return makeMovementFlags(dragFlags, swipeFlags);
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder,
                          RecyclerView.ViewHolder target) {
        mAdapter.onItemMove(viewHolder.getAdapterPosition(), target.getAdapterPosition());
        return true;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        mAdapter.onItemDismiss(viewHolder.getAdapterPosition());
    }

    @Override
    public boolean isLongPressDragEnabled() {
        return IS_LONG_PRESS_DRAG_ENABLED;
    }

    @Override
    public boolean isItemViewSwipeEnabled() {
        return IS_ITEM_VIEW_SWIPE_ENABLED;
    }
}
