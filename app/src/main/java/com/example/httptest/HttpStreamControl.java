package com.example.httptest;

import org.json.JSONObject;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class HttpStreamControl extends Thread {

    private static String POST_DATA;
    private static String url_string;
    private static URL url;
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
        System.out.println("httpstreamget token "+token);
        POST_DATA = ("token="+token);
        url_string = url_in;
        HttpStreamControl thread = new HttpStreamControl();
        thread.start();
        while(thread.isAlive()){
            System.out.println("getting data");
        }
        return true;
    }

    public void run() {
        try {
            System.out.println("run "+url_string);
            url = new URL(url_string);
            httpConnection = (HttpsURLConnection) url.openConnection();
            httpConnection.setRequestMethod("POST");
            httpConnection.setDoOutput(true);
            // write to connection
            httpConnection.getOutputStream().write(POST_DATA.getBytes());
            httpConnection.getOutputStream().flush();
            httpConnection.getOutputStream().close();
            // get response
            InputStream in = new BufferedInputStream(httpConnection.getInputStream());
            // parses the data

            lr = new ResultParser();
            JSONObject object = lr.resultParser(in);
            System.out.println("httpstream "+lr);

            setJsonResult(object);

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            httpConnection.disconnect();
        }
    }


    }


