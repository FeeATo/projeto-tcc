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
public class ClasseAdm {
    
    private int id_adm;
    private String nome;
    private String login_adm;
    private String senha;
    private String email;
        
    public ClasseAdm(){}
    
    public ClasseAdm(int Id, String Nome,String login_Adm ,String Senha , String email){
    
        this.id_adm = Id;
        this.nome = Nome;
        this.login_adm = login_Adm;
        this.senha = Senha;
        this.email = email;            
    }      
    
    public void setId(int id){
        this.id_adm = id;
    }
    
    public int getId(){
        return id_adm;
    }
    
    ////////
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getNome(){
        return nome;
    }
    
    ///////
    public void setLoginAdm(String login_adm){
        this.login_adm = login_adm;
    }
    
    public String getLoginAdm(){
        return login_adm;
    }
    
    ////////    
    public void setSenha(String senha){
        this.senha = senha;
    }
    
    public String getSenha(){
        return senha;
    }
    
    /////////
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getEmail(){
        return email;
    }
       
        
}
