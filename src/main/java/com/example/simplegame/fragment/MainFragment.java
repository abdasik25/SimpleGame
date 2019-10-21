package com.example.simplegame.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.example.simplegame.R;
import com.example.simplegame.adapter.RecyclerListAdapter;
import com.example.simplegame.adapter.SimpleItemTouchHelperCallback;
import com.example.simplegame.adapter.Win;
import com.example.simplegame.layout.SpanningGridLayoutManager;

public class MainFragment extends Fragment {

    private ItemTouchHelper mItemTouchHelper;
    private Button restartButton;

    public MainFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        Win win = new Win() {
            @Override
            public void finishGame() {
                restartButton.setText("You won!");
                restartButton.setTextColor(Color.RED);
            }
        };

        final RecyclerListAdapter adapter = new RecyclerListAdapter(win);

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        restartButton = view.findViewById(R.id.restartButton);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new

                SpanningGridLayoutManager(this.getContext(), 3));
        ((AppCompatActivity)

                getActivity()).

                getSupportActionBar().

                hide();

        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(adapter);
        mItemTouchHelper = new

                ItemTouchHelper(callback);
        mItemTouchHelper.attachToRecyclerView(recyclerView);

        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (restartButton.getText().equals("You won!")) {
                    restartButton.setText("Restart");
                    restartButton.setTextColor(Color.BLACK);
                }
                adapter.reshuffle();
            }
        });

    }

}