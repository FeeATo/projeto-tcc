package com.example.testesparatcc;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ConsultarBanco extends AppCompatActivity {

    Class1 xx = new Class1();
    ClasseBanco db = new ClasseBanco(this);
    ListView lstConsultar;
    TextView lblTitulo;
    Button btnProximo;
    String output = "";


    /*public void carregar_list(ListView l)// utilizado no onCreate() e onResume()
    {
        String delete = "delete from PrestServ3";
        db.manutencao(delete, ConsultarBanco.this);
        List<String> lst = new ArrayList<String>();
        lst=db.consultar("select * from PrestServ5", this);
        if(lst != null)
        {
            ArrayAdapter<String> adaptador = new ArrayAdapter<String>
                    (this,android.R.layout.simple_list_item_1,lst);
            l.setAdapter(adaptador);
            if(lst.size()==0)
                Toast.makeText(ConsultarBanco.this, "Sem registros", Toast.LENGTH_LONG).show();
        }
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultarbanco);

        lstConsultar=findViewById(R.id.lstConsulta);
        lblTitulo=findViewById(R.id.lblTitulo);

        if(xx.tipo_operacao==0)
            lblTitulo.setText("Consultar");
        if(xx.tipo_operacao==1)
            lblTitulo.setText("Alterar");
        if(xx.tipo_operacao==2)
            lblTitulo.setText("Excluir");

        //carregar_list(lstConsultar);
        //lblTitulo.setText(db.selects("select id from PrestServ3 where id='2'", this));
        lblTitulo.setText(db.contar_registros("select count(*) from PrestServ9") + "");

        /*lstConsultar.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object o = parent.getAdapter().getItem(position);
                xx.campos=(o.toString()).split(" - ");
                if(xx.tipo_operacao==1)
                {
                    Intent tela3 = new Intent(ConsultarBanco.this,ConsultarBanco.class);
                    startActivity(tela3);
                }
                if(xx.tipo_operacao==2)
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(ConsultarBanco.this);
                    builder.setMessage("Excluir REgistro ?")
                            .setCancelable(false)
                            .setIcon(android.R.drawable.arrow_down_float)
                            .setTitle("Tem certeza?")
                            .setPositiveButton("Sim", new	DialogInterface.OnClickListener()
                            {
                                public void onClick(DialogInterface dialog, int id)
                                {
                                    String sql = "delete from contatos where nome='" + xx.campos[0] + "' and fone='" + xx.campos[1] + "'";
                                    db.manutencao(sql, ConsultarBanco.this);
                                    carregar_list(lstConsultar);
                                    xx.chamaAlerta("Aviso", "Registro Excluido", ConsultarBanco.this);
                                }
                            })
                            .setNegativeButton("Não", new	DialogInterface.OnClickListener()
                            {
                                public void	onClick(DialogInterface dialog, int id)
                                {
                                    dialog.cancel();
                                }
                            });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
            }
        });*/
    }

    @Override
    public void onResume()
    {
        super.onResume();
        //carregar_list(lstConsultar);
        //QntdPrestServ(lstConsultar);
    }
}
