/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author Pichau
 */
public class PrestServ {
    
    private int id_prestserv;
    private int id_plano;
    private String nome_prestserv;
    private String senha;
    private String dtNasc;
    private String endereco;
    private int numero;
    private String complemento;
    private String cpf;
    private String telefone;
    private String email;
    private String prestImg_nome;
    private byte[] prestImg;
    
    public PrestServ(){}
    
    public PrestServ(int Id,int Id_plano ,String Nome, String senha , String dtNasc,String Endereco, int Numero, String Complemento, String CPF, String Telefone, String Email,byte[] Imagem){
    
        this.id_prestserv = Id;
        this.id_plano = Id_plano;
        this.nome_prestserv = Nome;
        this.senha = senha;
        this.dtNasc = dtNasc;
        this.endereco = Endereco;
        this.numero = Numero;
        this.complemento = Complemento;
        this.cpf = CPF;
        this.telefone = Telefone;
        this.email = Email;
        this.prestImg = Imagem;
       
    }
    
    public void setIdplano(int id_plano){
        this.id_plano = id_plano;
    }
    
    public int getIdplano(){
        return id_plano;
    }
    
    public void setId(int id){
        this.id_prestserv = id;
    }
    
    public int getId(){
        return id_prestserv;
    }
    
    ////////
    public void setNome(String nome_prestServ){
        this.nome_prestserv = nome_prestServ;
    }
    
    public String getNome(){
        return nome_prestserv;
    }
    
    ////////    
    public void setSenha(String senha){
        this.senha = senha;
    }
    
    public String getSenha(){
        return senha;
    }
    
    ///////
    public void setDtNasc(String dtNasc){
        this.dtNasc = dtNasc;
    }
    
    public String getDtNasc(){
        return dtNasc;
    }
    
    ///////
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
    
    public String getEndereco(){
        return endereco;
    }
    
    ///////
    public void setNumero(int numero){
        this.numero = numero;
    }
    
    public int getNumero(){
        return numero;
    }
    
    ////////
    public void setComplemento(String complemento){
        this.complemento = complemento;
    }
    
    public String getComplemento(){
        return complemento;
    }
    
    //////////
    public void setCpf(String cpf){
        this.cpf = cpf;
    }
    
    public String getCpf(){
        return cpf;
    }
    
    /////////
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
    
    public String getTelefone(){
        return telefone;
    }
    
    /////////
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getEmail(){
        return email;
    }
    
    //////////
    public void setPrestImg_nome(String prestImg_nome){
        this.prestImg_nome = prestImg_nome;
    }
    
    public String getPrestImg_nome(){
        return prestImg_nome;
    }
    
    //////////
    public void setPrestImg(byte[] prestImg){
        this.prestImg = prestImg;
    }
    
    public byte[] getPrestImg(){
        return prestImg;
    }
}
