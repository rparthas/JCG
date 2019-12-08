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
                int input = scanner.nextInt();
                switch (input) {
                    case 1:
                        game = new Game("Player1", "Computer1", GRID);
                        break loop;
                    case 2:
                        game = new Game("Player1", "Player2", GRID);
                        break loop;
                }
            } catch (Exception e) {
            }
        }
        game.printBoard();
        while (!game.isGameOver()) {
            System.out.println("Enter your x,y positions -> For first row and first column enter 1,1");
            String input = scanner.next();
            try {
                String[] positions = input.split(",");
                game.move(Integer.parseInt(positions[0]) - 1, Integer.parseInt(positions[1]) - 1);
            } catch (Exception e) {
            }
            game.printBoard();
        }
        Player winner = game.getWinner();
        System.out.println(winner != null ? "Winner is " + winner.getName() : "Tied");
    }


}
