package com.example.testesparatcc.cliente;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.testesparatcc.ClasseBanco;
import com.example.testesparatcc.HomeFragment;
import com.example.testesparatcc.R;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.lang.Integer.parseInt;

public class ListaPrestadores extends AppCompatActivity{

    ClasseBanco db;
    private ListView listPrestadores;
    public static String idPrestador;
    TextView tipoServico;

    ListView listaServicos;
    public Cursor cursor;
    public Cursor cursor2;
    String output;
    String servico;
    Bitmap bt = null;
    int qntd_servicos = 0;
    String[] nota;


    public static String idServicoStaticCliente;


    ArrayList<String> id_prestador = new ArrayList<String>();
    ArrayList<String> nome = new ArrayList<String>();
    ArrayList<String> avaliacao = new ArrayList<String>();
    ArrayList<String> qntdServiso = new ArrayList<String>();
    ArrayList<String> plano = new ArrayList<String>();

    ArrayList<Bitmap> imgPrestador = new ArrayList<Bitmap>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_prestadores);
        listPrestadores = (ListView) findViewById(R.id.listPrestadores);
        tipoServico = (TextView) findViewById(R.id.txtTipoServico);

        String id = HomeFragmentCliente.IdProfissao;
        if (id.equals("3")){
            tipoServico.setText("Mecânicos");
            servico = "Mecânica";
        }
        if (id.equals("5")){
            tipoServico.setText("Eletricistas");
            servico = "Elétrica";
        }
        if (id.equals("10")){
            tipoServico.setText("Cozinheiros");
            servico = "Cozinha";
        }
        if (id.equals("1")){
            tipoServico.setText("Encanadores");
            servico = "Encanação";
        }
        if (id.equals("4")){
            tipoServico.setText("Marceneiros");
            servico = "Marcenaria";
        }
        if (id.equals("7")){
            tipoServico.setText("Técnicos de informática");
            servico = "Informática";
        }

        db = new ClasseBanco(ListaPrestadores.this);


        //talvez as declarações dos Lists pudessem ter sido feitas com um só For, porém não tenho tempo para testar :c

        List<Bitmap> lstImgs = new ArrayList<Bitmap>();
        lstImgs=db.getImageListPrestadores(servico);

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
        lst=getPrestadorListByService(servico);

        if (!lst.isEmpty()) {
            for (int i = 0; i < lst.size(); i++) {
                String[] data = lst.get(i).split(" - ");

                id_prestador.add(data[0].replace("[", ""));
                nome.add(data[1].replace("]", ""));
                plano.add(data[2].replace("]", ""));

            }
        } else {
            Toast.makeText(ListaPrestadores.this, "Não há prestadores para este serviço", Toast.LENGTH_SHORT).show();
        }


        List<Float> lstNota = new ArrayList<Float>();
        lstNota=GetMediaAvaliacao();
        nota = new String[lstNota.size()];
        for (int k = 0; k<lstNota.size(); k++){
            nota[k] = lstNota.get(k).toString();
            if (nota[k].equals(""))
                avaliacao.add("0");
            else
                avaliacao.add(nota[k].replace("[","").replace("]",""));
        }



        String[] id_prestadorAr = id_prestador.toArray(new String[id_prestador.size()]);

        String[] nomeAr = nome.toArray(new String[nome.size()]);

        String[] avaliacaoAr = avaliacao.toArray(new String[avaliacao.size()]);

        String[] qntdAr = qntdServiso.toArray(new String[qntdServiso.size()]);

        String[] planoAr = plano.toArray(new String[plano.size()]);

        Bitmap[] imagemAr = imgPrestador.toArray(new Bitmap[imgPrestador.size()]);






        //seta adapter
        MyAdapter adapter = new MyAdapter(ListaPrestadores.this,id_prestadorAr, nomeAr, avaliacaoAr, qntdAr, planoAr, imagemAr);
        listPrestadores.setAdapter(adapter);

        listPrestadores.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String id_prestadorToProfile = id_prestadorAr[position];
                idPrestador = id_prestadorToProfile;

                Intent toProfile = new Intent(ListaPrestadores.this, PrestadorProfile.class);
                startActivity(toProfile);
            }
        });


    }

    //tentariva de alterar ordens de acordo com a quantidade de serviços do prestador,
    //porém demoraria mt tempo para mudar o jeito que os prestadores são pegos do banco.
    public List<String> CreateAndOrganizeMatriz(){
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

        }
        return null;
    }



    public List<String> getPrestadorListByService(String servico){
        try
        {
            int id_prestador;
            SQLiteDatabase objSQLiteDatabase = db.getWritableDatabase();
            cursor = objSQLiteDatabase.rawQuery("select id, nome, id_plano,prestImg from PrestServ9 where tipo_serv='"+servico+"' order by id_plano desc", null);

            List<String> list = new ArrayList<String>();

            if (cursor.moveToFirst())
            {
                do
                {
                    id_prestador = parseInt(cursor.getString(0));
                    qntd_servicos = GetQntdServicosById(id_prestador);
                    list.add(cursor.getString(0)+" - "+cursor.getString(1)+" - "+cursor.getString(2) + " - " + qntd_servicos);


                } while (cursor.moveToNext());
            }


            if (cursor != null && !cursor.isClosed())
            {
                cursor.close();

            }



            return list;
        }
        catch(Exception ex)
        {
            Log.e("Error", ex.getMessage());
            return null;
        }
    }



    public List<Integer> GetPrestadorIds(String servico){
        List<Integer> list = new ArrayList<Integer>();
        try {
            SQLiteDatabase objSQLiteDatabase = db.getWritableDatabase();
            cursor = objSQLiteDatabase.rawQuery("select id from PrestServ9 where tipo_serv='"+servico+"' order by id_plano desc", null);

            if (cursor.moveToFirst()) {
                do
                {
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

    public int GetQntdServicosById(int id_prestador){
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

    public List<Integer> GetQntdServicosByListId(){
        List<Integer> list = new ArrayList<Integer>();
        try {
            SQLiteDatabase objSQLiteDatabase = db.getWritableDatabase();
            for (int i = 0; i<GetPrestadorIds(servico).size(); i++) {
                cursor = objSQLiteDatabase.rawQuery("select count(*) from Servico where id_prestador=" + GetPrestadorIds(servico).get(i) + " and status_servico='Finalizado'", null);

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

    public List<Float> GetMediaAvaliacao() {
        List<Float> list = new ArrayList<Float>();

        float soma = 0;
        float media = 0;
        try {
            SQLiteDatabase objSQLiteDatabase = db.getWritableDatabase();

            for (int j = 0; j<GetPrestadorIds(servico).size(); j++) {
                cursor2 = objSQLiteDatabase.rawQuery("select count(avaliacao) from Servico where avaliacao !='Pendente' and id_prestador="+GetPrestadorIds(servico).get(j), null);
                if (cursor2.moveToFirst()){
                    output = cursor2.getString(0);
                }

                if (!output.equals("0")) {
                    cursor = objSQLiteDatabase.rawQuery("select avaliacao from Servico where avaliacao !='Pendente' and id_prestador=" + GetPrestadorIds(servico).get(j), null);
                    if (cursor.moveToFirst()) {
                        do {
                            System.out.println("dentro do DO WHILE");
                            soma += Float.parseFloat(cursor.getString(0));
                            //System.out.println("avaliacao prestador:" + GetPrestadorIds(servico).get(j) + "NOTA:" + cursor.getString(0));
                        } while (cursor.moveToNext());
                    }


                    media = soma / parseInt(output);
                    System.out.println("id do prestador:" + (j + 1));
                    System.out.println("avaliacao média dele:" + media);
                } else {
                    media = 0f;
                    System.out.println("sem avaliacao");
                }


                list.add(media);
                soma = 0;
            }


            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }

            return list;
        } catch (Exception ex) {
            Log.e("Error:" ,ex.getMessage());
            return null;
        }
    }



class MyAdapter extends ArrayAdapter<String> {

    Context context;
    String[] arrayId_prestador;
    String[] arrayNome;
    String[] arrayAvaliacao;
    String[] arrayQntd;
    String[] arrayPlano;
    Bitmap[] arrayImage;


    MyAdapter(Context cx, String id_prestador[], String nome[], String avaliacao[], String[] qntd, String[] plano, Bitmap[] imagem) {
        super(cx, R.layout.row_servicos, R.id.nomeListModel, nome);

        this.context = cx;
        this.arrayId_prestador = id_prestador;
        this.arrayNome = nome;
        this.arrayAvaliacao = avaliacao;
        this.arrayQntd = qntd;
        this.arrayPlano = plano;
        this.arrayImage = imagem;


    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = layoutInflater.inflate(R.layout.row_prestadores, parent, false);

        TextView txtIdPrestador = row.findViewById(R.id.idPrestadorListModelPrestador);
        TextView txtNome = row.findViewById(R.id.nomeListModelPrestador);
        TextView txtQtnd = row.findViewById(R.id.qtndServicosListModelPrestador);
        TextView txtPlano = row.findViewById(R.id.planoListModelPrestador);
        RatingBar rtNota = row.findViewById(R.id.ratingBarListModelPrestador);
        ImageView imagemPretador = row.findViewById(R.id.imgprestadorSituacaoListModelPrestador);

        imagemPretador.setImageBitmap(arrayImage[position]);

        //definir valores
        txtIdPrestador.setText(arrayId_prestador[position]);
        txtNome.setText(arrayNome[position]);
        rtNota.setRating(Float.parseFloat(arrayAvaliacao[position].replace("[","").replace("]","")));
        txtQtnd.setText(arrayQntd[position] + " serviço(s) realizado(s)");

        if (arrayPlano[position].equals("0")) {
            txtPlano.setText("Nenhum plano");
            txtPlano.setTextColor(Color.parseColor("#ababab"));
        }
        else {
            txtPlano.setText("Plano premium ✨");
            txtPlano.setTextColor(Color.parseColor("#3455b9"));
        }

        return row;
    }
}

}



