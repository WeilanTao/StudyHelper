import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudyHelper extends JFrame{
    private JPanel panelMain;
    private JPanel clockPanel;
    private JPanel buttonPanel;
    private JLabel clockLabel;
    private JLabel noticeLabel;

    private JButton restButton;
    private JButton studyButton;
    private JButton resetButton;

    public static void main(String[] args) {
        StudyHelper sh = new StudyHelper();

        // Layout the elements
        setLayout(sh);

        //initialize studyhelper
        studyHelperInitialize(sh);

    }
    private  static void studyHelperInitialize(StudyHelper sh){
        sh.setTitle("Study Helper");
        sh.setSize(1080, 700);
        sh.setVisible(true);


        // Todo: I don't want it to exit on close!!!
        sh.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//        sh.setResizable(false);
        sh.setLocationRelativeTo(null);

    }

    private static void setLayout (StudyHelper sh){
        //style
        JLabel title = new JLabel("Good Good Study, Day Day Up", SwingConstants.CENTER);
        sh.clockLabel = new JLabel("Clock Area", SwingConstants.CENTER);
        sh.noticeLabel = new JLabel("Notice Area", SwingConstants.CENTER);

        Font font = title.getFont().deriveFont(32f);
        title.setFont(font);
        sh.clockLabel.setFont(font);
        sh.noticeLabel.setFont(font);

        sh.restButton = new JButton("Take a Break");
        sh.studyButton = new JButton("Good Good Study");
        sh.resetButton = new JButton("Reset Timer");

        Font buttonFount = sh.resetButton.getFont().deriveFont(28f);
        sh.restButton.setFont(buttonFount);
        sh.studyButton.setFont(buttonFount);
        sh.resetButton.setFont(buttonFount);

        //position
        sh.panelMain = new JPanel(new GridLayout(3,1,5,5));
        sh.panelMain.add(title);

        sh.clockPanel= new JPanel(new GridLayout(1,2));
        sh.clockPanel.add(sh.clockLabel);
        sh.clockPanel.add(sh.noticeLabel);
        sh.panelMain.add(sh.clockPanel);

        sh.buttonPanel= new JPanel(new GridLayout(1,3));
        sh.buttonPanel.add(sh.studyButton);
        sh.buttonPanel.add(sh.restButton);
        sh.buttonPanel.add(sh.resetButton);
        sh.panelMain.add(sh.buttonPanel);

        sh.setContentPane(sh.panelMain);

    }
    public StudyHelper() {


    }


}
