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
            Logger.getLogger(MANAGESTUDENT.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MANAGESTUDENT.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void addPlaceorderStyle(JTextField textield) {
        Font font = txtpass.getFont();
        font = font.deriveFont(Font.ITALIC);
        txtpass.setFont(font);
        txtnew.setForeground(Color.gray); //font color
    }

    public void removePlaceorderStyle(JTextField textfield) {
        Font font = txtnew.getFont();
        font = font.deriveFont(Font.PLAIN);
        txtpass.setFont(font);
        txtnew.setForeground(Color.black);
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
        usertxt = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        oldpasstxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));
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
        jPanel1.add(txtpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 320, 40));

        jButton1.setBackground(new java.awt.Color(0, 0, 153));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setText("Change");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 320, 40));

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
        jPanel1.add(txtnew, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 192, 320, 40));
        jPanel1.add(usertxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 90, 110, -1));

        jButton2.setText("FIND");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 90, -1, -1));
        jPanel1.add(oldpasstxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 140, 110, -1));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(989, 415));
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

            txtnew.setEchoChar('@');

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
                String add1 = Rs.getString("password");
                oldpasstxt.setText(add1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String user, newpass, confirmpass;
        user = usertxt.getText();
        newpass = txtpass.getText();
        confirmpass = txtnew.getText();

        if (newpass.equals("")) {
            JOptionPane.showMessageDialog(null, "Input Password");

        } else if (newpass.equals("") && !confirmpass.equals("")) {
            JOptionPane.showMessageDialog(null, "Incorrect Password");
        } else {
            try {
                pst = con.prepareStatement("update account set password = ? where username = ? ");
                pst.setString(1, confirmpass);
                pst.setString(2, user);
                pst.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField oldpasstxt;
    private javax.swing.JPasswordField txtnew;
    private javax.swing.JTextField txtpass;
    private javax.swing.JTextField usertxt;
    // End of variables declaration//GEN-END:variables

}
