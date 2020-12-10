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
public class ClasseServico {
    private int id_servico;
    private int id_prestserv;
    private String nome_prestserv;
    private int id_usuario;
    private String nome_usuario;    
    private String tipo_serv;
    private int avaliacao;
        
    public ClasseServico(){}
    
    public ClasseServico(int Id_servico, int Id_prestserv, String Nome_prestserv, int Id_usuario ,String Nome_usuario ,String Tipo_serv, int Avaliacao){
    
        this.id_servico = Id_servico;
        this.id_prestserv = Id_prestserv;
        this.nome_prestserv = Nome_prestserv;
        this.id_usuario = Id_usuario;
        this.nome_usuario = Nome_usuario;
        
        this.tipo_serv = Tipo_serv;
        this.avaliacao = Avaliacao;
               
    }
    
    
    public void setId_servico(int id){
        this.id_servico = id;
    }
    
    public int getId_servico(){
        return id_servico;
    }
    
    ////////
    public void setId_prestserv(int id){
        this.id_prestserv = id;
    }
    
    public int getId_prestserv(){
        return id_prestserv;
    }
    
    ////////
    public void setNome_prestserv(String nome_prestServ){
        this.nome_prestserv = nome_prestServ;
    }
    
    public String getNome_prestserv(){
        return nome_prestserv;
    }
    
    ////////
    public void setId_usuario(int id){
        this.id_usuario = id;
    }
    
    public int getId_usuario(){
        return id_usuario;
    }
    
    ////////    
    public void setNome_usuario(String nome){
        this.nome_usuario = nome;
    }
    
    public String getNome_usuario(){
        return nome_usuario;
    }
    
    ///////
    public void setAvaliacao(int avaliacao){
        this.avaliacao = avaliacao;
    }
    
    public int getAvaliacao(){
        return avaliacao;
    }
    ///////
    public void setTipo_serv(String tipo){
        this.tipo_serv = tipo;
    }
    
    public String getTipo_serv(){
        return tipo_serv;
    }
    
    
   
   
}
