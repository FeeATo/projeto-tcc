package com.example.testesparatcc.cliente;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.testesparatcc.ClasseBanco;
import com.example.testesparatcc.HomeFragment;
import com.example.testesparatcc.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MenuCliente extends AppCompatActivity {


    ClasseBanco db;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_cliente);

        db = new ClasseBanco(this);



        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation_cliente);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_cliente,
                new HomeFragmentCliente()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch(item.getItemId()){
                        case R.id.nav_inicio_cliente:
                            selectedFragment = new HomeFragmentCliente();
                            break;
                        case R.id.nav_pedido_cliente:
                            selectedFragment = new PedidosFragmentCliente();
                            break;
                        case R.id.nav_perfil_cliente:
                            selectedFragment = new ProfileFragmenteCliente();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_cliente,
                            selectedFragment).commit();
                    return true;
                }
            };
}
