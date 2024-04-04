package ginto;

import java.awt.Color;
import java.awt.Font;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Forgot extends javax.swing.JFrame {

    public Forgot() {
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
            Logger.getLogger(Forgot.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Forgot.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        usertxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jCheckBox2 = new javax.swing.JCheckBox();
        oldpasstxt = new javax.swing.JPasswordField();
        jCheckBox1 = new javax.swing.JCheckBox();
        txtpass = new javax.swing.JPasswordField();
        jCheckBox3 = new javax.swing.JCheckBox();
        txtnew = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(255, 255, 255)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 38)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Change Password");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, 50));

        jButton1.setBackground(new java.awt.Color(0, 0, 153));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Change");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 380, 180, 40));

        jButton2.setBackground(new java.awt.Color(0, 0, 153));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Find");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 120, 60, -1));

        usertxt.setBackground(new java.awt.Color(0, 0, 51));
        usertxt.setForeground(new java.awt.Color(255, 255, 255));
        usertxt.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        usertxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                usertxtFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                usertxtFocusLost(evt);
            }
        });
        usertxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usertxtActionPerformed(evt);
            }
        });
        jPanel1.add(usertxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 320, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-left-3-20.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 30, 40));

        jCheckBox2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-eye-18.png"))); // NOI18N
        jCheckBox2.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-eye-18 (1).png"))); // NOI18N
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 220, -1, -1));

        oldpasstxt.setBackground(new java.awt.Color(0, 0, 51));
        oldpasstxt.setForeground(new java.awt.Color(255, 255, 255));
        oldpasstxt.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        oldpasstxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                oldpasstxtFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                oldpasstxtFocusLost(evt);
            }
        });
        oldpasstxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oldpasstxtActionPerformed(evt);
            }
        });
        jPanel1.add(oldpasstxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 320, 30));

        jCheckBox1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-eye-18.png"))); // NOI18N
        jCheckBox1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-eye-18 (1).png"))); // NOI18N
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 280, -1, -1));

        txtpass.setBackground(new java.awt.Color(0, 0, 51));
        txtpass.setForeground(new java.awt.Color(255, 255, 255));
        txtpass.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtpass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtpassFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtpassFocusLost(evt);
            }
        });
        txtpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpassActionPerformed(evt);
            }
        });
        jPanel1.add(txtpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 320, 30));

        jCheckBox3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-eye-18.png"))); // NOI18N
        jCheckBox3.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-eye-18 (1).png"))); // NOI18N
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 340, -1, -1));

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
        jPanel1.add(txtnew, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 320, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Username :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 70, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Old Password :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, 20));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("New Password :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Confirm Password :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, -1, -1));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(399, 445));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            pst = con.prepareStatement("select password from account where username=?");
            pst.setString(1, usertxt.getText());
            Rs = pst.executeQuery();

            if (Rs.next()) {
                JOptionPane.showMessageDialog(null, "Current Password Shown.");
                String add1 = Rs.getString("password");
                oldpasstxt.setText(add1);
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Username");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String user, newpass, confirmpass, none;
        user = usertxt.getText();
        newpass = txtpass.getText();
        confirmpass = txtnew.getText();
        none = "";

        if (user.equals(user) && (newpass.equals(confirmpass)))
        try {
            int optionType = JOptionPane.YES_NO_OPTION;
            int result = JOptionPane.showConfirmDialog(null, "Confirm Change Password?", "Change Password", optionType);
            if (result == JOptionPane.YES_OPTION) {
                pst = con.prepareStatement("update account set password = ? where username = ? ");
                pst.setString(1, confirmpass);
                pst.setString(2, user);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Password Updated");
                usertxt.setText("");
                oldpasstxt.setText("");
                txtpass.setText("");
                txtnew.setText("");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } else if (!confirmpass.equals(none)) {
            JOptionPane.showMessageDialog(null, "Password Does Not Match2");
        } else if (!newpass.equals(none)) {
            JOptionPane.showMessageDialog(null, "Password Does Not Match");
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void usertxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usertxtFocusGained
        
        
    }//GEN-LAST:event_usertxtFocusGained

    private void usertxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usertxtFocusLost
        
        
    }//GEN-LAST:event_usertxtFocusLost

    private void usertxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usertxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usertxtActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
          dispose();
        Login lg = new Login();
        lg.setVisible(true);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void oldpasstxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oldpasstxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_oldpasstxtActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
         if (jCheckBox1.isSelected()) {
            txtpass.setEchoChar((char) 0);
        } else {
            txtpass.setEchoChar('*');
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
          if (jCheckBox2.isSelected()) {
            oldpasstxt.setEchoChar((char) 0);
        } else {
            oldpasstxt.setEchoChar('*');
        }
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void oldpasstxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_oldpasstxtFocusGained
       
    }//GEN-LAST:event_oldpasstxtFocusGained

    private void oldpasstxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_oldpasstxtFocusLost
       
    }//GEN-LAST:event_oldpasstxtFocusLost

    private void txtpassFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtpassFocusGained
       
    }//GEN-LAST:event_txtpassFocusGained

    private void txtpassFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtpassFocusLost
         
    }//GEN-LAST:event_txtpassFocusLost

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
         if (jCheckBox3.isSelected()) {
            txtnew.setEchoChar((char) 0);
        } else {
            txtnew.setEchoChar('*');
        }
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void txtnewFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtnewFocusGained
          
    }//GEN-LAST:event_txtnewFocusGained

    private void txtnewFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtnewFocusLost
         
    }//GEN-LAST:event_txtnewFocusLost

    private void txtpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpassActionPerformed

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
            java.util.logging.Logger.getLogger(Forgot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Forgot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Forgot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Forgot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Forgot().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField oldpasstxt;
    private javax.swing.JPasswordField txtnew;
    private javax.swing.JPasswordField txtpass;
    private javax.swing.JTextField usertxt;
    // End of variables declaration//GEN-END:variables

}
