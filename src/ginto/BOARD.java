package ginto;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
import java.util.Date;
import javax.swing.DefaultComboBoxModel;

public class BOARD extends javax.swing.JFrame {

    public BOARD() {
        initComponents();
        Connect();
        db_table_update();
        db2_table_update();
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
        overdue();
        overdue_update();
        combobxforgenre();
        combobxforsec();

        setBackground(new Color(0, 0, 0));

        db_table.getTableHeader().setFont(new Font("Century Gothic", Font.BOLD, 12));
        db_table.getTableHeader().setOpaque(false);
        db_table.getTableHeader().setBackground(new Color(11, 0, 50));
        db_table.getTableHeader().setForeground(new Color(11, 0, 50));
        db_table.setRowHeight(25);

        db2_table.getTableHeader().setFont(new Font("Century Gothic", Font.BOLD, 12));
        db2_table.getTableHeader().setOpaque(false);
        db2_table.getTableHeader().setBackground(new Color(11, 0, 50));
        db2_table.getTableHeader().setForeground(new Color(11, 0, 50));
        db2_table.setRowHeight(25);

        manageb_table.getTableHeader().setFont(new Font("Century Gothic", Font.BOLD, 12));
        manageb_table.getTableHeader().setOpaque(false);
        manageb_table.getTableHeader().setBackground(new Color(11, 0, 50));
        manageb_table.getTableHeader().setForeground(new Color(11, 0, 50));
        manageb_table.setRowHeight(25);

        studtable.getTableHeader().setFont(new Font("Century Gothic", Font.BOLD, 12));
        studtable.getTableHeader().setOpaque(false);
        studtable.getTableHeader().setBackground(new Color(11, 0, 50));
        studtable.getTableHeader().setForeground(new Color(11, 0, 50));
        studtable.setRowHeight(25);

        transactiontable.getTableHeader().setFont(new Font("Century Gothic", Font.BOLD, 12));
        transactiontable.getTableHeader().setOpaque(false);
        transactiontable.getTableHeader().setBackground(new Color(11, 0, 50));
        transactiontable.getTableHeader().setForeground(new Color(11, 0, 50));
        transactiontable.setRowHeight(25);

        recordstable.getTableHeader().setFont(new Font("Century Gothic", Font.BOLD, 12));
        recordstable.getTableHeader().setOpaque(false);
        recordstable.getTableHeader().setBackground(new Color(11, 0, 50));
        recordstable.getTableHeader().setForeground(new Color(11, 0, 50));
        recordstable.setRowHeight(25);

        issuestudlist.getTableHeader().setFont(new Font("Century Gothic", Font.BOLD, 12));
        issuestudlist.getTableHeader().setOpaque(false);
        issuestudlist.getTableHeader().setBackground(new Color(11, 0, 50));
        issuestudlist.getTableHeader().setForeground(new Color(0, 0, 0));
        issuestudlist.setRowHeight(25);

        issuebooklist.getTableHeader().setFont(new Font("Century Gothic", Font.BOLD, 12));
        issuebooklist.getTableHeader().setOpaque(false);
        issuebooklist.getTableHeader().setBackground(new Color(11, 0, 50));
        issuebooklist.getTableHeader().setForeground(new Color(11, 0, 50));
        issuebooklist.setRowHeight(25);

        findreturndetails.getTableHeader().setFont(new Font("Century Gothic", Font.BOLD, 12));
        findreturndetails.getTableHeader().setOpaque(false);
        findreturndetails.getTableHeader().setBackground(new Color(11, 0, 50));
        findreturndetails.getTableHeader().setForeground(new Color(11, 0, 50));
        findreturndetails.setRowHeight(25);

    }

    Connection con;
    PreparedStatement pst;
    DefaultTableModel model;

    public void Connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://sql6.freesqldatabase.com/sql6695512", "sql6695512", "GFTh9FuTKq");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BOARD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BOARD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void db_table_update() {
        int CC;
        try {

            pst = con.prepareStatement("SELECT * FROM issue");
            ResultSet Rs = pst.executeQuery();

            ResultSetMetaData RSMD = Rs.getMetaData();
            CC = RSMD.getColumnCount();
            DefaultTableModel DFT = (DefaultTableModel) db_table.getModel();
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

    private void db2_table_update() {
        int CC;
        try {

            pst = con.prepareStatement("SELECT * FROM returnbook");
            ResultSet Rs = pst.executeQuery();

            ResultSetMetaData RSMD = Rs.getMetaData();
            CC = RSMD.getColumnCount();
            DefaultTableModel DFT = (DefaultTableModel) db2_table.getModel();
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

                    v2.add(Rs.getString("id"));
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

                    v2.add(Rs.getString("id"));
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

    private void overdue() {
        Date date = Calendar.getInstance().getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, yyy");
        String strDate = dateFormat.format(date);

        try {
            pst = con.prepareStatement("update issue set Date_Today=? ");
            pst.setString(1, strDate);

            pst.executeUpdate();

            transactiontableupdate();
            db_table_update();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void overdue_update() {
        try {
            pst = con.prepareStatement("update issue set Status = ? where Due_Date < Date_Today");
            pst.setString(1, "Overdue");

            pst.executeUpdate();
            transactiontableupdate();
            db_table_update();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void combobxforgenre() {
        genrecombobox.setModel(new DefaultComboBoxModel(new String[]{"..."}));
        manageb_filter.setModel(new DefaultComboBoxModel(new String[]{"..."}));
        booklistfilter.setModel(new DefaultComboBoxModel(new String[]{"..."}));
        try {
            Statement st = con.createStatement();
            ResultSet Rs = st.executeQuery("SELECT genre from combobox");
            while (Rs.next()) {
                String genre = Rs.getString("genre");
                genrecombobox.addItem(genre);
                manageb_filter.addItem(genre);
                booklistfilter.addItem(genre);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void combobxforsec() {
        txtGrandSec.setModel(new DefaultComboBoxModel(new String[]{"..."}));
        db_filter2.setModel(new DefaultComboBoxModel(new String[]{"..."}));
        studfilter.setModel(new DefaultComboBoxModel(new String[]{"..."}));
        recordsfilter.setModel(new DefaultComboBoxModel(new String[]{"..."}));
        retdetailsfilter.setModel(new DefaultComboBoxModel(new String[]{"..."}));
        studlist.setModel(new DefaultComboBoxModel(new String[]{"..."}));
        try {
            Statement st = con.createStatement();
            ResultSet Rs = st.executeQuery("SELECT grsec from grandseccombo");
            while (Rs.next()) {
                String grandsec = Rs.getString("grsec");
                txtGrandSec.addItem(grandsec);
                db_filter2.addItem(grandsec);
                studfilter.addItem(grandsec);
                recordsfilter.addItem(grandsec);
                retdetailsfilter.addItem(grandsec);
                studlist.addItem(grandsec);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void deleterecords() {
        try {
            pst = con.prepareStatement("TRUNCATE returnbook");
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Records deleted");
            recordstable_update();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void search(String str) {
        model = (DefaultTableModel) db_table.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
        db_table.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter("(?i)" + str));
    }

    public void managestudsearch(String str) {
        model = (DefaultTableModel) studtable.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
        studtable.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter("(?i)" + str));
    }

    public void managebooksearch(String str) {
        model = (DefaultTableModel) manageb_table.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
        manageb_table.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter("(?i)" + str));
    }

    public void transactionsearch(String str) {
        model = (DefaultTableModel) transactiontable.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
        transactiontable.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter("(?i)" + str));
    }

    public void recordssearch(String str) {
        model = (DefaultTableModel) recordstable.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
        recordstable.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter("(?i)" + str));
    }

    public void issueslssearch(String str) {
        model = (DefaultTableModel) issuestudlist.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
        issuestudlist.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter("(?i)" + str));
    }

    public void issuebooklstsearch(String str) {
        model = (DefaultTableModel) issuebooklist.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
        issuebooklist.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter("(?i)" + str));
    }

    public void detailssearch(String str) {
        model = (DefaultTableModel) findreturndetails.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
        findreturndetails.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter("(?i)" + str));
    }

    public void db2search(String str) {
        model = (DefaultTableModel) db2_table.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
        db2_table.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter("(?i)" + str));
    }

    public void dbfilter(String str) {
        model = (DefaultTableModel) db_table.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
        db_table.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(str));
    }

    public void db2filter(String str) {
        model = (DefaultTableModel) db2_table.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
        db2_table.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(str));
    }

    public void managebfilter(String str) {
        model = (DefaultTableModel) manageb_table.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
        manageb_table.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(str));
    }

    public void studfiltertab(String str) {
        model = (DefaultTableModel) studtable.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
        studtable.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(str));
    }

    public void transactionfiltertab(String str) {
        model = (DefaultTableModel) transactiontable.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
        transactiontable.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(str));
    }

    public void recordfiltertab(String str) {
        model = (DefaultTableModel) recordstable.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
        recordstable.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(str));
    }

    public void issuestudfilter(String str) {
        model = (DefaultTableModel) issuestudlist.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
        issuestudlist.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(str));
    }

    public void issuebookfilter(String str) {
        model = (DefaultTableModel) issuebooklist.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
        issuebooklist.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(str));
    }

    public void findreturnfilter(String str) {
        model = (DefaultTableModel) findreturndetails.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
        findreturndetails.setRowSorter(trs);
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
        db_search1 = new javax.swing.JTextField();
        jLabel78 = new javax.swing.JLabel();
        db_filter2 = new javax.swing.JComboBox<>();
        jPanel13 = new javax.swing.JPanel();
        a7 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        j = new javax.swing.JPanel();
        ex1 = new javax.swing.JLabel();
        j2 = new javax.swing.JPanel();
        hide1 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        db2_table = new javax.swing.JTable();
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
        jButton18 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        optadd = new javax.swing.JLabel();
        optdel = new javax.swing.JLabel();
        jPanel38 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        ex2 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        hide2 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
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
        stud_add = new javax.swing.JLabel();
        stud_edit = new javax.swing.JLabel();
        stud_delete = new javax.swing.JLabel();
        stud_update = new javax.swing.JLabel();
        textadd1 = new javax.swing.JLabel();
        txtedit1 = new javax.swing.JLabel();
        txtupdate1 = new javax.swing.JLabel();
        txtremove1 = new javax.swing.JLabel();
        jButton15 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        addopt = new javax.swing.JLabel();
        delopt = new javax.swing.JLabel();
        jButton28 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        addopt1 = new javax.swing.JLabel();
        delopt1 = new javax.swing.JLabel();
        jPanel39 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jPanel34 = new javax.swing.JPanel();
        ex3 = new javax.swing.JLabel();
        jPanel36 = new javax.swing.JPanel();
        hide3 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        searchmanagstud = new javax.swing.JTextField();
        studfilter = new javax.swing.JComboBox<>();
        jScrollPane6 = new javax.swing.JScrollPane();
        studtable = new javax.swing.JTable();
        transaction = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        transactionssearch = new javax.swing.JTextField();
        transacfilter = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        transactiontable = new javax.swing.JTable();
        issue = new javax.swing.JButton();
        returns = new javax.swing.JButton();
        jPanel24 = new javax.swing.JPanel();
        a8 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jPanel37 = new javax.swing.JPanel();
        ex4 = new javax.swing.JLabel();
        jPanel40 = new javax.swing.JPanel();
        hide4 = new javax.swing.JLabel();
        jPanel51 = new javax.swing.JPanel();
        ex10 = new javax.swing.JLabel();
        records = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        recordsfilter = new javax.swing.JComboBox<>();
        recordssearch = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        recordstable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jPanel26 = new javax.swing.JPanel();
        a9 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jPanel41 = new javax.swing.JPanel();
        ex5 = new javax.swing.JLabel();
        jPanel42 = new javax.swing.JPanel();
        hide5 = new javax.swing.JLabel();
        issuebook = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        issuebk_button = new javax.swing.JButton();
        issue_issuedate = new com.toedter.calendar.JDateChooser();
        issue_duedate = new com.toedter.calendar.JDateChooser();
        jLabel54 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
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
        jPanel33 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        a13 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jPanel43 = new javax.swing.JPanel();
        ex6 = new javax.swing.JLabel();
        jPanel44 = new javax.swing.JPanel();
        hide6 = new javax.swing.JLabel();
        student = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        issuestudlist = new javax.swing.JTable();
        jLabel70 = new javax.swing.JLabel();
        studlistsearch = new javax.swing.JTextField();
        studlist = new javax.swing.JComboBox<>();
        issuefindstud = new javax.swing.JButton();
        jPanel27 = new javax.swing.JPanel();
        jLabel80 = new javax.swing.JLabel();
        a10 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jPanel45 = new javax.swing.JPanel();
        ex7 = new javax.swing.JLabel();
        jPanel46 = new javax.swing.JPanel();
        hide7 = new javax.swing.JLabel();
        book = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        issuebooklist = new javax.swing.JTable();
        jLabel71 = new javax.swing.JLabel();
        booklistsearch = new javax.swing.JTextField();
        booklistfilter = new javax.swing.JComboBox<>();
        issuefindbooklist = new javax.swing.JButton();
        jPanel30 = new javax.swing.JPanel();
        jLabel81 = new javax.swing.JLabel();
        a11 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        hide = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        ex = new javax.swing.JLabel();
        returnbook = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
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
        jLabel73 = new javax.swing.JLabel();
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
        returnbookid = new javax.swing.JTextField();
        jLabel69 = new javax.swing.JLabel();
        returnbookgnr = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        return_button = new javax.swing.JButton();
        return_datereturned = new com.toedter.calendar.JDateChooser();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        returnduedate = new javax.swing.JTextField();
        returnissudate = new javax.swing.JTextField();
        jLabel61 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jPanel35 = new javax.swing.JPanel();
        jLabel76 = new javax.swing.JLabel();
        a15 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jPanel47 = new javax.swing.JPanel();
        ex8 = new javax.swing.JLabel();
        jPanel48 = new javax.swing.JPanel();
        hide8 = new javax.swing.JLabel();
        details = new javax.swing.JPanel();
        jLabel72 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        findreturndetails = new javax.swing.JTable();
        retdetailsfilter = new javax.swing.JComboBox<>();
        ret_find_but = new javax.swing.JButton();
        jPanel31 = new javax.swing.JPanel();
        jLabel82 = new javax.swing.JLabel();
        a16 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jPanel49 = new javax.swing.JPanel();
        ex9 = new javax.swing.JLabel();
        jPanel50 = new javax.swing.JPanel();
        hide9 = new javax.swing.JLabel();
        detailsssearch = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
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
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();

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

        dashboard.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 270, 105));

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

        dashboard.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 100, 270, 105));

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

        dashboard.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 100, 270, 105));

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

        dashboard.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 100, 270, 105));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/1w.png"))); // NOI18N
        dashboard.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));

        db_search.setBackground(new java.awt.Color(11, 0, 40));
        db_search.setForeground(new java.awt.Color(255, 255, 255));
        db_search.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 255, 255)));
        db_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                db_searchActionPerformed(evt);
            }
        });
        db_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                db_searchKeyReleased(evt);
            }
        });
        dashboard.add(db_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 250, 30));

        db_filter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "...", "Pending", "Overdue" }));
        db_filter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                db_filterActionPerformed(evt);
            }
        });
        dashboard.add(db_filter, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 220, 120, 30));

        db_table.setBackground(new java.awt.Color(255, 255, 255));
        db_table.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        db_table.setForeground(new java.awt.Color(0, 0, 0));
        db_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Student Name", "Strand", "Gr. & Sec.", "Book ID", "Book Name", "Book Author", "Genre", "Quantity", "Issue Date", "Due Date", "Return Date", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

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
            db_table.getColumnModel().getColumn(0).setMinWidth(0);
            db_table.getColumnModel().getColumn(0).setPreferredWidth(0);
            db_table.getColumnModel().getColumn(0).setMaxWidth(0);
            db_table.getColumnModel().getColumn(1).setPreferredWidth(150);
            db_table.getColumnModel().getColumn(2).setMinWidth(0);
            db_table.getColumnModel().getColumn(2).setPreferredWidth(0);
            db_table.getColumnModel().getColumn(2).setMaxWidth(0);
            db_table.getColumnModel().getColumn(3).setMinWidth(0);
            db_table.getColumnModel().getColumn(3).setPreferredWidth(0);
            db_table.getColumnModel().getColumn(3).setMaxWidth(0);
            db_table.getColumnModel().getColumn(4).setMinWidth(0);
            db_table.getColumnModel().getColumn(4).setPreferredWidth(0);
            db_table.getColumnModel().getColumn(4).setMaxWidth(0);
            db_table.getColumnModel().getColumn(5).setPreferredWidth(150);
            db_table.getColumnModel().getColumn(6).setMinWidth(0);
            db_table.getColumnModel().getColumn(6).setPreferredWidth(0);
            db_table.getColumnModel().getColumn(6).setMaxWidth(0);
            db_table.getColumnModel().getColumn(7).setMinWidth(0);
            db_table.getColumnModel().getColumn(7).setPreferredWidth(0);
            db_table.getColumnModel().getColumn(7).setMaxWidth(0);
            db_table.getColumnModel().getColumn(8).setMinWidth(0);
            db_table.getColumnModel().getColumn(8).setPreferredWidth(0);
            db_table.getColumnModel().getColumn(8).setMaxWidth(0);
            db_table.getColumnModel().getColumn(9).setMinWidth(80);
            db_table.getColumnModel().getColumn(9).setPreferredWidth(80);
            db_table.getColumnModel().getColumn(9).setMaxWidth(80);
            db_table.getColumnModel().getColumn(10).setMinWidth(0);
            db_table.getColumnModel().getColumn(10).setPreferredWidth(0);
            db_table.getColumnModel().getColumn(10).setMaxWidth(0);
            db_table.getColumnModel().getColumn(11).setMinWidth(0);
            db_table.getColumnModel().getColumn(11).setPreferredWidth(0);
            db_table.getColumnModel().getColumn(11).setMaxWidth(0);
            db_table.getColumnModel().getColumn(12).setMinWidth(80);
            db_table.getColumnModel().getColumn(12).setPreferredWidth(80);
            db_table.getColumnModel().getColumn(12).setMaxWidth(80);
        }

        dashboard.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 530, 500));

        db_search1.setBackground(new java.awt.Color(11, 0, 40));
        db_search1.setForeground(new java.awt.Color(255, 255, 255));
        db_search1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 255, 255)));
        db_search1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                db_search1ActionPerformed(evt);
            }
        });
        db_search1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                db_search1KeyReleased(evt);
            }
        });
        dashboard.add(db_search1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 220, 250, 30));

        jLabel78.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/1w.png"))); // NOI18N
        dashboard.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 220, -1, -1));

        db_filter2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "ABM", "HUMSS", "ICT", "General Reference", "Fiction", "Core Subject" }));
        db_filter2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                db_filter2ActionPerformed(evt);
            }
        });
        dashboard.add(db_filter2, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 220, -1, 30));

        jPanel13.setBackground(new java.awt.Color(16, 0, 61));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        a7.setFont(new java.awt.Font("Segoe UI", 1, 50)); // NOI18N
        a7.setForeground(new java.awt.Color(255, 255, 255));
        a7.setText("DASHBOARD");
        jPanel13.add(a7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 390, 60));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-dashboard-60.png"))); // NOI18N
        jPanel13.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 0, 60, 60));

        j.setBackground(new java.awt.Color(16, 0, 61));
        j.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ex1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-x-30.png"))); // NOI18N
        ex1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ex1MouseClicked(evt);
            }
        });
        j.add(ex1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 40));

        jPanel13.add(j, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 10, 30, 40));

        j2.setBackground(new java.awt.Color(16, 0, 61));
        j2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        hide1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-minus-30.png"))); // NOI18N
        hide1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hide1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                hide1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                hide1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                hide1MousePressed(evt);
            }
        });
        j2.add(hide1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 40));

        jPanel13.add(j2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 10, 30, 40));

        dashboard.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1120, 60));

        db2_table.setBackground(new java.awt.Color(255, 255, 255));
        db2_table.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        db2_table.setForeground(new java.awt.Color(0, 0, 0));
        db2_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Student Name", "Strand", "Gr. & Sec.", "Book ID", "Book Name", "Book Author", "Genre", "Quantity", "Issue Date", "Due Date", "Return Date", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        db2_table.setGridColor(new java.awt.Color(0, 0, 0));
        db2_table.setSelectionBackground(new java.awt.Color(153, 153, 153));
        db2_table.setSelectionForeground(new java.awt.Color(0, 0, 0));
        db2_table.setShowGrid(true);
        db2_table.setSurrendersFocusOnKeystroke(true);
        db2_table.getTableHeader().setResizingAllowed(false);
        db2_table.getTableHeader().setReorderingAllowed(false);
        jScrollPane10.setViewportView(db2_table);
        if (db2_table.getColumnModel().getColumnCount() > 0) {
            db2_table.getColumnModel().getColumn(0).setMinWidth(0);
            db2_table.getColumnModel().getColumn(0).setPreferredWidth(0);
            db2_table.getColumnModel().getColumn(0).setMaxWidth(0);
            db2_table.getColumnModel().getColumn(1).setPreferredWidth(150);
            db2_table.getColumnModel().getColumn(2).setMinWidth(0);
            db2_table.getColumnModel().getColumn(2).setPreferredWidth(0);
            db2_table.getColumnModel().getColumn(2).setMaxWidth(0);
            db2_table.getColumnModel().getColumn(3).setMinWidth(0);
            db2_table.getColumnModel().getColumn(3).setPreferredWidth(0);
            db2_table.getColumnModel().getColumn(3).setMaxWidth(0);
            db2_table.getColumnModel().getColumn(4).setMinWidth(0);
            db2_table.getColumnModel().getColumn(4).setPreferredWidth(0);
            db2_table.getColumnModel().getColumn(4).setMaxWidth(0);
            db2_table.getColumnModel().getColumn(5).setPreferredWidth(150);
            db2_table.getColumnModel().getColumn(6).setMinWidth(0);
            db2_table.getColumnModel().getColumn(6).setPreferredWidth(0);
            db2_table.getColumnModel().getColumn(6).setMaxWidth(0);
            db2_table.getColumnModel().getColumn(7).setMinWidth(0);
            db2_table.getColumnModel().getColumn(7).setPreferredWidth(0);
            db2_table.getColumnModel().getColumn(7).setMaxWidth(0);
            db2_table.getColumnModel().getColumn(8).setMinWidth(0);
            db2_table.getColumnModel().getColumn(8).setPreferredWidth(0);
            db2_table.getColumnModel().getColumn(8).setMaxWidth(0);
            db2_table.getColumnModel().getColumn(9).setMinWidth(80);
            db2_table.getColumnModel().getColumn(9).setPreferredWidth(80);
            db2_table.getColumnModel().getColumn(9).setMaxWidth(80);
            db2_table.getColumnModel().getColumn(10).setMinWidth(0);
            db2_table.getColumnModel().getColumn(10).setPreferredWidth(0);
            db2_table.getColumnModel().getColumn(10).setMaxWidth(0);
            db2_table.getColumnModel().getColumn(11).setMinWidth(0);
            db2_table.getColumnModel().getColumn(11).setPreferredWidth(0);
            db2_table.getColumnModel().getColumn(11).setMaxWidth(0);
            db2_table.getColumnModel().getColumn(12).setMinWidth(80);
            db2_table.getColumnModel().getColumn(12).setPreferredWidth(80);
            db2_table.getColumnModel().getColumn(12).setMaxWidth(80);
        }

        dashboard.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 260, 530, 500));

        jTabbedPane1.addTab("DASHBOARD", dashboard);

        managebook.setBackground(new java.awt.Color(11, 0, 40));
        managebook.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(11, 0, 40));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(255, 255, 255)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-books-90.png"))); // NOI18N
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, -1, -1));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Add a Book");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 110, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Book ID :");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 60, 20));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-contact-28 (1).png"))); // NOI18N
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 30, 40));

        txtBookID.setBackground(new java.awt.Color(11, 0, 40));
        txtBookID.setForeground(new java.awt.Color(255, 255, 255));
        txtBookID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtBookID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBookIDActionPerformed(evt);
            }
        });
        jPanel4.add(txtBookID, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 270, 40));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-moleskine-28 (1).png"))); // NOI18N
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, 40));

        txtBookName.setBackground(new java.awt.Color(11, 0, 40));
        txtBookName.setForeground(new java.awt.Color(255, 255, 255));
        txtBookName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jPanel4.add(txtBookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 270, 40));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Book Name :");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 80, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-collaborator-28 (1).png"))); // NOI18N
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, -1, 40));

        txtBookAuthor.setBackground(new java.awt.Color(11, 0, 40));
        txtBookAuthor.setForeground(new java.awt.Color(255, 255, 255));
        txtBookAuthor.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jPanel4.add(txtBookAuthor, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 270, 40));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Book Author :");
        jPanel4.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 90, -1));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Genre :");
        jPanel4.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 50, -1));

        genrecombobox.setPreferredSize(new java.awt.Dimension(129, 35));
        jPanel4.add(genrecombobox, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, 200, 30));

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-book-28.png"))); // NOI18N
        jPanel4.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, -1, 40));

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-unit-28 (1).png"))); // NOI18N
        jPanel4.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, -1, 40));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Quantity :");
        jPanel4.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 450, 70, -1));

        txtQuantity.setBackground(new java.awt.Color(11, 0, 40));
        txtQuantity.setForeground(new java.awt.Color(255, 255, 255));
        txtQuantity.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuantityActionPerformed(evt);
            }
        });
        jPanel4.add(txtQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 470, 270, 40));

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
        jPanel4.add(book_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 530, -1, -1));

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
        jPanel4.add(book_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 530, -1, -1));

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
        jPanel4.add(book_delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 530, 50, 50));

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
        jPanel4.add(book_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 530, -1, -1));

        btextadd.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btextadd.setForeground(new java.awt.Color(255, 255, 255));
        btextadd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btextadd.setText("ADD");
        jPanel4.add(btextadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 590, 50, -1));
        btextadd.setVisible(false);

        btxtedit.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btxtedit.setForeground(new java.awt.Color(255, 255, 255));
        btxtedit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btxtedit.setText("EDIT");
        jPanel4.add(btxtedit, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 590, 50, -1));
        btxtedit.setVisible(false);

        btxtremove.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btxtremove.setForeground(new java.awt.Color(255, 255, 255));
        btxtremove.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btxtremove.setText("DELETE");
        jPanel4.add(btxtremove, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 590, 50, -1));
        btxtremove.setVisible(false);

        btxtupdate.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btxtupdate.setForeground(new java.awt.Color(255, 255, 255));
        btxtupdate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btxtupdate.setText("UPDATE");
        jPanel4.add(btxtupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 590, -1, -1));
        btxtupdate.setVisible(false);

        jButton2.setBackground(new java.awt.Color(0, 0, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-plus-20.png"))); // NOI18N
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton2MouseExited(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 410, 30, 30));

        jButton18.setBackground(new java.awt.Color(255, 0, 0));
        jButton18.setForeground(new java.awt.Color(255, 255, 255));
        jButton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-delete-20.png"))); // NOI18N
        jButton18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton18MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton18MouseExited(evt);
            }
        });
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton18, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 410, 30, 30));

        jButton3.setText("jButton3");
        jPanel4.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 470, -1, -1));

        optadd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        optadd.setForeground(new java.awt.Color(0, 0, 255));
        optadd.setText("ADD");
        jPanel4.add(optadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 390, -1, -1));
        optadd.setVisible(false);

        optdel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        optdel.setForeground(new java.awt.Color(255, 0, 0));
        optdel.setText("DELETE");
        jPanel4.add(optdel, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 390, -1, -1));
        optdel.setVisible(false);

        managebook.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 340, 620));

        jPanel38.setBackground(new java.awt.Color(16, 0, 61));
        jPanel38.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 50)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("MANAGE BOOKS");
        jLabel25.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel38.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 460, 60));
        jPanel38.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 0, -1, 60));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-knowledge-60.png"))); // NOI18N
        jPanel38.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 0, -1, 60));

        jPanel29.setBackground(new java.awt.Color(16, 0, 61));
        jPanel29.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ex2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-x-30.png"))); // NOI18N
        ex2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ex2MouseClicked(evt);
            }
        });
        jPanel29.add(ex2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 40));

        jPanel38.add(jPanel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 10, 30, 40));

        jPanel32.setBackground(new java.awt.Color(16, 0, 61));
        jPanel32.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        hide2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-minus-30.png"))); // NOI18N
        hide2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hide2MouseClicked(evt);
            }
        });
        jPanel32.add(hide2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 40));

        jPanel38.add(jPanel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 10, 30, 40));

        managebook.add(jPanel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1120, 60));

        jPanel10.setBackground(new java.awt.Color(11, 0, 40));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/1w.png"))); // NOI18N
        jPanel10.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

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
        jPanel10.add(manageb_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 260, 30));

        manageb_filter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "ABM", "HUMSS", "ICT", "General Reference", "Fiction", "Core Subject" }));
        manageb_filter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageb_filterActionPerformed(evt);
            }
        });
        jPanel10.add(manageb_filter, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, -1, 30));

        manageb_table.setAutoCreateRowSorter(true);
        manageb_table.setBackground(new java.awt.Color(255, 255, 255));
        manageb_table.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        manageb_table.setForeground(new java.awt.Color(0, 0, 0));
        manageb_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", " Book ID", "Book Name", "Book Author", "Genre", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false
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
            manageb_table.getColumnModel().getColumn(0).setMinWidth(0);
            manageb_table.getColumnModel().getColumn(0).setPreferredWidth(0);
            manageb_table.getColumnModel().getColumn(0).setMaxWidth(0);
            manageb_table.getColumnModel().getColumn(1).setPreferredWidth(80);
            manageb_table.getColumnModel().getColumn(5).setPreferredWidth(80);
        }

        jPanel10.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 730, 580));

        managebook.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 770, 810));

        jTabbedPane1.addTab("MANAGEBOOK", managebook);

        managestudent.setBackground(new java.awt.Color(11, 0, 40));
        managestudent.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel11.setBackground(new java.awt.Color(11, 0, 40));
        jPanel11.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(255, 255, 255)));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-student-90.png"))); // NOI18N
        jPanel11.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, -1, -1));

        jLabel28.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Add a Student");
        jPanel11.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, -1, -1));

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Student ID :");
        jPanel11.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 70, 20));

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-security-pass-32.png"))); // NOI18N
        jPanel11.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 30, 40));

        txtStudentID.setBackground(new java.awt.Color(11, 0, 40));
        txtStudentID.setForeground(new java.awt.Color(255, 255, 255));
        txtStudentID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtStudentID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStudentIDActionPerformed(evt);
            }
        });
        jPanel11.add(txtStudentID, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 270, 40));

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-person-28.png"))); // NOI18N
        jPanel11.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, 40));

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Student Name :");
        jPanel11.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 90, -1));

        txtStudentName.setBackground(new java.awt.Color(11, 0, 40));
        txtStudentName.setForeground(new java.awt.Color(255, 255, 255));
        txtStudentName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jPanel11.add(txtStudentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 270, 40));

        txtStrand.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "...", "ABM", "ICT", "HUMSS" }));
        jPanel11.add(txtStrand, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 200, 30));

        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-security-pass-28.png"))); // NOI18N
        jPanel11.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, -1, 40));

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Strand ;");
        jPanel11.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 50, -1));

        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-user-groups-28.png"))); // NOI18N
        jPanel11.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 30, 40));

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Gr. & Sec. :");
        jPanel11.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 70, -1));

        txtGrandSec.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "..." }));
        jPanel11.add(txtGrandSec, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, 200, 30));

        stud_add.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        stud_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-add-48.png"))); // NOI18N
        stud_add.setToolTipText("");
        stud_add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stud_addMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                stud_addMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                stud_addMouseExited(evt);
            }
        });
        jPanel11.add(stud_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, -1, 50));

        stud_edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-pen-squared-48.png"))); // NOI18N
        stud_edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stud_editMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                stud_editMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                stud_editMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                stud_editMousePressed(evt);
            }
        });
        jPanel11.add(stud_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 440, -1, 50));

        stud_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-x-48.png"))); // NOI18N
        stud_delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stud_deleteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                stud_deleteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                stud_deleteMouseExited(evt);
            }
        });
        jPanel11.add(stud_delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 440, -1, 50));

        stud_update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/PG-removebg-preview.png"))); // NOI18N
        stud_update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stud_updateMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                stud_updateMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                stud_updateMouseExited(evt);
            }
        });
        jPanel11.add(stud_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 440, 50, 50));

        textadd1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        textadd1.setForeground(new java.awt.Color(255, 255, 255));
        textadd1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textadd1.setText("ADD");
        jPanel11.add(textadd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 500, 50, -1));
        textadd1.setVisible(false);

        txtedit1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        txtedit1.setForeground(new java.awt.Color(255, 255, 255));
        txtedit1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtedit1.setText("EDIT");
        jPanel11.add(txtedit1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 500, 50, -1));
        txtedit1.setVisible(false);

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
        jPanel11.add(txtupdate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 500, 50, -1));
        txtupdate1.setVisible(false);

        txtremove1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        txtremove1.setForeground(new java.awt.Color(255, 255, 255));
        txtremove1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtremove1.setText("DELETE");
        jPanel11.add(txtremove1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 500, 50, -1));
        txtremove1.setVisible(false);

        jButton15.setBackground(new java.awt.Color(0, 0, 255));
        jButton15.setForeground(new java.awt.Color(255, 255, 255));
        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-plus-20.png"))); // NOI18N
        jButton15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton15MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton15MouseExited(evt);
            }
        });
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        jPanel11.add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 390, 30, 30));

        jButton19.setBackground(new java.awt.Color(255, 0, 0));
        jButton19.setForeground(new java.awt.Color(255, 255, 255));
        jButton19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-delete-20.png"))); // NOI18N
        jButton19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton19MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton19MouseExited(evt);
            }
        });
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });
        jPanel11.add(jButton19, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 390, 30, 30));

        addopt.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        addopt.setForeground(new java.awt.Color(0, 0, 255));
        addopt.setText("ADD");
        jPanel11.add(addopt, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 370, 30, -1));
        addopt.setVisible(false);

        delopt.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        delopt.setForeground(new java.awt.Color(255, 0, 0));
        delopt.setText("DELETE");
        jPanel11.add(delopt, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 370, -1, -1));
        delopt.setVisible(false);

        jButton28.setBackground(new java.awt.Color(0, 0, 255));
        jButton28.setForeground(new java.awt.Color(255, 255, 255));
        jButton28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-plus-20.png"))); // NOI18N
        jButton28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton28MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton28MouseExited(evt);
            }
        });
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });
        jPanel11.add(jButton28, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 320, 30, 30));

        jButton29.setBackground(new java.awt.Color(255, 0, 0));
        jButton29.setForeground(new java.awt.Color(255, 255, 255));
        jButton29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-delete-20.png"))); // NOI18N
        jButton29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton29MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton29MouseExited(evt);
            }
        });
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });
        jPanel11.add(jButton29, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 320, 30, 30));

        addopt1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        addopt1.setForeground(new java.awt.Color(0, 0, 255));
        addopt1.setText("ADD");
        jPanel11.add(addopt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 300, 30, -1));
        addopt1.setVisible(false);

        delopt1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        delopt1.setForeground(new java.awt.Color(255, 0, 0));
        delopt1.setText("DELETE");
        jPanel11.add(delopt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 300, -1, -1));
        delopt1.setVisible(false);

        managestudent.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 340, 620));

        jPanel39.setBackground(new java.awt.Color(16, 0, 61));
        jPanel39.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 50)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("MANAGE STUDENT");
        jPanel39.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 520, 60));

        jLabel77.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-notepad-user-60.png"))); // NOI18N
        jPanel39.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 0, 60, 60));

        jPanel34.setBackground(new java.awt.Color(16, 0, 61));
        jPanel34.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ex3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-x-30.png"))); // NOI18N
        ex3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ex3MouseClicked(evt);
            }
        });
        jPanel34.add(ex3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 40));

        jPanel39.add(jPanel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 10, 30, 40));

        jPanel36.setBackground(new java.awt.Color(16, 0, 61));
        jPanel36.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        hide3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-minus-30.png"))); // NOI18N
        hide3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hide3MouseClicked(evt);
            }
        });
        jPanel36.add(hide3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 40));

        jPanel39.add(jPanel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 10, 30, 40));

        managestudent.add(jPanel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1120, 60));

        jPanel12.setBackground(new java.awt.Color(11, 0, 40));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/1w.png"))); // NOI18N
        jPanel12.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        searchmanagstud.setBackground(new java.awt.Color(11, 0, 40));
        searchmanagstud.setForeground(new java.awt.Color(255, 255, 255));
        searchmanagstud.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 255, 255)));
        searchmanagstud.setCaretColor(new java.awt.Color(255, 255, 255));
        searchmanagstud.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        searchmanagstud.setDragEnabled(true);
        searchmanagstud.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        searchmanagstud.setSelectionColor(new java.awt.Color(60, 63, 65));
        searchmanagstud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchmanagstudActionPerformed(evt);
            }
        });
        searchmanagstud.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchmanagstudKeyReleased(evt);
            }
        });
        jPanel12.add(searchmanagstud, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 260, 30));

        studfilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "ABM", "HUMSS", "ICT" }));
        studfilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studfilterActionPerformed(evt);
            }
        });
        jPanel12.add(studfilter, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, 130, 30));

        studtable.setAutoCreateRowSorter(true);
        studtable.setBackground(new java.awt.Color(255, 255, 255));
        studtable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        studtable.setForeground(new java.awt.Color(0, 0, 0));
        studtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Student ID", "Student Name", "Strand", "Gr. & Sec."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false
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
            studtable.getColumnModel().getColumn(0).setMinWidth(0);
            studtable.getColumnModel().getColumn(0).setPreferredWidth(0);
            studtable.getColumnModel().getColumn(0).setMaxWidth(0);
            studtable.getColumnModel().getColumn(1).setResizable(false);
            studtable.getColumnModel().getColumn(1).setPreferredWidth(80);
            studtable.getColumnModel().getColumn(2).setResizable(false);
            studtable.getColumnModel().getColumn(2).setPreferredWidth(150);
            studtable.getColumnModel().getColumn(3).setResizable(false);
            studtable.getColumnModel().getColumn(3).setPreferredWidth(80);
            studtable.getColumnModel().getColumn(4).setResizable(false);
        }

        jPanel12.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 730, 570));

        managestudent.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 770, 810));

        jTabbedPane1.addTab("MANAGESTUDENT", managestudent);

        transaction.setBackground(new java.awt.Color(11, 0, 40));
        transaction.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/1w.png"))); // NOI18N
        transaction.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        transactionssearch.setBackground(new java.awt.Color(11, 0, 40));
        transactionssearch.setForeground(new java.awt.Color(255, 255, 255));
        transactionssearch.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 255, 255)));
        transactionssearch.setSelectionColor(new java.awt.Color(255, 255, 255));
        transactionssearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transactionssearchActionPerformed(evt);
            }
        });
        transactionssearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                transactionssearchKeyReleased(evt);
            }
        });
        transaction.add(transactionssearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 270, 30));

        transacfilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "...", "Pending", "Overdue" }));
        transacfilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transacfilterActionPerformed(evt);
            }
        });
        transaction.add(transacfilter, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, 130, 30));

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
                false, false, false, false, false, false, false, false, false, false, false, true, false
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
            transactiontable.getColumnModel().getColumn(8).setMinWidth(0);
            transactiontable.getColumnModel().getColumn(8).setPreferredWidth(0);
            transactiontable.getColumnModel().getColumn(8).setMaxWidth(0);
            transactiontable.getColumnModel().getColumn(9).setResizable(false);
            transactiontable.getColumnModel().getColumn(9).setPreferredWidth(90);
            transactiontable.getColumnModel().getColumn(10).setResizable(false);
            transactiontable.getColumnModel().getColumn(10).setPreferredWidth(90);
            transactiontable.getColumnModel().getColumn(11).setMinWidth(0);
            transactiontable.getColumnModel().getColumn(11).setPreferredWidth(0);
            transactiontable.getColumnModel().getColumn(11).setMaxWidth(0);
            transactiontable.getColumnModel().getColumn(12).setResizable(false);
            transactiontable.getColumnModel().getColumn(12).setPreferredWidth(50);
        }

        transaction.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 1060, 570));

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

        jPanel24.setBackground(new java.awt.Color(16, 0, 61));
        jPanel24.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        a8.setFont(new java.awt.Font("Segoe UI", 1, 50)); // NOI18N
        a8.setForeground(new java.awt.Color(255, 255, 255));
        a8.setText("TRANSACTION");
        jPanel24.add(a8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 430, 60));

        jLabel84.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-check-book-60.png"))); // NOI18N
        jPanel24.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 0, 60, 60));

        jPanel37.setBackground(new java.awt.Color(16, 0, 61));
        jPanel37.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ex4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-x-30.png"))); // NOI18N
        ex4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ex4MouseClicked(evt);
            }
        });
        jPanel37.add(ex4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 40));

        jPanel24.add(jPanel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 10, 30, 40));

        jPanel40.setBackground(new java.awt.Color(16, 0, 61));
        jPanel40.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        hide4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-minus-30.png"))); // NOI18N
        hide4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hide4MouseClicked(evt);
            }
        });
        jPanel40.add(hide4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 40));

        jPanel51.setBackground(new java.awt.Color(16, 0, 61));
        jPanel51.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ex10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-x-30.png"))); // NOI18N
        ex10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ex10MouseClicked(evt);
            }
        });
        jPanel51.add(ex10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 30));

        jPanel40.add(jPanel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 10, 30, 30));

        jPanel24.add(jPanel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 10, 30, 40));

        transaction.add(jPanel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1120, 60));

        jTabbedPane1.addTab("TRANSACTION", transaction);

        records.setBackground(new java.awt.Color(11, 0, 40));
        records.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton4.setBackground(new java.awt.Color(0, 0, 255));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-download-24.png"))); // NOI18N
        jButton4.setText("DOWNLOAD ");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        records.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 720, -1, 30));

        recordsfilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "ABM", "HUMSS", "ICT" }));
        recordsfilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recordsfilterActionPerformed(evt);
            }
        });
        records.add(recordsfilter, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, 160, 30));

        recordssearch.setBackground(new java.awt.Color(11, 0, 40));
        recordssearch.setForeground(new java.awt.Color(255, 255, 255));
        recordssearch.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 255, 255)));
        recordssearch.setSelectionColor(new java.awt.Color(255, 255, 255));
        recordssearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recordssearchActionPerformed(evt);
            }
        });
        recordssearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                recordssearchKeyReleased(evt);
            }
        });
        records.add(recordssearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 270, 30));

        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/1w.png"))); // NOI18N
        records.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, 30));

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
        recordstable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                recordstableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(recordstable);
        if (recordstable.getColumnModel().getColumnCount() > 0) {
            recordstable.getColumnModel().getColumn(0).setMinWidth(0);
            recordstable.getColumnModel().getColumn(0).setPreferredWidth(0);
            recordstable.getColumnModel().getColumn(0).setMaxWidth(0);
            recordstable.getColumnModel().getColumn(1).setPreferredWidth(150);
            recordstable.getColumnModel().getColumn(2).setMinWidth(0);
            recordstable.getColumnModel().getColumn(2).setPreferredWidth(0);
            recordstable.getColumnModel().getColumn(2).setMaxWidth(0);
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

        records.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 1060, 570));

        jButton1.setBackground(new java.awt.Color(255, 0, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-delete-24.png"))); // NOI18N
        jButton1.setText("DELETE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        records.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 720, -1, 30));

        jPanel26.setBackground(new java.awt.Color(16, 0, 61));
        jPanel26.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        a9.setFont(new java.awt.Font("Segoe UI", 1, 50)); // NOI18N
        a9.setForeground(new java.awt.Color(255, 255, 255));
        a9.setText("RECORDS");
        jPanel26.add(a9, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 300, 60));

        jLabel85.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-records-60.png"))); // NOI18N
        jPanel26.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, 60, 60));

        jPanel41.setBackground(new java.awt.Color(16, 0, 61));
        jPanel41.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ex5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-x-30.png"))); // NOI18N
        ex5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ex5MouseClicked(evt);
            }
        });
        jPanel41.add(ex5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 40));

        jPanel26.add(jPanel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 10, 30, 40));

        jPanel42.setBackground(new java.awt.Color(16, 0, 61));
        jPanel42.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        hide5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-minus-30.png"))); // NOI18N
        hide5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hide5MouseClicked(evt);
            }
        });
        jPanel42.add(hide5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 40));

        jPanel26.add(jPanel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 10, 30, 40));

        records.add(jPanel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1120, 60));

        jTabbedPane1.addTab("RECORDS", records);

        issuebook.setBackground(new java.awt.Color(11, 0, 40));
        issuebook.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel20.setBackground(new java.awt.Color(16, 1, 59));
        jPanel20.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(255, 255, 255)));
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel52.setBackground(new java.awt.Color(0, 0, 102));
        jLabel52.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-knowledge-sharing-100 (1).png"))); // NOI18N
        jPanel20.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 100, 100));

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));
        jPanel21.setForeground(new java.awt.Color(255, 255, 255));
        jPanel21.setPreferredSize(new java.awt.Dimension(0, 5));

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel20.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 400, 3));

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

        issue_issuedate.setBackground(new java.awt.Color(16, 1, 59));
        issue_issuedate.setForeground(new java.awt.Color(255, 0, 0));
        issue_issuedate.setDateFormatString("dd-MM-yy");
        jPanel20.add(issue_issuedate, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 220, 32));

        issue_duedate.setBackground(new java.awt.Color(16, 1, 59));
        issue_duedate.setForeground(new java.awt.Color(255, 0, 0));
        issue_duedate.setDateFormatString("dd-MM-yy");
        jPanel20.add(issue_duedate, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 320, 220, 32));

        jLabel54.setBackground(new java.awt.Color(0, 0, 102));
        jLabel54.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setText("Due Date :");
        jPanel20.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, -1, -1));

        jLabel83.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel83.setForeground(new java.awt.Color(255, 255, 255));
        jLabel83.setText("Issue");
        jPanel20.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, -1, -1));

        issuebook.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 170, 440, 480));

        jPanel18.setBackground(new java.awt.Color(16, 1, 59));
        jPanel18.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(255, 255, 255)));
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel46.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-details-85.png"))); // NOI18N
        jLabel46.setText("Book Details");
        jPanel18.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, -1, -1));

        Search2.setBackground(new java.awt.Color(0, 0, 153));
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
            .addGap(0, 259, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel18.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 259, 3));

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

        issuebook.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 110, 310, 600));

        jPanel5.setBackground(new java.awt.Color(16, 1, 59));
        jPanel5.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(255, 255, 255)));
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
            .addGap(0, 259, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 130, 259, 3));

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

        Search.setBackground(new java.awt.Color(0, 0, 153));
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
        jPanel5.add(Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 220, -1, -1));

        issuebook.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 310, 600));
        jPanel5.getAccessibleContext().setAccessibleName("");

        jPanel33.setBackground(new java.awt.Color(16, 0, 61));
        jPanel33.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-left-3-20.png"))); // NOI18N
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
        });
        jPanel33.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 60));

        a13.setFont(new java.awt.Font("Segoe UI", 1, 50)); // NOI18N
        a13.setForeground(new java.awt.Color(255, 255, 255));
        a13.setText("ISSUE BOOK");
        jPanel33.add(a13, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 400, 60));

        jLabel86.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-course-assign-60.png"))); // NOI18N
        jPanel33.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 0, -1, -1));

        jPanel43.setBackground(new java.awt.Color(16, 0, 61));
        jPanel43.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ex6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-x-30.png"))); // NOI18N
        ex6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ex6MouseClicked(evt);
            }
        });
        jPanel43.add(ex6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 40));

        jPanel33.add(jPanel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 10, 30, 40));

        jPanel44.setBackground(new java.awt.Color(16, 0, 61));
        jPanel44.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        hide6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-minus-30.png"))); // NOI18N
        hide6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hide6MouseClicked(evt);
            }
        });
        jPanel44.add(hide6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 40));

        jPanel33.add(jPanel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 10, 30, 40));

        issuebook.add(jPanel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1110, 60));

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

        student.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 1060, 560));

        jLabel70.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/1w.png"))); // NOI18N
        student.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        studlistsearch.setBackground(new java.awt.Color(11, 0, 40));
        studlistsearch.setForeground(new java.awt.Color(255, 255, 255));
        studlistsearch.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 255, 255)));
        studlistsearch.setCaretColor(new java.awt.Color(255, 255, 255));
        studlistsearch.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        studlistsearch.setDragEnabled(true);
        studlistsearch.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        studlistsearch.setSelectionColor(new java.awt.Color(60, 63, 65));
        studlistsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studlistsearchActionPerformed(evt);
            }
        });
        studlistsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                studlistsearchKeyReleased(evt);
            }
        });
        student.add(studlistsearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 250, 30));

        studlist.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "ABM", "HUMSS", "ICT", "General Reference", "Fiction", "Core Subject" }));
        studlist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studlistActionPerformed(evt);
            }
        });
        student.add(studlist, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, 150, 30));

        issuefindstud.setBackground(new java.awt.Color(0, 0, 153));
        issuefindstud.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        issuefindstud.setForeground(new java.awt.Color(255, 255, 255));
        issuefindstud.setText("SELECT");
        issuefindstud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                issuefindstudActionPerformed(evt);
            }
        });
        student.add(issuefindstud, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 710, 140, 40));

        jPanel27.setBackground(new java.awt.Color(16, 0, 61));
        jPanel27.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel80.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-left-3-20.png"))); // NOI18N
        jLabel80.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel80MouseClicked(evt);
            }
        });
        jPanel27.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 60));

        a10.setFont(new java.awt.Font("Segoe UI", 1, 50)); // NOI18N
        a10.setForeground(new java.awt.Color(255, 255, 255));
        a10.setText("STUDENT LIST");
        jPanel27.add(a10, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 420, 60));

        jLabel89.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-drag-list-down-60.png"))); // NOI18N
        jPanel27.add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, -1, -1));

        jPanel45.setBackground(new java.awt.Color(16, 0, 61));
        jPanel45.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ex7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-x-30.png"))); // NOI18N
        ex7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ex7MouseClicked(evt);
            }
        });
        jPanel45.add(ex7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 40));

        jPanel27.add(jPanel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 10, 30, 40));

        jPanel46.setBackground(new java.awt.Color(16, 0, 61));
        jPanel46.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        hide7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-minus-30.png"))); // NOI18N
        hide7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hide7MouseClicked(evt);
            }
        });
        jPanel46.add(hide7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 40));

        jPanel27.add(jPanel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 10, 30, 40));

        student.add(jPanel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1120, 60));

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

        book.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 1060, 560));

        jLabel71.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/1w.png"))); // NOI18N
        book.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        booklistsearch.setBackground(new java.awt.Color(11, 0, 40));
        booklistsearch.setForeground(new java.awt.Color(255, 255, 255));
        booklistsearch.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 255, 255)));
        booklistsearch.setCaretColor(new java.awt.Color(255, 255, 255));
        booklistsearch.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        booklistsearch.setDragEnabled(true);
        booklistsearch.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        booklistsearch.setSelectionColor(new java.awt.Color(60, 63, 65));
        booklistsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                booklistsearchActionPerformed(evt);
            }
        });
        booklistsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                booklistsearchKeyReleased(evt);
            }
        });
        book.add(booklistsearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 250, 30));

        booklistfilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "ABM", "HUMSS", "ICT", "General Reference", "Fiction", "Core Subject" }));
        booklistfilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                booklistfilterActionPerformed(evt);
            }
        });
        book.add(booklistfilter, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, 150, 30));

        issuefindbooklist.setBackground(new java.awt.Color(0, 0, 153));
        issuefindbooklist.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        issuefindbooklist.setForeground(new java.awt.Color(255, 255, 255));
        issuefindbooklist.setText("SELECT");
        issuefindbooklist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                issuefindbooklistActionPerformed(evt);
            }
        });
        book.add(issuefindbooklist, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 710, 140, 40));

        jPanel30.setBackground(new java.awt.Color(16, 0, 61));
        jPanel30.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel81.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-left-3-20.png"))); // NOI18N
        jLabel81.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel81MouseClicked(evt);
            }
        });
        jPanel30.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 60));

        a11.setFont(new java.awt.Font("Segoe UI", 1, 50)); // NOI18N
        a11.setForeground(new java.awt.Color(255, 255, 255));
        a11.setText("BOOK LIST");
        jPanel30.add(a11, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 350, 60));

        jLabel88.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-drag-list-down-60.png"))); // NOI18N
        jPanel30.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 60, -1));

        jPanel3.setBackground(new java.awt.Color(16, 0, 61));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        hide.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-minus-30.png"))); // NOI18N
        hide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hideMouseClicked(evt);
            }
        });
        jPanel3.add(hide, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 40));

        jPanel30.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 10, 30, 40));

        jPanel22.setBackground(new java.awt.Color(16, 0, 61));
        jPanel22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ex.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-x-30.png"))); // NOI18N
        ex.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exMouseClicked(evt);
            }
        });
        jPanel22.add(ex, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 40));

        jPanel30.add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 10, 30, 40));

        book.add(jPanel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1120, 60));

        jTabbedPane1.addTab("BOOK", book);

        returnbook.setBackground(new java.awt.Color(11, 0, 40));
        returnbook.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(16, 1, 59));
        jPanel6.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(255, 255, 255)));
        jPanel6.setLayout(null);

        jLabel56.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-return-book-100.png"))); // NOI18N
        jPanel6.add(jLabel56);
        jLabel56.setBounds(110, 70, 101, 101);

        jLabel57.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(255, 255, 255));
        jLabel57.setText("Student ID :");
        jPanel6.add(jLabel57);
        jLabel57.setBounds(10, 190, 67, 16);

        finddetailsreturn.setBackground(new java.awt.Color(0, 0, 153));
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
        finddetailsreturn.setBounds(230, 180, 60, 22);

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

        jLabel73.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(255, 255, 255));
        jLabel73.setText("Details");
        jPanel6.add(jLabel73);
        jLabel73.setBounds(100, 20, 126, 44);

        returnbook.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 310, 600));

        jPanel8.setBackground(new java.awt.Color(16, 1, 59));
        jPanel8.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(255, 255, 255)));
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

        returnbook.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 110, 310, 600));

        jPanel9.setBackground(new java.awt.Color(16, 1, 59));
        jPanel9.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(255, 255, 255)));
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
        return_button.setBounds(110, 390, 220, 35);
        return_button.setEnabled(false);

        return_datereturned.setBackground(new java.awt.Color(16, 1, 59));
        return_datereturned.setDateFormatString("dd-MM-yy");
        jPanel9.add(return_datereturned);
        return_datereturned.setBounds(110, 300, 220, 30);

        jLabel74.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(255, 255, 255));
        jLabel74.setText("Return Date :");
        jPanel9.add(jLabel74);
        jLabel74.setBounds(10, 310, 80, 16);

        jLabel75.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-return-100.png"))); // NOI18N
        jPanel9.add(jLabel75);
        jLabel75.setBounds(180, 70, 100, 100);

        returnduedate.setBackground(new java.awt.Color(16, 1, 59));
        returnduedate.setForeground(new java.awt.Color(255, 255, 255));
        returnduedate.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        returnduedate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnduedateActionPerformed(evt);
            }
        });
        jPanel9.add(returnduedate);
        returnduedate.setBounds(110, 250, 220, 35);

        returnissudate.setBackground(new java.awt.Color(16, 1, 59));
        returnissudate.setForeground(new java.awt.Color(255, 255, 255));
        returnissudate.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        returnissudate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnissudateActionPerformed(evt);
            }
        });
        jPanel9.add(returnissudate);
        returnissudate.setBounds(110, 200, 220, 35);

        jLabel61.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(255, 255, 255));
        jLabel61.setText("Issue Date :");
        jPanel9.add(jLabel61);
        jLabel61.setBounds(10, 210, 70, 16);

        jLabel68.setBackground(new java.awt.Color(153, 153, 255));
        jLabel68.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(255, 255, 255));
        jLabel68.setText("Due Date :");
        jPanel9.add(jLabel68);
        jLabel68.setBounds(10, 260, 80, 16);

        jLabel55.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setText("Return");
        jPanel9.add(jLabel55);
        jLabel55.setBounds(160, 20, 130, 40);

        returnbook.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 170, 440, 480));

        jPanel35.setBackground(new java.awt.Color(16, 0, 61));
        jPanel35.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel76.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-left-3-20.png"))); // NOI18N
        jLabel76.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel76MouseClicked(evt);
            }
        });
        jPanel35.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 20, 60));

        a15.setFont(new java.awt.Font("Segoe UI", 1, 50)); // NOI18N
        a15.setForeground(new java.awt.Color(255, 255, 255));
        a15.setText("RETURN BOOK");
        jPanel35.add(a15, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 440, 60));

        jLabel87.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-study-60.png"))); // NOI18N
        jPanel35.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, -1, 60));

        jPanel47.setBackground(new java.awt.Color(16, 0, 61));
        jPanel47.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ex8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-x-30.png"))); // NOI18N
        ex8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ex8MouseClicked(evt);
            }
        });
        jPanel47.add(ex8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 40));

        jPanel35.add(jPanel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 10, 30, 40));

        jPanel48.setBackground(new java.awt.Color(16, 0, 61));
        jPanel48.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        hide8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-minus-30.png"))); // NOI18N
        hide8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hide8MouseClicked(evt);
            }
        });
        jPanel48.add(hide8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 40));

        jPanel35.add(jPanel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 10, 30, 40));

        returnbook.add(jPanel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1120, 60));

        jTabbedPane1.addTab("RETURNBOOK", returnbook);

        details.setBackground(new java.awt.Color(11, 0, 40));
        details.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel72.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/1w.png"))); // NOI18N
        details.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

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
        if (findreturndetails.getColumnModel().getColumnCount() > 0) {
            findreturndetails.getColumnModel().getColumn(2).setMinWidth(0);
            findreturndetails.getColumnModel().getColumn(2).setPreferredWidth(0);
            findreturndetails.getColumnModel().getColumn(2).setMaxWidth(0);
            findreturndetails.getColumnModel().getColumn(4).setMinWidth(0);
            findreturndetails.getColumnModel().getColumn(4).setPreferredWidth(0);
            findreturndetails.getColumnModel().getColumn(4).setMaxWidth(0);
            findreturndetails.getColumnModel().getColumn(6).setMinWidth(0);
            findreturndetails.getColumnModel().getColumn(6).setPreferredWidth(0);
            findreturndetails.getColumnModel().getColumn(6).setMaxWidth(0);
            findreturndetails.getColumnModel().getColumn(7).setMinWidth(0);
            findreturndetails.getColumnModel().getColumn(7).setPreferredWidth(0);
            findreturndetails.getColumnModel().getColumn(7).setMaxWidth(0);
            findreturndetails.getColumnModel().getColumn(8).setMinWidth(0);
            findreturndetails.getColumnModel().getColumn(8).setPreferredWidth(0);
            findreturndetails.getColumnModel().getColumn(8).setMaxWidth(0);
            findreturndetails.getColumnModel().getColumn(11).setMinWidth(0);
            findreturndetails.getColumnModel().getColumn(11).setPreferredWidth(0);
            findreturndetails.getColumnModel().getColumn(11).setMaxWidth(0);
        }

        details.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 1060, 550));

        retdetailsfilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "ABM", "HUMSS", "ICT", "General Reference", "Fiction", "Core Subject" }));
        retdetailsfilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retdetailsfilterActionPerformed(evt);
            }
        });
        details.add(retdetailsfilter, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 100, 150, 30));

        ret_find_but.setBackground(new java.awt.Color(0, 0, 153));
        ret_find_but.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        ret_find_but.setForeground(new java.awt.Color(255, 255, 255));
        ret_find_but.setText("SELECT");
        ret_find_but.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ret_find_butActionPerformed(evt);
            }
        });
        details.add(ret_find_but, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 710, 130, 40));

        jPanel31.setBackground(new java.awt.Color(16, 0, 61));
        jPanel31.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel82.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-left-3-20.png"))); // NOI18N
        jLabel82.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel82MouseClicked(evt);
            }
        });
        jPanel31.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 20, 60));

        a16.setFont(new java.awt.Font("Segoe UI", 1, 50)); // NOI18N
        a16.setForeground(new java.awt.Color(255, 255, 255));
        a16.setText("DETAILS");
        jPanel31.add(a16, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 250, 60));

        jLabel90.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-view-details-60.png"))); // NOI18N
        jPanel31.add(jLabel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, -1, -1));

        jPanel49.setBackground(new java.awt.Color(16, 0, 61));
        jPanel49.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ex9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-x-30.png"))); // NOI18N
        ex9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ex9MouseClicked(evt);
            }
        });
        jPanel49.add(ex9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 40));

        jPanel31.add(jPanel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 10, 30, 40));

        jPanel50.setBackground(new java.awt.Color(16, 0, 61));
        jPanel50.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        hide9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-minus-30.png"))); // NOI18N
        hide9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hide9MouseClicked(evt);
            }
        });
        jPanel50.add(hide9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 40));

        jPanel31.add(jPanel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 10, 30, 40));

        details.add(jPanel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1120, 60));

        detailsssearch.setBackground(new java.awt.Color(11, 0, 40));
        detailsssearch.setForeground(new java.awt.Color(255, 255, 255));
        detailsssearch.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 255, 255)));
        detailsssearch.setCaretColor(new java.awt.Color(255, 255, 255));
        detailsssearch.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        detailsssearch.setDragEnabled(true);
        detailsssearch.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        detailsssearch.setSelectionColor(new java.awt.Color(60, 63, 65));
        detailsssearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailsssearchActionPerformed(evt);
            }
        });
        detailsssearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                detailsssearchKeyReleased(evt);
            }
        });
        details.add(detailsssearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 250, 30));

        jTabbedPane1.addTab("DETAILS", details);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, -40, 1100, 840));

        jPanel2.setBackground(new java.awt.Color(16, 0, 61));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t1.setBackground(new java.awt.Color(16, 0, 61));
        t1.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 0, 0, 0, new java.awt.Color(255, 255, 255)));

        dash.setBackground(new java.awt.Color(153, 153, 153));
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
            .addComponent(dash, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
        );
        t1Layout.setVerticalGroup(
            t1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dash, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
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
            .addComponent(books, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
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
        students.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-user-groups-60.png"))); // NOI18N
        students.setText("     MANAGE STUDENTS");
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
            .addComponent(students, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
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
            .addComponent(trans, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
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
            .addComponent(rec, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
        );
        t5Layout.setVerticalGroup(
            t5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rec, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
        );

        jPanel2.add(t5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 270, 80));

        a6.setBackground(new java.awt.Color(0, 0, 153));

        A6.setBackground(new java.awt.Color(255, 255, 255));
        A6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        A6.setForeground(new java.awt.Color(255, 255, 255));
        A6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        A6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-log-out-40.png"))); // NOI18N
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
            .addComponent(A6, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
        );
        a6Layout.setVerticalGroup(
            a6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(A6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.add(a6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 700, 250, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/small.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 80));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("SYSTEM");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 70, 20));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("W e l c o m e !");
        jLabel3.setToolTipText("");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 100, 30));

        jLabel79.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(255, 255, 255));
        jLabel79.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel79.setText("LIBRARY MANAGEMENT");
        jPanel2.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, 20));

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

        manageb_table.setFocusable(true);
        book_edit.setEnabled(true);
        book_delete.setEnabled(true);
    }//GEN-LAST:event_manageb_tableMouseClicked

    private void manageb_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_manageb_searchKeyReleased
        String searchString = manageb_search.getText();
        managebooksearch(searchString);
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

            DefaultTableModel model = (DefaultTableModel) manageb_table.getModel();
            int selectedIndex = manageb_table.getSelectedRow();
            int id = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());
            String BookID, BookName, BookAuthor, Quantity, Genre;
            BookID = txtBookID.getText();
            BookName = txtBookName.getText();
            BookAuthor = txtBookAuthor.getText();
            Genre = genrecombobox.getSelectedItem().toString();
            Quantity = txtQuantity.getText();

            if (result == JOptionPane.YES_OPTION) {
                pst = con.prepareStatement("update books set bookid = ?, bookname = ?, bookauthor = ?, genre = ?, quantity = ? where id = ?");
            }
            pst.setString(1, BookID);
            pst.setString(2, BookName);
            pst.setString(3, BookAuthor);
            pst.setString(4, Genre);
            pst.setString(5, Quantity);
            pst.setInt(6, id);
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
            manageb_table.clearSelection();

        } catch (SQLException ex) {
            Logger.getLogger(BOARD.class.getName()).log(Level.SEVERE, null, ex);
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

            DefaultTableModel model = (DefaultTableModel) manageb_table.getModel();
            int selectedIndex = manageb_table.getSelectedRow();
            int id = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());
            if (result == JOptionPane.YES_OPTION) {
                pst = con.prepareStatement("delete from books where id= ?");
            }
            pst.setInt(1, id);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Book Deleted");
            booktable_update();
            issuebooktable_update();
            txtBookID.setText("");
            txtBookName.setText("");
            txtBookAuthor.setText("");
            genrecombobox.setSelectedIndex(0);
            txtQuantity.setText("");
            txtBookName.requestFocus();

        } catch (SQLException ex) {
            Logger.getLogger(BOARD.class.getName()).log(Level.SEVERE, null, ex);
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
        int SelectedRows = manageb_table.convertRowIndexToModel(manageb_table.getSelectedRow());

        txtBookID.setText(model.getValueAt(SelectedRows, 1).toString());
        txtBookName.setText(model.getValueAt(SelectedRows, 2).toString());
        txtBookAuthor.setText(model.getValueAt(SelectedRows, 3).toString());
        genrecombobox.setSelectedItem(model.getValueAt(SelectedRows, 4).toString());
        txtQuantity.setText(model.getValueAt(SelectedRows, 5).toString());


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
            int lastRow = manageb_table.convertRowIndexToView(manageb_table.getRowCount() - 1);
            manageb_table.setRowSelectionInterval(lastRow, lastRow);
            Rectangle cellrect = manageb_table.getCellRect(lastRow, 0, true);
            manageb_table.scrollRectToVisible(cellrect);
        } catch (SQLException ex) {
            Logger.getLogger(BOARD.class.getName()).log(Level.SEVERE, null, ex);

        }
    }//GEN-LAST:event_book_addMouseClicked

    private void txtQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantityActionPerformed

    }//GEN-LAST:event_txtQuantityActionPerformed

    private void txtBookIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBookIDActionPerformed

    }//GEN-LAST:event_txtBookIDActionPerformed

    private void db_filterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_db_filterActionPerformed
        String searchString = db_filter.getSelectedItem().toString();
        dbfilter(searchString);
    }//GEN-LAST:event_db_filterActionPerformed

    private void db_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_db_searchActionPerformed

    }//GEN-LAST:event_db_searchActionPerformed

    private void txtStudentIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStudentIDActionPerformed

    }//GEN-LAST:event_txtStudentIDActionPerformed

    private void stud_addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stud_addMouseClicked

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
            int lastRow = studtable.convertRowIndexToView(studtable.getRowCount() - 1);
            studtable.setRowSelectionInterval(lastRow, lastRow);
            Rectangle cellrect = studtable.getCellRect(lastRow, 0, true);
            studtable.scrollRectToVisible(cellrect);
        } catch (SQLException ex) {
            Logger.getLogger(BOARD.class.getName()).log(Level.SEVERE, null, ex);

        }
    }//GEN-LAST:event_stud_addMouseClicked

    private void stud_addMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stud_addMouseEntered
        textadd1.setVisible(true);
    }//GEN-LAST:event_stud_addMouseEntered

    private void stud_addMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stud_addMouseExited
        textadd1.setVisible(false);
    }//GEN-LAST:event_stud_addMouseExited

    private void stud_editMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stud_editMouseClicked
        DefaultTableModel model = (DefaultTableModel) studtable.getModel();
        int SelectedRows = studtable.convertRowIndexToModel(studtable.getSelectedRow());
        txtStudentID.setText(model.getValueAt(SelectedRows, 1).toString());
        txtStudentName.setText(model.getValueAt(SelectedRows, 2).toString());
        txtStrand.setSelectedItem(model.getValueAt(SelectedRows, 3).toString());
        txtGrandSec.setSelectedItem(model.getValueAt(SelectedRows, 4).toString());


    }//GEN-LAST:event_stud_editMouseClicked

    private void stud_editMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stud_editMouseEntered
        txtedit1.setVisible(true);
    }//GEN-LAST:event_stud_editMouseEntered

    private void stud_editMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stud_editMouseExited
        txtedit1.setVisible(false);
    }//GEN-LAST:event_stud_editMouseExited

    private void stud_editMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stud_editMousePressed

    }//GEN-LAST:event_stud_editMousePressed

    private void stud_deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stud_deleteMouseClicked
        int optionType = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to remove this student", "Delete", optionType);

        try {
            DefaultTableModel model = (DefaultTableModel) studtable.getModel();
            int selectedIndex = studtable.getSelectedRow();
            int id = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());
            if (result == JOptionPane.YES_OPTION) {
                pst = con.prepareStatement("DELETE FROM students WHERE id= ?");
            }
            pst.setInt(1, id);
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
            Logger.getLogger(BOARD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_stud_deleteMouseClicked

    private void stud_deleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stud_deleteMouseEntered
        txtremove1.setVisible(true);
    }//GEN-LAST:event_stud_deleteMouseEntered

    private void stud_deleteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stud_deleteMouseExited
        txtremove1.setVisible(false);
    }//GEN-LAST:event_stud_deleteMouseExited

    private void stud_updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stud_updateMouseClicked
        int optionType = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null, "Are you sure?", "Update Student", optionType);
        try {

            DefaultTableModel model = (DefaultTableModel) studtable.getModel();
            int selectedIndex = studtable.getSelectedRow();
            int id = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());
            String StudentID, StudentName, Strand, GrandSec;
            StudentID = txtStudentID.getText();
            StudentName = txtStudentName.getText();
            Strand = txtStrand.getSelectedItem().toString();
            GrandSec = txtGrandSec.getSelectedItem().toString();

            if (result == JOptionPane.YES_OPTION) {
                pst = con.prepareStatement("update students set studentid = ?, studentname = ?,strand = ?,gradeandsection = ? where id = ?");
            }
            pst.setString(1, StudentID);
            pst.setString(2, StudentName);
            pst.setString(3, Strand);
            pst.setString(4, GrandSec);
            pst.setInt(5, id);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Book Updated");
            stud_table_update();
            studenttable_update();
            txtStudentID.setText("");
            txtStudentName.setText("");
            txtStrand.setSelectedIndex(0);
            txtGrandSec.setSelectedIndex(0);
            txtStudentName.requestFocus();
            studtable.clearSelection();

        } catch (SQLException ex) {
            Logger.getLogger(BOARD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_stud_updateMouseClicked

    private void stud_updateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stud_updateMouseEntered
        txtupdate1.setVisible(true);
    }//GEN-LAST:event_stud_updateMouseEntered

    private void stud_updateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stud_updateMouseExited
        txtupdate1.setVisible(false);
    }//GEN-LAST:event_stud_updateMouseExited

    private void txtupdate1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtupdate1MouseEntered

    }//GEN-LAST:event_txtupdate1MouseEntered

    private void txtupdate1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtupdate1MouseExited

    }//GEN-LAST:event_txtupdate1MouseExited

    private void searchmanagstudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchmanagstudActionPerformed

    }//GEN-LAST:event_searchmanagstudActionPerformed

    private void searchmanagstudKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchmanagstudKeyReleased
        String searchString = searchmanagstud.getText();
        managestudsearch(searchString);
    }//GEN-LAST:event_searchmanagstudKeyReleased

    private void studfilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studfilterActionPerformed

        String searchString = studfilter.getSelectedItem().toString();
        studfiltertab(searchString);

    }//GEN-LAST:event_studfilterActionPerformed

    private void studtablejTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studtablejTable1MouseClicked

        studtable.setFocusable(true);
        stud_edit.setEnabled(true);
        stud_delete.setEnabled(true);

    }//GEN-LAST:event_studtablejTable1MouseClicked

    private void transactionssearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transactionssearchActionPerformed

    }//GEN-LAST:event_transactionssearchActionPerformed

    private void transactionssearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_transactionssearchKeyReleased
        String searchString = transactionssearch.getText();
        transactionsearch(searchString);
    }//GEN-LAST:event_transactionssearchKeyReleased

    private void transacfilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transacfilterActionPerformed

        String searchString = transacfilter.getSelectedItem().toString();
        transactionfiltertab(searchString);


    }//GEN-LAST:event_transacfilterActionPerformed

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

    private void recordssearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recordssearchActionPerformed

    }//GEN-LAST:event_recordssearchActionPerformed

    private void recordssearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_recordssearchKeyReleased
        String searchString = recordssearch.getText();
        recordssearch(searchString);
    }//GEN-LAST:event_recordssearchKeyReleased

    private void issuebk_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_issuebk_buttonActionPerformed

        Date date = Calendar.getInstance().getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, yyy");
        String strDate = dateFormat.format(date);

        String sql = "insert into issue(Student_ID,Student_Name,Strand,Grade_Section,Book_ID,Book_Name,Book_Author,Genre,Book_Quantity,Issue_Date,Due_Date,Date_Return,Status,Date_Today)values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
            pst.setString(13, "Pending");
            pst.setString(14, strDate);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Book Issued");
            overdue();
            overdue_update();
            transactiontableupdate();
            return_details();
            JOptionPane.showMessageDialog(null, "Issue Count Updated");
            issue_count();
            db_table_update();
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
            int lastRow = transactiontable.convertRowIndexToView(transactiontable.getRowCount() - 1);
            transactiontable.setRowSelectionInterval(lastRow, lastRow);
            Rectangle cellrect = transactiontable.getCellRect(lastRow, 0, true);
            transactiontable.scrollRectToVisible(cellrect);
            jTabbedPane1.setSelectedIndex(3);
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
        db_table_update();
        db2_table_update();
        return_count();
        issue_count();
        JOptionPane.showMessageDialog(null, "Return Count Updated");
        int lastRow = recordstable.convertRowIndexToView(recordstable.getRowCount() - 1);
        recordstable.setRowSelectionInterval(lastRow, lastRow);
        Rectangle cellrect = recordstable.getCellRect(lastRow, 0, true);
        recordstable.scrollRectToVisible(cellrect);
        jTabbedPane1.setSelectedIndex(4);
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

    private void studlistsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studlistsearchActionPerformed

    }//GEN-LAST:event_studlistsearchActionPerformed

    private void studlistsearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_studlistsearchKeyReleased
        String searchString = studlistsearch.getText();
        issueslssearch(searchString);
    }//GEN-LAST:event_studlistsearchKeyReleased

    private void issuebooklistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_issuebooklistMouseClicked

    }//GEN-LAST:event_issuebooklistMouseClicked

    private void booklistsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_booklistsearchActionPerformed

    }//GEN-LAST:event_booklistsearchActionPerformed

    private void booklistsearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_booklistsearchKeyReleased
        String searchString = booklistsearch.getText();
        issuebooklstsearch(searchString);
    }//GEN-LAST:event_booklistsearchKeyReleased

    private void findreturndetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_findreturndetailsMouseClicked

    }//GEN-LAST:event_findreturndetailsMouseClicked

    private void finddetailsreturnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_finddetailsreturnMouseClicked

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
        String input = JOptionPane.showInputDialog("Add a genre");
        genrecombobox.setModel(new DefaultComboBoxModel(new String[]{"..."}));
        manageb_filter.setModel(new DefaultComboBoxModel(new String[]{"..."}));
        booklistfilter.setModel(new DefaultComboBoxModel(new String[]{"..."}));
        try {
            Statement st = con.createStatement();
            ResultSet Rs = st.executeQuery("SELECT genre from combobox");
            while (Rs.next()) {
                String genre = Rs.getString("genre");
                genrecombobox.addItem(genre);
                manageb_filter.addItem(genre);
                booklistfilter.addItem(genre);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (input == null) {
            genrecombobox.setModel(new DefaultComboBoxModel(new String[]{"..."}));
            manageb_filter.setModel(new DefaultComboBoxModel(new String[]{"..."}));
            booklistfilter.setModel(new DefaultComboBoxModel(new String[]{"..."}));

            try {
                Statement st = con.createStatement();
                ResultSet Rs = st.executeQuery("SELECT genre from combobox");
                while (Rs.next()) {
                    String genre = Rs.getString("genre");
                    genrecombobox.addItem(genre);
                    manageb_filter.addItem(genre);
                    booklistfilter.addItem(genre);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            JOptionPane.showMessageDialog(null, "Invalid Genre.");

        } else {
            try {

                pst = con.prepareStatement("insert into combobox (genre) values(?)");
                pst.setString(1, input);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Genre Added.");
                genrecombobox.setModel(new DefaultComboBoxModel(new String[]{"..."}));
                manageb_filter.setModel(new DefaultComboBoxModel(new String[]{"..."}));
                booklistfilter.setModel(new DefaultComboBoxModel(new String[]{"..."}));
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                Statement st = con.createStatement();
                ResultSet Rs = st.executeQuery("SELECT genre from combobox");
                while (Rs.next()) {
                    String genre = Rs.getString("genre");
                    genrecombobox.addItem(genre);
                    manageb_filter.addItem(genre);
                    booklistfilter.addItem(genre);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void dashboardAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_dashboardAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_dashboardAncestorAdded

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
        jTabbedPane1.setSelectedIndex(7);

    }//GEN-LAST:event_Search2Search1ActionPerformed

    private void Search2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Search2MouseClicked

    }//GEN-LAST:event_Search2MouseClicked

    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchActionPerformed
        jTabbedPane1.setSelectedIndex(6);


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

        int optionType = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to log out?", "Logout", optionType);
        Login lg = new Login();
        if (result == JOptionPane.YES_OPTION) {
            lg.setVisible(true);
            dispose();
        }


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

    private void SearchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchMouseEntered

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed

        String input = JOptionPane.showInputDialog("Add a section");
        txtGrandSec.setModel(new DefaultComboBoxModel(new String[]{"..."}));
        db_filter2.setModel(new DefaultComboBoxModel(new String[]{"..."}));
        studfilter.setModel(new DefaultComboBoxModel(new String[]{"..."}));
        recordsfilter.setModel(new DefaultComboBoxModel(new String[]{"..."}));
        retdetailsfilter.setModel(new DefaultComboBoxModel(new String[]{"..."}));
        studlist.setModel(new DefaultComboBoxModel(new String[]{"..."}));
        try {
            Statement st = con.createStatement();
            ResultSet Rs = st.executeQuery("SELECT grsec from grandseccombo");
            while (Rs.next()) {
                String grandsec = Rs.getString("grsec");
                txtGrandSec.addItem(grandsec);
                db_filter2.addItem(grandsec);
                studfilter.addItem(grandsec);
                recordsfilter.addItem(grandsec);
                retdetailsfilter.addItem(grandsec);
                studlist.addItem(grandsec);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        if (input == null) {
            txtGrandSec.setModel(new DefaultComboBoxModel(new String[]{"..."}));
            db_filter2.setModel(new DefaultComboBoxModel(new String[]{"..."}));
            studfilter.setModel(new DefaultComboBoxModel(new String[]{"..."}));
            recordsfilter.setModel(new DefaultComboBoxModel(new String[]{"..."}));
            retdetailsfilter.setModel(new DefaultComboBoxModel(new String[]{"..."}));
            studlist.setModel(new DefaultComboBoxModel(new String[]{"..."}));

            try {
                Statement st = con.createStatement();
                ResultSet Rs = st.executeQuery("SELECT grsec from grandseccombo");
                while (Rs.next()) {
                    String grandsec = Rs.getString("grsec");
                    txtGrandSec.addItem(grandsec);
                    db_filter2.addItem(grandsec);
                    studfilter.addItem(grandsec);
                    recordsfilter.addItem(grandsec);
                    retdetailsfilter.addItem(grandsec);
                    studlist.addItem(grandsec);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            JOptionPane.showMessageDialog(null, "Invalid Section");
        } else {
            try {

                pst = con.prepareStatement("insert into grandseccombo (grsec) values(?)");
                pst.setString(1, input);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Section Added.");
                txtGrandSec.setModel(new DefaultComboBoxModel(new String[]{"..."}));
                db_filter2.setModel(new DefaultComboBoxModel(new String[]{"..."}));
                studfilter.setModel(new DefaultComboBoxModel(new String[]{"..."}));
                recordsfilter.setModel(new DefaultComboBoxModel(new String[]{"..."}));
                retdetailsfilter.setModel(new DefaultComboBoxModel(new String[]{"..."}));
                studlist.setModel(new DefaultComboBoxModel(new String[]{"..."}));
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                Statement st = con.createStatement();
                ResultSet Rs = st.executeQuery("SELECT grsec from grandseccombo");
                while (Rs.next()) {
                    String grandsec = Rs.getString("grsec");
                    txtGrandSec.addItem(grandsec);
                    db_filter2.addItem(grandsec);
                    studfilter.addItem(grandsec);
                    recordsfilter.addItem(grandsec);
                    retdetailsfilter.addItem(grandsec);
                    studlist.addItem(grandsec);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed

        genrecombobox.setModel(new DefaultComboBoxModel(new String[]{"..."}));
        manageb_filter.setModel(new DefaultComboBoxModel(new String[]{"..."}));
        booklistfilter.setModel(new DefaultComboBoxModel(new String[]{"..."}));
        String input = JOptionPane.showInputDialog("Enter the genre that you want to delete.");
        if (input == null) {
            JOptionPane.showMessageDialog(null, "Invalid Genre");
            genrecombobox.setModel(new DefaultComboBoxModel(new String[]{"..."}));
            manageb_filter.setModel(new DefaultComboBoxModel(new String[]{"..."}));
            booklistfilter.setModel(new DefaultComboBoxModel(new String[]{"..."}));
        } else {
            int optionType = JOptionPane.YES_NO_OPTION;
            int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete" + input + "?", "Delete", optionType);
            if (result == JOptionPane.YES_OPTION) {
                try {
                    pst = con.prepareStatement("delete from combobox where genre = ?");
                    pst.setString(1, input);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Genre Deleted");
                    genrecombobox.setModel(new DefaultComboBoxModel(new String[]{"..."}));
                    manageb_filter.setModel(new DefaultComboBoxModel(new String[]{"..."}));
                    booklistfilter.setModel(new DefaultComboBoxModel(new String[]{"..."}));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        try {
            Statement st = con.createStatement();
            ResultSet Rs = st.executeQuery("SELECT genre from combobox");
            while (Rs.next()) {
                String genre = Rs.getString("genre");
                genrecombobox.addItem(genre);
                manageb_filter.addItem(genre);
                booklistfilter.addItem(genre);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        txtGrandSec.setModel(new DefaultComboBoxModel(new String[]{"..."}));
        db_filter2.setModel(new DefaultComboBoxModel(new String[]{"..."}));
        studfilter.setModel(new DefaultComboBoxModel(new String[]{"..."}));
        recordsfilter.setModel(new DefaultComboBoxModel(new String[]{"..."}));
        retdetailsfilter.setModel(new DefaultComboBoxModel(new String[]{"..."}));
        studlist.setModel(new DefaultComboBoxModel(new String[]{"..."}));
        String input = JOptionPane.showInputDialog("Enter the section that you want to delete.");
        if (input == null) {
            JOptionPane.showMessageDialog(null, "Invalid Section");
            txtGrandSec.setModel(new DefaultComboBoxModel(new String[]{"..."}));
            db_filter2.setModel(new DefaultComboBoxModel(new String[]{"..."}));
            studfilter.setModel(new DefaultComboBoxModel(new String[]{"..."}));
            recordsfilter.setModel(new DefaultComboBoxModel(new String[]{"..."}));
            retdetailsfilter.setModel(new DefaultComboBoxModel(new String[]{"..."}));
            studlist.setModel(new DefaultComboBoxModel(new String[]{"..."}));
        } else {
            int optionType = JOptionPane.YES_NO_OPTION;
            int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete" + input + "?", "Delete", optionType);
            if (result == JOptionPane.YES_OPTION) {
                try {
                    pst = con.prepareStatement("delete from grandseccombo where grsec = ?");
                    pst.setString(1, input);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Section Deleted");
                    txtGrandSec.setModel(new DefaultComboBoxModel(new String[]{"..."}));
                    db_filter2.setModel(new DefaultComboBoxModel(new String[]{"..."}));
                    studfilter.setModel(new DefaultComboBoxModel(new String[]{"..."}));
                    recordsfilter.setModel(new DefaultComboBoxModel(new String[]{"..."}));
                    retdetailsfilter.setModel(new DefaultComboBoxModel(new String[]{"..."}));
                    studlist.setModel(new DefaultComboBoxModel(new String[]{"..."}));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        try {
            Statement st = con.createStatement();
            ResultSet Rs = st.executeQuery("SELECT grsec from grandseccombo");
            while (Rs.next()) {
                String grandsec = Rs.getString("grsec");
                txtGrandSec.addItem(grandsec);
                db_filter2.addItem(grandsec);
                studfilter.addItem(grandsec);
                recordsfilter.addItem(grandsec);
                retdetailsfilter.addItem(grandsec);
                studlist.addItem(grandsec);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int optionType = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete", "Delete", optionType);
        if (result == JOptionPane.YES_OPTION) {
            deleterecords();
            db2_table_update();
            return_count();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void db_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_db_searchKeyReleased
        String searchString = db_search.getText();
        search(searchString);


    }//GEN-LAST:event_db_searchKeyReleased

    private void recordstableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recordstableMouseClicked

    }//GEN-LAST:event_recordstableMouseClicked

    private void db_search1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_db_search1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_db_search1ActionPerformed

    private void db_search1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_db_search1KeyReleased
        String searchString = db_search1.getText();
        db2search(searchString);
    }//GEN-LAST:event_db_search1KeyReleased

    private void db_filter2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_db_filter2ActionPerformed
        String searchString = db_filter2.getSelectedItem().toString();
        db2filter(searchString);
    }//GEN-LAST:event_db_filter2ActionPerformed

    private void jLabel80MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel80MouseClicked
        jTabbedPane1.setSelectedIndex(5);
    }//GEN-LAST:event_jLabel80MouseClicked

    private void jLabel81MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel81MouseClicked
        jTabbedPane1.setSelectedIndex(5);
    }//GEN-LAST:event_jLabel81MouseClicked

    private void jLabel82MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel82MouseClicked
        jTabbedPane1.setSelectedIndex(8);
    }//GEN-LAST:event_jLabel82MouseClicked

    private void detailsssearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailsssearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_detailsssearchActionPerformed

    private void detailsssearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_detailsssearchKeyReleased
        String searchString = detailsssearch.getText();
        detailssearch(searchString);
    }//GEN-LAST:event_detailsssearchKeyReleased

    private void jButton15MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton15MouseEntered
        addopt.setVisible(true);
    }//GEN-LAST:event_jButton15MouseEntered

    private void jButton15MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton15MouseExited
        addopt.setVisible(false);
    }//GEN-LAST:event_jButton15MouseExited

    private void jButton19MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton19MouseEntered
        delopt.setVisible(true);
    }//GEN-LAST:event_jButton19MouseEntered

    private void jButton19MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton19MouseExited
        delopt.setVisible(false);
    }//GEN-LAST:event_jButton19MouseExited

    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseEntered
        optadd.setVisible(true);
    }//GEN-LAST:event_jButton2MouseEntered

    private void jButton2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseExited
        optadd.setVisible(false);
    }//GEN-LAST:event_jButton2MouseExited

    private void jButton18MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton18MouseEntered
        optdel.setVisible(true);
    }//GEN-LAST:event_jButton18MouseEntered

    private void jButton18MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton18MouseExited
        optdel.setVisible(false);
    }//GEN-LAST:event_jButton18MouseExited

    private void manageb_filterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageb_filterActionPerformed
        String searchString = manageb_filter.getSelectedItem().toString();
        managebfilter(searchString);

    }//GEN-LAST:event_manageb_filterActionPerformed

    private void recordsfilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recordsfilterActionPerformed

        String searchString = recordsfilter.getSelectedItem().toString();
        recordfiltertab(searchString);

    }//GEN-LAST:event_recordsfilterActionPerformed

    private void studlistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studlistActionPerformed

        String searchString = studlist.getSelectedItem().toString();
        issuestudfilter(searchString);
    }//GEN-LAST:event_studlistActionPerformed

    private void booklistfilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_booklistfilterActionPerformed

        String searchString = booklistfilter.getSelectedItem().toString();
        issuebookfilter(searchString);
    }//GEN-LAST:event_booklistfilterActionPerformed

    private void retdetailsfilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retdetailsfilterActionPerformed

        String searchString = retdetailsfilter.getSelectedItem().toString();
        findreturnfilter(searchString);
    }//GEN-LAST:event_retdetailsfilterActionPerformed

    private void jButton28MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton28MouseEntered
        addopt1.setVisible(true);
    }//GEN-LAST:event_jButton28MouseEntered

    private void jButton28MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton28MouseExited
        addopt1.setVisible(false);
    }//GEN-LAST:event_jButton28MouseExited

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton28ActionPerformed

    private void jButton29MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton29MouseEntered
        delopt1.setVisible(true);
    }//GEN-LAST:event_jButton29MouseEntered

    private void jButton29MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton29MouseExited
        delopt1.setVisible(false);
    }//GEN-LAST:event_jButton29MouseExited

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton29ActionPerformed

    private void hide1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hide1MouseClicked
       this.setExtendedState(BOARD.ICONIFIED);
    }//GEN-LAST:event_hide1MouseClicked

    private void hide2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hide2MouseClicked
        this.setExtendedState(BOARD.ICONIFIED);
    }//GEN-LAST:event_hide2MouseClicked

    private void hide3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hide3MouseClicked
        this.setExtendedState(BOARD.ICONIFIED);
    }//GEN-LAST:event_hide3MouseClicked

    private void hide4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hide4MouseClicked
       this.setExtendedState(BOARD.ICONIFIED);
    }//GEN-LAST:event_hide4MouseClicked

    private void hide5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hide5MouseClicked
        this.setExtendedState(BOARD.ICONIFIED);
    }//GEN-LAST:event_hide5MouseClicked

    private void hide6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hide6MouseClicked
        this.setExtendedState(BOARD.ICONIFIED);
    }//GEN-LAST:event_hide6MouseClicked

    private void hide7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hide7MouseClicked
       this.setExtendedState(BOARD.ICONIFIED);
    }//GEN-LAST:event_hide7MouseClicked

    private void hideMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hideMouseClicked
        this.setExtendedState(BOARD.ICONIFIED);
    }//GEN-LAST:event_hideMouseClicked

    private void hide8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hide8MouseClicked
       this.setExtendedState(BOARD.ICONIFIED);
    }//GEN-LAST:event_hide8MouseClicked

    private void hide9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hide9MouseClicked
        this.setExtendedState(BOARD.ICONIFIED);
    }//GEN-LAST:event_hide9MouseClicked

    private void ex1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ex1MouseClicked
         dispose();
    }//GEN-LAST:event_ex1MouseClicked

    private void ex2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ex2MouseClicked
         dispose();
    }//GEN-LAST:event_ex2MouseClicked

    private void ex3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ex3MouseClicked
         dispose();
    }//GEN-LAST:event_ex3MouseClicked

    private void ex4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ex4MouseClicked
         dispose();
    }//GEN-LAST:event_ex4MouseClicked

    private void ex5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ex5MouseClicked
         dispose();
    }//GEN-LAST:event_ex5MouseClicked

    private void ex6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ex6MouseClicked
         dispose();
    }//GEN-LAST:event_ex6MouseClicked

    private void ex7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ex7MouseClicked
         dispose();
    }//GEN-LAST:event_ex7MouseClicked

    private void exMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exMouseClicked
         dispose();
    }//GEN-LAST:event_exMouseClicked

    private void ex8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ex8MouseClicked
         dispose();
    }//GEN-LAST:event_ex8MouseClicked

    private void ex9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ex9MouseClicked
         dispose();
    }//GEN-LAST:event_ex9MouseClicked

    private void hide1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hide1MousePressed
         resetColor(j);
    }//GEN-LAST:event_hide1MousePressed

    private void hide1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hide1MouseExited
         setColor(j);
    }//GEN-LAST:event_hide1MouseExited

    private void hide1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hide1MouseEntered
       
    }//GEN-LAST:event_hide1MouseEntered

    private void ex10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ex10MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ex10MouseClicked

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
            java.util.logging.Logger.getLogger(BOARD.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BOARD.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BOARD.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BOARD.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JLabel a13;
    private javax.swing.JLabel a15;
    private javax.swing.JLabel a16;
    private javax.swing.JPanel a6;
    private javax.swing.JLabel a7;
    private javax.swing.JLabel a8;
    private javax.swing.JLabel a9;
    private javax.swing.JLabel addopt;
    private javax.swing.JLabel addopt1;
    private javax.swing.JPanel book;
    private javax.swing.JLabel book_add;
    private javax.swing.JLabel book_delete;
    private javax.swing.JLabel book_edit;
    private javax.swing.JLabel book_update;
    private javax.swing.JLabel bookcount;
    private javax.swing.JComboBox<String> booklistfilter;
    private javax.swing.JTextField booklistsearch;
    private javax.swing.JLabel books;
    private javax.swing.JLabel btextadd;
    private javax.swing.JLabel btxtedit;
    private javax.swing.JLabel btxtremove;
    private javax.swing.JLabel btxtupdate;
    private javax.swing.JLabel dash;
    private javax.swing.JPanel dashboard;
    private javax.swing.JTable db2_table;
    private javax.swing.JComboBox<String> db_filter;
    private javax.swing.JComboBox<String> db_filter2;
    private javax.swing.JTextField db_search;
    private javax.swing.JTextField db_search1;
    private javax.swing.JTable db_table;
    private javax.swing.JLabel delopt;
    private javax.swing.JLabel delopt1;
    private javax.swing.JPanel details;
    private javax.swing.JTextField detailsssearch;
    private javax.swing.JLabel ex;
    private javax.swing.JLabel ex1;
    private javax.swing.JLabel ex10;
    private javax.swing.JLabel ex2;
    private javax.swing.JLabel ex3;
    private javax.swing.JLabel ex4;
    private javax.swing.JLabel ex5;
    private javax.swing.JLabel ex6;
    private javax.swing.JLabel ex7;
    private javax.swing.JLabel ex8;
    private javax.swing.JLabel ex9;
    private javax.swing.JButton finddetailsreturn;
    private javax.swing.JTable findreturndetails;
    private javax.swing.JComboBox<String> genrecombobox;
    private javax.swing.JLabel hide;
    private javax.swing.JLabel hide1;
    private javax.swing.JLabel hide2;
    private javax.swing.JLabel hide3;
    private javax.swing.JLabel hide4;
    private javax.swing.JLabel hide5;
    private javax.swing.JLabel hide6;
    private javax.swing.JLabel hide7;
    private javax.swing.JLabel hide8;
    private javax.swing.JLabel hide9;
    private javax.swing.JButton issue;
    private com.toedter.calendar.JDateChooser issue_duedate;
    private com.toedter.calendar.JDateChooser issue_issuedate;
    private javax.swing.JButton issuebk_button;
    private javax.swing.JPanel issuebook;
    private javax.swing.JTextField issuebookau;
    private javax.swing.JTextField issuebookgnr;
    private javax.swing.JTextField issuebookid;
    private javax.swing.JTable issuebooklist;
    private javax.swing.JTextField issuebooknm;
    private javax.swing.JTextField issuebookqua;
    private javax.swing.JLabel issuedbcount;
    private javax.swing.JButton issuefindbooklist;
    private javax.swing.JButton issuefindstud;
    private javax.swing.JTextField issuestudgrsec;
    private javax.swing.JTextField issuestudid;
    private javax.swing.JTable issuestudlist;
    private javax.swing.JTextField issuestudnm;
    private javax.swing.JTextField issuestudstr;
    private javax.swing.JPanel j;
    private javax.swing.JPanel j2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
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
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel51;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JComboBox<String> manageb_filter;
    private javax.swing.JTextField manageb_search;
    private javax.swing.JTable manageb_table;
    private javax.swing.JPanel managebook;
    private javax.swing.JPanel managestudent;
    private javax.swing.JLabel optadd;
    private javax.swing.JLabel optdel;
    private javax.swing.JLabel rec;
    private javax.swing.JPanel records;
    private javax.swing.JComboBox<String> recordsfilter;
    private javax.swing.JTextField recordssearch;
    private javax.swing.JTable recordstable;
    private javax.swing.JButton ret_find_but;
    private javax.swing.JComboBox<String> retdetailsfilter;
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
    private javax.swing.JTextField searchmanagstud;
    private javax.swing.JLabel stud_add;
    private javax.swing.JLabel stud_delete;
    private javax.swing.JLabel stud_edit;
    private javax.swing.JLabel stud_update;
    private javax.swing.JPanel student;
    private javax.swing.JLabel studentcount;
    private javax.swing.JLabel students;
    private javax.swing.JComboBox<String> studfilter;
    private javax.swing.JComboBox<String> studlist;
    private javax.swing.JTextField studlistsearch;
    private javax.swing.JTable studtable;
    private javax.swing.JPanel t1;
    private javax.swing.JPanel t2;
    private javax.swing.JPanel t3;
    private javax.swing.JPanel t4;
    private javax.swing.JPanel t5;
    private javax.swing.JLabel textadd1;
    private javax.swing.JLabel trans;
    private javax.swing.JComboBox<String> transacfilter;
    private javax.swing.JPanel transaction;
    private javax.swing.JTextField transactionssearch;
    private javax.swing.JTable transactiontable;
    private javax.swing.JTextField txtBookAuthor;
    private javax.swing.JTextField txtBookID;
    private javax.swing.JTextField txtBookName;
    private javax.swing.JComboBox<String> txtGrandSec;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JComboBox<String> txtStrand;
    private javax.swing.JTextField txtStudentID;
    private javax.swing.JTextField txtStudentName;
    private javax.swing.JLabel txtedit1;
    private javax.swing.JLabel txtremove1;
    private javax.swing.JLabel txtupdate1;
    // End of variables declaration//GEN-END:variables
}
