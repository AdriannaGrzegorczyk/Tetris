package tetris;

public class GameService extends TetrisMap {

    TetrisMap map = new TetrisMap();
    Pieces pieces = new Pieces();


    {
        //map.printBoard(true);
        pieces.addToTheMap();
    }

    public void addPiecesToBoard(String providedInput) {

        System.out.println("- - - -\n" +
                "- - - -\n" +
                "- - - -\n" +
                "- - - -");

        System.out.println();
        if (pieces.mapOfAllPieces.containsKey(providedInput)) {

            int[][] pieceShapes = pieces.mapOfAllPieces.get(providedInput);

            for (int[] pieceShape : pieceShapes) {
                for (int piece : pieceShape) {

                    boardMap[piece/4][piece%4]=1;
                }
                printBoard(false);
                boardMap=new int [4][4];
                System.out.println();
            }
        }


    }
}
