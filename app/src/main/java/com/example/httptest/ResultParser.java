package com.example.httptest;

import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ResultParser {

    // result parser json
    public JSONObject resultParser(InputStream in) throws IOException, JSONException {

        BufferedReader json = new BufferedReader(new InputStreamReader(in));
        JSONObject object = new JSONObject(json.readLine());
        json.close();
        
        return object;
    }

}
