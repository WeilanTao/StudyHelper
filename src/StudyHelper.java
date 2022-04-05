import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;
import java.time.Instant;

public class StudyHelper extends JFrame{
    private JPanel panelMain;
    private JPanel clockPanel;
    private JPanel buttonPanel;
    private JLabel clockLabel;
    private JLabel noticeLabel;

    private JButton restButton;
    private JButton studyButton;
    private JButton resetButton;

    private Timer timer;

    public static void main(String[] args) {
        //to make gain the system ui look; support cross-platform
        try {
            UIManager.setLookAndFeel(UIManager.
                    getSystemLookAndFeelClassName());
        } catch(Exception e) {
            e.printStackTrace();
        }

        StudyHelper sh = new StudyHelper();

        //button actions
        sh.studyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Instant start = Instant.now();
                sh.timer = new Timer(1, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Duration duration = Duration.between(start, Instant.now());
                        long h = duration.toHours();
                        long m = duration.toMinutes() - 60 * h;
                        long s = duration.getSeconds() - 60 * m;

                        sh.clockLabel.setText(String.format("%02d",h)+" : "+String.format("%02d",m)+" : "+String.format("%02d",s));
                    }
                });
                sh.timer.start();
            }
        });

    }


    public StudyHelper() {

        // Layout the elements
        setLayout(this);

        //initialize studyhelper
        studyHelperInitialize(this);
    }
    private  static void studyHelperInitialize(StudyHelper sh){
        sh.setTitle("Study Helper");
        sh.setSize(1080, 700);
        sh.setVisible(true);


        // Todo: I don't want it to exit on close!!!
        sh.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        sh.setResizable(false);
        sh.setLocationRelativeTo(null);

    }

    private static void setLayout (StudyHelper sh){
        //component initializing and styling

        //label
        JLabel title = new JLabel("Good Good Study, Day Day Up", SwingConstants.CENTER);
        sh.clockLabel = new JLabel("Clock Area", SwingConstants.CENTER);
        sh.noticeLabel = new JLabel("Notice Area", SwingConstants.CENTER);

        Font titleFont = title.getFont().deriveFont(Font.BOLD, 32f);
        title.setFont(titleFont);
        title.setVerticalAlignment(JLabel.TOP);
        sh.clockLabel.setFont(titleFont);
        sh.noticeLabel.setFont(titleFont);

        //button
        sh.restButton = new JButton("Break");
        sh.studyButton = new JButton("Study");
        sh.resetButton = new JButton("Reset ");

        Font buttonFount = sh.resetButton.getFont().deriveFont(Font.BOLD, 26f);
        sh.restButton.setFont(buttonFount);
        sh.studyButton.setFont(buttonFount);
        sh.resetButton.setFont(buttonFount);
        sh.restButton.setFocusPainted(false);
        sh.studyButton.setFocusPainted(false);
        sh.resetButton.setFocusPainted(false);


        int btnw = 200;
        int btnh = 30;
        sh.restButton.setPreferredSize(new Dimension(btnw, btnh));
        sh.studyButton.setPreferredSize(new Dimension(btnw, btnh));
        sh.resetButton.setPreferredSize(new Dimension(btnw, btnh));

        //position
        sh.panelMain = new JPanel(new GridBagLayout());
        sh.panelMain.setBorder(new EmptyBorder(10, 10, 10, 10));

        GridBagConstraints gbc = new GridBagConstraints();

        //the title line
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth=3;
        gbc.gridheight=1;
        gbc.ipady = 10;
        gbc.weighty =500;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        sh.panelMain.add(title,gbc);

        //the clock line
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth=3;
        gbc.gridheight=1;
        gbc.ipady = 350;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        sh.clockPanel= new JPanel(new GridLayout(1,2));
        sh.clockPanel.add(sh.clockLabel);
        sh.clockPanel.add(sh.noticeLabel);
        sh.panelMain.add(sh.clockPanel,gbc);


        //the button line
        sh.buttonPanel= new JPanel(new GridLayout(1,3,50,5));
        sh.buttonPanel.add(sh.studyButton,gbc);
        sh.buttonPanel.add(sh.restButton,gbc);
        sh.buttonPanel.add(sh.resetButton,gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth=2;
        gbc.gridheight=1;
        gbc.ipady = btnh;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        sh.panelMain.add(sh.buttonPanel,gbc);

        //add painMain to JFrame studyHelper
        sh.setContentPane(sh.panelMain);

    }

}
