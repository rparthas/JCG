package com.jcg.tictactoe;

public class Score {

    private boolean win;

    public boolean isWin() {
        return win;
    }

    public boolean isTie() {
        return tie;
    }

    private boolean tie;

    private int moves;

    public Score(boolean win, boolean tie) {
        this.win = win;
        this.tie = tie;
    }

    @Override
    public String toString() {
        return "Score{" +
                "win=" + win +
                ", tie=" + tie +
                ", moves=" + moves +
                '}';
    }

    public boolean isLoss() {
        return !isTie() && !isWin();
    }
}
