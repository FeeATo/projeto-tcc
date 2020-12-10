package com.example.testesparatcc.cliente;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.testesparatcc.ClasseBanco;
import com.example.testesparatcc.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class PrestadorProfile extends AppCompatActivity {

    TextView txtId, txtNome, txtTelefone, txtEmail, txtServico, txtQntd;
    RatingBar rtNota;
    ImageView imgView;
    Button btnContratar;
    ClasseBanco db;
    public Cursor cursor;
    float soma = 0;
    float media;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prestador_profile);

        txtId = (TextView) findViewById(R.id.txtIdPrestProfile);
        txtNome = (TextView) findViewById(R.id.txtNomePrestProfile);
        txtTelefone = (TextView) findViewById(R.id.txtTelefonePrestProfile);
        txtEmail = (TextView) findViewById(R.id.txtEmailPrestProfile);
        txtServico = (TextView) findViewById(R.id.txtServicoPrestProfile);
        btnContratar = (Button) findViewById(R.id.btnContratar);
        imgView = (ImageView) findViewById(R.id.imagePrestadorProfile);
        txtQntd = (TextView) findViewById(R.id.txtQtndPerfilPrestador);
        rtNota = (RatingBar) findViewById(R.id.rtbarPerfilPrestador);


        db = new ClasseBanco(this);
        List<String> lst = new ArrayList<String>();
        String quantidadeServicos = db.contar_registros("select count(*) from Servico where id_prestador="+ parseInt(ListaPrestadores.idPrestador)+" and status_servico='Finalizado'");
        lst = db.getPrestadorData("select id, nome, telefone, email, tipo_serv, id_plano from PrestServ9 where id='"+parseInt(ListaPrestadores.idPrestador)+"'");
        String[] dados = lst.toString().split(" - ");

        imgView.setImageBitmap(db.getImagePrestador(parseInt(ListaPrestadores.idPrestador)));

        txtId.setText(dados[0].replace("[", ""));
        txtNome.setText(dados[1]);
        txtTelefone.setText(dados[2]);
        txtEmail.setText(dados[3]);
        txtServico.setText(dados[4]);

        rtNota.setRating(GetMediaAvaliacao(parseInt(ListaPrestadores.idPrestador)));
        txtQntd.setText(quantidadeServicos + " serviço(s) realizado(s)");

        btnContratar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Intent toConfirmar = new Intent(PrestadorProfile.this, FinalizarPedido.class);
                 startActivity(toConfirmar);
            }
        });

        txtTelefone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://api.whatsapp.com/send?phone=55"+txtTelefone.getText().toString().replace(" ",""))));
            }
        });

    }

    public float GetMediaAvaliacao(int id_prestador) {
        List<String> list = new ArrayList<String>();
        try {
            SQLiteDatabase objSQLiteDatabase = db.getWritableDatabase();
            cursor = objSQLiteDatabase.rawQuery("select avaliacao from Servico where id_prestador=" + id_prestador + " and avaliacao !='Pendente'", null);

            if (cursor.moveToFirst()) {
                do{
                    list.add(cursor.getString(0));
                } while (cursor.moveToNext());

            }
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }

            String[] notas = list.toArray(new String[list.size()]);

            for (String n : notas){
                soma = soma + Float.parseFloat(n);
            }

            media = soma / notas.length;
            System.out.println("Soma:" + soma);
            System.out.println("Notas size:" + notas.length);
            System.out.println("Média:" + media);
            return media;
        } catch (Exception ex) {
            Log.e("ERROR", "Erro ao mostrar avaliacao media:" + ex.getMessage());
            Toast.makeText(PrestadorProfile.this, ex.getMessage(), Toast.LENGTH_LONG).show();
            return 0;
        }
    }

}
