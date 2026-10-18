import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class assignment24_BookIssueTracking extends JFrame {

    JTextField txtIssueId, txtBookId, txtStudentName;
    JTextField txtIssueDate, txtReturnDate;

    JTable table;
    DefaultTableModel model;

    String url = "jdbc:mysql://localhost:3306/Library";
    String username = "root";
    String password = "root";

    public assignment24_BookIssueTracking() {

        setTitle("Book Issue Tracking System");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Heading
        JLabel heading = new JLabel("BOOK ISSUE TRACKING SYSTEM");
        heading.setFont(new Font("Arial", Font.BOLD, 24));
        heading.setHorizontalAlignment(JLabel.CENTER);

        // Input fields
        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 10, 10));

        inputPanel.add(new JLabel("Issue ID:"));
        txtIssueId = new JTextField();
        inputPanel.add(txtIssueId);

        inputPanel.add(new JLabel("Book ID:"));
        txtBookId = new JTextField();
        inputPanel.add(txtBookId);

        inputPanel.add(new JLabel("Student Name:"));
        txtStudentName = new JTextField();
        inputPanel.add(txtStudentName);

        inputPanel.add(new JLabel("Issue Date (YYYY-MM-DD):"));
        txtIssueDate = new JTextField();
        inputPanel.add(txtIssueDate);

        inputPanel.add(new JLabel("Return Date (YYYY-MM-DD):"));
        txtReturnDate = new JTextField();
        inputPanel.add(txtReturnDate);

        // Buttons
        JPanel buttonPanel = new JPanel();

        JButton btnAdd = new JButton("Add Record");
        JButton btnView = new JButton("View Records");
        JButton btnSearch = new JButton("Search");
        JButton btnUpdate = new JButton("Update");
        JButton btnDelete = new JButton("Delete");
        JButton btnClear = new JButton("Clear");

        buttonPanel.add(btnAdd);
        buttonPanel.add(btnView);
        buttonPanel.add(btnSearch);
        buttonPanel.add(btnUpdate);
        buttonPanel.add(btnDelete);
        buttonPanel.add(btnClear);

        // Table
        model = new DefaultTableModel();

        model.addColumn("Issue ID");
        model.addColumn("Book ID");
        model.addColumn("Student Name");
        model.addColumn("Issue Date");
        model.addColumn("Return Date");

        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        // Layout
        JPanel topPanel = new JPanel(new BorderLayout(10, 10));
        topPanel.add(heading, BorderLayout.NORTH);
        topPanel.add(inputPanel, BorderLayout.CENTER);

        setLayout(new BorderLayout(10, 10));

        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Button actions
        btnAdd.addActionListener(e -> addRecord());
        btnView.addActionListener(e -> viewRecords());
        btnSearch.addActionListener(e -> searchRecord());
        btnUpdate.addActionListener(e -> updateRecord());
        btnDelete.addActionListener(e -> deleteRecord());
        btnClear.addActionListener(e -> clearFields());

        // Double-click table row to load data
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {

                int row = table.getSelectedRow();

                if (row >= 0) {
                    txtIssueId.setText(model.getValueAt(row, 0).toString());
                    txtBookId.setText(model.getValueAt(row, 1).toString());
                    txtStudentName.setText(model.getValueAt(row, 2).toString());
                    txtIssueDate.setText(model.getValueAt(row, 3).toString());

                    Object returnDate = model.getValueAt(row, 4);

                    if (returnDate != null) {
                        txtReturnDate.setText(returnDate.toString());
                    } else {
                        txtReturnDate.setText("");
                    }
                }
            }
        });

        setVisible(true);
    }

    // Database connection
    Connection getConnection() throws SQLException {

        return DriverManager.getConnection(
                url, username, password
        );
    }

    // Add record
    void addRecord() {

        String sql = "INSERT INTO book_issue " +
                "(book_id, student_name, issue_date, return_date) " +
                "VALUES (?, ?, ?, ?)";

        try {

            Connection con = getConnection();

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, Integer.parseInt(txtBookId.getText()));
            pst.setString(2, txtStudentName.getText());
            pst.setDate(3, Date.valueOf(txtIssueDate.getText()));

            if (txtReturnDate.getText().trim().isEmpty()) {
                pst.setNull(4, Types.DATE);
            } else {
                pst.setDate(4, Date.valueOf(txtReturnDate.getText()));
            }

            pst.executeUpdate();

            JOptionPane.showMessageDialog(
                    this,
                    "Book Issue Record Added Successfully!"
            );

            pst.close();
            con.close();

            clearFields();
            viewRecords();

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Error: " + ex.getMessage()
            );
        }
    }

    // View records
    void viewRecords() {

        model.setRowCount(0);

        String sql = "SELECT * FROM book_issue";

        try {

            Connection con = getConnection();

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                model.addRow(new Object[]{
                        rs.getInt("issue_id"),
                        rs.getInt("book_id"),
                        rs.getString("student_name"),
                        rs.getDate("issue_date"),
                        rs.getDate("return_date")
                });
            }

            rs.close();
            stmt.close();
            con.close();

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Error: " + ex.getMessage()
            );
        }
    }

    // Search record
    void searchRecord() {

        String sql =
                "SELECT * FROM book_issue WHERE issue_id = ?";

        try {

            Connection con = getConnection();

            PreparedStatement pst =
                    con.prepareStatement(sql);

            pst.setInt(
                    1,
                    Integer.parseInt(txtIssueId.getText())
            );

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                txtBookId.setText(
                        String.valueOf(rs.getInt("book_id"))
                );

                txtStudentName.setText(
                        rs.getString("student_name")
                );

                txtIssueDate.setText(
                        rs.getDate("issue_date").toString()
                );

                Date returnDate = rs.getDate("return_date");

                if (returnDate != null) {
                    txtReturnDate.setText(
                            returnDate.toString()
                    );
                } else {
                    txtReturnDate.setText("");
                }

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Record Not Found!"
                );
            }

            rs.close();
            pst.close();
            con.close();

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Error: " + ex.getMessage()
            );
        }
    }

    // Update record
    void updateRecord() {

        String sql =
                "UPDATE book_issue SET " +
                "book_id = ?, student_name = ?, " +
                "issue_date = ?, return_date = ? " +
                "WHERE issue_id = ?";

        try {

            Connection con = getConnection();

            PreparedStatement pst =
                    con.prepareStatement(sql);

            pst.setInt(
                    1,
                    Integer.parseInt(txtBookId.getText())
            );

            pst.setString(
                    2,
                    txtStudentName.getText()
            );

            pst.setDate(
                    3,
                    Date.valueOf(txtIssueDate.getText())
            );

            if (txtReturnDate.getText().trim().isEmpty()) {

                pst.setNull(4, Types.DATE);

            } else {

                pst.setDate(
                        4,
                        Date.valueOf(txtReturnDate.getText())
                );
            }

            pst.setInt(
                    5,
                    Integer.parseInt(txtIssueId.getText())
            );

            int result = pst.executeUpdate();

            if (result > 0) {

                JOptionPane.showMessageDialog(
                        this,
                        "Record Updated Successfully!"
                );

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Record Not Found!"
                );
            }

            pst.close();
            con.close();

            clearFields();
            viewRecords();

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Error: " + ex.getMessage()
            );
        }
    }

    // Delete record
    void deleteRecord() {

        String sql =
                "DELETE FROM book_issue WHERE issue_id = ?";

        try {

            Connection con = getConnection();

            PreparedStatement pst =
                    con.prepareStatement(sql);

            pst.setInt(
                    1,
                    Integer.parseInt(txtIssueId.getText())
            );

            int result = pst.executeUpdate();

            if (result > 0) {

                JOptionPane.showMessageDialog(
                        this,
                        "Record Deleted Successfully!"
                );

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Record Not Found!"
                );
            }

            pst.close();
            con.close();

            clearFields();
            viewRecords();

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Error: " + ex.getMessage()
            );
        }
    }

    // Clear fields
    void clearFields() {

        txtIssueId.setText("");
        txtBookId.setText("");
        txtStudentName.setText("");
        txtIssueDate.setText("");
        txtReturnDate.setText("");
    }

    public static void main(String[] args) {

        new assignment24_BookIssueTracking();
    }
}