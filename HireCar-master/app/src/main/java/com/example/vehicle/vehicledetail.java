package com.example.vehicle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.CSPreferences;
import com.example.Pojoclass.Car_list;
import com.example.WebapiCall;
import com.google.gson.Gson;

import java.util.Calendar;
import java.util.HashMap;

public class vehicledetail extends AppCompatActivity {

    TextView textView;
    RecyclerView rvVdl;
    Button button, reservebtn, returnbtn, cancelbtn;
    private static final String TAG = "vehicledetail";

    private TextView startDate, endDate;
    private DatePickerDialog.OnDateSetListener startset, endset;

    ImageView CarImage;
    TextView tvvId, tvType, tvBrand,tvModel,tvYear, tvColor,tvLicense, tvState, tvSdate, tvEdate;
    Car_list.CarList service=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vehicledetail);
        // get data
        Gson gson=new Gson();
        service=gson.fromJson(CSPreferences.readString(vehicledetail.this,"detaildata"),Car_list.CarList.class);


        tvType = findViewById(R.id.dtype);
        tvBrand =findViewById(R.id.dbrand);
        tvModel =findViewById(R.id.dmodel);
        tvYear = findViewById(R.id.dyear);
        tvColor =findViewById(R.id.dcolor);
        tvLicense = findViewById(R.id.dlicense);
        CarImage = findViewById(R.id.CarImage);
        tvState = findViewById(R.id.state);
        tvSdate = findViewById(R.id.sdate);
        tvEdate = findViewById(R.id.edate);


        tvType.setText(service.getType());
        tvBrand.setText(service.getBrand());
        tvModel.setText(service.getModel());
        tvYear.setText(service.getYear());
        tvColor.setText(service.getColor());
        tvLicense.setText(service.getLicence());
//        tvState.setText(service.getState());


        Glide.with(this).load(service.getImage()).into(CarImage);





        button = findViewById(R.id.rentbtn);
        reservebtn = findViewById(R.id.reservebtn);
        returnbtn = findViewById(R.id.returnbtn);
        cancelbtn = findViewById(R.id.cancelbtn);

       /* rvVdl = findViewById(R.id.rvVdl);
        rvVdl.setLayoutManager(new LinearLayoutManager(this));
*/
      /*  VehicleAdapter vehicleAdapter = new VehicleAdapter(getApplicationContext(),);
        rvVdl.setAdapter(vehicleAdapter);
*/
        //datepicker part
        startDate = findViewById(R.id.startdate);
        endDate = findViewById(R.id.enddate);

        startDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        vehicledetail.this,
                        android.R.style.Theme_DeviceDefault_Dialog_MinWidth,
                        startset,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

            }
        });
        endDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        vehicledetail.this,
                        android.R.style.Theme_DeviceDefault_Dialog_MinWidth,
                        endset,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

            }
        });
        startset = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                String date = month + "/" + day + "/" + year;

                startDate.setText(date);

            }
        };
        endset = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                String date = month + "/" + day + "/" + year;

                endDate.setText(date);
            }
        };
        //
        //    Button Click Listeners: Rent, Reservation, Return, Cancel.
        //
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String ad = startDate.getText().toString();
                String ed = endDate.getText().toString();


                if (startDate.getText().toString().length() == 0){
                    Toast.makeText(getApplicationContext(), " Select Start date.", Toast.LENGTH_SHORT).show();

                }else if (endDate.getText().toString().length() == 0){
                    Toast.makeText(getApplicationContext(), " Select End date.", Toast.LENGTH_SHORT).show();

                } else {

                    HashMap<String,String> hashMap = new HashMap<>();
                    hashMap.put("session_id",CSPreferences.readString(vehicledetail.this,"auth_key"));
                    hashMap.put("car_id",""+service.getId());
                    hashMap.put("state","1");
                    hashMap.put("from_date",startDate.getText().toString());
                    hashMap.put("end_date",endDate.getText().toString());

                    WebapiCall webapiCall = new WebapiCall();
                    webapiCall.make_on_rent(vehicledetail.this, hashMap);

//                    Toast.makeText(getApplicationContext(), " You have rented a car successfully.", Toast.LENGTH_SHORT).show();
                }

            }
        });
        reservebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                HashMap<String,String> hashMap = new HashMap<>();
                hashMap.put("session_id",CSPreferences.readString(vehicledetail.this,"auth_key"));
                hashMap.put("car_id",""+service.getId());
                hashMap.put("state","2");
                hashMap.put("from_date","");
                hashMap.put("end_date","");

                WebapiCall webapiCall = new WebapiCall();
                webapiCall.make_on_rent(vehicledetail.this, hashMap);
            }
        });
        returnbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashMap<String,String> hashMap = new HashMap<>();
                hashMap.put("session_id",CSPreferences.readString(vehicledetail.this,"auth_key"));
                hashMap.put("car_id",""+service.getId());
                hashMap.put("state","3");
                hashMap.put("from_date","");
                hashMap.put("end_date","");

                WebapiCall webapiCall = new WebapiCall();
                webapiCall.make_on_rent(vehicledetail.this, hashMap);

                //Toast.makeText(getApplicationContext(), " You have returned a car successfully.", Toast.LENGTH_SHORT).show();
            }
        });
        cancelbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashMap<String,String> hashMap = new HashMap<>();
                hashMap.put("session_id",CSPreferences.readString(vehicledetail.this,"auth_key"));
                hashMap.put("car_id",""+service.getId());
                hashMap.put("state","4");
                hashMap.put("from_date","");
                hashMap.put("end_date","");

                WebapiCall webapiCall = new WebapiCall();
                webapiCall.make_on_rent(vehicledetail.this, hashMap);

               // Toast.makeText(getApplicationContext(), " You have canceled a car rent successfully.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
