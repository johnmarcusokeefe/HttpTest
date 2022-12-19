package com.example.httptest;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class BlockView extends OptionsMenu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_block_view);

        BlockControl bc = new BlockControl();
        
        if(bc.flag){
             // may have to check if returned
            JSONObject r = HttpStreamControl.getJsonResult();
            // returns json
            try {
                // jsonarray
                List<Block> blockItem = new ArrayList<>();
                JSONArray blocks = r.getJSONArray("blocks");
                System.out.println("blockview " + blocks.length());
                int end = blocks.length();
                //
                String line;
                for (int i = 0; i < end; i++) {
                    line = blocks.get(i).toString();
                    // jsonarrayline {"id":"1","date":"2022-11-01","job":"Job Identifier"}
                    JSONObject jsonLine = new JSONObject(line);
                    // create instance of block
                    Block newBlock = new Block();
                    newBlock.setId(jsonLine.get("id").toString());
                    newBlock.setDate(jsonLine.get("date").toString());
                    newBlock.setJob(jsonLine.get("job").toString());
                    blockItem.add(newBlock);
                }
                //
                
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }



    }

}
