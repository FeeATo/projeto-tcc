package com.example.testesparatcc;

import android.graphics.Bitmap;

public class ModelClassImage {


    private Bitmap imagem;

    public ModelClassImage(Bitmap imagem){

        this.imagem = imagem;
    }


    public Bitmap getImage(){
        return imagem;
    }

    public void setImage(Bitmap imagem){
        this.imagem = imagem;
    }
}
