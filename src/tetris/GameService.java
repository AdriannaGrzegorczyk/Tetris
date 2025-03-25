package tetris;



public class GameService  {

    TetrisMap tetrisMap = new TetrisMap();
    Pieces pieces = new Pieces();
    int[][] tetrominoRotations;
    int currentRotation;
    int tetrominoMovement=0;
    int tetrominoDown=0;



    public GameService() {
        pieces.addToTheMap();
    }




    public void addPiecesToBoard(String providedInput) {

        System.out.println();
        tetrisMap.printBoard(false);
        System.out.println();

        if (pieces.mapOfAllPieces.containsKey(providedInput)) {
            tetrominoRotations = pieces.mapOfAllPieces.get(providedInput);
            currentRotation = 0;
            for (int piece : tetrominoRotations[currentRotation]) {
                tetrisMap.boardMap[piece / 10][piece % 10] = 1;
            }
            tetrisMap.printBoard(false);
            System.out.println();
        }
    }

    public void printSingleRotation(){
        tetrisMap.boardMap = new int[Integer.parseInt(tetrisMap.row)][Integer.parseInt(tetrisMap.col)];
        for (int singleIndexOfRotation : tetrominoRotations[currentRotation]) {

            singleIndexOfRotation = (tetrominoDown * Integer.parseInt(tetrisMap.col)) + singleIndexOfRotation;
            int initialRow =singleIndexOfRotation/10; // checking in which row we are
            singleIndexOfRotation = singleIndexOfRotation + tetrominoMovement; // 4+ 40
            int rowAfterMovement = singleIndexOfRotation/10; // 4
            singleIndexOfRotation = singleIndexOfRotation - ((rowAfterMovement - initialRow) *10);

            tetrisMap.boardMap[singleIndexOfRotation / 10][singleIndexOfRotation % 10] = 1;
        }
        tetrisMap.printBoard(false);
        System.out.println();

    }
    public void rotateTetromino() {
        currentRotation = (currentRotation+1)% tetrominoRotations.length;
        tetrominoDown++;
    }

    public void moveRight() {
        tetrominoMovement++;
        tetrominoDown++;
    }

    public void moveLeft() {
        tetrominoMovement--;
        tetrominoDown++;

    }

    public void moveDown() {
        tetrominoDown++;
    }


}