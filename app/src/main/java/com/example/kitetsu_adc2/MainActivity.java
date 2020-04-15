package com.example.kitetsu_adc2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    EditText pwd,name;
    CheckBox showpwd;
    private Button registerbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name) ;
        pwd = findViewById(R.id.pwd);
        showpwd = findViewById(R.id.showpwd);
        registerbtn = findViewById(R.id.register_btn);

        //for showing and hiding password
        showpwd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                if (b){
                   pwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
                else{
                    pwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });

        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveRegister(v);
                startActivity(new Intent(MainActivity.this, Login.class));
            }
        });


    }
    //register credentials in local database
    public void saveRegister(View view){
        //Managedb is database and ob is its object
        Managedb ob = new Managedb(this);

        String reg=ob.saveRegister(name.getText().toString(),pwd.getText().toString());

        Toast.makeText(this,reg, Toast.LENGTH_SHORT).show();

        //for reseting the field
        name.setText("");
        pwd.setText("");
    }

    public void gotoLogin(View view){
        //changing activity // goes to another page
        startActivity(new Intent(this, Login.class));
    }
}

