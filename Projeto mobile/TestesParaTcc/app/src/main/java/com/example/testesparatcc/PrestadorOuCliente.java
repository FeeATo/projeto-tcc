package com.example.testesparatcc;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.testesparatcc.cliente.ListaPrestadores;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class PrestadorOuCliente extends AppCompatActivity {

    Button btnToCliente, btnToPrestador;
    public Cursor cursor, cursor2;
    int qntd_servicos;
    ClasseBanco db;
    String output;

    ArrayList<String> id_prestador = new ArrayList<String>();
    ArrayList<String> nome = new ArrayList<String>();
    ArrayList<String> avaliacao = new ArrayList<String>();
    ArrayList<String> qntdServiso = new ArrayList<String>();
    ArrayList<String> plano = new ArrayList<String>();

    ArrayList<Bitmap> imgPrestador = new ArrayList<Bitmap>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prestador_ou_cliente);

        db = new ClasseBanco(PrestadorOuCliente.this);

        btnToCliente = (Button) findViewById(R.id.btnToCliente);
        btnToPrestador = (Button) findViewById(R.id.btnToPrestador);

        //vai para Cadastro/Login de cliente
        btnToCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toCliente = new Intent(PrestadorOuCliente.this, PaginaPrincipalCliente.class);
                startActivity(toCliente);
            }
        });

        //vai para Cadastro/Login de prestador
        btnToPrestador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toPrestador = new Intent(PrestadorOuCliente.this, PaginaPrincipal.class);
                startActivity(toPrestador);
            }
        });



        /*List<Bitmap> lstImgs = new ArrayList<Bitmap>();
        lstImgs=db.getImageListPrestadores("Mecânica");

        for (int m = 0; m<lstImgs.size(); m++){
            imgPrestador.add(lstImgs.get(m));
        }

        List<Integer> lstQntd = new ArrayList<Integer>();
        lstQntd=GetQntdServicosByListId();

        for (int j = 0; j<lstQntd.size(); j++){
            String[] qntd = lstQntd.get(j).toString().split(",");
            qntdServiso.add(qntd[0].replace("[","").replace("]",""));
        }


        List<String> lst = new ArrayList<String>();
        lst=getPrestadorListByService("Mecânica");

        if (!lst.isEmpty()) {
            for (int i = 0; i < lst.size(); i++) {
                String[] data = lst.get(i).split(" - ");

                id_prestador.add(data[0].replace("[", ""));
                nome.add(data[1].replace("]", ""));
                plano.add(data[2].replace("]", ""));

            }
        } else {
            Toast.makeText(PrestadorOuCliente.this, "Não há prestadores para este serviço", Toast.LENGTH_SHORT).show();
        }


        List<Float> lstNota = new ArrayList<Float>();
        lstNota=GetMediaAvaliacao();


        for (int k = 0; k<lstNota.size(); k++){
            String[] nota = lstNota.get(k).toString().split(",");
            if (nota[0].equals(""))
                avaliacao.add("0");
            else
                avaliacao.add(nota[0].replace("[","").replace("]",""));
        }*/

        //CreateAndOrganizeMatriz();

    }



    /*public void CreateAndOrganizeMatriz(){
        int[][] qntdMatriz = new int[GetPrestadorIds("Mecânica").size()][2];

        //linhas da matriz
        for (int i = 0; i<GetPrestadorIds("Mecânica").size(); i++){
            //colunas da matriz
            for (int j = 0; j<2; j++){
                if (j == 0){
                    qntdMatriz[i][j] = GetPrestadorIds("Mecânica").get(i);
                    System.out.println(qntdMatriz[i][j]);
                } else {
                    qntdMatriz[i][j] = GetQntdServicosById(GetPrestadorIds("Mecânica").get(i));
                    System.out.println(qntdMatriz[i][j]);
                }
            }
        }

        System.out.println("organizado ------------");
        //organizar
        for (int i = 0; i<GetPrestadorIds("Mecânica").size(); i++){

            for (int j = 0; j<GetPrestadorIds("Mecânica").size(); j++){

                if (qntdMatriz[j][1] > qntdMatriz[i][1] && j > i){

                    int atual = qntdMatriz[j][0];
                    int atualQntd = qntdMatriz[j][1];

                    int base = qntdMatriz[i][0];
                    int baseQntd = qntdMatriz[i][1];

                    //id atual se torna a base id
                    qntdMatriz[j][0] = base;
                    //qntd atual se torna a base qntd
                    qntdMatriz[j][1] = baseQntd;

                    qntdMatriz[i][0] = atual;
                    qntdMatriz[i][1] = atualQntd;

                } else
                    System.out.println("n muda");

            }
        }

        System.out.println(qntdMatriz[0][0] + "---" + qntdMatriz[0][1]);
        System.out.println(qntdMatriz[1][0] + "---" + qntdMatriz[1][1]);
        System.out.println(qntdMatriz[2][0] + "---" + qntdMatriz[2][1]);

        List<String> idsOrganizados = new ArrayList<String>();
        //criar lista com ids organizados
        for (int i = 0; i<GetPrestadorIds("Mecânica").size(); i++){
            idsOrganizados.add(qntdMatriz[i][0] + "");
        }

        System.out.println(idsOrganizados);

    }

    public List<String> getPrestadorListByService(String servico){
        try {
            int id_prestador;
            SQLiteDatabase objSQLiteDatabase = db.getWritableDatabase();
            cursor = objSQLiteDatabase.rawQuery("select id, nome, id_plano,prestImg from PrestServ9 where tipo_serv='" + servico + "' order by id_plano desc", null);

            List<String> list = new ArrayList<String>();

            if (cursor.moveToFirst()) {
                do {
                    id_prestador = parseInt(cursor.getString(0));
                    qntd_servicos = GetQntdServicosById(id_prestador);
                    list.add(cursor.getString(0) + " - " + cursor.getString(1) + " - " + cursor.getString(2) + " - " + qntd_servicos);


                } while (cursor.moveToNext());
            }


            if (cursor != null && !cursor.isClosed()) {
                cursor.close();

            }


            return list;
        } catch (Exception ex) {
            Log.e("Error", ex.getMessage());
            return null;
        }
    }


    public List<Integer> GetPrestadorIds (String servico){
        List<Integer> list = new ArrayList<Integer>();
        try {
            SQLiteDatabase objSQLiteDatabase = db.getWritableDatabase();
            cursor = objSQLiteDatabase.rawQuery("select id from PrestServ9 where tipo_serv='" + servico + "' order by id_plano desc", null);

            if (cursor.moveToFirst()) {
                do {
                    list.add(cursor.getInt(0));

                } while (cursor.moveToNext());

            }
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }

            return list;
        } catch (Exception ex) {
            return null;
        }
    }

    public int GetQntdServicosById ( int id_prestador){
        List<Integer> list = new ArrayList<Integer>();
        try {
            SQLiteDatabase objSQLiteDatabase = db.getWritableDatabase();
            cursor2 = objSQLiteDatabase.rawQuery("select count(*) from Servico where id_prestador=" + id_prestador + " and status_servico='Finalizado'", null);

            if (cursor2.moveToFirst()) {

                output = cursor2.getString(0);

            }

            if (cursor2 != null && !cursor2.isClosed()) {
                cursor2.close();
            }


            return parseInt(output);
        } catch (Exception ex) {
            Log.e("Error", ex.getMessage());
            return 0;
        }
    }

    public List<Integer> GetQntdServicosByListId () {
        List<Integer> list = new ArrayList<Integer>();
        try {
            SQLiteDatabase objSQLiteDatabase = db.getWritableDatabase();
            for (int i = 0; i < GetPrestadorIds("Mecânica").size(); i++) {
                cursor = objSQLiteDatabase.rawQuery("select count(*) from Servico where id_prestador=" + GetPrestadorIds("Mecânica").get(i) + " and status_servico='Finalizado'", null);

                if (cursor.moveToFirst()) {

                    list.add(cursor.getInt(0));

                }
            }
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }

            return list;
        } catch (Exception ex) {
            Log.e("Error", ex.getMessage());
            return null;
        }
    }

    public List<Float> GetMediaAvaliacao () {
        List<Float> list = new ArrayList<Float>();

        float soma = 0;
        float media = 0;
        try {
            SQLiteDatabase objSQLiteDatabase = db.getWritableDatabase();

            for (int j = 0; j < GetPrestadorIds("Mecânica").size(); j++) {
                cursor2 = objSQLiteDatabase.rawQuery("select count(avaliacao) from Servico where avaliacao !='Pendente' and id_prestador=" + GetPrestadorIds("Mecânica").get(j), null);
                if (cursor2.moveToNext()) {
                    output = cursor2.getString(0);
                }

                cursor = objSQLiteDatabase.rawQuery("select avaliacao from Servico where avaliacao !='Pendente' and id_prestador=" + GetPrestadorIds("Mecânica").get(j), null);
                for (int i = 0; cursor.moveToNext(); i++) {
                    if (cursor.moveToFirst()) {

                        soma += Float.parseFloat(cursor.getString(i));
                        media = soma / parseInt(output);

                    }

                }
                list.add(media);
            }


            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }

            return list;
        } catch (Exception ex) {
            Log.e("Error:", ex.getMessage());
            return null;
        }
    }*/
}
