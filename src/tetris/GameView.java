package tetris;

import java.util.Scanner;

public class GameView {

    Scanner scanner = new Scanner(System.in);
    GameService gameService;
    boolean running = true;


    public GameView(GameService gameService) {
        this.gameService = gameService;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (running) {
            manageActions(scanner.nextLine());

        }
    }


    private void manageActions(String userInput) {

        if (userInput.equals("rotate")) {
            gameService.rotateTetromino();
        } else if (userInput.equals("right")) {
            gameService.moveRight();
        } else if (userInput.equals("left")) {
            gameService.moveLeft();
        } else if (userInput.equals("down")) {
            gameService.moveDown();
        } else if (userInput.equals("break")) {
            gameService.breakTetrominoRow();
        } else if (userInput.equals("piece")) {
            gameService.addPiecesToBoard(scanner.nextLine());
        } else if (userInput.equals("exit")) {
            this.running = false;
            return;
        }
        gameService.tetrisMap.printStaticBoard();
        System.out.println();
        running=!gameService.isGameOver();
    }
}
