package tetris;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        GameService gameService = new GameService();
        GameView view = new GameView(gameService);
        view.start();


    }
}