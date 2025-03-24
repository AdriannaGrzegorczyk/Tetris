package tetris;

import java.util.HashMap;
import java.util.Map;


public class Pieces {


    Map<String,int[][]> mapOfAllPieces = new HashMap<>();

    public void addToTheMap (){
        this.mapOfAllPieces.put("O", new int[][]{{5, 6, 9, 10}});
        this.mapOfAllPieces.put("I", new int[][]{{1, 5, 9, 13}, {4, 5, 6, 7}, {1, 5, 9, 13}, {4, 5, 6, 7},{1, 5, 9, 13}});
        this.mapOfAllPieces.put("S", new int[][]{{6, 5, 9, 8}, {5, 9, 10, 14}, {6, 5, 9, 8}, {5, 9, 10, 14},{6, 5, 9, 8}});
        this.mapOfAllPieces.put("Z", new int[][]{{4, 5, 9, 10}, {2, 5, 6, 9}, {4, 5, 9, 10}, {2, 5, 6, 9},{4, 5, 9, 10}});
        this.mapOfAllPieces.put("L", new int[][]{{1, 5, 9, 10}, {2, 4, 5, 6}, {1, 2, 6, 10}, {4, 5, 6, 8},{1, 5, 9, 10}});
        this.mapOfAllPieces.put("J", new int[][]{{2, 6, 9, 10}, {4, 5, 6, 10}, {1, 2, 5, 9}, {0, 4, 5, 6},{2, 6, 9, 10}});
        this.mapOfAllPieces.put("T", new int[][]{{1, 4, 5, 6}, {1, 4, 5, 9}, {4, 5, 6, 9}, {1, 5, 6, 9},{1, 4, 5, 6}});
    }
}