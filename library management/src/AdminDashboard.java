import javax.swing.*;
import java.awt.event.*;

public class AdminDashboard extends JFrame {
    JButton addBookButton, viewBooksButton, manageUsersButton;

    AdminDashboard() {
        setTitle("Admin Dashboard");
        setSize(500, 400);
        setLayout(null);

        addBookButton = new JButton("Add Book");
        viewBooksButton = new JButton("View Books");
        manageUsersButton = new JButton("Manage Users");

        addBookButton.setBounds(100, 50, 200, 30);
        viewBooksButton.setBounds(100, 100, 200, 30);
        manageUsersButton.setBounds(100, 150, 200, 30);

        add(addBookButton);
        add(viewBooksButton);
        add(manageUsersButton);

        // Action listeners for buttons (each button will open a new form)
        addBookButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code to add book (opens new form)
                new AddBookForm();
            }
        });

        viewBooksButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code to view books
               // new ViewBooksForm();
            }
        });

        manageUsersButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code to manage users
               // new ManageUsersForm();
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
