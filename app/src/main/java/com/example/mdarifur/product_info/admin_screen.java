package com.example.mdarifur.product_info;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class admin_screen extends AppCompatActivity {
    Preference preference;
    String login_data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_screen);
        preference = new Preference(this);
    }

    public void insertNewProduct(View view) {
        Intent insetPro = new Intent(admin_screen.this,InsertData.class);
        startActivity(insetPro);
        finish();
    }

    public void product_all_view(View view) {
        Intent productView = new Intent(admin_screen.this,admin_product_list.class);
        startActivity(productView);
        finish();
    }

    public void login(View view) {
        login_data = "false";
        preference.saveUserData(login_data);
        Intent productView = new Intent(admin_screen.this,Login_Activity.class);
        startActivity(productView);
        finish();
    }
}
