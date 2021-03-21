/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rolmedo.tiles15.tools;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author ruben
 */
public class PuzzleParams {
    
    public static Integer TILTES_SIZE = 16;
    public static Integer LAST_TILTE = 0;
    public static Integer BLANK=0;
    public static ArrayList<Integer> GOAL_STATE;
    
    static{
        GOAL_STATE = new ArrayList<Integer>();
         for(int i = 1; i < TILTES_SIZE; i++){
            GOAL_STATE.add(i);
        }
        GOAL_STATE.add(LAST_TILTE);
    }
    
    public static ArrayList getRandomPuzzle(){
        
        ArrayList<Integer> puzzle = new ArrayList<>();
        for(int i = 0; i < TILTES_SIZE; i++){
            puzzle.add(i);
        }
        Collections.shuffle(puzzle);
        return puzzle;
    }
    
    public static int findHeuristic(ArrayList<Integer> puzzle) {
        if (puzzle == null)
                return 1;
        /* ManhattanDistance as heuristic */
        int manhattanDistance = 0;

        for (int i = 0; i < puzzle.size(); i++) {
            int tile = puzzle.get(i);
                if (tile != BLANK) {
                        int goalPositionRow = (tile - 1) / 4;
                        int curPositionRow = i / 4;
                        int goalPositionCol = (tile - 1) % 4;
                        int curPositionCol = i % 4;
                        manhattanDistance += Math.abs(goalPositionRow
                                        - curPositionRow)
                                        + Math.abs(goalPositionCol - curPositionCol);
                }
        }
	return manhattanDistance*2;
    }

    
    public static int findBlankPos(ArrayList<Integer> puzzle){
        return puzzle.indexOf(BLANK);
    }
    
}
