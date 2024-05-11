package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.util.ArrayList;

public class Hombre extends AppCompatActivity implements View.OnClickListener {
    // Lista de productos
    private ArrayList<Producto> productos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hombre);

        productos = new ArrayList<>();

        Button btnProduct1 = findViewById(R.id.button3);
        Button btnProduct2 = findViewById(R.id.button4);
        Button btnProduct3 = findViewById(R.id.button5);
        Button btnProduct4 = findViewById(R.id.button6);
        Button btnProduct5 = findViewById(R.id.button7);
        Button btnProduct6 = findViewById(R.id.button8);

        btnProduct1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregarProducto("Champions T-shirt Blue", 195400);
            }
        });

        btnProduct2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregarProducto("Champions Basic T-shirt Cream", 195000);
            }
        });

        btnProduct3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregarProducto("Champions T-shirt Black", 164500);
            }
        });

        btnProduct4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregarProducto("Champions T-shirt White", 164500);
            }
        });

        btnProduct5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregarProducto("Thereal Backflip T-shirt White", 250000);
            }
        });

        btnProduct6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregarProducto("Zip-up Hoodie Black", 475000);
            }
        });

        // Botón "Carrito"
        Button btnCarrito = findViewById(R.id.button10);
        btnCarrito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear intent para abrir la actividad del carrito
                Intent intent = new Intent(Hombre.this, Carrito.class);
                // Pasar la lista de productos al carrito (si es necesario)
                intent.putExtra("productos", productos);
                // Iniciar la actividad del carrito
                startActivity(intent);
            }
        });

        // Botón "Menú"
        Button btnMenu = findViewById(R.id.button9);
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear intent para volver al menú principal
                Intent intent = new Intent(Hombre.this, Menu.class);
                // Pasar la lista de productos al menú principal
                intent.putExtra("productos", productos);
                // Iniciar la actividad del menú principal
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View v) {
        // Manejar los clics de los botones si es necesario
    }

    private void agregarProducto(String nombre, double precio) {
        Producto producto = new Producto(nombre, precio);
        productos.add(producto);
    }
}
