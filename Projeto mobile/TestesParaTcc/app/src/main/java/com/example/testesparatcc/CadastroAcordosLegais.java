package com.example.testesparatcc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CadastroAcordosLegais extends AppCompatActivity {

    CheckBox cbCiente;
    Button btnConfirmar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acordos_legais);

        cbCiente = (CheckBox)findViewById(R.id.cbCiente);
        btnConfirmar = (Button)findViewById(R.id.btnNextAcordos);

        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cbCiente.isChecked()){
                    Intent menu = new Intent(CadastroAcordosLegais.this, Menu.class);
                    startActivity(menu);
                } else{
                    cbCiente.requestFocus();
                    Toast.makeText(CadastroAcordosLegais.this, "Não é possível continuar sem aceitar os acordos legais", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
