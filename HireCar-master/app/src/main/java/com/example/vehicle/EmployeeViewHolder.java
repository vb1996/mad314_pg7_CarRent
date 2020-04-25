package com.example.vehicle;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



    public class EmployeeViewHolder extends RecyclerView.ViewHolder {


        TextView tvcId, tvcName, tvcpwd, tvccontact;

        EmployeeViewHolder(@NonNull View itemView) {
            super(itemView);
            tvcId = itemView.findViewById(R.id.tvcId);
            tvcName = itemView.findViewById(R.id.tvcName);
            tvcpwd = itemView.findViewById(R.id.tvcpwd);
            tvccontact = itemView.findViewById(R.id.tvccontact);
        }
    }

