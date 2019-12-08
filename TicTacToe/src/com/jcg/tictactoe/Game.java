package com.jcg.tictactoe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {

    private int SIZE = 4;
    private final String FILLER = " ";
    private String[][] positions;
    private Player[] players =
            {new Player("Computer1", "X"), new Player("Computer2", "O")};
    private Player currPlayer = null;

    public Game(String player, int grid) {
        SIZE = grid == 0 ? 3 : grid;
        positions = new String[SIZE][SIZE];
        players[0] = new Player(player, "X");
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                positions[i][j] = FILLER;
            }
        }
        currPlayer = players[0];
    }

    public Game(String player1, String player2, int grid) {
        this(player1, grid);
        players[1] = new Player(player2, "O");
        playMove();
    }

    private void playMove() {
        if (!currPlayer.isComputer() || isGameOver()) {
            return;
        }

        Player computer = currPlayer;
        List<Move> moves = new ArrayList<>();

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (positions[i][j].equals(FILLER)) {
                    positions[i][j] = computer.getSymbol();
                    List<Score> scores = new ArrayList<>();
                    miniMax(scores);
                    Move move = new Move(i, j, scores);
                    moves.add(move);
//                    System.out.println(move.toString());
                    positions[i][j] = FILLER;
                    currPlayer = computer;
                }
            }
        }
        currPlayer = computer;
        Collections.sort(moves);
        updatePlayerMove(moves.get(0).getRow(), moves.get(0).getColumn());

    }

    private void miniMax(List<Score> scoreList) {
        Player winner = getWinner();
        if (currPlayer.equals(winner)) {
            if (currPlayer.isComputer()) {
                scoreList.add(new Score(true, false));
            } else
                scoreList.add(new Score(false, false));
        }
        if (isNoMovesLeft())
            scoreList.add(new Score(false, true));
        changePlayer();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (positions[i][j].equals(FILLER)) {
                    positions[i][j] = currPlayer.getSymbol();
                    miniMax(scoreList);
                    positions[i][j] = FILLER;

                }
            }
        }
    }

    private boolean isNoMovesLeft() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (positions[i][j].equals(FILLER)) {
                    return false;
                }
            }
        }
        return true;
    }


    public void move(int xPosition, int yPosition) {
        if (isGameOver())
            return;
        if (xPosition >= SIZE || yPosition >= SIZE || xPosition < 0 || yPosition < 0)
            return;
        if (!positions[xPosition][yPosition].equals(FILLER))
            return;
        updatePlayerMove(xPosition, yPosition);
        playMove();
    }

    private void updatePlayerMove(int xPosition, int yPosition) {
        positions[xPosition][yPosition] = currPlayer.getSymbol();
        changePlayer();
    }

    private void changePlayer() {
        currPlayer = currPlayer.equals(players[1]) ? players[0] : players[1];
    }

    public void printBoard() {
        String header = "  ";
        for (int j = 0; j < SIZE; j++) {
            header += "|" + (j + 1);
        }
        System.out.println(header);
        for (int j = 0; j < SIZE * 3; j++) {
            System.out.print("_");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            String row = (i + 1) + " ";
            for (int j = 0; j < SIZE; j++) {
                row += "|" + positions[i][j];
            }
            System.out.println(row);
            for (int j = 0; j < SIZE * 3; j++) {
                System.out.print("_");
            }
            System.out.println();
        }
        System.out.println(currPlayer.getName() + " Turn now");
    }

    public boolean isGameOver() {
        return getWinner() != null || isNoMovesLeft();
    }

    private String rowCrossed() {
        for (int i = 0; i < SIZE; i++) {
            String check = positions[i][0];
            for (int j = 1; j < SIZE; j++) {
                if (!check.equals(positions[i][j])) {
                    check = FILLER;
                    break;
                }
            }
            if (!check.equals(FILLER)) {
                return check;
            }
        }
        return FILLER;
    }

    private String columnCrossed() {
        for (int i = 0; i < SIZE; i++) {
            String check = positions[0][i];
            for (int j = 1; j < SIZE; j++) {
                if (!check.equals(positions[j][i])) {
                    check = FILLER;
                    break;
                }
            }
            if (!check.equals(FILLER)) {
                return check;
            }
        }
        return FILLER;
    }

    private String diagonalCrossed() {
        String check = positions[0][0];
        for (int i = 1; i < SIZE; i++) {
            if (!check.equals(positions[i][i])) {
                check = FILLER;
                break;
            }
        }
        if (!check.equals(FILLER)) {
            return check;
        }
        check = positions[0][2];
        for (int i = 1; i < SIZE; i++) {
            if (!check.equals(positions[i][SIZE - 1 - i])) {
                check = FILLER;
                break;
            }
        }
        if (!check.equals(FILLER)) {
            return check;
        }
        return FILLER;
    }

    public Player getWinner() {
        for (Player player : players) {
            if (player.getSymbol().equals(rowCrossed())) return player;
            if (player.getSymbol().equals(columnCrossed())) return player;
            if (player.getSymbol().equals(diagonalCrossed())) return player;
        }
        return null;
    }
}
