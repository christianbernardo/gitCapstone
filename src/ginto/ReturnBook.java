
package ginto;

import java.awt.Component;
import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;




public class ReturnBook extends javax.swing.JFrame {

    
    public ReturnBook() {
       initComponents();
       Connect(); 
       table_update();
        

       
       
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
            Logger.getLogger(ReturnBook.class.getName()).log(Level.SEVERE, null, ex);
        }catch (SQLException ex) {
            Logger.getLogger(ReturnBook.class.getName()).log(Level.SEVERE, null, ex);
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
            pst.setString(3, txtStrand.getText());
            pst.setString(4, txtGrSec.getText());
            pst.setString(5, txtBookID.getText());
            pst.setString(6, txtBookName.getText());
            pst.setString(7, txtAuthor.getText());
            pst.setString(8, txtGenre.getText());
            pst.setString(9, txtQuantity.getText());
            pst.setString(10, txtIssueDate.getText());
            pst.setString(11, txtDueDate.getText());
            pst.setString(12, ((JTextField)txtReturnDate.getDateEditor().getUiComponent()).getText());
            pst.setString(13, "Returned");

            pst.execute();
            JOptionPane.showMessageDialog(null, "Book Returned");
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
    public void resizeColumnWidth(JTable findreturndetails) {
    final TableColumnModel columnModel = findreturndetails.getColumnModel();
    for (int column = 0; column < findreturndetails.getColumnCount(); column++) {
        int width = 15; 
        for (int row = 0; row < findreturndetails.getRowCount(); row++) {
            TableCellRenderer renderer = findreturndetails.getCellRenderer(row, column);
            Component comp = findreturndetails.prepareRenderer(renderer, row, column);
            width = Math.max(comp.getPreferredSize().width +1 , width);
        }
        if(width > 300)
            width=300;
        columnModel.getColumn(column).setPreferredWidth(width);
    }
}
    
    
    
   
    
    
    
    
    private void table_update()
    {
        int CC;
        try {
            
            pst = con.prepareStatement("SELECT * FROM issue");
            ResultSet Rs = pst.executeQuery();
            
            ResultSetMetaData RSMD = Rs.getMetaData();
            CC = RSMD.getColumnCount();
            DefaultTableModel DFT = (DefaultTableModel) findreturndetails.getModel();
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

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtStudentName = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtGrSec = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtBookName = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtAuthor = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtReturnDate = new com.toedter.calendar.JDateChooser();
        txtBookID = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtGenre = new javax.swing.JTextField();
        txtDueDate = new javax.swing.JTextField();
        txtStudentID = new javax.swing.JTextField();
        txtStrand = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtIssueDate = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        findreturndetails = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 950, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 40));

        jPanel4.setBackground(new java.awt.Color(102, 102, 102));

        jPanel2.setBackground(new java.awt.Color(0, 0, 51));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(102, 102, 102)));
        jPanel2.setPreferredSize(new java.awt.Dimension(350, 500));
        jPanel2.setLayout(null);

        jButton7.setBackground(new java.awt.Color(255, 0, 0));
        jButton7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Search");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton7);
        jButton7.setBounds(360, 200, 72, 23);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Return");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(170, 40, 124, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-return-book-100.png"))); // NOI18N
        jPanel2.add(jLabel1);
        jLabel1.setBounds(180, 90, 101, 101);

        jButton1.setBackground(new java.awt.Color(204, 0, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Return");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(180, 530, 124, 29);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Student ID :");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(20, 190, 67, 16);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Student Name :");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(20, 250, 87, 30);

        txtStudentName.setBackground(new java.awt.Color(0, 0, 51));
        txtStudentName.setForeground(new java.awt.Color(255, 255, 255));
        txtStudentName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtStudentName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStudentNameActionPerformed(evt);
            }
        });
        jPanel2.add(txtStudentName);
        txtStudentName.setBounds(20, 280, 430, 35);

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Issue Date:");
        jPanel2.add(jLabel13);
        jLabel13.setBounds(20, 460, 61, 16);

        txtGrSec.setBackground(new java.awt.Color(0, 0, 51));
        txtGrSec.setForeground(new java.awt.Color(255, 255, 255));
        txtGrSec.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtGrSec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGrSecActionPerformed(evt);
            }
        });
        jPanel2.add(txtGrSec);
        txtGrSec.setBounds(20, 420, 430, 35);

        jPanel7.setBackground(new java.awt.Color(0, 0, 51));
        jPanel7.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 0, new java.awt.Color(102, 102, 102)));
        jPanel7.setPreferredSize(new java.awt.Dimension(350, 500));
        jPanel7.setLayout(null);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Details");
        jPanel7.add(jLabel9);
        jLabel9.setBounds(180, 40, 126, 44);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-view-details-100.png"))); // NOI18N
        jPanel7.add(jLabel10);
        jLabel10.setBounds(190, 90, 101, 101);

        jButton6.setBackground(new java.awt.Color(204, 0, 0));
        jButton6.setForeground(new java.awt.Color(0, 0, 0));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/2.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton6);
        jButton6.setBounds(440, 10, 20, 20);

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Book ID :");
        jPanel7.add(jLabel15);
        jLabel15.setBounds(20, 200, 51, 16);

        jLabel16.setBackground(new java.awt.Color(153, 153, 255));
        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Book Name :");
        jPanel7.add(jLabel16);
        jLabel16.setBounds(20, 260, 71, 16);

        txtBookName.setBackground(new java.awt.Color(0, 0, 51));
        txtBookName.setForeground(new java.awt.Color(255, 255, 255));
        txtBookName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtBookName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBookNameActionPerformed(evt);
            }
        });
        jPanel7.add(txtBookName);
        txtBookName.setBounds(20, 280, 430, 35);

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Author :");
        jPanel7.add(jLabel17);
        jLabel17.setBounds(20, 320, 45, 16);

        txtAuthor.setBackground(new java.awt.Color(0, 0, 51));
        txtAuthor.setForeground(new java.awt.Color(255, 255, 255));
        txtAuthor.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAuthorActionPerformed(evt);
            }
        });
        jPanel7.add(txtAuthor);
        txtAuthor.setBounds(20, 340, 430, 35);

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Quantity :");
        jPanel7.add(jLabel18);
        jLabel18.setBounds(20, 440, 54, 16);

        txtQuantity.setBackground(new java.awt.Color(0, 0, 51));
        txtQuantity.setForeground(new java.awt.Color(255, 255, 255));
        txtQuantity.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuantityActionPerformed(evt);
            }
        });
        jPanel7.add(txtQuantity);
        txtQuantity.setBounds(20, 460, 430, 35);

        jLabel19.setBackground(new java.awt.Color(153, 153, 255));
        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Due Date :");
        jPanel7.add(jLabel19);
        jLabel19.setBounds(20, 500, 80, 16);
        jPanel7.add(txtReturnDate);
        txtReturnDate.setBounds(30, 570, 240, 30);

        txtBookID.setBackground(new java.awt.Color(0, 0, 51));
        txtBookID.setForeground(new java.awt.Color(255, 255, 255));
        txtBookID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtBookID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBookIDActionPerformed(evt);
            }
        });
        jPanel7.add(txtBookID);
        txtBookID.setBounds(20, 220, 430, 35);

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Genre ;");
        jPanel7.add(jLabel20);
        jLabel20.setBounds(20, 380, 41, 16);

        txtGenre.setBackground(new java.awt.Color(0, 0, 51));
        txtGenre.setForeground(new java.awt.Color(255, 255, 255));
        txtGenre.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtGenre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGenreActionPerformed(evt);
            }
        });
        jPanel7.add(txtGenre);
        txtGenre.setBounds(20, 400, 430, 35);

        txtDueDate.setBackground(new java.awt.Color(0, 0, 51));
        txtDueDate.setForeground(new java.awt.Color(255, 255, 255));
        txtDueDate.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtDueDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDueDateActionPerformed(evt);
            }
        });
        jPanel7.add(txtDueDate);
        txtDueDate.setBounds(20, 530, 430, 30);

        jPanel2.add(jPanel7);
        jPanel7.setBounds(470, 0, 470, 610);

        txtStudentID.setBackground(new java.awt.Color(0, 0, 51));
        txtStudentID.setForeground(new java.awt.Color(255, 255, 255));
        txtStudentID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtStudentID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStudentIDActionPerformed(evt);
            }
        });
        jPanel2.add(txtStudentID);
        txtStudentID.setBounds(20, 210, 430, 36);

        txtStrand.setBackground(new java.awt.Color(0, 0, 51));
        txtStrand.setForeground(new java.awt.Color(255, 255, 255));
        txtStrand.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtStrand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStrandActionPerformed(evt);
            }
        });
        jPanel2.add(txtStrand);
        txtStrand.setBounds(20, 350, 430, 35);

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Strand");
        jPanel2.add(jLabel14);
        jLabel14.setBounds(20, 320, 37, 30);

        txtIssueDate.setBackground(new java.awt.Color(0, 0, 51));
        txtIssueDate.setForeground(new java.awt.Color(255, 255, 255));
        txtIssueDate.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtIssueDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIssueDateActionPerformed(evt);
            }
        });
        jPanel2.add(txtIssueDate);
        txtIssueDate.setBounds(20, 480, 430, 30);

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Gr. & Sec.  :");
        jPanel2.add(jLabel21);
        jLabel21.setBounds(20, 390, 65, 16);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 945, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 39, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("RETURN", jPanel4);

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
        jScrollPane1.setViewportView(findreturndetails);
        if (findreturndetails.getColumnModel().getColumnCount() > 0) {
            findreturndetails.getColumnModel().getColumn(0).setPreferredWidth(50);
            findreturndetails.getColumnModel().getColumn(1).setPreferredWidth(50);
            findreturndetails.getColumnModel().getColumn(3).setPreferredWidth(50);
            findreturndetails.getColumnModel().getColumn(4).setPreferredWidth(50);
            findreturndetails.getColumnModel().getColumn(5).setPreferredWidth(50);
            findreturndetails.getColumnModel().getColumn(7).setPreferredWidth(50);
            findreturndetails.getColumnModel().getColumn(8).setPreferredWidth(50);
            findreturndetails.getColumnModel().getColumn(9).setPreferredWidth(50);
            findreturndetails.getColumnModel().getColumn(10).setPreferredWidth(50);
        }

        jButton3.setText("FIND");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(415, 415, 415)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(418, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("DETAILS", jPanel5);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 690));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(945, 646));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtGrSecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGrSecActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGrSecActionPerformed

    private void txtStudentNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStudentNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStudentNameActionPerformed

    private void txtStudentIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStudentIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStudentIDActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Delete();
        ReturnUpdate();
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void txtBookIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBookIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBookIDActionPerformed

    private void txtBookNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBookNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBookNameActionPerformed

    private void txtAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAuthorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAuthorActionPerformed

    private void txtQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuantityActionPerformed

    private void txtIssueDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIssueDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIssueDateActionPerformed

    private void findreturndetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_findreturndetailsMouseClicked
        
    }//GEN-LAST:event_findreturndetailsMouseClicked

    private void txtStrandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStrandActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStrandActionPerformed

    private void txtGenreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGenreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGenreActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        DefaultTableModel model = (DefaultTableModel) findreturndetails.getModel();
        int SelectedRows = findreturndetails.convertRowIndexToModel( findreturndetails.getSelectedRow() );  
        
        txtStudentID.setText(model.getValueAt(SelectedRows, 0).toString());
        txtStudentName.setText(model.getValueAt(SelectedRows, 1).toString());
        txtStrand.setText(model.getValueAt(SelectedRows, 2).toString());
        txtGrSec.setText(model.getValueAt(SelectedRows, 3).toString());
        txtBookID.setText(model.getValueAt(SelectedRows, 4).toString());
        txtBookName.setText(model.getValueAt(SelectedRows, 5).toString());
        txtAuthor.setText(model.getValueAt(SelectedRows, 6).toString());
        txtGenre.setText(model.getValueAt(SelectedRows, 7).toString());
        txtQuantity.setText(model.getValueAt(SelectedRows, 8).toString());
        txtIssueDate.setText(model.getValueAt(SelectedRows, 9).toString());
        txtDueDate.setText(model.getValueAt(SelectedRows, 10).toString());
        
        
        
        
         jTabbedPane1.setSelectedIndex(0);
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtDueDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDueDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDueDateActionPerformed
      
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
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReturnBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable findreturndetails;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
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
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField txtAuthor;
    private javax.swing.JTextField txtBookID;
    private javax.swing.JTextField txtBookName;
    private javax.swing.JTextField txtDueDate;
    private javax.swing.JTextField txtGenre;
    private javax.swing.JTextField txtGrSec;
    private javax.swing.JTextField txtIssueDate;
    private javax.swing.JTextField txtQuantity;
    private com.toedter.calendar.JDateChooser txtReturnDate;
    private javax.swing.JTextField txtStrand;
    private javax.swing.JTextField txtStudentID;
    private javax.swing.JTextField txtStudentName;
    // End of variables declaration//GEN-END:variables

   
}
