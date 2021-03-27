/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rolmedo.tiles15.puzzle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author ruben
 * @param <Integer>
 */
@Entity
@Table
public abstract class Puzzle{
      
    @Id
    @GeneratedValue
    @Column
    protected String id;
    @Column
    protected ArrayList<Integer> tiles;
    @Column
    protected Boolean solvable;
    
    public static Puzzle generatePuzzle(int tiles){
        
        switch(tiles){
            case 15: PuzzleTiles15 puzzle = new PuzzleTiles15();
                     return puzzle;
                
            default: return null;
        }
       
    }

    public abstract int getPuzzleSize();
    public abstract Boolean isSolvable();
    @Override
    public String toString() {
        return "Puzzle=[id=" + id + ",values=" + this.tiles.toString() + ",solvable=" + this.isSolvable() + "]";
    }
    public String getId(){
        return this.id;
    }
}

