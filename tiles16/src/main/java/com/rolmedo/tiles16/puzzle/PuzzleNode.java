/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rolmedo.tiles16.puzzle;

import com.rolmedo.tiles16.tools.PuzzleParams;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author ruben
 */
public class PuzzleNode {
    private int cost;
    private int mDistance;
    private int fValue;
    private int blankPosition;
    private ArrayList<Integer> puzzle;
    
    public PuzzleNode(int cost, int mDistance, int fvalue, ArrayList<Integer> puzzle){
        	this.cost = cost;
		this.puzzle = puzzle;
		this.mDistance = PuzzleParams.findHeuristic(puzzle);// Manhattan;
		this.fValue = this.cost + this.mDistance;
		this.blankPosition = PuzzleParams.findBlankPos(this.puzzle);
    }
    
    public static PuzzleNode generatePuzzleNode(){
        return new PuzzleNode(0,0,0,PuzzleParams.getRandomPuzzle());
    }
    
    public ArrayList<Integer> getPuzzle(){
        return this.puzzle;
    }
    
    @Override
    public int hashCode(){
        return this.puzzle.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PuzzleNode other = (PuzzleNode) obj;
        if (!Objects.equals(this.puzzle, other.puzzle)) {
            return false;
        }
        return true;
    }
    
    
    
}
