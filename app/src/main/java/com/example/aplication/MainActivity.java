package com.example.aplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etPassword, etName;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPassword = (EditText)findViewById(R.id.etPassword);
        etName = (EditText)findViewById(R.id.etName);
        btnLogin = (Button) findViewById(R.id.btnLogin);


    }

    public void login(View v){
        if(etPassword.getText().length() == 0 || etName.getText().length() == 0){
            Toast.makeText(this,"¡Debe llenar los campos!", Toast.LENGTH_SHORT).show();
        } else {
            Intent in = new Intent(this, Activity2.class);
            in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(in);
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