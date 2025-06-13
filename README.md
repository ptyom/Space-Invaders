# 🕹️ Space Invaders on BBC micro:bit (MicroBlocks + NeoPixel)
# Created and developed by: Noor Ansari

Recreated a Space Invaders-style game on the BBC micro:bit using the MicroBlocks visual programming environment and an 8x8 NeoPixel LED grid.

> 🔗 [Watch Demo Video](https://go.screenpal.com/watch/cT1fcFn68oR)

---

## 🧠 Core Features

- Player-controlled movement using micro:bit buttons (A = left, B = right, A+B = shoot).
- Enemy AI that moves downward and side-to-side with timing and pattern control.
- Collision detection for bullet-enemy interactions.
- Score tracking to keep track of player's progression in the game.
- NeoPixel LED animations to show player (`blue`), enemy (`green`), and bullet (`red`).
- Game Over logic triggers when the enemy reaches the player's position.

---

## 📦 Languages & Technologies

Python (console simulation), Java (logic simulation), MicroBlocks, BBC micro:bit, NeoPixel (8x8 LED grid)

![MicroBlocks](https://img.shields.io/badge/-MicroBlocks-lightgrey?style=flat-square)
![Python](https://img.shields.io/badge/-Python-blue?logo=python&style=flat-square)
![Java](https://img.shields.io/badge/-Java-red?logo=java&style=flat-square)
![NeoPixel](https://img.shields.io/badge/-NeoPixel-orange?style=flat-square)
![BBC micro:bit](https://img.shields.io/badge/-micro%3Abit-black?style=flat-square)

---

## 🧱 Game Logic Overview

| Variable              | Description                                       |
|-----------------------|---------------------------------------------------|
| `player`              | X-position of the player on the bottom row (7)    |
| `enemyx` / `enemyy`   | X/Y position of the enemy                         |
| `bulletx` / `bullety` | X/Y position of the active bullet                 |
| `bullet.active`       | Boolean to track if a bullet is in flight         |
| `move_count`          | Tracks enemy movement pattern/timing              |

The game loop refreshes every 600ms. Each cycle:
- The enemy moves (random actions),
- The bullet (if fired) moves upward,
- Collision checks run,
- LED display is updated.

---

## 🖥 Alternate Implementations

This project was also ported to **Python** and **Java** to showcase logic portability and algorithmic thinking.

---

## 🧪 Unit Testing

Both Python and Java versions include unit tests that validate all core game logic.

### ✅ Test Coverage Includes:
- Initial player position
- Player movement (left/right constraints)
- Bullet logic and deactivation
- Bullet collision with enemy
- Game over trigger when enemy reaches the player

---

### 🔹 Python (Console Version)

The Python implementation (`space_invaders.py`) is structured as a `Game` class to facilitate testing with `unittest`.

Run the game:

```bash
python space_invaders.py
```

### 🔸 Java (Logic Simulation)

The Java implementation (`SpaceInvaders.java`) is organized into a modular `Game` class and includes test coverage using `JUnit 5`.

Run the game:

```bash
javac SpaceInvaders.java
java SpaceInvaders
```




