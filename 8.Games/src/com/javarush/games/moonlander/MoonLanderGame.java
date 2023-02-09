package com.javarush.games.moonlander;

import com.javarush.engine.cell.*;

public class MoonLanderGame extends Game {
    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;
    private Rocket rocket;
    private GameObject landscape;
    private boolean isUpPressed;
    private boolean isLeftPressed;
    private boolean isRightPressed;

    @Override
    public void initialize() {
        showGrid(false);
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }
    private void createGame() {
        createGameObjects();
        drawScene();
        setTurnTimer(50);
        isUpPressed = false;
        isLeftPressed = false;
        isRightPressed = false;
    }
    private void drawScene() {
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                setCellColor(x, y, Color.BLACK);
            }
        }
        landscape.draw(this);
        rocket.draw(this);
    }
    private void createGameObjects() {
        landscape = new GameObject(0, 25, ShapeMatrix.LANDSCAPE);
        rocket = new Rocket(WIDTH / 2, 0);
    }
    @Override
    public void onTurn(int step) {
        rocket.move();
        drawScene();
    }
    @Override
    public void setCellColor(int x, int y, Color color) {
        if (x > WIDTH - 1 || x < 0 || y < 0 || y > HEIGHT - 1) return;
        super.setCellColor(x, y, color);
    }
    @Override
    public void onKeyPress(Key key) {
        if (key == Key.UP) isUpPressed = true;
        if (key == Key.LEFT) {
            isLeftPressed = true;
            isRightPressed = false;
        }
        if (key == Key.RIGHT) {
            isRightPressed = true;
            isLeftPressed = false;
        }
    }
    @Override
    public void onKeyReleased(Key key) {
        if (key == Key.UP) isUpPressed = false;
        if (key == Key.LEFT) isLeftPressed = false;
        if (key == Key.RIGHT) isRightPressed = false;
    }
}

