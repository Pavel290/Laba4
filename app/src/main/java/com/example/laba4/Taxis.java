package com.example.laba4;

import static com.example.laba4.SQLHelper.COLUMN_BRAND_CAR;
import static com.example.laba4.SQLHelper.COLUMN_NAME;
import static com.example.laba4.SQLHelper.COLUMN_NUMBER_CAR;
import static com.example.laba4.SQLHelper.COLUMN_RATING;
import static com.example.laba4.SQLHelper.TABLE_NAME;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import kotlin.text.UStringsKt;

public class Taxis {
    private int id;
    private String fio;
    private String brand_car;
    private int number_car;
    private  float rating;

    public Taxis(int id, String fio, String brand_car, int nuber_car, float rating) {
        this.id = id;
        this.fio = fio;
        this.brand_car = brand_car;
        this.number_car = nuber_car;
        this.rating = rating;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getFio() { return fio; }
    public void setFio(String fio) { this.fio = fio; }

    public String getBrand_car() { return brand_car; }
    public void setBrand_car(String brand_car) { this.brand_car = brand_car; }
    public int getNumber_car() { return number_car; }
    public void setNumber_car(int number_car) { this.number_car = number_car; }
    public float getRating() { return rating; }
    public void setRating(float rating) { this.rating = rating; }
}
