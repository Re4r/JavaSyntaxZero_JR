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
        for (int x = 0; x < SIDE; x++) {
            for (int y = 0; y < SIDE; y++) {
                setCellColoredNumber(x, y, gameField[y][x]);
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
    private Color getColorByValue(int value) {
        switch (value) {
            case 0: return Color.WHITE;
            case 2: return Color.PLUM;
            case 4: return Color.SLATEBLUE;
            case 8: return Color.DODGERBLUE;
            case 16: return Color.DARKTURQUOISE;
            case 32: return Color.MEDIUMSEAGREEN;
            case 64: return Color.LIMEGREEN;
            case 128: return Color.DARKORANGE;
            case 256: return Color.SALMON;
            case 512: return Color.ORANGERED;
            case 1024: return Color.DEEPPINK;
            case 2048: return Color.MEDIUMVIOLETRED;
            default: return Color.NONE;
        }
    }
    private void setCellColoredNumber(int x, int y, int value) {
        Color color = getColorByValue(value);
        String str = value > 0 ? "" + value : "";
        setCellValueEx(x, y, color, str);

    }
    private boolean compressRow(int[] row) {
        int insertPosition = 0;
        boolean result = false;
        for (int x = 0; x < SIDE; x++) {
            if (row[x] > 0) {
                if (x != insertPosition) {
                    row[insertPosition] = row[x];
                    row[x] = 0;
                    result = true;
                }
                insertPosition++;
            }
        }
        return result;
    }

}
