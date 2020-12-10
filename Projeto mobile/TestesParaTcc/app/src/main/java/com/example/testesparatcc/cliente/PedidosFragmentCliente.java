package com.example.testesparatcc.cliente;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
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
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.testesparatcc.ClasseBanco;
import com.example.testesparatcc.DetalhesServicoAceitar;
import com.example.testesparatcc.MainActivity;
import com.example.testesparatcc.MessagesFragment;
import com.example.testesparatcc.R;

import java.util.ArrayList;
import java.util.List;

public class PedidosFragmentCliente extends Fragment {

    ListView listaServicos;
    TextView txtTituloPedidoCliente;
    ClasseBanco db;
    public Cursor cursor;
    String output;
    int imgPosição;

    public static String idServicoStaticCliente;

    ArrayList<String> id_servico = new ArrayList<String>();
    ArrayList<String> id_prestador = new ArrayList<String>();
    ArrayList<String> nome = new ArrayList<String>();
    ArrayList<String> avaliacao = new ArrayList<String>();
    ArrayList<String> telefone = new ArrayList<String>();
    ArrayList<String> status = new ArrayList<String>();
    int imagens[] = {R.drawable.servico_cancelado, R.drawable.servico_em_andamento, R.drawable.servico_terminado, R.drawable.servico_aceitar};

    Button btnOk, btnNo;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_pedido_cliente, container, false);

        listaServicos = (ListView) v.findViewById(R.id.listServicosCliente);
        txtTituloPedidoCliente = (TextView) v. findViewById(R.id.txtTituloPedidoCliente);



        //coloca valor nos arrays

        db = new ClasseBanco(getContext());
        List<String> lst = new ArrayList<String>();
        lst=db.getClienteListServices(db.getIdClienteByEmail(CadastroCliente.SetEmailCliente));

        for (int i = 0; i<lst.size(); i++){
            String[] data = lst.get(i).split(" - ");

            id_servico.add(data[0].replace("[",""));
            id_prestador.add(data[1]);
            nome.add(data[2]);
            telefone.add(data[3]);
            status.add(data[4]);
            avaliacao.add(data[5].replace("]", ""));

        }

        String[] id_servicoAr = id_servico.toArray(new String[id_servico.size()]);

        String[] id_prestadorAr = id_prestador.toArray(new String[id_prestador.size()]);

        String[] nomeAr = nome.toArray(new String[nome.size()]);

        String[] telefoneAr = telefone.toArray(new String[telefone.size()]);

        String[] statusAr = status.toArray(new String[status.size()]);

        String[] avaliacaoAr = avaliacao.toArray(new String[avaliacao.size()]);


        //seta adapter
        PedidosFragmentCliente.MyAdapterCliente adapter = new PedidosFragmentCliente.MyAdapterCliente(getContext(), id_servicoAr, id_prestadorAr, nomeAr, telefoneAr,statusAr, avaliacaoAr);
        listaServicos.setAdapter(adapter);

        listaServicos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (statusAr[position].equals("Finalizado") && avaliacaoAr[position].equals("Pendente")) {
                    idServicoStaticCliente = id_servicoAr[position];
                    Intent toDetalhesPedido = new Intent(getContext(), avaliarServico.class);
                    startActivity(toDetalhesPedido);
                }
            }
        });

        return v;
    }

    class MyAdapterCliente extends ArrayAdapter<String> {

        Context context;
        String[] arrayId_servico;
        String[] arrayId_prestador;
        String[] arrayNome;
        String[] arrayTelefone;
        String[] arrayStatus;
        String[] arrayAvaliacao;


        MyAdapterCliente(Context cx, String id_servico[], String id_prestador[], String nome[],
                  String[] telefone, String[] status, String[] avaliacao){
            super(cx, R.layout.row_servico_cliente, R.id.nomePrestadorListModelCliente, nome);

            this.context = cx;
            this.arrayId_servico = id_servico;
            this.arrayId_prestador = id_prestador;
            this.arrayNome = nome;
            this.arrayTelefone = telefone;
            this.arrayStatus = status;
            this.arrayAvaliacao = avaliacao;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row_servico_cliente, parent, false);

            TextView txtIdServico = row.findViewById(R.id.idServicoListModelCliente);
            TextView txtIdPrestador = row.findViewById(R.id.idPrestadorListModelCliente);
            TextView txtNome = row.findViewById(R.id.nomePrestadorListModelCliente);
            TextView txtTelefone = row.findViewById(R.id.enderecoListModelCliente);
            TextView txtStatus = row.findViewById(R.id.statusListModelCliente);
            ImageView images = row.findViewById(R.id.iconSituacaoListModel);
            TextView txtAvaliadoOuNao = (TextView) row.findViewById(R.id.txtAvaliadoOuNao);
            RatingBar rtBar = (RatingBar) row.findViewById(R.id.rtBarAvaliacaoServicoCliente);
            TextView txtEndereco = row.findViewById(R.id.complementoListMovelCliente);

            //definir valores


            txtIdServico.setText(arrayId_servico[position]);
            txtIdPrestador.setText(arrayId_prestador[position]);
            txtNome.setText(arrayNome[position]);
            txtStatus.setText(arrayStatus[position]);
            txtTelefone.setText(arrayTelefone[position]);
            txtEndereco.setText("");


            //txtAavaliacao

            if (!arrayStatus[position].equals("Finalizado")){
                txtAvaliadoOuNao.setText("");
                rtBar.setVisibility(View.GONE);
            }

            if (arrayStatus[position].equals("Finalizado") && !db.getData("select avaliacao from Servico where id_servico="+arrayId_servico[position], getContext()).equals("Pendente")){
                rtBar.setVisibility(View.VISIBLE);
                rtBar.setRating(Float.parseFloat(db.getData("select avaliacao from Servico where id_servico="+arrayId_servico[position], getContext())));
                /*txtAvaliadoOuNao.setVisibility(View.VISIBLE);
                txtAvaliadoOuNao.setText("Avaliado");*/
            }
            if (arrayStatus[position].equals("Finalizado") && db.getData("select avaliacao from Servico where id_servico="+arrayId_servico[position], getContext()).equals("Pendente")){
                txtAvaliadoOuNao.setVisibility(View.VISIBLE);
                txtAvaliadoOuNao.setText("Não avaliado");
            }

            //set status do serviço

            if (arrayStatus[position].equals("Em andamento")){
                images.setImageResource(imagens[1]);
            }

            if (arrayStatus[position].equals("Finalizado")){
                images.setImageResource(imagens[2]);
            }

            if (arrayStatus[position].equals("Cancelado") || arrayStatus[position].equals("Recusado")){
                images.setImageResource(imagens[0]);
            }
            if (arrayStatus[position].equals("Aguardando")){
                images.setImageResource(imagens[3]);
            }



            return row;
        }
    }
}
