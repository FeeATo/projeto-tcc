package com.example.testesparatcc.cliente;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.testesparatcc.ClasseBanco;
import com.example.testesparatcc.MainActivity;
import com.example.testesparatcc.R;

import static java.lang.Integer.parseInt;

public class CadastroCliente extends AppCompatActivity {

    ClasseBanco db;
    EditText editNome, editEmail, editTelefone, editSenha, editNascimento, editCpf, editEndereco, editNumero, editComple;
    Button btnProximo;
    public static String SetEmailCliente;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastrar_cliente);

        editNome=(EditText) findViewById(R.id.edtNome);
        editEmail=(EditText) findViewById(R.id.edtEmail);
        editTelefone=(EditText) findViewById(R.id.editTelefone);
        editSenha=(EditText) findViewById(R.id.edtSenha);
        editNascimento=(EditText) findViewById(R.id.editNascimento);
        editCpf=(EditText) findViewById(R.id.edtcpf);
        editEndereco=(EditText) findViewById(R.id.edtende);
        editNumero=(EditText) findViewById(R.id.edtnumero);
        editComple=(EditText) findViewById(R.id.edtcomple);
        btnProximo=(Button) findViewById(R.id.btnProximo);

        db = new ClasseBanco(this);
        db.criar_tabela(this);

        btnProximo.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if (!editNome.getText().toString().isEmpty() && !editSenha.getText().toString().isEmpty() && !editEmail.getText().toString().isEmpty()
                        && !editTelefone.getText().toString().isEmpty() && !editNascimento.getText().toString().isEmpty() && !editComple.getText().toString().isEmpty()
                        && !editCpf.getText().toString().isEmpty() && !editEndereco.getText().toString().isEmpty() && !editNumero.getText().toString().isEmpty()) {

                    if (db.getData("select id from Usuario where email='" + editEmail.getText().toString() + "'", CadastroCliente.this).equals("")) {
                        boolean insert;
                        insert = db.CadastroCliente(parseInt(db.contar_registros("select id from Usuario order by id desc limit 1")) + 1, editNome.getText().toString(),
                                editSenha.getText().toString(), editNascimento.getText().toString(),
                                editEndereco.getText().toString(), parseInt(editNumero.getText().toString()), editComple.getText().toString(),
                                parseInt(editCpf.getText().toString()), editTelefone.getText().toString(), editEmail.getText().toString());
                        SetEmailCliente = editEmail.getText().toString();


                        if (insert) {
                            Toast.makeText(CadastroCliente.this, "Valor inserido com sucesso", Toast.LENGTH_SHORT).show();
                            Intent toMenu_cliente = new Intent(CadastroCliente.this, MenuCliente.class);
                            startActivity(toMenu_cliente);


                        } else
                            Toast.makeText(CadastroCliente.this, "Erro ao inserir", Toast.LENGTH_SHORT).show();
                    } else
                        Toast.makeText(CadastroCliente.this, "Este email já está sendo utilizado", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
