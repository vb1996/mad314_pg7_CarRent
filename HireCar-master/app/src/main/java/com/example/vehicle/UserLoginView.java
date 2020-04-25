package com.example.vehicle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.CSPreferences;
import com.example.Interface.Car_list_interface;
import com.example.Pojoclass.Car_list;
import com.example.RecyclerItemClickListener;
import com.example.WebapiCall;
import com.google.gson.Gson;

import java.util.ArrayList;
public class UserLoginView extends AppCompatActivity implements Car_list_interface {
    TextView textView;
    RecyclerView rvUser;
    ArrayList<Car_list.CarList> car_arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login_view);
        rvUser = findViewById(R.id.rvUser);
        rvUser.setLayoutManager(new LinearLayoutManager(this));




        WebapiCall carlist = new WebapiCall();
        carlist.car_list(UserLoginView.this, this);

        UserAdapter userAdapter = new UserAdapter(getApplicationContext(),car_arrayList);
        rvUser.setAdapter(userAdapter);


/*
        VehicleAdapter vehicleAdapter = new VehicleAdapter(getApplicationContext(),car_arrayList);
        rvUser.setAdapter(vehicleAdapter);*/


        rvUser.addOnItemTouchListener(
                new RecyclerItemClickListener(UserLoginView.this, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        Intent intent = new Intent(UserLoginView.this, vehicledetail.class);
                        startActivity(intent);

                        Gson gson = new Gson();
                        CSPreferences.putString(UserLoginView.this,"detaildata",gson.toJson(car_arrayList.get(position)));
                    }
                }));


    }

    @Override
    public void carlist(ArrayList<Car_list.CarList> list) {
        car_arrayList.clear();
        car_arrayList.addAll(list);
        rvUser.getAdapter().notifyDataSetChanged();
    }
}
