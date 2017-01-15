package Game;

import java.util.Random;

public class Fruit {
    private static int[] position = {1, 1};
    private Random rand = new Random();
    public Fruit() {
        position[0] = rand.nextInt(40);
        position[1] = rand.nextInt(30);
    }
    public void randomPosition() {
        position[0] = rand.nextInt(40);
        position[1] = rand.nextInt(30);
    }
    public int[] getPosition() { return position; }
}
