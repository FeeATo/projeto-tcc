package com.example.testesparatcc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ContratarPlano extends AppCompatActivity {

    TextView btnContratarPlano, btnVoltarMenu;
    public static int SetIDPlanoContrato;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contratar_plano);

        btnContratarPlano = (TextView) findViewById(R.id.btnContratarPlano);
        btnVoltarMenu = (TextView) findViewById(R.id.btnVoltarMenu);

        btnContratarPlano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetIDPlanoContrato = 2;
                Intent toPagamento = new Intent(ContratarPlano.this, PagarPlano.class);
                startActivity(toPagamento);
            }
        });

        btnVoltarMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toMenu = new Intent(ContratarPlano.this, Menu.class);
                startActivity(toMenu);
            }
        });

    }
}
