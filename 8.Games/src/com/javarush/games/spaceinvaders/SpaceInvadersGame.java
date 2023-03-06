package com.javarush.games.spaceinvaders;

import com.javarush.engine.cell.*;
import com.javarush.games.spaceinvaders.gameobjects.Star;

import java.util.ArrayList;
import java.util.List;

public class SpaceInvadersGame extends Game {
    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;
    private List<Star> stars;

    @Override
    public void initialize() {
        showGrid(false);
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }
    private void createGame() {
        createStars();
        drawScene();
    }
    private void drawScene() {
        drawField();
    }
    private void drawField() {
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                setCellValueEx(x, y, Color.BLACK, "");
            }
        }
        for (Star star : stars) {
            star.draw(this);
        }
    }
    private void createStars() {
       stars = new ArrayList<>();
       for (int i = 0; i < 8; i++) {
           int x = getRandomNumber(1, WIDTH);
           int y = getRandomNumber(1, HEIGHT);
           stars.add(new Star(x, y));
       }
    }

}
