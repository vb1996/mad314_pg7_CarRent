package com.example.vehicle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.CSPreferences;
import com.example.WebapiCall;

import java.util.HashMap;

public class User extends AppCompatActivity {
    TextView textView;
    EditText editTextusername,editTextpassword;
    Button button,btn2;
    String goodPassword="1234";
    String goodUsername="Pulkit";
    String username, password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

         textView=findViewById(R.id.textView);
        editTextusername=findViewById(R.id.usrername);
        editTextpassword=findViewById(R.id.password);

        button=findViewById(R.id.button);
        btn2=findViewById(R.id.btnc2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {






                username = editTextusername.getText().toString();
                password = editTextpassword.getText().toString();

if (editTextusername.getText().toString().length() == 0){
    Toast.makeText(getApplicationContext(), "Please enter Username and Emial", Toast.LENGTH_SHORT).show();

}else  if (editTextpassword.getText().toString().length() == 0){
    Toast.makeText(getApplicationContext(), "Please enter password", Toast.LENGTH_SHORT).show();

}else {
    HashMap<String,String> hashMap = new HashMap<>();
    hashMap.put("email",editTextusername.getText().toString());
    hashMap.put("password",editTextpassword.getText().toString());
    hashMap.put("device_type","1");
    hashMap.put("device_token","11111111111111111111");

    WebapiCall webapiCall = new WebapiCall();
    webapiCall.LoginApi(User.this, hashMap);

}


              /*  if (goodPassword.equals(password) && goodUsername.equals(username)) {
                    Intent intent = new Intent(User.this, UserLoginView.class);
                    startActivity(intent);
                }

                else {
                    Intent intent = new Intent(User.this, UserLoginView.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), "Invalid Username or Password", Toast.LENGTH_SHORT).show();
                }*/


            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }

        });
    }
    }

