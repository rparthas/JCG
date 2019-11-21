package com.jcg.tictactoe;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Game game = new Game("Player1", "Player2");
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 9; i++) {
            System.out.println("Enter your x,y positions eg:0,0");
            String input = scanner.next();
            String[] positions = input.split(",");
            boolean result = game.move(Integer.parseInt(positions[0]), Integer.parseInt(positions[1]));
            if (!result) {
                i--;
            }
            game.printBoard();
        }
    }
}
