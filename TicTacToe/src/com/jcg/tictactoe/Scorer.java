package com.jcg.tictactoe;

public class Scorer {

    private int win;

    private int loss;

    private int moves;

    public int getScore(int grid) {
        if (win > 0 && loss == 0 && win + moves == grid) {
            return 10 * (grid - moves);
        }
        if (loss > 0 && win == 0 && loss + moves == grid) {
            return -10 * (grid - moves);
        }
        return 0;
    }

    public void ScoreBasedOnSymbol(String symbol, String symbolToCompare, String tieSymbol) {
        if (symbol.equals(symbolToCompare))
            win++;
        else if (tieSymbol.equals(symbolToCompare))
            moves++;
        else
            loss++;
    }

}
