package com.example.aplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class InformacionActivity extends AppCompatActivity {
    TextView tvNombre, tvApellido, tvGenero, tvLibreta, tvEstrato;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.informacion);

        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvApellido = (TextView) findViewById(R.id.tvApellido);
        tvGenero = (TextView) findViewById(R.id.tvGenero);
        tvLibreta = (TextView) findViewById(R.id.tvLibreta);
        tvEstrato = (TextView) findViewById(R.id.tvEstrato);

        tvNombre.setText("Nombre: " + getIntent().getStringExtra("nombre"));
        tvApellido.setText("Apellido: " + getIntent().getStringExtra("apellido"));
        tvGenero.setText("Género: " + getIntent().getStringExtra("genero"));
        tvLibreta.setText(getIntent().getBooleanExtra("libreta", false) ? "Tiene Libreta Militar" : "No tiene Libreta Militar");
        tvEstrato.setText("Estrato Socioeconómico: " + getIntent().getIntExtra("estrato", 1));

    }

    public void Atras(View v){
        Intent in = new Intent(this, Activity2.class);
        in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(in);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }
}