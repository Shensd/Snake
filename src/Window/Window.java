package Window;

import Constants.Constants;
import Controller.GraphicsController;
import Graphics.GraphicsPanel;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Window extends JFrame implements KeyListener{
    public Window() { init(); }

    private GraphicsController gc = GraphicsController.getInstance();
    private GraphicsPanel panel = gc.getPanel();
    private Constants c = Constants.getInstance();


    private void init() {
        int WIDTH = c.WIDTH;
        int HEIGHT = c.HEIGHT;

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setTitle("Jack Snake");
        setResizable(false);
        addKeyListener(this);
        add(panel);
        setLocationRelativeTo(null);

        pack();
        int trueW = WIDTH + getInsets().left + getInsets().right;
        int trueH = HEIGHT + getInsets().top + getInsets().bottom;
        setSize(trueW, trueH);

        setVisible(true);
    }

    //Key listeners
    @Override public void keyPressed(KeyEvent e) {
        int k = e.getKeyCode();
        if(k == KeyEvent.VK_W || k == KeyEvent.VK_UP) {
            if(gc.getDirection() != GraphicsController.DIRECTION_DOWN) {
                gc.setDirection(GraphicsController.DIRECTION_UP);
            }
        } else if(k == KeyEvent.VK_A || k == KeyEvent.VK_LEFT) {
            if(gc.getDirection() != GraphicsController.DIRECTION_RIGHT) {
                gc.setDirection(GraphicsController.DIRECTION_LEFT);
            }
        } else if(k == KeyEvent.VK_S || k == KeyEvent.VK_DOWN) {
            if(gc.getDirection() != GraphicsController.DIRECTION_UP) {
                gc.setDirection(GraphicsController.DIRECTION_DOWN);
            }
        } else if(k == KeyEvent.VK_D || k == KeyEvent.VK_RIGHT) {
            if(gc.getDirection() != GraphicsController.DIRECTION_LEFT) {
                gc.setDirection(GraphicsController.DIRECTION_RIGHT);
            }
        } else if(k == KeyEvent.VK_SPACE && c.getGameOver()) {
            gc.reset();
        }
    }
    @Override public void keyReleased(KeyEvent e) {}
    @Override public void keyTyped(KeyEvent e) {}
}
