package Controller;

import Constants.Constants;
import Game.Fruit;
import Game.Snake;
import Graphics.GraphicsPanel;
import Main.Main;
import Window.Window;

import java.util.List;

public class GraphicsController {

    private static GraphicsController INSTANCE = new GraphicsController();
    private GraphicsController() {}
    public static GraphicsController getInstance() { return INSTANCE; }

    private static GraphicsPanel panel = GraphicsPanel.getInstance();

    private Window win;
    private Snake player = new Snake();
    private Fruit fruit = new Fruit();

    public static final int DIRECTION_UP = 0;
    public static final int DIRECTION_DOWN = 1;
    public static final int DIRECTION_LEFT = 2;
    public static final int DIRECTION_RIGHT = 3;
    private static int lastDirection = DIRECTION_UP;

    //return methods
    public GraphicsPanel getPanel() { return panel; }
    public List<int[]> getPlayerPositions() { return player.getPositions(); }
    public int[] getFruitPosition() { return fruit.getPosition(); }

    public void createWindow() { win = new Window(); }

    private Constants c = Constants.getInstance();

    public boolean updateScreen() {
        if(player.checkDeath()) {
            panel.drawGameOver();
            panel.repaint();
            c.setGameOver(true);
            return true;
        }
        panel.repaint();
        panel.draw();

        if(player.getPositions().get(0)[0] == fruit.getPosition()[0]
                && player.getPositions().get(0)[1] == fruit.getPosition()[1]) {
            fruit.randomPosition();
            while(true) {
                boolean moved = false;
                int x = getFruitPosition()[0], y = getFruitPosition()[1];
                for(int[] b : player.getPositions()) {
                    if(x == b[0] && y == b[1]) {
                        fruit.randomPosition();
                        moved = true;
                        break;
                    }
                }
                if(!moved) { break; }
            }
            player.increaseLen();
        }
        return true;
    }

    public void reset() {
        fruit.randomPosition();
        player.reset();
        lastDirection = DIRECTION_UP;
        c.setGameOver(false);
    }

    public void updatePlayer() { player.update(lastDirection); }

    public void setDirection(int direction) { lastDirection = direction; }
    public int getDirection() { return lastDirection; }
}
