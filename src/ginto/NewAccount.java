package ginto;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class NewAccount extends javax.swing.JFrame {

    public NewAccount() {
        initComponents();
        Connect();

    }
    Connection con;
    PreparedStatement pst;
    ResultSet Rs;

    public void Connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://sql6.freesqldatabase.com/sql6695512", "sql6695512", "GFTh9FuTKq");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NewAccount.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(NewAccount.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtuser = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        txtnew = new javax.swing.JPasswordField();
        txtconfirm = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        a = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(255, 255, 255)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 38)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("New Account");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, -1, 50));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Username :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 70, -1));

        txtuser.setBackground(new java.awt.Color(0, 0, 51));
        txtuser.setForeground(new java.awt.Color(255, 255, 255));
        txtuser.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtuser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtuserFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtuserFocusLost(evt);
            }
        });
        txtuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtuserActionPerformed(evt);
            }
        });
        jPanel1.add(txtuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 320, 40));

        jCheckBox1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-eye-18.png"))); // NOI18N
        jCheckBox1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-eye-18 (1).png"))); // NOI18N
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 220, -1, -1));

        jCheckBox3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-eye-18.png"))); // NOI18N
        jCheckBox3.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-eye-18 (1).png"))); // NOI18N
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 290, -1, -1));

        txtnew.setBackground(new java.awt.Color(0, 0, 51));
        txtnew.setForeground(new java.awt.Color(255, 255, 255));
        txtnew.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtnew.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtnewFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtnewFocusLost(evt);
            }
        });
        txtnew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnewActionPerformed(evt);
            }
        });
        jPanel1.add(txtnew, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 320, 40));

        txtconfirm.setBackground(new java.awt.Color(0, 0, 51));
        txtconfirm.setForeground(new java.awt.Color(255, 255, 255));
        txtconfirm.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtconfirm.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtconfirmFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtconfirmFocusLost(evt);
            }
        });
        jPanel1.add(txtconfirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 320, 40));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Password :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Confirm Password :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, -1, -1));

        jButton1.setBackground(new java.awt.Color(0, 0, 153));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Confirm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 370, 180, 40));

        a.setBackground(new java.awt.Color(0, 0, 51));
        a.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-left-3-20.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel4MouseExited(evt);
            }
        });
        a.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 20, 40));

        jPanel1.add(a, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 40));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(400, 445));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void mini(JPanel a) {
        a.setBackground(new Color(153, 153, 153));
    }

    public void close(JPanel a1) {
        a1.setBackground(new Color(0, 0, 51));
    }

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        dispose();
        Login lg = new Login();
        lg.setVisible(true);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void txtuserFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtuserFocusGained

    }//GEN-LAST:event_txtuserFocusGained

    private void txtuserFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtuserFocusLost

    }//GEN-LAST:event_txtuserFocusLost

    private void txtuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtuserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtuserActionPerformed

    private void txtnewFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtnewFocusGained

    }//GEN-LAST:event_txtnewFocusGained

    private void txtnewFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtnewFocusLost

    }//GEN-LAST:event_txtnewFocusLost

    private void txtnewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnewActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnewActionPerformed

    private void txtconfirmFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtconfirmFocusGained

    }//GEN-LAST:event_txtconfirmFocusGained

    private void txtconfirmFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtconfirmFocusLost

    }//GEN-LAST:event_txtconfirmFocusLost

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if (jCheckBox1.isSelected()) {
            txtnew.setEchoChar((char) 0);
        } else {
            txtnew.setEchoChar('*');
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
        if (jCheckBox3.isSelected()) {
            txtconfirm.setEchoChar((char) 0);
        } else {
            txtconfirm.setEchoChar('*');
        }
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String user, pass, confirm;

        user = txtuser.getText();
        pass = txtnew.getText();
        confirm = txtconfirm.getText();

        if (user.equals(user) && (pass.equals(confirm))) {
            try {
                int optionType = JOptionPane.YES_NO_OPTION;
                int result = JOptionPane.showConfirmDialog(null, "Confirm", "Create Account", optionType);
                if (result == JOptionPane.YES_OPTION) {

                }
                int outcome = JOptionPane.showConfirmDialog(null, "Only one account per branch of school is allowed");
                if (outcome == JOptionPane.YES_OPTION) {
                    pst = con.prepareStatement("update account set username = ?, password = ? ");

                    pst.setString(1, user);
                    pst.setString(2, pass);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Succesfully Created New Account");

                    txtuser.setText("");
                    txtnew.setText("");
                    txtconfirm.setText("");

                    txtuser.requestFocus();

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseEntered
        mini(a);
    }//GEN-LAST:event_jLabel4MouseEntered

    private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseExited
        close(a);
    }//GEN-LAST:event_jLabel4MouseExited

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
            java.util.logging.Logger.getLogger(NewAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewAccount().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel a;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtconfirm;
    private javax.swing.JPasswordField txtnew;
    private javax.swing.JTextField txtuser;
    // End of variables declaration//GEN-END:variables
}
