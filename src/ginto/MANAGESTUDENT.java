
package ginto;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import  java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;


public class MANAGESTUDENT extends javax.swing.JInternalFrame {

    DefaultTableModel model;

    
    public MANAGESTUDENT() {
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
            Logger.getLogger(MANAGESTUDENT.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MANAGESTUDENT.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
       
    private void table_update()
    {
        int CC;
        try {
            
            pst = con.prepareStatement("SELECT * FROM students");
            ResultSet Rs = pst.executeQuery();
            
            ResultSetMetaData RSMD = Rs.getMetaData();
            CC = RSMD.getColumnCount();
            DefaultTableModel DFT = (DefaultTableModel) jTable1.getModel();
            DFT.setRowCount(0);
            
            while (Rs.next()) {
                Vector v2 = new Vector();
                
                for (int ii = 1; ii <= CC; ii++) {
                  
                    v2.add(Rs.getString("studentid"));
                    v2.add(Rs.getString("studentname"));
                    v2.add(Rs.getString("strand"));
                    v2.add(Rs.getString("gradeandsection"));
                }
           DFT.addRow(v2);
            }
        }catch (Exception e) {
            
            
        
    }
    }

    
    public void setRecordsTable() 
    {
        try {
            pst = con.prepareStatement("select * from students");
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()) {
                String StudentID = rs.getString("studentid");
                String StudentName = rs.getString("studentname");
                String Strand = rs.getString("strand");
                String GradeAndSection = rs.getString("gradeandsection");
                
                Object [] obj = {StudentID,StudentName,Strand,GradeAndSection};
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
        txtStudentID = new javax.swing.JTextField();
        txtStudentName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
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
        jComboBox3 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        txtGrandSec = new javax.swing.JComboBox<>();
        txtStrand = new javax.swing.JComboBox<>();
        editbutton = new javax.swing.JLabel();
        addbutton = new javax.swing.JLabel();
        updatebutton = new javax.swing.JLabel();
        deletebutton = new javax.swing.JLabel();
        textadd = new javax.swing.JLabel();
        txtupdate = new javax.swing.JLabel();
        txtremove = new javax.swing.JLabel();
        txtedit = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1186, 701));

        jPanel2.setBackground(new java.awt.Color(31, 25, 60));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Student ID");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Student Name");

        txtStudentID.setBackground(new java.awt.Color(31, 25, 60));
        txtStudentID.setForeground(new java.awt.Color(255, 255, 255));
        txtStudentID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtStudentID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStudentIDActionPerformed(evt);
            }
        });

        txtStudentName.setBackground(new java.awt.Color(31, 25, 60));
        txtStudentName.setForeground(new java.awt.Color(255, 255, 255));
        txtStudentName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Strand");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Gr. & Sec.");

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Add a Student");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-student-90.png"))); // NOI18N

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-security-pass-32.png"))); // NOI18N

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-security-pass-28.png"))); // NOI18N

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-person-28.png"))); // NOI18N

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-user-groups-28.png"))); // NOI18N

        jPanel11.setBackground(new java.awt.Color(31, 25, 60));

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setBackground(new java.awt.Color(255, 255, 255));
        jTable1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable1.setForeground(new java.awt.Color(0, 0, 0));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Student Name", "Strand", "Gr. & Sec."
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
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(80);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(150);
        }

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 40)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 204));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-manage-80.png"))); // NOI18N
        jLabel15.setText("Manage Student");

        jPanel10.setBackground(new java.awt.Color(255, 255, 204));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
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

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "ABM", "HUMSS", "ICT" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(245, 245, 245)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel15)))
                    .addComponent(jScrollPane5))
                .addContainerGap(1121, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel16)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(250, Short.MAX_VALUE))
        );

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

        txtGrandSec.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "12 JOBS", "12 GATES", "12 DELL" }));

        txtStrand.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "ABM", "ICT", "HUMSS" }));

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
            public void mousePressed(java.awt.event.MouseEvent evt) {
                editbuttonMousePressed(evt);
            }
        });

        addbutton.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        addbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-add-48.png"))); // NOI18N
        addbutton.setToolTipText("");
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

        textadd.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        textadd.setForeground(new java.awt.Color(255, 255, 255));
        textadd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textadd.setText("ADD");

        txtupdate.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        txtupdate.setForeground(new java.awt.Color(255, 255, 255));
        txtupdate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtupdate.setText("UPDATE");
        txtupdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtupdateMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtupdateMouseExited(evt);
            }
        });

        txtremove.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        txtremove.setForeground(new java.awt.Color(255, 255, 255));
        txtremove.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtremove.setText("DELETE");

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
                        .addGap(120, 120, 120)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel4)
                                    .addComponent(txtStudentID)
                                    .addComponent(txtStudentName)
                                    .addComponent(txtStrand, 0, 277, Short.MAX_VALUE))
                                .addComponent(txtGrandSec, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(addbutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(textadd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(editbutton)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(txtedit, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(deletebutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtremove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(24, 24, 24)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(updatebutton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtupdate))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(49, 49, 49)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtStudentID, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtStudentName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(13, 13, 13)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtStrand, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4))
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(txtGrandSec, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(deletebutton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(editbutton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addbutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textadd)
                            .addComponent(txtremove)
                            .addComponent(txtedit)
                            .addComponent(txtupdate)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(updatebutton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(2234, 2234, 2234))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 702, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        updatebutton.setVisible(false);
        deletebutton.setVisible(false);
        textadd.setVisible(false);
        txtupdate.setVisible(false);
        txtremove.setVisible(false);
        txtedit.setVisible(false);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtStudentIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStudentIDActionPerformed
        
    }//GEN-LAST:event_txtStudentIDActionPerformed

    private void jTable1jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1jTable1MouseClicked
        
        jTable1.setFocusable(true);
        editbutton.setEnabled(true);
        deletebutton.setEnabled(true);
        
        

    }//GEN-LAST:event_jTable1jTable1MouseClicked

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed

    }//GEN-LAST:event_txtSearchActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        String searchString = txtSearch.getText();
        search(searchString);
    }//GEN-LAST:event_txtSearchKeyReleased

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
         String filterString = jComboBox3.getSelectedItem().toString();
         filter(filterString);
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void addbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addbuttonMouseClicked
         
        
        try {
            String StudentID,StudentName,Strand,GrandSec;
            StudentID = txtStudentID.getText();
            StudentName = txtStudentName.getText();
            Strand = txtStrand.getSelectedItem().toString();
            GrandSec = txtGrandSec.getSelectedItem().toString();
            pst = con.prepareStatement("insert into students (studentid,studentname,strand,gradeandsection)values(?,?,?,?)");
            pst.setString(1, StudentID);
            pst.setString(2, StudentName);
            pst.setString(3, Strand);
            pst.setString(4, GrandSec);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Student Added");
            table_update();
            txtStudentID.setText("");
            txtStudentName.setText("");
            txtStrand.setSelectedIndex(0);
            txtGrandSec.setSelectedIndex(0);
            txtGrandSec.requestFocus();
        }catch (SQLException ex) {
            Logger.getLogger(MANAGESTUDENT.class.getName()).log(Level.SEVERE, null, ex);

        }

    }//GEN-LAST:event_addbuttonMouseClicked

    private void updatebuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatebuttonMouseClicked
          int optionType = JOptionPane.YES_NO_OPTION;
          int result = JOptionPane.showConfirmDialog(null, "Are you sure?","Update Student", optionType);
          try { 
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();  
            String StudentID,StudentName,Strand,GrandSec;
            StudentID = txtStudentID.getText();
            StudentName = txtStudentName.getText();
            Strand = txtStrand.getSelectedItem().toString();
            GrandSec = txtGrandSec.getSelectedItem().toString();
            
            if (result == JOptionPane.YES_OPTION) 
            pst = con.prepareStatement("update students set studentid = ?, studentname = ?,strand = ?,gradeandsection = ? where studentid = ?");            
            pst.setString (1, StudentID);
            pst.setString (2, StudentName);
            pst.setString (3, Strand);
            pst.setString (4, GrandSec);
            pst.setString (5, StudentID);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Book Updated");
            table_update();
            txtStudentID.setText("");
            txtStudentName.setText("");
            txtStrand.setSelectedIndex(0);
            txtGrandSec.setSelectedIndex(0);
            txtStudentName.requestFocus();
            addbutton.setVisible(true);
            deletebutton.setVisible(true);
            editbutton.setVisible(true);
            updatebutton.setVisible(false);
            jTable1.clearSelection();
            
        }catch (SQLException ex) {
            Logger.getLogger(MANAGESTUDENT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_updatebuttonMouseClicked

    private void deletebuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deletebuttonMouseClicked
           int optionType = JOptionPane.YES_NO_OPTION;
           int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to remove this student", "Delete", optionType);
        
           
           try {
               String StudentID;
               StudentID = txtStudentID.getText();
               if (result == JOptionPane.YES_OPTION)
               pst = con.prepareStatement("DELETE FROM students WHERE studentid= ?");
               pst.setString(1, StudentID);
               pst.executeUpdate();
               JOptionPane.showMessageDialog(this, "Student Removed");
               table_update();
               txtStudentID.setText("");
               txtStudentName.setText("");
               txtStrand.setSelectedIndex(0);
               txtGrandSec.setSelectedIndex(0);
               txtStudentName.requestFocus();
                   
           }catch (SQLException ex) {
               Logger.getLogger(MANAGESTUDENT.class.getName()).log(Level.SEVERE, null, ex);
           }
    }//GEN-LAST:event_deletebuttonMouseClicked

    private void editbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editbuttonMouseClicked
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int SelectedRows = jTable1.convertRowIndexToModel( jTable1.getSelectedRow() );      
        txtStudentID.setText(model.getValueAt(SelectedRows, 0).toString());
        txtStudentName.setText(model.getValueAt(SelectedRows, 1).toString());
        txtStrand.setSelectedItem(model.getValueAt(SelectedRows, 2).toString());
        txtGrandSec.setSelectedItem(model.getValueAt(SelectedRows, 3).toString());
        
        addbutton.setVisible(false);
        deletebutton.setVisible(true);
        editbutton.setVisible(false);
        updatebutton.setVisible(true);
        
    }//GEN-LAST:event_editbuttonMouseClicked

    private void addbuttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addbuttonMouseEntered
        textadd.setVisible(true);
    }//GEN-LAST:event_addbuttonMouseEntered

    private void addbuttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addbuttonMouseExited
       textadd.setVisible(false);
    }//GEN-LAST:event_addbuttonMouseExited

    private void txtupdateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtupdateMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_txtupdateMouseExited

    private void deletebuttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deletebuttonMouseEntered
        txtremove.setVisible(true);
    }//GEN-LAST:event_deletebuttonMouseEntered

    private void deletebuttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deletebuttonMouseExited
          txtremove.setVisible(false);
    }//GEN-LAST:event_deletebuttonMouseExited

    private void editbuttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editbuttonMouseEntered
           txtedit.setVisible(true);      
    }//GEN-LAST:event_editbuttonMouseEntered

    private void updatebuttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatebuttonMouseEntered
        txtupdate.setVisible(true);      
    }//GEN-LAST:event_updatebuttonMouseEntered

    private void updatebuttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatebuttonMouseExited
          txtupdate.setVisible(false);          
    }//GEN-LAST:event_updatebuttonMouseExited

    private void editbuttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editbuttonMouseExited
       txtedit.setVisible(false);              
    }//GEN-LAST:event_editbuttonMouseExited

    private void txtupdateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtupdateMouseEntered
       
    }//GEN-LAST:event_txtupdateMouseEntered

    private void editbuttonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editbuttonMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_editbuttonMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addbutton;
    private javax.swing.JLabel deletebutton;
    private javax.swing.JLabel editbutton;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
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
    private javax.swing.JComboBox<String> txtGrandSec;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JComboBox<String> txtStrand;
    private javax.swing.JTextField txtStudentID;
    private javax.swing.JTextField txtStudentName;
    private javax.swing.JLabel txtedit;
    private javax.swing.JLabel txtremove;
    private javax.swing.JLabel txtupdate;
    private javax.swing.JLabel updatebutton;
    // End of variables declaration//GEN-END:variables
}
