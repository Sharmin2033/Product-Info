package Sqlite.productInfo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import Model.ProductInfo;

/**
 * Created by MD.Arifur on 7/21/2016.
 */
public class TableOperation {
    private ProductInfoDBHelper productInfoDBHelper;
    private SQLiteDatabase database;
    private ProductInfo productInfo;

    public TableOperation(Context context) {
        productInfoDBHelper = new  ProductInfoDBHelper(context);
    }

    private void OpenWrite(){
        database = productInfoDBHelper.getWritableDatabase();
    }
    private void CloseDB(){
        productInfoDBHelper.close();
    }

    public boolean insertData(ProductInfo productInfo){
        this.OpenWrite();
        ContentValues contentValues = new ContentValues();

        contentValues.put(productInfoDBHelper.PRODUCT_NAME,productInfo.getProductName());
        contentValues.put(productInfoDBHelper.PRODUCT_PRICE,productInfo.getProductPrice());
        contentValues.put(productInfoDBHelper.PRODUCT_QUANTITY,productInfo.getProductQuantity());
        contentValues.put(productInfoDBHelper.PRODUCT_BRAND,productInfo.getProductBrand());
        contentValues.put(productInfoDBHelper.ADDITIONAL_INFO,productInfo.getAdditionalInfo());

        long insert = database.insert(productInfoDBHelper.TABLE_NAME,null,contentValues);
        this.CloseDB();
        if(insert>0){
            return true;
        }else{
            return false;
        }
    }
    public ProductInfo getSingleData(int id){
        this.OpenWrite();
        Cursor cursor = database.query(productInfoDBHelper.TABLE_NAME,new String[]{productInfoDBHelper.PRODUCT_ID,productInfoDBHelper.PRODUCT_NAME,ProductInfoDBHelper.PRODUCT_PRICE,productInfoDBHelper.PRODUCT_QUANTITY,productInfoDBHelper.PRODUCT_BRAND,productInfoDBHelper.ADDITIONAL_INFO},productInfoDBHelper.PRODUCT_ID+" = "+id,null,null,null,null);
        cursor.moveToFirst();

        int product_id = cursor.getInt(cursor.getColumnIndex(productInfoDBHelper.PRODUCT_ID));
        String product_name = cursor.getString(cursor.getColumnIndex(productInfoDBHelper.PRODUCT_NAME));
        String product_price = cursor.getString(cursor.getColumnIndex(productInfoDBHelper.PRODUCT_PRICE));
        String product_quantity = cursor.getString(cursor.getColumnIndex(productInfoDBHelper.PRODUCT_QUANTITY));
        String product_brand = cursor.getString(cursor.getColumnIndex(productInfoDBHelper.PRODUCT_BRAND));
        String addition_info = cursor.getString(cursor.getColumnIndex(productInfoDBHelper.ADDITIONAL_INFO));

        cursor.close();

        productInfo = new ProductInfo(product_id,product_name,product_price,product_quantity,product_brand,addition_info);

        this.CloseDB();

        return productInfo;
    }
    public ArrayList<ProductInfo>getAllData(){
        ArrayList<ProductInfo>product_info = new ArrayList<>();

        this.OpenWrite();

        String query = "SELECT * FROM "+productInfoDBHelper.TABLE_NAME;
        Cursor cursor =database.rawQuery(query,null);

        if(cursor != null && cursor.getCount()>0){
            cursor.moveToFirst();

            for (int i=0; i<cursor.getCount();i++){
                int product_id = cursor.getInt(cursor.getColumnIndex(productInfoDBHelper.PRODUCT_ID));
                String product_name = cursor.getString(cursor.getColumnIndex(productInfoDBHelper.PRODUCT_NAME));
                String product_price = cursor.getString(cursor.getColumnIndex(productInfoDBHelper.PRODUCT_PRICE));
                String product_quantity = cursor.getString(cursor.getColumnIndex(productInfoDBHelper.PRODUCT_QUANTITY));
                String product_brand = cursor.getString(cursor.getColumnIndex(productInfoDBHelper.PRODUCT_BRAND));
                String addition_info = cursor.getString(cursor.getColumnIndex(productInfoDBHelper.ADDITIONAL_INFO));

                productInfo = new ProductInfo(product_id,product_name,product_price,product_quantity,product_brand,addition_info);
                product_info.add(productInfo);
                cursor.moveToNext();

            }

            this.CloseDB();
            cursor.close();

            return product_info;

        }else{
            return  null;
        }
    }
    public boolean updateData(int id,ProductInfo productInfo){
        this.OpenWrite();

        ContentValues contentValues = new ContentValues();

        contentValues.put(productInfoDBHelper.PRODUCT_NAME,productInfo.getProductName());
        contentValues.put(productInfoDBHelper.PRODUCT_PRICE,productInfo.getProductPrice());
        contentValues.put(productInfoDBHelper.PRODUCT_QUANTITY,productInfo.getProductQuantity());
        contentValues.put(productInfoDBHelper.PRODUCT_BRAND,productInfo.getProductBrand());
        contentValues.put(productInfoDBHelper.ADDITIONAL_INFO,productInfo.getAdditionalInfo());

        int update = database.update(productInfoDBHelper.TABLE_NAME,contentValues,productInfoDBHelper.PRODUCT_ID+" = "+id,null);

        this.CloseDB();
        if(update>0) {
            return true;
        }else{
            return false;
        }
    }
}
