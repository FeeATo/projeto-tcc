package com.example.testesparatcc.cliente;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import com.example.testesparatcc.ClasseBanco;
import com.example.testesparatcc.Login;
import com.example.testesparatcc.Menu;
import com.example.testesparatcc.R;

import static java.lang.Integer.parseInt;

public class FinalizarPedido extends AppCompatActivity {


    TextView txtConfPrestadorPedido, txtConfEmailPrestadorPedido, txtConfTelefonePedido, txtConfServicoPedido,txtEndereco,
            txtNumero, txtComplemento, txtNomeCliente;
    Button btnFinalizar;
    ClasseBanco db;
    String output;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finalizar_pedido_cliente);

        db = new ClasseBanco(this);

        btnFinalizar = (Button) findViewById(R.id.btnFazerPedido);

        txtEndereco = (TextView) findViewById(R.id.editConfEnderecoPedido);
        txtNumero = (TextView) findViewById(R.id.editConfNumeroPedido);
        txtComplemento = (TextView) findViewById(R.id.editConfComplementoPedido);
        txtNomeCliente = (TextView) findViewById(R.id.editConfNomeClientePedido);

        txtConfPrestadorPedido = (TextView) findViewById(R.id.txtConfPrestadorPedido);
        txtConfEmailPrestadorPedido = (TextView) findViewById(R.id.txtConfEmailPedido);
        txtConfTelefonePedido = (TextView) findViewById(R.id.txtConfTelefonePedido);
        txtConfServicoPedido = (TextView) findViewById(R.id.txtConfServicoPedido);


        //setTexts
        SetEnderecoEditsByEmail(CadastroCliente.SetEmailCliente);
        SetDadosPrestadorById(parseInt(ListaPrestadores.idPrestador));

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mensagem = "Há um novo serviço, deseja aceitar?";

                if (db.CriarServicoByIds(db.getIdClienteByEmail(CadastroCliente.SetEmailCliente), parseInt(ListaPrestadores.idPrestador))){
                    NotificationCompat.Builder builder = new NotificationCompat.Builder(FinalizarPedido.this)
                            .setSmallIcon(R.drawable.ic_novoservico_icon)
                            .setContentTitle("Novo serviço!")
                            .setAutoCancel(true);

                    Intent notificacao = new Intent(FinalizarPedido.this, Login.class);
                    notificacao.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    notificacao.putExtra("message", mensagem);

                    PendingIntent pendingIntent = PendingIntent.getActivity(FinalizarPedido.this, 0, notificacao,PendingIntent.FLAG_UPDATE_CURRENT);
                    builder.setContentIntent(pendingIntent);

                    NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);

                    notificationManager.notify(0, builder.build());

                    Toast.makeText(FinalizarPedido.this, "Pedido enviado com sucesso!", Toast.LENGTH_LONG).show();
                } else
                    Toast.makeText(FinalizarPedido.this, "não criou pedido", Toast.LENGTH_SHORT).show();

            }
        });

    }

    public void SetEnderecoEditsByEmail(String email){
        try
        {
            SQLiteDatabase objectSQLite = db.getWritableDatabase();
            Cursor data = objectSQLite.rawQuery("select nome_usu,endereco, complemento, numero from Usuario where email='"+email+"'",null);
            if (data.moveToFirst()) {
                do {
                    txtNomeCliente.setText(data.getString(0));
                    txtEndereco.setText(data.getString(1));
                    txtComplemento.setText(data.getString(2));
                    txtNumero.setText(data.getString(3));
                } while (data.moveToNext());
            }

        }catch (Exception ex){
            Toast.makeText(FinalizarPedido.this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void SetDadosPrestadorById(int id){
        try
        {
            SQLiteDatabase objectSQLite = db.getWritableDatabase();
            Cursor data = objectSQLite.rawQuery("select nome, email, telefone, tipo_serv from PrestServ9 where id='"+id+"'",null);
            if (data.moveToFirst()) {
                do {
                    txtConfPrestadorPedido.setText(data.getString(0));
                    txtConfEmailPrestadorPedido.setText(data.getString(1));
                    txtConfTelefonePedido.setText(data.getString(2));
                    txtConfServicoPedido.setText(data.getString(3));

                } while (data.moveToNext());
            }

        }catch (Exception ex){
            Toast.makeText(FinalizarPedido.this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
