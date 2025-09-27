# Tic Tac Toe Game

## Overview

This Tic Tac Toe project is a flexible and interactive game that supports multiple board sizes, bot difficulty levels, and global undo functionality. The design follows **Builder** and **Factory** patterns for clean and scalable architecture.

## Features

* Dynamic board size based on user input.
* Bot with difficulty levels: Easy, Medium, Hard.
* Maximum number of players (including bot) = `board dimension - 1`.
* Global undo functionality to revert the last move.
* Clear separation of concerns using Java classes.

## Project Structure

```
Board.java
Bot.java
BotDifficultyLevel.java
Cell.java
CellState.java
Game.java
GameStatus.java
Move.java
Player.java
PlayerType.java
Symbol.java
```

### Class Descriptions

* **Board.java**: Represents the game board and contains methods to place symbols, check for winners, and manage cells.
* **Bot.java**: Handles bot moves based on selected difficulty.
* **BotDifficultyLevel.java**: Enum for bot difficulty levels (EASY, MEDIUM, HARD).
* **Cell.java**: Represents a single cell on the board.
* **CellState.java**: Enum representing the state of a cell (EMPTY, X, O, etc.).
* **Game.java**: Controls the game flow, including turns, move validation, and undo functionality.
* **GameStatus.java**: Enum representing game status (IN_PROGRESS, DRAW, WIN).
* **Move.java**: Represents a move made by a player.
* **Player.java**: Represents a player, human or bot.
* **PlayerType.java**: Enum representing type of player (HUMAN, BOT).
* **Symbol.java**: Enum representing player symbols (X, O, etc.).

## Design Patterns

* **Builder Pattern**: Used to construct the `Game` and `Board` objects with flexible configuration.
* **Factory Pattern**: Used to create different types of players (`Bot` or `Human`) based on user input.

## Additional Functionality

* **Global Undo**: Allows players to undo the last move globally, reverting the board state.

## Class Diagram

```plaintext
         +----------------+
         |      Game       |
         +----------------+
         | -board: Board   |
         | -players: List  |
         | -moves: Stack   |
         +----------------+
         | +start()        |
         | +playMove()     |
         | +undoMove()     |
         +----------------+
                 |
                 |
        +--------+--------+
        |                 |
   +---------+       +----------+
   |  Player |       |   Bot    |
   +---------+       +----------+
   | -name   |       | -level   |
   | -type   |       +----------+
   | -symbol |       | +makeMove()|
   +---------+       +----------+
         |
         |
   +----------------+
   |   Board        |
   +----------------+
   | -cells: Cell[][]|
   | -dimension      |
   +----------------+
   | +placeSymbol()  |
   | +checkWin()     |
   | +undo()         |
   +----------------+
         |
   +-----+-----+
   |           |
+------+   +--------+
| Cell |   | CellState|
+------+   +--------+
| -state|   | EMPTY   |
| -row  |   | X       |
| -col  |   | O       |
+------+   +--------+
```

## How to Run

1. Clone the repository.
2. Compile all Java files.
3. Run `Game.java`.
4. Follow on-screen instructions to select board size, number of players, and bot difficulty.

## Future Enhancements

* Add networked multiplayer mode.
* Implement AI with Minimax algorithm for unbeatable bot.
* Add GUI for a better user experience.
