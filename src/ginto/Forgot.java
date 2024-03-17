
package ginto;



import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;

public class Forgot extends javax.swing.JFrame {

    /**
     * Creates new form Forgot
     */
    public Forgot() {
        initComponents();
        addPlaceorderStyle(txtpass);
        removePlaceorderStyle(txtnew);
    }
    
    public void addPlaceorderStyle(JTextField textield){
        Font font = txtpass.getFont();
        font = font.deriveFont(Font.ITALIC);
        txtpass.setFont(font);
        txtnew.setForeground(Color.gray); //font color
    }
     public void removePlaceorderStyle(JTextField textfield){
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(400, 350));

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

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(416, 415));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtpassFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtpassFocusGained
        if(txtpass.getText().equals("Create New Password")){
            txtpass.setText(null);
            txtpass.requestFocus();
            
            removePlaceorderStyle(txtpass);
        }
    }//GEN-LAST:event_txtpassFocusGained

    private void txtnewFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtnewFocusGained
         if(txtnew.getText().equals("Confirm Password")){
            txtnew.setText(null);
            txtnew.requestFocus();
            
            txtnew.setEchoChar('@');
            
             removePlaceorderStyle(txtnew);
        }
    }//GEN-LAST:event_txtnewFocusGained

    private void txtpassFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtpassFocusLost
       if(txtpass.getText().length()==0){
          addPlaceorderStyle(txtpass);
          txtpass.setText("Create New Password");
       }
    }//GEN-LAST:event_txtpassFocusLost

    private void txtnewFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtnewFocusLost
       if(txtnew.getText().length()==0){
           addPlaceorderStyle(txtnew);
           txtnew.setText("Confirm Password");
           txtnew.setEchoChar('\u0000');

       }
    }//GEN-LAST:event_txtnewFocusLost

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField txtnew;
    private javax.swing.JTextField txtpass;
    // End of variables declaration//GEN-END:variables

 
   
}
