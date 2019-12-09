package com.jcg.tictactoe;

import java.util.Scanner;

public class Main {

    public static final int GRID = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game;
        loop:
        while (true) {
            System.out.println("Enter number of human players");
            try {
                String input = scanner.next();
                switch (Integer.parseInt(input)) {
                    case 1:
                        game = new Game("Player1", GRID);
                        break loop;
                    case 2:
                        game = new Game("Player1", "Player2", GRID);
                        break loop;
                }
            } catch (Exception e) {
            }
        }
        game.start();
        Player winner = game.getWinner();
        System.out.println(winner != null ? "Winner is " + winner.getName() : "Tied");
    }


}
