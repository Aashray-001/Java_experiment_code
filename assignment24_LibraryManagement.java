import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class assignment24_LibraryManagement extends JFrame {

    JTextField txtId, txtTitle, txtAuthor, txtCategory, txtPrice;
    JTable table;
    DefaultTableModel model;

    String url = "jdbc:mysql://localhost:3306/Library";
    String username = "root";
    String password = "root";

    public assignment24_LibraryManagement() {

        setTitle("Library Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Heading
        JLabel heading = new JLabel("LIBRARY MANAGEMENT SYSTEM");
        heading.setFont(new Font("Arial", Font.BOLD, 24));
        heading.setHorizontalAlignment(JLabel.CENTER);

        // Input panel
        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 10, 10));

        inputPanel.add(new JLabel("Book ID:"));
        txtId = new JTextField();
        inputPanel.add(txtId);

        inputPanel.add(new JLabel("Book Title:"));
        txtTitle = new JTextField();
        inputPanel.add(txtTitle);

        inputPanel.add(new JLabel("Author:"));
        txtAuthor = new JTextField();
        inputPanel.add(txtAuthor);

        inputPanel.add(new JLabel("Category:"));
        txtCategory = new JTextField();
        inputPanel.add(txtCategory);

        inputPanel.add(new JLabel("Price:"));
        txtPrice = new JTextField();
        inputPanel.add(txtPrice);

        // Buttons
        JPanel buttonPanel = new JPanel();

        JButton btnAdd = new JButton("Add Book");
        JButton btnView = new JButton("View Books");
        JButton btnSearch = new JButton("Search");
        JButton btnDelete = new JButton("Delete");
        JButton btnClear = new JButton("Clear");

        buttonPanel.add(btnAdd);
        buttonPanel.add(btnView);
        buttonPanel.add(btnSearch);
        buttonPanel.add(btnDelete);
        buttonPanel.add(btnClear);

        // Table
        model = new DefaultTableModel();

        model.addColumn("Book ID");
        model.addColumn("Title");
        model.addColumn("Author");
        model.addColumn("Category");
        model.addColumn("Price");

        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);

        // Main layout
        setLayout(new BorderLayout(10, 10));

        add(heading, BorderLayout.NORTH);
        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        add(scrollPane, BorderLayout.EAST);

        // Better layout using another panel
        JPanel centerPanel = new JPanel(new BorderLayout(10, 10));
        centerPanel.add(inputPanel, BorderLayout.NORTH);
        centerPanel.add(scrollPane, BorderLayout.CENTER);

        remove(inputPanel);
        remove(scrollPane);

        add(centerPanel, BorderLayout.CENTER);

        // Button actions
        btnAdd.addActionListener(e -> addBook());
        btnView.addActionListener(e -> viewBooks());
        btnSearch.addActionListener(e -> searchBook());
        btnDelete.addActionListener(e -> deleteBook());
        btnClear.addActionListener(e -> clearFields());

        setVisible(true);
    }

    // Database connection
    Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    // Add book
    void addBook() {

        String sql = "INSERT INTO books VALUES (?, ?, ?, ?, ?)";

        try {
            Connection con = getConnection();

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, Integer.parseInt(txtId.getText()));
            pst.setString(2, txtTitle.getText());
            pst.setString(3, txtAuthor.getText());
            pst.setString(4, txtCategory.getText());
            pst.setDouble(5, Double.parseDouble(txtPrice.getText()));

            pst.executeUpdate();

            JOptionPane.showMessageDialog(this,
                    "Book Added Successfully!");

            pst.close();
            con.close();

            clearFields();
            viewBooks();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "Error: " + ex.getMessage());
        }
    }

    // View all books
    void viewBooks() {

        model.setRowCount(0);

        String sql = "SELECT * FROM books";

        try {
            Connection con = getConnection();

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                model.addRow(new Object[]{
                        rs.getInt("book_id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("category"),
                        rs.getDouble("price")
                });
            }

            rs.close();
            stmt.close();
            con.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "Error: " + ex.getMessage());
        }
    }

    // Search book
    void searchBook() {

        String sql = "SELECT * FROM books WHERE book_id = ?";

        try {
            Connection con = getConnection();

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, Integer.parseInt(txtId.getText()));

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                txtTitle.setText(rs.getString("title"));
                txtAuthor.setText(rs.getString("author"));
                txtCategory.setText(rs.getString("category"));
                txtPrice.setText(String.valueOf(rs.getDouble("price")));

            } else {

                JOptionPane.showMessageDialog(this,
                        "Book Not Found!");
            }

            rs.close();
            pst.close();
            con.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "Error: " + ex.getMessage());
        }
    }

    // Delete book
    void deleteBook() {

        String sql = "DELETE FROM books WHERE book_id = ?";

        try {
            Connection con = getConnection();

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, Integer.parseInt(txtId.getText()));

            int result = pst.executeUpdate();

            if (result > 0) {
                JOptionPane.showMessageDialog(this,
                        "Book Deleted Successfully!");
            } else {
                JOptionPane.showMessageDialog(this,
                        "Book Not Found!");
            }

            pst.close();
            con.close();

            clearFields();
            viewBooks();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "Error: " + ex.getMessage());
        }
    }

    // Clear fields
    void clearFields() {

        txtId.setText("");
        txtTitle.setText("");
        txtAuthor.setText("");
        txtCategory.setText("");
        txtPrice.setText("");
    }

    public static void main(String[] args) {
        new assignment24_LibraryManagement();
    }
}