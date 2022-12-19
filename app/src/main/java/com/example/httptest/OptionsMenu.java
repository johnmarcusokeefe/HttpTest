package com.example.httptest;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

public class OptionsMenu extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.page_nav, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menu){
        LoginControl lc = new LoginControl();

        System.out.println("onoptions");
        if( menu.getItemId() == R.id.profile) {
            System.out.println(lc.get_token());
            ProfileView pv = new ProfileView();
            createView(pv.getClass(), lc.get_token());
        }
        if( menu.getItemId() == R.id.blocks) {
            System.out.println("r.id.blocks");
            BlockView bv = new BlockView();
            createView(bv.getClass(), lc.get_token());

        }
        if( menu.getItemId() == R.id.expenses) {
            System.out.println("r.id.expense");
        }
        // logout sets token to null in database and goes to login window
        if( menu.getItemId() == R.id.logout) {
            System.out.println("r.id.logout");
            lc.logout();
            LoginView lv = new LoginView();
            createView(lv.getClass(), "" );
        }
        return true;
    }

    //
    public void createView(Class name, String token) {

        Intent i = new Intent(this, name);
        i.putExtra("token", token);
        startActivity(i);
        }

}
