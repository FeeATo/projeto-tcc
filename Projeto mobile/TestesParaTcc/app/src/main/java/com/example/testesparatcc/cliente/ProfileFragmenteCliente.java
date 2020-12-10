package com.example.testesparatcc.cliente;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.testesparatcc.AceitarServico;
import com.example.testesparatcc.ClasseBanco;
import com.example.testesparatcc.ContratarPlano;
import com.example.testesparatcc.Menu;
import com.example.testesparatcc.PaginaPrincipal;
import com.example.testesparatcc.PaginaPrincipalCliente;
import com.example.testesparatcc.PlanoPerfil;
import com.example.testesparatcc.PrestadorOuCliente;
import com.example.testesparatcc.R;

import static java.lang.Integer.parseInt;

public class ProfileFragmenteCliente extends Fragment {

    ClasseBanco db;
    Button btnPerfilProfile, btnSairCliente, btnDeletarConta;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profile_cliente, container, false);

        db = new ClasseBanco(getContext());
        btnPerfilProfile = (Button) v.findViewById(R.id.btnPerfilClienteProfile);
        btnSairCliente = (Button) v.findViewById(R.id.btnSairProfileCliente);
        btnDeletarConta = (Button) v.findViewById(R.id.btnDeletarProfile);

        btnSairCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toContratar = new Intent(getContext(), PrestadorOuCliente.class);
                startActivity(toContratar);
            }
        });

        btnPerfilProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toEditarPerfil = new Intent(getContext(), EditarPerfilCliente.class);
                startActivity(toEditarPerfil);
            }
        });

        btnDeletarConta.setOnClickListener(new View.OnClickListener() {
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
                        foi = db.DeletarConta(db.getIdClienteByEmail(CadastroCliente.SetEmailCliente), "Usuario");
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
