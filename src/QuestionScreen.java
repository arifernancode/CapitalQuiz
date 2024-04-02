import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;

public class QuestionScreen extends JFrame implements ActionListener {
    JButton submitButton = new JButton("Submit");
    ButtonGroup buttons;

    JRadioButton button1;
    JRadioButton button2;
    JRadioButton button3;

    public boolean isDisposable = false;

    String capital;

    public QuestionScreen(String country, String capital, String[] choices) {
        this.setFocusable(true);
        this.capital = capital;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(450, 450);
        this.setLayout(null);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(0xADD8E6));

        JTextPane countryArea = new JTextPane();
        countryArea.setText(country);
        StyledDocument doc = countryArea.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);
        countryArea.setBounds(20, 20, 360, 80);
        countryArea.setFont(new Font("Times New Roman", Font.BOLD, 30));
        countryArea.setBackground(new Color(0xADD8E6));
        countryArea.setEditable(false);

        this.add(countryArea);

        buttons = new ButtonGroup();
        button1 = new JRadioButton(choices[0]);
        button2 = new JRadioButton(choices[1]);
        button3 = new JRadioButton(choices[2]);
        buttons.add(button1);
        buttons.add(button2);
        buttons.add(button3);

        button1.setBounds(40, 120, 120, 40);
        button2.setBounds(150, 120, 120, 40);
        button3.setBounds(280, 120, 120, 40);

        button1.addActionListener(e -> submitButton.setEnabled(true));
        button2.addActionListener(e -> submitButton.setEnabled(true));
        button3.addActionListener(e -> submitButton.setEnabled(true));

        this.add(button1);
        this.add(button2);
        this.add(button3);

        submitButton.addActionListener(this);
        submitButton.setBounds(365, 380, 80,40);
        submitButton.setEnabled(false);

        this.add(submitButton);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(submitButton)) {
            String selectedButtonText = "";

            if(button1.isSelected()) selectedButtonText = button1.getText();
            else if(button2.isSelected()) selectedButtonText = button2.getText();
            else if(button3.isSelected()) selectedButtonText = button3.getText();

            boolean isCorrect = selectedButtonText.equals(capital);
            System.out.println(isCorrect);

            if(isCorrect) CountryGame.questionsCorrect++;

            isDisposable = true;

            dispose();
        }
    }
}