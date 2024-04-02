import javax.swing.*;
import java.awt.*;

public class EndScreen extends JFrame {
    public EndScreen() {
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.orange);
        this.setLayout(new FlowLayout(FlowLayout.LEADING));
        this.setSize(500, 500);

        JLabel finalScore = new JLabel((int) CountryGame.finalScore + "%");
        finalScore.setFont(new Font("Times New Roman", Font.BOLD, 150));

        this.add(finalScore);
        pack();

    }
}