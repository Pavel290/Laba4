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

public class delete extends AppCompatActivity {
    private EditText DelID;
    private Button buttonDelete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_delete);
        SQLHelper dbHelper = new SQLHelper(this);

        DelID = findViewById(R.id.DelID);
        buttonDelete = findViewById(R.id.btnDelete);
        ImageButton buttonBack = findViewById(R.id.buttonBack);

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idStr = DelID.getText().toString();
                int idInt = Integer.parseInt(idStr);

                dbHelper.deleteTaxis(idInt);

                Toast.makeText(delete.this, ("Запись с id: " + idInt + " удалена"), Toast.LENGTH_SHORT).show();
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