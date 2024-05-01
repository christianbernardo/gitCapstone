package ginto;

import ginto.BOARD;
import ginto.Forgot;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Login extends javax.swing.JFrame {

    public Login() {
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
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addPlaceorderStyle(JTextField textield) {
        Font font = nametxt.getFont();
        font = font.deriveFont(Font.PLAIN);
        nametxt.setFont(font);
        passtxt.setForeground(Color.gray); //font color

    }

    public void removePlaceorderStyle(JTextField textfield) {
        Font font = passtxt.getFont();
        font = font.deriveFont(Font.PLAIN);
        nametxt.setFont(font);
        passtxt.setForeground(Color.black);
    }

    public void close() {
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
        jLabel3 = new javax.swing.JLabel();
        nametxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        passtxt = new javax.swing.JPasswordField();
        b1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Change = new javax.swing.JLabel();
        hide = new javax.swing.JPanel();
        hide6 = new javax.swing.JLabel();
        exs = new javax.swing.JPanel();
        ex6 = new javax.swing.JLabel();
        newaccount = new javax.swing.JLabel();
        w1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

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
        jCheckBox1.setBounds(740, 230, 20, 20);

        jLabel4.setFont(new java.awt.Font("Microsoft PhagsPa", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Username");
        Rigth.add(jLabel4);
        jLabel4.setBounds(450, 130, 52, 16);

        jLabel5.setFont(new java.awt.Font("Microsoft PhagsPa", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Password");
        Rigth.add(jLabel5);
        jLabel5.setBounds(450, 200, 50, 16);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-user-32.png"))); // NOI18N
        Rigth.add(jLabel3);
        jLabel3.setBounds(410, 150, 32, 30);

        nametxt.setBackground(new java.awt.Color(0, 0, 51));
        nametxt.setFont(new java.awt.Font("Microsoft PhagsPa", 0, 12)); // NOI18N
        nametxt.setForeground(new java.awt.Color(255, 255, 255));
        nametxt.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        nametxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nametxtFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                nametxtFocusLost(evt);
            }
        });
        nametxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nametxtActionPerformed(evt);
            }
        });
        Rigth.add(nametxt);
        nametxt.setBounds(450, 160, 310, 30);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-lock-32.png"))); // NOI18N
        Rigth.add(jLabel8);
        jLabel8.setBounds(410, 220, 30, 32);

        passtxt.setBackground(new java.awt.Color(0, 0, 51));
        passtxt.setFont(new java.awt.Font("Microsoft PhagsPa", 0, 12)); // NOI18N
        passtxt.setForeground(new java.awt.Color(255, 255, 255));
        passtxt.setAutoscrolls(false);
        passtxt.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        passtxt.setDoubleBuffered(true);
        passtxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passtxtFocusGained(evt);
            }
        });
        passtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passtxtActionPerformed(evt);
            }
        });
        passtxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passtxtKeyPressed(evt);
            }
        });
        Rigth.add(passtxt);
        passtxt.setBounds(450, 230, 310, 30);

        b1.setBackground(new java.awt.Color(255, 255, 255));
        b1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        b1.setForeground(new java.awt.Color(0, 0, 0));
        b1.setText("Login");
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
        b1.setBounds(560, 300, 100, 30);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Welcome!");
        Rigth.add(jLabel1);
        jLabel1.setBounds(100, 30, 250, 70);

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("SIGN IN");
        Rigth.add(jLabel2);
        jLabel2.setBounds(560, 90, 70, 24);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 45)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("LIBRARY MANAGEMENT SYSTEM");
        Rigth.add(jLabel6);
        jLabel6.setBounds(30, 410, 750, 60);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/gr-removebg-preview.png"))); // NOI18N
        Rigth.add(jLabel7);
        jLabel7.setBounds(90, 100, 250, 280);

        Change.setForeground(new java.awt.Color(255, 255, 255));
        Change.setText("Forgot Password");
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
        Change.setBounds(670, 270, 110, 16);

        hide.setBackground(new java.awt.Color(0, 0, 51));
        hide.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        hide6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-minus-30.png"))); // NOI18N
        hide6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hide6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                hide6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                hide6MouseExited(evt);
            }
        });
        hide.add(hide6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 30));

        Rigth.add(hide);
        hide.setBounds(730, 10, 30, 30);

        exs.setBackground(new java.awt.Color(0, 0, 51));
        exs.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ex6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-x-30.png"))); // NOI18N
        ex6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ex6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ex6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ex6MouseExited(evt);
            }
        });
        exs.add(ex6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 30));

        Rigth.add(exs);
        exs.setBounds(760, 10, 30, 30);

        newaccount.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        newaccount.setForeground(new java.awt.Color(255, 255, 255));
        newaccount.setText("Sign up");
        newaccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                newaccountMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                newaccountMouseEntered(evt);
            }
        });
        newaccount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                newaccountKeyPressed(evt);
            }
        });
        Rigth.add(newaccount);
        newaccount.setBounds(590, 340, 50, 20);

        w1.setBackground(new java.awt.Color(0, 0, 51));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-circled-i-20.png"))); // NOI18N
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel9MouseExited(evt);
            }
        });

        javax.swing.GroupLayout w1Layout = new javax.swing.GroupLayout(w1);
        w1.setLayout(w1Layout);
        w1Layout.setHorizontalGroup(
            w1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, w1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel9))
        );
        w1Layout.setVerticalGroup(
            w1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, w1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel9))
        );

        Rigth.add(w1);
        w1.setBounds(10, 10, 20, 20);

        jPanel2.setBackground(new java.awt.Color(0, 0, 51));
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 780, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        Rigth.add(jPanel2);
        jPanel2.setBounds(10, 10, 780, 30);

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
      public void mini(JPanel a) {
        a.setBackground(new Color(153, 153, 153));
    }

    public void close(JPanel a1) {
        a1.setBackground(new Color(0, 0, 51));
    }

    public void hide(JPanel a2) {
        a2.setBackground(new Color(204, 0, 0));
    }

    public void ex(JPanel a3) {
        a3.setBackground(new Color(0, 0, 51));
    }


    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1ActionPerformed
        String username, password;

        username = nametxt.getText();
        password = passtxt.getText();

        try {
            pst = con.prepareStatement("select * from account where username=? and password =?");
            pst.setString(1, username);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                close();
                BOARD bd = new BOARD();
                bd.setVisible(true);
            } else if (nametxt.getText().equals("") && passtxt.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Please input user and pass");
            } else if (nametxt.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Please input username");
            } else if (passtxt.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Please input password");
            } else if (!nametxt.getText().equals("") && !passtxt.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "invalid user or pass");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_b1ActionPerformed

    private void passtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passtxtActionPerformed

    }//GEN-LAST:event_passtxtActionPerformed

    private void nametxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nametxtActionPerformed

    }//GEN-LAST:event_nametxtActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if (jCheckBox1.isSelected()) {
            passtxt.setEchoChar((char) 0);
        } else {
            passtxt.setEchoChar('*');
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void passtxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passtxtKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            String username, password;

            username = nametxt.getText();
            password = passtxt.getText();

            try {
                pst = con.prepareStatement("select * from account where username=? and password=?");
                pst.setString(1, username);
                pst.setString(2, password);
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    close();
                    BOARD bd = new BOARD();
                    bd.setVisible(true);
                } else if (nametxt.getText().equals("") && passtxt.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please input user and pass");
                } else if (nametxt.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please input username");
                } else if (passtxt.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please input password");
                } else if (!nametxt.getText().equals("") && !passtxt.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "invalid user or pass");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }//GEN-LAST:event_passtxtKeyPressed

    private void b1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_b1KeyPressed

    }//GEN-LAST:event_b1KeyPressed

    private void ChangeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ChangeKeyPressed


    }//GEN-LAST:event_ChangeKeyPressed

    private void ChangeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ChangeMouseClicked
        dispose();
        Forgot forgot = new Forgot();
        forgot.setVisible(true);
    }//GEN-LAST:event_ChangeMouseClicked

    private void nametxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nametxtFocusGained

    }//GEN-LAST:event_nametxtFocusGained

    private void nametxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nametxtFocusLost

    }//GEN-LAST:event_nametxtFocusLost

    private void passtxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passtxtFocusGained

    }//GEN-LAST:event_passtxtFocusGained

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        JOptionPane.showMessageDialog(this, "Group 4\nAropo,Kristine Jane\nBernardo,Christian\nCastro,Mark Ivan\nCastro,Raphael Luis\nCruz,Alden Euan Raine\nGalvez,Mitchie\nGarcia,Kyron Lee\nLacson,Tiffany Mae\nPerlas,Angelo");
    }//GEN-LAST:event_jLabel9MouseClicked

    private void hide6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hide6MouseClicked
        this.setExtendedState(BOARD.ICONIFIED);
    }//GEN-LAST:event_hide6MouseClicked

    private void ex6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ex6MouseClicked
        dispose();
    }//GEN-LAST:event_ex6MouseClicked

    private void hide6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hide6MouseEntered
        mini(hide);
    }//GEN-LAST:event_hide6MouseEntered

    private void hide6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hide6MouseExited
        close(hide);
    }//GEN-LAST:event_hide6MouseExited

    private void ex6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ex6MouseEntered
        hide(exs);
    }//GEN-LAST:event_ex6MouseEntered

    private void ex6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ex6MouseExited
        ex(exs);
    }//GEN-LAST:event_ex6MouseExited

    private void newaccountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newaccountMouseClicked
        dispose();
        NewAccount newaccount = new NewAccount();
        newaccount.setVisible(true);
    }//GEN-LAST:event_newaccountMouseClicked

    private void newaccountKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_newaccountKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_newaccountKeyPressed

    private void newaccountMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newaccountMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_newaccountMouseEntered

    private void jLabel9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseEntered
        mini(w1);
    }//GEN-LAST:event_jLabel9MouseEntered

    private void jLabel9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseExited
        close(w1);
    }//GEN-LAST:event_jLabel9MouseExited

    private int xMouse, yMouse;
    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_jPanel2MousePressed

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_jPanel2MouseDragged

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
    private javax.swing.JLabel ex6;
    private javax.swing.JPanel exs;
    private javax.swing.JPanel hide;
    private javax.swing.JLabel hide6;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField nametxt;
    private javax.swing.JLabel newaccount;
    private javax.swing.JPasswordField passtxt;
    private javax.swing.JPanel w1;
    // End of variables declaration//GEN-END:variables
}
