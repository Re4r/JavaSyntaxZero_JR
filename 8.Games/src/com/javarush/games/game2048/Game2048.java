package com.javarush.games.game2048;

import com.javarush.engine.cell.*;

import java.util.Arrays;

public class Game2048 extends Game {
    private static final int SIDE = 4;
    private int[][] gameField = new int[SIDE][SIDE];
    private boolean isGameStopped = false;
    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
        drawScene();

    }

    private void createGame() {
        gameField = new int[SIDE][SIDE];
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
        if (getMaxTileValue() >= 2048) {
            win();
            return;
        }

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
    private  boolean mergeRow(int[] row) {
        boolean result = false;
        for (int i = 0; i < row.length - 1; i++) {
            if (row[i] != 0 && row[i] == row[i + 1]) {
                row[i] += row[i + 1];
                row[i + 1] = 0;
                result = true;
            }
        }
        return result;
    }
    @Override
    public void onKeyPress(Key key) {
        if (isGameStopped) {
            if (key == Key.SPACE) {
                isGameStopped = false;
                createGame();
                drawScene();
            } else {
                return;
            }
        }

        if (!canUserMove()) {
            gameOver();
            return;
        }
        if (key == Key.UP) {
            moveUp();
        } else if (key == Key.DOWN) {
            moveDown();
        } else if (key == Key.RIGHT) {
            moveRight();
        } else if (key == Key.LEFT) {
            moveLeft();
        } else {
            return;
        }
        drawScene();
    }
    private void moveLeft() {
        boolean isNewNumberNeeded = false;
        for (int[] row : gameField) {
            boolean wasCompressed = compressRow(row);
            boolean wasMerged = mergeRow(row);
            if (wasMerged) compressRow(row);
            if (wasCompressed || wasMerged) isNewNumberNeeded = true;
        }
        if (isNewNumberNeeded) createNewNumber();
    }
    private void moveRight() {
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();
    }
    private void moveUp() {
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();
    }
    private void moveDown() {
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
    }
    private void rotateClockwise() {
        int[][] result = new int[SIDE][SIDE];
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                result[j][SIDE - 1 - i] = gameField[i][j];
            }
        }
        gameField = result;
    }
    private int getMaxTileValue() {
        int max = gameField[0][0];
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                if (gameField[i][j] > max) {
                    max = gameField[i][j];
                }
            }
        }
        return max;
    }
    private void win() {
        isGameStopped = true;
        showMessageDialog(Color.BLACK, "YOU WIN", Color.WHITE, 50);
    }
    private void gameOver() {
        isGameStopped = true;
        showMessageDialog(Color.BLACK, "GAME OVER", Color.WHITE, 50);
    }
    private boolean canUserMove() {
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                if (gameField[i][j] == 0) {
                    return true;
                } else if (i < SIDE - 1 && gameField[i][j] == gameField[i + 1][j]) {
                    return true;
                } else if (j < SIDE - 1 && gameField[i][j] == gameField[i][j + 1]) {
                    return true;
                }
                }
            }
        return false;
        }

    }


