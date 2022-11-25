import javax.swing.*;
import java.awt.*;

public class Window extends JPanel {
    protected String appStatus;
    protected JPanel Menu;
    protected JPanel Game;
    private JButton buttonToGame;
    World worldNow;

    public Window() {
        appStatus = "menu";

        Menu = new JPanel();
        buttonToGame = new JButton("Game");
        buttonToGame.addActionListener(e -> {
            this.appStatus = "game";
            worldNow = new World(10, 10);
        });
        add(this.buttonToGame);
        Menu.add(buttonToGame);

        Game = new JPanel();

        Timer timer;
        timer = new Timer(0, e -> {
            revalidate();
            repaint();
        });
        timer.setRepeats(true);
        // Aprox. 60 FPS
        timer.setDelay(17);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        if (this.appStatus == "menu") {
            remove(Game);
            add(Menu);
        } else if (this.appStatus == "game") {
            remove(Menu);
            add(Game);

            for (int y = 0; y < worldNow.sizeY + 2; y++) {
                for (int x = 0; x < worldNow.sizeY + 2; x++) {
                    if (y == 0 || y == worldNow.sizeY + 1 || x == 0 || x == worldNow.sizeX + 1) {
                        g2d.setColor(Color.ORANGE);
                    } else {
                        g2d.setColor(Color.BLUE);
                    }
                    g2d.fillRect(x * 25, y * 25, 25, 25);
                }
            }
        }
    }
}
