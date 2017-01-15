package Main;

import Constants.Constants;
import Controller.GraphicsController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    private GraphicsController gc = GraphicsController.getInstance();
    private Constants c = Constants.getInstance();

    public static void main(String[] args) {
        Main m = new Main();
        m.init();
    }
    private void init() {
        gc.createWindow();
        gameLoop();
    }

    private Timer graphics = new Timer(1, (ActionEvent e) -> {
        if(c.getGameOver()) {return;}
        try {
            while(true) {
                if(gc.updateScreen()) { break; }
            }
        } catch(Exception ex) {ex.printStackTrace();}
    });

    private Timer game = new Timer(150, (ActionEvent e) -> {
        if(c.getGameOver()) { return; }
        gc.updatePlayer();
    });

    private void gameLoop() {
        game.start();
        graphics.start();
    }
}
