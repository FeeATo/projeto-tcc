package com.example.testesparatcc;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class CadastroServico extends AppCompatActivity {


    Spinner spServico, spExperiencia;
    Button btnToAcordos;
    ClasseBanco db;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadservico);

        btnToAcordos = (Button) findViewById(R.id.btnNextServ);

        db = new ClasseBanco(this);
        spServico = (Spinner) findViewById(R.id.spServico);
        spExperiencia = (Spinner) findViewById(R.id.spExperiencia);
        //fundo.setImageResource(R.drawable.fundo_servico);

        //spinner de tipo de serviço
        List<String> spinnerArrayTipo =  new ArrayList<String>();
        spinnerArrayTipo.add(0,"Escolha uma opção");
        spinnerArrayTipo.add("Mecânica");
        spinnerArrayTipo.add("Elétrica");
        spinnerArrayTipo.add("Cozinha");
        spinnerArrayTipo.add("Encanação");
        spinnerArrayTipo.add("Marcenaria");
        spinnerArrayTipo.add("Informática");


        ArrayAdapter<String> adapterTipo = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, spinnerArrayTipo);

        adapterTipo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spServico = (Spinner) findViewById(R.id.spServico);
        spServico.setAdapter(adapterTipo);

        spServico.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) parent.getChildAt(0)).setTextColor(Color.rgb(74, 74, 74));
                if(parent.getItemAtPosition(position).equals("Escolha uma opção")){
                    ((TextView) parent.getChildAt(0)).setTextColor(Color.rgb(74, 74, 74));

                } else
                {
                    //nd tbm fdc
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //TODO Auto-genetared method stub
            }
        });
        //////////////////////////////////////////
        //spinner de experiencia profissional
        List<String> spinnerArrayExperiencia =  new ArrayList<String>();
        spinnerArrayExperiencia.add(0,"Escolha uma opção");
        spinnerArrayExperiencia.add("Básica");
        spinnerArrayExperiencia.add("Mediana");
        spinnerArrayExperiencia.add("Avançada");


        ArrayAdapter<String> adapterExperiencia = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, spinnerArrayExperiencia);

        adapterExperiencia.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spExperiencia = (Spinner) findViewById(R.id.spExperiencia);
        spExperiencia.setAdapter(adapterExperiencia);

        spExperiencia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) parent.getChildAt(0)).setTextColor(Color.rgb(74, 74, 74));
                if(parent.getItemAtPosition(position).equals("Escolha uma opção")){
                    ((TextView) parent.getChildAt(0)).setTextColor(Color.rgb(74, 74, 74));

                } else
                {
                    //nd tbm fdc
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //TODO Auto-genetared method stub
            }
        });

        ////////////////////////////////////////////////////////////////////////////////////////

        btnToAcordos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selected = spServico.getSelectedItem().toString();
                if (!selected.equals("Escolha uma opção")) {
                    boolean insert;
                    insert = db.AddServicoByEmail(selected, MainActivity.SetEmail);
                    if(insert){
                        Intent ToAcordos = new Intent(CadastroServico.this, CadastroAcordosLegais.class);
                        startActivity(ToAcordos);
                    } else{
                        Toast.makeText(CadastroServico.this, "Selecione todos os dados", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });



    }
}
