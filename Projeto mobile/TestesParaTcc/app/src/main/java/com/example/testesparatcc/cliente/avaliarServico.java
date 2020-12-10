package com.example.testesparatcc.cliente;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.testesparatcc.ClasseBanco;
import com.example.testesparatcc.R;

import static java.lang.Integer.parseInt;

public class avaliarServico extends AppCompatActivity {

    TextView txtId, txtNota;
    Button btnEnviar;
    RatingBar rtNota;

    ClasseBanco db;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.avaliar_servico);

        txtId = (TextView) findViewById(R.id.txtIdServicoAvaliacao);
        btnEnviar = (Button) findViewById(R.id.btnEnviarAvaliacao);
        rtNota = (RatingBar) findViewById(R.id.rtAvaliacaoServico);
        txtNota = (TextView) findViewById(R.id.txtNota);
        txtId.setText(PedidosFragmentCliente.idServicoStaticCliente);

        db = new ClasseBanco(avaliarServico.this);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (db.SetAvaliacaoServico(parseInt(PedidosFragmentCliente.idServicoStaticCliente), rtNota.getRating() + "")){
                    Toast.makeText(avaliarServico.this, "Avaliação enviada com sucesso!", Toast.LENGTH_SHORT).show();
                    Intent toMenu = new Intent(avaliarServico.this, MenuCliente.class);
                    startActivity(toMenu);
                } else
                    Toast.makeText(avaliarServico.this, "Erro ao avaliar", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
