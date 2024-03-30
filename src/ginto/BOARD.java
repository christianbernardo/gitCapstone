package ginto;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.text.MessageFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.OrientationRequested;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

public class BOARD extends javax.swing.JFrame {

    public BOARD() {
        initComponents();
        Connect();
        booktable_update();
        stud_table_update();
        transactiontableupdate();
        recordstable_update();
        return_details();
        studenttable_update();
        issuebooktable_update();
        book_count();
        student_count();
        issue_count();
        return_count();

        setBackground(new Color(0, 0, 0, 0));

        db_table.getTableHeader().setFont(new Font("Century Gothic", Font.BOLD, 12));
        db_table.getTableHeader().setOpaque(false);
        db_table.getTableHeader().setBackground(new Color(19, 22, 40));
        db_table.getTableHeader().setForeground(new Color(0, 0, 0));
        db_table.setRowHeight(25);

        manageb_table.getTableHeader().setFont(new Font("Century Gothic", Font.BOLD, 12));
        manageb_table.getTableHeader().setOpaque(false);
        manageb_table.getTableHeader().setBackground(new Color(19, 22, 40));
        manageb_table.getTableHeader().setForeground(new Color(0, 0, 0));
        manageb_table.setRowHeight(25);

        studtable.getTableHeader().setFont(new Font("Century Gothic", Font.BOLD, 12));
        studtable.getTableHeader().setOpaque(false);
        studtable.getTableHeader().setBackground(new Color(19, 22, 40));
        studtable.getTableHeader().setForeground(new Color(0, 0, 0));
        studtable.setRowHeight(25);

        transactiontable.getTableHeader().setFont(new Font("Century Gothic", Font.BOLD, 12));
        transactiontable.getTableHeader().setOpaque(false);
        transactiontable.getTableHeader().setBackground(new Color(19, 22, 40));
        transactiontable.getTableHeader().setForeground(new Color(0, 0, 0));
        transactiontable.setRowHeight(25);

        recordstable.getTableHeader().setFont(new Font("Century Gothic", Font.BOLD, 12));
        recordstable.getTableHeader().setOpaque(false);
        recordstable.getTableHeader().setBackground(new Color(19, 22, 40));
        recordstable.getTableHeader().setForeground(new Color(0, 0, 0));
        recordstable.setRowHeight(25);

        issuestudlist.getTableHeader().setFont(new Font("Century Gothic", Font.BOLD, 12));
        issuestudlist.getTableHeader().setOpaque(false);
        issuestudlist.getTableHeader().setBackground(new Color(19, 22, 40));
        issuestudlist.getTableHeader().setForeground(new Color(0, 0, 0));
        issuestudlist.setRowHeight(25);

        issuebooklist.getTableHeader().setFont(new Font("Century Gothic", Font.BOLD, 12));
        issuebooklist.getTableHeader().setOpaque(false);
        issuebooklist.getTableHeader().setBackground(new Color(19, 22, 40));
        issuebooklist.getTableHeader().setForeground(new Color(0, 0, 0));
        issuebooklist.setRowHeight(25);

        findreturndetails.getTableHeader().setFont(new Font("Century Gothic", Font.BOLD, 12));
        findreturndetails.getTableHeader().setOpaque(false);
        findreturndetails.getTableHeader().setBackground(new Color(19, 22, 40));
        findreturndetails.getTableHeader().setForeground(new Color(0, 0, 0));
        findreturndetails.setRowHeight(25);

    }

    Connection con;
    PreparedStatement pst;
    DefaultTableModel model;

    public void Connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/data", "root", "");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BOARD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BOARD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void booktable_update() {
        int CC;
        try {

            pst = con.prepareStatement("SELECT * FROM books");
            ResultSet Rs = pst.executeQuery();

            ResultSetMetaData RSMD = Rs.getMetaData();
            CC = RSMD.getColumnCount();
            DefaultTableModel DFT = (DefaultTableModel) manageb_table.getModel();
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
        } catch (Exception e) {

        }
    }

    private void stud_table_update() {
        int CC;
        try {

            pst = con.prepareStatement("SELECT * FROM students");
            ResultSet Rs = pst.executeQuery();

            ResultSetMetaData RSMD = Rs.getMetaData();
            CC = RSMD.getColumnCount();
            DefaultTableModel DFT = (DefaultTableModel) studtable.getModel();
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
        } catch (Exception e) {

        }
    }

    private void issuebooktable_update() {
        int CC;
        try {

            pst = con.prepareStatement("SELECT * FROM books");
            ResultSet Rs = pst.executeQuery();

            ResultSetMetaData RSMD = Rs.getMetaData();
            CC = RSMD.getColumnCount();
            DefaultTableModel DFT = (DefaultTableModel) issuebooklist.getModel();
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
        } catch (Exception e) {

        }
    }

    public void transactiontableupdate() {
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
        } catch (Exception e) {

        }
    }

    private void recordstable_update() {
        int CC;
        try {

            pst = con.prepareStatement("SELECT * FROM returnbook");
            ResultSet Rs = pst.executeQuery();

            ResultSetMetaData RSMD = Rs.getMetaData();
            CC = RSMD.getColumnCount();
            DefaultTableModel DFT = (DefaultTableModel) recordstable.getModel();
            DFT.setRowCount(0);

            while (Rs.next()) {
                Vector v2 = new Vector();

                for (int ii = 1; ii <= CC; ii++) {
                    v2.add(Rs.getString("student_id"));
                    v2.add(Rs.getString("student_name"));
                    v2.add(Rs.getString("strand"));
                    v2.add(Rs.getString("grade_section"));
                    v2.add(Rs.getString("book_id"));
                    v2.add(Rs.getString("book_name"));
                    v2.add(Rs.getString("book_author"));
                    v2.add(Rs.getString("genre"));
                    v2.add(Rs.getString("book_quantity"));
                    v2.add(Rs.getString("issue_date"));
                    v2.add(Rs.getString("due_date"));
                    v2.add(Rs.getString("return_date"));
                    v2.add(Rs.getString("status"));

                }
                DFT.addRow(v2);
            }
        } catch (Exception e) {
        }
    }

    private void return_details() {
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
        } catch (Exception e) {

        }
    }

    private void studenttable_update() {
        int CC;
        try {

            pst = con.prepareStatement("SELECT * FROM students");
            ResultSet Rs = pst.executeQuery();

            ResultSetMetaData RSMD = Rs.getMetaData();
            CC = RSMD.getColumnCount();
            DefaultTableModel DFT = (DefaultTableModel) issuestudlist.getModel();
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
        } catch (Exception e) {

        }
    }

    public void Delete() {
        String sql = "delete from issue where Student_ID=?";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, returnstudid.getText());
            pst.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void ReturnUpdate() {
        String sql = "insert into returnbook(student_id,student_name,strand,grade_section,book_id,book_name,book_author,genre,book_quantity,issue_date,due_date,return_date,status)values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, returnstudid.getText());
            pst.setString(2, returnstudnm.getText());
            pst.setString(3, returnstudstr.getText());
            pst.setString(4, returnstudgrsec.getText());
            pst.setString(5, returnbookid.getText());
            pst.setString(6, returnbooknm.getText());
            pst.setString(7, returnbookau.getText());
            pst.setString(8, returnbookgnr.getText());
            pst.setString(9, returnbookqua.getText());
            pst.setString(10, returnissudate.getText());
            pst.setString(11, returnduedate.getText());
            pst.setString(12, ((JTextField) return_datereturned.getDateEditor().getUiComponent()).getText());
            pst.setString(13, "Returned");

            pst.execute();
            JOptionPane.showMessageDialog(null, "Book Returned");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void book_count() {
        try {
            pst = con.prepareStatement("SELECT COUNT(*) AS bookCount from books");
            ResultSet Rs = pst.executeQuery();

            while (Rs.next()) {
                int bcount = Rs.getInt("bookcount");
                bookcount.setText(String.valueOf(bcount));

            }
        } catch (Exception e) {
            e.printStackTrace();
            {

            }
        }

    }

    private void student_count() {
        try {
            pst = con.prepareStatement("SELECT COUNT(*) AS studentCount from students");
            ResultSet Rs = pst.executeQuery();

            while (Rs.next()) {
                int scount = Rs.getInt("studentcount");
                studentcount.setText(String.valueOf(scount));

            }
        } catch (Exception e) {
            e.printStackTrace();
            {

            }
        }

    }

    private void issue_count() {
        try {
            pst = con.prepareStatement("SELECT COUNT(*) AS issueCount from issue");
            ResultSet Rs = pst.executeQuery();

            while (Rs.next()) {
                int icount = Rs.getInt("issuecount");
                issuedbcount.setText(String.valueOf(icount));

            }
        } catch (Exception e) {
            e.printStackTrace();
            {

            }
        }

    }

    private void return_count() {
        try {
            pst = con.prepareStatement("SELECT COUNT(*) AS returnCount from returnbook");
            ResultSet Rs = pst.executeQuery();

            while (Rs.next()) {
                int rcount = Rs.getInt("returncount");
                returnedbcount.setText(String.valueOf(rcount));

            }
        } catch (Exception e) {
            e.printStackTrace();
            {

            }
        }

    }

    public void search(String str) {
        model = (DefaultTableModel) db_table.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
        db_table.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter("(?i)" + str));
    }

    public void filter(String str) {
        model = (DefaultTableModel) db_table.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
        db_table.setRowSorter(trs);
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
        bookcount = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        studentcount = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        returnedbcount = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        issuedbcount = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        db_search = new javax.swing.JTextField();
        db_filter = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        db_table = new javax.swing.JTable();
        a7 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
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
        genrecombobox = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        book_add = new javax.swing.JLabel();
        book_edit = new javax.swing.JLabel();
        book_delete = new javax.swing.JLabel();
        book_update = new javax.swing.JLabel();
        btextadd = new javax.swing.JLabel();
        btxtedit = new javax.swing.JLabel();
        btxtremove = new javax.swing.JLabel();
        btxtupdate = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        manageb_search = new javax.swing.JTextField();
        manageb_filter = new javax.swing.JComboBox<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        manageb_table = new javax.swing.JTable();
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
        jButton15 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        txtSearch1 = new javax.swing.JTextField();
        jComboBox3 = new javax.swing.JComboBox<>();
        jScrollPane6 = new javax.swing.JScrollPane();
        studtable = new javax.swing.JTable();
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
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        records = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jComboBox5 = new javax.swing.JComboBox<>();
        jTextField3 = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel40 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        recordstable = new javax.swing.JTable();
        a9 = new javax.swing.JLabel();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        issuebook = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        issuebk_button = new javax.swing.JButton();
        issue_issuedate = new com.toedter.calendar.JDateChooser();
        issue_duedate = new com.toedter.calendar.JDateChooser();
        jLabel54 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        Search2 = new javax.swing.JButton();
        jPanel19 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        issuebookid = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        issuebooknm = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        issuebookau = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        issuebookqua = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        issuebookgnr = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        issuestudid = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        issuestudnm = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        issuestudgrsec = new javax.swing.JTextField();
        issuestudstr = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        Search = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        bookpanel = new javax.swing.JPanel();
        jLabel80 = new javax.swing.JLabel();
        txtSearch7 = new javax.swing.JTextField();
        jComboBox11 = new javax.swing.JComboBox<>();
        jScrollPane12 = new javax.swing.JScrollPane();
        issuebooklist1 = new javax.swing.JTable();
        issuefindbooklist1 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        studentpanel = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        issuestudlist1 = new javax.swing.JTable();
        txtSearch5 = new javax.swing.JTextField();
        jLabel78 = new javax.swing.JLabel();
        jComboBox9 = new javax.swing.JComboBox<>();
        issuefindstud1 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        student = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        issuestudlist = new javax.swing.JTable();
        jLabel70 = new javax.swing.JLabel();
        txtSearch2 = new javax.swing.JTextField();
        jComboBox6 = new javax.swing.JComboBox<>();
        a10 = new javax.swing.JLabel();
        issuefindstud = new javax.swing.JButton();
        book = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        issuebooklist = new javax.swing.JTable();
        jLabel71 = new javax.swing.JLabel();
        txtSearch3 = new javax.swing.JTextField();
        jComboBox7 = new javax.swing.JComboBox<>();
        a11 = new javax.swing.JLabel();
        issuefindbooklist = new javax.swing.JButton();
        returnbook = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        finddetailsreturn = new javax.swing.JButton();
        returnstudid = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        returnstudnm = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        returnstudstr = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        returnstudgrsec = new javax.swing.JTextField();
        jLabel61 = new javax.swing.JLabel();
        returnissudate = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        returnbooknm = new javax.swing.JTextField();
        jLabel66 = new javax.swing.JLabel();
        returnbookau = new javax.swing.JTextField();
        jLabel67 = new javax.swing.JLabel();
        returnbookqua = new javax.swing.JTextField();
        jLabel68 = new javax.swing.JLabel();
        returnbookid = new javax.swing.JTextField();
        jLabel69 = new javax.swing.JLabel();
        returnbookgnr = new javax.swing.JTextField();
        returnduedate = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        return_button = new javax.swing.JButton();
        return_datereturned = new com.toedter.calendar.JDateChooser();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        detailspanel = new javax.swing.JPanel();
        jLabel79 = new javax.swing.JLabel();
        txtSearch6 = new javax.swing.JTextField();
        jComboBox10 = new javax.swing.JComboBox<>();
        ret_find_but1 = new javax.swing.JButton();
        jScrollPane11 = new javax.swing.JScrollPane();
        findreturndetails1 = new javax.swing.JTable();
        jLabel81 = new javax.swing.JLabel();
        details = new javax.swing.JPanel();
        jLabel72 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        findreturndetails = new javax.swing.JTable();
        txtSearch4 = new javax.swing.JTextField();
        jComboBox8 = new javax.swing.JComboBox<>();
        a12 = new javax.swing.JLabel();
        ret_find_but = new javax.swing.JButton();
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

        dashboard.setBackground(new java.awt.Color(11, 0, 40));
        dashboard.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                dashboardAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        dashboard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel14.setBackground(new java.awt.Color(11, 0, 50));
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

        bookcount.setFont(new java.awt.Font("Segoe UI", 1, 50)); // NOI18N
        bookcount.setForeground(new java.awt.Color(255, 255, 255));
        bookcount.setText("100");
        jPanel14.add(bookcount);
        bookcount.setBounds(150, 0, 87, 110);

        dashboard.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 270, 110));

        jPanel15.setBackground(new java.awt.Color(11, 0, 50));
        jPanel15.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 0, 0, 2, new java.awt.Color(255, 255, 255)));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("TOTAL STUDENTS");
        jLabel14.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel15.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 160, 30));

        studentcount.setFont(new java.awt.Font("Segoe UI", 1, 50)); // NOI18N
        studentcount.setForeground(new java.awt.Color(255, 255, 255));
        studentcount.setText("559");
        jPanel15.add(studentcount, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, -1, 110));

        dashboard.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, 270, -1));

        jPanel16.setBackground(new java.awt.Color(11, 0, 50));
        jPanel16.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 0, 0, 2, new java.awt.Color(255, 255, 255)));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("RETURNED BOOKS");
        jLabel16.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel16.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 170, 30));

        returnedbcount.setFont(new java.awt.Font("Segoe UI", 1, 50)); // NOI18N
        returnedbcount.setForeground(new java.awt.Color(255, 255, 255));
        returnedbcount.setText("459");
        jPanel16.add(returnedbcount, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, -1, 110));

        dashboard.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 120, 270, -1));

        jPanel17.setBackground(new java.awt.Color(11, 0, 50));
        jPanel17.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 0, 0, 2, new java.awt.Color(255, 255, 255)));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("ISSUED BOOKS");
        jLabel18.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel17.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 140, 30));

        issuedbcount.setFont(new java.awt.Font("Segoe UI", 1, 50)); // NOI18N
        issuedbcount.setForeground(new java.awt.Color(255, 255, 255));
        issuedbcount.setText("599");
        jPanel17.add(issuedbcount, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, -1, 110));

        dashboard.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 120, 270, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/1w.png"))); // NOI18N
        dashboard.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));

        db_search.setBackground(new java.awt.Color(11, 0, 40));
        db_search.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 255, 255)));
        db_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                db_searchActionPerformed(evt);
            }
        });
        dashboard.add(db_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 250, 30));

        db_filter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "ABM", "HUMSS", "ICT", "General Reference", "Fiction", "Core Subject" }));
        db_filter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                db_filterActionPerformed(evt);
            }
        });
        dashboard.add(db_filter, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 240, -1, 30));

        db_table.setBackground(new java.awt.Color(255, 255, 255));
        db_table.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        db_table.setForeground(new java.awt.Color(0, 0, 0));
        db_table.setModel(new javax.swing.table.DefaultTableModel(
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
        db_table.setGridColor(new java.awt.Color(0, 0, 0));
        db_table.setSelectionBackground(new java.awt.Color(153, 153, 153));
        db_table.setSelectionForeground(new java.awt.Color(0, 0, 0));
        db_table.setShowGrid(true);
        db_table.setSurrendersFocusOnKeystroke(true);
        db_table.getTableHeader().setResizingAllowed(false);
        db_table.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(db_table);
        if (db_table.getColumnModel().getColumnCount() > 0) {
            db_table.getColumnModel().getColumn(0).setPreferredWidth(20);
            db_table.getColumnModel().getColumn(1).setPreferredWidth(200);
        }

        dashboard.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 530, 480));

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
        dashboard.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 20, 30, -1));

        jButton5.setBackground(new java.awt.Color(102, 102, 102));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/1.png"))); // NOI18N
        dashboard.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 20, 30, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane9.setViewportView(jTable1);

        dashboard.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 280, 530, 480));

        jTabbedPane1.addTab("DASHBOARD", dashboard);

        managebook.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(11, 0, 40));
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

        txtBookID.setBackground(new java.awt.Color(11, 0, 40));
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

        txtBookName.setBackground(new java.awt.Color(11, 0, 40));
        txtBookName.setForeground(new java.awt.Color(255, 255, 255));
        txtBookName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jPanel4.add(txtBookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, 290, 40));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Book Name :");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 80, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-collaborator-28 (1).png"))); // NOI18N
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, -1, 40));

        txtBookAuthor.setBackground(new java.awt.Color(11, 0, 40));
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

        genrecombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "..." }));
        genrecombobox.setPreferredSize(new java.awt.Dimension(129, 35));
        jPanel4.add(genrecombobox, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 510, 250, 40));

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-book-28.png"))); // NOI18N
        jPanel4.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, -1, 40));

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-unit-28 (1).png"))); // NOI18N
        jPanel4.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 580, -1, 40));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Quantity :");
        jPanel4.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 560, 70, -1));

        txtQuantity.setBackground(new java.awt.Color(11, 0, 40));
        txtQuantity.setForeground(new java.awt.Color(255, 255, 255));
        txtQuantity.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuantityActionPerformed(evt);
            }
        });
        jPanel4.add(txtQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 580, 290, 40));

        book_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-add-48.png"))); // NOI18N
        book_add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                book_addMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                book_addMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                book_addMouseExited(evt);
            }
        });
        jPanel4.add(book_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 640, -1, -1));

        book_edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-pen-squared-48.png"))); // NOI18N
        book_edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                book_editMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                book_editMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                book_editMouseExited(evt);
            }
        });
        jPanel4.add(book_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 640, -1, -1));

        book_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-x-48.png"))); // NOI18N
        book_delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                book_deleteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                book_deleteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                book_deleteMouseExited(evt);
            }
        });
        jPanel4.add(book_delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 640, 50, 50));
        book_delete.setVisible(false);

        book_update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/PG-removebg-preview.png"))); // NOI18N
        book_update.setPreferredSize(new java.awt.Dimension(48, 48));
        book_update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                book_updateMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                book_updateMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                book_updateMouseExited(evt);
            }
        });
        jPanel4.add(book_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 640, -1, -1));
        book_update.setVisible(false);

        btextadd.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btextadd.setForeground(new java.awt.Color(255, 255, 255));
        btextadd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btextadd.setText("ADD");
        jPanel4.add(btextadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 700, 50, -1));
        btextadd.setVisible(false);

        btxtedit.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btxtedit.setForeground(new java.awt.Color(255, 255, 255));
        btxtedit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btxtedit.setText("EDIT");
        jPanel4.add(btxtedit, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 700, 50, -1));
        btxtedit.setVisible(false);

        btxtremove.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btxtremove.setForeground(new java.awt.Color(255, 255, 255));
        btxtremove.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btxtremove.setText("DELETE");
        jPanel4.add(btxtremove, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 700, 50, -1));
        btxtremove.setVisible(false);

        btxtupdate.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btxtupdate.setForeground(new java.awt.Color(255, 255, 255));
        btxtupdate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btxtupdate.setText("UPDATE");
        jPanel4.add(btxtupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 700, -1, -1));
        btxtupdate.setVisible(false);

        jButton2.setBackground(new java.awt.Color(102, 102, 102));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-plus-20.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 520, 20, 20));

        managebook.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 810));

        jButton6.setBackground(new java.awt.Color(102, 102, 102));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/1.png"))); // NOI18N
        managebook.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 20, 30, -1));

        jButton8.setBackground(new java.awt.Color(255, 0, 0));
        jButton8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/2.png"))); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        managebook.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 20, 30, -1));

        jPanel10.setBackground(new java.awt.Color(11, 0, 40));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 50)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 204));
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-book-50.png"))); // NOI18N
        jLabel25.setText(" Manage Books");
        jLabel25.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 0, new java.awt.Color(255, 255, 255)));
        jPanel10.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 400, 90));

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/1w.png"))); // NOI18N
        jPanel10.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        manageb_search.setBackground(new java.awt.Color(11, 0, 40));
        manageb_search.setForeground(new java.awt.Color(255, 255, 255));
        manageb_search.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 255, 255)));
        manageb_search.setCaretColor(new java.awt.Color(255, 255, 255));
        manageb_search.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        manageb_search.setDragEnabled(true);
        manageb_search.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        manageb_search.setSelectionColor(new java.awt.Color(60, 63, 65));
        manageb_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageb_searchActionPerformed(evt);
            }
        });
        manageb_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                manageb_searchKeyReleased(evt);
            }
        });
        jPanel10.add(manageb_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 260, 30));

        manageb_filter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "ABM", "HUMSS", "ICT", "General Reference", "Fiction", "Core Subject" }));
        jPanel10.add(manageb_filter, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, -1, 30));

        manageb_table.setAutoCreateRowSorter(true);
        manageb_table.setBackground(new java.awt.Color(255, 255, 255));
        manageb_table.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        manageb_table.setForeground(new java.awt.Color(0, 0, 0));
        manageb_table.setModel(new javax.swing.table.DefaultTableModel(
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
        manageb_table.setGridColor(new java.awt.Color(0, 0, 0));
        manageb_table.setSelectionBackground(new java.awt.Color(153, 153, 153));
        manageb_table.setSelectionForeground(new java.awt.Color(0, 0, 0));
        manageb_table.setShowGrid(true);
        manageb_table.getTableHeader().setReorderingAllowed(false);
        manageb_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                manageb_tableMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(manageb_table);
        if (manageb_table.getColumnModel().getColumnCount() > 0) {
            manageb_table.getColumnModel().getColumn(0).setPreferredWidth(80);
            manageb_table.getColumnModel().getColumn(4).setPreferredWidth(80);
        }

        jPanel10.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 730, 600));

        managebook.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 770, 810));

        jTabbedPane1.addTab("MANAGEBOOK", managebook);

        managestudent.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel11.setBackground(new java.awt.Color(11, 0, 40));
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

        txtStudentID.setBackground(new java.awt.Color(11, 0, 40));
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

        txtStudentName.setBackground(new java.awt.Color(11, 0, 40));
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
        book_delete.setVisible(false);

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
        book_update.setVisible(false);

        textadd1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        textadd1.setForeground(new java.awt.Color(255, 255, 255));
        textadd1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textadd1.setText("ADD");
        jPanel11.add(textadd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 630, 50, -1));
        btextadd.setVisible(false);

        txtedit1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        txtedit1.setForeground(new java.awt.Color(255, 255, 255));
        txtedit1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtedit1.setText("EDIT");
        jPanel11.add(txtedit1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 630, 50, -1));
        btxtedit.setVisible(false);

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
        btxtupdate.setVisible(false);

        txtremove1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        txtremove1.setForeground(new java.awt.Color(255, 255, 255));
        txtremove1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtremove1.setText("DELETE");
        jPanel11.add(txtremove1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 630, 50, -1));
        btxtremove.setVisible(false);

        jButton1.setBackground(new java.awt.Color(102, 102, 102));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-plus-20.png"))); // NOI18N
        jPanel11.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 450, 20, 20));

        jButton15.setBackground(new java.awt.Color(102, 102, 102));
        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-plus-20.png"))); // NOI18N
        jPanel11.add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 530, 20, 20));

        managestudent.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 810));

        jButton9.setBackground(new java.awt.Color(102, 102, 102));
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/1.png"))); // NOI18N
        managestudent.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 20, 30, -1));

        jButton10.setBackground(new java.awt.Color(255, 0, 0));
        jButton10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/2.png"))); // NOI18N
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        managestudent.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 20, 30, -1));

        jPanel12.setBackground(new java.awt.Color(11, 0, 40));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 50)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 204));
        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-manage-80.png"))); // NOI18N
        jLabel37.setText("Manage Student");
        jLabel37.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 0, new java.awt.Color(255, 255, 255)));
        jPanel12.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, -1, 90));

        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/1w.png"))); // NOI18N
        jPanel12.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        txtSearch1.setBackground(new java.awt.Color(11, 0, 40));
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

        studtable.setAutoCreateRowSorter(true);
        studtable.setBackground(new java.awt.Color(255, 255, 255));
        studtable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        studtable.setForeground(new java.awt.Color(0, 0, 0));
        studtable.setModel(new javax.swing.table.DefaultTableModel(
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
        studtable.setGridColor(new java.awt.Color(0, 0, 0));
        studtable.setSelectionBackground(new java.awt.Color(153, 153, 153));
        studtable.setSelectionForeground(new java.awt.Color(0, 0, 0));
        studtable.setShowGrid(true);
        studtable.getTableHeader().setReorderingAllowed(false);
        studtable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studtablejTable1MouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(studtable);
        if (studtable.getColumnModel().getColumnCount() > 0) {
            studtable.getColumnModel().getColumn(0).setResizable(false);
            studtable.getColumnModel().getColumn(0).setPreferredWidth(80);
            studtable.getColumnModel().getColumn(1).setResizable(false);
            studtable.getColumnModel().getColumn(1).setPreferredWidth(150);
            studtable.getColumnModel().getColumn(2).setResizable(false);
            studtable.getColumnModel().getColumn(2).setPreferredWidth(80);
            studtable.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanel12.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 730, 600));

        managestudent.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 770, 810));

        jTabbedPane1.addTab("MANAGESTUDENT", managestudent);

        transaction.setBackground(new java.awt.Color(11, 0, 40));
        transaction.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/1w.png"))); // NOI18N
        transaction.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        jTextField2.setBackground(new java.awt.Color(11, 0, 40));
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
        if (transactiontable.getColumnModel().getColumnCount() > 0) {
            transactiontable.getColumnModel().getColumn(0).setMinWidth(0);
            transactiontable.getColumnModel().getColumn(0).setPreferredWidth(0);
            transactiontable.getColumnModel().getColumn(0).setMaxWidth(0);
            transactiontable.getColumnModel().getColumn(1).setResizable(false);
            transactiontable.getColumnModel().getColumn(1).setPreferredWidth(170);
            transactiontable.getColumnModel().getColumn(2).setResizable(false);
            transactiontable.getColumnModel().getColumn(3).setMinWidth(0);
            transactiontable.getColumnModel().getColumn(3).setPreferredWidth(0);
            transactiontable.getColumnModel().getColumn(3).setMaxWidth(0);
            transactiontable.getColumnModel().getColumn(4).setMinWidth(0);
            transactiontable.getColumnModel().getColumn(4).setPreferredWidth(0);
            transactiontable.getColumnModel().getColumn(4).setMaxWidth(0);
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

        jButton11.setBackground(new java.awt.Color(102, 102, 102));
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/1.png"))); // NOI18N
        transaction.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 20, 30, -1));

        jButton12.setBackground(new java.awt.Color(255, 0, 0));
        jButton12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton12.setForeground(new java.awt.Color(255, 255, 255));
        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/2.png"))); // NOI18N
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        transaction.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 20, 30, -1));

        jTabbedPane1.addTab("TRANSACTION", transaction);

        records.setBackground(new java.awt.Color(11, 0, 40));
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

        jTextField3.setBackground(new java.awt.Color(11, 0, 40));
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

        recordstable.setBackground(new java.awt.Color(255, 255, 255));
        recordstable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        recordstable.setForeground(new java.awt.Color(0, 0, 0));
        recordstable.setModel(new javax.swing.table.DefaultTableModel(
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
        recordstable.setGridColor(new java.awt.Color(0, 0, 0));
        recordstable.setSelectionBackground(new java.awt.Color(153, 153, 153));
        recordstable.setSelectionForeground(new java.awt.Color(0, 0, 0));
        recordstable.setShowGrid(true);
        recordstable.getTableHeader().setResizingAllowed(false);
        recordstable.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(recordstable);
        if (recordstable.getColumnModel().getColumnCount() > 0) {
            recordstable.getColumnModel().getColumn(0).setMinWidth(0);
            recordstable.getColumnModel().getColumn(0).setPreferredWidth(0);
            recordstable.getColumnModel().getColumn(0).setMaxWidth(0);
            recordstable.getColumnModel().getColumn(1).setPreferredWidth(150);
            recordstable.getColumnModel().getColumn(2).setMinWidth(0);
            recordstable.getColumnModel().getColumn(2).setPreferredWidth(0);
            recordstable.getColumnModel().getColumn(2).setMaxWidth(0);
            recordstable.getColumnModel().getColumn(3).setMinWidth(0);
            recordstable.getColumnModel().getColumn(3).setPreferredWidth(0);
            recordstable.getColumnModel().getColumn(3).setMaxWidth(0);
            recordstable.getColumnModel().getColumn(4).setMinWidth(0);
            recordstable.getColumnModel().getColumn(4).setPreferredWidth(0);
            recordstable.getColumnModel().getColumn(4).setMaxWidth(0);
            recordstable.getColumnModel().getColumn(5).setPreferredWidth(150);
            recordstable.getColumnModel().getColumn(6).setMinWidth(0);
            recordstable.getColumnModel().getColumn(6).setPreferredWidth(0);
            recordstable.getColumnModel().getColumn(6).setMaxWidth(0);
            recordstable.getColumnModel().getColumn(7).setMinWidth(0);
            recordstable.getColumnModel().getColumn(7).setPreferredWidth(0);
            recordstable.getColumnModel().getColumn(7).setMaxWidth(0);
            recordstable.getColumnModel().getColumn(8).setMinWidth(0);
            recordstable.getColumnModel().getColumn(8).setPreferredWidth(0);
            recordstable.getColumnModel().getColumn(8).setMaxWidth(0);
            recordstable.getColumnModel().getColumn(12).setPreferredWidth(50);
        }

        records.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 1080, 600));

        a9.setFont(new java.awt.Font("Century Gothic", 1, 50)); // NOI18N
        a9.setForeground(new java.awt.Color(255, 255, 255));
        a9.setText("RECORDS");
        records.add(a9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 425, -1));

        jButton13.setBackground(new java.awt.Color(102, 102, 102));
        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/1.png"))); // NOI18N
        records.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 20, 30, -1));

        jButton14.setBackground(new java.awt.Color(255, 0, 0));
        jButton14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton14.setForeground(new java.awt.Color(255, 255, 255));
        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/2.png"))); // NOI18N
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        records.add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 20, 30, -1));

        jTabbedPane1.addTab("RECORDS", records);

        issuebook.setBackground(new java.awt.Color(11, 0, 40));
        issuebook.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel20.setBackground(new java.awt.Color(16, 1, 59));
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel52.setBackground(new java.awt.Color(0, 0, 102));
        jLabel52.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-books-50 (1).png"))); // NOI18N
        jLabel52.setText("Issue Book");
        jPanel20.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 150, 60));

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));
        jPanel21.setForeground(new java.awt.Color(255, 255, 255));
        jPanel21.setPreferredSize(new java.awt.Dimension(0, 5));

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel20.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 129, 400, 8));

        jLabel53.setBackground(new java.awt.Color(0, 0, 102));
        jLabel53.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setText("Issue Date :");
        jPanel20.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        issuebk_button.setBackground(new java.awt.Color(255, 0, 0));
        issuebk_button.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        issuebk_button.setForeground(new java.awt.Color(255, 255, 255));
        issuebk_button.setText("ISSUE");
        issuebk_button.setBorder(null);
        issuebk_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                issuebk_buttonActionPerformed(evt);
            }
        });
        jPanel20.add(issuebk_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 400, 220, 35));
        jPanel20.add(issue_issuedate, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 265, 32));
        jPanel20.add(issue_duedate, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, 265, 32));

        jLabel54.setBackground(new java.awt.Color(0, 0, 102));
        jLabel54.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setText("Due Date :");
        jPanel20.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, -1, -1));

        issuebook.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 170, 440, 480));

        jPanel18.setBackground(new java.awt.Color(16, 1, 59));
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel46.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-details-85.png"))); // NOI18N
        jLabel46.setText("Book Details");
        jPanel18.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, -1, -1));

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
        jPanel18.add(Search2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, -1, -1));

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setForeground(new java.awt.Color(255, 255, 255));
        jPanel19.setPreferredSize(new java.awt.Dimension(0, 5));

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel18.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 259, 8));

        jLabel47.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("Book ID :");
        jPanel18.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));

        issuebookid.setBackground(new java.awt.Color(16, 1, 59));
        issuebookid.setForeground(new java.awt.Color(255, 255, 255));
        issuebookid.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        issuebookid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                issuebookidActionPerformed(evt);
            }
        });
        jPanel18.add(issuebookid, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 290, 35));

        jLabel48.setBackground(new java.awt.Color(153, 153, 255));
        jLabel48.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setText("Book Name :");
        jPanel18.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, -1, -1));

        issuebooknm.setBackground(new java.awt.Color(16, 1, 59));
        issuebooknm.setForeground(new java.awt.Color(255, 255, 255));
        issuebooknm.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        issuebooknm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                issuebooknmActionPerformed(evt);
            }
        });
        jPanel18.add(issuebooknm, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 290, 35));

        jLabel49.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setText("Author :");
        jPanel18.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, -1, -1));

        issuebookau.setBackground(new java.awt.Color(16, 1, 59));
        issuebookau.setForeground(new java.awt.Color(255, 255, 255));
        issuebookau.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        issuebookau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                issuebookauActionPerformed(evt);
            }
        });
        jPanel18.add(issuebookau, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 290, 35));

        jLabel50.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setText("Quantity :");
        jPanel18.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, -1, -1));

        issuebookqua.setBackground(new java.awt.Color(16, 1, 59));
        issuebookqua.setForeground(new java.awt.Color(255, 255, 255));
        issuebookqua.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        issuebookqua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                issuebookquaActionPerformed(evt);
            }
        });
        jPanel18.add(issuebookqua, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 530, 290, 35));

        jLabel51.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setText("Genre :");
        jPanel18.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, -1, -1));

        issuebookgnr.setBackground(new java.awt.Color(16, 1, 59));
        issuebookgnr.setForeground(new java.awt.Color(255, 255, 255));
        issuebookgnr.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        issuebookgnr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                issuebookgnrActionPerformed(evt);
            }
        });
        jPanel18.add(issuebookgnr, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 290, 35));

        issuebook.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, 310, 590));

        jPanel5.setBackground(new java.awt.Color(16, 1, 59));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel41.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("Student Name :");
        jPanel5.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, -1, -1));

        issuestudid.setBackground(new java.awt.Color(16, 1, 59));
        issuestudid.setForeground(new java.awt.Color(255, 255, 255));
        issuestudid.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        issuestudid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                issuestudidActionPerformed(evt);
            }
        });
        jPanel5.add(issuestudid, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 290, 36));

        jLabel42.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("Gr. & Sec.  :");
        jPanel5.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, -1, -1));

        jLabel43.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("Student ID :");
        jPanel5.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));

        jLabel44.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-student-registration-85.png"))); // NOI18N
        jLabel44.setText("Student Details");
        jPanel5.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        issuestudnm.setBackground(new java.awt.Color(16, 1, 59));
        issuestudnm.setForeground(new java.awt.Color(255, 255, 255));
        issuestudnm.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        issuestudnm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                issuestudnmActionPerformed(evt);
            }
        });
        jPanel5.add(issuestudnm, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 290, 35));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setForeground(new java.awt.Color(255, 255, 255));
        jPanel7.setPreferredSize(new java.awt.Dimension(0, 5));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 130, 259, 8));

        issuestudgrsec.setBackground(new java.awt.Color(16, 1, 59));
        issuestudgrsec.setForeground(new java.awt.Color(255, 255, 255));
        issuestudgrsec.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        issuestudgrsec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                issuestudgrsecActionPerformed(evt);
            }
        });
        jPanel5.add(issuestudgrsec, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 290, 35));

        issuestudstr.setBackground(new java.awt.Color(16, 1, 59));
        issuestudstr.setForeground(new java.awt.Color(255, 255, 255));
        issuestudstr.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        issuestudstr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                issuestudstrActionPerformed(evt);
            }
        });
        jPanel5.add(issuestudstr, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 290, 35));

        jLabel45.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("Strand :");
        jPanel5.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, -1, -1));

        Search.setBackground(new java.awt.Color(255, 0, 0));
        Search.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Search.setForeground(new java.awt.Color(255, 255, 255));
        Search.setText("Find");
        Search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SearchMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SearchMouseEntered(evt);
            }
        });
        Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchActionPerformed(evt);
            }
        });
        jPanel5.add(Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, -1, -1));

        issuebook.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 310, 590));
        jPanel5.getAccessibleContext().setAccessibleName("");

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-left-3-20.png"))); // NOI18N
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
        });
        issuebook.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 20, 30));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-curved-arrow-20.png"))); // NOI18N
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
        });
        issuebook.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 20, -1, 30));

        jLabel77.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-left-3-20.png"))); // NOI18N
        issuebook.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 20, 20, 30));

        bookpanel.setBackground(new java.awt.Color(11, 0, 40));
        bookpanel.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)));

        jLabel80.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/1w.png"))); // NOI18N

        txtSearch7.setBackground(new java.awt.Color(11, 0, 40));
        txtSearch7.setForeground(new java.awt.Color(255, 255, 255));
        txtSearch7.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 255, 255)));
        txtSearch7.setCaretColor(new java.awt.Color(255, 255, 255));
        txtSearch7.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtSearch7.setDragEnabled(true);
        txtSearch7.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        txtSearch7.setSelectionColor(new java.awt.Color(60, 63, 65));
        txtSearch7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearch7ActionPerformed(evt);
            }
        });
        txtSearch7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearch7KeyReleased(evt);
            }
        });

        jComboBox11.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "ABM", "HUMSS", "ICT", "General Reference", "Fiction", "Core Subject" }));

        issuebooklist1.setAutoCreateRowSorter(true);
        issuebooklist1.setBackground(new java.awt.Color(255, 255, 255));
        issuebooklist1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        issuebooklist1.setForeground(new java.awt.Color(0, 0, 0));
        issuebooklist1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book ID", "Book Name", "Book Author", "Genre", " Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        issuebooklist1.setGridColor(new java.awt.Color(0, 0, 0));
        issuebooklist1.setSelectionBackground(new java.awt.Color(153, 153, 153));
        issuebooklist1.setSelectionForeground(new java.awt.Color(0, 0, 0));
        issuebooklist1.setShowGrid(true);
        issuebooklist1.getTableHeader().setReorderingAllowed(false);
        issuebooklist1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                issuebooklist1MouseClicked(evt);
            }
        });
        jScrollPane12.setViewportView(issuebooklist1);

        issuefindbooklist1.setText("FIND");
        issuefindbooklist1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                issuefindbooklist1ActionPerformed(evt);
            }
        });

        jButton17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/2.png"))); // NOI18N
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bookpanelLayout = new javax.swing.GroupLayout(bookpanel);
        bookpanel.setLayout(bookpanelLayout);
        bookpanelLayout.setHorizontalGroup(
            bookpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bookpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bookpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane12)
                    .addGroup(bookpanelLayout.createSequentialGroup()
                        .addComponent(jLabel80)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearch7, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox11, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(issuefindbooklist1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 474, Short.MAX_VALUE)
                        .addComponent(jButton17)))
                .addContainerGap())
        );
        bookpanelLayout.setVerticalGroup(
            bookpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bookpanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(bookpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel80, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bookpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSearch7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(issuefindbooklist1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton17)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        issuebook.add(bookpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 1020, 680));
        bookpanel.setVisible(false);

        studentpanel.setBackground(new java.awt.Color(11, 0, 40));
        studentpanel.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)));

        issuestudlist1.setAutoCreateRowSorter(true);
        issuestudlist1.setBackground(new java.awt.Color(255, 255, 255));
        issuestudlist1.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(0, 0, 0)));
        issuestudlist1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        issuestudlist1.setForeground(new java.awt.Color(0, 0, 0));
        issuestudlist1.setModel(new javax.swing.table.DefaultTableModel(
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
        issuestudlist1.setGridColor(new java.awt.Color(0, 0, 0));
        issuestudlist1.setSelectionBackground(new java.awt.Color(153, 153, 153));
        issuestudlist1.setSelectionForeground(new java.awt.Color(0, 0, 0));
        issuestudlist1.setShowGrid(true);
        issuestudlist1.getTableHeader().setReorderingAllowed(false);
        issuestudlist1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                issuestudlist1jTable1MouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(issuestudlist1);

        txtSearch5.setBackground(new java.awt.Color(11, 0, 40));
        txtSearch5.setForeground(new java.awt.Color(255, 255, 255));
        txtSearch5.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 255, 255)));
        txtSearch5.setCaretColor(new java.awt.Color(255, 255, 255));
        txtSearch5.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtSearch5.setDragEnabled(true);
        txtSearch5.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        txtSearch5.setSelectionColor(new java.awt.Color(60, 63, 65));
        txtSearch5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearch5ActionPerformed(evt);
            }
        });
        txtSearch5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearch5KeyReleased(evt);
            }
        });

        jLabel78.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/1w.png"))); // NOI18N

        jComboBox9.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "ABM", "HUMSS", "ICT", "General Reference", "Fiction", "Core Subject" }));

        issuefindstud1.setText("FIND");
        issuefindstud1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                issuefindstud1ActionPerformed(evt);
            }
        });

        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/2.png"))); // NOI18N
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout studentpanelLayout = new javax.swing.GroupLayout(studentpanel);
        studentpanel.setLayout(studentpanelLayout);
        studentpanelLayout.setHorizontalGroup(
            studentpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(studentpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(studentpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane10)
                    .addGroup(studentpanelLayout.createSequentialGroup()
                        .addComponent(jLabel78)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearch5, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox9, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(issuefindstud1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 480, Short.MAX_VALUE)
                        .addComponent(jButton16)))
                .addContainerGap())
        );
        studentpanelLayout.setVerticalGroup(
            studentpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(studentpanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(studentpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel78)
                    .addGroup(studentpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSearch5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(issuefindstud1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton16)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        issuebook.add(studentpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 1020, 680));
        studentpanel.setVisible(false);

        jTabbedPane1.addTab("ISSUEBOOK", issuebook);

        student.setBackground(new java.awt.Color(11, 0, 40));
        student.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        issuestudlist.setAutoCreateRowSorter(true);
        issuestudlist.setBackground(new java.awt.Color(255, 255, 255));
        issuestudlist.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(0, 0, 0)));
        issuestudlist.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        issuestudlist.setForeground(new java.awt.Color(0, 0, 0));
        issuestudlist.setModel(new javax.swing.table.DefaultTableModel(
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
        issuestudlist.setGridColor(new java.awt.Color(0, 0, 0));
        issuestudlist.setSelectionBackground(new java.awt.Color(153, 153, 153));
        issuestudlist.setSelectionForeground(new java.awt.Color(0, 0, 0));
        issuestudlist.setShowGrid(true);
        issuestudlist.getTableHeader().setReorderingAllowed(false);
        issuestudlist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                issuestudlistjTable1MouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(issuestudlist);

        student.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 1070, 650));

        jLabel70.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/1w.png"))); // NOI18N
        student.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        txtSearch2.setBackground(new java.awt.Color(11, 0, 40));
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
        student.add(txtSearch2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 250, 30));

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "ABM", "HUMSS", "ICT", "General Reference", "Fiction", "Core Subject" }));
        student.add(jComboBox6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, 150, 30));

        a10.setFont(new java.awt.Font("Century Gothic", 1, 50)); // NOI18N
        a10.setForeground(new java.awt.Color(255, 255, 255));
        a10.setText("STUDENT LIST");
        student.add(a10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 425, 60));

        issuefindstud.setText("FIND");
        issuefindstud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                issuefindstudActionPerformed(evt);
            }
        });
        student.add(issuefindstud, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, 60, 20));

        jTabbedPane1.addTab("STUDENT", student);

        book.setBackground(new java.awt.Color(11, 0, 40));
        book.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        issuebooklist.setAutoCreateRowSorter(true);
        issuebooklist.setBackground(new java.awt.Color(255, 255, 255));
        issuebooklist.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        issuebooklist.setForeground(new java.awt.Color(0, 0, 0));
        issuebooklist.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book ID", "Book Name", "Book Author", "Genre", " Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        issuebooklist.setGridColor(new java.awt.Color(0, 0, 0));
        issuebooklist.setSelectionBackground(new java.awt.Color(153, 153, 153));
        issuebooklist.setSelectionForeground(new java.awt.Color(0, 0, 0));
        issuebooklist.setShowGrid(true);
        issuebooklist.getTableHeader().setReorderingAllowed(false);
        issuebooklist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                issuebooklistMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(issuebooklist);

        book.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 1070, 650));

        jLabel71.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/1w.png"))); // NOI18N
        book.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        txtSearch3.setBackground(new java.awt.Color(11, 0, 40));
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

        issuefindbooklist.setText("FIND");
        issuefindbooklist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                issuefindbooklistActionPerformed(evt);
            }
        });
        book.add(issuefindbooklist, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, 60, 20));

        jTabbedPane1.addTab("BOOK", book);

        returnbook.setBackground(new java.awt.Color(11, 0, 40));
        returnbook.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(16, 1, 59));
        jPanel6.setLayout(null);

        jLabel55.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setText("Return");
        jPanel6.add(jLabel55);
        jLabel55.setBounds(100, 20, 130, 40);

        jLabel56.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-return-book-100.png"))); // NOI18N
        jPanel6.add(jLabel56);
        jLabel56.setBounds(110, 70, 101, 101);

        jLabel57.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(255, 255, 255));
        jLabel57.setText("Student ID :");
        jPanel6.add(jLabel57);
        jLabel57.setBounds(10, 190, 67, 16);

        finddetailsreturn.setBackground(new java.awt.Color(255, 0, 0));
        finddetailsreturn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        finddetailsreturn.setForeground(new java.awt.Color(255, 255, 255));
        finddetailsreturn.setText("Find");
        finddetailsreturn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                finddetailsreturnMouseClicked(evt);
            }
        });
        finddetailsreturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finddetailsreturnActionPerformed(evt);
            }
        });
        jPanel6.add(finddetailsreturn);
        finddetailsreturn.setBounds(240, 210, 60, 22);

        returnstudid.setBackground(new java.awt.Color(16, 1, 59));
        returnstudid.setForeground(new java.awt.Color(255, 255, 255));
        returnstudid.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        returnstudid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnstudidActionPerformed(evt);
            }
        });
        jPanel6.add(returnstudid);
        returnstudid.setBounds(10, 210, 290, 36);

        jLabel58.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(255, 255, 255));
        jLabel58.setText("Student Name :");
        jPanel6.add(jLabel58);
        jLabel58.setBounds(10, 260, 87, 20);

        returnstudnm.setBackground(new java.awt.Color(16, 1, 59));
        returnstudnm.setForeground(new java.awt.Color(255, 255, 255));
        returnstudnm.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        returnstudnm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnstudnmActionPerformed(evt);
            }
        });
        jPanel6.add(returnstudnm);
        returnstudnm.setBounds(10, 280, 290, 35);

        jLabel59.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(255, 255, 255));
        jLabel59.setText("Strand :");
        jPanel6.add(jLabel59);
        jLabel59.setBounds(10, 330, 50, 16);

        returnstudstr.setBackground(new java.awt.Color(16, 1, 59));
        returnstudstr.setForeground(new java.awt.Color(255, 255, 255));
        returnstudstr.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        returnstudstr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnstudstrActionPerformed(evt);
            }
        });
        jPanel6.add(returnstudstr);
        returnstudstr.setBounds(10, 350, 290, 35);

        jLabel60.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(255, 255, 255));
        jLabel60.setText("Gr. & Sec.  :");
        jPanel6.add(jLabel60);
        jLabel60.setBounds(10, 400, 65, 16);

        returnstudgrsec.setBackground(new java.awt.Color(16, 1, 59));
        returnstudgrsec.setForeground(new java.awt.Color(255, 255, 255));
        returnstudgrsec.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        returnstudgrsec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnstudgrsecActionPerformed(evt);
            }
        });
        jPanel6.add(returnstudgrsec);
        returnstudgrsec.setBounds(10, 420, 290, 35);

        jLabel61.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(255, 255, 255));
        jLabel61.setText("Issue Date :");
        jPanel6.add(jLabel61);
        jLabel61.setBounds(10, 470, 70, 16);

        returnissudate.setBackground(new java.awt.Color(16, 1, 59));
        returnissudate.setForeground(new java.awt.Color(255, 255, 255));
        returnissudate.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        returnissudate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnissudateActionPerformed(evt);
            }
        });
        jPanel6.add(returnissudate);
        returnissudate.setBounds(10, 490, 290, 35);

        returnbook.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 310, 600));

        jPanel8.setBackground(new java.awt.Color(16, 1, 59));
        jPanel8.setPreferredSize(new java.awt.Dimension(350, 500));
        jPanel8.setLayout(null);

        jLabel62.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(255, 255, 255));
        jLabel62.setText("Details");
        jPanel8.add(jLabel62);
        jLabel62.setBounds(80, 20, 126, 44);

        jLabel63.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-view-details-100.png"))); // NOI18N
        jPanel8.add(jLabel63);
        jLabel63.setBounds(90, 70, 101, 101);

        jLabel64.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(255, 255, 255));
        jLabel64.setText("Book ID :");
        jPanel8.add(jLabel64);
        jLabel64.setBounds(10, 190, 51, 16);

        jLabel65.setBackground(new java.awt.Color(153, 153, 255));
        jLabel65.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(255, 255, 255));
        jLabel65.setText("Book Name :");
        jPanel8.add(jLabel65);
        jLabel65.setBounds(10, 260, 71, 16);

        returnbooknm.setBackground(new java.awt.Color(16, 1, 59));
        returnbooknm.setForeground(new java.awt.Color(255, 255, 255));
        returnbooknm.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        returnbooknm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnbooknmActionPerformed(evt);
            }
        });
        jPanel8.add(returnbooknm);
        returnbooknm.setBounds(10, 280, 290, 35);

        jLabel66.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(255, 255, 255));
        jLabel66.setText("Author :");
        jPanel8.add(jLabel66);
        jLabel66.setBounds(10, 330, 45, 20);

        returnbookau.setBackground(new java.awt.Color(16, 1, 59));
        returnbookau.setForeground(new java.awt.Color(255, 255, 255));
        returnbookau.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        returnbookau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnbookauActionPerformed(evt);
            }
        });
        jPanel8.add(returnbookau);
        returnbookau.setBounds(10, 350, 290, 35);

        jLabel67.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(255, 255, 255));
        jLabel67.setText("Quantity :");
        jPanel8.add(jLabel67);
        jLabel67.setBounds(10, 470, 54, 16);

        returnbookqua.setBackground(new java.awt.Color(16, 1, 59));
        returnbookqua.setForeground(new java.awt.Color(255, 255, 255));
        returnbookqua.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        returnbookqua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnbookquaActionPerformed(evt);
            }
        });
        jPanel8.add(returnbookqua);
        returnbookqua.setBounds(10, 490, 290, 35);

        jLabel68.setBackground(new java.awt.Color(153, 153, 255));
        jLabel68.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(255, 255, 255));
        jLabel68.setText("Due Date :");
        jPanel8.add(jLabel68);
        jLabel68.setBounds(10, 540, 80, 16);

        returnbookid.setBackground(new java.awt.Color(16, 1, 59));
        returnbookid.setForeground(new java.awt.Color(255, 255, 255));
        returnbookid.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        returnbookid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnbookidActionPerformed(evt);
            }
        });
        jPanel8.add(returnbookid);
        returnbookid.setBounds(10, 210, 290, 35);

        jLabel69.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(255, 255, 255));
        jLabel69.setText("Genre :");
        jPanel8.add(jLabel69);
        jLabel69.setBounds(10, 400, 41, 16);

        returnbookgnr.setBackground(new java.awt.Color(16, 1, 59));
        returnbookgnr.setForeground(new java.awt.Color(255, 255, 255));
        returnbookgnr.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        returnbookgnr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnbookgnrActionPerformed(evt);
            }
        });
        jPanel8.add(returnbookgnr);
        returnbookgnr.setBounds(10, 420, 290, 35);

        returnduedate.setBackground(new java.awt.Color(16, 1, 59));
        returnduedate.setForeground(new java.awt.Color(255, 255, 255));
        returnduedate.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        returnduedate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnduedateActionPerformed(evt);
            }
        });
        jPanel8.add(returnduedate);
        returnduedate.setBounds(10, 560, 290, 35);

        returnbook.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 110, 310, 600));

        jPanel9.setBackground(new java.awt.Color(16, 1, 59));
        jPanel9.setLayout(null);

        return_button.setBackground(new java.awt.Color(255, 0, 0));
        return_button.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        return_button.setForeground(new java.awt.Color(255, 255, 255));
        return_button.setText("Return");
        return_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                return_buttonActionPerformed(evt);
            }
        });
        jPanel9.add(return_button);
        return_button.setBounds(110, 410, 220, 35);
        return_button.setEnabled(false);
        jPanel9.add(return_datereturned);
        return_datereturned.setBounds(100, 310, 260, 30);

        jLabel73.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(255, 255, 255));
        jLabel73.setText("Return Book");
        jPanel9.add(jLabel73);
        jLabel73.setBounds(110, 80, 226, 44);

        jLabel74.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(255, 255, 255));
        jLabel74.setText("Return Date :");
        jPanel9.add(jLabel74);
        jLabel74.setBounds(10, 320, 80, 16);

        jLabel75.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-return-100.png"))); // NOI18N
        jPanel9.add(jLabel75);
        jLabel75.setBounds(180, 140, 100, 100);

        returnbook.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 170, 440, 480));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-left-3-20.png"))); // NOI18N
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });
        returnbook.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 20, 20, 30));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-curved-arrow-20.png"))); // NOI18N
        returnbook.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 20, -1, 30));

        jLabel76.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-left-3-20.png"))); // NOI18N
        jLabel76.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel76MouseClicked(evt);
            }
        });
        returnbook.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 20, 30));

        detailspanel.setBackground(new java.awt.Color(11, 0, 40));
        detailspanel.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)));

        jLabel79.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/1w.png"))); // NOI18N

        txtSearch6.setEditable(false);
        txtSearch6.setBackground(new java.awt.Color(11, 0, 40));
        txtSearch6.setForeground(new java.awt.Color(255, 255, 255));
        txtSearch6.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 255, 255)));
        txtSearch6.setCaretColor(new java.awt.Color(255, 255, 255));
        txtSearch6.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtSearch6.setDragEnabled(true);
        txtSearch6.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        txtSearch6.setSelectionColor(new java.awt.Color(60, 63, 65));
        txtSearch6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearch6ActionPerformed(evt);
            }
        });
        txtSearch6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearch6KeyReleased(evt);
            }
        });

        jComboBox10.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "ABM", "HUMSS", "ICT", "General Reference", "Fiction", "Core Subject" }));

        ret_find_but1.setText("FIND");
        ret_find_but1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ret_find_but1ActionPerformed(evt);
            }
        });

        findreturndetails1.setAutoCreateRowSorter(true);
        findreturndetails1.setBackground(new java.awt.Color(255, 255, 255));
        findreturndetails1.setForeground(new java.awt.Color(0, 0, 0));
        findreturndetails1.setModel(new javax.swing.table.DefaultTableModel(
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
        findreturndetails1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        findreturndetails1.setGridColor(new java.awt.Color(0, 0, 0));
        findreturndetails1.setSelectionBackground(new java.awt.Color(153, 153, 153));
        findreturndetails1.setSelectionForeground(new java.awt.Color(0, 0, 0));
        findreturndetails1.setShowGrid(true);
        findreturndetails1.getTableHeader().setResizingAllowed(false);
        findreturndetails1.getTableHeader().setReorderingAllowed(false);
        findreturndetails1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                findreturndetails1MouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(findreturndetails1);

        jLabel81.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-curved-arrow-20.png"))); // NOI18N
        jLabel81.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel81MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout detailspanelLayout = new javax.swing.GroupLayout(detailspanel);
        detailspanel.setLayout(detailspanelLayout);
        detailspanelLayout.setHorizontalGroup(
            detailspanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detailspanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(detailspanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane11)
                    .addGroup(detailspanelLayout.createSequentialGroup()
                        .addComponent(jLabel79)
                        .addGap(0, 0, 0)
                        .addComponent(txtSearch6, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jComboBox10, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ret_find_but1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 472, Short.MAX_VALUE)
                        .addComponent(jLabel81)))
                .addContainerGap())
        );
        detailspanelLayout.setVerticalGroup(
            detailspanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, detailspanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(detailspanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(detailspanelLayout.createSequentialGroup()
                        .addGap(0, 6, Short.MAX_VALUE)
                        .addGroup(detailspanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel79)
                            .addComponent(txtSearch6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(detailspanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jComboBox10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ret_find_but1))))
                    .addComponent(jLabel81, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(8, 8, 8)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        returnbook.add(detailspanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 1020, 680));
        detailspanel.setVisible(false);

        jTabbedPane1.addTab("RETURNBOOK", returnbook);

        details.setBackground(new java.awt.Color(11, 0, 40));
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
        txtSearch4.setBackground(new java.awt.Color(11, 0, 40));
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
        details.add(txtSearch4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 250, 30));

        jComboBox8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "ABM", "HUMSS", "ICT", "General Reference", "Fiction", "Core Subject" }));
        details.add(jComboBox8, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, 150, 30));

        a12.setFont(new java.awt.Font("Century Gothic", 1, 50)); // NOI18N
        a12.setForeground(new java.awt.Color(255, 255, 255));
        a12.setText("DETAILS");
        details.add(a12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 425, 50));

        ret_find_but.setText("FIND");
        ret_find_but.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ret_find_butActionPerformed(evt);
            }
        });
        details.add(ret_find_but, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, 60, -1));

        jTabbedPane1.addTab("DETAILS", details);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, -40, 1100, 840));

        jPanel2.setBackground(new java.awt.Color(16, 0, 61));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(11, 0, 40));
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

        t1.setBackground(new java.awt.Color(16, 0, 61));
        t1.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 0, 0, 0, new java.awt.Color(255, 255, 255)));

        dash.setBackground(new java.awt.Color(31, 25, 60));
        dash.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        dash.setForeground(new java.awt.Color(255, 255, 255));
        dash.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        dash.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/dash-removebg-preview.png"))); // NOI18N
        dash.setText("       DASHBOARD");
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
            .addGroup(t1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dash, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE))
        );
        t1Layout.setVerticalGroup(
            t1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dash, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
        );

        jPanel2.add(t1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 270, 80));

        t2.setBackground(new java.awt.Color(16, 0, 61));
        t2.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 0, 0, 0, new java.awt.Color(255, 255, 255)));

        books.setBackground(new java.awt.Color(31, 25, 60));
        books.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        books.setForeground(new java.awt.Color(255, 255, 255));
        books.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        books.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/book-removebg-preview.png"))); // NOI18N
        books.setText("       MANAGE BOOKS");
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
            .addGroup(t2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(books, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE))
        );
        t2Layout.setVerticalGroup(
            t2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(books, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
        );

        jPanel2.add(t2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 270, 80));

        t3.setBackground(new java.awt.Color(16, 0, 61));
        t3.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 0, 0, 0, new java.awt.Color(255, 255, 255)));

        students.setBackground(new java.awt.Color(31, 25, 60));
        students.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        students.setForeground(new java.awt.Color(255, 255, 255));
        students.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        students.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/student-removebg-preview.png"))); // NOI18N
        students.setText("        MANAGE STUDENTS");
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
            .addComponent(students, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
        );
        t3Layout.setVerticalGroup(
            t3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(t3Layout.createSequentialGroup()
                .addComponent(students, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.add(t3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 270, 80));

        t4.setBackground(new java.awt.Color(16, 0, 61));
        t4.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 0, 0, 0, new java.awt.Color(255, 255, 255)));

        trans.setBackground(new java.awt.Color(31, 25, 60));
        trans.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        trans.setForeground(new java.awt.Color(255, 255, 255));
        trans.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        trans.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/trans-removebg-preview.png"))); // NOI18N
        trans.setText("        TRANSACTION");
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
            .addComponent(trans, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
        );
        t4Layout.setVerticalGroup(
            t4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(trans, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
        );

        jPanel2.add(t4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 270, 80));

        t5.setBackground(new java.awt.Color(16, 0, 61));
        t5.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 0, 3, 0, new java.awt.Color(255, 255, 255)));

        rec.setBackground(new java.awt.Color(31, 25, 60));
        rec.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        rec.setForeground(new java.awt.Color(255, 255, 255));
        rec.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        rec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/rec-removebg-preview.png"))); // NOI18N
        rec.setText("        RECORDS");
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
            .addComponent(rec, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
        );
        t5Layout.setVerticalGroup(
            t5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rec, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
        );

        jPanel2.add(t5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 270, 80));

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
            .addComponent(A6, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
        );
        a6Layout.setVerticalGroup(
            a6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(A6, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel2.add(a6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 700, 270, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 800));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(1368, 800));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void setColor(JPanel p) {
        p.setBackground(new Color(16, 0, 61));
    }

    public void resetColor(JPanel p1) {
        p1.setBackground(new Color(0, 5, 87));
    }

    private void manageb_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manageb_tableMouseClicked

        db_table.setFocusable(true);
        book_edit.setEnabled(true);
        book_delete.setEnabled(true);
    }//GEN-LAST:event_manageb_tableMouseClicked

    private void manageb_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_manageb_searchKeyReleased
        String searchString = manageb_search.getText();
        search(searchString);
    }//GEN-LAST:event_manageb_searchKeyReleased

    private void manageb_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageb_searchActionPerformed

    }//GEN-LAST:event_manageb_searchActionPerformed

    private void book_updateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_book_updateMouseExited
        btxtupdate.setVisible(false);
    }//GEN-LAST:event_book_updateMouseExited

    private void book_updateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_book_updateMouseEntered
        btxtupdate.setVisible(true);
    }//GEN-LAST:event_book_updateMouseEntered

    private void book_updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_book_updateMouseClicked

        int optionType = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null, "Are you sure?", "Update Book", optionType);
        try {

            String BookID, BookName, BookAuthor, Quantity, Genre;
            BookID = txtBookID.getText();
            BookName = txtBookName.getText();
            BookAuthor = txtBookAuthor.getText();
            Quantity = txtQuantity.getText();
            Genre = genrecombobox.getSelectedItem().toString();

            if (result == JOptionPane.YES_OPTION) {
                pst = con.prepareStatement("update books set bookid = ?, bookname = ?,bookauthor = ?,genre = ?, quantity = ? where bookid = ?");
            }
            pst.setString(1, BookID);
            pst.setString(2, BookName);
            pst.setString(3, BookAuthor);
            pst.setString(4, Genre);
            pst.setString(5, Quantity);
            pst.setString(6, BookID);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Book Updated");
            booktable_update();
            issuebooktable_update();
            txtBookID.setText("");
            txtBookName.setText("");
            txtBookAuthor.setText("");
            genrecombobox.setSelectedIndex(0);
            txtQuantity.setText("");
            txtBookName.requestFocus();
            book_add.setVisible(true);
            book_delete.setVisible(true);
            book_edit.setVisible(true);
            book_update.setVisible(false);
            db_table.clearSelection();

        } catch (SQLException ex) {
            Logger.getLogger(MANAGESTUDENT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_book_updateMouseClicked

    private void book_deleteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_book_deleteMouseExited
        btxtremove.setVisible(false);
    }//GEN-LAST:event_book_deleteMouseExited

    private void book_deleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_book_deleteMouseEntered
        btxtremove.setVisible(true);
    }//GEN-LAST:event_book_deleteMouseEntered

    private void book_deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_book_deleteMouseClicked

        int optionType = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to remove this book", "Delete", optionType);
        try {

            String BookID;
            BookID = txtBookID.getText();
            if (result == JOptionPane.YES_OPTION) {
                pst = con.prepareStatement("delete from books where bookid= ?");
            }
            pst.setString(1, BookID);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Book Deleted");
            booktable_update();
            issuebooktable_update();
            txtBookID.setText("");
            txtBookName.setText("");
            txtBookAuthor.setText("");
            genrecombobox.setSelectedIndex(0);
            txtQuantity.setText("");

        } catch (SQLException ex) {
            Logger.getLogger(MANAGEBOOK.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_book_deleteMouseClicked

    private void book_editMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_book_editMouseExited
        btxtedit.setVisible(false);
    }//GEN-LAST:event_book_editMouseExited

    private void book_editMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_book_editMouseEntered
        btxtedit.setVisible(true);
    }//GEN-LAST:event_book_editMouseEntered

    private void book_editMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_book_editMouseClicked

        DefaultTableModel model = (DefaultTableModel) manageb_table.getModel();
        int selectedIndex = manageb_table.getSelectedRow();

        txtBookID.setText(model.getValueAt(selectedIndex, 0).toString());
        txtBookName.setText(model.getValueAt(selectedIndex, 1).toString());
        txtBookAuthor.setText(model.getValueAt(selectedIndex, 2).toString());
        genrecombobox.setSelectedItem(model.getValueAt(selectedIndex, 3).toString());
        txtQuantity.setText(model.getValueAt(selectedIndex, 4).toString());

        book_add.setVisible(false);
        book_delete.setVisible(true);
        book_edit.setVisible(true);
        book_update.setVisible(true);
    }//GEN-LAST:event_book_editMouseClicked

    private void book_addMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_book_addMouseExited
        btextadd.setVisible(false);
    }//GEN-LAST:event_book_addMouseExited

    private void book_addMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_book_addMouseEntered
        btextadd.setVisible(true);
    }//GEN-LAST:event_book_addMouseEntered

    private void book_addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_book_addMouseClicked
        try {
            String BookID, BookName, BookAuthor, Quantity, Genre;
            BookID = txtBookID.getText();
            BookName = txtBookName.getText();
            BookAuthor = txtBookAuthor.getText();
            Quantity = txtQuantity.getText();
            Genre = genrecombobox.getSelectedItem().toString();
            pst = con.prepareStatement("insert into books (bookid,bookname,bookauthor,genre,quantity)values(?,?,?,?,?)");
            pst.setString(1, BookID);
            pst.setString(2, BookName);
            pst.setString(3, BookAuthor);
            pst.setString(4, Genre);
            pst.setString(5, Quantity);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Book Added");
            booktable_update();
            issuebooktable_update();
            JOptionPane.showMessageDialog(null, "Book Count Updated");
            book_count();
            txtBookID.setText("");
            txtBookName.setText("");
            txtBookAuthor.setText("");
            genrecombobox.setSelectedIndex(0);
            txtQuantity.setText("");
            txtBookName.requestFocus();
            int lastRow = db_table.convertRowIndexToView(db_table.getRowCount() - 1);
            db_table.setRowSelectionInterval(lastRow, lastRow);
            Rectangle cellrect = db_table.getCellRect(lastRow, 0, true);
            db_table.scrollRectToVisible(cellrect);
        } catch (SQLException ex) {
            Logger.getLogger(MANAGEBOOK.class.getName()).log(Level.SEVERE, null, ex);

        }
    }//GEN-LAST:event_book_addMouseClicked

    private void txtQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantityActionPerformed

    }//GEN-LAST:event_txtQuantityActionPerformed

    private void txtBookIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBookIDActionPerformed

    }//GEN-LAST:event_txtBookIDActionPerformed

    private void db_filterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_db_filterActionPerformed

    }//GEN-LAST:event_db_filterActionPerformed

    private void db_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_db_searchActionPerformed

    }//GEN-LAST:event_db_searchActionPerformed

    private void txtStudentIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStudentIDActionPerformed

    }//GEN-LAST:event_txtStudentIDActionPerformed

    private void addbutton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addbutton1MouseClicked

        try {
            String StudentID, StudentName, Strand, GrandSec;
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
            stud_table_update();
            studenttable_update();
            JOptionPane.showMessageDialog(null, "Student Count Updated");
            student_count();
            txtStudentID.setText("");
            txtStudentName.setText("");
            txtStrand.setSelectedIndex(0);
            txtGrandSec.setSelectedIndex(0);
            txtGrandSec.requestFocus();
        } catch (SQLException ex) {
            Logger.getLogger(MANAGESTUDENT.class.getName()).log(Level.SEVERE, null, ex);

        }
    }//GEN-LAST:event_addbutton1MouseClicked

    private void addbutton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addbutton1MouseEntered
        btextadd.setVisible(true);
    }//GEN-LAST:event_addbutton1MouseEntered

    private void addbutton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addbutton1MouseExited
        btextadd.setVisible(false);
    }//GEN-LAST:event_addbutton1MouseExited

    private void editbutton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editbutton1MouseClicked
        DefaultTableModel model = (DefaultTableModel) studtable.getModel();
        int SelectedRows = studtable.convertRowIndexToModel(studtable.getSelectedRow());
        txtStudentID.setText(model.getValueAt(SelectedRows, 0).toString());
        txtStudentName.setText(model.getValueAt(SelectedRows, 1).toString());
        txtStrand.setSelectedItem(model.getValueAt(SelectedRows, 2).toString());
        txtGrandSec.setSelectedItem(model.getValueAt(SelectedRows, 3).toString());

        book_add.setVisible(false);
        book_delete.setVisible(true);
        book_edit.setVisible(false);
        book_update.setVisible(true);

    }//GEN-LAST:event_editbutton1MouseClicked

    private void editbutton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editbutton1MouseEntered
        btxtedit.setVisible(true);
    }//GEN-LAST:event_editbutton1MouseEntered

    private void editbutton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editbutton1MouseExited
        btxtedit.setVisible(false);
    }//GEN-LAST:event_editbutton1MouseExited

    private void editbutton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editbutton1MousePressed

    }//GEN-LAST:event_editbutton1MousePressed

    private void deletebutton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deletebutton1MouseClicked
        int optionType = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to remove this student", "Delete", optionType);

        try {
            String StudentID;
            StudentID = txtStudentID.getText();
            if (result == JOptionPane.YES_OPTION) {
                pst = con.prepareStatement("DELETE FROM students WHERE studentid= ?");
            }
            pst.setString(1, StudentID);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Student Removed");
            stud_table_update();
            studenttable_update();
            txtStudentID.setText("");
            txtStudentName.setText("");
            txtStrand.setSelectedIndex(0);
            txtGrandSec.setSelectedIndex(0);
            txtStudentName.requestFocus();

        } catch (SQLException ex) {
            Logger.getLogger(MANAGESTUDENT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_deletebutton1MouseClicked

    private void deletebutton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deletebutton1MouseEntered
        btxtremove.setVisible(true);
    }//GEN-LAST:event_deletebutton1MouseEntered

    private void deletebutton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deletebutton1MouseExited
        btxtremove.setVisible(false);
    }//GEN-LAST:event_deletebutton1MouseExited

    private void updatebutton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatebutton1MouseClicked
        int optionType = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null, "Are you sure?", "Update Student", optionType);
        try {
            DefaultTableModel model = (DefaultTableModel) db_table.getModel();
            String StudentID, StudentName, Strand, GrandSec;
            StudentID = txtStudentID.getText();
            StudentName = txtStudentName.getText();
            Strand = txtStrand.getSelectedItem().toString();
            GrandSec = txtGrandSec.getSelectedItem().toString();

            if (result == JOptionPane.YES_OPTION) {
                pst = con.prepareStatement("update students set studentid = ?, studentname = ?,strand = ?,gradeandsection = ? where studentid = ?");
            }
            pst.setString(1, StudentID);
            pst.setString(2, StudentName);
            pst.setString(3, Strand);
            pst.setString(4, GrandSec);
            pst.setString(5, StudentID);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Book Updated");
            stud_table_update();
            studenttable_update();
            txtStudentID.setText("");
            txtStudentName.setText("");
            txtStrand.setSelectedIndex(0);
            txtGrandSec.setSelectedIndex(0);
            txtStudentName.requestFocus();
            book_add.setVisible(true);
            book_delete.setVisible(true);
            book_edit.setVisible(true);
            book_update.setVisible(false);
            db_table.clearSelection();

        } catch (SQLException ex) {
            Logger.getLogger(MANAGESTUDENT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_updatebutton1MouseClicked

    private void updatebutton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatebutton1MouseEntered
        btxtupdate.setVisible(true);
    }//GEN-LAST:event_updatebutton1MouseEntered

    private void updatebutton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatebutton1MouseExited
        btxtupdate.setVisible(false);
    }//GEN-LAST:event_updatebutton1MouseExited

    private void txtupdate1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtupdate1MouseEntered

    }//GEN-LAST:event_txtupdate1MouseEntered

    private void txtupdate1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtupdate1MouseExited

    }//GEN-LAST:event_txtupdate1MouseExited

    private void txtSearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearch1ActionPerformed

    }//GEN-LAST:event_txtSearch1ActionPerformed

    private void txtSearch1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearch1KeyReleased
        String searchString = manageb_search.getText();
        search(searchString);
    }//GEN-LAST:event_txtSearch1KeyReleased

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        String filterString = jComboBox3.getSelectedItem().toString();
        filter(filterString);
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void studtablejTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studtablejTable1MouseClicked

        db_table.setFocusable(true);
        book_edit.setEnabled(true);
        book_delete.setEnabled(true);

    }//GEN-LAST:event_studtablejTable1MouseClicked

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed

    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
        String searchString = db_search.getText();
        search(searchString);
    }//GEN-LAST:event_jTextField2KeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
        String filterString = db_filter.getSelectedItem().toString();
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
            recordstable.print(JTable.PrintMode.FIT_WIDTH, header, footer, true, set, true);
            JOptionPane.showMessageDialog(null, "\n" + "Downloaded Succesfully");
        } catch (java.awt.print.PrinterException e) {
            JOptionPane.showMessageDialog(null, "\n" + "Failed" + "\n" + e);
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed

    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyReleased
        String searchString = db_search.getText();
        search(searchString);
    }//GEN-LAST:event_jTextField3KeyReleased

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        ListSelectionModel selectionModel = db_table.getSelectionModel();
        int rowCount = db_table.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            selectionModel.addSelectionInterval(i, i);
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

        dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void issuebk_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_issuebk_buttonActionPerformed
        String sql = "insert into issue(Student_ID,Student_Name,Strand,Grade_Section,Book_ID,Book_Name,Book_Author,Genre,Book_Quantity,Issue_Date,Due_Date,Date_Return,Status)values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, issuestudid.getText());
            pst.setString(2, issuestudnm.getText());
            pst.setString(3, issuestudstr.getText());
            pst.setString(4, issuestudgrsec.getText());
            pst.setString(5, issuebookid.getText());
            pst.setString(6, issuebooknm.getText());
            pst.setString(7, issuebookau.getText());
            pst.setString(8, issuebookgnr.getText());
            pst.setString(9, issuebookqua.getText());
            pst.setString(10, ((JTextField) issue_issuedate.getDateEditor().getUiComponent()).getText());
            pst.setString(11, ((JTextField) issue_duedate.getDateEditor().getUiComponent()).getText());
            pst.setString(12, "---");
            pst.setString(13, "---");
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Book Issued");
            transactiontableupdate();
            return_details();
            JOptionPane.showMessageDialog(null, "Issue Count Updated");
            issue_count();
            issuestudid.setText("");
            issuestudnm.setText("");
            issuestudstr.setText("");
            issuestudgrsec.setText("");
            issuebookid.setText("");
            issuebooknm.setText("");
            issuebookau.setText("");
            issuebookgnr.setText("");
            issuebookqua.setText("");
            issue_issuedate.setCalendar(null);
            issue_duedate.setCalendar(null);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }


    }//GEN-LAST:event_issuebk_buttonActionPerformed

    private void finddetailsreturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finddetailsreturnActionPerformed
        jTabbedPane1.setSelectedIndex(9);
    }//GEN-LAST:event_finddetailsreturnActionPerformed

    private void returnstudidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnstudidActionPerformed

    }//GEN-LAST:event_returnstudidActionPerformed

    private void returnstudnmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnstudnmActionPerformed

    }//GEN-LAST:event_returnstudnmActionPerformed

    private void returnstudstrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnstudstrActionPerformed

    }//GEN-LAST:event_returnstudstrActionPerformed

    private void returnstudgrsecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnstudgrsecActionPerformed

    }//GEN-LAST:event_returnstudgrsecActionPerformed

    private void returnissudateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnissudateActionPerformed

    }//GEN-LAST:event_returnissudateActionPerformed

    private void return_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_return_buttonActionPerformed
        Delete();
        ReturnUpdate();
        returnstudid.setText("");
        returnstudnm.setText("");
        returnstudstr.setText("");
        returnstudgrsec.setText("");
        returnbookid.setText("");
        returnbooknm.setText("");
        returnbookau.setText("");
        returnbookgnr.setText("");
        returnbookqua.setText("");
        returnissudate.setText("");
        returnduedate.setText("");
        return_datereturned.setCalendar(null);
        transactiontableupdate();
        recordstable_update();
        return_details();
        return_count();
        issue_count();
        JOptionPane.showMessageDialog(null, "Return Count Updated");
    }//GEN-LAST:event_return_buttonActionPerformed

    private void returnbooknmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnbooknmActionPerformed

    }//GEN-LAST:event_returnbooknmActionPerformed

    private void returnbookauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnbookauActionPerformed

    }//GEN-LAST:event_returnbookauActionPerformed

    private void returnbookquaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnbookquaActionPerformed

    }//GEN-LAST:event_returnbookquaActionPerformed

    private void returnbookidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnbookidActionPerformed

    }//GEN-LAST:event_returnbookidActionPerformed

    private void returnbookgnrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnbookgnrActionPerformed

    }//GEN-LAST:event_returnbookgnrActionPerformed

    private void returnduedateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnduedateActionPerformed

    }//GEN-LAST:event_returnduedateActionPerformed

    private void issuestudlistjTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_issuestudlistjTable1MouseClicked

    }//GEN-LAST:event_issuestudlistjTable1MouseClicked

    private void txtSearch2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearch2ActionPerformed

    }//GEN-LAST:event_txtSearch2ActionPerformed

    private void txtSearch2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearch2KeyReleased

    }//GEN-LAST:event_txtSearch2KeyReleased

    private void issuebooklistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_issuebooklistMouseClicked

    }//GEN-LAST:event_issuebooklistMouseClicked

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

    private void finddetailsreturnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_finddetailsreturnMouseClicked
        jTabbedPane1.setSelectedIndex(9);
    }//GEN-LAST:event_finddetailsreturnMouseClicked

    private void ret_find_butActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ret_find_butActionPerformed
        DefaultTableModel model = (DefaultTableModel) findreturndetails.getModel();
        int SelectedRows = findreturndetails.convertRowIndexToModel(findreturndetails.getSelectedRow());

        returnstudid.setText(model.getValueAt(SelectedRows, 0).toString());
        returnstudnm.setText(model.getValueAt(SelectedRows, 1).toString());
        returnstudstr.setText(model.getValueAt(SelectedRows, 2).toString());
        returnstudgrsec.setText(model.getValueAt(SelectedRows, 3).toString());
        returnbookid.setText(model.getValueAt(SelectedRows, 4).toString());
        returnbooknm.setText(model.getValueAt(SelectedRows, 5).toString());
        returnbookau.setText(model.getValueAt(SelectedRows, 6).toString());
        returnbookgnr.setText(model.getValueAt(SelectedRows, 7).toString());
        returnbookqua.setText(model.getValueAt(SelectedRows, 8).toString());
        returnissudate.setText(model.getValueAt(SelectedRows, 9).toString());
        returnduedate.setText(model.getValueAt(SelectedRows, 10).toString());

        jTabbedPane1.setSelectedIndex(8);
        return_button.setEnabled(true);
    }//GEN-LAST:event_ret_find_butActionPerformed

    private void issuefindstudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_issuefindstudActionPerformed
        DefaultTableModel model = (DefaultTableModel) issuestudlist.getModel();
        int SelectedRows = issuestudlist.convertRowIndexToModel(issuestudlist.getSelectedRow());

        issuestudid.setText(model.getValueAt(SelectedRows, 0).toString());
        issuestudnm.setText(model.getValueAt(SelectedRows, 1).toString());
        issuestudstr.setText(model.getValueAt(SelectedRows, 2).toString());
        issuestudgrsec.setText(model.getValueAt(SelectedRows, 3).toString());

        jTabbedPane1.setSelectedIndex(5);
    }//GEN-LAST:event_issuefindstudActionPerformed

    private void issuefindbooklistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_issuefindbooklistActionPerformed
        DefaultTableModel model = (DefaultTableModel) issuebooklist.getModel();
        int SelectedRows = issuebooklist.convertRowIndexToModel(issuebooklist.getSelectedRow());

        issuebookid.setText(model.getValueAt(SelectedRows, 0).toString());
        issuebooknm.setText(model.getValueAt(SelectedRows, 1).toString());
        issuebookau.setText(model.getValueAt(SelectedRows, 2).toString());
        issuebookgnr.setText(model.getValueAt(SelectedRows, 3).toString());
        issuebookqua.setText(model.getValueAt(SelectedRows, 4).toString());

        jTabbedPane1.setSelectedIndex(5);
    }//GEN-LAST:event_issuefindbooklistActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            String input = JOptionPane.showInputDialog("Add a genre");
            pst = con.prepareStatement("insert into combobox (genre) values(?)");
            pst.setString(1, input);
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Statement st = con.createStatement();
            ResultSet Rs = st.executeQuery("SELECT genre from combobox");
            while (Rs.next()) {
                String genre = Rs.getString("genre");
                genrecombobox.addItem(genre);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void dashboardAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_dashboardAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_dashboardAncestorAdded

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
         dispose();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
         dispose();
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton14ActionPerformed

    private void issuebookgnrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_issuebookgnrActionPerformed

    }//GEN-LAST:event_issuebookgnrActionPerformed

    private void issuebookquaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_issuebookquaActionPerformed

    }//GEN-LAST:event_issuebookquaActionPerformed

    private void issuebookauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_issuebookauActionPerformed

    }//GEN-LAST:event_issuebookauActionPerformed

    private void issuebooknmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_issuebooknmActionPerformed

    }//GEN-LAST:event_issuebooknmActionPerformed

    private void issuebookidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_issuebookidActionPerformed

    }//GEN-LAST:event_issuebookidActionPerformed

    private void Search2Search1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Search2Search1ActionPerformed

        bookpanel.setVisible(true);
    }//GEN-LAST:event_Search2Search1ActionPerformed

    private void Search2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Search2MouseClicked
       
    }//GEN-LAST:event_Search2MouseClicked

    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchActionPerformed
        
        
        studentpanel.setVisible(true);
        
    }//GEN-LAST:event_SearchActionPerformed

    private void SearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchMouseClicked
        
    }//GEN-LAST:event_SearchMouseClicked

    private void issuestudstrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_issuestudstrActionPerformed

    }//GEN-LAST:event_issuestudstrActionPerformed

    private void issuestudgrsecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_issuestudgrsecActionPerformed

    }//GEN-LAST:event_issuestudgrsecActionPerformed

    private void issuestudnmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_issuestudnmActionPerformed

    }//GEN-LAST:event_issuestudnmActionPerformed

    private void issuestudidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_issuestudidActionPerformed

    }//GEN-LAST:event_issuestudidActionPerformed

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
        resetColor(t5);
    }//GEN-LAST:event_recMousePressed

    private void recMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recMouseExited
        setColor(t5);
    }//GEN-LAST:event_recMouseExited

    private void recMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recMouseEntered

    }//GEN-LAST:event_recMouseEntered

    private void recMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recMouseClicked
        jTabbedPane1.setSelectedIndex(4);
    }//GEN-LAST:event_recMouseClicked

    private void transMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transMousePressed
        resetColor(t4);
    }//GEN-LAST:event_transMousePressed

    private void transMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transMouseExited
        setColor(t4);
    }//GEN-LAST:event_transMouseExited

    private void transMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transMouseEntered

    }//GEN-LAST:event_transMouseEntered

    private void transMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transMouseClicked
        jTabbedPane1.setSelectedIndex(3);
    }//GEN-LAST:event_transMouseClicked

    private void studentsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentsMousePressed
        resetColor(t3);

    }//GEN-LAST:event_studentsMousePressed

    private void studentsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentsMouseExited
        setColor(t3);
    }//GEN-LAST:event_studentsMouseExited

    private void studentsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentsMouseEntered

    }//GEN-LAST:event_studentsMouseEntered

    private void studentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentsMouseClicked
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_studentsMouseClicked

    private void booksMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_booksMouseReleased

    }//GEN-LAST:event_booksMouseReleased

    private void booksMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_booksMousePressed
        resetColor(t2);
    }//GEN-LAST:event_booksMousePressed

    private void booksMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_booksMouseExited
        setColor(t2);
    }//GEN-LAST:event_booksMouseExited

    private void booksMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_booksMouseEntered

    }//GEN-LAST:event_booksMouseEntered

    private void booksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_booksMouseClicked
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_booksMouseClicked

    private void dashMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashMouseReleased

    }//GEN-LAST:event_dashMouseReleased

    private void dashMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashMousePressed
        resetColor(t1);
    }//GEN-LAST:event_dashMousePressed

    private void dashMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashMouseExited
        setColor(t1);
    }//GEN-LAST:event_dashMouseExited

    private void dashMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashMouseEntered

    }//GEN-LAST:event_dashMouseEntered

    private void dashMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashMouseClicked
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_dashMouseClicked

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        jTabbedPane1.setSelectedIndex(3);
    }//GEN-LAST:event_jLabel17MouseClicked

    private void jLabel76MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel76MouseClicked
       jTabbedPane1.setSelectedIndex(3);
    }//GEN-LAST:event_jLabel76MouseClicked

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
       jTabbedPane1.setSelectedIndex(8);
    }//GEN-LAST:event_jLabel19MouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        jTabbedPane1.setSelectedIndex(5);
    }//GEN-LAST:event_jLabel13MouseClicked

    private void SearchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchMouseEntered

    private void issuestudlist1jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_issuestudlist1jTable1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_issuestudlist1jTable1MouseClicked

    private void issuefindstud1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_issuefindstud1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_issuefindstud1ActionPerformed

    private void txtSearch5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearch5KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearch5KeyReleased

    private void txtSearch5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearch5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearch5ActionPerformed

    private void txtSearch7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearch7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearch7ActionPerformed

    private void txtSearch7KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearch7KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearch7KeyReleased

    private void issuebooklist1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_issuebooklist1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_issuebooklist1MouseClicked

    private void issuefindbooklist1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_issuefindbooklist1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_issuefindbooklist1ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        jTabbedPane1.setSelectedIndex(6);
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
     jTabbedPane1.setSelectedIndex(6);
    }//GEN-LAST:event_jButton17ActionPerformed

    private void txtSearch6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearch6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearch6ActionPerformed

    private void txtSearch6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearch6KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearch6KeyReleased

    private void ret_find_but1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ret_find_but1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ret_find_but1ActionPerformed

    private void findreturndetails1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_findreturndetails1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_findreturndetails1MouseClicked

    private void jLabel81MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel81MouseClicked
        jTabbedPane1.setSelectedIndex(8);
    }//GEN-LAST:event_jLabel81MouseClicked

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
    private javax.swing.JLabel addbutton1;
    private javax.swing.JPanel book;
    private javax.swing.JLabel book_add;
    private javax.swing.JLabel book_delete;
    private javax.swing.JLabel book_edit;
    private javax.swing.JLabel book_update;
    private javax.swing.JLabel bookcount;
    private javax.swing.JPanel bookpanel;
    private javax.swing.JLabel books;
    private javax.swing.JLabel btextadd;
    private javax.swing.JLabel btxtedit;
    private javax.swing.JLabel btxtremove;
    private javax.swing.JLabel btxtupdate;
    private javax.swing.JLabel dash;
    private javax.swing.JPanel dashboard;
    private javax.swing.JComboBox<String> db_filter;
    private javax.swing.JTextField db_search;
    private javax.swing.JTable db_table;
    private javax.swing.JLabel deletebutton1;
    private javax.swing.JPanel details;
    private javax.swing.JPanel detailspanel;
    private javax.swing.JLabel editbutton1;
    private javax.swing.JButton finddetailsreturn;
    private javax.swing.JTable findreturndetails;
    private javax.swing.JTable findreturndetails1;
    private javax.swing.JComboBox<String> genrecombobox;
    private javax.swing.JButton issue;
    private com.toedter.calendar.JDateChooser issue_duedate;
    private com.toedter.calendar.JDateChooser issue_issuedate;
    private javax.swing.JButton issuebk_button;
    private javax.swing.JPanel issuebook;
    private javax.swing.JTextField issuebookau;
    private javax.swing.JTextField issuebookgnr;
    private javax.swing.JTextField issuebookid;
    private javax.swing.JTable issuebooklist;
    private javax.swing.JTable issuebooklist1;
    private javax.swing.JTextField issuebooknm;
    private javax.swing.JTextField issuebookqua;
    private javax.swing.JLabel issuedbcount;
    private javax.swing.JButton issuefindbooklist;
    private javax.swing.JButton issuefindbooklist1;
    private javax.swing.JButton issuefindstud;
    private javax.swing.JButton issuefindstud1;
    private javax.swing.JTextField issuestudgrsec;
    private javax.swing.JTextField issuestudid;
    private javax.swing.JTable issuestudlist;
    private javax.swing.JTable issuestudlist1;
    private javax.swing.JTextField issuestudnm;
    private javax.swing.JTextField issuestudstr;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox<String> jComboBox10;
    private javax.swing.JComboBox<String> jComboBox11;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JComboBox<String> jComboBox7;
    private javax.swing.JComboBox<String> jComboBox8;
    private javax.swing.JComboBox<String> jComboBox9;
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
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
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
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JComboBox<String> manageb_filter;
    private javax.swing.JTextField manageb_search;
    private javax.swing.JTable manageb_table;
    private javax.swing.JPanel managebook;
    private javax.swing.JPanel managestudent;
    private javax.swing.JLabel rec;
    private javax.swing.JPanel records;
    private javax.swing.JTable recordstable;
    private javax.swing.JButton ret_find_but;
    private javax.swing.JButton ret_find_but1;
    private javax.swing.JButton return_button;
    private com.toedter.calendar.JDateChooser return_datereturned;
    private javax.swing.JPanel returnbook;
    private javax.swing.JTextField returnbookau;
    private javax.swing.JTextField returnbookgnr;
    private javax.swing.JTextField returnbookid;
    private javax.swing.JTextField returnbooknm;
    private javax.swing.JTextField returnbookqua;
    private javax.swing.JTextField returnduedate;
    private javax.swing.JLabel returnedbcount;
    private javax.swing.JTextField returnissudate;
    private javax.swing.JButton returns;
    private javax.swing.JTextField returnstudgrsec;
    private javax.swing.JTextField returnstudid;
    private javax.swing.JTextField returnstudnm;
    private javax.swing.JTextField returnstudstr;
    private javax.swing.JPanel student;
    private javax.swing.JLabel studentcount;
    private javax.swing.JPanel studentpanel;
    private javax.swing.JLabel students;
    private javax.swing.JTable studtable;
    private javax.swing.JPanel t1;
    private javax.swing.JPanel t2;
    private javax.swing.JPanel t3;
    private javax.swing.JPanel t4;
    private javax.swing.JPanel t5;
    private javax.swing.JLabel textadd1;
    private javax.swing.JLabel trans;
    private javax.swing.JPanel transaction;
    private javax.swing.JTable transactiontable;
    private javax.swing.JTextField txtBookAuthor;
    private javax.swing.JTextField txtBookID;
    private javax.swing.JTextField txtBookName;
    private javax.swing.JComboBox<String> txtGrandSec;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtSearch1;
    private javax.swing.JTextField txtSearch2;
    private javax.swing.JTextField txtSearch3;
    private javax.swing.JTextField txtSearch4;
    private javax.swing.JTextField txtSearch5;
    private javax.swing.JTextField txtSearch6;
    private javax.swing.JTextField txtSearch7;
    private javax.swing.JComboBox<String> txtStrand;
    private javax.swing.JTextField txtStudentID;
    private javax.swing.JTextField txtStudentName;
    private javax.swing.JLabel txtedit1;
    private javax.swing.JLabel txtremove1;
    private javax.swing.JLabel txtupdate1;
    private javax.swing.JLabel updatebutton1;
    // End of variables declaration//GEN-END:variables
}
