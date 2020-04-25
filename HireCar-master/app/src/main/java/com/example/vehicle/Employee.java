package com.example.vehicle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.WebapiCall;

import java.util.HashMap;
import java.util.List;

public class Employee extends AppCompatActivity {
    EditText editTextempname,editTextemppassword;
    Button button, btn2;
    String goodempPassword="123";
    String goodempname="Pulkit";
    String employeename, emppassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee2);

        editTextempname=findViewById(R.id.empname);
        editTextemppassword=findViewById(R.id.emppassword);

        button=findViewById(R.id.button1);
        btn2=findViewById(R.id.btnc);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            employeename = editTextempname.getText().toString();
            emppassword=editTextemppassword.getText().toString();
                if (editTextempname.getText().toString().length() == 0){
                    Toast.makeText(getApplicationContext(), "Please enter Username and Emial", Toast.LENGTH_SHORT).show();

                }else  if (editTextemppassword.getText().toString().length() == 0){
                    Toast.makeText(getApplicationContext(), "Please enter password", Toast.LENGTH_SHORT).show();

                }else {
                    HashMap<String,String> hashMap = new HashMap<>();
                    hashMap.put("email",editTextempname.getText().toString());
                    hashMap.put("password",editTextemppassword.getText().toString());
                    hashMap.put("device_type","1");
                    hashMap.put("device_token","11111111111111111111");

                    WebapiCall webapiCall = new WebapiCall();
                    webapiCall.LoginApi(Employee.this, hashMap);

                }

          /*  List<EmployeeData> employees = EmployeeDataSource.getInstance().employees;
            Boolean is_login = Boolean.FALSE;

            for (int i = 0; i < employees.size(); i++) {
                EmployeeData employee = employees.get(i);
                if ((employee.userName.equals(employeename)&&employee.password.equals(emppassword))||(goodempname.equals(employeename)&&goodempPassword.equals(emppassword))) {
                    is_login = Boolean.TRUE;
                    break;
                }
            }
                if (is_login) {
                    Toast.makeText(getApplicationContext(),employeename + "  login success!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Employee.this,EmpLoginView.class);
                    startActivity(intent);
                }
                else
                {
                    Intent intent = new Intent(Employee.this,EmpLoginView.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(),"Invalid Employeename or Password", Toast.LENGTH_SHORT).show();
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
