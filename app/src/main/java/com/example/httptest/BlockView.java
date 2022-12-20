package com.example.httptest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class BlockView extends OptionsMenu {

    ListView listView;
    List<Block> blockList;
    Activity context;

    public BlockView() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_block_view);

        listView=(ListView)findViewById(R.id.block_list);
        BlockControl bc = new BlockControl();
        
        if(bc.flag){
             // may have to check if returned
            JSONObject r = HttpStreamControl.getJsonResult();
            // returns json
            try {
                // jsonarray
                blockList = new ArrayList<>();
                JSONArray blocks = r.getJSONArray("blocks");
                System.out.println("blockview " + blocks.length());
                int end = blocks.length();
                //
                String line;
                // this is creating the block objects from database
                for (int i = 0; i < end; i++) {
                    line = blocks.get(i).toString();
                    // jsonarrayline {"id":"1","date":"2022-11-01","job":"Job Identifier"}
                    JSONObject jsonLine = new JSONObject(line);
                    // create instance of block
                    // could bypass this? and create the view from this data
                    Block newBlock = new Block();
                    newBlock.setId(jsonLine.get("id").toString());
                    newBlock.setDate(jsonLine.get("date").toString());
                    newBlock.setJob(jsonLine.get("job").toString());
                    blockList.add(newBlock);
                }
                // ???
                ListView list;
                list=(ListView)findViewById(R.id.block_list);
                getView(0, list, listView);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }



    }
// example code takes black record and sets the text for one activity
    public View getView(int position, View view, ViewGroup parent){

        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.activity_block_view, null,true);

        TextView id = (TextView) view.findViewById(R.id.block_id);
        TextView date = (TextView) view.findViewById(R.id.block_id);
        TextView job = (TextView) view.findViewById(R.id.block_id);

        id.setText(blockList.get(position).getId());
        date.setText(blockList.get(position).getDate());
        job.setText(blockList.get(position).getJob());

        return rowView;

    }

}
