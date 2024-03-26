
package ginto;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;


public class Login extends javax.swing.JFrame {

    
    public Login() {
        initComponents();
    }
    
    public void close (){
        WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Rigth = new javax.swing.JPanel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        u1 = new javax.swing.JTextField();
        p1 = new javax.swing.JPasswordField();
        b1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Change = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("LOGIN");
        setMinimumSize(new java.awt.Dimension(800, 500));
        setUndecorated(true);

        jPanel1.setToolTipText("LOGIN");
        jPanel1.setLayout(null);

        Rigth.setBackground(new java.awt.Color(0, 0, 51));
        Rigth.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(255, 255, 255)));
        Rigth.setForeground(new java.awt.Color(255, 255, 255));
        Rigth.setMinimumSize(new java.awt.Dimension(810, 500));
        Rigth.setLayout(null);

        jCheckBox1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(31, 25, 60)));
        jCheckBox1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-eye-18.png"))); // NOI18N
        jCheckBox1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-eye-18 (1).png"))); // NOI18N
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        Rigth.add(jCheckBox1);
        jCheckBox1.setBounds(730, 230, 20, 20);

        jLabel4.setFont(new java.awt.Font("Microsoft PhagsPa", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Username");
        Rigth.add(jLabel4);
        jLabel4.setBounds(460, 130, 52, 16);

        jLabel5.setFont(new java.awt.Font("Microsoft PhagsPa", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Password");
        Rigth.add(jLabel5);
        jLabel5.setBounds(460, 200, 50, 16);

        u1.setBackground(new java.awt.Color(0, 0, 51));
        u1.setFont(new java.awt.Font("Microsoft PhagsPa", 0, 12)); // NOI18N
        u1.setForeground(new java.awt.Color(255, 255, 255));
        u1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        u1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                u1ActionPerformed(evt);
            }
        });
        Rigth.add(u1);
        u1.setBounds(460, 160, 290, 30);

        p1.setBackground(new java.awt.Color(0, 0, 51));
        p1.setFont(new java.awt.Font("Microsoft PhagsPa", 0, 12)); // NOI18N
        p1.setForeground(new java.awt.Color(255, 255, 255));
        p1.setAutoscrolls(false);
        p1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        p1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p1ActionPerformed(evt);
            }
        });
        p1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                p1KeyPressed(evt);
            }
        });
        Rigth.add(p1);
        p1.setBounds(460, 230, 290, 30);

        b1.setBackground(new java.awt.Color(255, 255, 255));
        b1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        b1.setForeground(new java.awt.Color(0, 0, 0));
        b1.setText("Log in");
        b1.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1ActionPerformed(evt);
            }
        });
        b1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                b1KeyPressed(evt);
            }
        });
        Rigth.add(b1);
        b1.setBounds(560, 290, 70, 30);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Welcome!");
        Rigth.add(jLabel1);
        jLabel1.setBounds(90, 30, 240, 70);

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("SIGN IN");
        Rigth.add(jLabel2);
        jLabel2.setBounds(560, 70, 70, 23);

        jButton3.setBackground(new java.awt.Color(204, 0, 0));
        jButton3.setForeground(new java.awt.Color(0, 0, 0));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/2.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        Rigth.add(jButton3);
        jButton3.setBounds(770, 10, 20, 20);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 45)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("LIBRARY MANAGEMENT SYSTEM");
        Rigth.add(jLabel6);
        jLabel6.setBounds(30, 410, 750, 60);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-user-32.png"))); // NOI18N
        Rigth.add(jLabel3);
        jLabel3.setBounds(420, 150, 32, 40);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-lock-32.png"))); // NOI18N
        Rigth.add(jLabel8);
        jLabel8.setBounds(420, 220, 30, 40);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-circled-i-20.png"))); // NOI18N
        Rigth.add(jLabel9);
        jLabel9.setBounds(10, 10, 20, 20);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/1710378165978.png"))); // NOI18N
        Rigth.add(jLabel7);
        jLabel7.setBounds(80, 100, 256, 274);

        Change.setForeground(new java.awt.Color(255, 255, 255));
        Change.setText("Forgot/Change Password");
        Change.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ChangeMouseClicked(evt);
            }
        });
        Change.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ChangeKeyPressed(evt);
            }
        });
        Rigth.add(Change);
        Change.setBounds(530, 330, 140, 16);

        jPanel1.add(Rigth);
        Rigth.setBounds(0, 0, 800, 500);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(800, 500));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1ActionPerformed
        String username = "CFSI_Admin";
        String password = "CFSI2024";

        String user = u1.getText();
        String pass = p1.getText();

        if(user.equals(username)&&pass.equals(password)){
            close();
            HomePage pg = new HomePage();
            pg.setVisible(true);
        }
        else if (u1.getText().equals("")&&p1.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please input user and pass");
        }
        else if (u1.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please input username");
        }
        else if (p1.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please input password");
        }
        else if (!u1.getText().equals("")&&!p1.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "invalid user or pass");
        }
    }//GEN-LAST:event_b1ActionPerformed

    private void p1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p1ActionPerformed
        
    }//GEN-LAST:event_p1ActionPerformed

    private void u1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_u1ActionPerformed
        
    }//GEN-LAST:event_u1ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if (jCheckBox1.isSelected())
        {
            p1.setEchoChar((char)0);
        }
        else
        {
            p1.setEchoChar('*');
        }    
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void p1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_p1KeyPressed
       if(evt.getKeyCode()== KeyEvent.VK_ENTER){

            String username = "CFSI_Admin";
            String password = "CFSI2024";
            
            String user = u1.getText();
            String pass = p1.getText();
            
            if(user.equals(username)&&pass.equals(password)){
                close();
                HomePage pg = new HomePage();
                pg.setVisible(true);
            }
            else if (u1.getText().equals("")&&p1.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Please input user and pass");
            }
            else if (u1.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Please input username");
            }
            else if (p1.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Please input password");
            }
            else if (!u1.getText().equals("")&&!p1.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "invalid user or pass");
            }
        }                
       
    }//GEN-LAST:event_p1KeyPressed

    private void b1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_b1KeyPressed
        
    }//GEN-LAST:event_b1KeyPressed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void ChangeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ChangeKeyPressed

         
    }//GEN-LAST:event_ChangeKeyPressed

    private void ChangeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ChangeMouseClicked
       
    }//GEN-LAST:event_ChangeMouseClicked

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Change;
    private javax.swing.JPanel Rigth;
    private javax.swing.JButton b1;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField p1;
    private javax.swing.JTextField u1;
    // End of variables declaration//GEN-END:variables
}
