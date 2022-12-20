package com.example.httptest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class BlockAdapter extends ArrayAdapter<Block> {


    public BlockAdapter(@NonNull Context context, ArrayList<Block> block) {
        super(context, 0, block);
    }

    public View getView(int position, @Nullable View viewItem, @NonNull ViewGroup viewGroup) {

        if(viewItem==null){
            Block block = getItem(position);

            TextView id = viewItem.findViewById(R.id.block_id);
            TextView date = viewItem.findViewById(R.id.block_date);
            TextView job = viewItem.findViewById(R.id.block_job);

            id.setText(block.getId());
            date.setText(block.getDate());
            job.setText(block.getJob());
        }


        return viewItem;
    }
}
