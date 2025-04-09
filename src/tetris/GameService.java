package tetris;

public class GameService {

    TetrisMap tetrisMap = new TetrisMap();
    Pieces pieces = new Pieces();
    int[][] tetrominoRotations;
    int currentRotation;
    int tetrominoMovement = 0;
    int tetrominoDown = 0;


    public GameService() {
        pieces.addToTheMap();
    }


    public void addPiecesToBoard(String providedInput) {
        if (pieces.mapOfAllPieces.containsKey(providedInput)) {
            tetrominoRotations = pieces.mapOfAllPieces.get(providedInput);
            currentRotation = 0;
            tetrominoDown = 0;
            tetrominoMovement = 0;
            if (isHittingAnotherTetromino()) {
                System.out.println("Game Over!");
            }
            for (int piece : tetrominoRotations[currentRotation]) {
                tetrisMap.boardMap[piece / 10][piece % 10] = 1;
            }


        }
    }


    public void printSingleRotation() {
        tetrisMap.boardMap = new int[Integer.parseInt(tetrisMap.row)][Integer.parseInt(tetrisMap.col)];
        for (int singleIndexOfRotation : tetrominoRotations[currentRotation]) {
            singleIndexOfRotation = (tetrominoDown * Integer.parseInt(tetrisMap.col)) + singleIndexOfRotation;
            singleIndexOfRotation = singleIndexOfRotation + tetrominoMovement;
            tetrisMap.boardMap[singleIndexOfRotation / 10][singleIndexOfRotation % 10] = 1;
        }

    }

    public void printSingleRotationSecondBoard() {
        for (int singleIndexOfRotation : tetrominoRotations[currentRotation]) {
            singleIndexOfRotation = (tetrominoDown * Integer.parseInt(tetrisMap.col)) + singleIndexOfRotation;
            singleIndexOfRotation = singleIndexOfRotation + tetrominoMovement;
            tetrisMap.boardMapToSaveTetromino[singleIndexOfRotation / 10][singleIndexOfRotation % 10] = 1;
        }
        tetrisMap.boardMap = new int[Integer.parseInt(tetrisMap.row)][Integer.parseInt(tetrisMap.col)];
    }

    public boolean isHittingFlor() {
        for (int singleIndexOfRotation : tetrominoRotations[currentRotation]) {
            singleIndexOfRotation = singleIndexOfRotation + tetrominoMovement;
            int rowAfterMovement = (singleIndexOfRotation / 10) + tetrominoDown;
            if (rowAfterMovement == tetrisMap.boardMap.length) {
                return true;
            }
        }
        return false;
  }


    public boolean isHittingRightBorder() {
        for (int singleIndexOfRotation : tetrominoRotations[currentRotation]) {
            int initialRow = singleIndexOfRotation / 10;
            singleIndexOfRotation = singleIndexOfRotation + tetrominoMovement;
            int rowAfterMovement = singleIndexOfRotation / 10;
            if (rowAfterMovement > initialRow) {
                return true;
            }
        }
        return false;
    }

    public boolean isHittingLeftBorder() {
        for (int singleIndexOfRotation : tetrominoRotations[currentRotation]) {
            int initialRow = singleIndexOfRotation / 10;
            singleIndexOfRotation = singleIndexOfRotation + tetrominoMovement;
            int rowAfterMovement = singleIndexOfRotation / 10;
            if (rowAfterMovement < initialRow || singleIndexOfRotation < 0) {
                return true;
            }
        }
        return false;
    }

    public void rotateTetromino() {
        tetrominoDown++;
        if (isHittingFlor() || isHittingAnotherTetromino()) {
            tetrominoDown--;
            printSingleRotationSecondBoard();
            return;
        }
        currentRotation = (currentRotation + 1) % tetrominoRotations.length;
        if (isHittingFlor() || isHittingLeftBorder() || isHittingRightBorder()) {
            if (currentRotation == 0) {
                currentRotation = tetrominoRotations.length - 1;
            } else {
                currentRotation = currentRotation - 1;
            }
        }
        printSingleRotation();
    }

    public void moveRight() {
        tetrominoDown++;
        if (isHittingFlor() || isHittingAnotherTetromino()) {
            tetrominoDown--;
            printSingleRotationSecondBoard();
            return;
        }
        tetrominoMovement++;
        if (isHittingRightBorder() || isHittingAnotherTetromino()) {
            tetrominoMovement--;
        }
        printSingleRotation();

    }

    public void moveLeft() {
        tetrominoDown++;
        if (isHittingFlor() || isHittingAnotherTetromino()) {
            tetrominoDown--;
            printSingleRotationSecondBoard();
            return;
        }
        tetrominoMovement--;
        if (isHittingLeftBorder() || isHittingAnotherTetromino()) {
            tetrominoMovement++;
        }
        printSingleRotation();
    }

    public void moveDown() {
        tetrominoDown++;
        if (isHittingFlor() || isHittingAnotherTetromino()) {
            tetrominoDown--;
            printSingleRotationSecondBoard();
            return;
        }
        printSingleRotation();
    }

    public boolean isHittingAnotherTetromino() {
        for (int singleIndexOfRotation : tetrominoRotations[currentRotation]) {
            singleIndexOfRotation = (tetrominoDown * Integer.parseInt(tetrisMap.col)) + singleIndexOfRotation;
            singleIndexOfRotation = singleIndexOfRotation + tetrominoMovement;
            if (tetrisMap.boardMapToSaveTetromino[singleIndexOfRotation / 10][singleIndexOfRotation % 10] == 1) {
                return true;

            }
        }
        return false;
    }

    public void breakTetrominoRow() {
        boolean isLastRowMarked = true;
        for (int i = 0; i < tetrisMap.boardMapToSaveTetromino[0].length; i++) {
            if (tetrisMap.boardMapToSaveTetromino[tetrisMap.boardMapToSaveTetromino.length-1][i] != 1) {
                isLastRowMarked = false;
                break;
            }
        }
        if (isLastRowMarked) {
            for (int i = tetrisMap.boardMapToSaveTetromino.length - 2; i >= 0; i--) {
                for (int j = 0; j < tetrisMap.boardMapToSaveTetromino[i].length; j++) {
                    tetrisMap.boardMapToSaveTetromino[i + 1][j] = tetrisMap.boardMapToSaveTetromino[i][j];
                }
            }
            tetrisMap.boardMapToSaveTetromino[0] = new int[tetrisMap.boardMapToSaveTetromino[0].length];
            breakTetrominoRow();
        }
    }

    public boolean isGameOver(){
        for (int i = 0; i<tetrisMap.boardMapToSaveTetromino[0].length;i++){
            if (tetrisMap.boardMapToSaveTetromino[0][i] == 1){
                System.out.println("Game Over!");
               return true;
            }
        }
        return false;

    }


}
