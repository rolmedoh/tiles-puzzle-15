/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rolmedo.tiles15.puzzle;

import com.rolmedo.tiles15.tools.PuzzleParams;
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

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getmDistance() {
        return mDistance;
    }

    public void setmDistance(int mDistance) {
        this.mDistance = mDistance;
    }

    public int getfValue() {
        return fValue;
    }

    public void setfValue(int fValue) {
        this.fValue = fValue;
    }

    public int getBlankPosition() {
        return blankPosition;
    }

    public void setBlankPosition(int blankPosition) {
        this.blankPosition = blankPosition;
    }
    
    @Override
    public int hashCode(){
        final int prime = 31;
	int result = 1;
	result = prime * result + this.puzzle.hashCode();
	return result;

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
