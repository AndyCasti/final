package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class Sign_up extends AppCompatActivity {

    EditText nombre;
    EditText apellido;
    EditText fecha;
    EditText email;
    EditText contraseña;
    EditText confirmar;
    Button buttonSignUp;
    FirebaseAuth mAuth;
    FirebaseFirestore mFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        // Inicializar Firebase Authentication
        mAuth = FirebaseAuth.getInstance();

        // Inicializar Firebase Firestore
        mFirestore = FirebaseFirestore.getInstance();

        Button buttonMenu = findViewById(R.id.button17);
        nombre = findViewById(R.id.nombre);
        apellido = findViewById(R.id.apellido);
        fecha = findViewById(R.id.fecha);
        email = findViewById(R.id.email);
        contraseña = findViewById(R.id.contraseña);
        confirmar = findViewById(R.id.confirmar);
        buttonSignUp = findViewById(R.id.buttonSignUp);

        buttonMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });
    }

    private void register() {
        String name = nombre.getText().toString();
        String surname = apellido.getText().toString();
        String date = fecha.getText().toString();
        String correo = email.getText().toString();
        String password = contraseña.getText().toString();
        String confirm = confirmar.getText().toString();

        if (!name.isEmpty() && !surname.isEmpty() && !date.isEmpty() && !password.isEmpty() && !confirm.isEmpty()) {
            if (isEmailValid(correo)) {
                // Registrar el usuario utilizando FirebaseAuth
                mAuth.createUserWithEmailAndPassword(correo, password)
                        .addOnCompleteListener(Sign_up.this, task -> {
                            if (task.isSuccessful()) {
                                // El registro fue exitoso
                                Toast.makeText(Sign_up.this, "Registro exitoso", Toast.LENGTH_SHORT).show();
                                // Aquí puedes redirigir al usuario a la siguiente actividad o realizar otras acciones
                            } else {
                                // Si el registro falla, mostrar un mensaje al usuario
                                Toast.makeText(Sign_up.this, "Error al registrar", Toast.LENGTH_SHORT).show();
                            }
                        });
            } else {
                // El correo electrónico no es válido
                Toast.makeText(Sign_up.this, "Correo electrónico no válido", Toast.LENGTH_SHORT).show();
            }
        } else {
            // Todos los campos deben estar completos
            Toast.makeText(Sign_up.this, "Por favor completa todos los campos", Toast.LENGTH_SHORT).show();
        }
    }

    // Función para validar el correo electrónico
    public boolean isEmailValid(String correo) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(correo).matches();
    }
}
