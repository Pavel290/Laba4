package com.example.laba4;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class SQLHelper extends SQLiteOpenHelper {
    // Константы для базы данных и таблицы
    public static final String DATABASE_NAME = "DataBase.db";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "MyTable";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "fio";
    public static final String COLUMN_BRAND_CAR = "car_brand";
    public static final String COLUMN_NUMBER_CAR = "number_car";
    public static final String COLUMN_RATING = "rating";

    // SQL запрос для создания таблицы
    private static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID          + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_NAME        + " TEXT NOT NULL, "        +
                    COLUMN_BRAND_CAR   + " TEXT NOT NULL, "              +
                    COLUMN_NUMBER_CAR  + " INTEGER, "              +
                    COLUMN_RATING      + " REAL"                   +
                    ")";

    public SQLHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    public long addTaxis(String fio, String brand_car, int number_car, float rating) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, fio);
        values.put(COLUMN_BRAND_CAR, brand_car);
        values.put(COLUMN_NUMBER_CAR, number_car);
        values.put(COLUMN_RATING, rating);
        long id = db.insert(TABLE_NAME, null, values);
        db.close();
        return id;
    }
    public ArrayList<Taxis> getAllTaxis() {
        ArrayList<Taxis> taxisList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID));
                @SuppressLint("Range") String fio = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
                @SuppressLint("Range") String brand_car = cursor.getString(cursor.getColumnIndex(COLUMN_BRAND_CAR));
                @SuppressLint("Range") int nuber_car = cursor.getInt(cursor.getColumnIndex(COLUMN_NUMBER_CAR));
                @SuppressLint("Range") float rating = cursor.getFloat(cursor.getColumnIndex(COLUMN_RATING));
                taxisList.add(new Taxis(id, fio, brand_car, nuber_car, rating));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return taxisList;
    }
    public int updateTaxis(Taxis taxis) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, taxis.getFio());
        values.put(COLUMN_BRAND_CAR, taxis.getBrand_car());
        values.put(COLUMN_NUMBER_CAR, taxis.getNumber_car());
        values.put(COLUMN_RATING, taxis.getRating());
        return db.update(TABLE_NAME, values, COLUMN_ID + " = ?",
                new String[]{String.valueOf(taxis.getId())});
    }
    public void deleteTaxis(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, COLUMN_ID + " = ?",
                new String[]{String.valueOf(id)});
        db.close();
    }
}