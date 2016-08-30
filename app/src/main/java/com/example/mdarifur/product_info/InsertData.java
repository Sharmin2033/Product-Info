package com.example.mdarifur.product_info;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Model.ProductInfo;
import Sqlite.productInfo.ProductInfoDBHelper;
import Sqlite.productInfo.TableOperation;

public class InsertData extends AppCompatActivity {
    EditText nameET,priceET,quantityET,brandET,infoET;
    String productName,productPrice,productQuantity,productBrand,productInfo;
    ProductInfo product;
    TableOperation tableOperation;
    Button updateBTN;
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inset_data);
        nameET = (EditText) findViewById(R.id.nameInsetET);
        priceET = (EditText) findViewById(R.id.priceInsertET);
        quantityET = (EditText) findViewById(R.id.quantityInsertET);
        brandET = (EditText) findViewById(R.id.brandInsertET);
        infoET = (EditText) findViewById(R.id.infoInertET);
        updateBTN = (Button) findViewById(R.id.updateProductBTN);
        id = getIntent().getIntExtra("id",0);
        if (id!=0) {
            tableOperation = new TableOperation(this);
            product = tableOperation.getSingleData(id);

            nameET.setText(product.getProductName());
            priceET.setText(product.getProductPrice());
            quantityET.setText(product.getProductQuantity());
            brandET.setText(product.getProductBrand());
            infoET.setText(product.getAdditionalInfo());
            updateBTN.setText("Update Product");
        }

    }

    public void insertProduct(View view) {
        productName =nameET.getText().toString();
        productPrice = priceET.getText().toString();
        productQuantity = quantityET.getText().toString();
        productBrand = brandET.getText().toString();
        productInfo = infoET.getText().toString();
        if(productName.isEmpty() || productPrice.isEmpty()||productQuantity.isEmpty()||productBrand.isEmpty()){
            Toast.makeText(InsertData.this, "Require field not be empty ", Toast.LENGTH_SHORT).show();
        }else {
            product = new ProductInfo(productName,productPrice,productQuantity,productBrand,productInfo);
            tableOperation = new TableOperation(this);
            if(id>0){
                boolean update_pro = tableOperation.updateData(id,product);
                if(update_pro == true){
                    Toast.makeText(InsertData.this, "Successfully Update", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(getApplicationContext(),admin_product_list.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(InsertData.this, "Fail to Update", Toast.LENGTH_SHORT).show();
                }
            }else {
                boolean result = tableOperation.insertData(product);
                if (result == true) {
                    Toast.makeText(InsertData.this, "Successfully Save", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), admin_product_list.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(InsertData.this, "Fail to Save", Toast.LENGTH_SHORT).show();
                }
            }

        }

    }

    public void backToAdmin(View view) {
        Intent intent = new Intent(getApplicationContext(), admin_screen.class);
        startActivity(intent);

    }
}
