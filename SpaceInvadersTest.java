// Noor Ansari

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SpaceInvadersTest {
    SpaceInvaders game;

    @BeforeEach
    void setup() {
        game = new SpaceInvaders();
    }

    @Test
    void testInitialPlayerPosition() {
        assertEquals(4, game.getPlayerX());
    }

    @Test
    void testMoveLeft() {
        game.movePlayerLeft();
        assertEquals(3, game.getPlayerX());
    }

    @Test
    void testMoveRight() {
        game.movePlayerRight();
        assertEquals(5, game.getPlayerX());
    }

    @Test
    void testFireBullet() {
        game.fireBullet();
        assertTrue(game.isBulletActive());
        assertEquals(game.getPlayerX(), game.getBulletX());
        assertEquals(6, game.getBulletY());
    }

    @Test
    void testBulletMovesUp() {
        game.fireBullet();
        int startY = game.getBulletY();
        game.updateBullet();
        assertEquals(startY - 1, game.getBulletY());
    }

    @Test
    void testBulletDeactivatesOffscreen() {
        game.fireBullet();
        for (int i = 0; i < 10; i++) {
            game.updateBullet();
        }
        assertFalse(game.isBulletActive());
    }

    @Test
    void testBulletHitsEnemy() {
        game.fireBullet();
        game.updateBullet(); // bulletY = 5
        game.updateBullet(); // bulletY = 4
        game.updateBullet(); // etc.

        // manual
        game.fireBullet();
        game.updateBullet();
        game.updateBullet();
        game.updateBullet();
        game.updateBullet();
        game.updateBullet();

        game.fireBullet();
        game.updateBullet();

        // set manually to hit
        game.fireBullet();
        game.updateBullet();
        game.updateBullet();
        game.updateBullet();
        game.updateBullet();
        game.updateBullet();
        game.updateBullet();
    }

    @Test
    void testEnemyReachesPlayer() {
        while (!game.isGameOver()) {
            game.updateEnemy();
            if (game.getEnemyY() == 7 && game.getEnemyX() == game.getPlayerX()) {
                break;
            }
        }
        assertTrue(game.isGameOver());
    }
}
