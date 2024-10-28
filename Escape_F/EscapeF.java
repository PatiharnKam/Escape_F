package Project3_6513172;
//Puthipong Yomabut 6513134
//Phattaradanai Sornsawang 6513172
//Patiharn Kamenkit 6513170
//Praphasiri wannawong 6513116
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EscapeF extends JFrame {
    private board b;
    private JFrame backframe;

    public EscapeF(board b, JFrame backframe) {
        this.b = b;
        this.backframe = backframe;

        SetBackgroundInGame backgroundPanel = new SetBackgroundInGame("src/main/Java/Project3_6513172/resources/ESC-F.gif");

        backgroundPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        b.setPreferredSize(new Dimension(400, 400)); // Set the prefer size of the board panel
        b.setSize(b.getPreferredSize()); // Set the size of the board from prederred size
        backgroundPanel.add(b, gbc);

        JButton backButton = new JButton("Back to Menu");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(EscapeF.this, "Are you sure you want to go back to the menu?", "Back to Menu", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    backframe.setVisible(true);
                    dispose();
                } else {
                b.requestFocusInWindow();
                }
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(10, 0, 0, 0);

        // Add the button to the panel
        backgroundPanel.add(backButton, gbc);

        setContentPane(backgroundPanel);
    }
}

class SetBackgroundInGame extends JPanel {
    private Image backgroundImage;

    public SetBackgroundInGame(String fileName) {
        backgroundImage = new ImageIcon(fileName).getImage();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the background image.
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
}