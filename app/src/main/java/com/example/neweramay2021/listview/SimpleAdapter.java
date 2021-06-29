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

public class SimpleAdapter<convertView> extends ArrayAdapter {
    private ArrayList<String> data;
    private Context context;

    public SimpleAdapter(Context context, ArrayList<String> list){
        super(context, R.layout.single_row_simple_listview);
        this.data = list;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View mainView;
        String fruitString = data.get(position);

        if(convertView == null) {
            mainView = View.inflate(context, R.layout.single_row_simple_listview, null);
            ViewHolder holder = new ViewHolder();
            holder.tvString = mainView.findViewById(R.id.tvString);

            holder.tvString.setText(fruitString);

            mainView.setTag(holder);
        } else {
            mainView = convertView;
            ViewHolder holder = (ViewHolder) convertView.getTag();
            holder.tvString.setText(fruitString);
        }
        return mainView;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    class ViewHolder{
        TextView tvString;
    }
}
