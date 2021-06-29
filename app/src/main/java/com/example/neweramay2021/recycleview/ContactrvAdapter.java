package com.example.neweramay2021.recycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.neweramay2021.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class ContactrvAdapter extends RecyclerView.Adapter<ContactrvAdapter.ViewHolder>{
    private ArrayList<Contactrv> contactlist = new ArrayList<>();
    private Context context;

    public ContactrvAdapter(Context context, ArrayList<Contactrv> list){
        this.contactlist = list;
        this.context = context;
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.single_row_contactrv, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ContactrvAdapter.ViewHolder holder, int position) {
        Contactrv contactrv = contactlist.get(position);

        holder.tvName.setText(contactrv.getName());
        holder.tvPhoneNumber.setText(contactrv.getPhoneNumber());
    }

    @Override
    public int getItemCount() {
        return contactlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView tvName, tvPhoneNumber;

        public ViewHolder(View itemView){
            super(itemView);

            tvName = itemView.findViewById(R.id.name);
            tvPhoneNumber = itemView.findViewById(R.id.phoneNumber);
        }
    }
}
