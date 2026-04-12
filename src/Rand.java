import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class Rand {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Pass System");
        frame.setSize(450, 400); // הגבהנו מעט כדי שיהיה מקום לטקסט
        frame.getContentPane().setBackground(new Color(220, 153, 182));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        JTextArea textArea = new JTextArea("Enter a username & password:");
        textArea.setBounds(20, 20, 400, 80);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        textArea.setOpaque(false);
        textArea.setFont(new Font("Verdana", Font.BOLD, 18));
        frame.add(textArea);


        JLabel userLabel = new JLabel("username:");
        userLabel.setBounds(20, 110, 100, 25);
        frame.add(userLabel);

        JTextField userField = new JTextField();
        userField.setBounds(120, 110, 150, 25);
        frame.add(userField);

        JLabel passLabel = new JLabel("password:");
        passLabel.setBounds(20, 150, 100, 25);
        frame.add(passLabel);

        JPasswordField passField = new JPasswordField();
        passField.setBounds(120, 150, 150, 25);
        frame.add(passField);

        JButton button = new JButton("Click");
        button.setBounds(120, 200, 100, 30);
        button.setBackground(new Color(6, 19, 8));
        button.setForeground(new Color(171, 91, 126));
        frame.add(button);


        Pass passChecker = new Pass();
        Username userChecker = new Username();

        button.addActionListener(e -> {
            String userIn = userField.getText().trim();
            String passIn = new String(passField.getPassword());

            String userRes = userChecker.valid(userIn);
            String passRes = passChecker.generate(passIn);

            if (userRes.equals("OK") && passRes.equals("Perfecto!")) {

                if (saveUserToDB(userIn, passIn)) {
                    textArea.setForeground(new Color(0, 100, 0)); // ירוק כהה
                    textArea.setText("Success! Registered: " + userIn);
                } else {
                    textArea.setForeground(new Color(101, 17, 26));
                    textArea.setText("Database Error: Could not save user.");
                }

            } else {

                textArea.setForeground(Color.RED);
                StringBuilder errors = new StringBuilder();

                if (!userRes.equals("OK")) errors.append("User: ").append(userRes).append("\n");
                if (!passRes.equals("Perfecto!")) errors.append("Pass: ").append(passRes);

                textArea.setText(errors.toString());
            }
        });

        frame.setVisible(true);
    }

    public static boolean saveUserToDB(String user, String pass) {
        String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
        try (Connection conn = DB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, user);
            pstmt.setString(2, pass);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Save failed: " + e.getMessage());
            return false;
        }
    }
}
