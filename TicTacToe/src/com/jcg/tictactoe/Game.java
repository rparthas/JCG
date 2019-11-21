package com.jcg.tictactoe;

public class Game {

    public static final int SIZE = 3;
    private String[][] positions;
    private String player1 = "Computer1";
    private String player2 = "Computer2";
    private String activePlayer = null;

    public Game(String player) {
        positions = new String[SIZE][SIZE];
        player1 = player;
    }

    public Game(String player1, String player2) {
        this(player1);
        this.player2 = player2;
    }


    public boolean move(int xPosition, int yPosition) {
        if (xPosition >= SIZE || yPosition >= SIZE || xPosition < 0 || yPosition < 0)
            return false;
        if (positions[xPosition][yPosition] != null)
            return false;
        updatePlayerMove(xPosition, yPosition);
        return true;
    }

    private void updatePlayerMove(int xPosition, int yPosition) {
        activePlayer = activePlayer == null || activePlayer.equals(player2) ? player1 : player2;
        positions[xPosition][yPosition] = activePlayer;
    }

    public void printBoard() {
        for (int i = 0; i < SIZE; i++) {
            String row = "";
            for (int j = 0; j < SIZE; j++) {
                row = row + " " + positions[i][j];
            }
            System.out.println(row);
        }
    }

}
