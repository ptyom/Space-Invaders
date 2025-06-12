import time
import random

WIDTH = 8
HEIGHT = 8

player_x = 4
enemy_x = random.randint(1, 5)
enemy_y = 0
bullet_x = 0
bullet_y = 0
bullet_active = False

while True:
    screen = [[' ' for _ in range(WIDTH)] for _ in range(HEIGHT)]
    screen[7][player_x] = 'P'  # Player
    if 0 <= enemy_y < HEIGHT:
        screen[enemy_y][enemy_x] = 'E'
    if bullet_active and 0 <= bullet_y < HEIGHT:
        screen[bullet_y][bullet_x] = '^'
    for row in screen:
        print(''.join(row))
    print('-' * 10)

    # Bullet logic
    if bullet_active:
        bullet_y -= 1
        if bullet_y < 0:
            bullet_active = False
        elif bullet_x == enemy_x and bullet_y == enemy_y:
            # hit
            enemy_x = random.randint(1, 5)
            enemy_y = 0
            bullet_active = False

    # Enemy 
    time.sleep(0.6)
    enemy_y += 1
    if enemy_y == 7 and enemy_x == player_x:
        print("GAME OVER")
        break

    if not bullet_active and random.random() < 0.3:
        bullet_x = player_x
        bullet_y = 6
        bullet_active = True
    move = random.choice(['left', 'right', 'stay'])
    if move == 'left' and player_x > 0:
        player_x -= 1
    elif move == 'right' and player_x < WIDTH - 1:
        player_x += 1
