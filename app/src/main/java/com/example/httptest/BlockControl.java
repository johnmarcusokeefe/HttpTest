package com.example.httptest;

public class BlockControl {

    ViewAdapter viewAdapter = new ViewAdapter();

    String url = "https://okka.com.au/driverlog_rest/blocks.php";
    HttpStreamControl hsc = new HttpStreamControl();


    Boolean flag = hsc.httpRequest(url);


}
