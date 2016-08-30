package com.example.mdarifur.product_info;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Home_Screen extends AppCompatActivity {
    Preference preference;
    String isLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preference = new Preference(this);
        isLogin = preference.getUserData();
        if(isLogin.equals("true")){
            Intent loginSucess = new Intent(Home_Screen.this,admin_screen.class);
            startActivity(loginSucess);
            finish();
        }else{
            setContentView(R.layout.activity_home__screen);
        }
    }

    public void ShowList(View view) {
        Intent intent=new Intent(this,all_view.class);
        startActivity(intent);
    }

    public void EntryProduct(View view) {
        Intent login=new Intent(this,Login_Activity.class);
        startActivity(login);
    }
}
