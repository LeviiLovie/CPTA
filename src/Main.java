import javax.swing.*;

public class Main {
    public Main() {
        JFrame frame = new JFrame();
        frame.setTitle("CPTA - Crasy pasta of things assembling");
        frame.setSize(1280, 720 + 25);
        frame.setLocation(0, 0);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        frame.setLayout(null);
        frame.add(new Window());
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}