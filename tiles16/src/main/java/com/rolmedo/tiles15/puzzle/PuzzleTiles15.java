/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rolmedo.tiles15.puzzle;

import com.rolmedo.tiles15.tools.PuzzleTools;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;
import javax.persistence.Entity;


/**
 *
 * @author ruben
 * @param
 */
@Entity
public class PuzzleTiles15 extends Puzzle{
    
    private static final int PUZZLE_SIZE = 16;
            
    public PuzzleTiles15(){
        this.tiles = PuzzleTools.getRandomPuzzle(PUZZLE_SIZE);
        this.id = UUID.randomUUID(); 
        System.out.println("Puzzle created");
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
