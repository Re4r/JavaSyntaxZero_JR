package com.javarush.games.spaceinvaders.gameobjects;

import com.javarush.engine.cell.Game;
import com.javarush.games.spaceinvaders.Direction;
import com.javarush.games.spaceinvaders.ShapeMatrix;

import java.util.ArrayList;
import java.util.List;

public class EnemyFleet {
    private static final int ROWS_COUNT = 3;
    private static final int COLUMNS_COUNT = 10;
    private static final int STEP = ShapeMatrix.ENEMY.length + 1;
    private List<EnemyShip> ships;
    private Direction direction = Direction.RIGHT;

    public EnemyFleet() {
        createShips();
    }

    private void createShips() {
        ships = new ArrayList<>();
        for (int y = 0; y < ROWS_COUNT; y++) {
            for (int x = 0; x < COLUMNS_COUNT; x++) {
                ships.add(new EnemyShip(x * STEP, y * STEP + 12));
            }
        }
    }
    public void draw(Game game) {
        for (EnemyShip ship : ships) {
            ship.draw(game);
        }
    }
    private double getLeftBorder() {
        double min = Double.MAX_VALUE;
        for (EnemyShip ship : ships) {
            if (ship.x < min) min = ship.x;
        }
        return min;
    }
    private double getRightBorder() {
        double max = Double.MIN_VALUE;
        for (EnemyShip ship : ships) {
            if ((ship.x + ship.width) > max) max = ship.x + ship.width;
        }
        return max;
    }
    private double getSpeed() {
        return Double.min(2.0, (3.0 / ships.size()));
    }
    public void move() {

    }

}
