package com.example.testesparatcc;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.testesparatcc.cliente.ListaPrestadores;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;


public class MessagesFragment extends Fragment {

    ListView listaServicos;
    ClasseBanco db;
    public Cursor cursor;
    String output;
    int imgPosição;


    public static String idServicoStatic;

    ArrayList<String> id_servico = new ArrayList<String>();
    ArrayList<String> id_cliente = new ArrayList<String>();
    ArrayList<String> nome = new ArrayList<String>();
    ArrayList<String> endereco = new ArrayList<String>();
    ArrayList<String> numero  = new ArrayList<String>();
    ArrayList<String> complemento = new ArrayList<String>();
    ArrayList<String> telefone = new ArrayList<String>();
    ArrayList<String> email = new ArrayList<String>();
    ArrayList<String> status = new ArrayList<String>();



    int imagens[] = {R.drawable.servico_cancelado, R.drawable.servico_em_andamento, R.drawable.servico_terminado, R.drawable.servico_aceitar};

    Button btnOk, btnNo;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_messages, container, false);

        listaServicos = (ListView) v.findViewById(R.id.listServicos);

        //coloca valor nos arrays

        db = new ClasseBanco(getContext());
        List<String> lst = new ArrayList<String>();
        lst=db.getListServices(db.getIdPrestByEmail(MainActivity.SetEmail));

        for (int i = 0; i<lst.size(); i++){
            String[] data = lst.get(i).split(" - ");

            id_servico.add(data[0].replace("[",""));
            id_cliente.add(data[1]);
            nome.add(data[2]);
            endereco.add(data[3]);
            numero.add(data[4]);
            complemento.add(data[5]);
            telefone.add(data[6]);
            email.add(data[7]);
            status.add(data[8]);
        }

        String[] id_servicoAr = id_servico.toArray(new String[id_servico.size()]);

        String[] id_clienteAr = id_cliente.toArray(new String[id_cliente.size()]);

        String[] nomeAr = nome.toArray(new String[nome.size()]);

        String[] enderecoAr = endereco.toArray(new String[endereco.size()]);

        String[] numeroAr = numero.toArray(new String[numero.size()]);

        String[] complementoAr = complemento.toArray(new String[complemento.size()]);

        String[] telefoneAr = telefone.toArray(new String[telefone.size()]);

        String[] emailAr = email.toArray(new String[email.size()]);

        String[] statusAr = status.toArray(new String[status.size()]);


        //seta adapter
        MyAdapter adapter = new MyAdapter(getContext(), id_servicoAr, id_clienteAr, nomeAr, enderecoAr, numeroAr, complementoAr, telefoneAr, emailAr,statusAr);
        listaServicos.setAdapter(adapter);
        /*if(lst != null)
        {
            ArrayAdapter<String> listviewAdapter = new ArrayAdapter<String>(
                    getActivity(), android.R.layout.simple_list_item_1, lst){

                @NonNull
                @Override
                public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                    View view = super.getView(position, convertView, parent);
                    TextView textView=(TextView) view.findViewById(android.R.id.text1);
                    textView.setTextColor(Color.BLACK);

                    return view;
                }
            };
            listaServicos.setAdapter(listviewAdapter);
            if(lst.size()==0)
                Toast.makeText(getContext(), "Sem serviços", Toast.LENGTH_LONG).show();
        } else
            Toast.makeText(getContext(), "list null", Toast.LENGTH_LONG).show();*/

        listaServicos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                idServicoStatic = id_servicoAr[position];
                Intent toDetalhesPedido = new Intent(getContext(), DetalhesServicoAceitar.class);
                startActivity(toDetalhesPedido);
            }
        });



        return v;
    }

    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String[] arrayId_servico;
        String[] arrayId_cliente;
        String[] arrayNome;
        String[] arrayEndereco;
        String[] arrayNumero;
        String[] arrayComplemento;
        String[] arrayTelefone;
        String[] arrayEmail;
        String[] arrayStatus;


        MyAdapter(Context cx, String id_servico[], String id_cliente[], String nome[],
                  String[] endereco, String[] numero, String[] complemento, String[] telefone, String[] email, String[] status){
            super(cx, R.layout.row_servicos, R.id.nomeListModel, nome);

            this.context = cx;
            this.arrayId_servico = id_servico;
            this.arrayId_cliente = id_cliente;
            this.arrayNome = nome;
            this.arrayEndereco = endereco;
            this.arrayNumero = numero;
            this.arrayComplemento = complemento;
            this.arrayTelefone = telefone;
            this.arrayEmail = email;
            this.arrayStatus = status;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row_servicos, parent, false);

            TextView txtIdServico = row.findViewById(R.id.idServicoListModel);
            TextView txtNome = row.findViewById(R.id.nomeListModel);
            TextView txtEndereco = row.findViewById(R.id.enderecoListModel);
            TextView txtComplemento = row.findViewById(R.id.complementoListMovel);
            TextView txtStatus = row.findViewById(R.id.statusListModel);
            ImageView images = row.findViewById(R.id.iconSituacaoListModel);

            //definir valores


            txtIdServico.setText(arrayId_servico[position]);
            txtNome.setText(arrayNome[position]);
            txtEndereco.setText(arrayEndereco[position]+ ", " + arrayNumero[position]);
            txtComplemento.setText(arrayComplemento[position]);
            txtStatus.setText(arrayStatus[position]);
            txtComplemento.setText(arrayComplemento[position]);

            if (arrayStatus[position].equals("Em andamento")){
                images.setImageResource(imagens[1]);
            }

            if (arrayStatus[position].equals("Finalizado")){
                images.setImageResource(imagens[2]);
            }

            if (arrayStatus[position].equals("Cancelado")){
                images.setImageResource(imagens[0]);
            }
            if (arrayStatus[position].equals("Aguardando")){
                images.setImageResource(imagens[3]);
            }

            return row;
        }
    }


}
