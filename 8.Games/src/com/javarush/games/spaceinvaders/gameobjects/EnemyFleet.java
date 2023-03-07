package com.javarush.games.spaceinvaders.gameobjects;

import com.javarush.engine.cell.Game;
import com.javarush.games.spaceinvaders.Direction;
import com.javarush.games.spaceinvaders.ShapeMatrix;
import com.javarush.games.spaceinvaders.SpaceInvadersGame;

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
        ships.add(new Boss(STEP * COLUMNS_COUNT / 2.0 - ShapeMatrix.BOSS_ANIMATION_FIRST.length / 2.0 - 1.0, 5.0));
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
        if (ships.isEmpty()) return;

        Direction currentDirection = direction;
        if (direction == Direction.LEFT && getLeftBorder() < 0) {
            direction = Direction.RIGHT;
            currentDirection = Direction.DOWN;
        }
        if (direction == Direction.RIGHT && getRightBorder() > SpaceInvadersGame.WIDTH) {
            direction = Direction.LEFT;
            currentDirection = Direction.DOWN;
        }
        for (EnemyShip ship : ships) {
            ship.move(currentDirection, getSpeed());
        }
    }
    public Bullet fire(Game game) {
        if (ships.isEmpty()) return null;
        int randomNum = game.getRandomNumber(100 / SpaceInvadersGame.COMPLEXITY);
        if (randomNum > 0) return null;
        int randomNum2 = game.getRandomNumber(ships.size());
        return ships.get(randomNum2).fire();
    }
    public int verifyHit(List<Bullet> bullets) {
        int sumScore = 0;
        if (bullets.isEmpty()) return 0;
        for (Bullet bullet : bullets) {
            for (EnemyShip ship : ships) {
                if (ship.isAlive && bullet.isAlive && ship.isCollision(bullet)) {
                    bullet.kill();
                    sumScore += ship.score;
                    ship.kill();
                }
            }
        }
        return sumScore;
    }
    public void deleteHiddenShips() {
        ships.removeIf(ship -> !ship.isVisible());
    }
    public double getBottomBorder() {
        double max = Double.MIN_VALUE;
        for (EnemyShip ship : ships) {
            double currentValue = ship.y + ship.height;
            if (currentValue > max) {
                max = currentValue;
            }
        }
        return max;
    }
    public int getShipsCount() {
        return ships.size();
    }

}
