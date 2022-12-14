package com.example.httptest;

import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public class LoginControl extends Thread {

    private static String POST_DATA;
    private static String url_string;
    private static String token = null;
    private static String username = null;
    HttpStreamControl hsc = new HttpStreamControl();

    public static void apiRequest(String user, String password) {
        POST_DATA = ("user="+user+"&password="+password);
        url_string = "https://okka.com.au/driverlog_rest/index.php";;
        LoginControl thread = new LoginControl();
        thread.start();
    }

    public static void set_token(String tokenIn){
        token = tokenIn;
    }
    public String get_token(){
        return token;
    }
    public static void set_username(String usernameIn){
        username = usernameIn;
    }
    public String get_username(){
        return username;
    }

    public void run() {
            System.out.println("This code is running in a thread");
        URL url = null;
        HttpsURLConnection httpConnection = null;
        ResultParser lr = null;
        try {
                //System.out.println(url_string);
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
                set_token(object.getString("token"));
                set_username(object.getString("username"));

            } catch (Exception e) {
                e.printStackTrace();
            }
            finally {
                httpConnection.disconnect();
                currentThread().interrupt();
            }


    }

    public void logout() {
        String url = "https://okka.com.au/driverlog_rest/logout.php";
        Boolean result = hsc.httpRequest(url);
    }

}

