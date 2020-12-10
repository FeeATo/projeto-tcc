package com.example.testesparatcc;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class PaginaPrincipal extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.primeirapagina);

        Button btnCadastrar = (Button) findViewById(R.id.btnCadastrar);
        Button btnLogin = (Button) findViewById(R.id.btnLogar);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cadastrar = new Intent(PaginaPrincipal.this, MainActivity.class);
                startActivity(cadastrar);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logar = new Intent(PaginaPrincipal.this, Login.class);
                startActivity(logar);
            }
        });
    }
}
