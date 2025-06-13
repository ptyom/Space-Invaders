#Noor Ansari

import random

WIDTH = 8
HEIGHT = 8

class Game:
    def __init__(self):
        self.player_x = 4
        self.enemy_x = random.randint(1, 5)
        self.enemy_y = 0
        self.bullet_x = 0
        self.bullet_y = 0
        self.bullet_active = False
        self.game_over = False

    def move_player_left(self):
        if self.player_x > 0:
            self.player_x -= 1

    def move_player_right(self):
        if self.player_x < WIDTH - 1:
            self.player_x += 1

    def fire_bullet(self):
        if not self.bullet_active:
            self.bullet_x = self.player_x
            self.bullet_y = 6
            self.bullet_active = True

    def update_bullet(self):
        if self.bullet_active:
            self.bullet_y -= 1
            if self.bullet_y < 0:
                self.bullet_active = False
            elif self.bullet_x == self.enemy_x and self.bullet_y == self.enemy_y:
                self.enemy_x = random.randint(1, 5)
                self.enemy_y = 0
                self.bullet_active = False

    def update_enemy(self):
        self.enemy_y += 1
        if self.enemy_y == 7 and self.enemy_x == self.player_x:
            self.game_over = True

    def get_state(self):
        return {
            "player": self.player_x,
            "enemy": (self.enemy_x, self.enemy_y),
            "bullet": (self.bullet_x, self.bullet_y),
            "bullet_active": self.bullet_active,
            "game_over": self.game_over
        }
