package com.example.testesparatcc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class MainActivity extends AppCompatActivity {

    public TextView editNome, editEmail, editTelefone, editDtNasc, editSenha, editSenhaConfir, txtBemvindo;
    public Button btn;
    public static String SetName;
    public static String SetEmail;

    ClasseBanco db;
    Class1 xx = new Class1();
    String output = "";
    SQLiteDatabase sqlite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        btn = (Button)findViewById(R.id.btnCad);
        editNome = (EditText) findViewById(R.id.editNome);
        editEmail = (EditText) findViewById(R.id.editEmail);
        editTelefone = (EditText) findViewById(R.id.editTelefone);
        editDtNasc = (EditText) findViewById(R.id.editTelefone);
        editSenha = (EditText) findViewById(R.id.editSenha);
        editSenhaConfir = (EditText) findViewById(R.id.editSenhaConfir);
        txtBemvindo = (TextView) findViewById(R.id.txtBemvindo);

        String output = "";
        db = new ClasseBanco(this);

        db.criar_tabela(this);

        ArrayList<String> lst = new ArrayList<String>();
        lst.add("Masculino");
        lst.add("Feminino");
        lst.add("Outros");

        AddData();

    }


    public void AddData(){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                insertvalues();
            }
        });
    }

    public void createDatabase(){
        try{

            db.getReadableDatabase();
        }
        catch(Exception e){
            Toast.makeText(this, "Erro:" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public boolean insertvalues(){
        try{
            SQLiteDatabase objSQLiteDatabase = db.getWritableDatabase();

            if(objSQLiteDatabase != null){

                if (!editNome.getText().toString().isEmpty() && !editEmail.getText().toString().isEmpty()
                        && !editTelefone.getText().toString().isEmpty() && !editDtNasc.getText().toString().isEmpty()
                        && !editEmail.getText().toString().isEmpty() && !editTelefone.getText().toString().isEmpty()
                        && !editSenha.getText().toString().isEmpty() && !editSenhaConfir.getText().toString().isEmpty()) {
                    if (editSenha.getText().toString().equals(editSenhaConfir.getText().toString())) {
                        if (db.getData("select id from PrestServ9 where email='"+editEmail.getText().toString()+"'", MainActivity.this).equals("")) {
                            ContentValues objContentValues = new ContentValues();
                            objContentValues.put("id", parseInt(db.contar_registros("select id from PrestServ9 order by id desc limit 1")) + 1);
                            objContentValues.put("nome", editNome.getText().toString());
                            objContentValues.put("senha ", editSenha.getText().toString());
                            objContentValues.put("dtNasc", editDtNasc.getText().toString());
                            objContentValues.put("endereco", "");
                            objContentValues.put("numero", 0);
                            objContentValues.put("complemento", "");
                            objContentValues.put("cpf", 0);
                            objContentValues.put("telefone", editTelefone.getText().toString());
                            objContentValues.put("email", editEmail.getText().toString());
                            objContentValues.put("tipo_serv", "");
                            objContentValues.put("id_plano", 0);
                            objContentValues.put("prestImg ", "");

                            long checkIfQueryRuns = objSQLiteDatabase.insert("PrestServ9", null, objContentValues);
                            if (checkIfQueryRuns != -1) {
                                String[] firstname = editNome.getText().toString().split(" ");
                                SetName = firstname[0];
                                SetEmail = editEmail.getText().toString();

                                Intent infodetrampo = new Intent(MainActivity.this, InfoDeTrampo.class);
                                startActivity(infodetrampo);
                            } else {
                                xx.chamaAlerta("Erro", "Erro ao inserir valores", MainActivity.this);
                            }
                        } else
                        {
                            xx.chamaAlerta("Aviso", "Este email já está sendo utilizado!", MainActivity.this);
                        }

                    } else
                        xx.chamaAlerta("Aviso", "Senhas não correspondem", MainActivity.this);
                }
                else{
                    xx.chamaAlerta("Aviso", "Por favor, preencha todos os campos.", MainActivity.this);
                }
            }
            return true;
        }
        catch (Exception e){
            xx.chamaAlerta("erro", e.getMessage(), MainActivity.this);
            return false;
        }
    }
}