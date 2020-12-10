package classes;


import java.awt.Toolkit;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pichau
 */
public class MetodosUtilitarios {
    
    ClasseConexaoJava con;
    String output = "";
    
    public String GetNameByLoginName(String loginName){
        con = new ClasseConexaoJava();
        boolean resultado = con.conectar();
        if(resultado == true){
            try{
                String query = "select nome from ADM where login_adm=?";
                PreparedStatement pst = con.getConn().prepareStatement(query);
                pst.setString(1, loginName);
                
                ResultSet rs = pst.executeQuery();
                while(rs.next()){
                    output = rs.getString("nome").replace(" ","");                    
                }
            } 
            catch (Exception erro){
                JOptionPane.showMessageDialog(null, erro);
            }
        }
        
        return output;
    }
    
    //contadores
    
    public int TabelaQntd(String tabela){
        con = new ClasseConexaoJava();
        boolean resultado = con.conectar();
        if(resultado == true){
            try{
                String query = "select count(*) as 'qntd' from "+tabela+"";
                PreparedStatement pst = con.getConn().prepareStatement(query);
                ResultSet rs = pst.executeQuery();
                
                while(rs.next()){
                    output = rs.getString("qntd");
                }
            }
            catch(Exception erro){
                JOptionPane.showMessageDialog(null, erro);
            }
        }
        
        return Integer.parseInt(output);
    }
}
