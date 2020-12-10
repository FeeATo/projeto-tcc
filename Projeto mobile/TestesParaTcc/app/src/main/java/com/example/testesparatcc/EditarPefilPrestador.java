package com.example.testesparatcc;

import android.Manifest;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.icu.text.UnicodeSetSpanner;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.testesparatcc.cliente.ListaPrestadores;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class EditarPefilPrestador extends AppCompatActivity {

    final int REQUEST_CODE_GALLERY=999;
    EditText editNomeEditar, editEmailEditar, editTelefoneEditar, editDtNascEditar, editEnderecoEditar, editNumeroEditar, editComplementoEditar, editCpfEditar;
    TextView txtId, txtServico;
    ImageView imgView;
    Spinner spinnerServicoEditar;
    Button btnSalvarEditar;

    public Cursor cursor;

    String output = "";

    ClasseBanco db;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editar_perfil_prestador);

        db = new ClasseBanco(EditarPefilPrestador.this);

        imgView = (ImageView) findViewById(R.id.imgPrestadorEditar);
        txtId = (TextView) findViewById(R.id.idPrestadorEditar);
        editNomeEditar = (EditText) findViewById(R.id.editNomeEditar);
        editEmailEditar = (EditText) findViewById(R.id.editEmailEditar);
        editTelefoneEditar = (EditText) findViewById(R.id.editTelefoneEditar);
        editDtNascEditar = (EditText) findViewById(R.id.editDtNascEditar);
        editEnderecoEditar = (EditText) findViewById(R.id.editEnderecoEditar);
        editNumeroEditar = (EditText) findViewById(R.id.editNumeroEditar);
        editComplementoEditar = (EditText) findViewById(R.id.editComplementoEditar);
        editCpfEditar = (EditText) findViewById(R.id.editCpfEditar);
        txtServico = (TextView) findViewById(R.id.editTiposervEditar);

        btnSalvarEditar = (Button) findViewById(R.id.btnSalvarEditar);

        LoadInformationsById(db.getIdPrestByEmail(MainActivity.SetEmail));

        btnSalvarEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (SalvarAlteracoesById(parseInt(txtId.getText().toString().replace("ID: ", "")))){
                    Toast.makeText(EditarPefilPrestador.this, "Valores alterados", Toast.LENGTH_SHORT).show();
                    Intent toMenu = new Intent(EditarPefilPrestador.this, Menu.class);
                    startActivity(toMenu);
                } else
                    Toast.makeText(EditarPefilPrestador.this, "Nenhum valor alterado", Toast.LENGTH_SHORT).show();
            }
        });

        imgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCompat.requestPermissions(
                        EditarPefilPrestador.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        REQUEST_CODE_GALLERY);
            }
        });
    }

    private byte[] imageViewToByte(ImageView image) {
        Bitmap bitmap = ((BitmapDrawable) image.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100,stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == REQUEST_CODE_GALLERY){
            if(grantResults.length >0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, REQUEST_CODE_GALLERY);
            }
            else {
                Toast.makeText(getApplicationContext(), "You don't have permission to access file location!", Toast.LENGTH_SHORT).show();
            }
            return;
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == REQUEST_CODE_GALLERY && resultCode == RESULT_OK && data != null){
            Uri uri = data.getData();

            try {
                InputStream inputStream = getContentResolver().openInputStream(uri);

                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                imgView.setImageBitmap(bitmap);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }



    //colocar id do prestador, mas n pode editar

    public void LoadInformationsById(int id_prestador){
        try
        {
            List<String> lst = new ArrayList<String>();
            db = new ClasseBanco(EditarPefilPrestador.this);
            SQLiteDatabase objectSQLiteDatabase = db.getWritableDatabase();

            cursor = objectSQLiteDatabase.rawQuery("select * from PrestServ9 where id="+id_prestador, null);
            if(cursor.moveToFirst()){

                lst.add(cursor.getString(0) + " - " + cursor.getString(1) + " - " + cursor.getString(3) + " - " +
                            cursor.getString(4) + " - " + cursor.getString(5) + " - " + cursor.getString(6) + " - " +
                            cursor.getString(7) + " - " + cursor.getString(8) + " - " + cursor.getString(9) + " - " +
                            cursor.getString(10));

            }

            String[] dados = lst.toString().replace("[","").replace("]","").split(" - ");

            txtId.setText("ID: " + dados[0]);
            editNomeEditar.setText(dados[1]);
            editEmailEditar.setText(dados[8]);
            editTelefoneEditar.setText(dados[7]);
            editDtNascEditar.setText(dados[2]);
            editEnderecoEditar.setText(dados[3]);
            editNumeroEditar.setText(dados[4]);
            editComplementoEditar.setText(dados[5]);
            editCpfEditar.setText(dados[6]);
            txtServico.setText(dados[9]);
            imgView.setImageBitmap(db.getImagePrestador(parseInt(dados[0])));

        }catch (Exception ex){
            Toast.makeText(EditarPefilPrestador.this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public boolean SalvarAlteracoesById(int id_prestador){

        SQLiteDatabase objSQLiteDatabase = db.getWritableDatabase();
        byte[] newEntryImg = imageViewToByte(imgView);

        ContentValues objContentValues = new ContentValues();
        objContentValues.put("nome", editNomeEditar.getText().toString());
        objContentValues.put("dtNasc", editDtNascEditar.getText().toString());
        objContentValues.put("endereco", editEnderecoEditar.getText().toString());
        objContentValues.put("numero", parseInt(editNumeroEditar.getText().toString()));
        objContentValues.put("complemento", editComplementoEditar.getText().toString());
        objContentValues.put("cpf", editCpfEditar.getText().toString());
        objContentValues.put("telefone", editTelefoneEditar.getText().toString());
        objContentValues.put("prestImg ", newEntryImg);

        int up = objSQLiteDatabase.update("PrestServ9", objContentValues, "id="+id_prestador, null);
        if (up > 0) {
            return true;
        } else {
            return false;
        }
    }




}
