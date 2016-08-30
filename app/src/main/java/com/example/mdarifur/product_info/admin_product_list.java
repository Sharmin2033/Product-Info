package com.example.mdarifur.product_info;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

import Model.ProductInfo;
import Sqlite.productInfo.TableOperation;

public class admin_product_list extends AppCompatActivity {

    ListView contactListView;
    TableOperation tableOperation;
    ArrayList<ProductInfo> allProduct;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_product_list);

        contactListView= (ListView) findViewById(R.id.all_viewLV);
        tableOperation=new TableOperation(this);
        allProduct=tableOperation.getAllData();
        customAdapter=new CustomAdapter(this,allProduct);
        contactListView.setAdapter(customAdapter);
    }

}
