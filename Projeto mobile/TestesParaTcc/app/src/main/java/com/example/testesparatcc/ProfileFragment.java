package com.example.testesparatcc;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.example.testesparatcc.cliente.CadastroCliente;

import java.util.ArrayList;
import java.util.List;


public class ProfileFragment extends Fragment {


    Button btnPerfil, btnPlano, btnDeletar, btnSobre, btnSair;
    ClasseBanco db;
    Context cx;
    public Cursor cursor;
    String output;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profile, container, false);

        btnPerfil = (Button) v.findViewById(R.id.btnPerfilProfile);
        btnPlano = (Button) v.findViewById(R.id.btnPlanosProfile);
        btnDeletar = (Button) v.findViewById(R.id.btnDeletarProfilePrestador);
        btnSair = (Button) v.findViewById(R.id.btnSairProfile);

        db = new ClasseBanco(getContext());

        btnPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toEditProfile = new Intent(getContext(), EditarPefilPrestador.class);
                startActivity(toEditProfile);
            }
        });

        btnPlano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toPlano = new Intent(getContext(), PlanoPerfil.class);
                startActivity(toPlano);
            }
        });

        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toPlano = new Intent(getContext(), PrestadorOuCliente.class);
                startActivity(toPlano);
            }
        });

        btnDeletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AreYouSure();
            }
        });

        return v;
    }

    public void AreYouSure(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage("Tem certeza que deseja deletar sua conta?")
                .setCancelable(false)
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        boolean foi;
                        foi = db.DeletarConta(db.getIdPrestByEmail(MainActivity.SetEmail), "PrestServ9");

                        if(foi){

                            Toast.makeText(getContext(), "Conta deletada com sucesso", Toast.LENGTH_SHORT).show();
                            Intent toPrestadorOuServico = new Intent(getContext(), PrestadorOuCliente.class);
                            startActivity(toPrestadorOuServico);


                        } else
                            Toast.makeText(getContext(), "Erro ao deletar a conta", Toast.LENGTH_SHORT).show();
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
