package com.example.testesparatcc;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class CadastroFoto extends AppCompatActivity {
    final int REQUEST_CODE_GALLERY=999;

    ClasseBanco db;

    public Button btnImg;
    public ImageView imgFunc;
    public TextView txtEscrito;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadfoto2);
        Context context;

        db = new ClasseBanco(this);
        btnImg = (Button) findViewById(R.id.btnCadastrarImg);
        imgFunc = (ImageView) findViewById(R.id.profile_image);
        txtEscrito = (TextView) findViewById(R.id.textView4);

        //txtEscrito.setText(db.getData("select count(*) from PrestServ5", null));
        //txtEscrito.setText(db.getTeste(MainActivity.SetEmail, CadastroFoto.this));

        btnImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                byte[] newEntryImg = imageViewToByte(imgFunc);
                AddImageByEmail(newEntryImg, MainActivity.SetEmail);
            }

        });

        imgFunc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCompat.requestPermissions(
                        CadastroFoto.this,
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
                imgFunc.setImageBitmap(bitmap);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    private void AddImageByEmail(byte[] Image, String email){

        boolean insertData = db.AddImageByEmail(Image, email);
        if (insertData) {
            Intent cadEndereco = new Intent(CadastroFoto.this, CadastroEndereco.class);
            startActivity(cadEndereco);
        } else {
            Toast.makeText((getApplicationContext()), "Erro no upload da imagem", Toast.LENGTH_SHORT).show();
        }
    }


}
