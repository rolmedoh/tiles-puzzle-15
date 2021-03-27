/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rolmedo.tiles15.puzzle;

import com.rolmedo.tiles15.tools.PuzzleTools;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;


/**
 *
 * @author ruben
 * @param <Integer>
 */
public class PuzzleTiles15<Integer> extends Puzzle implements Serializable{
    
    private static final int PUZZLE_SIZE = 16;
            
    protected PuzzleTiles15(){
        super();
        this.tiles.addAll(PuzzleTools.getRandomPuzzle(PUZZLE_SIZE));
        this.id = UUID.randomUUID().toString();  
    }
    
  

    @Override
    public Boolean isSolvable(){     
        if(Objects.isNull(this.isSolvable())){
            this.solvable = PuzzleTools.checkSolvable(this.tiles);
            return this.solvable;
        }
        return this.solvable;
    }

    @Override
    public int getPuzzleSize() {
        return PUZZLE_SIZE;
    }

}
