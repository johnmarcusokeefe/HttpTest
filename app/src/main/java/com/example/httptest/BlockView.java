package com.example.httptest;

import android.os.Bundle;
import android.util.JsonReader;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;

public class BlockView extends OptionsMenu {

    private ResultParser rp;
    private JSONObject temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_block_view);

        BlockControl bc = new BlockControl();
        ListView l;


        if(bc.flag == true){
            HttpStreamControl hsc = new HttpStreamControl();
             // may have to check if returned
            JSONObject r = hsc.getJsonResult();
            System.out.println("blockview flag = true ");
            // returns json
            try {
                // jsonarray
                ArrayList<String> al = new ArrayList<String>();
                JSONArray blocks = r.getJSONArray("blocks");
                System.out.println("blockview " + blocks.length());
                int end = blocks.length();
                //
                String line = null;
                for (int i = 0; i < end; i++) {
                    line = blocks.get(i).toString();
                    System.out.println("jsonarrayline "+ line);
                    JSONObject temp = new JSONObject(line);
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
                        new ArrayAdapter<String>(this, R.layout.simplerow, al);
                ListView blocklist = (ListView) findViewById(R.id.block_list);
                blocklist.setAdapter(listAdapter);
                
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }



    }

}
