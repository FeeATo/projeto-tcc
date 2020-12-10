package com.example.testesparatcc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class InfoDeTrampo extends AppCompatActivity {

    Button btnCadImagem, btnCadEndereco, btnRGCPF, btnServico, btnAcordosLegais;
    TextView txtFalta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maisinformacoescadastro);

        btnCadImagem = (Button) findViewById(R.id.btnImg);
        btnCadEndereco = (Button) findViewById(R.id.btnEndereco);
        btnRGCPF = (Button) findViewById(R.id.btnRgCpf);
        btnServico = (Button) findViewById(R.id.btnServico);
        btnAcordosLegais = (Button) findViewById(R.id.btnAcordosLegais);
        txtFalta = (TextView) findViewById(R.id.txtFalta);

        txtFalta.setText("Falta pouco, " + MainActivity.SetName + "!");

        btnCadImagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent CadastroFoto = new Intent(InfoDeTrampo.this, CadastroFoto.class);
                startActivity(CadastroFoto);
            }
        });


    }
}
