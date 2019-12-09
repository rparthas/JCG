package com.jcg.tictactoe;

import java.util.ArrayList;
import java.util.List;

public class AIPlayer extends Player {

    public AIPlayer(String name, String symbol) {
        super(name, symbol);
    }

    public boolean isComputer() {
        return true;
    }

    public void playMove(Game game) {

        String[][] board = game.getBoard();
        Move bestMove = new Move(-1, -1, Integer.MIN_VALUE);
        int gridSize = board.length;
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                if (board[i][j].equals(Game.FILLER)) {
                    board[i][j] = getSymbol();
                    Move move = new Move(i, j, calculateMoveCost(getSymbol(), board));
//                    System.out.println(move.toString());
                    if (move.getScore() > bestMove.getScore()) {
                        bestMove = move;
                    }
                    board[i][j] = Game.FILLER;
                }
            }
        }
        game.move(bestMove.getRow(), bestMove.getColumn());

    }

    private int calculateMoveCost(final String symbol, String[][] board) {
        int size = board.length;
        List<Scorer> scorerList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Scorer rowScorer = new Scorer();
            Scorer colScorer = new Scorer();
            for (int j = 0; j < size; j++) {
                rowScorer.ScoreBasedOnSymbol(symbol, board[i][j], Game.FILLER);
                colScorer.ScoreBasedOnSymbol(symbol, board[j][i], Game.FILLER);
            }
            scorerList.add(rowScorer);
            scorerList.add(colScorer);
        }

        Scorer diagonal1Scorer = new Scorer();
        Scorer diagonal2Scorer = new Scorer();
        for (int i = 0; i < size; i++) {
            diagonal1Scorer.ScoreBasedOnSymbol(symbol, board[i][i], Game.FILLER);
            diagonal2Scorer.ScoreBasedOnSymbol(symbol, board[i][size - i - 1], Game.FILLER);
        }
        scorerList.add(diagonal1Scorer);
        scorerList.add(diagonal2Scorer);

        int score = 0;
        for (Scorer scorer : scorerList) {
            score += scorer.getScore(size);
        }

        return score;
    }
}
