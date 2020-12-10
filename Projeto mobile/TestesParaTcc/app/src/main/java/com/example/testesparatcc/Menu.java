package com.example.testesparatcc;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class Menu extends AppCompatActivity {

    TextView txtNome;
    ClasseBanco db;
    ImageView imgPrestador;

    Button btnAceitar;
    public static String idServico;
    public Cursor cursor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        db = new ClasseBanco(Menu.this);

        btnAceitar = (Button) findViewById(R.id.btnAceitarServico);
        imgPrestador = (ImageView) findViewById(R.id.imagePrestadorMenu);

        imgPrestador.setImageBitmap(db.getImagePrestador(db.getIdPrestByEmail(MainActivity.SetEmail)));


        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new HomeFragment()).commit();

        db = new ClasseBanco(this);
        txtNome = (TextView) findViewById(R.id.txtNome);

        String id = db.SearchForServicesByPrestId(db.getIdPrestByEmail(MainActivity.SetEmail), Menu.this).toString();
        String count = db.CountAguardandoServices(db.getIdPrestByEmail(MainActivity.SetEmail), Menu.this).toString();

        if (count.equals("1")) {
            btnAceitar.setVisibility(View.VISIBLE);
            idServico = id;
        }





        String query = "select nome from PrestServ9 where email='" + MainActivity.SetEmail + "'";
        txtNome.setText(db.getData(query, Menu.this));


        btnAceitar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MessagesFragment.idServicoStatic = id;
                Intent toAceitarServico = new Intent(Menu.this, DetalhesServicoAceitar.class);
                startActivity(toAceitarServico);
            }
        });
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.nav_inicio:
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.nav_caixadeentrada:
                            selectedFragment = new MessagesFragment();
                            break;
                        case R.id.nav_perfil:
                            selectedFragment = new ProfileFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();
                    return true;
                }
            };




}
