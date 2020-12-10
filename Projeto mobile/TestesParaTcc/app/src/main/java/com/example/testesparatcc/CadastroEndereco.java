package com.example.testesparatcc;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import static java.lang.Integer.parseInt;

public class CadastroEndereco extends AppCompatActivity {

    ClasseBanco db;
    Context context;

    public Button btnNext;
    public TextView txtRua, txtNumero, txtComplemento, txtPonto, txtEndereco, txtComplementoFim;

    String[] ArrayEndereco;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadendereco);

        txtRua = (EditText) findViewById(R.id.editRua);
        txtNumero = (EditText) findViewById(R.id.editNumero);
        txtComplemento = (EditText) findViewById(R.id.editComplemento);
        txtPonto = (EditText) findViewById(R.id.editPonto);
        txtEndereco = (TextView) findViewById(R.id.txtEnderecoENumero);
        txtComplementoFim = (TextView) findViewById(R.id.txtComplementoFim);
        btnNext = (Button) findViewById(R.id.btnNextEnd);

        txtEndereco.setText("");
        txtComplementoFim.setText("");

        db = new ClasseBanco(this);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!txtRua.getText().toString().isEmpty() && !txtNumero.getText().toString().isEmpty()) {
                    boolean query = db.AddEnderecoByEmail(txtRua.getText().toString(), txtComplemento.getText().toString(), parseInt(txtNumero.getText().toString()), MainActivity.SetEmail);
                    if(query){
                        Intent cadEndereco = new Intent(CadastroEndereco.this, CadastroRgCpf.class);
                        startActivity(cadEndereco);
                    }
                } else{
                    Toast.makeText(CadastroEndereco.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        txtRua.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                txtEndereco.setText(txtRua.getText().toString() + "");

            }

            @Override
            public void afterTextChanged(Editable s) {
                txtEndereco.setText(txtRua.getText().toString() + ", ");
                ArrayEndereco = txtRua.getText().toString().split(", ");
            }
        });

        txtNumero.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                txtEndereco.setText(ArrayEndereco[0] + ", "+txtNumero.getText().toString() + "");
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        txtComplemento.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                txtComplementoFim.setText(txtComplemento.getText().toString() + "");
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

    }
}
