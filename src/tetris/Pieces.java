package tetris;

import java.util.HashMap;
import java.util.Map;


public class Pieces {


    Map<String,int[][]> mapOfAllPieces = new HashMap<>();

    public void addToTheMap (){
        this.mapOfAllPieces.put("O", new int[][]{{4, 14, 15, 5}});
        this.mapOfAllPieces.put("I", new int[][]{{4, 14, 24, 34}, {3, 4, 5, 6}});
        this.mapOfAllPieces.put("S", new int[][]{{5, 4, 14, 13}, {4, 14, 15, 25}});
        this.mapOfAllPieces.put("Z", new int[][]{{4, 5, 15, 16}, {5, 15, 14, 24}});
        this.mapOfAllPieces.put("L", new int[][]{{4, 14, 24, 25}, {5, 15, 14, 13}, {4, 5, 15, 25}, {6, 5, 4, 14}});
        this.mapOfAllPieces.put("J", new int[][] {{5, 15, 25, 24}, {15, 5, 4, 3}, {5, 4, 14, 24}, {4, 14, 15, 16}});
        this.mapOfAllPieces.put("T", new int[][]{{4, 14, 24, 15}, {4, 13, 14, 15}, {5, 15, 25, 14}, {4, 5, 6, 15}});
    }
}