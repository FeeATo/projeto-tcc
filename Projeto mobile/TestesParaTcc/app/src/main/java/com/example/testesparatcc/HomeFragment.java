package com.example.testesparatcc;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    public Button btnToPlano;
    public TextView txtPlano, txtServicosCount;
    RatingBar rtNota;
    Context cx;
    public Cursor cursor;
    float soma;
    ClasseBanco db;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        txtPlano = v.findViewById(R.id.txtPlano);
        txtServicosCount = v.findViewById(R.id.txtServicoCount);
        rtNota = v.findViewById(R.id.ratingBar);
        btnToPlano = v.findViewById(R.id.btnToPlano);


        db = new ClasseBanco(getContext());
        setNomePlano();

        txtServicosCount.setText(db.ContarServicosFeitosById(db.getIdPrestByEmail(MainActivity.SetEmail)));

        btnToPlano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent plano = new Intent(getContext(), ContratarPlano.class);
                startActivity(plano);
            }
        });
        System.out.println("id do prestador:" + db.getIdPrestByEmail(MainActivity.SetEmail));
        rtNota.setRating(GetMediaAvaliacao(db.getIdPrestByEmail(MainActivity.SetEmail)));


        return v;
    }

    public void setNomePlano(){
        String plano = db.getData("select id_plano from PrestServ9 where id='"+db.GetIdPrestByEmail(MainActivity.SetEmail)+"'", cx);

        if (plano.equals("0")){
            txtPlano.setText("Nenhum plano contratado");
            txtPlano.setBackgroundResource(R.drawable.menu_plano_nenhum);
        }
        if(plano.equals("1")){
            txtPlano.setText("Plano premium");
            txtPlano.setBackgroundResource(R.drawable.menu_plano_medio);
            txtPlano.setTextColor(Color.rgb(255,255,255));
        }


    }

    public float GetMediaAvaliacao(int id_prestador) {
        List<Float> list = new ArrayList<Float>();
        try {
            SQLiteDatabase objSQLiteDatabase = db.getWritableDatabase();
            cursor = objSQLiteDatabase.rawQuery("select avaliacao from Servico where avaliacao !='Pendente' and id_prestador=" + id_prestador, null);


            for (int i = 0; cursor.moveToNext(); i++) {
                if (cursor.moveToFirst()) {
                    list.add(Float.parseFloat(cursor.getString(i)));
                }
            }


            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }


            for (float n : list){
                soma = soma + n;
            }
            System.out.println(list);
            System.out.println(soma);
            System.out.println(list.size());
            System.out.println(soma / list.size());
            return soma / list.size();
        } catch (Exception ex) {
            Log.e("Erro:", ex.getMessage());
            return 0;
        }
    }

}
