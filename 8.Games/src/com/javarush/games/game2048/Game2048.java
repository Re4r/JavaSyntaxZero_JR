package com.javarush.games.game2048;

import com.javarush.engine.cell.*;

import java.util.Arrays;

public class Game2048 extends Game {
    private static final int SIDE = 4;
    private int[][] gameField = new int[SIDE][SIDE];
    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
        drawScene();

    }

    private void createGame() {
        createNewNumber();
        createNewNumber();
    }
    private void drawScene() {
        for (int x = 0; x < gameField.length; x++) {
            for (int y = 0; y < gameField[x].length; y++) {
                setCellColor(x, y, Color.RED);
            }
        }
    }
    private void createNewNumber() {
        boolean isCreated = false;
        do {
            int x = getRandomNumber(SIDE);
            int y = getRandomNumber(SIDE);
            if (gameField[x][y] == 0) {
                gameField[x][y] = (getRandomNumber(10) < 9) ? 2 : 4;
                isCreated = true;
            }
        } while (!isCreated);
    }

}
