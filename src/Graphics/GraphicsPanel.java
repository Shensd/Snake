package Graphics;

import Constants.Constants;
import Controller.GraphicsController;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GraphicsPanel extends JPanel {

    private Constants c = Constants.getInstance();

    private int HEIGHT = c.HEIGHT;
    private int WIDTH = c.WIDTH;

    private GraphicsController gc = GraphicsController.getInstance();

    private final int BOX_SIZE = 16;

    private BufferedImage img = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);

    private static final GraphicsPanel INSTANCE = new GraphicsPanel();
    public static GraphicsPanel getInstance() { return INSTANCE; }

    private GraphicsPanel() { setPreferredSize(new Dimension(WIDTH, HEIGHT)); }

    private void clearIMG() {
        Graphics g = img.getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, img.getWidth(), img.getHeight());
        g.dispose();
    }

    public void drawGameOver() {
        Graphics g = img.getGraphics();
        g.setColor(Color.BLACK);
        g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 32));
        g.drawString("GAME OVER", 230, 235);
        g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 16));
        g.drawString("Press space to restart", 210, 260);
        g.dispose();
    }

    public void draw() {
        Graphics g = img.getGraphics();
        //player
        for(int[] p : gc.getPlayerPositions()) {
            int x = p[0]*BOX_SIZE, y = p[1]*BOX_SIZE;
            g.setColor(Color.BLACK);
            g.fillRect(x, y, BOX_SIZE, BOX_SIZE);
            g.setColor(Color.LIGHT_GRAY);
            g.drawRect(x, y, BOX_SIZE, BOX_SIZE);
        }
        //fruit
        g.setColor(Color.DARK_GRAY);
        int[] pos = gc.getFruitPosition();
        g.fillRect(pos[0]*BOX_SIZE, pos[1]*BOX_SIZE, BOX_SIZE, BOX_SIZE);
        g.dispose();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(img, 0, 0, null);
        this.clearIMG();
        g2d.dispose();
    }

}
