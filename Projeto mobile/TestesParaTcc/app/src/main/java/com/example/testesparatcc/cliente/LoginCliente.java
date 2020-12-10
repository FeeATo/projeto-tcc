package com.example.testesparatcc.cliente;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.testesparatcc.ClasseBanco;
import com.example.testesparatcc.Login;
import com.example.testesparatcc.MainActivity;
import com.example.testesparatcc.Menu;
import com.example.testesparatcc.R;

public class LoginCliente extends AppCompatActivity {

    TextView txtEmail, txtSenha;
    Button btnLogar;
    ClasseBanco db;
    Context cx;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_cliente);

        db = new ClasseBanco(this);
        db.criar_tabela(this);

        txtEmail = (TextView) findViewById(R.id.editEmailCliente);
        txtSenha = (TextView) findViewById(R.id.editSenhaCliente);

        btnLogar = (Button) findViewById(R.id.btnEntrarCliente);

        btnLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String query = "select senha from usuario where email='"+txtEmail.getText().toString()+"'";
                String senha = db.getData(query, getBaseContext());
                if(txtSenha.getText().toString().equals(senha))
                {
                    CadastroCliente.SetEmailCliente = txtEmail.getText().toString();
                    Intent menuCliente = new Intent(LoginCliente.this, MenuCliente.class);
                    startActivity(menuCliente);
                } else{
                    Toast.makeText(LoginCliente.this, "Senha incorreta", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
