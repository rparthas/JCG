package com.jcg.tictactoe;

public class Move {

    private int row;

    public int getRow() {
        return row;
    }


    @Override
    public String toString() {
        return "Move{" +
                "row=" + row +
                ", column=" + column +
                ", score=" + score +
                '}';
    }

    public int getColumn() {
        return column;
    }


    private int column;


    public int getScore() {
        return score;
    }

    private int score;

    public Move(int row, int column, int score) {
        this.row = row;
        this.column = column;
        this.score = score;
    }
}
