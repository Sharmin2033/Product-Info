package com.example.mdarifur.product_info;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login_Activity extends AppCompatActivity {
    EditText nameEdT,passwordEdT;
    Preference preference;
    String dataToBeSaveed,isLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preference = new Preference(this);

        isLogin = preference.getUserData();

        if(isLogin.equals("true")){
            Intent loginSucess = new Intent(Login_Activity.this,admin_screen.class);
            startActivity(loginSucess);
            finish();
        }else {
            setContentView(R.layout.activity_login);

            nameEdT = (EditText) findViewById(R.id.nameET);
            passwordEdT = (EditText) findViewById(R.id.passwordET);

        }
    }

    public void CheckLogin(View view) {
        String username = nameEdT.getText().toString();
        String pasword = passwordEdT.getText().toString();

        String admin = "admin";
        String passkey = "12345";

        if (username.equals(admin)&&pasword.equals(passkey)){

            this.dataToBeSaveed = "true";

            Toast.makeText(Login_Activity.this, "Successfully Login", Toast.LENGTH_SHORT).show();
            Intent loginSucess = new Intent(Login_Activity.this,admin_screen.class);
            startActivity(loginSucess);
            finish();
        }else{
            this.dataToBeSaveed = "false";
            Toast.makeText(Login_Activity.this,"Login Fail", Toast.LENGTH_LONG).show();
        }
        preference.saveUserData(dataToBeSaveed);
    }

    public void backToScreen(View view) {
        Intent loginSucess = new Intent(Login_Activity.this,Home_Screen.class);
        startActivity(loginSucess);
        finish();
    }

}