package com.example.httptest;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileView extends OptionsMenu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_view);

        String username = getIntent().getStringExtra("username");


        TextView name = (TextView) findViewById(R.id.userName);
        name.setText(username);

        ImageView iv = (ImageView)findViewById(R.id.profileImage);
        iv.setImageResource(R.drawable.ic_launcher_background);
    }


}