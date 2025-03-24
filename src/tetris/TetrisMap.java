package tetris;



public class TetrisMap {

    public int[][] boardMap = new int[4][4];


    public void printBoard(boolean isMasked) {

        for (int i = 0; i < this.boardMap.length; i++) {

            for (int j = 0; j < this.boardMap[i].length; j++) {
                if (isMasked) {
                    System.out.print("- ");
                } else{
                    if(boardMap[i][j] == 0){
                        System.out.print("- ");
                    }else{
                        System.out.print("0 ");
                    }
                }
            }
            System.out.println();
        }
    }



}
