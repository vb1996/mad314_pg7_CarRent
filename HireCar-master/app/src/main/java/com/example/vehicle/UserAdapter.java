package com.example.vehicle;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.Pojoclass.Car_list;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<VehicleViewHolder>{

    // clicklistener part /////////////////////////////////
    private  OnItemClickListener vListener;
    public interface OnItemClickListener{
        void  onItemClick(int position);
    }
    public  void setOnItemClickListener(OnItemClickListener listener){
        vListener = listener;
    }
    // clicklistener end //////////////////////////////////////////////
int i = 1;
    Context contexts;
    private LayoutInflater inflater;
    ArrayList<Car_list.CarList> arrayLists = new ArrayList<>();
    UserAdapter(Context context,ArrayList<Car_list.CarList> arrayList) {
        this.inflater = LayoutInflater.from(context);
        arrayLists = arrayList;
        contexts = context;
    }

    @NonNull
    @Override
    public VehicleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.vehicle_vh, parent, false);
        return new VehicleViewHolder(view, vListener);
    }

    @Override
    public void onBindViewHolder(@NonNull VehicleViewHolder holder, int position) {
        VehicleData vehicle;
        vehicle = VehicleDataSource.getInstance().vehicles.get(position);
        String scolor;

        holder.tvvId.setText(""+i++);

        holder.tvType.setText(arrayLists.get(position).getType());
        holder.tvBrand.setText(arrayLists.get(position).getBrand());

        Glide.with(contexts).load(arrayLists.get(position).getImage()).into(holder.CarImage);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });


    }

    @Override
    public int getItemCount() {
        return arrayLists.size();
    }
}



