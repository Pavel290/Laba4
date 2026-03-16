package com.example.laba4;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private LinearLayout container;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SQLHelper dbHelper = new SQLHelper(this);
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        container = findViewById(R.id.container);

        Button btnAdd = findViewById(R.id.btnAdd);
        Button btnShow = findViewById(R.id.btnShow);
        Button btnUpdate = findViewById(R.id.btnUpdate);
        Button btnDelete = findViewById(R.id.btnDelete);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddRecordActivity.class);
                startActivity(intent);
            }
        });

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayAllTaxis(dbHelper);
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, UpdateTaxis.class);
                startActivity(intent);
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, delete.class);
                startActivity(intent);
            }
        });
    }
    public void displayAllTaxis(SQLHelper db) {
        ArrayList<Taxis> worker = db.getAllTaxis();
        container.removeAllViews();

        if (worker.isEmpty()) {
            TextView emptyView = new TextView(this);
            emptyView.setText("Список студентов пуст");
            container.addView(emptyView);
            return;
        }

        for (Taxis taxis : worker) {
            TextView textView = new TextView(this);
            textView.setText(taxis.getId() + ": " + taxis.getFio() + ", марка машины " + taxis.getBrand_car() + " номер машины " + taxis.getNumber_car() + " рйтинг такстса " + + taxis.getRating());
            textView.setTextSize(16);
            textView.setPadding(8, 8, 8, 8);
            container.addView(textView);
        }
    }
}