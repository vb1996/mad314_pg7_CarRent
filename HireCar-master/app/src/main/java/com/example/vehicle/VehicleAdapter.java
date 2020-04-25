package com.example.vehicle;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.Pojoclass.Car_list;
import com.example.Pojoclass.UserlistPojo;

import java.util.ArrayList;

public class VehicleAdapter extends RecyclerView.Adapter<VdetailViewHolder>{


    private LayoutInflater inflater;
    ArrayList<Car_list.CarList> arrayLists = new ArrayList<>();
    int i = 1;

    Context contexts;
    VehicleAdapter(Context context, ArrayList<Car_list.CarList> arrayList) {
        this.inflater = LayoutInflater.from(context);
        arrayLists = arrayList;
        contexts = context;

    }

    @NonNull
    @Override
    public VdetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.selectedcar, parent, false);
        return new VdetailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VdetailViewHolder holder, int position) {
        VehicleData vehicle;
        vehicle = VehicleDataSource.getInstance().vehicles.get(position);
        String scolor, carstate;


        holder.tvType.setText(arrayLists.get(position).getType());
        holder.tvBrand.setText(arrayLists.get(position).getBrand());
        holder.tvModel.setText(arrayLists.get(position).getModel());
        holder.tvYear.setText(arrayLists.get(position).getYear());
        holder.tvColor.setText(arrayLists.get(position).getColor());
        holder.tvLicense.setText(arrayLists.get(position).getLicence());
        holder.tvState.setText(arrayLists.get(position).getState());


        Glide.with(contexts).load(arrayLists.get(position).getImage()).into(holder.CarImage);




        /*scolor = String.valueOf(vehicle.color).toString();
            if (scolor == "Red"){
                holder.CarImage.setImageResource(R.drawable.redcar);
            }
            else if (scolor == "White"){
                holder.CarImage.setImageResource(R.drawable.white);
            }
            else {
                holder.CarImage.setImageResource(R.drawable.black);
            }
        carstate = String.valueOf(vehicle.state).toString();
            if (carstate == "Return"){
                holder.tvSdate.setText(String.valueOf(vehicle.sdate));
                holder.tvEdate.setText("");
            }
            else{
                holder.tvSdate.setText(String.valueOf(vehicle.sdate));
                holder.tvEdate.setText(String.valueOf(vehicle.edate));
            }*/


    }

    @Override
    public int getItemCount() {
        return arrayLists.size();
    }
}



