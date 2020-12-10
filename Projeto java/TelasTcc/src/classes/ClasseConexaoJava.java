package classes;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.management.Query;

public class ClasseConexaoJava {
    private String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private String caminho = "jdbc:sqlserver://DESKTOP-SQRS0ER\\SQLEXPRESS;DatabaseName=TccCSharp";
    private String usuario = "sa";
    private String senha = "etesp";    
    private Connection conn;
    
    public boolean conectar(){
        try {
            Class.forName(this.driver);
            this.setConn(DriverManager.getConnection(caminho,usuario,senha));
            return true;
        }
        catch (Exception erro){
            return false;
        }
    }
    
    public Connection getConnection(){
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-SQRS0ER\\SQLEXPRESS;DatabaseName=TccCSharp", "sa","etesp");
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
       
    public void desconectar(){
        try{
            this.getConn().close();
        } catch (Exception ex) {}
    }
    
    public Connection getConn(){
        return conn;
    }
    
    public void setConn(Connection conn){
        this.conn = conn;
    }
    
    
    
}
