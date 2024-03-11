
package ginto;


import java.sql.*;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class IssueBook extends javax.swing.JFrame {

    
    public IssueBook() {
        initComponents();
        Connect();
    }
    
    Connection con;
    PreparedStatement pst;
    ResultSet Rs;
    
    public void Connect()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/data","root","");
        }catch (ClassNotFoundException ex) {
            Logger.getLogger(IssueBook.class.getName()).log(Level.SEVERE, null, ex);
        }catch (SQLException ex) {
            Logger.getLogger(IssueBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        A4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        Search = new javax.swing.JButton();
        txtStudentID = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtStudentName = new javax.swing.JTextField();
        txtGrSec = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        Search2 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtBookID = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtBookName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtAuthor = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        jPanel14 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        issuebook = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        txtIssueDate = new com.toedter.calendar.JDateChooser();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        A4.setBackground(new java.awt.Color(255, 255, 255));
        A4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(102, 102, 102)));
        A4.setForeground(new java.awt.Color(255, 255, 255));
        A4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1020, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        A4.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 10));

        jTabbedPane1.setBackground(new java.awt.Color(102, 102, 102));
        jTabbedPane1.setForeground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jPanel3.setBackground(new java.awt.Color(0, 0, 51));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(102, 102, 102)));
        jPanel3.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-student-registration-85.png"))); // NOI18N
        jLabel2.setText("Student Details");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(62, 56, 208, 85);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setForeground(new java.awt.Color(255, 255, 255));
        jPanel7.setPreferredSize(new java.awt.Dimension(0, 5));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 259, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel7);
        jPanel7.setBounds(37, 159, 259, 8);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Student ID :");
        jPanel3.add(jLabel8);
        jLabel8.setBounds(10, 260, 67, 16);

        Search.setBackground(new java.awt.Color(255, 0, 0));
        Search.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Search.setForeground(new java.awt.Color(255, 255, 255));
        Search.setText("Search");
        Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchActionPerformed(evt);
            }
        });
        jPanel3.add(Search);
        Search.setBounds(240, 280, 72, 23);

        txtStudentID.setBackground(new java.awt.Color(0, 0, 51));
        txtStudentID.setForeground(new java.awt.Color(255, 255, 255));
        txtStudentID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtStudentID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStudentIDActionPerformed(evt);
            }
        });
        jPanel3.add(txtStudentID);
        txtStudentID.setBounds(10, 280, 310, 36);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Student Name :");
        jPanel3.add(jLabel9);
        jLabel9.setBounds(10, 330, 87, 16);

        txtStudentName.setBackground(new java.awt.Color(0, 0, 51));
        txtStudentName.setForeground(new java.awt.Color(255, 255, 255));
        txtStudentName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtStudentName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStudentNameActionPerformed(evt);
            }
        });
        jPanel3.add(txtStudentName);
        txtStudentName.setBounds(10, 350, 310, 35);

        txtGrSec.setBackground(new java.awt.Color(0, 0, 51));
        txtGrSec.setForeground(new java.awt.Color(255, 255, 255));
        txtGrSec.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtGrSec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGrSecActionPerformed(evt);
            }
        });
        jPanel3.add(txtGrSec);
        txtGrSec.setBounds(10, 420, 310, 35);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Gr. & Sec.  :");
        jPanel3.add(jLabel11);
        jLabel11.setBounds(10, 400, 65, 16);

        jPanel15.setBackground(new java.awt.Color(0, 0, 51));
        jPanel15.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(102, 102, 102)));
        jPanel15.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-details-85.png"))); // NOI18N
        jLabel3.setText("Book Details");
        jPanel15.add(jLabel3);
        jLabel3.setBounds(68, 57, 187, 85);

        Search2.setBackground(new java.awt.Color(255, 0, 0));
        Search2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Search2.setForeground(new java.awt.Color(255, 255, 255));
        Search2.setText("Search");
        Search2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Search1ActionPerformed(evt);
            }
        });
        jPanel15.add(Search2);
        Search2.setBounds(240, 280, 72, 23);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setForeground(new java.awt.Color(255, 255, 255));
        jPanel12.setPreferredSize(new java.awt.Dimension(0, 5));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 259, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        jPanel15.add(jPanel12);
        jPanel12.setBounds(33, 160, 259, 8);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Book ID :");
        jPanel15.add(jLabel4);
        jLabel4.setBounds(10, 260, 51, 16);

        txtBookID.setBackground(new java.awt.Color(0, 0, 51));
        txtBookID.setForeground(new java.awt.Color(255, 255, 255));
        txtBookID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtBookID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBookIDActionPerformed(evt);
            }
        });
        jPanel15.add(txtBookID);
        txtBookID.setBounds(10, 280, 310, 35);

        jLabel5.setBackground(new java.awt.Color(153, 153, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Book Name :");
        jPanel15.add(jLabel5);
        jLabel5.setBounds(10, 330, 71, 16);

        txtBookName.setBackground(new java.awt.Color(0, 0, 51));
        txtBookName.setForeground(new java.awt.Color(255, 255, 255));
        txtBookName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtBookName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBookNameActionPerformed(evt);
            }
        });
        jPanel15.add(txtBookName);
        txtBookName.setBounds(10, 350, 310, 35);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Author :");
        jPanel15.add(jLabel6);
        jLabel6.setBounds(10, 390, 45, 16);

        txtAuthor.setBackground(new java.awt.Color(0, 0, 51));
        txtAuthor.setForeground(new java.awt.Color(255, 255, 255));
        txtAuthor.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAuthorActionPerformed(evt);
            }
        });
        jPanel15.add(txtAuthor);
        txtAuthor.setBounds(10, 420, 310, 35);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Quantity :");
        jPanel15.add(jLabel7);
        jLabel7.setBounds(10, 460, 54, 16);

        txtQuantity.setBackground(new java.awt.Color(0, 0, 51));
        txtQuantity.setForeground(new java.awt.Color(255, 255, 255));
        txtQuantity.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuantityActionPerformed(evt);
            }
        });
        jPanel15.add(txtQuantity);
        txtQuantity.setBounds(10, 490, 310, 35);

        jPanel3.add(jPanel15);
        jPanel15.setBounds(340, 0, 350, 590);

        jPanel14.setBackground(new java.awt.Color(0, 0, 51));
        jPanel14.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 0, 4, 0, new java.awt.Color(102, 102, 102)));

        jLabel18.setBackground(new java.awt.Color(0, 0, 102));
        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-books-50 (1).png"))); // NOI18N
        jLabel18.setText("Issue Book");

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setForeground(new java.awt.Color(255, 255, 255));
        jPanel13.setPreferredSize(new java.awt.Dimension(0, 5));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 259, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        jLabel14.setBackground(new java.awt.Color(0, 0, 102));
        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Issue Date :");

        issuebook.setBackground(new java.awt.Color(255, 0, 0));
        issuebook.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        issuebook.setForeground(new java.awt.Color(255, 255, 255));
        issuebook.setText("ISSUE BOOK");
        issuebook.setBorder(null);
        issuebook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                issuebookActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(204, 0, 0));
        jButton3.setForeground(new java.awt.Color(0, 0, 0));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/2.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addGap(0, 25, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(96, 96, 96))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(issuebook, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIssueDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(jLabel18)
                .addGap(18, 18, 18)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIssueDate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91)
                .addComponent(issuebook, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(122, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel14);
        jPanel14.setBounds(690, 0, 320, 590);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1020, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab(" DETAILS", jPanel1);

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setBackground(new java.awt.Color(255, 255, 255));
        jTable1.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(0, 0, 0)));
        jTable1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable1.setForeground(new java.awt.Color(0, 0, 0));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "                                   Student Name", "Strand", "Gr. & Sec."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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
                jTable1jTable1MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1020, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("STUDENT", jPanel5);

        jTable2.setAutoCreateRowSorter(true);
        jTable2.setBackground(new java.awt.Color(255, 255, 255));
        jTable2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable2.setForeground(new java.awt.Color(0, 0, 0));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                " Book ID", "                                   Book Name", "                                   Book Author", "Genre", " Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setGridColor(new java.awt.Color(0, 0, 0));
        jTable2.setSelectionBackground(new java.awt.Color(153, 153, 153));
        jTable2.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jTable2.setShowGrid(true);
        jTable2.getTableHeader().setReorderingAllowed(false);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 1020, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 593, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("BOOK", jPanel6);

        A4.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -3, 1020, 680));

        getContentPane().add(A4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 620));

        setSize(new java.awt.Dimension(1020, 621));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchActionPerformed
        
        jTabbedPane1.setSelectedIndex(1);

    }//GEN-LAST:event_SearchActionPerformed

    private void txtStudentIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStudentIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStudentIDActionPerformed

    private void txtStudentNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStudentNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStudentNameActionPerformed

    private void txtGrSecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGrSecActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGrSecActionPerformed

    private void issuebookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_issuebookActionPerformed
        String sql= "insert into issue(Student_ID,Student_Name,Grade_Section,Book_ID,Book_Name,Book_Author,Book_Quantity,Issue_Date)values (?,?,?,?,?,?,?,?)";
        try{
            pst= con.prepareStatement(sql);
            pst.setString(1, txtStudentID.getText());
            pst.setString(2, txtStudentName.getText());
            pst.setString(3, txtGrSec.getText());
            pst.setString(4, txtBookID.getText());
            pst.setString(5, txtBookName.getText());
            pst.setString(6, txtAuthor.getText());
            pst.setString(7, txtQuantity.getText());
            pst.setString(8, ((JTextField)txtIssueDate.getDateEditor().getUiComponent()).getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Book Issued");
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_issuebookActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable1jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1jTable1MouseClicked

        jTable1.setFocusable(true);
        jLabel14.setEnabled(true);
       

    }//GEN-LAST:event_jTable1jTable1MouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        int selectedIndex = jTable2.getSelectedRow();
        txtBookID.setText(model.getValueAt(selectedIndex, 0).toString());
        txtBookName.setText(model.getValueAt(selectedIndex, 1).toString());
        txtAuthor.setText(model.getValueAt(selectedIndex, 2).toString());
        txtQuantity.setText(model.getValueAt(selectedIndex, 3).toString());

    }//GEN-LAST:event_jTable2MouseClicked

    private void txtQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuantityActionPerformed

    private void txtAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAuthorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAuthorActionPerformed

    private void txtBookNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBookNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBookNameActionPerformed

    private void txtBookIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBookIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBookIDActionPerformed

    private void Search1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Search1ActionPerformed
        String sql = ("SELECT * FROM books where bookid=?");
        try {
            /* pst = con.prepareStatement(sql);
            pst.setString(1, txtBookID.getText());
            Rs= pst.executeQuery();
            if(Rs.next()) {
                String add1=Rs.getString("bookname");
                txtBookName.setText(add1);
                String add2=Rs.getString("bookauthor");
                txtAuthor.setText(add2);
                String add3=Rs.getString("quantity");
                txtQuantity.setText(add3);
                Rs.close();
                pst.close();*/
                 jTabbedPane1.setSelectedIndex(2); {
                }
                /*else {
                    JOptionPane.showMessageDialog(null, "Book ID not found");
                }*/

            }catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }finally {
                try{
                    Rs.close();
                    pst.close();
                }catch (SQLException ex) {
                    Logger.getLogger(IssueBook.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
    }//GEN-LAST:event_Search1ActionPerformed

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
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IssueBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel A4;
    private javax.swing.JButton Search;
    private javax.swing.JButton Search2;
    private javax.swing.JButton issuebook;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField txtAuthor;
    private javax.swing.JTextField txtBookID;
    private javax.swing.JTextField txtBookName;
    private javax.swing.JTextField txtGrSec;
    private com.toedter.calendar.JDateChooser txtIssueDate;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtStudentID;
    private javax.swing.JTextField txtStudentName;
    // End of variables declaration//GEN-END:variables
}
