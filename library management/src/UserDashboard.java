import javax.swing.*;

public class UserDashboard extends JFrame {
    JButton viewAvailableBooks, viewIssuedBooks;

    UserDashboard() {
        setTitle("User Dashboard");
        setSize(500, 400);
        setLayout(null);

        viewAvailableBooks = new JButton("View Available Books");
        viewIssuedBooks = new JButton("View Borrowed Books");

        viewAvailableBooks.setBounds(100, 100, 200, 30);
        viewIssuedBooks.setBounds(100, 150, 200, 30);

        add(viewAvailableBooks);
        add(viewIssuedBooks);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
