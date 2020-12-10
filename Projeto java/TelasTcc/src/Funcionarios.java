

import classes.PrestServ;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import classes.MetodosUtilitarios;
import classes.ModeloTabela;
import java.awt.Component;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.paint.Color;
import javax.management.Query;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import javax.swing.table.TableCellRenderer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pichau
 */
public class Funcionarios extends javax.swing.JFrame {

    ClasseConexaoJava conn;
    int i;
    ArrayList<PrestServ> tabelaPrestServ = new ArrayList<>();
    PrestServ db_prestserv;
    public static String SetWhichForm;
    MetodosUtilitarios prestservCount = new MetodosUtilitarios();
        
    
    public Funcionarios() {
        initComponents();
        mostrarDados();
        setIcon();   
          
    }

    private void setIcon(){
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.png")));
    }
    
    //popula o grid
    public void mostrarDados(){
        String []nomesColunas = {"Imagem", "ID","ID Plano" ,"Nome", "Senha", "Data de nascimento", "Endereço", "Número", "Complemento", "CPF", "Telefone", "Email"};
        ArrayList<PrestServ> registros = BindTable();
        Object[][] rows = new Object[registros.size()][12];
        for(i = 0; i < registros.size(); i++){
            rows[i][1] = registros.get(i).getId();
            rows[i][2] = registros.get(i).getIdplano();
            rows[i][3] = registros.get(i).getNome();
            rows[i][4] = registros.get(i).getSenha();
            rows[i][5] = registros.get(i).getDtNasc();
            rows[i][6] = registros.get(i).getEndereco();
            rows[i][7] = registros.get(i).getNumero();
            rows[i][8] = registros.get(i).getComplemento();
            rows[i][9] = registros.get(i).getCpf();
            rows[i][10] = registros.get(i).getTelefone();
            rows[i][11] = registros.get(i).getEmail();
            
            if(registros.get(i).getPrestImg() != null){
                ImageIcon imagem = new ImageIcon(new ImageIcon(registros.get(i).getPrestImg()).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH) ); 
                rows[i][0] = imagem;
            }
            else{
                rows[i][0] = null;
            }
                       
            ModeloTabela model = new ModeloTabela(rows, nomesColunas);
            jtDisplay.setModel(model);
            jtDisplay.setRowHeight(90);
            jtDisplay.getColumnModel().getColumn(10).setPreferredWidth(90);                     
        }        
    }
            
    public ArrayList<PrestServ> BindTable(){
        conn = new ClasseConexaoJava();
        ArrayList<PrestServ> list = new ArrayList<PrestServ>();
        Connection con = conn.getConnection();
        Statement st;
        ResultSet rs;
        
          
        try {
            st = con.createStatement();
            rs = st.executeQuery("select * from PrestServ");
   
            PrestServ p;
            while(rs.next()){
                p = new PrestServ(
                rs.getInt("id_prestserv"),
                rs.getInt("id_plano"),
                rs.getString("nome_prestserv"),
                rs.getString("senha"),
                rs.getString("dtNasc"),
                rs.getString("endereco"),
                rs.getInt("numero"),
                rs.getString("complemento"),
                rs.getString("cpf"),
                rs.getString("telefone"),
                rs.getString("email"),
                rs.getBytes("prestImg")                       
                
            );
            list.add(p);
            }
        }
        catch (SQLException ex){
            
        }
        
        
        return list;
    }
    
    
    
    
    /*public void mostrarDados(){
        
        con = new ClasseConexaoJava();
        boolean resultado = con.conectar();
        if(resultado == true){
            try{
                PreparedStatement pst = con.getConn().prepareStatement("select * from PrestServ");
                ResultSet rs = pst.executeQuery();
                while(rs.next()){
                   db_prestserv = new PrestServ();
                   db_prestserv.setId(Integer.parseInt(rs.getString(1)));
                   db_prestserv.setNome(rs.getString(2));
                   db_prestserv.setSenha(rs.getString(3));
                   db_prestserv.setDtNasc(rs.getString(4));
                   db_prestserv.setEndereco(rs.getString(5));
                   db_prestserv.setNumero(Integer.parseInt(rs.getString(6)));
                   db_prestserv.setComplemento(rs.getString(7));
                   db_prestserv.setCpf(rs.getString(8));
                   db_prestserv.setTelefone(rs.getString(9));
                   db_prestserv.setEmail(rs.getString(10));
                   db_prestserv.setPrestImg(rs.getBytes(12));
                   tabelaPrestServ.add(db_prestserv);                   
               }
               //mostrarGrid();
            }
            catch (Exception erro){
                JOptionPane.showMessageDialog(null, erro);
            }
        } 
        else{
            JOptionPane.showMessageDialog(null, "Consulta a tabela de prest serv falhou");
        }
    }*/
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtDisplay = new javax.swing.JTable();
        lblHome = new javax.swing.JLabel();
        btnAlerta = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Prestadores de serviço");
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setLocation(new java.awt.Point(0, 0));
        setMaximumSize(new java.awt.Dimension(780, 533));
        setMinimumSize(new java.awt.Dimension(780, 533));
        setResizable(false);
        setSize(new java.awt.Dimension(780, 533));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(780, 650));
        jPanel1.setMinimumSize(new java.awt.Dimension(780, 650));
        jPanel1.setPreferredSize(new java.awt.Dimension(780, 650));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(722, 426));
        jPanel2.setRequestFocusEnabled(false);
        jPanel2.setLayout(null);

        jtDisplay.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jtDisplay.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtDisplay.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jtDisplay.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jtDisplay.setName(""); // NOI18N
        jScrollPane2.setViewportView(jtDisplay);

        jPanel2.add(jScrollPane2);
        jScrollPane2.setBounds(0, 0, 740, 350);

        lblHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/homeJavaIcon.png"))); // NOI18N
        lblHome.setText("jLabel2");
        lblHome.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblHome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHomeMouseClicked(evt);
            }
        });
        jPanel2.add(lblHome);
        lblHome.setBounds(320, 360, 120, 50);

        btnAlerta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/classes/labelerroJava.png"))); // NOI18N
        btnAlerta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAlerta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAlertaMouseClicked(evt);
            }
        });
        jPanel2.add(btnAlerta);
        btnAlerta.setBounds(680, 360, 47, 50);

        jLabel4.setText("Nome:");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(10, 360, 38, 20);

        jLabel5.setText("ID:");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(10, 390, 17, 20);
        jPanel2.add(txtID);
        txtID.setBounds(60, 390, 180, 23);
        jPanel2.add(txtNome);
        txtNome.setBounds(60, 360, 180, 23);

        btnPesquisar.setText(" 🔎");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });
        jPanel2.add(btnPesquisar);
        btnPesquisar.setBounds(250, 360, 50, 50);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(30, 90, 740, 420);

        jPanel3.setBackground(new java.awt.Color(52, 85, 185));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Prestadores de serviço");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(149, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(149, 149, 149))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(120, 20, 544, 50);

        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel1.add(jLabel6);
        jLabel6.setBounds(20, 80, 760, 440);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 540, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void SelectRowByName(String tabela){
        int i;
        MetodosUtilitarios prestservCount = new MetodosUtilitarios();
        int qntd = prestservCount.TabelaQntd(tabela);
        
        
        for(i = 0; i < qntd; i++){
            
            if(jtDisplay.getModel().getValueAt(i,2).toString().replace(" ","").equals(txtNome.getText().replace(" ",""))){              
                jtDisplay.setRowSelectionInterval(i, i);             
            }
        }
    }
    
    public void SelectRowById(String tabela){
        int i;
        MetodosUtilitarios prestservCount = new MetodosUtilitarios();
        int qntd = prestservCount.TabelaQntd(tabela);
        
        for(i = 0; i<qntd; i++){
            if(jtDisplay.getModel().getValueAt(i,1).toString().replace(" ","").equals(txtID.getText().replace(" ",""))){
                jtDisplay.setRowSelectionInterval(i, i);
                
            }
        }
    }
    
    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        if(!(txtNome.getText().equals("")) && txtID.getText().equals("")){
            SelectRowByName("PrestServ");
        }
        if((txtNome.getText().equals("")) && !(txtID.getText().equals(""))){
            SelectRowById("PrestServ");
        }
        if(!(txtNome.getText().equals("")) && !(txtID.getText().equals(""))){
            SelectRowById("PrestServ");
        }
        
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void lblHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHomeMouseClicked
        new jfPaginaInicial().setVisible(true);
        this.setVisible(false);
        dispose();
    }//GEN-LAST:event_lblHomeMouseClicked

    private void btnAlertaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAlertaMouseClicked
        
        new jfMsgCSharp().setVisible(true);
        
    }//GEN-LAST:event_btnAlertaMouseClicked
    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Funcionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Funcionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Funcionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Funcionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Funcionarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAlerta;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jtDisplay;
    private javax.swing.JLabel lblHome;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables

    private Object GetData(JTable jtDisplay, int i, int i0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
