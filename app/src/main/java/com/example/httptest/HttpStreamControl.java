package com.example.httptest;

import org.json.JSONObject;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class HttpStreamControl extends Thread {

    private static String POST_DATA;
    private static String url_string;
    private HttpsURLConnection httpConnection;
    ResultParser lr;
    private static JSONObject jsonResult;
    //
    public static JSONObject getJsonResult() {
        return jsonResult;
    }
    //
    public static void setJsonResult(JSONObject jsonResult) {
        HttpStreamControl.jsonResult = jsonResult;
    }

    public static Boolean httpRequest(String url_in) {
        LoginControl lc = new LoginControl();
        String token = lc.get_token();
        POST_DATA = ("token="+token);
        url_string = url_in;
        HttpStreamControl thread = new HttpStreamControl();
        thread.start();
//        while(thread.isAlive()){
//            System.out.println("getting data");
//        }
        System.out.println("exit while");
        return true;
    }

    public void run() {
        try {
            URL url = new URL(url_string);
            httpConnection = (HttpsURLConnection) url.openConnection();
            httpConnection.setRequestMethod("POST");
            httpConnection.setDoOutput(true);
            // write to connection
            httpConnection.getOutputStream().write(POST_DATA.getBytes());
            httpConnection.getOutputStream().flush();
            httpConnection.getOutputStream().close();
            // get response
            InputStream in = new BufferedInputStream(httpConnection.getInputStream());

                BufferedReader rawJson = new BufferedReader(new InputStreamReader(in));
                JSONObject object = new JSONObject(rawJson.readLine());
                rawJson.close();
                setJsonResult(object);

        } catch (Exception e) {

            e.printStackTrace();

        }
        finally {
            httpConnection.disconnect();
            currentThread().interrupt();

        }
    }


    }


