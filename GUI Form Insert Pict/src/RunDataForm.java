import javax.swing.*;

public class RunDataForm {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Data");
        jFrame.setContentPane(new DataForm().getRootP());
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(600,400);
        jFrame.setVisible(true);
    }
}