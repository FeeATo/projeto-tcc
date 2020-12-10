package com.example.testesparatcc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    ClasseBanco db;
    public TextView  btnCadastro;
    EditText editEmail, editSenha;
    Button btnLogin, btnCriarPlano;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_func);

        editEmail = (EditText) findViewById(R.id.editEmailLogin);
        editSenha = (EditText) findViewById(R.id.editSenhaLogin);
        btnCadastro = (TextView) findViewById(R.id.txtCadastrar);
        btnLogin = (Button) findViewById(R.id.btnLogin);


        db = new ClasseBanco(this);



        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String query = "select senha from PrestServ9 where email='"+editEmail.getText().toString()+"'";
                String senha = db.getData(query, getBaseContext());
                if(editSenha.getText().toString().equals(senha))
                {
                    MainActivity.SetEmail = editEmail.getText().toString();
                    Intent menu = new Intent(Login.this, Menu.class);
                    startActivity(menu);
                }
                else
                {
                    Toast.makeText(getBaseContext(),"Credêncial inválida",Toast.LENGTH_SHORT).show();
                }
            }

        });

        btnCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cadastro = new Intent(Login.this, MainActivity.class);
                startActivity(cadastro);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
