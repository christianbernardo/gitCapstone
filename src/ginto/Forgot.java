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
        addPlaceorderStyle(txtpass);
        removePlaceorderStyle(txtnew);
    }

    Connection con;
    PreparedStatement pst;
    ResultSet Rs;

    public void Connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/data", "root", "");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Forgot.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Forgot.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void addPlaceorderStyle(JTextField textield) {
        Font font = txtpass.getFont();
        font = font.deriveFont(Font.PLAIN);
        txtpass.setFont(font);
        txtnew.setForeground(Color.gray); //font color

    }

    public void removePlaceorderStyle(JTextField textfield) {
        Font font = txtnew.getFont();
        font = font.deriveFont(Font.PLAIN);
        txtpass.setFont(font);
        txtnew.setForeground(Color.black);
    }

    public void userPlaceorderStyle(JTextField textield) {
        Font font = usertxt.getFont();
        font = font.deriveFont(Font.PLAIN);
        usertxt.setFont(font);
        oldpasstxt.setForeground(Color.gray); //font color

    }

    public void oldPlaceorderStyle(JTextField textield) {
        Font font = oldpasstxt.getFont();
        font = font.deriveFont(Font.PLAIN);
        usertxt.setFont(font);
        oldpasstxt.setForeground(Color.gray); //font color

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtpass = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtnew = new javax.swing.JPasswordField();
        jButton2 = new javax.swing.JButton();
        usertxt = new javax.swing.JTextField();
        oldpasstxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(380, 380));

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(255, 255, 255)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 38)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("New Password");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, 50));

        txtpass.setText("Create New Password");
        txtpass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtpassFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtpassFocusLost(evt);
            }
        });
        jPanel1.add(txtpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 320, 40));

        jButton1.setBackground(new java.awt.Color(0, 0, 153));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Change");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 360, 180, 30));

        jPanel2.setBackground(new java.awt.Color(255, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel2.setText("Please create a new password that ");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 320, 20));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("you don't use on any other site.");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 320, 20));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 320, 40));

        txtnew.setText("Confirm Password");
        txtnew.setEchoChar('\u0000');
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
        jPanel1.add(txtnew, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 320, 40));

        jButton2.setBackground(new java.awt.Color(255, 0, 0));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("FIND");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, 60, -1));

        usertxt.setText("Username");
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
        jPanel1.add(usertxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 320, 40));

        oldpasstxt.setText("Old Password");
        oldpasstxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                oldpasstxtFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                oldpasstxtFocusLost(evt);
            }
        });
        jPanel1.add(oldpasstxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 320, 40));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-curved-arrow-20.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, 30, 30));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(399, 435));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtpassFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtpassFocusGained
        if (txtpass.getText().equals("Create New Password")) {
            txtpass.setText(null);
            txtpass.requestFocus();

            removePlaceorderStyle(txtpass);
        }
    }//GEN-LAST:event_txtpassFocusGained

    private void txtnewFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtnewFocusGained
        if (txtnew.getText().equals("Confirm Password")) {
            txtnew.setText(null);
            txtnew.requestFocus();

            txtnew.setEchoChar('•');

            removePlaceorderStyle(txtnew);
        }
    }//GEN-LAST:event_txtnewFocusGained

    private void txtpassFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtpassFocusLost
        if (txtpass.getText().length() == 0) {
            addPlaceorderStyle(txtpass);
            txtpass.setText("Create New Password");
        }
    }//GEN-LAST:event_txtpassFocusLost

    private void txtnewFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtnewFocusLost
        if (txtnew.getText().length() == 0) {
            addPlaceorderStyle(txtnew);
            txtnew.setText("Confirm Password");
            txtnew.setEchoChar('\u0000');

        }
    }//GEN-LAST:event_txtnewFocusLost

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
        if (usertxt.getText().equals("Username")) {
            usertxt.setText(null);
            usertxt.requestFocus();

            removePlaceorderStyle(usertxt);
        }
    }//GEN-LAST:event_usertxtFocusGained

    private void usertxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usertxtFocusLost
        if (usertxt.getText().length() == 0) {
            addPlaceorderStyle(usertxt);
            usertxt.setText("Username");
        }
    }//GEN-LAST:event_usertxtFocusLost

    private void oldpasstxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_oldpasstxtFocusGained
        if (oldpasstxt.getText().equals("Old Password")) {
            oldpasstxt.setText(null);
            oldpasstxt.requestFocus();

            removePlaceorderStyle(oldpasstxt);
        }

    }//GEN-LAST:event_oldpasstxtFocusGained

    private void oldpasstxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_oldpasstxtFocusLost
        if (oldpasstxt.getText().length() == 0) {
            addPlaceorderStyle(oldpasstxt);
            oldpasstxt.setText("Old Password");
        }
    }//GEN-LAST:event_oldpasstxtFocusLost

    private void txtnewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnewActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnewActionPerformed

    private void usertxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usertxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usertxtActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
          dispose();
        Login lg = new Login();
        lg.setVisible(true);
    }//GEN-LAST:event_jLabel4MouseClicked

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField oldpasstxt;
    private javax.swing.JPasswordField txtnew;
    private javax.swing.JTextField txtpass;
    private javax.swing.JTextField usertxt;
    // End of variables declaration//GEN-END:variables

}
