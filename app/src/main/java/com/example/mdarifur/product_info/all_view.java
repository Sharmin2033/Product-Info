package com.example.mdarifur.product_info;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import Model.ProductInfo;
import Sqlite.productInfo.TableOperation;

public class all_view extends AppCompatActivity {
    ListView contactListView;
    TableOperation tableOperation;
    ArrayList<ProductInfo> allProduct;
    CustomAdapter_Admin customAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_view);

        contactListView= (ListView) findViewById(R.id.all_viewLV);
        tableOperation=new TableOperation(this);
        allProduct=tableOperation.getAllData();
        customAdapter=new CustomAdapter_Admin(this,allProduct);
        contactListView.setAdapter(customAdapter);
    }

}
