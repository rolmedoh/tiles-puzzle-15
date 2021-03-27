/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rolmedo.tiles15.puzzle;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author ruben
 * @param <Integer>
 */
@Entity
public abstract class Puzzle{
      
    @Id
    protected UUID id;
    @ElementCollection
    protected List<Integer> tiles;
    protected Boolean solvable = null;
    
    public abstract int getPuzzleSize();
    public abstract Boolean isSolvable();
    @Override
    public String toString() {
        return "Puzzle=[id=" + id + ",values=" + this.tiles.toString() + ",solvable=" + this.solvable + "]";
    }
    public UUID getId(){
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setTiles(List<Integer> tiles) {
        this.tiles = tiles;
    }

    public void setSolvable(Boolean solvable) {
        this.solvable = solvable;
    }
    
}

