package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // Obtener referencias a los botones
        Button buttonInicio = findViewById(R.id.button5);
        Button buttonHombre = findViewById(R.id.button6);
        Button buttonMujer = findViewById(R.id.button7);
        Button buttonIniciarsesion = findViewById(R.id.button8);
        Button buttonRegistrarme = findViewById(R.id.button9);

        buttonInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }

        });

        buttonHombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, Hombre.class);
                startActivity(intent);
            }
        });

        buttonMujer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, Mujer.class);
                startActivity(intent);
            }
        });

        buttonIniciarsesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, Login.class);
                startActivity(intent);
            }
        });

        buttonRegistrarme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, Sign_up.class);
                startActivity(intent);
            }
        });

    }
}
