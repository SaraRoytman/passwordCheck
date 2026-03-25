import javax.swing.*;
import java.awt.*;

public class Rand {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Pass");
        frame.setSize(450, 450);
        frame.getContentPane().setBackground(new Color(223, 104, 208));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        JTextArea textArea = new JTextArea("Enter a username & password:");
        textArea.setBounds(20, 20, 400, 60);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        textArea.setOpaque(false);
        textArea.setFont(new Font("Arial", Font.BOLD, 18));
        frame.add(textArea);

        JLabel userLabel = new JLabel("username:");
        userLabel.setBounds(20, 100, 100, 25);
        frame.add(userLabel);

        JTextField userField = new JTextField();
        userField.setBounds(120, 100, 150, 25);
        frame.add(userField);

        JLabel passLabel = new JLabel("password:");
        passLabel.setBounds(20, 140, 100, 25);
        frame.add(passLabel);

        JTextField passField = new JTextField();
        passField.setBounds(120, 140, 150, 25);
        frame.add(passField);

        JButton button = new JButton("Click");
        button.setBounds(120, 190, 90, 25);
        button.setBackground(new Color(6, 19, 8));
        button.setForeground(new Color(176, 120, 191));
        frame.add(button);

        passgen passChecker = new passgen();
        Username userChecker = new Username();

        button.addActionListener(e -> {
            String userIn = userField.getText();
            String passIn = passField.getText();

            String userRes = userChecker.valid(userIn);
            String passRes = passChecker.generate(passIn);

            if (userRes.equals("OK") && passRes.equals("Perfecto!")) {
                textArea.setText("Success! Welcome " + userIn);
            } else {
                StringBuilder errors = new StringBuilder();
                if (!userRes.equals("OK")) errors.append("User: ").append(userRes).append("\n");
                if (!passRes.equals("Perfecto!")) errors.append("Pass: ").append(passRes);
                textArea.setText(errors.toString());
            }
        });

        frame.setVisible(true);
    }
}
