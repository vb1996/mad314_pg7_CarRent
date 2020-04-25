package com.example;



import com.example.Pojoclass.Car_list;
import com.example.Pojoclass.LoginPojo;
import com.example.Pojoclass.Make_on_rent;
import com.example.Pojoclass.UserlistPojo;

import java.util.HashMap;
import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;


public interface ApiInterface {
   @FormUrlEncoded
    @POST("loginUser")
    Call<LoginPojo> loginUser(@FieldMap HashMap<String, String> hashMap);

   @FormUrlEncoded
    @POST("make_on_rent")
    Call<Make_on_rent> make_on_rent(@FieldMap HashMap<String, String> hashMap);

    @GET("user_list")
    Call<UserlistPojo> user_list();

    @GET("car_list")
    Call<Car_list> car_list();




}
