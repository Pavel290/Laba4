package com.example.laba4;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddRecordActivity extends AppCompatActivity {
    private EditText editTextName, editTextBrandCar, editTextNumberCar, editTextRating;
    private Button buttonSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SQLHelper dbHelper = new SQLHelper(this);
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity);

        editTextName = findViewById(R.id.editTextName);
        editTextBrandCar = findViewById(R.id.editTextBrandCar);
        editTextNumberCar = findViewById(R.id.editTextNumberCar);
        editTextRating = findViewById(R.id.editTextRating);

        buttonSave = findViewById(R.id.buttonSave);
        ImageButton buttonBack = findViewById(R.id.buttonBack);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                String brandCar = editTextBrandCar.getText().toString();
                String numberCarStr = editTextNumberCar.getText().toString();
                int numberCar = Integer.parseInt(numberCarStr);
                String ratingStr = editTextRating.getText().toString();
                float rating = Float.parseFloat(ratingStr);

                long id = dbHelper.addTaxis(name, brandCar, numberCar, rating);
                if (id != -1) {
                    Toast.makeText(AddRecordActivity.this, "Таксист добавлен с ID: " + id, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(AddRecordActivity.this, "Ошибка добавления таксиста", Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(AddRecordActivity.this, "Запись сохранена", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}