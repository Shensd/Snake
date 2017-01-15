package Constants;

public class Constants {

    private static Constants INSTANCE = new Constants();
    private Constants() {}
    public static Constants getInstance() { return INSTANCE; }

    public final int HEIGHT = 480;
    public final int WIDTH = 640;

    private boolean quitGame = false;
    public void setGameOver(boolean state) { quitGame = state; }
    public boolean getGameOver() { return quitGame; }
}
