import javax.swing.*;

public class exp_swing {
    public static void main(String[] args){
        JFrame frame=new JFrame("Swing Demo");

        JLabel label=new JLabel("Welcome to Java Swing!",JLabel.CENTER);

        frame.add(label);

        frame.setSize(350,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}