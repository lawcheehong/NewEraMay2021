package com.example.neweramay2021.listview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.neweramay2021.R;

import java.util.ArrayList;

public class ContactAdapter extends ArrayAdapter {
    private ArrayList<String> data;
    private Context context;

    public ContactAdapter(Context context, ArrayList<String> list){
        super(context, R.layout.contact);
        this.data = list;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View mainView;
        String contactString = data.get(position);

        if(convertView == null) {
            mainView = View.inflate(context, R.layout.contact, null);
            ViewHolder holder = new ViewHolder();
            holder.contacttvString1 = mainView.findViewById(R.id.contacttvString1);

            holder.contacttvString1.setText(contactString);

            mainView.setTag(holder);
        } else {
            mainView = convertView;
            ContactAdapter.ViewHolder holder = (ContactAdapter.ViewHolder) convertView.getTag();
            holder.contacttvString1.setText(contactString);
        }
        return mainView;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    class ViewHolder{
        TextView contacttvString1;
    }
}
