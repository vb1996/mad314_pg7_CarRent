package com.example;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;


import com.example.Interface.Car_list_interface;
import com.example.Interface.Userlis_interface;
import com.example.Pojoclass.Car_list;
import com.example.Pojoclass.LoginPojo;
import com.example.Pojoclass.Make_on_rent;
import com.example.Pojoclass.UserlistPojo;
import com.example.vehicle.EmpLoginView;
import com.example.vehicle.UserLoginView;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WebapiCall {

    ProgressDialog pd;

    public void dailogshow(Context context){
        pd = new ProgressDialog(context);
        pd.setMessage("loading...");
        pd.setCancelable(false);
        pd.show();
    }
    public void dailoghide(Context context){
        pd.dismiss();
    }

    // API Restarentlnfo####################################################################################################################
    public void LoginApi(final Context context, HashMap<String,String> hashMap) {
        dailogshow(context);
        Call<LoginPojo> userpost_responseCall = ApiClient.getClient().loginUser(hashMap);
        userpost_responseCall.enqueue(new Callback<LoginPojo>() {
            @Override
            public void onResponse(Call<LoginPojo> call, Response<LoginPojo> response) {
                dailoghide(context);
                if(response.code() == 200){
                    GlobalClass.showtost(context,""+response.body().getMessage());

                    if (response.body().getProfile().getUsertype().equals("1")){
                        CSPreferences.putString(context,"auth_key",response.body().getProfile().getSessionId());
                        Intent intent = new Intent(context, UserLoginView.class);
                        context.startActivity(intent);

                    }else {
                        CSPreferences.putString(context,"auth_key",response.body().getProfile().getSessionId());

                        Intent intent = new Intent(context, EmpLoginView.class);
                        context.startActivity(intent);
                    }




                /*    CSPreferences.putString(context,"auth_key",response.body().getData().getAuthKey());
                    CSPreferences.putString(context,"id",response.body().getData().getUser().getId().toString());
                    CSPreferences.putString(context,"name",response.body().getData().getUser().getName());
                    CSPreferences.putString(context,"last_name",response.body().getData().getUser().getLastName());
                    CSPreferences.putString(context,"email",response.body().getData().getUser().getEmail());
                    CSPreferences.putString(context,"type",response.body().getData().getUser().getType());
     */            // CSPreferences.putString(context,"otp",response.body().getData().getUser().getOtp().toString());

                }else {
                    GlobalClass.showtost(context,""+response.body().getMessage());
                }
            }
            @Override
            public void onFailure(Call<LoginPojo> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();
                Toast.makeText(context, "Poor Connection."+t.toString(), Toast.LENGTH_SHORT).show();
                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }


    public void make_on_rent(final Context context, HashMap<String,String> hashMap) {
        dailogshow(context);
        Call<Make_on_rent> userpost_responseCall = ApiClient.getClient().make_on_rent(hashMap);
        userpost_responseCall.enqueue(new Callback<Make_on_rent>() {
            @Override
            public void onResponse(Call<Make_on_rent> call, Response<Make_on_rent> response) {
                dailoghide(context);
                if(response.code() == 200){
                    GlobalClass.showtost(context,""+response.body().getMessage());




                /*    CSPreferences.putString(context,"auth_key",response.body().getData().getAuthKey());
                    CSPreferences.putString(context,"id",response.body().getData().getUser().getId().toString());
                    CSPreferences.putString(context,"name",response.body().getData().getUser().getName());
                    CSPreferences.putString(context,"last_name",response.body().getData().getUser().getLastName());
                    CSPreferences.putString(context,"email",response.body().getData().getUser().getEmail());
                    CSPreferences.putString(context,"type",response.body().getData().getUser().getType());
     */            // CSPreferences.putString(context,"otp",response.body().getData().getUser().getOtp().toString());

                }else {
                    GlobalClass.showtost(context,""+response.body().getMessage());
                }
            }
            @Override
            public void onFailure(Call<Make_on_rent> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();
                Toast.makeText(context, "Poor Connection."+t.toString(), Toast.LENGTH_SHORT).show();
                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }


    public void userlist(final Context context, final Userlis_interface userlis_interface) {
        dailogshow(context);
        Call<UserlistPojo> userpost_responseCall = ApiClient.getClient().user_list();
        userpost_responseCall.enqueue(new Callback<UserlistPojo>() {
            @Override
            public void onResponse(Call<UserlistPojo> call, Response<UserlistPojo> response) {
                dailoghide(context);
                if(response.code() == 200){
                   // GlobalClass.showtost(context,""+response.body().getMessage());
                    userlis_interface.userlist((ArrayList<UserlistPojo.UserList>) response.body().getUserList());

                }else {
                    GlobalClass.showtost(context,""+response.body().getMessage());
                }
            }
            @Override
            public void onFailure(Call<UserlistPojo> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();
                Toast.makeText(context, "Poor Connection."+t.toString(), Toast.LENGTH_SHORT).show();
                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }

  public void car_list(final Context context, final Car_list_interface car_list_interface) {
       // dailogshow(context);
        Call<Car_list> userpost_responseCall = ApiClient.getClient().car_list();
        userpost_responseCall.enqueue(new Callback<Car_list>() {
            @Override
            public void onResponse(Call<Car_list> call, Response<Car_list> response) {
               // dailoghide(context);
                if(response.code() == 200){
                   // GlobalClass.showtost(context,""+response.body().getMessage());
                   car_list_interface.carlist((ArrayList<Car_list.CarList>) response.body().getCarList());

                }else {
                  //  GlobalClass.showtost(context,""+response.body().getMessage());
                }
            }
            @Override
            public void onFailure(Call<Car_list> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();
                Toast.makeText(context, "Poor Connection."+t.toString(), Toast.LENGTH_SHORT).show();
                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }

}
