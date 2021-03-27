/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rolmedo.tiles15.tools;

import com.rolmedo.tiles15.puzzle.Puzzle;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author ruben
 */
public class PuzzleTools {

    
    public static ArrayList getRandomPuzzle(int puzzleSize){

        ArrayList<Integer> puzzle = new ArrayList<>();
        for(int i = 0; i < puzzleSize; i++){
            puzzle.add(i);
        }
        Collections.shuffle(puzzle);
        return puzzle;
    }
    
    /**
     * https://ssaurel.medium.com/developing-a-15-puzzle-game-of-fifteen-in-java-dfe1359cc6e3
     * @param puzzle
     * @return 
     */
    public static Boolean checkSolvable(ArrayList<Integer> tiles){
        int countInversions = 0;

        for (int i = 0; i < tiles.size(); i++) {
          for (int j = 0; j < i; j++) {
            if (tiles.get(j) > tiles.get(i))
              countInversions++;
          }
        }
        return countInversions % 2 == 0;
    }

}
