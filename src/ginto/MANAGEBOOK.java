
package ginto;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import  java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

public class MANAGEBOOK extends javax.swing.JInternalFrame {
    
    DefaultTableModel model;

    
    public MANAGEBOOK() {
        initComponents();
        Connect();
        table_update();
        setRecordsTable();
        
        
        this.setBorder(javax.swing.BorderFactory . createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI ui=(BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);
        setBackground(new Color(0,0,0,0));
        jTable1.getTableHeader().setFont(new Font("Century Gothic",Font.BOLD, 12));
        jTable1.getTableHeader().setOpaque(false);
        jTable1.getTableHeader().setBackground(new Color(19,22,40));
        jTable1.getTableHeader().setForeground(new Color(0,0,0));
        jTable1.setRowHeight(25);
      
    }
    
    Connection con;
    PreparedStatement pst;
    
    public void Connect()
     {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/data","root","");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MANAGEBOOK.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MANAGEBOOK.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
    private void table_update()
    {
        int CC;
        try {
            
            pst = con.prepareStatement("SELECT * FROM books");
            ResultSet Rs = pst.executeQuery();
            
            ResultSetMetaData RSMD = Rs.getMetaData();
            CC = RSMD.getColumnCount();
            DefaultTableModel DFT = (DefaultTableModel) jTable1.getModel();
            DFT.setRowCount(0);
            
            while (Rs.next()) {
                Vector v2 = new Vector();
                
                for (int ii = 1; ii <= CC; ii++) {
                  
                    v2.add(Rs.getString("bookid"));
                    v2.add(Rs.getString("bookname"));
                    v2.add(Rs.getString("bookauthor"));
                    v2.add(Rs.getString("genre"));
                    v2.add(Rs.getString("quantity"));
                }
           DFT.addRow(v2);
            }
        }catch (Exception e) {
            
            
        
    }
    }

    
    public void setRecordsTable() 
    {
        try {
            pst = con.prepareStatement("select * from books");
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()) {
                String BookID = rs.getString("Book_ID");
                String BookName = rs.getString("Book_Name");
                String BookAuthor = rs.getString("Book_Author");
                String Genre = rs.getString("Genre");
                String Quantity = rs.getString("Quantity");
                
                Object [] obj = {BookID,BookName,BookAuthor,Genre,Quantity};
                model =  (DefaultTableModel)jTable1.getModel();
                model.addRow(obj);
            }
        }catch (Exception e) {
            
    }
    }
    
    public void search(String str) {
        model = (DefaultTableModel) jTable1.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
        jTable1.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter("(?i)" + str));
    }
          public void filter(String str) {
           model = (DefaultTableModel) jTable1.getModel();
           TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
           jTable1.setRowSorter(trs);
           trs.setRowFilter(RowFilter.regexFilter(str));
    }
       
       
    
    
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtBookID = new javax.swing.JTextField();
        txtBookName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        txtBookAuthor = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtGenre = new javax.swing.JComboBox<>();
        addbutton = new javax.swing.JLabel();
        updatebutton = new javax.swing.JLabel();
        deletebutton = new javax.swing.JLabel();
        editbutton = new javax.swing.JLabel();
        txtremove = new javax.swing.JLabel();
        textadd = new javax.swing.JLabel();
        txtupdate = new javax.swing.JLabel();
        txtedit = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1186, 701));

        jPanel2.setBackground(new java.awt.Color(31, 25, 60));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Book ID");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Book Name");

        txtBookID.setBackground(new java.awt.Color(31, 25, 60));
        txtBookID.setForeground(new java.awt.Color(255, 255, 255));
        txtBookID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtBookID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBookIDActionPerformed(evt);
            }
        });

        txtBookName.setBackground(new java.awt.Color(31, 25, 60));
        txtBookName.setForeground(new java.awt.Color(255, 255, 255));
        txtBookName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Book Author");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Quantity");

        txtQuantity.setBackground(new java.awt.Color(31, 25, 60));
        txtQuantity.setForeground(new java.awt.Color(255, 255, 255));
        txtQuantity.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuantityActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Add a Book");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-books-90.png"))); // NOI18N

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-contact-28 (1).png"))); // NOI18N

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-collaborator-28 (1).png"))); // NOI18N

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-moleskine-28 (1).png"))); // NOI18N

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-unit-28 (1).png"))); // NOI18N

        jPanel11.setBackground(new java.awt.Color(31, 25, 60));

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setBackground(new java.awt.Color(255, 255, 255));
        jTable1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable1.setForeground(new java.awt.Color(0, 0, 0));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                " Book ID", "Book Name", "Book Author", "Genre", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setGridColor(new java.awt.Color(0, 0, 0));
        jTable1.setSelectionBackground(new java.awt.Color(153, 153, 153));
        jTable1.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jTable1.setShowGrid(true);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(80);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(80);
        }

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 40)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 204));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-book-50.png"))); // NOI18N
        jLabel15.setText("Manage Books");

        jPanel10.setBackground(new java.awt.Color(255, 255, 204));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 311, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        txtSearch.setBackground(new java.awt.Color(31, 25, 60));
        txtSearch.setForeground(new java.awt.Color(255, 255, 255));
        txtSearch.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 255, 255)));
        txtSearch.setCaretColor(new java.awt.Color(255, 255, 255));
        txtSearch.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtSearch.setDragEnabled(true);
        txtSearch.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        txtSearch.setSelectionColor(new java.awt.Color(60, 63, 65));
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/1w.png"))); // NOI18N

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "ABM", "HUMSS", "ICT", "General Reference", "Fiction", "Core Subject" }));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(282, 282, 282)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(350, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel16)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        txtBookAuthor.setBackground(new java.awt.Color(31, 25, 60));
        txtBookAuthor.setForeground(new java.awt.Color(255, 255, 255));
        txtBookAuthor.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(6, 637));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 702, Short.MAX_VALUE)
        );

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Genre");

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-book-28.png"))); // NOI18N

        txtGenre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "ABM", "HUMSS", "ICT", "General Reference", "Fiction", "Core Subject" }));
        txtGenre.setPreferredSize(new java.awt.Dimension(129, 35));

        addbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-add-48.png"))); // NOI18N
        addbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addbuttonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addbuttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addbuttonMouseExited(evt);
            }
        });

        updatebutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/PG-removebg-preview.png"))); // NOI18N
        updatebutton.setPreferredSize(new java.awt.Dimension(48, 48));
        updatebutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updatebuttonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                updatebuttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                updatebuttonMouseExited(evt);
            }
        });

        deletebutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-x-48.png"))); // NOI18N
        deletebutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deletebuttonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deletebuttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deletebuttonMouseExited(evt);
            }
        });

        editbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-pen-squared-48.png"))); // NOI18N
        editbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editbuttonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                editbuttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                editbuttonMouseExited(evt);
            }
        });

        txtremove.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        txtremove.setForeground(new java.awt.Color(255, 255, 255));
        txtremove.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtremove.setText("DELETE");

        textadd.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        textadd.setForeground(new java.awt.Color(255, 255, 255));
        textadd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textadd.setText("ADD");

        txtupdate.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        txtupdate.setForeground(new java.awt.Color(255, 255, 255));
        txtupdate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtupdate.setText("UPDATE");

        txtedit.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        txtedit.setForeground(new java.awt.Color(255, 255, 255));
        txtedit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtedit.setText("EDIT");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBookID, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                            .addComponent(txtBookName)
                            .addComponent(txtBookAuthor)
                            .addComponent(txtGenre, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtQuantity)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel4)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(addbutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(textadd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(editbutton)
                                            .addComponent(txtedit, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(deletebutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtremove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(updatebutton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBookID, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBookName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtBookAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(jLabel17))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtGenre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(106, 106, 106)))
                        .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel10))
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(editbutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(deletebutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(addbutton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textadd)
                            .addComponent(txtremove)
                            .addComponent(txtedit)
                            .addComponent(txtupdate)))
                    .addComponent(updatebutton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2123, 2123, 2123))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 702, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 2103, Short.MAX_VALUE))
        );

        updatebutton.setVisible(false);
        deletebutton.setVisible(false);
        txtremove.setVisible(false);
        textadd.setVisible(false);
        txtupdate.setVisible(false);
        txtedit.setVisible(false);

        getContentPane().add(jPanel2, java.awt.BorderLayout.LINE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
      
    

        
        jTable1.setFocusable(true);
       editbutton.setEnabled(true);
       deletebutton.setEnabled(true);
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void txtBookIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBookIDActionPerformed
        
    }//GEN-LAST:event_txtBookIDActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed

    }//GEN-LAST:event_txtSearchActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
           String searchString = txtSearch.getText();
        search(searchString);
    }//GEN-LAST:event_txtSearchKeyReleased

    private void txtQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantityActionPerformed
        
    }//GEN-LAST:event_txtQuantityActionPerformed

    private void updatebuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatebuttonMouseClicked
        
        int optionType = JOptionPane.YES_NO_OPTION;
          int result = JOptionPane.showConfirmDialog(null, "Are you sure?","Update Book", optionType);
          try { 
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();  
            String BookID,BookName,BookAuthor,Quantity,Genre;
            BookID = txtBookID.getText();
            BookName = txtBookName.getText();
            BookAuthor = txtBookAuthor.getText();
            Quantity = txtQuantity.getText();
            Genre = txtGenre.getSelectedItem().toString();
            
            if (result == JOptionPane.YES_OPTION) 
            pst = con.prepareStatement("update books set bookid = ?, bookname = ?,bookauthor = ?,genre = ?, quantity = ? where bookid = ?");            
            pst.setString (1, BookID);
            pst.setString (2, BookName);
            pst.setString (3, BookAuthor);
            pst.setString (4, Genre);
            pst.setString (5, Quantity);
            pst.setString (6, BookID);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Book Updated");
            table_update();
            txtBookID.setText("");
            txtBookName.setText("");
            txtBookAuthor.setText("");
            txtGenre.setSelectedIndex(0);
            txtQuantity.setText("");
            txtBookName.requestFocus();
            addbutton.setVisible(true);
            deletebutton.setVisible(true);
            editbutton.setVisible(true);
            updatebutton.setVisible(false);
            jTable1.clearSelection();
            
        }catch (SQLException ex) {
            Logger.getLogger(MANAGESTUDENT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_updatebuttonMouseClicked

    private void editbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editbuttonMouseClicked
        
         DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int selectedIndex = jTable1.getSelectedRow();
        
        txtBookID.setText(model.getValueAt(selectedIndex, 0).toString());
        txtBookName.setText(model.getValueAt(selectedIndex, 1).toString());
        txtBookAuthor.setText(model.getValueAt(selectedIndex, 2).toString());
        txtGenre.setSelectedItem(model.getValueAt(selectedIndex, 3).toString());
        txtQuantity.setText(model.getValueAt(selectedIndex, 4).toString());
        
        
        
        
        addbutton.setVisible(false);
        deletebutton.setVisible(true);
        editbutton.setVisible(true);
        updatebutton.setVisible(true);

    }//GEN-LAST:event_editbuttonMouseClicked

    private void addbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addbuttonMouseClicked
          try {
            String BookID,BookName,BookAuthor,Quantity,Genre;
            BookID = txtBookID.getText();
            BookName = txtBookName.getText();
            BookAuthor = txtBookAuthor.getText();
            Quantity = txtQuantity.getText();
            Genre = txtGenre.getSelectedItem().toString();
            pst = con.prepareStatement("insert into books (bookid,bookname,bookauthor,genre,quantity)values(?,?,?,?,?)");
            pst.setString(1, BookID);
            pst.setString(2, BookName);
            pst.setString(3, BookAuthor);
            pst.setString(4,Genre);
            pst.setString(5, Quantity);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Book Added");
            table_update();
            txtBookID.setText("");
            txtBookName.setText("");
            txtBookAuthor.setText("");
            txtGenre.setSelectedIndex(0);
            txtQuantity.setText("");
            txtBookName.requestFocus();
            int lastRow = jTable1.convertRowIndexToView(jTable1.getRowCount()- 1);
            jTable1.setRowSelectionInterval(lastRow, lastRow);
            Rectangle cellrect = jTable1.getCellRect (lastRow, 0, true);
            jTable1.scrollRectToVisible(cellrect);
        }catch (SQLException ex) {
            Logger.getLogger(MANAGEBOOK.class.getName()).log(Level.SEVERE, null, ex);

        }
    }//GEN-LAST:event_addbuttonMouseClicked

    private void deletebuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deletebuttonMouseClicked
         
            int optionType = JOptionPane.YES_NO_OPTION;
            int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to remove this book", "Delete", optionType);
            try {
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();         
            String BookID;
            BookID = txtBookID.getText();
            if (result == JOptionPane.YES_OPTION)      
            pst = con.prepareStatement("delete from books where bookid= ?");
            pst.setString(1, BookID);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Book Deleted");
            table_update();
            txtBookID.setText("");
            txtBookName.setText("");
            txtBookAuthor.setText("");
            txtGenre.setSelectedIndex(0);
            txtQuantity.setText("");
      
        }catch (SQLException ex) {
            Logger.getLogger(MANAGEBOOK.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_deletebuttonMouseClicked

    private void addbuttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addbuttonMouseEntered
        textadd.setVisible(true);
    }//GEN-LAST:event_addbuttonMouseEntered

    private void addbuttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addbuttonMouseExited
       textadd.setVisible(false);
    }//GEN-LAST:event_addbuttonMouseExited

    private void deletebuttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deletebuttonMouseEntered
        txtremove.setVisible(true);
    }//GEN-LAST:event_deletebuttonMouseEntered

    private void deletebuttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deletebuttonMouseExited
        txtremove.setVisible(false);
    }//GEN-LAST:event_deletebuttonMouseExited

    private void updatebuttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatebuttonMouseEntered
         txtupdate.setVisible(true);
    }//GEN-LAST:event_updatebuttonMouseEntered

    private void updatebuttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatebuttonMouseExited
        txtupdate.setVisible(false);
    }//GEN-LAST:event_updatebuttonMouseExited

    private void editbuttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editbuttonMouseEntered
        txtedit.setVisible(true);
    }//GEN-LAST:event_editbuttonMouseEntered

    private void editbuttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editbuttonMouseExited
         txtedit.setVisible(false);
    }//GEN-LAST:event_editbuttonMouseExited

   
   

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addbutton;
    private javax.swing.JLabel deletebutton;
    private javax.swing.JLabel editbutton;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel textadd;
    private javax.swing.JTextField txtBookAuthor;
    private javax.swing.JTextField txtBookID;
    private javax.swing.JTextField txtBookName;
    private javax.swing.JComboBox<String> txtGenre;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JLabel txtedit;
    private javax.swing.JLabel txtremove;
    private javax.swing.JLabel txtupdate;
    private javax.swing.JLabel updatebutton;
    // End of variables declaration//GEN-END:variables
}
