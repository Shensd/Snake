package Game;

import Controller.GraphicsController;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private List<int[]> body = new ArrayList<>();
    public Snake() {
        body.add(new int[]{20, 15});
        body.add(new int[]{20, 16});
        body.add(new int[]{20, 17});
        body.add(new int[]{20, 18});
    }
    public boolean checkDeath() {
        int ind = 0;
        int x = body.get(0)[0], y = body.get(0)[1];
        for(int[] b : body) {
            if(x == b[0] && y == b[1] && ind > 0) {
                return true;
            }
            ind++;
        }
        return (x < 0 || x > 39 || y < 0 || y > 29);
    }

    public boolean checkWin() {
        return (body.size() == 1199);
    }

    public void update(int direction) {
        for(int i = body.size() - 1; i > 0; i--) {
            body.set(i, body.get(i - 1));
        }
        switch(direction) {
            case GraphicsController.DIRECTION_UP:
                body.set(0, new int[]{body.get(1)[0], body.get(1)[1] - 1});
                break;
            case GraphicsController.DIRECTION_DOWN:
                body.set(0, new int[]{body.get(1)[0], body.get(1)[1] + 1});
                break;
            case GraphicsController.DIRECTION_LEFT:
                body.set(0, new int[]{body.get(1)[0] - 1, body.get(1)[1]});
                break;
            case GraphicsController.DIRECTION_RIGHT:
                body.set(0, new int[]{body.get(1)[0] + 1, body.get(1)[1]});
                break;
        }
    }

    public void reset() {
        body.clear();
        body.add(new int[]{20, 15});
        body.add(new int[]{20, 16});
        body.add(new int[]{20, 17});
        body.add(new int[]{20, 18});
    }

    public List<int[]> getPositions() { return body; }
    public void increaseLen() { body.add(body.get(body.size() - 1)); }
}
