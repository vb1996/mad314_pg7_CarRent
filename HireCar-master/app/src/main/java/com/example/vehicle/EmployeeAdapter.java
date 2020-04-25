package com.example.vehicle;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Pojoclass.UserlistPojo;

import java.util.ArrayList;
import java.util.List;


public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeViewHolder>{

        private LayoutInflater inflater;
    ArrayList<UserlistPojo.UserList> arrayLists = new ArrayList<>();
 int i = 1;
        EmployeeAdapter(Context context, ArrayList<UserlistPojo.UserList> arrayList) {
            this.inflater = LayoutInflater.from(context);
            arrayLists = arrayList;

        }

        @NonNull
        @Override
        public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            View view = inflater.inflate(R.layout.employee_vh, parent, false);
            return new EmployeeViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {

            /*
            Employees can view the customer list(user list).
            So the userdata list is called.
            */
           // UserData user;user = UserDataSource.getInstance().users.get(position);


           // holder.tvcId.setText(arrayLists.get(position).geti);
            holder.tvcName.setText(""+arrayLists.get(position).getName());
           // holder.tvcpwd.setText(arrayLists.get(position).getName());
            holder.tvccontact.setText(arrayLists.get(position).getPhone());
            holder.tvcId.setText(""+i++);
            // holder.UserImage.setText(String.valueOf(user.name));
        }

        @Override
        public int getItemCount() {
            return arrayLists.size();
        }
    }

