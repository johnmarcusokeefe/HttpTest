package com.example.httptest;

import static com.example.httptest.R.id.block_list;

import android.app.Activity;
import android.content.Context;
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

    public BlockView() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_block_view);

        ListView listView = findViewById(block_list);
        //
        String url = "https://okka.com.au/driverlog_rest/blocks.php";
        // getters and setters are used to access the stream data
        Boolean flag = HttpStreamControl.httpRequest(url);
        //
        if(flag){
             // may have to check if returned
            JSONObject r = HttpStreamControl.getJsonResult();
            // returns json
            try {
                // jsonarray
                ArrayList<Block> blockList = new ArrayList<>();
                JSONArray blocks = r.getJSONArray("blocks");
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
                //

                BlockAdapter blockAdapter = new BlockAdapter(this, blockList);
                listView.setAdapter(blockAdapter);



            } catch (JSONException e) {
                e.printStackTrace();
            }
        }



    }

}
