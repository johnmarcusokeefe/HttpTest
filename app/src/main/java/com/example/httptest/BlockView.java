package com.example.httptest;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

public class BlockView extends OptionsMenu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_block_view);

        BlockControl bc = new BlockControl();
        // update to recyclerview

        if(bc.flag){

             // may have to check if returned
            JSONObject r = HttpStreamControl.getJsonResult();
            System.out.println("blockview flag = true ");
            // returns json
            try {
                // jsonarray
                ArrayList<String> al = new ArrayList<>();
                JSONArray blocks = r.getJSONArray("blocks");
                System.out.println("blockview " + blocks.length());
                int end = blocks.length();
                //
                String line;
                for (int i = 0; i < end; i++) {
                    line = blocks.get(i).toString();
                    System.out.println("jsonarrayline "+ line);
                    //JSONObject temp = new JSONObject(line);
                    // produces a set of keys
//                    Iterator keys = temp.keys();
//                    while (keys.hasNext()){
//                        System.out.println("temp keys "+ keys.next().toString());
//                    }
                    //System.out.println("jsonarraydate "+ temp.get("date"));
                    al.add(line);
                }

                System.out.println("arraylist blockview "+ al);
                ArrayAdapter<String> listAdapter =
                        new ArrayAdapter<>(this, R.layout.simplerow, al);
                ListView blocklist = findViewById(R.id.block_list);
                blocklist.setAdapter(listAdapter);
                
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }



    }

}
