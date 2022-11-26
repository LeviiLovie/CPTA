import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Window extends JPanel {
    protected String appStatus;
    protected JPanel Menu;
    protected JPanel Game;
    private JButton buttonToGame;
    World worldNow;

    BufferedImage[] walls;
    BufferedImage floor;
    BufferedImage[] connectors;

    public Window() {
        appStatus = "game";

        walls = new BufferedImage[8];
        connectors = new BufferedImage[8];
        try {
            walls[0] = ImageIO.read(new File("source/walls/wall1.1.png"));
            walls[1] = ImageIO.read(new File("source/walls/wall1.2.png"));
            walls[2] = ImageIO.read(new File("source/walls/wall1.3.png"));
            walls[3] = ImageIO.read(new File("source/walls/wall1.4.png"));

            walls[4] = ImageIO.read(new File("source/walls/wall2.1.png"));
            walls[5] = ImageIO.read(new File("source/walls/wall2.2.png"));
            walls[6] = ImageIO.read(new File("source/walls/wall2.3.png"));
            walls[7] = ImageIO.read(new File("source/walls/wall2.4.png"));

            floor = ImageIO.read(new File("source/floors/floor2.png"));

            connectors[0] = ImageIO.read(new File("source/connectors/inputconvevoyer1.png"));
            connectors[1] = ImageIO.read(new File("source/connectors/inputconvevoyer2.png"));
            connectors[2] = ImageIO.read(new File("source/connectors/inputconvevoyer3.png"));
            connectors[3] = ImageIO.read(new File("source/connectors/inputconvevoyer4.png"));

            connectors[4] = ImageIO.read(new File("source/connectors/outputconvevoyer4.png"));
            connectors[5] = ImageIO.read(new File("source/connectors/outputconvevoyer2.png"));
            connectors[6] = ImageIO.read(new File("source/connectors/outputconvevoyer1.png"));
            connectors[7] = ImageIO.read(new File("source/connectors/outputconvevoyer3.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (appStatus == "game") {
            worldNow = new World(10, 10);
        }

        Menu = new JPanel();
        buttonToGame = new JButton("Game");
        buttonToGame.addActionListener(e -> {
            appStatus = "game";
            worldNow = new World(10, 10);
        });
        add(buttonToGame);
        Menu.add(buttonToGame);

        Game = new JPanel();

//        Timer timer;
//        timer = new Timer(0, e -> {
//            revalidate();
//            repaint();
//        });
//        timer.setRepeats(true);
//        // Aprox. 60 FPS
//        timer.setDelay(17);
//        timer.start();
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


            int tileSize = 48;
            for (int x = 0; x < worldNow.sizeX + 2; x++) {
                for (int y = 0; y < worldNow.sizeY + 2; y++) {
                    if (y == 0) {
                        if (x == 0) {
                            g2d.drawImage(walls[4], x * tileSize, y * tileSize, tileSize, tileSize, null);
                        }
                        else if (x == worldNow.sizeX + 1) {
                            g2d.drawImage(walls[5], x * tileSize, y * tileSize, tileSize, tileSize, null);
                        }
                        else {
                            g2d.drawImage(walls[0], x * tileSize, y * tileSize, tileSize, tileSize, null);
                        }
                    } else if (y == worldNow.sizeEY) {
                        if (x == 0) {
                            g2d.drawImage(walls[7], x * tileSize, y * tileSize, tileSize, tileSize, null);
                        }
                        else if (x == worldNow.sizeX + 1) {
                            g2d.drawImage(walls[6], x * tileSize, y * tileSize, tileSize, tileSize, null);
                        }
                        else {
                            g2d.drawImage(walls[2], x * tileSize, y * tileSize, tileSize, tileSize, null);
                        }
                    } else if (x == 0 || x == worldNow.sizeEX) {
                        if (x == 0) {
                            g2d.drawImage(walls[3], x * tileSize, y * tileSize, tileSize, tileSize, null);
                        } else if (x == worldNow.sizeX + 1) {
                            g2d.drawImage(walls[1], x * tileSize, y * tileSize, tileSize, tileSize, null);
                        }
                    } else {
                        g2d.drawImage(floor, x * tileSize, y * tileSize, tileSize, tileSize, null);
                    }
                    for (int i = 0; i < worldNow.inPutConveyorData.length; i++) {
                        if (worldNow.inPutConveyorData[i][0] == 0) {
                            g2d.drawImage(connectors[3], worldNow.inPutConveyorData[i][0] * tileSize, worldNow.inPutConveyorData[i][1] * tileSize, tileSize, tileSize, null);
                        } else if (worldNow.inPutConveyorData[i][0] == worldNow.sizeX + 1) {
                            g2d.drawImage(connectors[1], worldNow.inPutConveyorData[i][0] * tileSize, worldNow.inPutConveyorData[i][1] * tileSize, tileSize, tileSize, null);
                        } else if (worldNow.inPutConveyorData[i][1] == 0) {
                            g2d.drawImage(connectors[0], worldNow.inPutConveyorData[i][0] * tileSize, worldNow.inPutConveyorData[i][1] * tileSize, tileSize, tileSize, null);
                        } else if (worldNow.inPutConveyorData[i][1] == worldNow.sizeY + 1) {
                            g2d.drawImage(connectors[2], worldNow.inPutConveyorData[i][0] * tileSize, worldNow.inPutConveyorData[i][1] * tileSize, tileSize, tileSize, null);
                        }
                    }
                    for (int i = 0; i < worldNow.inPutConveyorData.length; i++) {
                        if (worldNow.outPutConveyorData[i][0] == 0) {
                            g2d.drawImage(connectors[4], worldNow.outPutConveyorData[i][0] * tileSize, worldNow.outPutConveyorData[i][1] * tileSize, tileSize, tileSize, null);
                        } else if (worldNow.outPutConveyorData[i][0] == worldNow.sizeX + 1) {
                            g2d.drawImage(connectors[5], worldNow.outPutConveyorData[i][0] * tileSize, worldNow.outPutConveyorData[i][1] * tileSize, tileSize, tileSize, null);
                        } else if (worldNow.outPutConveyorData[i][1] == 0) {
                            g2d.drawImage(connectors[6], worldNow.outPutConveyorData[i][0] * tileSize, worldNow.outPutConveyorData[i][1] * tileSize, tileSize, tileSize, null);
                        } else if (worldNow.outPutConveyorData[i][1] == worldNow.sizeY + 1) {
                            g2d.drawImage(connectors[7], worldNow.outPutConveyorData[i][0] * tileSize, worldNow.outPutConveyorData[i][1] * tileSize, tileSize, tileSize, null);
                        }
                    }
//                    g2d.drawImage(
//                            inPutConveyor,
//                            worldNow.inPutConveyorData[0] * tileSize,
//                            worldNow.inPutConveyorData[1] * tileSize,
//                            tileSize,
//                            tileSize,
//                            null
//                    );
//                    g2d.drawImage(
//                            outPutConveyor,
//                            worldNow.outPutConveyorData[0] * tileSize,
//                            worldNow.outPutConveyorData[1] * tileSize,
//                            tileSize,
//                            tileSize,
//                            null
//                    );

//                    if (y == 0 && (x != 0 && x != worldNow.sizeY)) {
//                        g2d.drawImage(walls[0], x * 32, y * 32, 32, 32, null);
//                    } else if (y == worldNow.sizeY && (x != 0 && x != worldNow.sizeY)) {
//                        g2d.drawImage(walls[2], x * 32, y * 32, 32, 32, null);
//                    } else if (x == 0 && (y != 0 && y != worldNow.sizeY)) {
//                        g2d.drawImage(walls[1], x * 32, y * 32, 32, 32, null);
//                    } else if (x == worldNow.sizeX && (y != 0 && y != worldNow.sizeY)) {
//                        g2d.drawImage(walls[1], x * 32, y * 32, 32, 32, null);
//                    }
//                    System.out.println(worldNow.sizeY + " - " + y + " | " + worldNow.sizeX + " - " + x);

//                    else if (x == (worldNow.sizeEX - 1) && (y != 0 && y != worldNow.sizeEY)) {
//                        g2d.drawImage(walls[2], y * 32, (x + 1) * 32, 32, 32, null);
//                    } else if (y == 0 && (x != 0 && x != worldNow.sizeEY)) {
//                        g2d.drawImage(walls[3], y * 32, x * 32, 32, 32, null);
////                    } else if (y == worldNow.sizeEY && (x != 0 && x != worldNow.sizeEX)) {
//                    } else if (y == (worldNow.sizeEY - 1)) {
//                        g2d.drawImage(walls[1], (y + 1) * 32, x * 32, 32, 32, null);
//                    }
//                    } else if (x == worldNow.sizeEX && (x != 0 && x != worldNow.sizeEY)) {
//                        System.out.println(x + " | " + y + " - " + "x");
//                        g2d.drawImage(walls[2], x * 32, y * 32, 32, 32, null);
//                    } else if (y == 0 && (x != 0 && x != worldNow.sizeEY)) {
//                        System.out.println(x + " | " + y + " - " + "4");
//                        g2d.drawImage(walls[4], x * 32, y * 32, 32, 32, null);
//                    } else if (y == worldNow.sizeEY && (x != 0 && x != worldNow.sizeEY)) {
//                        System.out.println(x + " | " + y + " - " + "1");
//                        g2d.drawImage(walls[1], x * 32, y * 32, 32, 32, null);
//                    }
//                    if (x == 0 && (y != 0 && y != worldNow.sizeX)) {
//                        g2d.drawImage(walls[0], y * 25, x * 25, 32, 32, null);
//                    } if (y == 0 && (x != 0 && y != worldNow.sizeX)) {
//                        g2d.drawImage(walls[0], y * 25, x * 25, 32, 32, null);
//                    } else if (y != 0 || y != worldNow.sizeY + 1 || x != 0 || x != worldNow.sizeX + 1) {
//                        g2d.setColor(Color.BLUE);
//                    } else {
//                        g2d.fillRect(x * 25, y * 25, 25, 25);
//                    }
                }
            }
        }
    }
}
