package tetris;


import java.util.Scanner;

public class TetrisMap {

    String row;
    String col;
    public int[][] boardMap;
    public int[][] boardMapToSaveTetromino;

    public TetrisMap() {
        Scanner input = new Scanner(System.in);
        String boardSize = input.nextLine();
        col = boardSize.substring(0, boardSize.indexOf(" "));
        row = boardSize.substring(boardSize.indexOf(" ") + 1);
        boardMap = new int[Integer.parseInt(row)][Integer.parseInt(col)];
        boardMapToSaveTetromino = new int[Integer.parseInt(row)][Integer.parseInt(col)];
        printStaticBoard();
        System.out.println();

    }


    public void printBoard(boolean isMasked) {

        for (int i = 0; i < this.boardMap.length; i++) {
            for (int j = 0; j < this.boardMap[i].length; j++) {
                if (isMasked) {
                    System.out.print("- ");
                } else {
                    if (boardMap[i][j] == 0) {
                        System.out.print("- ");
                    } else {
                        System.out.print("0 ");
                    }
                }
            }
            System.out.println();
        }
    }

    public void printStaticBoard() {
        for (int i = 0; i < this.boardMapToSaveTetromino.length; i++) {
            for (int j = 0; j < this.boardMapToSaveTetromino[i].length; j++) {
                if (boardMapToSaveTetromino[i][j] == 0 && boardMap[i][j] == 0) {
                    System.out.print("- ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }

    }
}
