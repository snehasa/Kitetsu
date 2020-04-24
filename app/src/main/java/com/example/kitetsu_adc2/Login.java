package com.example.kitetsu_adc2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText loginname, loginpwd;
    Button loginbtn;
    Managedb databaseHelper;
    ImageButton gotoregister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginname = findViewById(R.id.loginname) ;
        loginpwd = findViewById(R.id.loginpwd);
        loginbtn = findViewById(R.id.loginbtn);
        gotoregister = findViewById(R.id.gotoregister);
        //databasehelper is an object for database
        databaseHelper = new Managedb(this);


        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //value of editext is recieved and turned into string
                String username=loginname.getText().toString();
                String password=loginpwd.getText().toString();

                //validatelogin method is run which returns true of false// true as in user exists
                if (databaseHelper.validatelogin(username,password)){
                    //if user exists home page is redirected
                    startActivity(new Intent(Login.this, Home.class));
                }
                else{
                    //if user doesnot exist toast is shown
                    Toast.makeText(Login.this, "Login unsuccesfull", Toast.LENGTH_SHORT).show();
                }
            }
        });

        gotoregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, MainActivity.class));

            }
        });


    }


}
