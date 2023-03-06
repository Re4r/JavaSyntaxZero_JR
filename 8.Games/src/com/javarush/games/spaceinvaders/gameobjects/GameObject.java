package com.javarush.games.spaceinvaders.gameobjects;

import com.javarush.engine.cell.*;

public class GameObject {

    public double x;
    public double y;
    public int[][] matrix;
    public int width;
    public int height;

    public GameObject(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setMatrix(int[][] m) {
        matrix = m;
        width = matrix[0].length;
        height = matrix.length;
    }
    public void draw(Game game) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                game.setCellValueEx((int) (x + j), (int) (y + i), Color.values()[matrix[i][j]], "");
            }
        }
    }

}
