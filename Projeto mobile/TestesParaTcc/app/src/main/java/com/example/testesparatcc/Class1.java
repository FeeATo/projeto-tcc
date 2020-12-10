package com.example.testesparatcc;

import android.app.AlertDialog;
import android.content.Context;

public class Class1 {
    public static int tipo_operacao=0;//0 consultar, 1 alterar, 2 excluir
    public static String[]campos=null; //para separar os campos nome e fone com slit();

    public void chamaAlerta(String titulo, String mensagem, Context contexto)
    {
        AlertDialog.Builder alerta = new AlertDialog.Builder(contexto);
        alerta.setTitle(titulo);
        alerta.setMessage(mensagem);
        alerta.setNeutralButton("OK", null);
        alerta.show();
    }
}
