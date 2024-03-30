package ginto;



import  java.sql.*;
import java.awt.Color;
import java.awt.Font;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;




public class TRANSACTION extends javax.swing.JInternalFrame {

   
    public TRANSACTION() {
        initComponents();
        Connect();
        transactiontableupdate();
        setRecordsTable();

        
       this.setBorder(javax.swing.BorderFactory . createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI ui=(BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);
        setBackground(new Color(0,0,0,0));
        transactiontable.getTableHeader().setFont(new Font("Century Gothic",Font.BOLD, 12));
        transactiontable.getTableHeader().setOpaque(false);
        transactiontable.getTableHeader().setBackground(new Color(19,22,40));
        transactiontable.getTableHeader().setForeground(new Color(0,0,0));
        transactiontable.setRowHeight(25);       

    }
    
    DefaultTableModel model;
    Connection con;
    PreparedStatement pst;
    
    
    
   
    
    
    
    
    
     public void Connect()
     {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/data","root","");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TRANSACTION.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TRANSACTION.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     public void transactiontableupdate()
    {
        int CC;
        try {
            
            pst = con.prepareStatement("SELECT * FROM issue");
            ResultSet Rs = pst.executeQuery();
            
            ResultSetMetaData RSMD = Rs.getMetaData();
            CC = RSMD.getColumnCount();
            DefaultTableModel DFT = (DefaultTableModel) transactiontable.getModel();
            DFT.setRowCount(0);
            
            while (Rs.next()) {
                Vector v2 = new Vector();
                
                for (int ii = 1; ii <= CC; ii++) {
                  
                    v2.add(Rs.getString("Student_ID"));
                    v2.add(Rs.getString("Student_Name"));
                    v2.add(Rs.getString("Strand"));
                    v2.add(Rs.getString("Grade_Section"));
                    v2.add(Rs.getString("Book_ID"));
                    v2.add(Rs.getString("Book_Name"));
                    v2.add(Rs.getString("Book_Author"));
                    v2.add(Rs.getString("Genre"));
                    v2.add(Rs.getString("Book_Quantity"));
                    v2.add(Rs.getString("Issue_Date"));
                    v2.add(Rs.getString("Due_Date"));
                    v2.add(Rs.getString("Date_Return"));
                    v2.add(Rs.getString("Status"));
                    
                    
                }
           DFT.addRow(v2);
            }
        }catch (Exception e) {
            
            
        
    }
    }
    
     
    public void search(String str) {
        model = (DefaultTableModel) transactiontable.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
        transactiontable.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter("(?i)" + str));
    }
      public void filter(String str) {
           model = (DefaultTableModel) transactiontable.getModel();
           TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
           transactiontable.setRowSorter(trs);
           trs.setRowFilter(RowFilter.regexFilter(str));
           }
    
    
           public void setRecordsTable() 
    {
        try {
            pst = con.prepareStatement("select * from issue");
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()) {
                String StudentID = rs.getString("Student_ID");
                String StudentName = rs.getString("Student_Name");
                String BookID = rs.getString("Book_ID");
                String BookName = rs.getString("Book_Name");
                String BookAuthor = rs.getString("Book_Author");
                
                
                Object [] obj = {StudentID,StudentName,BookID,BookName,BookAuthor};
                model =  (DefaultTableModel)transactiontable.getModel();
                model.addRow(obj);
            }
        }catch (Exception e) {
            
    }
    }
                   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        transactiontable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1186, 701));

        jPanel2.setBackground(new java.awt.Color(31, 25, 60));
        jPanel2.setPreferredSize(new java.awt.Dimension(1178, 701));

        transactiontable.setAutoCreateRowSorter(true);
        transactiontable.setBackground(new java.awt.Color(255, 255, 255));
        transactiontable.setForeground(new java.awt.Color(0, 0, 0));
        transactiontable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Student Name", "Strand", "Gr. & Sec.", "Book ID", "Book Name", "Author", "Genre", "Quantity", "Issue Date", "Due Date", "Date Return", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        transactiontable.setGridColor(new java.awt.Color(0, 0, 0));
        transactiontable.setSelectionBackground(new java.awt.Color(153, 153, 153));
        transactiontable.setSelectionForeground(new java.awt.Color(0, 0, 0));
        transactiontable.setShowGrid(true);
        transactiontable.getTableHeader().setResizingAllowed(false);
        transactiontable.getTableHeader().setReorderingAllowed(false);
        transactiontable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                transactiontableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(transactiontable);
        if (transactiontable.getColumnModel().getColumnCount() > 0) {
            transactiontable.getColumnModel().getColumn(0).setResizable(false);
            transactiontable.getColumnModel().getColumn(0).setPreferredWidth(0);
            transactiontable.getColumnModel().getColumn(1).setResizable(false);
            transactiontable.getColumnModel().getColumn(1).setPreferredWidth(170);
            transactiontable.getColumnModel().getColumn(2).setResizable(false);
            transactiontable.getColumnModel().getColumn(3).setResizable(false);
            transactiontable.getColumnModel().getColumn(3).setPreferredWidth(0);
            transactiontable.getColumnModel().getColumn(4).setResizable(false);
            transactiontable.getColumnModel().getColumn(4).setPreferredWidth(0);
            transactiontable.getColumnModel().getColumn(5).setResizable(false);
            transactiontable.getColumnModel().getColumn(6).setResizable(false);
            transactiontable.getColumnModel().getColumn(6).setPreferredWidth(120);
            transactiontable.getColumnModel().getColumn(7).setResizable(false);
            transactiontable.getColumnModel().getColumn(8).setResizable(false);
            transactiontable.getColumnModel().getColumn(8).setPreferredWidth(60);
            transactiontable.getColumnModel().getColumn(9).setResizable(false);
            transactiontable.getColumnModel().getColumn(9).setPreferredWidth(90);
            transactiontable.getColumnModel().getColumn(10).setResizable(false);
            transactiontable.getColumnModel().getColumn(10).setPreferredWidth(90);
            transactiontable.getColumnModel().getColumn(11).setResizable(false);
            transactiontable.getColumnModel().getColumn(11).setPreferredWidth(90);
            transactiontable.getColumnModel().getColumn(12).setResizable(false);
            transactiontable.getColumnModel().getColumn(12).setPreferredWidth(50);
        }

        jButton1.setBackground(new java.awt.Color(255, 0, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("ISSUE BOOK");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField1.setBackground(new java.awt.Color(31, 25, 60));
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 255, 255)));
        jTextField1.setSelectionColor(new java.awt.Color(255, 255, 255));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/1w.png"))); // NOI18N

        jButton2.setBackground(new java.awt.Color(255, 0, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("RETURN BOOK");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "JOBS", "GATES", "ROBERTS", "DELL" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton3.setText("REFRESH");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89)
                        .addComponent(jButton3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(247, 247, 247)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(105, 105, 105)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        IssueBook ib = new IssueBook();
        ib.setVisible(true);
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        
        
    }//GEN-LAST:event_jButton1MouseClicked

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed

    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        String searchString = jTextField1.getText();
        search(searchString);
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        ReturnBook rb = new ReturnBook();
        rb.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void transactiontableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transactiontableMouseClicked
             
    }//GEN-LAST:event_transactiontableMouseClicked

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        String filterString = jComboBox1.getSelectedItem().toString();
        filter(filterString);
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       transactiontableupdate();
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable transactiontable;
    // End of variables declaration//GEN-END:variables
}
