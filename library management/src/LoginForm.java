import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class LoginForm extends JFrame implements ActionListener {
    JLabel userLabel, passLabel;
    JTextField userField;
    JPasswordField passField;
    JButton loginButton;

    // Constructor
    LoginForm() {
        setTitle("Library Management System - Login");
        setSize(400, 200);
        setLayout(new GridLayout(3, 2));

        userLabel = new JLabel("Username:");
        userField = new JTextField();

        passLabel = new JLabel("Password:");
        passField = new JPasswordField();

        loginButton = new JButton("Login");
        loginButton.addActionListener(this);

        add(userLabel);
        add(userField);
        add(passLabel);
        add(passField);
        add(loginButton);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String username = userField.getText();
        String password = String.valueOf(passField.getPassword());

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter both username and password");
            return;
        }

        String url = "jdbc:mysql://localhost:3306/library";

        try (Connection con = DriverManager.getConnection(url, "root", "");
             PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE username=? AND password=?")) {

            ps.setString(1, username);
            ps.setString(2, password); // Consider hashing the password here

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String role = rs.getString("role");
                    if (role.equals("admin")) {
                        new AdminDashboard();
                    } else {
                        new UserDashboard();
                    }
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid username or password");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new LoginForm();
    }
}
