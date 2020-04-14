package com.example.kitetsu_adc2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText pwd,name;
    CheckBox showpwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText)findViewById(R.id.name) ;
        pwd = (EditText)findViewById(R.id.pwd);
        showpwd = findViewById(R.id.showpwd);



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

    }

    public void saveRegister(View view){
        Managedb ob = new Managedb(this);
        String reg=ob.saveRegister(name.getText().toString(),pwd.getText().toString());

        Toast.makeText(this,reg, Toast.LENGTH_SHORT).show();
        name.setText("");
        pwd.setText("");
    }

    public void gotoLogin(View view){
        startActivity(new Intent(this, Login.class));
    }
}

