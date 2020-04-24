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
    EditText regpwd,regusername, regfirstname, reglastname;
    CheckBox showpwd;
    private Button registerbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        regusername = findViewById(R.id.regusername) ;
        regpwd = findViewById(R.id.regpwd);
        showpwd = findViewById(R.id.showpwd);
        registerbtn = findViewById(R.id.regbtn);
        regfirstname= findViewById(R.id.regfirstname);
        reglastname = findViewById(R.id.reglastname);

        //for showing and hiding password
        showpwd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                if (b){
                   regpwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
                else{
                    regpwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
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

        String reg=ob.saveRegister(regusername.getText().toString(),regpwd.getText().toString());

        Toast.makeText(this,reg, Toast.LENGTH_SHORT).show();

        //for reseting the field
        regusername.setText("");
        regpwd.setText("");
    }

    public void gotoLogin(View view){
        //changing activity // goes to another page
        startActivity(new Intent(this, Login.class));
    }
}

