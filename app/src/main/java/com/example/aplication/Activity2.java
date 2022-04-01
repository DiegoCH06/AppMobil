package com.example.aplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {

    SeekBar seek;
    TextView tvEstrato;
    EditText etNombre, etApellido;
    RadioGroup rgGenero;
    CheckBox checkBox;
    String genero;
    int estrato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        seek = (SeekBar) findViewById(R.id.seekBar);
        tvEstrato = (TextView) findViewById(R.id.tvEstrato);
        etNombre = (EditText) findViewById(R.id.tvNombre);
        etApellido = (EditText) findViewById(R.id.tvApellido);
        rgGenero =(RadioGroup) findViewById(R.id.rgGenero);
        checkBox = (CheckBox) findViewById(R.id.checkBox);

        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                estrato = i;
                tvEstrato.setText("Estrato SocioEconomico: "+i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        genero = "";
        estrato = 1;
    }

    public void radioButton(View v){
        boolean checked = ((RadioButton) v).isChecked();

        // Check which radio button was clicked
        switch(v.getId()) {
            case R.id.rbMasculino:
                if (checked)
                    genero = "Masculino";
                    break;
            case R.id.rbFemenino:
                if (checked)
                    genero = "Femenino";
                    break;
        }
    }

    public void registrar(View v){

        if(etNombre.getText().toString().isEmpty() || etApellido.getText().toString().isEmpty() ||
            genero.isEmpty()){
            new AlertDialog.Builder(this).setTitle("Error de información").
                    setMessage("Debe llenar todo el formulario para poder registrarse en la aplicación")
                    .setCancelable(true)
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    }).show();
        } else {
            Intent i = new Intent(this, InformacionActivity.class);
            i.putExtra("nombre", etNombre.getText().toString());
            i.putExtra("apellido", etApellido.getText().toString());
            i.putExtra("estrato", estrato);
            i.putExtra("genero", genero);
            i.putExtra("libreta", checkBox.isChecked());
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);
        }

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