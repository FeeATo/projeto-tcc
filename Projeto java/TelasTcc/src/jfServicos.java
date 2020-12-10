
import classes.ClasseAdm;
import classes.ClasseServico;
import classes.ClasseUsuario;
import classes.MetodosUtilitarios;
import classes.PrestServ;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.management.Query;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pichau
 */
public class jfServicos extends javax.swing.JFrame {

    ClasseConexaoJava conn;
    int i;
    ArrayList<ClasseServico> tabelaAdm = new ArrayList<>();
    ClasseAdm classeAdm;
    public static String SetWhichForm;
    
    /**
     * Creates new form jfServicos
     */
    public jfServicos() {
        initComponents();
        mostrarDados();
        setIcon();
        jtDisplay.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    }
    
    private void setIcon(){
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.png")));
    }

    public void mostrarDados(){
        ArrayList<ClasseServico> registros = BindTable();
        DefaultTableModel model = (DefaultTableModel)jtDisplay.getModel();      
        Object[] rows = new Object[8];
        for(i = 0; i < registros.size(); i++){
            rows[0] = registros.get(i).getId_servico();
            rows[1] = registros.get(i).getId_prestserv();
            rows[2] = registros.get(i).getNome_prestserv();
            rows[3] = registros.get(i).getId_usuario();
            rows[4] = registros.get(i).getNome_usuario();            
            rows[5] = registros.get(i).getTipo_serv();
            rows[6] = registros.get(i).getAvaliacao();
            
                       
            model.addRow(rows);                  
        }
        
    }
            
    public ArrayList<ClasseServico> BindTable(){
        conn = new ClasseConexaoJava();
        ArrayList<ClasseServico> list = new ArrayList<ClasseServico>();
        Connection con = conn.getConnection();
        Statement st;
        ResultSet rs;
        
          
        try {
            st = con.createStatement();
            rs = st.executeQuery("select id_servico,id_prestservF, id_usuF, nome_usu,nome_prestserv,tipo_serv,avaliacao from Servico, Usuario,PrestServ where id_usu = id_usuF and id_prestserv = id_prestservF");
   
            ClasseServico p;
            while(rs.next()){
                p = new ClasseServico(
                rs.getInt("id_servico"),
                rs.getInt("id_prestservF"),
                rs.getString("nome_prestserv"),
                rs.getInt("id_usuF"),
                rs.getString("nome_usu"),                
                rs.getString("tipo_serv"),
                rs.getInt("avaliacao")                               
            );
            list.add(p);
            }
        }
        catch (SQLException ex){
            
        }
        
        
        return list;
    }
    
    public void SelectRowByIdPrestador(String tabela){
        int i;
        MetodosUtilitarios prestservCount = new MetodosUtilitarios();
        int qntd = prestservCount.TabelaQntd(tabela);
        
        
        for(i = 0; i < qntd; i++){
            
            if(jtDisplay.getModel().getValueAt(i,1).toString().replace(" ","").equals(txtIDprestador.getText().replace(" ",""))){              
                jtDisplay.setRowSelectionInterval(i, i);
            }
        }
    }
    
    public void SelectRowByIdServico(String tabela){
        int i;
        MetodosUtilitarios prestservCount = new MetodosUtilitarios();
        int qntd = prestservCount.TabelaQntd(tabela);
        
        for(i = 0; i<qntd; i++){
            if(jtDisplay.getModel().getValueAt(i,0).toString().replace(" ","").equals(txtIDservico.getText().replace(" ",""))){
                jtDisplay.setRowSelectionInterval(i, i);
                
            }
        }
    }
    
    public void SelectRowByIdUsuario(String tabela){
        int i;
        MetodosUtilitarios prestservCount = new MetodosUtilitarios();
        int qntd = prestservCount.TabelaQntd(tabela);
        
        for(i = 0; i<qntd; i++){
            if(jtDisplay.getModel().getValueAt(i,3).toString().replace(" ","").equals(txtIDusuario.getText().replace(" ",""))){
                jtDisplay.setRowSelectionInterval(i, i);
                
            }
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtDisplay = new javax.swing.JTable();
        lblHome = new javax.swing.JLabel();
        btnAlerta = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtIDservico = new javax.swing.JTextField();
        txtIDprestador = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        txtIDusuario = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Serviços");
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 800, 540));
        setMaximumSize(new java.awt.Dimension(800, 540));
        setMinimumSize(new java.awt.Dimension(800, 540));
        setPreferredSize(new java.awt.Dimension(805, 576));
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(800, 540));
        jPanel1.setMinimumSize(new java.awt.Dimension(800, 540));
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
                "ID Serviço", "ID Prestador", "Nome Prestador", "ID Usuário", "Nome Usuário", "Tipo de serviço", "Avaliacao"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtDisplay.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jtDisplay.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jtDisplay.setName(""); // NOI18N
        jScrollPane2.setViewportView(jtDisplay);
        if (jtDisplay.getColumnModel().getColumnCount() > 0) {
            jtDisplay.getColumnModel().getColumn(0).setResizable(false);
            jtDisplay.getColumnModel().getColumn(0).setPreferredWidth(105);
            jtDisplay.getColumnModel().getColumn(1).setResizable(false);
            jtDisplay.getColumnModel().getColumn(1).setPreferredWidth(105);
            jtDisplay.getColumnModel().getColumn(2).setResizable(false);
            jtDisplay.getColumnModel().getColumn(2).setPreferredWidth(105);
            jtDisplay.getColumnModel().getColumn(3).setResizable(false);
            jtDisplay.getColumnModel().getColumn(3).setPreferredWidth(105);
            jtDisplay.getColumnModel().getColumn(4).setResizable(false);
            jtDisplay.getColumnModel().getColumn(4).setPreferredWidth(105);
            jtDisplay.getColumnModel().getColumn(5).setResizable(false);
            jtDisplay.getColumnModel().getColumn(5).setPreferredWidth(105);
            jtDisplay.getColumnModel().getColumn(6).setResizable(false);
            jtDisplay.getColumnModel().getColumn(6).setPreferredWidth(105);
        }

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
        lblHome.setBounds(330, 360, 120, 50);

        btnAlerta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/classes/labelerroJava.png"))); // NOI18N
        btnAlerta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAlerta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAlertaMouseClicked(evt);
            }
        });
        jPanel2.add(btnAlerta);
        btnAlerta.setBounds(680, 360, 47, 50);

        jLabel4.setText("ID prestador:");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(170, 360, 76, 20);

        jLabel5.setText("ID usuário:");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(90, 360, 70, 20);
        jPanel2.add(txtIDservico);
        txtIDservico.setBounds(10, 380, 60, 30);
        jPanel2.add(txtIDprestador);
        txtIDprestador.setBounds(170, 380, 70, 30);

        btnPesquisar.setText(" 🔎");
        btnPesquisar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });
        jPanel2.add(btnPesquisar);
        btnPesquisar.setBounds(260, 360, 50, 50);
        jPanel2.add(txtIDusuario);
        txtIDusuario.setBounds(90, 380, 60, 30);

        jLabel7.setText("ID serviço:");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(10, 360, 70, 20);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(30, 90, 740, 420);

        jPanel3.setBackground(new java.awt.Color(52, 85, 185));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Serviços");
        jLabel1.setAlignmentX(0.5F);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(223, 223, 223)
                .addComponent(jLabel1)
                .addContainerGap(229, Short.MAX_VALUE))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHomeMouseClicked
        new jfPaginaInicial().setVisible(true);
        this.setVisible(false);
        dispose();
    }//GEN-LAST:event_lblHomeMouseClicked

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        if(!(txtIDprestador.getText().equals("")) && txtIDservico.getText().equals("") && txtIDusuario.getText().equals("")){            
            SelectRowByIdPrestador("Servico");
        }
        if(txtIDprestador.getText().equals("") && !(txtIDservico.getText().equals("")) && txtIDusuario.getText().equals("")){            
            SelectRowByIdServico("Servico");
        }
        if(txtIDprestador.getText().equals("") && (txtIDservico.getText().equals("")) && !(txtIDusuario.getText().equals(""))){            
            SelectRowByIdUsuario("Servico");
        }
        
    }//GEN-LAST:event_btnPesquisarActionPerformed

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
            java.util.logging.Logger.getLogger(jfServicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jfServicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jfServicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jfServicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jfServicos().setVisible(true);
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
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jtDisplay;
    private javax.swing.JLabel lblHome;
    private javax.swing.JTextField txtIDprestador;
    private javax.swing.JTextField txtIDservico;
    private javax.swing.JTextField txtIDusuario;
    // End of variables declaration//GEN-END:variables
}
