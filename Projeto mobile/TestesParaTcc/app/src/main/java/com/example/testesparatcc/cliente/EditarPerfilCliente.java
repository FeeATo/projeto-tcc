package com.example.testesparatcc.cliente;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.testesparatcc.ClasseBanco;
import com.example.testesparatcc.EditarPefilPrestador;
import com.example.testesparatcc.MainActivity;
import com.example.testesparatcc.Menu;
import com.example.testesparatcc.R;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class EditarPerfilCliente extends AppCompatActivity {

    EditText editNomeEditar, editEmailEditar, editTelefoneEditar, editDtNascEditar, editEnderecoEditar, editNumeroEditar, editComplementoEditar, editCpfEditar;
    TextView txtId;
    Button btnSalvarEditar;

    public Cursor cursor;
    String output = "";
    ClasseBanco db;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editar_perfil_cliente);

        db = new ClasseBanco(EditarPerfilCliente.this);


        txtId = (TextView) findViewById(R.id.idClienteEditar);
        editNomeEditar = (EditText) findViewById(R.id.editNomeEditarCliente);
        editEmailEditar = (EditText) findViewById(R.id.editEmailEditarCliente);
        editTelefoneEditar = (EditText) findViewById(R.id.editTelefoneEditarCliente);
        editDtNascEditar = (EditText) findViewById(R.id.editDtNascEditarCliente);
        editEnderecoEditar = (EditText) findViewById(R.id.editEnderecoEditarCliente);
        editNumeroEditar = (EditText) findViewById(R.id.editNumeroEditarCliente);
        editComplementoEditar = (EditText) findViewById(R.id.editComplementoEditarCliente);
        editCpfEditar = (EditText) findViewById(R.id.editCpfEditarCliente);

        btnSalvarEditar = (Button) findViewById(R.id.btnSalvarEditarCliente);

        LoadInformationsById(db.getIdClienteByEmail(CadastroCliente.SetEmailCliente));

        btnSalvarEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (SalvarAlteracoesById(parseInt(txtId.getText().toString()))){
                    Toast.makeText(EditarPerfilCliente.this, "Valores alterados", Toast.LENGTH_SHORT).show();
                    Intent toMenu = new Intent(EditarPerfilCliente.this, MenuCliente.class);
                    startActivity(toMenu);
                } else
                    Toast.makeText(EditarPerfilCliente.this, "Nenhum valor alterado", Toast.LENGTH_SHORT).show();
            }
        });


    }

    public void LoadInformationsById(int id_usuario){
        try
        {
            List<String> lst = new ArrayList<String>();
            db = new ClasseBanco(EditarPerfilCliente.this);
            SQLiteDatabase objectSQLiteDatabase = db.getWritableDatabase();

            cursor = objectSQLiteDatabase.rawQuery("select * from Usuario where id="+id_usuario, null);
            if(cursor.moveToFirst()){

                lst.add(cursor.getString(0) + " - " + cursor.getString(1) + " - " + cursor.getString(3) + " - " +
                        cursor.getString(4) + " - " + cursor.getString(5) + " - " + cursor.getString(6) + " - " +
                        cursor.getString(7) + " - " + cursor.getString(8) + " - " + cursor.getString(9));


            }

            String[] dados = lst.toString().replace("[","").replace("]","").split(" - ");

            txtId.setText(dados[0]);
            editNomeEditar.setText(dados[1]);
            editEmailEditar.setText(dados[8]);
            editTelefoneEditar.setText(dados[7]);
            editDtNascEditar.setText(dados[2]);
            editEnderecoEditar.setText(dados[3]);
            editNumeroEditar.setText(dados[4]);
            editComplementoEditar.setText(dados[5]);
            editCpfEditar.setText(dados[6]);


        }catch (Exception ex){
            Log.e("Error",  ex.getMessage());
        }
    }

    public boolean SalvarAlteracoesById(int id_usuario){

        SQLiteDatabase objSQLiteDatabase = db.getWritableDatabase();

        ContentValues objContentValues = new ContentValues();
        objContentValues.put("nome_usu", editNomeEditar.getText().toString());
        objContentValues.put("dtNasc", editDtNascEditar.getText().toString());
        objContentValues.put("endereco", editEnderecoEditar.getText().toString());
        objContentValues.put("numero", parseInt(editNumeroEditar.getText().toString()));
        objContentValues.put("complemento", editComplementoEditar.getText().toString());
        objContentValues.put("cpf", editCpfEditar.getText().toString());
        objContentValues.put("telefone", editTelefoneEditar.getText().toString());


        int up = objSQLiteDatabase.update("Usuario", objContentValues, "id="+id_usuario, null);
        if (up > 0) {
            return true;
        } else {
            return false;
        }
    }
}
