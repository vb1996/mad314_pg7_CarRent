package com.example.vehicle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.Interface.Car_list_interface;
import com.example.Interface.Userlis_interface;
import com.example.Pojoclass.Car_list;
import com.example.Pojoclass.UserlistPojo;
import com.example.WebapiCall;

import java.util.ArrayList;
import java.util.List;

public class EmpLoginView extends AppCompatActivity implements Userlis_interface , Car_list_interface {
    TextView textView;
    RecyclerView rvCustomer, rvList;
      ArrayList<UserlistPojo.UserList> arrayList = new ArrayList<>();
      ArrayList<Car_list.CarList> car_arrayList = new ArrayList<>();
    EmployeeAdapter employeeAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emp_login_view);

        rvCustomer= findViewById(R.id.rvcustomer);
        rvCustomer.setLayoutManager(new LinearLayoutManager(this));
        rvList= findViewById(R.id.rvlist);
        rvList.setLayoutManager(new LinearLayoutManager(this));

         employeeAdapter = new EmployeeAdapter(getApplicationContext(),arrayList);
        rvCustomer.setAdapter(employeeAdapter);




        VehicleAdapter vehicleAdapter = new VehicleAdapter(getApplicationContext(),car_arrayList);
        rvList.setAdapter(vehicleAdapter);


        WebapiCall webapiCall = new WebapiCall();
        webapiCall.userlist(EmpLoginView.this, this);


        WebapiCall carlist = new WebapiCall();
        carlist.car_list(EmpLoginView.this, this);













    }




    @Override
    public void userlist(ArrayList<UserlistPojo.UserList> list) {
        arrayList.clear();
        arrayList.addAll(list);
        rvCustomer.getAdapter().notifyDataSetChanged();

    }


    @Override
    public void carlist(ArrayList<Car_list.CarList> list) {

        car_arrayList.clear();
        car_arrayList.addAll(list);
        rvList.getAdapter().notifyDataSetChanged();

    }
}
