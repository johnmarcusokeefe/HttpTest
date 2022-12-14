package com.example.httptest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toolbar;

public class LoginView extends AppCompatActivity {

    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LoginControl loginControl = new LoginControl();
        mButton = findViewById(R.id.login_button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                EditText u = (EditText)findViewById(R.id.inputName);
                String user = u.getText().toString();
                EditText p = (EditText)findViewById(R.id.inputPassword);
                String password = p.getText().toString();

                // run login call
                loginControl.apiRequest(user, password);
                //
                // returns null unless this wait is run
                while(loginControl.get_token() == null) {
                    System.out.println("waiting for token");
                }
                createProfile(loginControl.get_token(), loginControl.get_username());
            }
        });


    }
    // called after login
    public void createProfile(String token, String username) {
        Intent i = new Intent(this, ProfileView.class);
        //
        Bundle b = new Bundle();
        b.putString("token",token);
        b.putString("username",username);
        System.out.println("loginview 52 "+b);
        i.putExtras(b);
        //
        startActivity(i);
    }



}