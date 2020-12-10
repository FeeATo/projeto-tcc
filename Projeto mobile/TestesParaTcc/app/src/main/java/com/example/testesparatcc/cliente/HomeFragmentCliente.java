package com.example.testesparatcc.cliente;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.graphics.Color;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.testesparatcc.ClasseBanco;
import com.example.testesparatcc.R;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;
import java.util.List;

public class HomeFragmentCliente extends Fragment {

    private ListView listaServicos;
    public static String IdProfissao;
    ClasseBanco db;
    Button btnToListEncanador, btnToListJardinagem, btnToListMecanico, btnToListLimpeza, btnToListEletricista,btnToListMassagem,
            btnToListEnfermagem, btnToListMassagem2, btnToListManicure, btnToListMecanico2, btnToListEncanador2, btnToListEletricista2,
            btnToListBaba, btnToListLimpeza2, btnToListCulinaria, btnToListJardinagem2, btnToListInformatica, btnToListPintor;
    TextView txtEndereco;

    int[] carrosselImages = {R.drawable.limpeza_carrossel, R.drawable.pointlabor_carrossel};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home_cliente, container, false);

        db = new ClasseBanco(getContext());

        btnToListEncanador = (Button) v.findViewById(R.id.btnToListEncanador);
        btnToListJardinagem = (Button) v.findViewById(R.id.btnToListJardinagem);
        btnToListMecanico = (Button) v.findViewById(R.id.btnToListMecanico);
        btnToListLimpeza = (Button) v.findViewById(R.id.btnToListLimpeza);
        btnToListEletricista = (Button) v.findViewById(R.id.btnToListEletricista);
        btnToListMassagem = (Button) v.findViewById(R.id.btnToListMassagem);
        btnToListEnfermagem = (Button) v.findViewById(R.id.btnToListEnfermagem);
        btnToListMassagem2 = (Button)v.findViewById(R.id.btnToListMassagem2);
        btnToListManicure = (Button) v.findViewById(R.id.btnToListManicure);
        btnToListMecanico2 = (Button) v.findViewById(R.id.btnToListMecanico2);
        btnToListEncanador2 = (Button) v.findViewById(R.id.btnToListEncanador2);
        btnToListEletricista2 = (Button) v.findViewById(R.id.btnToListEletricista2);
        btnToListBaba = (Button) v.findViewById(R.id.btnToListBaba);
        btnToListLimpeza2 = (Button) v.findViewById(R.id.btnToListLimpeza2);
        btnToListCulinaria = (Button) v.findViewById(R.id.btnToListCulinaria);
        btnToListJardinagem2 = (Button) v.findViewById(R.id.btnToListJardinagem2);
        btnToListInformatica = (Button) v.findViewById(R.id.btnToListInformatica);
        btnToListPintor = (Button) v.findViewById(R.id.btnToListPintor);
        txtEndereco = (TextView) v.findViewById(R.id.txtEnderecoMenuCliente);

        CarouselView carouselView = v.findViewById(R.id.carouselView);
        carouselView.setPageCount(carrosselImages.length);
        carouselView.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(carrosselImages[position]);
            }
        });


        txtEndereco.setText(db.getData("select endereco from Usuario where email='"+CadastroCliente.SetEmailCliente+"'", getContext()).replace("rua", "R.").replace("Rua", "R.") + "  ▿");

        txtEndereco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toListaPrestadores = new Intent(getContext(), EditarPerfilCliente.class);
                startActivity(toListaPrestadores);
            }
        });

        btnToListEncanador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IdProfissao = 1 + "";
                Intent toListaPrestadores = new Intent(getContext(), ListaPrestadores.class);
                startActivity(toListaPrestadores);
            }
        });

        btnToListEncanador2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IdProfissao = 1 + "";
                Intent toListaPrestadores = new Intent(getContext(), ListaPrestadores.class);
                startActivity(toListaPrestadores);
            }
        });

        //////

        btnToListJardinagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IdProfissao = 2 + "";
                Intent toListaPrestadores = new Intent(getContext(), ListaPrestadores.class);
                startActivity(toListaPrestadores);
            }
        });

        btnToListJardinagem2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IdProfissao = 2 + "";
                Intent toListaPrestadores = new Intent(getContext(), ListaPrestadores.class);
                startActivity(toListaPrestadores);
            }
        });

        //////

        btnToListMecanico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IdProfissao = 3 + "";
                Intent toListaPrestadores = new Intent(getContext(), ListaPrestadores.class);
                startActivity(toListaPrestadores);
            }
        });

        btnToListMecanico2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IdProfissao = 3 + "";
                Intent toListaPrestadores = new Intent(getContext(), ListaPrestadores.class);
                startActivity(toListaPrestadores);
            }
        });

        ///////

        btnToListLimpeza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IdProfissao = 4 + "";
                Intent toListaPrestadores = new Intent(getContext(), ListaPrestadores.class);
                startActivity(toListaPrestadores);
            }
        });

        btnToListLimpeza2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IdProfissao = 4 + "";
                Intent toListaPrestadores = new Intent(getContext(), ListaPrestadores.class);
                startActivity(toListaPrestadores);
            }
        });

        /////

        btnToListEletricista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IdProfissao = 5 + "";
                Intent toListaPrestadores = new Intent(getContext(), ListaPrestadores.class);
                startActivity(toListaPrestadores);
            }
        });

        btnToListEletricista2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IdProfissao = 5 + "";
                Intent toListaPrestadores = new Intent(getContext(), ListaPrestadores.class);
                startActivity(toListaPrestadores);
            }
        });

        /////

        btnToListMassagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IdProfissao = 6 + "";
                Intent toListaPrestadores = new Intent(getContext(), ListaPrestadores.class);
                startActivity(toListaPrestadores);
            }
        });

        btnToListMassagem2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IdProfissao = 6 + "";
                Intent toListaPrestadores = new Intent(getContext(), ListaPrestadores.class);
                startActivity(toListaPrestadores);
            }
        });

        //////

        btnToListEnfermagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IdProfissao = 7 + "";
                Intent toListaPrestadores = new Intent(getContext(), ListaPrestadores.class);
                startActivity(toListaPrestadores);
            }
        });

        btnToListInformatica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IdProfissao = 7 + "";
                Intent toListaPrestadores = new Intent(getContext(), ListaPrestadores.class);
                startActivity(toListaPrestadores);
            }
        });

        //////

        btnToListManicure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IdProfissao = 8 + "";
                Intent toListaPrestadores = new Intent(getContext(), ListaPrestadores.class);
                startActivity(toListaPrestadores);
            }
        });

        ///////

        btnToListBaba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IdProfissao = 9 + "";
                Intent toListaPrestadores = new Intent(getContext(), ListaPrestadores.class);
                startActivity(toListaPrestadores);
            }
        });

        ///////

        btnToListCulinaria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IdProfissao = 10 + "";
                Intent toListaPrestadores = new Intent(getContext(), ListaPrestadores.class);
                startActivity(toListaPrestadores);
            }
        });

        ///////

        btnToListPintor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IdProfissao = 11 + "";
                Intent toListaPrestadores = new Intent(getContext(), ListaPrestadores.class);
                startActivity(toListaPrestadores);
            }
        });

        return v;
    }


}
