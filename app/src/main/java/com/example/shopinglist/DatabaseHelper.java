package com.example.shopinglist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Date;
import java.util.List;

import java.text.SimpleDateFormat;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Logcat tag
    private static final String LOG = "DatabaseHelper";
    // Database Name
    public static final String DATABASE_NAME = "MyDBName.db";
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Table Names
    private static final String TABLE_SHOPPING = "shopping";

    // Common column names
    private static final String KEY_ID = "id";
    private static final String KEY_CREATED_AT = "created_at";

    // Shopping Table - column names
    private static final String KEY_ALISVERIS_ADI = "alisverisAdi";
    private static final String KEY_URUN_ADI = "urunAdi";
    private static final String KEY_URUN_MIKTARI = "urunMiktari";
    private static final String KEY_URUN_ADEDI = "urunAdedi";
    private static final String KEY_URUN_FIYATI = "urunFiyati";
    private static final String KEY_URUN_NOT = "urunNot";

    // Shopping table create statement
    private static final String CREATE_TABLE_SHOPPING_ADD = "CREATE TABLE " + TABLE_SHOPPING
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_ALISVERIS_ADI + " TEXT,"
            + KEY_URUN_ADI + " TEXT,"
            + KEY_URUN_MIKTARI + " TEXT,"
            + KEY_URUN_ADEDI + " TEXT,"
            + KEY_URUN_FIYATI + " TEXT,"
            + KEY_URUN_NOT + " TEXT,"
            + KEY_CREATED_AT + " DATETIME" + ")";

    public DatabaseHelper(Context context) {

        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // creating required tables
        db.execSQL(CREATE_TABLE_SHOPPING_ADD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_SHOPPING );
        // create new tables
        onCreate(db);
    }

    public boolean shoppingAdd(String alisverisAdi, String urunAdi,String urunMiktari,
                               String urunAdedi,String urunFiyati,String urunNot) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("alisverisAdi",alisverisAdi);
        cv.put("urunAdi",urunAdi);
        cv.put("urunMiktari",urunMiktari);
        cv.put("urunAdedi",urunAdedi);
        cv.put("urunFiyati",urunFiyati);
        cv.put("urunNot",urunNot);


        long result = sqLiteDatabase.insert("shopping", null, cv);
        return result != -1;
    }

}
