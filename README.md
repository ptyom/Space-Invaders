# 🕹️ Space Invaders on BBC micro:bit (MicroBlocks + NeoPixel)

Recreated a Space Invaders-style game on the BBC micro:bit using the MicroBlocks visual programming environment and an 8x8 NeoPixel LED grid.

> 🔗 [Watch Demo Video](https://go.screenpal.com/watch/cT1fcFn68oR)

## 🧠 Core Features

- **Player-controlled movement** using micro:bit buttons (A = left, B = right, A+B = shoot).
- **Enemy AI** that moves downward and side-to-side with timing and pattern control.
- **Collision detection** for bullet-enemy interactions.
- **Score Tracking** to keep track of player's progression in the game.
- **NeoPixel LED animations** to show player (blue), enemy (green), and bullet (red).
- **Game Over logic** triggers when the enemy reaches the player's row.

## 📦 Languages & Technologies

- MicroBlocks (visual programming)
- BBC micro:bit
- NeoPixel (8x8 LED grid)
- Python (console simulation)
- Java (logic simulation)

## 🧱 Game Logic Overview

| Variable             | Description                                        |
|----------------------|----------------------------------------------------|
| `player`             | X-position of the player on the bottom row (7)     |
| `enemyx` / `enemyy`  | X/Y position of the enemy                          |
| `bulletx` / `bullety`| X/Y position of the active bullet                  |
| `bullet.active`      | Boolean to track if a bullet is in flight          |
| `move_count`         | Tracks enemy movement pattern/timing               |

The game loop refreshes every 600ms. Each cycle:
- The enemy moves (random actions),
- The bullet (if fired) moves upward,
- Collision checks run,
- LED display is updated.

## 🖥 Alternate Implementations

This project was also ported to Python and Java to showcase logic portability and algorithmic thinking.

### 🔹 Python (Console Version)
```bash
python space_invaders.py

### 🔸 Java (Logic Simulation)
javac SpaceInvaders.java
java SpaceInvaders


