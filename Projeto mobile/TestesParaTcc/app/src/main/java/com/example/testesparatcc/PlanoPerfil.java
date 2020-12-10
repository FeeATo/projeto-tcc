package com.example.testesparatcc;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import static java.lang.Integer.parseInt;

public class PlanoPerfil extends AppCompatActivity {

    TextView txtPlano, txtAparecer, txtSuporte, txtDivulgacao, txtPromocoes, txtDescontos;
    Button btnToContratar;
    ClasseBanco db;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plano_meuperfil);
        db = new ClasseBanco(this);

        txtPlano = (TextView) findViewById(R.id.txtPlanoSeuPlano);
        txtAparecer = (TextView) findViewById(R.id.txtAparecerPlataforma);
        txtSuporte = (TextView) findViewById(R.id.txtSuporteDireto);
        txtDivulgacao = (TextView) findViewById(R.id.txtDivulgacao);
        txtPromocoes = (TextView) findViewById(R.id.txtPromocoes);
        txtDescontos = (TextView) findViewById(R.id.txtDescontosExclusivos);

        btnToContratar = (Button) findViewById(R.id.btnToContratarPlano);

        setNomePlano();

        btnToContratar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnToContratar.getText().toString().equals("Cancelar plano")){
                    AreYouSure();
                }
            }
        });


    }

    public void setNomePlano(){
        String plano = db.getData("select id_plano from PrestServ9 where id='"+db.GetIdPrestByEmail(MainActivity.SetEmail)+"'", this);

        if (plano.equals("0")){
            txtPlano.setText("Nenhum plano contratado");
            txtPlano.setBackgroundResource(R.drawable.menu_plano_nenhum);
            Intent toContratar = new Intent(PlanoPerfil.this, ContratarPlano.class);
            startActivity(toContratar);


        }
        if(plano.equals("1")){
            txtPlano.setText("Plano premium");
            txtPlano.setBackgroundResource(R.drawable.menu_plano_medio);
            txtPlano.setTextColor(Color.rgb(255,255,255));
            btnToContratar.setText("Cancelar plano");

            txtSuporte.setText("✔ Suporte direto e eficiente");
            txtDivulgacao.setText("✔ Maior divulgação no aplicativo");
            txtPromocoes.setText("✔ Promoções imperdíveis");
            txtDescontos.setText("✔ Descontos exclusivos");


        }
    }

    public boolean CancelarPlanoById(int id_prestador){
        SQLiteDatabase object = db.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id_plano", 0);
        int up = object.update("PrestServ9", contentValues, "id="+id_prestador, null);
        if(up>0){
            return true;
        } else
            return false;
    }

    public void AreYouSure(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Tem certeza que deseja cancelar o plano premium?")
                .setCancelable(false)
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        boolean foi;
                        foi = CancelarPlanoById(db.getIdPrestByEmail(MainActivity.SetEmail));
                        if(foi){
                            Toast.makeText(PlanoPerfil.this, "Plano cancelado com sucesso", Toast.LENGTH_SHORT).show();
                            Intent toServices = new Intent(PlanoPerfil.this, Menu.class);
                            startActivity(toServices);


                        } else
                            Toast.makeText(PlanoPerfil.this, "Erro ao cancelar plano", Toast.LENGTH_SHORT).show();
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
}
