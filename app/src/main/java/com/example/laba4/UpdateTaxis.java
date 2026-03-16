package com.example.laba4;

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

public class UpdateTaxis extends AppCompatActivity {
    private EditText editTextNameUpdt, editTextBrandCarUpdt, editTextNumberCarUpdt, editTextRatingUpdt, editTextIDUpdt;
    private Button buttonUpdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SQLHelper dbHelper = new SQLHelper(this);
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_update_taxis);

        editTextNameUpdt = findViewById(R.id.editTextNameUpdt);
        editTextBrandCarUpdt = findViewById(R.id.editTextBrandCarUpdt);
        editTextNumberCarUpdt = findViewById(R.id.editTextNumberCarUpdt);
        editTextRatingUpdt = findViewById(R.id.editTextRatingUpdt);
        editTextIDUpdt = findViewById(R.id.editTextIDUpdt);

        buttonUpdate = findViewById(R.id.buttonUpdate);
        ImageButton buttonBack = findViewById(R.id.buttonBack);

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextNameUpdt.getText().toString();
                String brandCar = editTextBrandCarUpdt.getText().toString();
                String numberCarStr = editTextNumberCarUpdt.getText().toString();
                int numberCar = Integer.parseInt(numberCarStr);
                String ratingStr = editTextRatingUpdt.getText().toString();
                float rating = Float.parseFloat(ratingStr);
                String idStr = editTextIDUpdt.getText().toString();
                int idUpdt = Integer.parseInt(idStr);

                long id = dbHelper.updateTaxis(new Taxis(idUpdt, name, brandCar, numberCar, rating));
                if (id != -1) {
                    Toast.makeText(UpdateTaxis.this, "Таксист обновлен", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(UpdateTaxis.this, "Ошибка обновления таксиста", Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(UpdateTaxis.this, "Запись сохранена", Toast.LENGTH_SHORT).show();
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