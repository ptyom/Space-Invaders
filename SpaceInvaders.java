int playerX = 4;
int enemyX = (int)(Math.random() * 5) + 1;
int enemyY = 0;
int bulletX = 0, bulletY = 0;
boolean bulletActive = false;

while (true) {
    drawPixel(playerX, 7, "blue");
    if (enemyY < 8) drawPixel(enemyX, enemyY, "green");
    if (bulletActive && bulletY >= 0) drawPixel(bulletX, bulletY, "red");

    // bullet
    if (bulletActive) {
        bulletY--;
        if (bulletY < 0) bulletActive = false;
        if (bulletX == enemyX && bulletY == enemyY) {
            // Hit enemy
            enemyX = (int)(Math.random() * 5) + 1;
            enemyY = 0;
            bulletActive = false;
        }
    }

    // enemy
    Thread.sleep(600);
    enemyY++;
    if (enemyY == 7 && enemyX == playerX) {
        System.out.println("GAME OVER");
        break;
    }

    if (!bulletActive) {
        bulletX = playerX;
        bulletY = 6;
        bulletActive = true;
    }
}
