package com.example.testesparatcc;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.braintreepayments.cardform.view.CardForm;

public class PagarPlano extends AppCompatActivity {

    Button btnPagar;
    ClasseBanco db;
    TextView txtMensagem;
    AlertDialog.Builder alertBuilder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pagar_plano);


        btnPagar = (Button) findViewById(R.id.btnPagar);
        txtMensagem = (TextView) findViewById(R.id.txtMensagemPagamento);
        db = new ClasseBanco(this);
        txtMensagem.setText("");


        btnPagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(db.ContratarPlanoById(db.GetIdPrestByEmail(MainActivity.SetEmail))){
                    Intent toSplash = new Intent(PagarPlano.this, SplashScreenPlano.class);
                    startActivity(toSplash);
                }
            }
        });
    }
}
