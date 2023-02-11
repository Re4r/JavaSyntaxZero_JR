package com.javarush.games.racer;

import com.javarush.engine.cell.*;

public class RacerGame extends Game {
    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;
    public static final int CENTER_X = WIDTH / 2;
    public static final int ROADSIDE_WIDTH = 14;


    @Override
    public void initialize() {
        showGrid(false);
        setScreenSize(WIDTH, HEIGHT);
        drawScene();
        createGame();
    }

    private void createGame() {
        drawScene();
    }
    private void drawScene() {
        drawField();
    }
    private void drawField() {
        // Разделительная полоса
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                if (x == CENTER_X) {
                    setCellColor(x, y, Color.WHITE);
                }
            }
        }
        // Дорожное полотно
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                if (x >= ROADSIDE_WIDTH && x < WIDTH - ROADSIDE_WIDTH) {
                    setCellColor(x, y, Color.DIMGREY);
                }
            }
        }

        // Обочина
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                if (x >= 0 && x < ROADSIDE_WIDTH) {
                    setCellColor(x, y, Color.GREEN);
                }
                if (x >= WIDTH - ROADSIDE_WIDTH && x <= WIDTH) {
                    setCellColor(x, y, Color.GREEN);
                }
            }
        }
    }
}
