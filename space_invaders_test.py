# Noor Ansari

import unittest
from space_invaders import Game

class TestSpaceInvaders(unittest.TestCase):

    def setUp(self):
        self.game = Game()

    def test_player_movement_left_right(self):
        original = self.game.player_x
        self.game.move_player_left()
        self.assertEqual(self.game.player_x, max(0, original - 1))
        self.game.move_player_right()
        self.assertEqual(self.game.player_x, min(7, original))

    def test_fire_bullet(self):
        self.game.fire_bullet()
        self.assertTrue(self.game.bullet_active)
        self.assertEqual(self.game.bullet_y, 6)
        self.assertEqual(self.game.bullet_x, self.game.player_x)

    def test_bullet_moves_up(self):
        self.game.fire_bullet()
        start_y = self.game.bullet_y
        self.game.update_bullet()
        self.assertEqual(self.game.bullet_y, start_y - 1)

    def test_bullet_deactivates_off_screen(self):
        self.game.fire_bullet()
        self.game.bullet_y = 0
        self.game.update_bullet()
        self.assertFalse(self.game.bullet_active)

    def test_bullet_hits_enemy(self):
        self.game.fire_bullet()
        self.game.bullet_x = self.game.enemy_x
        self.game.bullet_y = self.game.enemy_y + 1
        self.game.update_bullet()
        self.assertFalse(self.game.bullet_active)
        self.assertEqual(self.game.enemy_y, 0)

    def test_enemy_reaches_player(self):
        self.game.enemy_y = 6
        self.game.enemy_x = self.game.player_x
        self.game.update_enemy()
        self.assertTrue(self.game.game_over)

if __name__ == '__main__':
    unittest.main()
