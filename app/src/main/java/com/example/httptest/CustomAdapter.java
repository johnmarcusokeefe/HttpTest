package com.example.httptest;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    //private String[] localDataSet;
    private List<Block> localDataSet;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView id;
        private final TextView date;
        private final TextView job;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            id = (TextView) view.findViewById(R.id.block_id);
            date = (TextView) view.findViewById(R.id.block_id);
            job = (TextView) view.findViewById(R.id.block_id);
            //textView = (TextView) view.findViewById(R.id.textView);
        }

        public TextView getId() {
            return id;
        }

        public TextView getDate() {
            return date;
        }

        public TextView getJob() {
            return job;
        }
    }

    /**
     * Initialize the dataset of the Adapter
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView
     */
    public CustomAdapter(List<Block> dataSet) {
        localDataSet = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_block_view_item, parent, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        //viewHolder.getTextView().setText(localDataSet.indexOf("id"));
        
        viewHolder.getId().setText(localDataSet.indexOf("id"));
        viewHolder.getDate().setText(localDataSet.indexOf("date"));
        viewHolder.getJob().setText(localDataSet.indexOf("job"));

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
}
