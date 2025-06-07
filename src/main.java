import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main implements ActionListener {

    JFrame frame;
    JTextField textField;
    JButton[] NumberedButtons = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JButton addButton,subButton,mulButton,divButton;
    JButton decButton,equButton,delButton,clrButton,negButton;
    JPanel panel;

    Font font = new Font("Segoe UI", Font.BOLD, 24);
    Font buttonFont = new Font("Segoe UI", Font.PLAIN, 20);

    double num1 = 0, num2 = 0, result = 0;
    char operator;


    main(){
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(420, 600);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(40, 44, 52));

        textField = new JTextField();
        textField.setBounds(50, 25, 300, 60);
        textField.setFont(font);
        textField.setEditable(false);
        textField.setHorizontalAlignment(SwingConstants.RIGHT);
        textField.setBackground(new Color(30, 33, 40));
        textField.setForeground(Color.WHITE);
        textField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

        // Buttons
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("Clear");
        decButton = new JButton(".");
        negButton = new JButton("(-)");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;


        for (int i = 0; i < 9; i++) {
            styleButton(functionButtons[i]);
        }


        for (int i = 0; i < 10; i++) {
            NumberedButtons[i] = new JButton(String.valueOf(i));
            styleButton(NumberedButtons[i]);
        }

        negButton.setBounds(50, 480, 100, 50);
        delButton.setBounds(150, 480, 100, 50);
        clrButton.setBounds(250, 480, 100, 50);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 360);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        panel.setBackground(new Color(40, 44, 52));

        panel.add(NumberedButtons[1]);
        panel.add(NumberedButtons[2]);
        panel.add(NumberedButtons[3]);
        panel.add(addButton);
        panel.add(NumberedButtons[4]);
        panel.add(NumberedButtons[5]);
        panel.add(NumberedButtons[6]);
        panel.add(subButton);
        panel.add(NumberedButtons[7]);
        panel.add(NumberedButtons[8]);
        panel.add(NumberedButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(NumberedButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textField);
        frame.setVisible(true);
    }

    private void styleButton(JButton button) {
        button.addActionListener(this);
        button.setFont(buttonFont);
        button.setFocusable(false);
        button.setBackground(new Color(60, 63, 65));
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createLineBorder(new Color(80, 80, 80)));
    }

    public static void main(String[] args) {
        main calc = new main();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == NumberedButtons[i]) {
                textField.setText(textField.getText() + i);
            }
        }

        if (e.getSource() == decButton) {
            String temp = textField.getText();
            if (!temp.contains(".")) {
                textField.setText(temp + ".");
            }
        }

        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }

        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }

        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }

        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }

        if (e.getSource() == equButton) {
            num2 = Double.parseDouble(textField.getText());
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;

                case '-':
                    result = num1 - num2;
                    break;

                case '*':
                    result = num1 * num2;
                    break;

                case '/':
                    result = num1 / num2;
                    break;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }

        if (e.getSource() == clrButton) {
            textField.setText("");
        }

        if (e.getSource() == delButton) {
            String str = textField.getText();
            textField.setText("");

            for (int i = 0; i < str.length()-1; i++) {
                textField.setText(textField.getText()+str.charAt(i));
            }
        }

        if (e.getSource() == negButton) {
            double temp = Double.parseDouble(textField.getText());
            temp = -temp;
            textField.setText(String.valueOf(temp));
        }
    }
}
