package tetris;

import java.util.Scanner;

public class GameView {


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
            gameService.printSingleRotation();
        } else if (userInput.equals("right")) {
            gameService.moveRight();
            gameService.printSingleRotation();
        } else if (userInput.equals("left")) {
            gameService.moveLeft();
            gameService.printSingleRotation();
        } else if (userInput.equals("down")) {
            gameService.moveDown();
            gameService.printSingleRotation();
        } else if (userInput.equals("break")) {
            //TODO
        }
        else if (userInput.equals("exit")) {
            this.running = false;
        }
    }
}
