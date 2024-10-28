package Project3_6513172;
//Puthipong Yomabut 6513134
//Phattaradanai Sornsawang 6513172
//Patiharn Kamenkit 6513170
//Praphasiri wannawong 6513116
import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class frame_setting extends JFrame {
    private MySoundEffect sound;
    private Newmain nm;
    private JPanel contentpane_setting;
    private JFrame backframe_2,frame;
    private String path = "src/main/Java/Project3_6513172/resources/";
    private String[] background = {"background_menu.png"};
    private String[] buttonImages = {"button_back.png","button_soundoff.png","button_soundon.png"};

    public frame_setting(JFrame mainframe){
        nm = (Newmain) mainframe;
        backframe_2 = mainframe;
        sound = new MySoundEffect(path + "bgsound.wav");
        setTitle("ESCAPE-F");
        setSize(1365, 768);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int result = JOptionPane.showConfirmDialog(
                        frame,
                        "Are you sure you want to exit?",
                        "Exit Confirmation",
                        JOptionPane.YES_NO_OPTION
                );

                if (result == JOptionPane.YES_OPTION) {
                    // If clicks "Yes", exit the application
                    System.exit(0);
                }
            }
        });

        contentpane_setting = new JPanel(null);

        ImageIcon backgroundImage = new ImageIcon(path + background[0]);
        JLabel bg_setting_Label = new JLabel(backgroundImage);
        bg_setting_Label.setBounds(0, 0, 1365, 768);
        contentpane_setting.add(bg_setting_Label);

        JPanel buttonpanel = new JPanel(null);
        buttonpanel.setBounds(0, 0, 1200,1200);
        MyButton[] buttons = new MyButton[buttonImages.length];

        // button back
        ImageIcon button_back = new ImageIcon(path + buttonImages[0]);
        buttons[0] =new MyButton(button_back);
        buttons[0].setBounds(150, 600, 166, 140);
        buttons[0].addActionListener(e -> handleClick(0));
        bg_setting_Label.add(buttons[0]);        // Add JButton in JPanel

        ImageIcon button_mutemusic = new ImageIcon(path + buttonImages[1]);
        buttons[1] = new MyButton(button_mutemusic);
        buttons[1].setBounds(550, 275, 200,100);
        buttons[1].addActionListener(e -> handleClick(1));
        bg_setting_Label.add(buttons[1]);

        ImageIcon button_playmusic = new ImageIcon(path + buttonImages[2]);
        buttons[2] = new MyButton(button_playmusic);
        buttons[2].setBounds(550, 400, 200,100);
        buttons[2].addActionListener(e -> handleClick(2));
        bg_setting_Label.add(buttons[2]);

        buttonpanel.setOpaque(true);
        contentpane_setting.add(buttonpanel);
        setContentPane(contentpane_setting);
        this.setVisible(true);
        this.repaint();

    }
    public void handleClick(int buttonindex){
        switch (buttonindex) {
            case 0:
                backframe_2.setVisible(true);
                dispose();  // delete play_frame
                break;
            case 1:
                nm.stopmusic();
                break;
            case 2:
                nm.playmusic2();
                break;

        }
    }
}

