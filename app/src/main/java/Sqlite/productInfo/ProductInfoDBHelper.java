package Sqlite.productInfo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.mdarifur.product_info.InsertData;

/**
 * Created by MD.Arifur on 7/21/2016.
 */
public class ProductInfoDBHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "product_db.db";
    public static final int DB_VERSION = 1;

    public static final String TABLE_NAME ="product_info";

    public static final String PRODUCT_ID ="id";
    public static final String PRODUCT_NAME ="name";
    public static final String PRODUCT_PRICE ="price";
    public static final String PRODUCT_QUANTITY ="quantity";
    public static final String PRODUCT_BRAND ="brand";
    public static final String ADDITIONAL_INFO ="info";


    public static final String TABLE_QUERY = "CREATE TABLE "+TABLE_NAME+"( "+PRODUCT_ID+" integer PRIMARY KEY, "+PRODUCT_NAME+" text, "+PRODUCT_PRICE+" text, "+PRODUCT_QUANTITY+" text, "+PRODUCT_BRAND+" text, "+ADDITIONAL_INFO+" text);";


    public static final String TABLE_DROP = "drop table if exists"+TABLE_NAME;

    public ProductInfoDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(TABLE_DROP);
        onCreate(db);
    }
}
