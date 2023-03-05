package com.javarush.games.minigames.mini08;

import com.javarush.engine.cell.*;

/* 
Работа с клавиатурой
*/

public class KeyboardGame extends Game {

    @Override
    public void initialize() {
        setScreenSize(3, 3);

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                setCellColor(x, y, Color.WHITE);
            }
        }
    }

    @Override
    public void onKeyPress(Key key) {
        if (key == Key.LEFT) {
            int x = 0;
            for (int y = 0; y < 3; y++) {
                setCellColor(x, y, Color.GREEN);
            }
        }
        if (key == Key.RIGHT) {
            int x = 2;
            for (int y = 0; y < 3; y++) {
                setCellColor(x, y, Color.GREEN);
            }
        }
        if (key == Key.UP) {
            int y = 0;
            for (int x = 0; x < 3; x++) {
                setCellColor(x, y, Color.GREEN);
            }
        }
        if (key == Key.DOWN) {
            int y = 2;
            for (int x = 0; x < 3; x++) {
                setCellColor(x, y, Color.GREEN);
            }
        }
    }

    @Override
    public void onKeyReleased(Key key) {
        if (key == Key.LEFT) {
            int x = 0;
            for (int y = 0; y < 3; y++) {
                setCellColor(x, y, Color.WHITE);
            }
        }
        if (key == Key.RIGHT) {
            int x = 2;
            for (int y = 0; y < 3; y++) {
                setCellColor(x, y, Color.WHITE);
            }
        }
        if (key == Key.UP) {
            int y = 0;
            for (int x = 0; x < 3; x++) {
                setCellColor(x, y, Color.WHITE);
            }
        }
        if (key == Key.DOWN) {
            int y = 2;
            for (int x = 0; x < 3; x++) {
                setCellColor(x, y, Color.WHITE);
            }
        }
    }
}
