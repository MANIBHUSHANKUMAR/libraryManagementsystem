import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AddBookForm extends JFrame {
    JTextField titleField, authorField, isbnField, quantityField;
    JButton submitButton;

    AddBookForm() {
        setTitle("Add Book");
        setSize(400, 300);
        setLayout(new GridLayout(5, 2));

        titleField = new JTextField();
        authorField = new JTextField();
        isbnField = new JTextField();
        quantityField = new JTextField();

        submitButton = new JButton("Submit");

        add(new JLabel("Title:"));
        add(titleField);
        add(new JLabel("Author:"));
        add(authorField);
        add(new JLabel("ISBN:"));
        add(isbnField);
        add(new JLabel("Quantity:"));
        add(quantityField);
        add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String title = titleField.getText();
                String author = authorField.getText();
                String isbn = isbnField.getText();
                int quantity = Integer.parseInt(quantityField.getText());

                try {
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
                    PreparedStatement ps = con.prepareStatement("INSERT INTO books (title, author, isbn, quantity) VALUES (?, ?, ?, ?)");
                    ps.setString(1, title);
                    ps.setString(2, author);
                    ps.setString(3, isbn);
                    ps.setInt(4, quantity);

                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Book Added Successfully");
                    dispose(); // Close the form after submission
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
