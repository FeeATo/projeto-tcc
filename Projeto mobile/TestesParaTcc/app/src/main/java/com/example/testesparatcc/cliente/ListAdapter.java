package com.example.testesparatcc.cliente;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.testesparatcc.R;
import com.example.testesparatcc.cliente.Prestador;

import java.util.ArrayList;

/*public class ListAdapter extends ArrayAdapter<Prestador> {
    private Context mcontext;
    int mresource;
    private static class ViewHolder{
        ImageView img;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        byte[] img = getItem(position).getImg();
        int[] id = getItem(position).getId();
        String[] nome = getItem(position).getNome();
        String[] telefone = getItem(position).getTelefone();
        String[] email = getItem(position).getEmail();
        Prestador prestador = new Prestador(img, id, nome, telefone, email);

        View result;
        ViewHolder holder;
        if (convertView == null){
            LayoutInflater inflater = LayoutInflater.from(mcontext);
            convertView = inflater.inflate(mresource, parent, false);
            holder = new ViewHolder();
            holder.img = (ImageView)convertView.findViewById(R.id.imgPrestador);
            result = convertView;
            convertView.setTag(holder);
        } else{
            holder = (ViewHolder) convertView.getTag();
            result = convertView;
        }
        holder.img.setImageBitmap(BitmapFactory.decodeByteArray(prestador.getImg(), 0, prestador.getImg().length));
        return convertView;

    }

    public ListAdapter(Context context, int resource, ArrayList<Prestador> objects){
        super(context, resource, objects);
        mcontext = context;
        mresource = resource;


    }
}*/


