package tetris;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String selectedTetromino = scanner.nextLine();

        GameService gameService = new GameService();
        GameView view = new GameView(gameService);

        gameService.addPiecesToBoard(selectedTetromino);
        view.start();


    }
}