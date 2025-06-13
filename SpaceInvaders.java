// Noor Ansari

import java.util.Random;

public class SpaceInvaders {
    private int playerX = 4;
    private int enemyX = randomX();
    private int enemyY = 0;
    private int bulletX = 0, bulletY = 0;
    private boolean bulletActive = false;
    private boolean gameOver = false;

    private static int randomX() {
        return new Random().nextInt(5) + 1;
    }

    public int getPlayerX() { return playerX; }
    public int getEnemyX() { return enemyX; }
    public int getEnemyY() { return enemyY; }
    public int getBulletX() { return bulletX; }
    public int getBulletY() { return bulletY; }
    public boolean isBulletActive() { return bulletActive; }
    public boolean isGameOver() { return gameOver; }

    public void movePlayerLeft() {
        if (playerX > 0) playerX--;
    }

    public void movePlayerRight() {
        if (playerX < 7) playerX++;
    }

    public void fireBullet() {
        if (!bulletActive) {
            bulletX = playerX;
            bulletY = 6;
            bulletActive = true;
        }
    }

    public void updateBullet() {
        if (bulletActive) {
            bulletY--;
            if (bulletY < 0) {
                bulletActive = false;
            } else if (bulletX == enemyX && bulletY == enemyY) {
                // hit
                enemyX = randomX();
                enemyY = 0;
                bulletActive = false;
            }
        }
    }

    public void updateEnemy() {
        enemyY++;
        if (enemyY == 7 && enemyX == playerX) {
            gameOver = true;
        }
    }
}
