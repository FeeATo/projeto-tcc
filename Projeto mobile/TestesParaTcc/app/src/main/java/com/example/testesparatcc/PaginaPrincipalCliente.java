package com.example.testesparatcc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.testesparatcc.cliente.*;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class PaginaPrincipalCliente extends AppCompatActivity {

    Button btnLoginCliente, btnCadastroCliente;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.paginaprincipalcliente);

        btnCadastroCliente = (Button) findViewById(R.id.btnCadastrarCliente);
        btnLoginCliente = (Button) findViewById(R.id.btnLoginCliente);

        btnCadastroCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toCadastro = new Intent(PaginaPrincipalCliente.this, CadastroCliente.class);
                startActivity(toCadastro);
            }
        });

        btnLoginCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toLogin = new Intent(PaginaPrincipalCliente.this, LoginCliente.class);
                startActivity(toLogin);
            }
        });
    }
}
