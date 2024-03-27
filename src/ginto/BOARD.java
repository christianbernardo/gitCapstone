
package ginto;


import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import  java.sql.*;
import java.text.MessageFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.OrientationRequested;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;




public class BOARD extends javax.swing.JFrame {

    
    public BOARD() {
        initComponents();
        Connect();
        table_update();
        setRecordsTable();
    }
    
    Connection con;
    PreparedStatement pst;
    DefaultTableModel model;
    
    
    
    public void Connect()
     {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/data","root","");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BOARD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BOARD.class.getName()).log(Level.SEVERE, null, ex);
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
     
     public void Delete(){
        String sql="delete from issue where Student_ID=?";
        
        try{
            pst=con.prepareStatement(sql);
            pst.setString(1, txtStudentID.getText());
            pst.execute();        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
     
     public void ReturnUpdate(){
         String sql= "insert into returnbook(student_id,student_name,strand,grade_section,book_id,book_name,book_author,genre,book_quantity,issue_date,due_date,return_date,status)values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try{
            pst= con.prepareStatement(sql);
            pst.setString(1, txtStudentID.getText());
            pst.setString(2, txtStudentName.getText());
            pst.setString(3, txtStrand.getSelectedItem().toString());
            pst.setString(4, txtGrSec.getText());
            pst.setString(5, txtBookID.getText());
            pst.setString(6, txtBookName.getText());
            pst.setString(7, txtAuthor.getText());
            pst.setString(8, txtGenre.getSelectedItem().toString());
            pst.setString(9, txtQuantity.getText());
            pst.setString(10, ((JTextField)txtIssueDate.getDateEditor().getUiComponent()).getText());
            pst.setString(11, ((JTextField)txtDueDate.getDateEditor().getUiComponent()).getText());
            pst.setString(12, ((JTextField)txtReturnDate.getDateEditor().getUiComponent()).getText());
            pst.setString(13, "Returned");

            pst.execute();
            JOptionPane.showMessageDialog(null, "Book Returned");
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
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

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        dashboard = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        a7 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        managebook = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtBookID = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtBookName = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtBookAuthor = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtGenre = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        addbutton = new javax.swing.JLabel();
        editbutton = new javax.swing.JLabel();
        deletebutton = new javax.swing.JLabel();
        updatebutton = new javax.swing.JLabel();
        textadd = new javax.swing.JLabel();
        txtedit = new javax.swing.JLabel();
        txtremove = new javax.swing.JLabel();
        txtupdate = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        managestudent = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        txtStudentID = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        txtStudentName = new javax.swing.JTextField();
        txtStrand = new javax.swing.JComboBox<>();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        txtGrandSec = new javax.swing.JComboBox<>();
        addbutton1 = new javax.swing.JLabel();
        editbutton1 = new javax.swing.JLabel();
        deletebutton1 = new javax.swing.JLabel();
        updatebutton1 = new javax.swing.JLabel();
        textadd1 = new javax.swing.JLabel();
        txtedit1 = new javax.swing.JLabel();
        txtupdate1 = new javax.swing.JLabel();
        txtremove1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        txtSearch1 = new javax.swing.JTextField();
        jComboBox3 = new javax.swing.JComboBox<>();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        transaction = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jComboBox4 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        transactiontable = new javax.swing.JTable();
        issue = new javax.swing.JButton();
        returns = new javax.swing.JButton();
        a8 = new javax.swing.JLabel();
        records = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jComboBox5 = new javax.swing.JComboBox<>();
        jTextField3 = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel40 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        a9 = new javax.swing.JLabel();
        issuebook = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        txtStudentID1 = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        txtStudentName1 = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        txtGrSec = new javax.swing.JTextField();
        txtStrand1 = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        Search = new javax.swing.JButton();
        jPanel18 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        Search2 = new javax.swing.JButton();
        jPanel19 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        txtBookID1 = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        txtBookName1 = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        txtAuthor = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        txtQuantity1 = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        txtGenre1 = new javax.swing.JTextField();
        jPanel20 = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        issuebook1 = new javax.swing.JButton();
        txtIssueDate = new com.toedter.calendar.JDateChooser();
        txtDueDate = new com.toedter.calendar.JDateChooser();
        jLabel54 = new javax.swing.JLabel();
        student = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jLabel70 = new javax.swing.JLabel();
        txtSearch2 = new javax.swing.JTextField();
        jComboBox6 = new javax.swing.JComboBox<>();
        a10 = new javax.swing.JLabel();
        book = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jLabel71 = new javax.swing.JLabel();
        txtSearch3 = new javax.swing.JTextField();
        jComboBox7 = new javax.swing.JComboBox<>();
        a11 = new javax.swing.JLabel();
        returnbook = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        txtStudentID2 = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        txtStudentName2 = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        txtStrand2 = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        txtGrSec1 = new javax.swing.JTextField();
        jLabel61 = new javax.swing.JLabel();
        txtIssueDate1 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        txtBookName2 = new javax.swing.JTextField();
        jLabel66 = new javax.swing.JLabel();
        txtAuthor1 = new javax.swing.JTextField();
        jLabel67 = new javax.swing.JLabel();
        txtQuantity2 = new javax.swing.JTextField();
        jLabel68 = new javax.swing.JLabel();
        txtReturnDate = new com.toedter.calendar.JDateChooser();
        txtBookID2 = new javax.swing.JTextField();
        jLabel69 = new javax.swing.JLabel();
        txtGenre2 = new javax.swing.JTextField();
        txtDueDate1 = new javax.swing.JTextField();
        details = new javax.swing.JPanel();
        jLabel72 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        findreturndetails = new javax.swing.JTable();
        txtSearch4 = new javax.swing.JTextField();
        jComboBox8 = new javax.swing.JComboBox<>();
        a12 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        t1 = new javax.swing.JPanel();
        dash = new javax.swing.JLabel();
        t2 = new javax.swing.JPanel();
        books = new javax.swing.JLabel();
        t3 = new javax.swing.JPanel();
        students = new javax.swing.JLabel();
        t4 = new javax.swing.JPanel();
        trans = new javax.swing.JLabel();
        t5 = new javax.swing.JPanel();
        rec = new javax.swing.JLabel();
        a6 = new javax.swing.JPanel();
        A6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dashboard.setBackground(new java.awt.Color(31, 25, 60));
        dashboard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel14.setBackground(new java.awt.Color(0, 0, 51));
        jPanel14.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 0, 0, 2, new java.awt.Color(255, 255, 255)));
        jPanel14.setPreferredSize(new java.awt.Dimension(340, 92));
        jPanel14.setLayout(null);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("TOTAL BOOKS");
        jLabel12.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel14.add(jLabel12);
        jLabel12.setBounds(10, 10, 126, 30);

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 50)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("100");
        jPanel14.add(jLabel13);
        jLabel13.setBounds(150, 0, 87, 110);

        dashboard.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 270, 110));

        jPanel15.setBackground(new java.awt.Color(0, 0, 51));
        jPanel15.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 0, 0, 2, new java.awt.Color(255, 255, 255)));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("TOTAL STUDENTS");
        jLabel14.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel15.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 160, 30));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 50)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("559");
        jPanel15.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, -1, 110));

        dashboard.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, 270, -1));

        jPanel16.setBackground(new java.awt.Color(0, 0, 51));
        jPanel16.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 0, 0, 2, new java.awt.Color(255, 255, 255)));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("ISSUED BOOKS");
        jLabel16.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel16.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 140, 30));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 50)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("459");
        jPanel16.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, -1, 110));

        dashboard.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 120, 270, -1));

        jPanel17.setBackground(new java.awt.Color(0, 0, 51));
        jPanel17.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 0, 0, 2, new java.awt.Color(255, 255, 255)));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("OVERDUE");
        jLabel18.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel17.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, 30));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 50)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("599");
        jPanel17.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, -1, 110));

        dashboard.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 120, 270, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/1w.png"))); // NOI18N
        dashboard.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));

        jTextField1.setBackground(new java.awt.Color(31, 25, 60));
        jTextField1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 255, 255)));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        dashboard.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 250, 30));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "ABM", "HUMSS", "ICT", "General Reference", "Fiction", "Core Subject" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        dashboard.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 240, -1, 30));

        jTable1.setBackground(new java.awt.Color(255, 255, 255));
        jTable1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable1.setForeground(new java.awt.Color(0, 0, 0));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Student's Name", "Book Name", "Book ID", "Date Borrow", "Due Date", "Days Overdue", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setGridColor(new java.awt.Color(0, 0, 0));
        jTable1.setSelectionBackground(new java.awt.Color(153, 153, 153));
        jTable1.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jTable1.setShowGrid(true);
        jTable1.setSurrendersFocusOnKeystroke(true);
        jTable1.getTableHeader().setResizingAllowed(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTable1);

        dashboard.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 1080, 480));

        a7.setFont(new java.awt.Font("Century Gothic", 1, 50)); // NOI18N
        a7.setForeground(new java.awt.Color(255, 255, 255));
        a7.setText("DASHBOARD");
        dashboard.add(a7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 425, -1));

        jButton7.setBackground(new java.awt.Color(255, 0, 0));
        jButton7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/2.png"))); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        dashboard.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 20, -1, -1));

        jTabbedPane1.addTab("DASHBOARD", dashboard);

        managebook.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(31, 25, 60));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 2, new java.awt.Color(255, 255, 255)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-books-90.png"))); // NOI18N
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, -1, -1));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Add a Book");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 110, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Book ID :");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 60, 20));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-contact-28 (1).png"))); // NOI18N
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 30, 40));

        txtBookID.setBackground(new java.awt.Color(31, 25, 60));
        txtBookID.setForeground(new java.awt.Color(255, 255, 255));
        txtBookID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtBookID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBookIDActionPerformed(evt);
            }
        });
        jPanel4.add(txtBookID, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 290, 40));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-moleskine-28 (1).png"))); // NOI18N
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, -1, 40));

        txtBookName.setBackground(new java.awt.Color(31, 25, 60));
        txtBookName.setForeground(new java.awt.Color(255, 255, 255));
        txtBookName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jPanel4.add(txtBookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, 290, 40));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Book Name :");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 80, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-collaborator-28 (1).png"))); // NOI18N
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, -1, 40));

        txtBookAuthor.setBackground(new java.awt.Color(31, 25, 60));
        txtBookAuthor.setForeground(new java.awt.Color(255, 255, 255));
        txtBookAuthor.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jPanel4.add(txtBookAuthor, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 440, 290, 40));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Book Author :");
        jPanel4.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 420, 90, -1));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Genre :");
        jPanel4.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 490, 50, -1));

        txtGenre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "ABM", "HUMSS", "ICT", "General Reference", "Fiction", "Core Subject" }));
        txtGenre.setPreferredSize(new java.awt.Dimension(129, 35));
        jPanel4.add(txtGenre, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 510, 240, 40));

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-book-28.png"))); // NOI18N
        jPanel4.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, -1, 40));

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-unit-28 (1).png"))); // NOI18N
        jPanel4.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 580, -1, 40));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Quantity :");
        jPanel4.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 560, 70, -1));

        txtQuantity.setBackground(new java.awt.Color(31, 25, 60));
        txtQuantity.setForeground(new java.awt.Color(255, 255, 255));
        txtQuantity.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuantityActionPerformed(evt);
            }
        });
        jPanel4.add(txtQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 580, 290, 40));

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
        jPanel4.add(addbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 640, -1, -1));

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
        jPanel4.add(editbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 640, -1, -1));

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
        jPanel4.add(deletebutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 640, 50, 50));
        deletebutton.setVisible(false);

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
        jPanel4.add(updatebutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 640, -1, -1));
        updatebutton.setVisible(false);

        textadd.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        textadd.setForeground(new java.awt.Color(255, 255, 255));
        textadd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textadd.setText("ADD");
        jPanel4.add(textadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 700, 50, -1));
        textadd.setVisible(false);

        txtedit.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        txtedit.setForeground(new java.awt.Color(255, 255, 255));
        txtedit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtedit.setText("EDIT");
        jPanel4.add(txtedit, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 700, 50, -1));
        txtedit.setVisible(false);

        txtremove.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        txtremove.setForeground(new java.awt.Color(255, 255, 255));
        txtremove.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtremove.setText("DELETE");
        jPanel4.add(txtremove, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 700, 50, -1));
        txtremove.setVisible(false);

        txtupdate.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        txtupdate.setForeground(new java.awt.Color(255, 255, 255));
        txtupdate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtupdate.setText("UPDATE");
        jPanel4.add(txtupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 700, -1, -1));
        txtupdate.setVisible(false);

        managebook.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 810));

        jPanel10.setBackground(new java.awt.Color(31, 25, 60));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 50)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 204));
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-book-50.png"))); // NOI18N
        jLabel25.setText(" Manage Books");
        jLabel25.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 0, new java.awt.Color(255, 255, 255)));
        jPanel10.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 400, 90));

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/1w.png"))); // NOI18N
        jPanel10.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

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
        jPanel10.add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 260, 30));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "ABM", "HUMSS", "ICT", "General Reference", "Fiction", "Core Subject" }));
        jPanel10.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, -1, 30));

        jTable2.setAutoCreateRowSorter(true);
        jTable2.setBackground(new java.awt.Color(255, 255, 255));
        jTable2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable2.setForeground(new java.awt.Color(0, 0, 0));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(jTable2);

        jPanel10.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 730, 600));

        managebook.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 770, 810));

        jTabbedPane1.addTab("MANAGEBOOK", managebook);

        managestudent.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel11.setBackground(new java.awt.Color(31, 25, 60));
        jPanel11.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 2, new java.awt.Color(255, 255, 255)));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-student-90.png"))); // NOI18N
        jPanel11.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, -1, -1));

        jLabel28.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Add a Student");
        jPanel11.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, -1, -1));

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Student ID :");
        jPanel11.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 70, 20));

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-security-pass-32.png"))); // NOI18N
        jPanel11.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 30, 40));

        txtStudentID.setBackground(new java.awt.Color(31, 25, 60));
        txtStudentID.setForeground(new java.awt.Color(255, 255, 255));
        txtStudentID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtStudentID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStudentIDActionPerformed(evt);
            }
        });
        jPanel11.add(txtStudentID, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 290, 40));

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-person-28.png"))); // NOI18N
        jPanel11.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, -1, 40));

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Student Name :");
        jPanel11.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 90, -1));

        txtStudentName.setBackground(new java.awt.Color(31, 25, 60));
        txtStudentName.setForeground(new java.awt.Color(255, 255, 255));
        txtStudentName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jPanel11.add(txtStudentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, 290, 40));

        txtStrand.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "ABM", "ICT", "HUMSS" }));
        jPanel11.add(txtStrand, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 440, 250, 40));

        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-security-pass-28.png"))); // NOI18N
        jPanel11.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, -1, 40));

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Strand ;");
        jPanel11.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 420, 50, -1));

        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-user-groups-28.png"))); // NOI18N
        jPanel11.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, 30, 40));

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Gr. & Sec. :");
        jPanel11.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 490, 70, -1));

        txtGrandSec.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "12 JOBS", "12 GATES", "12 DELL" }));
        jPanel11.add(txtGrandSec, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 520, 250, 40));

        addbutton1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        addbutton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-add-48.png"))); // NOI18N
        addbutton1.setToolTipText("");
        addbutton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addbutton1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addbutton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addbutton1MouseExited(evt);
            }
        });
        jPanel11.add(addbutton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 570, -1, 50));

        editbutton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-pen-squared-48.png"))); // NOI18N
        editbutton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editbutton1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                editbutton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                editbutton1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                editbutton1MousePressed(evt);
            }
        });
        jPanel11.add(editbutton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 570, -1, 50));

        deletebutton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-x-48.png"))); // NOI18N
        deletebutton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deletebutton1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deletebutton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deletebutton1MouseExited(evt);
            }
        });
        jPanel11.add(deletebutton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 570, -1, 50));
        deletebutton.setVisible(false);

        updatebutton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/PG-removebg-preview.png"))); // NOI18N
        updatebutton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updatebutton1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                updatebutton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                updatebutton1MouseExited(evt);
            }
        });
        jPanel11.add(updatebutton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 570, 50, 50));
        updatebutton.setVisible(false);

        textadd1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        textadd1.setForeground(new java.awt.Color(255, 255, 255));
        textadd1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textadd1.setText("ADD");
        jPanel11.add(textadd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 630, 50, -1));
        textadd.setVisible(false);

        txtedit1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        txtedit1.setForeground(new java.awt.Color(255, 255, 255));
        txtedit1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtedit1.setText("EDIT");
        jPanel11.add(txtedit1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 630, 50, -1));
        txtedit.setVisible(false);

        txtupdate1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        txtupdate1.setForeground(new java.awt.Color(255, 255, 255));
        txtupdate1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtupdate1.setText("UPDATE");
        txtupdate1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtupdate1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtupdate1MouseExited(evt);
            }
        });
        jPanel11.add(txtupdate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 630, 50, -1));
        txtupdate.setVisible(false);

        txtremove1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        txtremove1.setForeground(new java.awt.Color(255, 255, 255));
        txtremove1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtremove1.setText("DELETE");
        jPanel11.add(txtremove1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 630, 50, -1));
        txtremove.setVisible(false);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/1.png"))); // NOI18N
        jPanel11.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 450, 20, -1));

        managestudent.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 810));

        jPanel12.setBackground(new java.awt.Color(31, 25, 60));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 50)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 204));
        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-manage-80.png"))); // NOI18N
        jLabel37.setText("Manage Student");
        jLabel37.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 0, new java.awt.Color(255, 255, 255)));
        jPanel12.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, -1, 90));

        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/1w.png"))); // NOI18N
        jPanel12.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        txtSearch1.setBackground(new java.awt.Color(31, 25, 60));
        txtSearch1.setForeground(new java.awt.Color(255, 255, 255));
        txtSearch1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 255, 255)));
        txtSearch1.setCaretColor(new java.awt.Color(255, 255, 255));
        txtSearch1.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtSearch1.setDragEnabled(true);
        txtSearch1.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        txtSearch1.setSelectionColor(new java.awt.Color(60, 63, 65));
        txtSearch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearch1ActionPerformed(evt);
            }
        });
        txtSearch1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearch1KeyReleased(evt);
            }
        });
        jPanel12.add(txtSearch1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 260, 30));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "ABM", "HUMSS", "ICT" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });
        jPanel12.add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, 130, 30));

        jTable3.setAutoCreateRowSorter(true);
        jTable3.setBackground(new java.awt.Color(255, 255, 255));
        jTable3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable3.setForeground(new java.awt.Color(0, 0, 0));
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable3.setGridColor(new java.awt.Color(0, 0, 0));
        jTable3.setSelectionBackground(new java.awt.Color(153, 153, 153));
        jTable3.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jTable3.setShowGrid(true);
        jTable3.getTableHeader().setReorderingAllowed(false);
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3jTable1MouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jTable3);

        jPanel12.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 730, 600));

        managestudent.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 770, 810));

        jTabbedPane1.addTab("MANAGESTUDENT", managestudent);

        transaction.setBackground(new java.awt.Color(31, 25, 60));
        transaction.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/1w.png"))); // NOI18N
        transaction.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        jTextField2.setBackground(new java.awt.Color(31, 25, 60));
        jTextField2.setForeground(new java.awt.Color(255, 255, 255));
        jTextField2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 255, 255)));
        jTextField2.setSelectionColor(new java.awt.Color(255, 255, 255));
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
        });
        transaction.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 270, 30));

        jButton3.setText("REFRESH");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        transaction.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 120, -1, 30));

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "JOBS", "GATES", "ROBERTS", "DELL" }));
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });
        transaction.add(jComboBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 120, 150, 30));

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

        transaction.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 1080, 550));

        issue.setBackground(new java.awt.Color(255, 0, 0));
        issue.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        issue.setForeground(new java.awt.Color(255, 255, 255));
        issue.setText("ISSUE BOOK");
        issue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                issueMouseClicked(evt);
            }
        });
        issue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                issueActionPerformed(evt);
            }
        });
        transaction.add(issue, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 720, 250, 40));

        returns.setBackground(new java.awt.Color(255, 0, 0));
        returns.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        returns.setForeground(new java.awt.Color(255, 255, 255));
        returns.setText("RETURN BOOK");
        returns.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                returnsMouseClicked(evt);
            }
        });
        returns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnsActionPerformed(evt);
            }
        });
        transaction.add(returns, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 720, 250, 40));

        a8.setFont(new java.awt.Font("Century Gothic", 1, 50)); // NOI18N
        a8.setForeground(new java.awt.Color(255, 255, 255));
        a8.setText("TRANSACTION");
        transaction.add(a8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 425, -1));

        jTabbedPane1.addTab("TRANSACTION", transaction);

        records.setBackground(new java.awt.Color(31, 25, 60));
        records.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton4.setText("DOWNLOAD ");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        records.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 120, -1, 20));

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "ABM", "HUMSS", "ICT" }));
        records.add(jComboBox5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, 170, 30));

        jTextField3.setBackground(new java.awt.Color(31, 25, 60));
        jTextField3.setForeground(new java.awt.Color(255, 255, 255));
        jTextField3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 255, 255)));
        jTextField3.setSelectionColor(new java.awt.Color(255, 255, 255));
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField3KeyReleased(evt);
            }
        });
        records.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 290, 30));

        jCheckBox1.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-select-18.png"))); // NOI18N
        jCheckBox1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-select-18 (1).png"))); // NOI18N
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        records.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 130, -1, 20));

        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/1w.png"))); // NOI18N
        records.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, 30));

        jTable4.setBackground(new java.awt.Color(255, 255, 255));
        jTable4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable4.setForeground(new java.awt.Color(0, 0, 0));
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Student Name", "Strand", "Gr. & Sec", "Book ID", "Book Name", "Author", "Genre", "Quantity", "Issue Date", "Due Date", "Return Date", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable4.setGridColor(new java.awt.Color(0, 0, 0));
        jTable4.setSelectionBackground(new java.awt.Color(153, 153, 153));
        jTable4.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jTable4.setShowGrid(true);
        jTable4.getTableHeader().setResizingAllowed(false);
        jTable4.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jTable4);

        records.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 1080, 600));

        a9.setFont(new java.awt.Font("Century Gothic", 1, 50)); // NOI18N
        a9.setForeground(new java.awt.Color(255, 255, 255));
        a9.setText("RECORDS");
        records.add(a9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 425, -1));

        jTabbedPane1.addTab("RECORDS", records);

        issuebook.setBackground(new java.awt.Color(31, 25, 60));
        issuebook.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(0, 0, 117));

        jLabel41.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("Student Name :");

        txtStudentID1.setBackground(new java.awt.Color(0, 0, 117));
        txtStudentID1.setForeground(new java.awt.Color(255, 255, 255));
        txtStudentID1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtStudentID1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStudentID1ActionPerformed(evt);
            }
        });

        jLabel42.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("Gr. & Sec.  :");

        jLabel43.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("Student ID :");

        jLabel44.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-student-registration-85.png"))); // NOI18N
        jLabel44.setText("Student Details");

        txtStudentName1.setBackground(new java.awt.Color(0, 0, 117));
        txtStudentName1.setForeground(new java.awt.Color(255, 255, 255));
        txtStudentName1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtStudentName1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStudentName1ActionPerformed(evt);
            }
        });

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

        txtGrSec.setBackground(new java.awt.Color(0, 0, 117));
        txtGrSec.setForeground(new java.awt.Color(255, 255, 255));
        txtGrSec.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtGrSec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGrSecActionPerformed(evt);
            }
        });

        txtStrand1.setBackground(new java.awt.Color(0, 0, 117));
        txtStrand1.setForeground(new java.awt.Color(255, 255, 255));
        txtStrand1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtStrand1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStrand1ActionPerformed(evt);
            }
        });

        jLabel45.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("Strand :");

        Search.setBackground(new java.awt.Color(255, 0, 0));
        Search.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Search.setForeground(new java.awt.Color(255, 255, 255));
        Search.setText("Find");
        Search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SearchMouseClicked(evt);
            }
        });
        Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabel44)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtStudentID1)
                    .addComponent(txtStudentName1)
                    .addComponent(txtStrand1)
                    .addComponent(txtGrSec)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel41)
                            .addComponent(jLabel45)
                            .addComponent(jLabel42))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel43)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Search)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel44)
                .addGap(11, 11, 11)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(Search))
                .addGap(1, 1, 1)
                .addComponent(txtStudentID1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jLabel41)
                .addGap(4, 4, 4)
                .addComponent(txtStudentName1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabel45)
                .addGap(4, 4, 4)
                .addComponent(txtStrand1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabel42)
                .addGap(4, 4, 4)
                .addComponent(txtGrSec, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(327, Short.MAX_VALUE))
        );

        issuebook.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 350, 780));

        jPanel18.setBackground(new java.awt.Color(0, 0, 96));
        jPanel18.setLayout(null);

        jLabel46.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-details-85.png"))); // NOI18N
        jLabel46.setText("Book Details");
        jPanel18.add(jLabel46);
        jLabel46.setBounds(70, 30, 187, 85);

        Search2.setBackground(new java.awt.Color(255, 0, 0));
        Search2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Search2.setForeground(new java.awt.Color(255, 255, 255));
        Search2.setText("Find");
        Search2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Search2MouseClicked(evt);
            }
        });
        Search2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Search2Search1ActionPerformed(evt);
            }
        });
        jPanel18.add(Search2);
        Search2.setBounds(260, 160, 72, 23);

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setForeground(new java.awt.Color(255, 255, 255));
        jPanel19.setPreferredSize(new java.awt.Dimension(0, 5));

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 259, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        jPanel18.add(jPanel19);
        jPanel19.setBounds(30, 130, 259, 8);

        jLabel47.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("Book ID :");
        jPanel18.add(jLabel47);
        jLabel47.setBounds(10, 160, 51, 16);

        txtBookID1.setBackground(new java.awt.Color(0, 0, 96));
        txtBookID1.setForeground(new java.awt.Color(255, 255, 255));
        txtBookID1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtBookID1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBookID1ActionPerformed(evt);
            }
        });
        jPanel18.add(txtBookID1);
        txtBookID1.setBounds(10, 180, 330, 35);

        jLabel48.setBackground(new java.awt.Color(153, 153, 255));
        jLabel48.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setText("Book Name :");
        jPanel18.add(jLabel48);
        jLabel48.setBounds(10, 220, 71, 16);

        txtBookName1.setBackground(new java.awt.Color(0, 0, 96));
        txtBookName1.setForeground(new java.awt.Color(255, 255, 255));
        txtBookName1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtBookName1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBookName1ActionPerformed(evt);
            }
        });
        jPanel18.add(txtBookName1);
        txtBookName1.setBounds(10, 250, 330, 35);

        jLabel49.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setText("Author :");
        jPanel18.add(jLabel49);
        jLabel49.setBounds(10, 290, 45, 16);

        txtAuthor.setBackground(new java.awt.Color(0, 0, 96));
        txtAuthor.setForeground(new java.awt.Color(255, 255, 255));
        txtAuthor.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAuthorActionPerformed(evt);
            }
        });
        jPanel18.add(txtAuthor);
        txtAuthor.setBounds(10, 320, 330, 35);

        jLabel50.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setText("Quantity :");
        jPanel18.add(jLabel50);
        jLabel50.setBounds(10, 430, 54, 16);

        txtQuantity1.setBackground(new java.awt.Color(0, 0, 96));
        txtQuantity1.setForeground(new java.awt.Color(255, 255, 255));
        txtQuantity1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtQuantity1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuantity1ActionPerformed(evt);
            }
        });
        jPanel18.add(txtQuantity1);
        txtQuantity1.setBounds(10, 460, 330, 35);

        jLabel51.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setText("Genre :");
        jPanel18.add(jLabel51);
        jLabel51.setBounds(10, 360, 41, 16);

        txtGenre1.setBackground(new java.awt.Color(0, 0, 96));
        txtGenre1.setForeground(new java.awt.Color(255, 255, 255));
        txtGenre1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtGenre1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGenre1ActionPerformed(evt);
            }
        });
        jPanel18.add(txtGenre1);
        txtGenre1.setBounds(10, 390, 330, 35);

        issuebook.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 350, 780));

        jPanel20.setBackground(new java.awt.Color(0, 0, 81));

        jLabel52.setBackground(new java.awt.Color(0, 0, 102));
        jLabel52.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-books-50 (1).png"))); // NOI18N
        jLabel52.setText("Issue Book");

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));
        jPanel21.setForeground(new java.awt.Color(255, 255, 255));
        jPanel21.setPreferredSize(new java.awt.Dimension(0, 5));

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 259, Short.MAX_VALUE)
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        jLabel53.setBackground(new java.awt.Color(0, 0, 102));
        jLabel53.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setText("Issue Date :");

        issuebook1.setBackground(new java.awt.Color(255, 0, 0));
        issuebook1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        issuebook1.setForeground(new java.awt.Color(255, 255, 255));
        issuebook1.setText("ISSUE BOOK");
        issuebook1.setBorder(null);
        issuebook1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                issuebook1ActionPerformed(evt);
            }
        });

        jLabel54.setBackground(new java.awt.Color(0, 0, 102));
        jLabel54.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setText("Due Date :");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIssueDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDueDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel53)
                                    .addComponent(jLabel54)
                                    .addGroup(jPanel20Layout.createSequentialGroup()
                                        .addGap(44, 44, 44)
                                        .addComponent(issuebook1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addComponent(jLabel52)))
                        .addGap(0, 59, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel52)
                .addGap(39, 39, 39)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81)
                .addComponent(jLabel53)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIssueDate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel54)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDueDate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(issuebook1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(357, Short.MAX_VALUE))
        );

        issuebook.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 20, 350, 780));

        jTabbedPane1.addTab("ISSUEBOOK", issuebook);

        student.setBackground(new java.awt.Color(31, 25, 60));
        student.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable5.setAutoCreateRowSorter(true);
        jTable5.setBackground(new java.awt.Color(255, 255, 255));
        jTable5.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(0, 0, 0)));
        jTable5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable5.setForeground(new java.awt.Color(0, 0, 0));
        jTable5.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable5.setGridColor(new java.awt.Color(0, 0, 0));
        jTable5.setSelectionBackground(new java.awt.Color(153, 153, 153));
        jTable5.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jTable5.setShowGrid(true);
        jTable5.getTableHeader().setReorderingAllowed(false);
        jTable5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable5jTable1MouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(jTable5);

        student.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 1070, 650));

        jLabel70.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/1w.png"))); // NOI18N
        student.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        txtSearch2.setBackground(new java.awt.Color(31, 25, 60));
        txtSearch2.setForeground(new java.awt.Color(255, 255, 255));
        txtSearch2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 255, 255)));
        txtSearch2.setCaretColor(new java.awt.Color(255, 255, 255));
        txtSearch2.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtSearch2.setDragEnabled(true);
        txtSearch2.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        txtSearch2.setSelectionColor(new java.awt.Color(60, 63, 65));
        txtSearch2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearch2ActionPerformed(evt);
            }
        });
        txtSearch2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearch2KeyReleased(evt);
            }
        });
        student.add(txtSearch2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 320, 30));

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "ABM", "HUMSS", "ICT", "General Reference", "Fiction", "Core Subject" }));
        student.add(jComboBox6, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, 160, 30));

        a10.setFont(new java.awt.Font("Century Gothic", 1, 50)); // NOI18N
        a10.setForeground(new java.awt.Color(255, 255, 255));
        a10.setText("STUDENT LIST");
        student.add(a10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 425, 60));

        jTabbedPane1.addTab("STUDENT", student);

        book.setBackground(new java.awt.Color(31, 25, 60));
        book.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable6.setAutoCreateRowSorter(true);
        jTable6.setBackground(new java.awt.Color(255, 255, 255));
        jTable6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable6.setForeground(new java.awt.Color(0, 0, 0));
        jTable6.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable6.setGridColor(new java.awt.Color(0, 0, 0));
        jTable6.setSelectionBackground(new java.awt.Color(153, 153, 153));
        jTable6.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jTable6.setShowGrid(true);
        jTable6.getTableHeader().setReorderingAllowed(false);
        jTable6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable6MouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(jTable6);

        book.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 1070, 650));

        jLabel71.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/1w.png"))); // NOI18N
        book.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        txtSearch3.setBackground(new java.awt.Color(31, 25, 60));
        txtSearch3.setForeground(new java.awt.Color(255, 255, 255));
        txtSearch3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 255, 255)));
        txtSearch3.setCaretColor(new java.awt.Color(255, 255, 255));
        txtSearch3.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtSearch3.setDragEnabled(true);
        txtSearch3.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        txtSearch3.setSelectionColor(new java.awt.Color(60, 63, 65));
        txtSearch3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearch3ActionPerformed(evt);
            }
        });
        txtSearch3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearch3KeyReleased(evt);
            }
        });
        book.add(txtSearch3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 250, 30));

        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "ABM", "HUMSS", "ICT", "General Reference", "Fiction", "Core Subject" }));
        book.add(jComboBox7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, 150, 30));

        a11.setFont(new java.awt.Font("Century Gothic", 1, 50)); // NOI18N
        a11.setForeground(new java.awt.Color(255, 255, 255));
        a11.setText("BOOK LIST");
        book.add(a11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 425, 60));

        jTabbedPane1.addTab("BOOK", book);

        returnbook.setBackground(new java.awt.Color(31, 25, 60));
        returnbook.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(0, 0, 102));
        jPanel6.setLayout(null);

        jLabel55.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setText("Return");
        jPanel6.add(jLabel55);
        jLabel55.setBounds(200, 10, 124, 40);

        jLabel56.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-return-book-100.png"))); // NOI18N
        jPanel6.add(jLabel56);
        jLabel56.setBounds(210, 60, 101, 101);

        jLabel57.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(255, 255, 255));
        jLabel57.setText("Student ID :");
        jPanel6.add(jLabel57);
        jLabel57.setBounds(20, 180, 67, 16);

        jButton8.setBackground(new java.awt.Color(255, 0, 0));
        jButton8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("Find");
        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton8MouseClicked(evt);
            }
        });
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton8);
        jButton8.setBounds(360, 170, 80, 23);

        txtStudentID2.setBackground(new java.awt.Color(0, 0, 51));
        txtStudentID2.setForeground(new java.awt.Color(255, 255, 255));
        txtStudentID2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtStudentID2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStudentID2ActionPerformed(evt);
            }
        });
        jPanel6.add(txtStudentID2);
        txtStudentID2.setBounds(20, 200, 420, 36);

        jLabel58.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(255, 255, 255));
        jLabel58.setText("Student Name :");
        jPanel6.add(jLabel58);
        jLabel58.setBounds(20, 240, 87, 20);

        txtStudentName2.setBackground(new java.awt.Color(0, 0, 51));
        txtStudentName2.setForeground(new java.awt.Color(255, 255, 255));
        txtStudentName2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtStudentName2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStudentName2ActionPerformed(evt);
            }
        });
        jPanel6.add(txtStudentName2);
        txtStudentName2.setBounds(20, 260, 420, 35);

        jLabel59.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(255, 255, 255));
        jLabel59.setText("Strand :");
        jPanel6.add(jLabel59);
        jLabel59.setBounds(20, 300, 50, 16);

        txtStrand2.setBackground(new java.awt.Color(0, 0, 51));
        txtStrand2.setForeground(new java.awt.Color(255, 255, 255));
        txtStrand2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtStrand2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStrand2ActionPerformed(evt);
            }
        });
        jPanel6.add(txtStrand2);
        txtStrand2.setBounds(20, 320, 420, 35);

        jLabel60.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(255, 255, 255));
        jLabel60.setText("Gr. & Sec.  :");
        jPanel6.add(jLabel60);
        jLabel60.setBounds(20, 360, 65, 16);

        txtGrSec1.setBackground(new java.awt.Color(0, 0, 51));
        txtGrSec1.setForeground(new java.awt.Color(255, 255, 255));
        txtGrSec1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtGrSec1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGrSec1ActionPerformed(evt);
            }
        });
        jPanel6.add(txtGrSec1);
        txtGrSec1.setBounds(20, 380, 420, 35);

        jLabel61.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(255, 255, 255));
        jLabel61.setText("Issue Date:");
        jPanel6.add(jLabel61);
        jLabel61.setBounds(20, 420, 61, 16);

        txtIssueDate1.setBackground(new java.awt.Color(0, 0, 51));
        txtIssueDate1.setForeground(new java.awt.Color(255, 255, 255));
        txtIssueDate1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtIssueDate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIssueDate1ActionPerformed(evt);
            }
        });
        jPanel6.add(txtIssueDate1);
        txtIssueDate1.setBounds(20, 440, 420, 35);

        jButton5.setBackground(new java.awt.Color(204, 0, 0));
        jButton5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Return");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton5);
        jButton5.setBounds(160, 510, 124, 29);

        returnbook.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 530, 790));

        jPanel8.setBackground(new java.awt.Color(0, 0, 86));
        jPanel8.setPreferredSize(new java.awt.Dimension(350, 500));
        jPanel8.setLayout(null);

        jLabel62.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(255, 255, 255));
        jLabel62.setText("Details");
        jPanel8.add(jLabel62);
        jLabel62.setBounds(210, 10, 126, 44);

        jLabel63.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-view-details-100.png"))); // NOI18N
        jPanel8.add(jLabel63);
        jLabel63.setBounds(220, 60, 101, 101);

        jLabel64.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(255, 255, 255));
        jLabel64.setText("Book ID :");
        jPanel8.add(jLabel64);
        jLabel64.setBounds(20, 160, 51, 16);

        jLabel65.setBackground(new java.awt.Color(153, 153, 255));
        jLabel65.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(255, 255, 255));
        jLabel65.setText("Book Name :");
        jPanel8.add(jLabel65);
        jLabel65.setBounds(20, 220, 71, 16);

        txtBookName2.setBackground(new java.awt.Color(0, 0, 51));
        txtBookName2.setForeground(new java.awt.Color(255, 255, 255));
        txtBookName2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtBookName2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBookName2ActionPerformed(evt);
            }
        });
        jPanel8.add(txtBookName2);
        txtBookName2.setBounds(20, 240, 420, 35);

        jLabel66.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(255, 255, 255));
        jLabel66.setText("Author :");
        jPanel8.add(jLabel66);
        jLabel66.setBounds(20, 280, 45, 16);

        txtAuthor1.setBackground(new java.awt.Color(0, 0, 51));
        txtAuthor1.setForeground(new java.awt.Color(255, 255, 255));
        txtAuthor1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtAuthor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAuthor1ActionPerformed(evt);
            }
        });
        jPanel8.add(txtAuthor1);
        txtAuthor1.setBounds(20, 300, 420, 35);

        jLabel67.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(255, 255, 255));
        jLabel67.setText("Quantity :");
        jPanel8.add(jLabel67);
        jLabel67.setBounds(20, 400, 54, 16);

        txtQuantity2.setBackground(new java.awt.Color(0, 0, 51));
        txtQuantity2.setForeground(new java.awt.Color(255, 255, 255));
        txtQuantity2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtQuantity2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuantity2ActionPerformed(evt);
            }
        });
        jPanel8.add(txtQuantity2);
        txtQuantity2.setBounds(20, 420, 420, 35);

        jLabel68.setBackground(new java.awt.Color(153, 153, 255));
        jLabel68.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(255, 255, 255));
        jLabel68.setText("Due Date :");
        jPanel8.add(jLabel68);
        jLabel68.setBounds(20, 460, 80, 16);
        jPanel8.add(txtReturnDate);
        txtReturnDate.setBounds(20, 530, 240, 30);

        txtBookID2.setBackground(new java.awt.Color(0, 0, 51));
        txtBookID2.setForeground(new java.awt.Color(255, 255, 255));
        txtBookID2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtBookID2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBookID2ActionPerformed(evt);
            }
        });
        jPanel8.add(txtBookID2);
        txtBookID2.setBounds(20, 180, 420, 35);

        jLabel69.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(255, 255, 255));
        jLabel69.setText("Genre :");
        jPanel8.add(jLabel69);
        jLabel69.setBounds(20, 340, 41, 16);

        txtGenre2.setBackground(new java.awt.Color(0, 0, 51));
        txtGenre2.setForeground(new java.awt.Color(255, 255, 255));
        txtGenre2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtGenre2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGenre2ActionPerformed(evt);
            }
        });
        jPanel8.add(txtGenre2);
        txtGenre2.setBounds(20, 360, 420, 35);

        txtDueDate1.setBackground(new java.awt.Color(0, 0, 51));
        txtDueDate1.setForeground(new java.awt.Color(255, 255, 255));
        txtDueDate1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtDueDate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDueDate1ActionPerformed(evt);
            }
        });
        jPanel8.add(txtDueDate1);
        txtDueDate1.setBounds(20, 480, 420, 35);

        returnbook.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 20, 530, 790));

        jTabbedPane1.addTab("RETURNBOOK", returnbook);

        details.setBackground(new java.awt.Color(31, 25, 60));
        details.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel72.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/1w.png"))); // NOI18N
        details.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        findreturndetails.setAutoCreateRowSorter(true);
        findreturndetails.setBackground(new java.awt.Color(255, 255, 255));
        findreturndetails.setForeground(new java.awt.Color(0, 0, 0));
        findreturndetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Student Name", "Strand", "Gr. & Sec.", "Book ID", "Book Name", "Genre", "Author", "Quantity", "Issue Date", "Due Date", "Return Date", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        findreturndetails.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        findreturndetails.setGridColor(new java.awt.Color(0, 0, 0));
        findreturndetails.setSelectionBackground(new java.awt.Color(153, 153, 153));
        findreturndetails.setSelectionForeground(new java.awt.Color(0, 0, 0));
        findreturndetails.setShowGrid(true);
        findreturndetails.getTableHeader().setResizingAllowed(false);
        findreturndetails.getTableHeader().setReorderingAllowed(false);
        findreturndetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                findreturndetailsMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(findreturndetails);

        details.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 1070, 650));

        txtSearch4.setEditable(false);
        txtSearch4.setBackground(new java.awt.Color(31, 25, 60));
        txtSearch4.setForeground(new java.awt.Color(255, 255, 255));
        txtSearch4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 255, 255)));
        txtSearch4.setCaretColor(new java.awt.Color(255, 255, 255));
        txtSearch4.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtSearch4.setDragEnabled(true);
        txtSearch4.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        txtSearch4.setSelectionColor(new java.awt.Color(60, 63, 65));
        txtSearch4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearch4ActionPerformed(evt);
            }
        });
        txtSearch4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearch4KeyReleased(evt);
            }
        });
        details.add(txtSearch4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 260, 30));

        jComboBox8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "ABM", "HUMSS", "ICT", "General Reference", "Fiction", "Core Subject" }));
        details.add(jComboBox8, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, 150, 30));

        a12.setFont(new java.awt.Font("Century Gothic", 1, 50)); // NOI18N
        a12.setForeground(new java.awt.Color(255, 255, 255));
        a12.setText("DETAILS");
        details.add(a12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 425, 50));

        jTabbedPane1.addTab("DETAILS", details);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, -40, 1110, 840));

        jPanel2.setBackground(new java.awt.Color(21, 0, 73));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(27, 0, 96));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("LIBRARY MANAGEMENT");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 170, 20));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/small.png"))); // NOI18N
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 60));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Welcome!");
        jLabel3.setToolTipText("");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 30, 90, 30));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 240, 60));

        t1.setBackground(new java.awt.Color(21, 0, 73));

        dash.setBackground(new java.awt.Color(145, 145, 145));
        dash.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        dash.setForeground(new java.awt.Color(255, 255, 255));
        dash.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        dash.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/dash-removebg-preview.png"))); // NOI18N
        dash.setText("       DASHBOARD");
        dash.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        dash.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dashMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dashMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dashMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                dashMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                dashMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout t1Layout = new javax.swing.GroupLayout(t1);
        t1.setLayout(t1Layout);
        t1Layout.setHorizontalGroup(
            t1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dash, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
        );
        t1Layout.setVerticalGroup(
            t1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dash, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );

        jPanel2.add(t1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 260, 80));

        t2.setBackground(new java.awt.Color(21, 0, 73));

        books.setBackground(new java.awt.Color(0, 5, 87));
        books.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        books.setForeground(new java.awt.Color(255, 255, 255));
        books.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        books.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/book-removebg-preview.png"))); // NOI18N
        books.setText("       MANAGE BOOKS");
        books.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        books.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                booksMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                booksMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                booksMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                booksMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                booksMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout t2Layout = new javax.swing.GroupLayout(t2);
        t2.setLayout(t2Layout);
        t2Layout.setHorizontalGroup(
            t2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(books, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
        );
        t2Layout.setVerticalGroup(
            t2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(books, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );

        jPanel2.add(t2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 260, 80));

        t3.setBackground(new java.awt.Color(21, 0, 73));

        students.setBackground(new java.awt.Color(0, 5, 87));
        students.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        students.setForeground(new java.awt.Color(255, 255, 255));
        students.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        students.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/student-removebg-preview.png"))); // NOI18N
        students.setText("       MANAGE STUDENTS");
        students.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 255, 255)));
        students.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                studentsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                studentsMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                studentsMousePressed(evt);
            }
        });

        javax.swing.GroupLayout t3Layout = new javax.swing.GroupLayout(t3);
        t3.setLayout(t3Layout);
        t3Layout.setHorizontalGroup(
            t3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(students, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
        );
        t3Layout.setVerticalGroup(
            t3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(t3Layout.createSequentialGroup()
                .addComponent(students, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.add(t3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 260, 80));

        t4.setBackground(new java.awt.Color(21, 0, 73));

        trans.setBackground(new java.awt.Color(0, 5, 87));
        trans.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        trans.setForeground(new java.awt.Color(255, 255, 255));
        trans.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        trans.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/trans-removebg-preview.png"))); // NOI18N
        trans.setText("       TRANSACTION");
        trans.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        trans.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                transMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                transMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                transMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                transMousePressed(evt);
            }
        });

        javax.swing.GroupLayout t4Layout = new javax.swing.GroupLayout(t4);
        t4.setLayout(t4Layout);
        t4Layout.setHorizontalGroup(
            t4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(trans, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
        );
        t4Layout.setVerticalGroup(
            t4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(trans, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );

        jPanel2.add(t4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 260, 80));

        t5.setBackground(new java.awt.Color(21, 0, 73));

        rec.setBackground(new java.awt.Color(255, 255, 255));
        rec.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        rec.setForeground(new java.awt.Color(255, 255, 255));
        rec.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        rec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/rec-removebg-preview.png"))); // NOI18N
        rec.setText("       RECORDS");
        rec.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        rec.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                recMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                recMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                recMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                recMousePressed(evt);
            }
        });

        javax.swing.GroupLayout t5Layout = new javax.swing.GroupLayout(t5);
        t5.setLayout(t5Layout);
        t5Layout.setHorizontalGroup(
            t5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rec, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
        );
        t5Layout.setVerticalGroup(
            t5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rec, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );

        jPanel2.add(t5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 260, 80));

        a6.setBackground(new java.awt.Color(255, 0, 0));

        A6.setBackground(new java.awt.Color(255, 255, 255));
        A6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        A6.setForeground(new java.awt.Color(255, 255, 255));
        A6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        A6.setText(" Log out");
        A6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                A6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                A6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                A6MouseExited(evt);
            }
        });

        javax.swing.GroupLayout a6Layout = new javax.swing.GroupLayout(a6);
        a6.setLayout(a6Layout);
        a6Layout.setHorizontalGroup(
            a6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(a6Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(A6, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(73, Short.MAX_VALUE))
        );
        a6Layout.setVerticalGroup(
            a6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, a6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(A6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.add(a6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 700, 260, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 800));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(1368, 800));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked

        jTable1.setFocusable(true);
        editbutton.setEnabled(true);
        deletebutton.setEnabled(true);
    }//GEN-LAST:event_jTable2MouseClicked

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        String searchString = txtSearch.getText();
        search(searchString);
    }//GEN-LAST:event_txtSearchKeyReleased

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed

    }//GEN-LAST:event_txtSearchActionPerformed

    private void updatebuttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatebuttonMouseExited
        txtupdate.setVisible(false);
    }//GEN-LAST:event_updatebuttonMouseExited

    private void updatebuttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatebuttonMouseEntered
        txtupdate.setVisible(true);
    }//GEN-LAST:event_updatebuttonMouseEntered

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

    private void deletebuttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deletebuttonMouseExited
        txtremove.setVisible(false);
    }//GEN-LAST:event_deletebuttonMouseExited

    private void deletebuttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deletebuttonMouseEntered
        txtremove.setVisible(true);
    }//GEN-LAST:event_deletebuttonMouseEntered

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

    private void editbuttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editbuttonMouseExited
        txtedit.setVisible(false);
    }//GEN-LAST:event_editbuttonMouseExited

    private void editbuttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editbuttonMouseEntered
        txtedit.setVisible(true);
    }//GEN-LAST:event_editbuttonMouseEntered

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

    private void addbuttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addbuttonMouseExited
        textadd.setVisible(false);
    }//GEN-LAST:event_addbuttonMouseExited

    private void addbuttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addbuttonMouseEntered
        textadd.setVisible(true);
    }//GEN-LAST:event_addbuttonMouseEntered

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

    private void txtQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantityActionPerformed

    }//GEN-LAST:event_txtQuantityActionPerformed

    private void txtBookIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBookIDActionPerformed

    }//GEN-LAST:event_txtBookIDActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed

    }//GEN-LAST:event_jTextField1ActionPerformed

    private void txtStudentIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStudentIDActionPerformed

    }//GEN-LAST:event_txtStudentIDActionPerformed

    private void addbutton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addbutton1MouseClicked

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
    }//GEN-LAST:event_addbutton1MouseClicked

    private void addbutton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addbutton1MouseEntered
        textadd.setVisible(true);
    }//GEN-LAST:event_addbutton1MouseEntered

    private void addbutton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addbutton1MouseExited
        textadd.setVisible(false);
    }//GEN-LAST:event_addbutton1MouseExited

    private void editbutton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editbutton1MouseClicked
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

    }//GEN-LAST:event_editbutton1MouseClicked

    private void editbutton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editbutton1MouseEntered
        txtedit.setVisible(true);
    }//GEN-LAST:event_editbutton1MouseEntered

    private void editbutton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editbutton1MouseExited
        txtedit.setVisible(false);
    }//GEN-LAST:event_editbutton1MouseExited

    private void editbutton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editbutton1MousePressed
        
    }//GEN-LAST:event_editbutton1MousePressed

    private void deletebutton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deletebutton1MouseClicked
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
    }//GEN-LAST:event_deletebutton1MouseClicked

    private void deletebutton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deletebutton1MouseEntered
        txtremove.setVisible(true);
    }//GEN-LAST:event_deletebutton1MouseEntered

    private void deletebutton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deletebutton1MouseExited
        txtremove.setVisible(false);
    }//GEN-LAST:event_deletebutton1MouseExited

    private void updatebutton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatebutton1MouseClicked
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
    }//GEN-LAST:event_updatebutton1MouseClicked

    private void updatebutton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatebutton1MouseEntered
        txtupdate.setVisible(true);
    }//GEN-LAST:event_updatebutton1MouseEntered

    private void updatebutton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatebutton1MouseExited
        txtupdate.setVisible(false);
    }//GEN-LAST:event_updatebutton1MouseExited

    private void txtupdate1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtupdate1MouseEntered

    }//GEN-LAST:event_txtupdate1MouseEntered

    private void txtupdate1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtupdate1MouseExited
       
    }//GEN-LAST:event_txtupdate1MouseExited

    private void txtSearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearch1ActionPerformed

    }//GEN-LAST:event_txtSearch1ActionPerformed

    private void txtSearch1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearch1KeyReleased
        String searchString = txtSearch.getText();
        search(searchString);
    }//GEN-LAST:event_txtSearch1KeyReleased

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        String filterString = jComboBox3.getSelectedItem().toString();
        filter(filterString);
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jTable3jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3jTable1MouseClicked

        jTable1.setFocusable(true);
        editbutton.setEnabled(true);
        deletebutton.setEnabled(true);

    }//GEN-LAST:event_jTable3jTable1MouseClicked

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed

    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
        String searchString = jTextField1.getText();
        search(searchString);
    }//GEN-LAST:event_jTextField2KeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
        String filterString = jComboBox1.getSelectedItem().toString();
        filter(filterString);
    }//GEN-LAST:event_jComboBox4ActionPerformed

    private void transactiontableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transactiontableMouseClicked

    }//GEN-LAST:event_transactiontableMouseClicked

    private void issueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_issueMouseClicked
        jTabbedPane1.setSelectedIndex(5);

    }//GEN-LAST:event_issueMouseClicked

    private void issueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_issueActionPerformed
        jTabbedPane1.setSelectedIndex(5);
       

    }//GEN-LAST:event_issueActionPerformed

    private void returnsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_returnsMouseClicked
        jTabbedPane1.setSelectedIndex(8);

    }//GEN-LAST:event_returnsMouseClicked

    private void returnsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnsActionPerformed
        jTabbedPane1.setSelectedIndex(8);
        
    }//GEN-LAST:event_returnsActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        MessageFormat header = new MessageFormat("Records");
        MessageFormat footer = new MessageFormat("(0,number,integer)");
        try {
            PrintRequestAttributeSet set = new HashPrintRequestAttributeSet();
            set.add(OrientationRequested.PORTRAIT);
            jTable1.print(JTable.PrintMode.FIT_WIDTH, header, footer, true, set, true);
            JOptionPane.showMessageDialog(null, "\n" + "Downloaded Succesfully");
        } catch (java.awt.print.PrinterException e) {
            JOptionPane.showMessageDialog(null, "\n" + "Failed" + "\n" + e);
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed

    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyReleased
        String searchString = jTextField1.getText();
        search(searchString);
    }//GEN-LAST:event_jTextField3KeyReleased

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        ListSelectionModel selectionModel = jTable1.getSelectionModel();
        int rowCount = jTable1.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            selectionModel.addSelectionInterval(i, i);
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

        dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void A6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_A6MouseExited
        
    }//GEN-LAST:event_A6MouseExited

    private void A6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_A6MouseEntered

    }//GEN-LAST:event_A6MouseEntered

    private void A6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_A6MouseClicked
        Login lg = new Login();
        lg.setVisible(true);

        dispose();
    }//GEN-LAST:event_A6MouseClicked

    private void recMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recMousePressed

        
    }//GEN-LAST:event_recMousePressed

    private void recMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recMouseExited
        
    }//GEN-LAST:event_recMouseExited

    private void recMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recMouseEntered
        
    }//GEN-LAST:event_recMouseEntered

    private void recMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recMouseClicked
       jTabbedPane1.setSelectedIndex(4);
    }//GEN-LAST:event_recMouseClicked

    private void transMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transMousePressed

       
    }//GEN-LAST:event_transMousePressed

    private void transMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transMouseExited
      
    }//GEN-LAST:event_transMouseExited

    private void transMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transMouseEntered
       
    }//GEN-LAST:event_transMouseEntered

    private void transMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transMouseClicked
    jTabbedPane1.setSelectedIndex(3);
       
    }//GEN-LAST:event_transMouseClicked

    private void studentsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentsMousePressed

        
    }//GEN-LAST:event_studentsMousePressed

    private void studentsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentsMouseExited
       
    }//GEN-LAST:event_studentsMouseExited

    private void studentsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentsMouseEntered
      
    }//GEN-LAST:event_studentsMouseEntered

    private void studentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentsMouseClicked
    jTabbedPane1.setSelectedIndex(2);        
    }//GEN-LAST:event_studentsMouseClicked

    private void booksMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_booksMouseReleased

    }//GEN-LAST:event_booksMouseReleased

    private void booksMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_booksMousePressed

        
    }//GEN-LAST:event_booksMousePressed

    private void booksMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_booksMouseExited
       
    }//GEN-LAST:event_booksMouseExited

    private void booksMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_booksMouseEntered
       
    }//GEN-LAST:event_booksMouseEntered

    private void booksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_booksMouseClicked
    jTabbedPane1.setSelectedIndex(1);       
    }//GEN-LAST:event_booksMouseClicked

    private void dashMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashMouseReleased
       
    }//GEN-LAST:event_dashMouseReleased

    private void dashMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashMousePressed
        
    }//GEN-LAST:event_dashMousePressed

    private void dashMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashMouseExited

    }//GEN-LAST:event_dashMouseExited

    private void dashMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashMouseEntered
        
    }//GEN-LAST:event_dashMouseEntered

    private void dashMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashMouseClicked
    jTabbedPane1.setSelectedIndex(0);     
    }//GEN-LAST:event_dashMouseClicked

    private void txtStudentID1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStudentID1ActionPerformed
        
    }//GEN-LAST:event_txtStudentID1ActionPerformed

    private void txtStudentName1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStudentName1ActionPerformed
        
    }//GEN-LAST:event_txtStudentName1ActionPerformed

    private void txtGrSecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGrSecActionPerformed
        
    }//GEN-LAST:event_txtGrSecActionPerformed

    private void txtStrand1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStrand1ActionPerformed
        
    }//GEN-LAST:event_txtStrand1ActionPerformed

    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchActionPerformed
       jTabbedPane1.setSelectedIndex(6);
        
    }//GEN-LAST:event_SearchActionPerformed

    private void Search2Search1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Search2Search1ActionPerformed

        jTabbedPane1.setSelectedIndex(7);

    }//GEN-LAST:event_Search2Search1ActionPerformed

    private void txtBookID1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBookID1ActionPerformed
        
    }//GEN-LAST:event_txtBookID1ActionPerformed

    private void txtBookName1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBookName1ActionPerformed
        
    }//GEN-LAST:event_txtBookName1ActionPerformed

    private void txtAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAuthorActionPerformed
        
    }//GEN-LAST:event_txtAuthorActionPerformed

    private void txtQuantity1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantity1ActionPerformed
        
    }//GEN-LAST:event_txtQuantity1ActionPerformed

    private void txtGenre1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGenre1ActionPerformed
        
    }//GEN-LAST:event_txtGenre1ActionPerformed

    private void issuebook1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_issuebook1ActionPerformed
        String sql= "insert into issue(Student_ID,Student_Name,Strand,Grade_Section,Book_ID,Book_Name,Book_Author,Genre,Book_Quantity,Issue_Date,Due_Date,Date_Return,Status)values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try{
            pst= con.prepareStatement(sql);
            pst.setString(1, txtStudentID.getText());
            pst.setString(2, txtStudentName.getText());
            pst.setString(3, txtStrand.getSelectedItem().toString());
            pst.setString(4, txtGrSec.getText());
            pst.setString(5, txtBookID.getText());
            pst.setString(6, txtBookName.getText());
            pst.setString(7, txtAuthor.getText());
            pst.setString(8, txtGenre.getSelectedItem().toString());
            pst.setString(9, txtQuantity.getText());
            pst.setString(10, ((JTextField)txtIssueDate.getDateEditor().getUiComponent()).getText());
            pst.setString(11, ((JTextField)txtDueDate.getDateEditor().getUiComponent()).getText());
            pst.setString(12, "---");
            pst.setString(13, "---");
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Book Issued");
            TRANSACTION transaction = new TRANSACTION();
            transaction.transactiontableupdate();

        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        dispose();

    }//GEN-LAST:event_issuebook1ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        jTabbedPane1.setSelectedIndex(9);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void txtStudentID2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStudentID2ActionPerformed
       
    }//GEN-LAST:event_txtStudentID2ActionPerformed

    private void txtStudentName2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStudentName2ActionPerformed
        
    }//GEN-LAST:event_txtStudentName2ActionPerformed

    private void txtStrand2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStrand2ActionPerformed
       
    }//GEN-LAST:event_txtStrand2ActionPerformed

    private void txtGrSec1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGrSec1ActionPerformed
       
    }//GEN-LAST:event_txtGrSec1ActionPerformed

    private void txtIssueDate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIssueDate1ActionPerformed
        
    }//GEN-LAST:event_txtIssueDate1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Delete();
        ReturnUpdate();
        dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void txtBookName2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBookName2ActionPerformed
       
    }//GEN-LAST:event_txtBookName2ActionPerformed

    private void txtAuthor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAuthor1ActionPerformed
        
    }//GEN-LAST:event_txtAuthor1ActionPerformed

    private void txtQuantity2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantity2ActionPerformed
       
    }//GEN-LAST:event_txtQuantity2ActionPerformed

    private void txtBookID2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBookID2ActionPerformed
        
    }//GEN-LAST:event_txtBookID2ActionPerformed

    private void txtGenre2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGenre2ActionPerformed
        
    }//GEN-LAST:event_txtGenre2ActionPerformed

    private void txtDueDate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDueDate1ActionPerformed
       
    }//GEN-LAST:event_txtDueDate1ActionPerformed

    private void jTable5jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable5jTable1MouseClicked

    }//GEN-LAST:event_jTable5jTable1MouseClicked

    private void txtSearch2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearch2ActionPerformed

    }//GEN-LAST:event_txtSearch2ActionPerformed

    private void txtSearch2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearch2KeyReleased

    }//GEN-LAST:event_txtSearch2KeyReleased

    private void jTable6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable6MouseClicked

    }//GEN-LAST:event_jTable6MouseClicked

    private void txtSearch3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearch3ActionPerformed
        
    }//GEN-LAST:event_txtSearch3ActionPerformed

    private void txtSearch3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearch3KeyReleased

    }//GEN-LAST:event_txtSearch3KeyReleased

    private void findreturndetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_findreturndetailsMouseClicked

    }//GEN-LAST:event_findreturndetailsMouseClicked

    private void txtSearch4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearch4ActionPerformed

    }//GEN-LAST:event_txtSearch4ActionPerformed

    private void txtSearch4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearch4KeyReleased

    }//GEN-LAST:event_txtSearch4KeyReleased

    private void SearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchMouseClicked
        jTabbedPane1.setSelectedIndex(6);
    }//GEN-LAST:event_SearchMouseClicked

    private void Search2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Search2MouseClicked
        jTabbedPane1.setSelectedIndex(7);

    }//GEN-LAST:event_Search2MouseClicked

    private void jButton8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseClicked
        jTabbedPane1.setSelectedIndex(9);
    }//GEN-LAST:event_jButton8MouseClicked

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
            java.util.logging.Logger.getLogger(BOARD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BOARD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BOARD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BOARD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BOARD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel A6;
    private javax.swing.JButton Search;
    private javax.swing.JButton Search2;
    private javax.swing.JLabel a10;
    private javax.swing.JLabel a11;
    private javax.swing.JLabel a12;
    private javax.swing.JPanel a6;
    private javax.swing.JLabel a7;
    private javax.swing.JLabel a8;
    private javax.swing.JLabel a9;
    private javax.swing.JLabel addbutton;
    private javax.swing.JLabel addbutton1;
    private javax.swing.JPanel book;
    private javax.swing.JLabel books;
    private javax.swing.JLabel dash;
    private javax.swing.JPanel dashboard;
    private javax.swing.JLabel deletebutton;
    private javax.swing.JLabel deletebutton1;
    private javax.swing.JPanel details;
    private javax.swing.JLabel editbutton;
    private javax.swing.JLabel editbutton1;
    private javax.swing.JTable findreturndetails;
    private javax.swing.JButton issue;
    private javax.swing.JPanel issuebook;
    private javax.swing.JButton issuebook1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JComboBox<String> jComboBox7;
    private javax.swing.JComboBox<String> jComboBox8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JPanel managebook;
    private javax.swing.JPanel managestudent;
    private javax.swing.JLabel rec;
    private javax.swing.JPanel records;
    private javax.swing.JPanel returnbook;
    private javax.swing.JButton returns;
    private javax.swing.JPanel student;
    private javax.swing.JLabel students;
    private javax.swing.JPanel t1;
    private javax.swing.JPanel t2;
    private javax.swing.JPanel t3;
    private javax.swing.JPanel t4;
    private javax.swing.JPanel t5;
    private javax.swing.JLabel textadd;
    private javax.swing.JLabel textadd1;
    private javax.swing.JLabel trans;
    private javax.swing.JPanel transaction;
    private javax.swing.JTable transactiontable;
    private javax.swing.JTextField txtAuthor;
    private javax.swing.JTextField txtAuthor1;
    private javax.swing.JTextField txtBookAuthor;
    private javax.swing.JTextField txtBookID;
    private javax.swing.JTextField txtBookID1;
    private javax.swing.JTextField txtBookID2;
    private javax.swing.JTextField txtBookName;
    private javax.swing.JTextField txtBookName1;
    private javax.swing.JTextField txtBookName2;
    private com.toedter.calendar.JDateChooser txtDueDate;
    private javax.swing.JTextField txtDueDate1;
    private javax.swing.JComboBox<String> txtGenre;
    private javax.swing.JTextField txtGenre1;
    private javax.swing.JTextField txtGenre2;
    private javax.swing.JTextField txtGrSec;
    private javax.swing.JTextField txtGrSec1;
    private javax.swing.JComboBox<String> txtGrandSec;
    private com.toedter.calendar.JDateChooser txtIssueDate;
    private javax.swing.JTextField txtIssueDate1;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtQuantity1;
    private javax.swing.JTextField txtQuantity2;
    private com.toedter.calendar.JDateChooser txtReturnDate;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSearch1;
    private javax.swing.JTextField txtSearch2;
    private javax.swing.JTextField txtSearch3;
    private javax.swing.JTextField txtSearch4;
    private javax.swing.JComboBox<String> txtStrand;
    private javax.swing.JTextField txtStrand1;
    private javax.swing.JTextField txtStrand2;
    private javax.swing.JTextField txtStudentID;
    private javax.swing.JTextField txtStudentID1;
    private javax.swing.JTextField txtStudentID2;
    private javax.swing.JTextField txtStudentName;
    private javax.swing.JTextField txtStudentName1;
    private javax.swing.JTextField txtStudentName2;
    private javax.swing.JLabel txtedit;
    private javax.swing.JLabel txtedit1;
    private javax.swing.JLabel txtremove;
    private javax.swing.JLabel txtremove1;
    private javax.swing.JLabel txtupdate;
    private javax.swing.JLabel txtupdate1;
    private javax.swing.JLabel updatebutton;
    private javax.swing.JLabel updatebutton1;
    // End of variables declaration//GEN-END:variables
}
