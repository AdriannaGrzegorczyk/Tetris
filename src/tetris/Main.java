package tetris;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        GameService gameService = new GameService();
        gameService.addPiecesToBoard(scanner.nextLine());



    }
}