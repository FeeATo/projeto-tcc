package com.example.testesparatcc.cliente;

public class Prestador {

    private byte[] img;
    private int id;
    private String nome;
    private String telefone;
    private String email;

    public Prestador(byte[] img, int id, String nome, String telefone, String email){
        this.img = img;
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



}
