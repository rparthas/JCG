package com.jcg.tictactoe;

import java.util.List;

public class Move implements Comparable<Move> {

    private int row;

    public int getRow() {
        return row;
    }

    public Move(int row, int column, List<Score> scores) {
        this.row = row;
        this.column = column;
        this.scores = scores;
    }

    @Override
    public String toString() {
        return "Move{" +
                "row=" + row +
                ", column=" + column +
                ", score=" + getNetScore() +
                '}';
    }

    public int getColumn() {
        return column;
    }


    private int column;

    public List<Score> getScores() {
        return scores;
    }

    private List<Score> scores;

    private int getNetScore() {
        int wins = 0;
        int losses = 0;
        for (Score score : scores) {
            wins += score.isWin() ? 1 : 0;
            losses += score.isLoss() ? 1 : 0;
        }
        return wins - losses;
    }

    @Override
    public int compareTo(Move move) {
        int netScore = getNetScore();
        int otherNetScore = move.getNetScore();
        return netScore > otherNetScore ? -1 : netScore == otherNetScore ? 0 : 1;
    }
}
