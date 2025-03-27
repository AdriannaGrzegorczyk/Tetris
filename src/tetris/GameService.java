package tetris;
/*
1. Przeniesc te fragmenty kodu ktore sprawdzaja czy ruch jest legalny do metod
2. Te metody powinny zwracac boolea
4. Wrzucic to sprawdzanie  do metod moveRight/moveLeft/moveDown w logiczny sposob
 */

public class GameService {

    TetrisMap tetrisMap = new TetrisMap();
    Pieces pieces = new Pieces();
    int[][] tetrominoRotations;
    int currentRotation;
    int tetrominoMovement = 0;
    int tetrominoDown = 0;
    boolean endOfMovement = false;


    public GameService() {
        pieces.addToTheMap();
    }


    public void addPiecesToBoard(String providedInput) {

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

    public void coppyArray() {

        for (int i = 0; i < tetrisMap.boardMap.length; i++) {
            for (int j = 0; j < tetrisMap.boardMap[i].length; j++) {
                tetrisMap.boardMapToSaveTetromino[i][j] = tetrisMap.boardMap[i][j];
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
        tetrisMap.printBoard(false);
        System.out.println();
    }

    public boolean isHittingFlor() {
        for (int singleIndexOfRotation : tetrominoRotations[currentRotation]) {
            singleIndexOfRotation = singleIndexOfRotation + tetrominoMovement;
            int rowAfterMovement = (singleIndexOfRotation / 10) + tetrominoDown;
            if (rowAfterMovement == tetrisMap.boardMap.length) {
                coppyArray();
                return true;
            }
        }
        return false;
    }

    public int adjustHittingBorder() {
        for (int singleIndexOfRotation : tetrominoRotations[currentRotation]) {
            int initialRow = singleIndexOfRotation / 10;
            singleIndexOfRotation = singleIndexOfRotation + tetrominoMovement;
            int rowAfterMovement = singleIndexOfRotation / 10;
            if (rowAfterMovement > initialRow) {
                return -1;
            } else if (rowAfterMovement < initialRow || singleIndexOfRotation < 0) {
                return 1;
            }
        }
        return 0;
    }

    public void rotateTetromino() {
        tetrominoDown++;
        if (isHittingFlor()) {
            tetrominoDown--;
            return;
        }
        currentRotation = (currentRotation + 1) % tetrominoRotations.length;
        if (adjustHittingBorder() != 0 || isHittingFlor()) {
            if (currentRotation == 0) {
                currentRotation = tetrominoRotations.length - 1;
            } else {
                currentRotation = currentRotation - 1;
            }
        }
    }

    public void moveRight() {
        tetrominoDown++;
        if (isHittingFlor()) {
            tetrominoDown--;
            return;
        }
        tetrominoMovement++;
        tetrominoMovement = tetrominoMovement + adjustHittingBorder();
    }

    public void moveLeft() {
        tetrominoDown++;
        if (isHittingFlor()) {
            tetrominoDown--;
            return;
        }
        tetrominoMovement--;
        tetrominoMovement = tetrominoMovement + adjustHittingBorder();
    }

    public void moveDown() {
        tetrominoDown++;
        if (isHittingFlor()) {
            tetrominoDown--;
            return;
        }
    }
}

