package com.example.mdarifur.product_info;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import Model.ProductInfo;

/**
 * Created by Mobile App Develop on 23-7-16.
 */
public class CustomAdapter_Admin extends ArrayAdapter<ProductInfo> {
    private Context context;
    private ArrayList<ProductInfo> profiles;

    public CustomAdapter_Admin(Context context,ArrayList<ProductInfo> profiles) {
        super(context, R.layout.all_listview, profiles);
        this.context=context;
        this.profiles=profiles;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView=inflater.inflate(R.layout.all_listview,null,true);

        TextView profileNameText= (TextView) convertView.findViewById(R.id.productNameTV);
        TextView profilePic= (TextView) convertView.findViewById(R.id.productPriceTV);

        profileNameText.setText(profiles.get(position).getProductName());
        profilePic.setText(profiles.get(position).getProductPrice());
        profileNameText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(context,String.valueOf(profiles.get(position).getProductID()), Toast.LENGTH_SHORT).show();
                Intent myIntent = new Intent(view.getContext(),
                        product_details_admin.class);
                myIntent.putExtra("id",String.valueOf(profiles.get(position).getProductID()));
                context.startActivity(myIntent);
            }
        });

        return convertView;
    }

}
