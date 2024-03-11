
package ginto;



import java.awt.Color;
import  java.sql.*;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.RowFilter;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;




public class HomePage extends javax.swing.JFrame {

    
    
   
    
    public HomePage() {
        initComponents();   
        Connect();
        book_count();
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
            Logger.getLogger(DASHBOARD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DASHBOARD.class.getName()).log(Level.SEVERE, null, ex);
        }
    
     }
    
     public void search(String str) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
        jTable1.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter("(?i)" + str));
    }
      public void filter(String str) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
           TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
           jTable1.setRowSorter(trs);
           trs.setRowFilter(RowFilter.regexFilter(str));
    }
      

      private void book_count()
      {
          try {
              pst = (PreparedStatement) con.prepareStatement("SELECT COUNT(*) AS bookCount from books");
              ResultSet Rs = pst.executeQuery();
              
              while (Rs.next())
              {
                  int bcount = Rs.getInt("bookCount");
                  jLabel3.setText(String.valueOf(bcount));
                  
              }
          }catch (Exception e) {
              e.printStackTrace();
              {
                  
              }
          }
      }
     

     
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Header = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        a7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        Side = new javax.swing.JPanel();
        menu = new javax.swing.JPanel();
        t1 = new javax.swing.JPanel();
        a1 = new javax.swing.JLabel();
        t2 = new javax.swing.JPanel();
        a2 = new javax.swing.JLabel();
        t3 = new javax.swing.JPanel();
        a3 = new javax.swing.JLabel();
        t4 = new javax.swing.JPanel();
        a4 = new javax.swing.JLabel();
        t5 = new javax.swing.JPanel();
        a5 = new javax.swing.JLabel();
        a6 = new javax.swing.JPanel();
        A6 = new javax.swing.JLabel();
        A1 = new javax.swing.JPanel();
        A9 = new javax.swing.JDesktopPane();
        A2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox<>();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        Header.setBackground(new java.awt.Color(255, 255, 255));
        Header.setPreferredSize(new java.awt.Dimension(1185, 100));
        Header.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(0, 0, 51));

        jButton7.setBackground(new java.awt.Color(255, 0, 0));
        jButton7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/2.png"))); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(71, Short.MAX_VALUE)
                .addComponent(jButton7)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton7)
                .addContainerGap(78, Short.MAX_VALUE))
        );

        Header.add(jPanel2, java.awt.BorderLayout.LINE_END);

        jPanel3.setBackground(new java.awt.Color(0, 0, 51));
        jPanel3.setForeground(new java.awt.Color(19, 22, 40));

        a7.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        a7.setForeground(new java.awt.Color(255, 255, 255));
        a7.setText("DASHBOARD");

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("LIBRARY MANAGEMENT SYSTEM");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-school-50.png"))); // NOI18N

        jPanel6.setBackground(new java.awt.Color(31, 25, 60));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1090, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 219, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(a7, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(a7, javax.swing.GroupLayout.PREFERRED_SIZE, 42, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Header.add(jPanel3, java.awt.BorderLayout.CENTER);

        getContentPane().add(Header, java.awt.BorderLayout.PAGE_START);

        Side.setBackground(new java.awt.Color(255, 255, 255));
        Side.setForeground(new java.awt.Color(255, 255, 255));
        Side.setPreferredSize(new java.awt.Dimension(180, 817));
        Side.setLayout(new java.awt.BorderLayout());

        menu.setBackground(new java.awt.Color(0, 0, 51));
        menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t1.setBackground(new java.awt.Color(0, 5, 87));

        a1.setBackground(new java.awt.Color(0, 0, 153));
        a1.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        a1.setForeground(new java.awt.Color(255, 255, 255));
        a1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        a1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/dash-removebg-preview.png"))); // NOI18N
        a1.setText("DASHBOARD");
        a1.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 0, 3, 0, new java.awt.Color(102, 102, 102)));
        a1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                a1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                a1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                a1MousePressed(evt);
            }
        });

        javax.swing.GroupLayout t1Layout = new javax.swing.GroupLayout(t1);
        t1.setLayout(t1Layout);
        t1Layout.setHorizontalGroup(
            t1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a1, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
        );
        t1Layout.setVerticalGroup(
            t1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a1, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );

        menu.add(t1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 180, 80));

        t2.setBackground(new java.awt.Color(0, 5, 87));

        a2.setBackground(new java.awt.Color(0, 5, 87));
        a2.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        a2.setForeground(new java.awt.Color(255, 255, 255));
        a2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        a2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/book-removebg-preview.png"))); // NOI18N
        a2.setText("MANAGE BOOKS");
        a2.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 0, 3, 0, new java.awt.Color(102, 102, 102)));
        a2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                a2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                a2MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                a2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                a2MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout t2Layout = new javax.swing.GroupLayout(t2);
        t2.setLayout(t2Layout);
        t2Layout.setHorizontalGroup(
            t2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a2, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
        );
        t2Layout.setVerticalGroup(
            t2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a2, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );

        menu.add(t2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 180, 80));

        t3.setBackground(new java.awt.Color(0, 5, 87));

        a3.setBackground(new java.awt.Color(0, 5, 87));
        a3.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        a3.setForeground(new java.awt.Color(255, 255, 255));
        a3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        a3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/student-removebg-preview.png"))); // NOI18N
        a3.setText("MANAGE STUDENTS");
        a3.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 0, 3, 0, new java.awt.Color(102, 102, 102)));
        a3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                a3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                a3MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                a3MousePressed(evt);
            }
        });

        javax.swing.GroupLayout t3Layout = new javax.swing.GroupLayout(t3);
        t3.setLayout(t3Layout);
        t3Layout.setHorizontalGroup(
            t3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a3, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
        );
        t3Layout.setVerticalGroup(
            t3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a3, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );

        menu.add(t3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 180, 80));

        t4.setBackground(new java.awt.Color(0, 5, 87));

        a4.setBackground(new java.awt.Color(0, 5, 87));
        a4.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        a4.setForeground(new java.awt.Color(255, 255, 255));
        a4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        a4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/trans-removebg-preview.png"))); // NOI18N
        a4.setText("TRANSACTION");
        a4.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 0, 3, 0, new java.awt.Color(102, 102, 102)));
        a4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                a4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                a4MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                a4MousePressed(evt);
            }
        });

        javax.swing.GroupLayout t4Layout = new javax.swing.GroupLayout(t4);
        t4.setLayout(t4Layout);
        t4Layout.setHorizontalGroup(
            t4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a4, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
        );
        t4Layout.setVerticalGroup(
            t4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a4, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );

        menu.add(t4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 180, 80));

        t5.setBackground(new java.awt.Color(0, 5, 87));

        a5.setBackground(new java.awt.Color(255, 255, 255));
        a5.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        a5.setForeground(new java.awt.Color(255, 255, 255));
        a5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        a5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/rec-removebg-preview.png"))); // NOI18N
        a5.setText("RECORDS");
        a5.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 0, 3, 0, new java.awt.Color(102, 102, 102)));
        a5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                a5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                a5MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                a5MousePressed(evt);
            }
        });

        javax.swing.GroupLayout t5Layout = new javax.swing.GroupLayout(t5);
        t5.setLayout(t5Layout);
        t5Layout.setHorizontalGroup(
            t5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a5, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
        );
        t5Layout.setVerticalGroup(
            t5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a5, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );

        menu.add(t5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 180, 80));

        a6.setBackground(new java.awt.Color(0, 0, 51));

        A6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        A6.setForeground(new java.awt.Color(255, 255, 255));
        A6.setText("Log out");
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
                .addComponent(A6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        a6Layout.setVerticalGroup(
            a6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(A6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        menu.add(a6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 620, 50, -1));

        Side.add(menu, java.awt.BorderLayout.LINE_END);

        getContentPane().add(Side, java.awt.BorderLayout.LINE_START);

        A1.setBackground(new java.awt.Color(0, 0, 204));
        A1.setOpaque(false);
        A1.setLayout(new java.awt.BorderLayout());

        A2.setBackground(new java.awt.Color(31, 25, 60));
        A2.setPreferredSize(new java.awt.Dimension(1192, 799));

        jPanel4.setBackground(new java.awt.Color(19, 22, 40));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("TOTAL BOOKS");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 40));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("100");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 70, 50));

        jPanel5.setBackground(new java.awt.Color(19, 22, 40));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("ISSUED BOOKS");
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 200, 40));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("559");
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, -1, 60));

        jPanel7.setBackground(new java.awt.Color(19, 22, 40));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("AVAILABLE BOOKS");
        jPanel7.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 40));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("459");
        jPanel7.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, -1, 60));

        jPanel8.setBackground(new java.awt.Color(19, 22, 40));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("OVERDUE");
        jPanel8.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 180, 40));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("599");
        jPanel8.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, -1, 60));

        jTextField1.setBackground(new java.awt.Color(31, 25, 60));
        jTextField1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 255, 255)));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/1w.png"))); // NOI18N

        jTable1.setBackground(new java.awt.Color(255, 255, 255));
        jTable1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable1.setForeground(new java.awt.Color(0, 0, 0));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
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
        jTable1.getTableHeader().setResizingAllowed(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(20);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(250);
        }

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "ABM", "HUMSS", "ICT", "General Reference", "Fiction", "Core Subject" }));

        javax.swing.GroupLayout A2Layout = new javax.swing.GroupLayout(A2);
        A2.setLayout(A2Layout);
        A2Layout.setHorizontalGroup(
            A2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(A2Layout.createSequentialGroup()
                .addGroup(A2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(A2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2))
                    .addGroup(A2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(A2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(A2Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(A2Layout.createSequentialGroup()
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)))))
                .addContainerGap())
        );
        A2Layout.setVerticalGroup(
            A2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(A2Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(A2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, A2Layout.createSequentialGroup()
                        .addGroup(A2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)))
                .addGap(7, 7, 7)
                .addGroup(A2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(A2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        A9.setLayer(A2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout A9Layout = new javax.swing.GroupLayout(A9);
        A9.setLayout(A9Layout);
        A9Layout.setHorizontalGroup(
            A9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1186, Short.MAX_VALUE)
            .addGroup(A9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(A2, javax.swing.GroupLayout.DEFAULT_SIZE, 1186, Short.MAX_VALUE))
        );
        A9Layout.setVerticalGroup(
            A9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 701, Short.MAX_VALUE)
            .addGroup(A9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(A2, javax.swing.GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE))
        );

        A1.add(A9, java.awt.BorderLayout.CENTER);

        getContentPane().add(A1, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(1366, 801));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void setColor (JPanel p)
    {
        p.setBackground(new Color(0,0,153));
    }
    
     public void resetColor (JPanel p1)
    {
        p1.setBackground(new Color(0,5,87));
    }
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        
         dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void a5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a5MouseClicked
        RECORDS a5=new RECORDS();
        A9.removeAll();
        A9.add(a5).setVisible(true);
    }//GEN-LAST:event_a5MouseClicked

    private void a5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a5MousePressed
       
        a7.setText("RECORDS");
    }//GEN-LAST:event_a5MousePressed

    private void a3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a3MousePressed
       
        a7.setText("MANAGE STUDENTS");
    }//GEN-LAST:event_a3MousePressed

    private void a3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a3MouseClicked
          MANAGESTUDENT a3=new MANAGESTUDENT();
        A9.removeAll();
        A9.add(a3).setVisible(true);

    }//GEN-LAST:event_a3MouseClicked

    private void a1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a1MouseClicked
        DASHBOARD a1=new DASHBOARD();
         A9.removeAll();
         A9.add(a1).setVisible(true);
    }//GEN-LAST:event_a1MouseClicked

    private void a1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a1MousePressed
       a7.setText("DASHBOARD");
    }//GEN-LAST:event_a1MousePressed

    private void a1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a1MouseEntered
         setColor(t1);        
    }//GEN-LAST:event_a1MouseEntered

    private void a1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a1MouseExited
         resetColor(t1); 
    }//GEN-LAST:event_a1MouseExited

    private void a4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a4MouseClicked
        
        TRANSACTION a4=new TRANSACTION();
         A9.removeAll();
         A9.add(a4).setVisible(true);
    }//GEN-LAST:event_a4MouseClicked

    private void a4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a4MousePressed

       a7.setText("TRANSACTION");
    }//GEN-LAST:event_a4MousePressed

    private void a2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a2MouseReleased
        
    }//GEN-LAST:event_a2MouseReleased

    private void a2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a2MousePressed
        
        a7.setText("MANAGE BOOKS");
    }//GEN-LAST:event_a2MousePressed

    private void a2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a2MouseClicked
        MANAGEBOOK a2=new MANAGEBOOK();
        A9.removeAll();
        A9.add(a2).setVisible(true);
    }//GEN-LAST:event_a2MouseClicked

    private void A6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_A6MouseClicked
         Login lg = new Login();
        lg.setVisible(true);

        dispose();
    }//GEN-LAST:event_A6MouseClicked

    private void a2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a2MouseEntered
         setColor(t2);
    }//GEN-LAST:event_a2MouseEntered

    private void a2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a2MouseExited
        resetColor(t2); 
    }//GEN-LAST:event_a2MouseExited

    private void a3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a3MouseEntered
         setColor(t3);
    }//GEN-LAST:event_a3MouseEntered

    private void a3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a3MouseExited
         resetColor(t3);
    }//GEN-LAST:event_a3MouseExited

    private void a4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a4MouseEntered
         setColor(t4);
    }//GEN-LAST:event_a4MouseEntered

    private void a4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a4MouseExited
         resetColor(t4);
    }//GEN-LAST:event_a4MouseExited

    private void a5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a5MouseEntered
         setColor(t5);
    }//GEN-LAST:event_a5MouseEntered

    private void a5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a5MouseExited
        resetColor(t5);
    }//GEN-LAST:event_a5MouseExited

    private void A6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_A6MouseEntered
       setColor(a6);
    }//GEN-LAST:event_A6MouseEntered

    private void A6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_A6MouseExited
       resetColor(a6);
    }//GEN-LAST:event_A6MouseExited

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed

    }//GEN-LAST:event_jTextField1ActionPerformed

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
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel A1;
    private javax.swing.JPanel A2;
    private javax.swing.JLabel A6;
    private javax.swing.JDesktopPane A9;
    private javax.swing.JPanel Header;
    private javax.swing.JPanel Side;
    private javax.swing.JLabel a1;
    private javax.swing.JLabel a2;
    private javax.swing.JLabel a3;
    private javax.swing.JLabel a4;
    private javax.swing.JLabel a5;
    private javax.swing.JPanel a6;
    private javax.swing.JLabel a7;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel menu;
    private javax.swing.JPanel t1;
    private javax.swing.JPanel t2;
    private javax.swing.JPanel t3;
    private javax.swing.JPanel t4;
    private javax.swing.JPanel t5;
    // End of variables declaration//GEN-END:variables
}
