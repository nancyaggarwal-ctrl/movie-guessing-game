## Overview

`MovieWordGuessGUI` is a Java-based graphical game that allows users to guess the name of a movie one letter at a time, similar to the classic "Hangman" game. The player starts with a set number of lifelines, and some letters are revealed automatically to make guessing easier. The game provides instant feedback for correct and incorrect guesses.

---

## Features

* Random movie selection from a predefined list.
* Automatic reveal of one-third of the letters at the start.
* Limited lifelines for wrong guesses.
* Visual feedback for correct ✅ and wrong ❌ guesses.
* Displays game status, remaining lifelines, and messages.
* Pop-up dialogs for **win** or **game over** conditions.
* Simple and intuitive **GUI** using Java Swing.

---

## Movie List

The game randomly selects from the following movies:
`DANGAL, SHOLAY, LAGAAN, BAHUBALI, KGF, ANDHADHUN, CHAKDEINDIA, DHURANDHAR, TAAREZAMEENPAR, 3IDIOTS, STRANGERTHINGS, INCEPTION, JOKER`

---

## Installation

### Requirements

* Java JDK 8 or higher
* Any IDE that supports Java (Eclipse, IntelliJ IDEA, VS Code, NetBeans)
* Alternatively, you can run via command line.

---

## How to Play

1. The program displays a partially revealed movie name.
2. Enter a single letter in the input field and click **Guess**.
3. If the letter is correct, it appears in its position(s) in the movie name.
4. If the letter is wrong, a lifeline is lost.
5. The game continues until:

   * You guess all letters correctly (**Win!**)
   * You run out of lifelines (**Game Over!**)

---

## GUI Components

* **Title Label**: Displays "Movie Word Guessing Game" at the top.
* **Word Label**: Shows the current state of the guessed movie.
* **Lifeline Label**: Displays remaining lifelines.
* **Input Field & Button**: Allows the player to enter guesses.
* **Message Label**: Shows messages like "Correct Guess!" or "Wrong Guess!".

---

## Code Highlights

* Uses **Java Swing** (`JFrame`, `JLabel`, `JTextField`, `JButton`) for GUI.
* Random movie selection with `java.util.Random`.
* Partial reveal of letters at the start (`Arrays.fill()` and random index selection).
* Real-time game feedback and message updates.
* Dialog boxes using `JOptionPane` for win/game over events.

---

## Future Improvements

* Add **categories** (e.g., Action, Comedy, Thriller) to choose from.
* Implement **hint system** for difficult movies.
* Add **score tracking** across multiple rounds.
* Improve GUI with colors and icons for a more engaging experience.
* Add keyboard input support for faster gameplay.
