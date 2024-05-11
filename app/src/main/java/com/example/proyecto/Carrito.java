package com.example.proyecto;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class Carrito extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);

        // Obtener datos de la lista de productos del intent
        ArrayList<Producto> productos = (ArrayList<Producto>) getIntent().getSerializableExtra("productos");

        // Mostrar los productos agregados en un TextView
        TextView textViewProductos = findViewById(R.id.textViewProductos);
        StringBuilder sb = new StringBuilder();
        double totalPrecio = 0.0;
        for (Producto producto : productos) {
            sb.append(producto.getNombre()).append(" - $").append(producto.getPrecio()).append("\n");
            totalPrecio += producto.getPrecio();
        }
        textViewProductos.setText(sb.toString());

        // Mostrar el total del precio
        final double finalTotalPrecio = totalPrecio;
        TextView textViewTotalPrice = findViewById(R.id.textViewTotalPrice);
        textViewTotalPrice.setText("Total: $" + finalTotalPrecio);

        // Botón para regresar al menú principal
        Button btnMenu = findViewById(R.id.button18);
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear intent para volver al menú principal
                Intent intent = new Intent(Carrito.this, Menu.class);
                startActivity(intent);
                // Finalizar la actividad actual para liberar recursos
                finish();
            }
        });

        // Botón para pagar
        Button btnPagar = findViewById(R.id.buttonPay);
        btnPagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Verificar si el saldo es suficiente
                if (saldoSuficiente(finalTotalPrecio)) {
                    // Si el saldo es suficiente, realizar el pago
                    // Aquí podrías agregar el código para realizar el pago
                } else {
                    // Si el saldo no es suficiente, mostrar un mensaje
                    Toast.makeText(Carrito.this, "Saldo insuficiente", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Función para verificar si el saldo es suficiente para realizar el pago
    private boolean saldoSuficiente(double total) {
        // Aquí podrías implementar la lógica para verificar si el saldo es suficiente
        return false; // Por defecto, devolvemos false para este ejemplo
    }
}
