package com.example.mdarifur.product_info;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import Model.ProductInfo;
import Sqlite.productInfo.TableOperation;

public class Product_detail extends AppCompatActivity {
    TextView name_tv,price_tv,quantity_tv,info_tv,brandTV;
    TableOperation tableOpreation;
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        String id_intent = getIntent().getStringExtra("id");

        this.id = Integer.valueOf(id_intent);
        name_tv = (TextView) findViewById(R.id.nameTV);
        price_tv = (TextView) findViewById(R.id.priiceTV);
        quantity_tv = (TextView) findViewById(R.id.quantityTV);
        info_tv = (TextView) findViewById(R.id.infoTV);
        brandTV = (TextView) findViewById(R.id.brandTV);


        tableOpreation = new TableOperation(this);
        ProductInfo product = tableOpreation.getSingleData(id);

        name_tv.setText(product.getProductName());
        price_tv.setText(product.getProductPrice());
        quantity_tv.setText(product.getProductQuantity());
        info_tv.setText(product.getAdditionalInfo());
        brandTV.setText(product.getProductBrand());
    }

    public void updateProduct(View view) {
        Intent intent=new Intent(getApplicationContext(),InsertData.class);
        intent.putExtra("id",id);
        startActivity(intent);
    }
}
