package com.example.testesparatcc;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.testesparatcc.cliente.FinalizarPedido;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class AceitarServico extends AppCompatActivity {

    TextView txtNome, txtEndereco, txtNumero,txtComplemento, txtDistancia;
    ClasseBanco db;
    Button btnConfirmar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aceitar_servico_prestador);

        txtNome = (TextView) findViewById(R.id.txtNomeClienteAceitar);
        txtEndereco = (TextView) findViewById(R.id.txtEnderecoClienteAceitar);
        txtNumero = (TextView) findViewById(R.id.txtNumeroClienteAceitar);
        txtComplemento = (TextView) findViewById(R.id.txtComplementoClienteAceitar);
        txtDistancia = (TextView) findViewById(R.id.txtDistanciaClienteAceitar);
        btnConfirmar = (Button) findViewById(R.id.btnConfirmarAceitarServico);

        db = new ClasseBanco(this);

        GetServiceDataById(parseInt(Menu.idServico));


        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AreYouSure();
            }
        });

    }

    public void AreYouSure(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Tem certeza que quer aceitar o serviço?")
                .setCancelable(false)
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        boolean foi;
                        foi = db.AceitarPedidoPrestadorById(parseInt(Menu.idServico), AceitarServico.this);
                        if(foi){
                            Toast.makeText(AceitarServico.this, "Serviço aceito", Toast.LENGTH_SHORT).show();
                            Intent toServices = new Intent(AceitarServico.this, Menu.class);
                            startActivity(toServices);


                        } else
                            Toast.makeText(AceitarServico.this, "Erro ao aceitar servico", Toast.LENGTH_SHORT).show();
                    }
                })

                .setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.cancel();
                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void GetServiceDataById(int id_servico) {
        try
        {
            SQLiteDatabase objectSQLite = db.getWritableDatabase();
            //Cursor data = objectSQLite.rawQuery("select nome_usu, endereco, numero, complemento from Usuario where id in (select id_cliente from Servico where id_servico="+id_servico+")",null);
            Cursor data = objectSQLite.rawQuery("select nome_usu, endereco, numero, complemento from Usuario",null);

            if (data.moveToFirst()) {
                do {
                    txtNome.setText(data.getString(0));
                    txtEndereco.setText(data.getString(1));
                    txtNumero.setText(data.getString(2));
                    txtComplemento.setText(data.getString(2));

                } while (data.moveToNext());

            }

        }catch (Exception ex){
            Toast.makeText(AceitarServico.this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }
}
