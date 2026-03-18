import javax.swing.*;
import java.awt.*;

public class Rand {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Pass");
        frame.setSize(400, 350);
        frame.getContentPane().setBackground(new Color(223, 104, 208));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        JTextArea textArea = new JTextArea("Enter a password:");
        textArea.setBounds(20, 50, 440, 60);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        textArea.setOpaque(false);
        textArea.setFont(new Font("Arial", Font.BOLD, 18));
        frame.add(textArea);

        JTextField textField = new JTextField();
        textField.setBounds(20, 160, 150, 25);
        frame.add(textField);

        JButton button = new JButton("Click");
        button.setBounds(180, 160, 90, 25);
        button.setBackground(new Color(6, 19, 8));
        button.setForeground(new Color(176, 120, 191));
        frame.add(button);

        passgen generator = new passgen();

        button.addActionListener(e -> {
            String input = textField.getText();
            if (!input.isEmpty()) {
                String securePass = generator.generate(input);
                textArea.setText("Your new password:\n" + securePass);
            } else {
                textArea.setText("Please enter something first!");
            }
        });

        frame.setVisible(true);
    }
}
