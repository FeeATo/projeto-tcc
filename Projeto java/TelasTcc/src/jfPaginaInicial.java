
import classes.MetodosUtilitarios;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import javafx.scene.paint.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pichau
 */
public class jfPaginaInicial extends javax.swing.JFrame {

    MetodosUtilitarios getName;
    String timeStamp = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(Calendar.getInstance().getTime()); 
    Color color = Color.rgb(0, 0, 0);
    float ColorArray[];
    /**
     * Creates new form jfPaginaInicial
     */
    public jfPaginaInicial() {
        initComponents();
        getName = new MetodosUtilitarios();
        lblBemVindo.setText("Bem-vindo, " + getName.GetNameByLoginName(Login.SetLoginName) + "!");               
        lblDataEHora.setText(timeStamp);    
        setIcon();
               
    }
    
    private void setIcon(){
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.png")));
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
        jpEsquerda = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jpUsuario = new javax.swing.JPanel();
        lblUsuario = new javax.swing.JLabel();
        jpServico = new javax.swing.JPanel();
        lblServico = new javax.swing.JLabel();
        jpPrestador = new javax.swing.JPanel();
        lblPrestador = new javax.swing.JLabel();
        jpAdm = new javax.swing.JPanel();
        lblAdm = new javax.swing.JLabel();
        btnTrocaUsuario = new javax.swing.JLabel();
        btnSair = new javax.swing.JLabel();
        jpDireita = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblBemVindo = new javax.swing.JLabel();
        lblDataEHora = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(252, 252, 252));
        jPanel1.setLayout(null);

        jpEsquerda.setBackground(new java.awt.Color(252, 252, 252));
        jpEsquerda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(191, 191, 191)));
        jpEsquerda.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Leelawadee UI", 1, 16)); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jpEsquerda.add(jLabel1);
        jLabel1.setBounds(20, 20, 210, 50);
        jLabel1.getAccessibleContext().setAccessibleName("consultaBackBranco");

        jLabel2.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        jLabel2.setText("CONSULTA");
        jpEsquerda.add(jLabel2);
        jLabel2.setBounds(40, 33, 110, 25);

        jpUsuario.setBackground(new java.awt.Color(227, 227, 227));
        jpUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpUsuarioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jpUsuarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jpUsuarioMouseExited(evt);
            }
        });

        lblUsuario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(0, 102, 204));
        lblUsuario.setText("CONSULTAR USUÁRIO ");
        lblUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblUsuarioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblUsuarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblUsuarioMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jpUsuarioLayout = new javax.swing.GroupLayout(jpUsuario);
        jpUsuario.setLayout(jpUsuarioLayout);
        jpUsuarioLayout.setHorizontalGroup(
            jpUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpUsuarioLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblUsuario)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jpUsuarioLayout.setVerticalGroup(
            jpUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jpEsquerda.add(jpUsuario);
        jpUsuario.setBounds(25, 70, 200, 40);

        jpServico.setBackground(new java.awt.Color(227, 227, 227));
        jpServico.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpServico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpServicoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jpServicoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jpServicoMouseExited(evt);
            }
        });

        lblServico.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblServico.setForeground(new java.awt.Color(0, 102, 204));
        lblServico.setText("CONSULTAR SERVIÇO");
        lblServico.setToolTipText("");
        lblServico.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblServico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblServicoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblServicoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblServicoMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jpServicoLayout = new javax.swing.GroupLayout(jpServico);
        jpServico.setLayout(jpServicoLayout);
        jpServicoLayout.setHorizontalGroup(
            jpServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpServicoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblServico)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jpServicoLayout.setVerticalGroup(
            jpServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpServicoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblServico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        lblServico.getAccessibleContext().setAccessibleName("lblServico");

        jpEsquerda.add(jpServico);
        jpServico.setBounds(25, 110, 200, 40);

        jpPrestador.setBackground(new java.awt.Color(227, 227, 227));
        jpPrestador.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpPrestador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpPrestadorMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jpPrestadorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jpPrestadorMouseExited(evt);
            }
        });

        lblPrestador.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        lblPrestador.setForeground(new java.awt.Color(0, 102, 204));
        lblPrestador.setText("CONSULTAR PRESTADOR");
        lblPrestador.setToolTipText("");
        lblPrestador.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lblPrestador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPrestadorMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblPrestadorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblPrestadorMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jpPrestadorLayout = new javax.swing.GroupLayout(jpPrestador);
        jpPrestador.setLayout(jpPrestadorLayout);
        jpPrestadorLayout.setHorizontalGroup(
            jpPrestadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPrestadorLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblPrestador)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpPrestadorLayout.setVerticalGroup(
            jpPrestadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPrestadorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPrestador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jpEsquerda.add(jpPrestador);
        jpPrestador.setBounds(25, 150, 200, 40);

        jpAdm.setBackground(new java.awt.Color(227, 227, 227));
        jpAdm.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpAdm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpAdmMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jpAdmMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jpAdmMouseExited(evt);
            }
        });

        lblAdm.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblAdm.setForeground(new java.awt.Color(0, 102, 204));
        lblAdm.setText("CONSULTAR ADM");
        lblAdm.setToolTipText("");
        lblAdm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAdmMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblAdmMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblAdmMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jpAdmLayout = new javax.swing.GroupLayout(jpAdm);
        jpAdm.setLayout(jpAdmLayout);
        jpAdmLayout.setHorizontalGroup(
            jpAdmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAdmLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblAdm)
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jpAdmLayout.setVerticalGroup(
            jpAdmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpAdmLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAdm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jpEsquerda.add(jpAdm);
        jpAdm.setBounds(25, 190, 200, 40);

        btnTrocaUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/trocar usuario 2.png"))); // NOI18N
        btnTrocaUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTrocaUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTrocaUsuarioMouseClicked(evt);
            }
        });
        jpEsquerda.add(btnTrocaUsuario);
        btnTrocaUsuario.setBounds(20, 300, 210, 70);

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/turn off 4.png"))); // NOI18N
        btnSair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSairMouseClicked(evt);
            }
        });
        jpEsquerda.add(btnSair);
        btnSair.setBounds(20, 230, 210, 70);

        jPanel1.add(jpEsquerda);
        jpEsquerda.setBounds(20, 20, 250, 390);

        jpDireita.setBackground(new java.awt.Color(252, 252, 252));
        jpDireita.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(191, 191, 191)));
        jpDireita.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 53)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 128));
        jLabel3.setText("POINT LABOR");
        jpDireita.add(jLabel3);
        jLabel3.setBounds(40, 40, 370, 110);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/logoJava.png"))); // NOI18N
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel4.setIconTextGap(5);
        jpDireita.add(jLabel4);
        jLabel4.setBounds(410, 60, 60, 60);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(25, 25, 112));
        jLabel5.setText("SISTEMA DE CONSULTA");
        jpDireita.add(jLabel5);
        jLabel5.setBounds(150, 130, 230, 20);

        jPanel2.setBackground(new java.awt.Color(25, 25, 112));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 215, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jpDireita.add(jPanel2);
        jPanel2.setBounds(150, 150, 215, 1);

        lblBemVindo.setFont(new java.awt.Font("Calibri", 1, 28)); // NOI18N
        lblBemVindo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBemVindo.setText("Bem-vindo nome!");
        jpDireita.add(lblBemVindo);
        lblBemVindo.setBounds(0, 200, 520, 50);

        lblDataEHora.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblDataEHora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDataEHora.setText("jLabel7");
        lblDataEHora.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        lblDataEHora.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jpDireita.add(lblDataEHora);
        lblDataEHora.setBounds(160, 300, 200, 30);

        jPanel1.add(jpDireita);
        jpDireita.setBounds(290, 20, 520, 390);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 832, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSairMouseClicked
        WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);

        // this will hide and dispose the frame, so that the application quits by
        // itself if there is nothing else around. 
        setVisible(false);
        dispose();
        // if you have other similar frames around, you should dispose them, too.

        // finally, call this to really exit. 
        // i/o libraries such as WiiRemoteJ need this. 
        // also, this is what swing does for JFrame.EXIT_ON_CLOSE
        System.exit(0); 
    }//GEN-LAST:event_btnSairMouseClicked

    private void btnTrocaUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTrocaUsuarioMouseClicked
        new Login().setVisible(true);
        this.setVisible(false);
        dispose();
    }//GEN-LAST:event_btnTrocaUsuarioMouseClicked

    //cria borda quando passa em cima
    private void jpUsuarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpUsuarioMouseEntered
        jpUsuario.setBorder(BorderFactory.createLineBorder(java.awt.Color.gray, 1));
    }//GEN-LAST:event_jpUsuarioMouseEntered

    private void jpUsuarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpUsuarioMouseExited
        jpUsuario.setBorder(BorderFactory.createLineBorder(java.awt.Color.gray, 0));
    }//GEN-LAST:event_jpUsuarioMouseExited

    ///////////
    
    private void jpServicoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpServicoMouseEntered
        jpServico.setBorder(BorderFactory.createLineBorder(java.awt.Color.gray, 1));
    }//GEN-LAST:event_jpServicoMouseEntered

    private void jpServicoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpServicoMouseExited
        jpServico.setBorder(BorderFactory.createLineBorder(java.awt.Color.gray, 0));
    }//GEN-LAST:event_jpServicoMouseExited

    ///////////
    
    private void jpPrestadorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpPrestadorMouseEntered
        jpPrestador.setBorder(BorderFactory.createLineBorder(java.awt.Color.gray, 1));
    }//GEN-LAST:event_jpPrestadorMouseEntered

    private void jpPrestadorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpPrestadorMouseExited
        jpPrestador.setBorder(BorderFactory.createLineBorder(java.awt.Color.gray, 0));
    }//GEN-LAST:event_jpPrestadorMouseExited

    ///////////
    
    private void jpAdmMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpAdmMouseEntered
        jpAdm.setBorder(BorderFactory.createLineBorder(java.awt.Color.gray, 1));
    }//GEN-LAST:event_jpAdmMouseEntered

    private void jpAdmMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpAdmMouseExited
        jpAdm.setBorder(BorderFactory.createLineBorder(java.awt.Color.gray, 0));
    }//GEN-LAST:event_jpAdmMouseExited

    ///////////
    
    private void lblUsuarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUsuarioMouseEntered
        jpUsuario.setBorder(BorderFactory.createLineBorder(java.awt.Color.gray, 1));
    }//GEN-LAST:event_lblUsuarioMouseEntered

    private void lblUsuarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUsuarioMouseExited
        jpUsuario.setBorder(BorderFactory.createLineBorder(java.awt.Color.gray, 0));
    }//GEN-LAST:event_lblUsuarioMouseExited

    ///////////
    
    private void lblServicoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblServicoMouseEntered
        jpServico.setBorder(BorderFactory.createLineBorder(java.awt.Color.gray, 1));
    }//GEN-LAST:event_lblServicoMouseEntered

    private void lblServicoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblServicoMouseExited
        jpServico.setBorder(BorderFactory.createLineBorder(java.awt.Color.gray, 0));
    }//GEN-LAST:event_lblServicoMouseExited

    ///////////
    
    private void lblPrestadorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPrestadorMouseEntered
        jpPrestador.setBorder(BorderFactory.createLineBorder(java.awt.Color.gray, 1));
    }//GEN-LAST:event_lblPrestadorMouseEntered

    private void lblPrestadorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPrestadorMouseExited
        jpPrestador.setBorder(BorderFactory.createLineBorder(java.awt.Color.gray, 0));
    }//GEN-LAST:event_lblPrestadorMouseExited

    ///////////
    
    private void lblAdmMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAdmMouseEntered
        jpAdm.setBorder(BorderFactory.createLineBorder(java.awt.Color.gray, 1));
    }//GEN-LAST:event_lblAdmMouseEntered

    private void lblAdmMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAdmMouseExited
        jpAdm.setBorder(BorderFactory.createLineBorder(java.awt.Color.gray, 0));
    }//GEN-LAST:event_lblAdmMouseExited

    ///////////
    
    //navegacao be like:
    
    private void jpUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpUsuarioMouseClicked
        new jfUsuario().setVisible(true);
        this.setVisible(false);
        dispose();
    }//GEN-LAST:event_jpUsuarioMouseClicked

    private void jpServicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpServicoMouseClicked
        new jfServicos().setVisible(true);
        this.setVisible(false);
        dispose();
    }//GEN-LAST:event_jpServicoMouseClicked

    private void jpPrestadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpPrestadorMouseClicked
        new Funcionarios().setVisible(true);
        this.setVisible(false);
        dispose();
    }//GEN-LAST:event_jpPrestadorMouseClicked

    private void jpAdmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpAdmMouseClicked
        new jfAdm().setVisible(true);
        this.setVisible(false);
        dispose();
    }//GEN-LAST:event_jpAdmMouseClicked

    ////////////
    
    private void lblUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUsuarioMouseClicked
        new jfUsuario().setVisible(true);
        this.setVisible(false);
        dispose();
    }//GEN-LAST:event_lblUsuarioMouseClicked

    private void lblServicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblServicoMouseClicked
        new jfServicos().setVisible(true);
        this.setVisible(false);
        dispose();
    }//GEN-LAST:event_lblServicoMouseClicked

    private void lblPrestadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPrestadorMouseClicked
        new Funcionarios().setVisible(true);
        this.setVisible(false);
        dispose();
    }//GEN-LAST:event_lblPrestadorMouseClicked

    private void lblAdmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAdmMouseClicked
        new jfAdm().setVisible(true);
        this.setVisible(false);
        dispose();
    }//GEN-LAST:event_lblAdmMouseClicked
      
    
    
    
    
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
            java.util.logging.Logger.getLogger(jfPaginaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jfPaginaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jfPaginaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jfPaginaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jfPaginaInicial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnSair;
    private javax.swing.JLabel btnTrocaUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jpAdm;
    private javax.swing.JPanel jpDireita;
    private javax.swing.JPanel jpEsquerda;
    private javax.swing.JPanel jpPrestador;
    private javax.swing.JPanel jpServico;
    private javax.swing.JPanel jpUsuario;
    private javax.swing.JLabel lblAdm;
    private javax.swing.JLabel lblBemVindo;
    private javax.swing.JLabel lblDataEHora;
    private javax.swing.JLabel lblPrestador;
    private javax.swing.JLabel lblServico;
    private javax.swing.JLabel lblUsuario;
    // End of variables declaration//GEN-END:variables
}