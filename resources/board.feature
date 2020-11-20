Feature: TicTacToe
L’objectif est d’illustrer la lecture des données à partir des tables de données
Scenario: First move in an empty board
Given a board like this:
| | 1 | 2 | 3 |
| 1 | | | |
| 2 | | | |
| 3 | | | |
When player x plays in row 2, column 1
Then the board should look like this:
| | 1 | 2 | 3 |
| 1 | | | |
| 2 | x | | |
| 3 | | | |