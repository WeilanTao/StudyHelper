import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudyHelper extends JFrame{
    private JPanel panelMain;
    private JButton startStudyButton;
    private JButton resetButton;

    public static void main(String[] args) {
        StudyHelper sh = new StudyHelper();
        sh.setContentPane(sh.panelMain);
        sh.setTitle("Study Helper");
        sh.setSize(1080, 700);
        sh.setVisible(true);

        // Todo: I don't want it to exit on close!!!
        sh.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        sh.setResizable(false);
        sh.setLocationRelativeTo(null);

    }
    public StudyHelper() {
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
