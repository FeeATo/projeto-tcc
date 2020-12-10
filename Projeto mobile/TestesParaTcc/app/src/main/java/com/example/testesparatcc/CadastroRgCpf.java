package com.example.testesparatcc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import static java.lang.Integer.parseInt;

public class CadastroRgCpf extends AppCompatActivity {

    EditText txtRg, txtCpf;
    Button btnProximo;
    ClasseBanco db;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadrgcpf);

        txtRg = (EditText) findViewById(R.id.editRG);
        txtCpf = (EditText) findViewById(R.id.editCPF);
        btnProximo = (Button) findViewById(R.id.btnNextRGCPF);

        db = new ClasseBanco(this);

        btnProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!txtCpf.getText().toString().isEmpty() && !txtRg.getText().toString().isEmpty()) {
                    boolean query = db.AddRgCpfByEmail(txtCpf.getText().toString(), MainActivity.SetEmail);
                    if (query) {
                        Intent cadServico = new Intent(CadastroRgCpf.this, CadastroServico.class);
                        startActivity(cadServico);
                    } else {
                        Toast.makeText(CadastroRgCpf.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });



    }
}
