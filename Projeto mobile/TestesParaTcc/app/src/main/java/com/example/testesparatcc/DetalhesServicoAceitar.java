package com.example.testesparatcc;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class DetalhesServicoAceitar extends AppCompatActivity {

    String id_servico;
    ClasseBanco db;
    public Cursor cursor;
    TextView txtNome, txtEndereco, txtComplemento, txtIdCliente, txtIdServico, txtTelefone, txtStatus, txtMensagem;
    Button btnOk, btnNo;
    ImageView imgImagens;
    int imagens[] = {R.drawable.servico_cancelado, R.drawable.servico_em_andamento, R.drawable.servico_terminado, R.drawable.servico_aceitar};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalhes_servico_aceitar);

        id_servico = MessagesFragment.idServicoStatic;

        txtNome = (TextView) findViewById(R.id.txtNomeAceitar);
        txtTelefone = (TextView) findViewById(R.id.txtTelefoneAceitar);
        txtEndereco = (TextView) findViewById(R.id.txtEnderecoAceitar);
        txtComplemento = (TextView) findViewById(R.id.txtComplementoAceitar);
        txtIdCliente = (TextView) findViewById(R.id.txtIdClienteAceitar);
        txtIdServico = (TextView) findViewById(R.id.txtIdServicoAceitar);
        txtStatus = (TextView) findViewById(R.id.txtStatusAceitar);
        txtMensagem = (TextView) findViewById(R.id.txtMensagemErro);
        imgImagens = (ImageView) findViewById(R.id.imgStatusAceitar);
        btnOk = (Button) findViewById(R.id.btnAceitarTerminarServico);
        btnNo = (Button) findViewById(R.id.btnRecusarCancelarServico);


        db = new ClasseBanco(DetalhesServicoAceitar.this);


        String[] dados = getServiceDetailsById(id_servico).split(" - ");
        txtIdServico.setText("ID Serviço: " + dados[0].replace("[",""));
        txtIdCliente.setText("ID Cliente: " +dados[1]);
        txtNome.setText(dados[2]);
        txtEndereco.setText(dados[3] + ", " + dados[4]);
        txtComplemento.setText(dados[5]);
        txtTelefone.setText(dados[6]);
        txtStatus.setText(dados[7].replace("]", ""));

        if (dados[7].replace("]", "").equals("Em andamento")){
            imgImagens.setImageResource(imagens[1]);
            btnOk.setText("Finalizar serviço");
        }

        if (dados[7].replace("]", "").equals("Finalizado")){
            imgImagens.setImageResource(imagens[2]);
            btnOk.setText("------------");
        }

        if (dados[7].replace("]", "").equals("Cancelado") || dados[7].replace("]", "").equals("Recusado")){
            imgImagens.setImageResource(imagens[0]);
            btnOk.setText("------------");
        }
        if (dados[7].replace("]", "").equals("Aguardando")){
            imgImagens.setImageResource(imagens[3]);
            btnOk.setText("Aceitar serviço");
        }


        //setas botoes desabilitados
        if(btnOk.getText().equals("------------")){
            btnOk.setEnabled(false);
            btnNo.setEnabled(false);
        }


        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //aceitar
                if(btnOk.getText().equals("Aceitar serviço")){
                    AreYouSureAceitar(parseInt(dados[0].replace("[", "")));
                }

                //finalizar
                if (btnOk.getText().equals("Finalizar serviço")){
                    AreYouSureFinalizar(parseInt(dados[0].replace("[","")));
                }



            }
        });

        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //recusar
                if(btnOk.getText().equals("Aceitar serviço")){
                    AreYouSureRecusar(parseInt(dados[0].replace("[","")));
                }

                //cancelar
                if (btnOk.getText().equals("Finalizar serviço")){
                    AreYouSureCancelar(parseInt(dados[0].replace("[","")));
                }
            }
        });


    }

    public String getServiceDetailsById(String id_servico){
        try
        {
            List<String> list = new ArrayList<String>();
            SQLiteDatabase objSQLiteDatabase = db.getWritableDatabase();
            cursor = objSQLiteDatabase.rawQuery("select id_servico, id_cliente, nome_usu, endereco, numero,complemento,telefone, status_servico  from Servico, Usuario where id_cliente=id and id_servico="+id_servico, null);

            if (cursor.moveToFirst())
            {
                do
                {
                    list.add(cursor.getString(0)+" - "+cursor.getString(1)+" - "+cursor.getString(2)+" - "+cursor.getString(3)+" - "+cursor.getString(4)+" - "+cursor.getString(5)+" - "+cursor.getString(6)+" - "+cursor.getString(7));
                    //list.add(cursor.getString(0)+" - "+cursor.getString(1)+" - "+cursor.getString(8)+" - "+cursor.getString(9)+" - "+cursor.getString(11));
                } while (cursor.moveToNext());
            }
            if (cursor != null && !cursor.isClosed())
            {
                cursor.close();
            }
            return list.toString();
        }
        catch(Exception ex)
        {
            return ex.toString();
        }
    }

    public void AreYouSureFinalizar(int id_servico){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Tem certeza que deseja finalizar o serviço?")
                .setCancelable(false)
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        boolean foi;
                        foi = db.FinalizarServicoById(id_servico);
                        if(foi){
                            Toast.makeText(DetalhesServicoAceitar.this, "Serviço finalizado", Toast.LENGTH_SHORT).show();
                            Intent atualizarPagina = new Intent(DetalhesServicoAceitar.this, Menu.class);
                            startActivity(atualizarPagina);

                        } else
                            Toast.makeText(DetalhesServicoAceitar.this, "Erro ao finalizar servico", Toast.LENGTH_SHORT).show();
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

    public void AreYouSureAceitar(int id_servico){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Tem certeza que quer aceitar o serviço?")
                .setCancelable(false)
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        boolean foi;
                        foi = db.AceitarPedidoPrestadorById(parseInt(Menu.idServico), DetalhesServicoAceitar.this);
                        if(foi){
                            Toast.makeText(DetalhesServicoAceitar.this, "Serviço aceito", Toast.LENGTH_SHORT).show();
                            Intent toServices = new Intent(DetalhesServicoAceitar.this, Menu.class);
                            startActivity(toServices);


                        } else
                            Toast.makeText(DetalhesServicoAceitar.this, "Erro ao aceitar servico", Toast.LENGTH_SHORT).show();
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

    public void AreYouSureRecusar(int id_servico){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Tem certeza que deseja finalizar o serviço?")
                .setCancelable(false)
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        boolean foi;
                        foi = db.RecusarServicoById(id_servico);
                        if(foi){
                            Toast.makeText(DetalhesServicoAceitar.this, "Serviço recusado", Toast.LENGTH_SHORT).show();
                            Intent atualizarPagina = new Intent(DetalhesServicoAceitar.this, Menu.class);
                            startActivity(atualizarPagina);

                        } else
                            Toast.makeText(DetalhesServicoAceitar.this, "Erro ao finalizar servico", Toast.LENGTH_SHORT).show();
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

    public void AreYouSureCancelar(int id_servico){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Tem certeza que deseja finalizar o serviço?")
                .setCancelable(false)
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        boolean foi;
                        foi = db.CancelarServicoById(id_servico);
                        if(foi){
                            Toast.makeText(DetalhesServicoAceitar.this, "Serviço cancelado", Toast.LENGTH_SHORT).show();
                            Intent atualizarPagina = new Intent(DetalhesServicoAceitar.this, Menu.class);
                            startActivity(atualizarPagina);

                        } else
                            Toast.makeText(DetalhesServicoAceitar.this, "Erro ao finalizar servico", Toast.LENGTH_SHORT).show();
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
