//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import javax.swing.*;
import java.awt.*;

public class Rand{
    public static void main(String[] args){
        JFrame frame = new JFrame("Pass");
        frame.setSize(450,250);
        frame.getContentPane().setBackground(new Color(223, 104, 208));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        JLabel label = new JLabel("Enter a password: ");
        label.setBounds(20, 20, 400, 25);
        label.setFont(new Font("Arial",Font.BOLD,18));

        JTextField textField = new JTextField();
        textField.setBounds(20, 70, 150, 25);

        JButton button = new JButton("Click");
        button.setBounds(180, 70, 90, 25);
        button.setBackground(new Color(6, 19, 8));
        button.setForeground(new Color(176, 120, 191));



        frame.add(textField);
        frame.add(button);
        frame.add(label);
        passgen generator = new passgen();

        button.addActionListener(e -> {
            String input = textField.getText();


            String securePass = generator.generate(input);

            label.setText("Your new password: " + securePass);
        });

        frame.setVisible(true);
    }

}
