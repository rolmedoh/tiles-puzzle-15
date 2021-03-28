/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rolmedo.tiles15.tools;

import com.rolmedo.tiles15.TilesApplication;
import com.rolmedo.tiles15.puzzle.PuzzleTiles15;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author ruben
 */
public class PuzzleTools {

    public static final int PUZZLE_SIZE_16 = 16;  
    public static Logger LOGGER = LoggerFactory.getLogger(TilesApplication.class);
    
    public static ArrayList getRandomPuzzle(int puzzleSize){

        ArrayList<Integer> puzzle = new ArrayList<>();
        for(int i = 1; i < puzzleSize; i++){
            puzzle.add(i);
        }
        Collections.shuffle(puzzle);
        puzzle.add(0);
        return puzzle;
    }
    
    /**
     * https://ssaurel.medium.com/developing-a-15-puzzle-game-of-fifteen-in-java-dfe1359cc6e3
     * @param puzzle
     * @return 
     */
    public static Boolean checkSolvable(List<Integer> tiles){
        int countInversions = 0;

        for (int i = 0; i < tiles.size(); i++) {
          for (int j = 0; j < i; j++) {
            if (tiles.get(j) > tiles.get(i))
              countInversions++;
          }
        }
        return countInversions % 2 == 0;
    }

     public static PuzzleTiles15 generatePuzzle(){ 
       
            PuzzleTools.LOGGER.debug("Requested puzzle with 15 tiles");
            PuzzleTiles15 puzzle = new PuzzleTiles15();
            return puzzle;
  
    }
}
