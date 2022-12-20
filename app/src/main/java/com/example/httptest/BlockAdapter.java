package com.example.httptest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BlockAdapter extends ArrayAdapter<Block> {

    //private String[] localDataSet;
    private List<Block> localDataSet;


    public BlockAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }
}
