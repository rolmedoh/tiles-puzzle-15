/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rolmedo.tiles15.puzzle;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rolmedo.tiles15.tools.PuzzleTools;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;


/**
 *
 * @author ruben
 * @param
 */
@Entity
public class PuzzleTiles15{
            
    @Id
    protected String id;
    @ElementCollection
    protected List<Integer> tiles;
    protected Boolean solvable = null;
    
    public PuzzleTiles15(){
        PuzzleTools.LOGGER.trace("Puzzle creation");
        this.tiles = PuzzleTools.getRandomPuzzle(PuzzleTools.PUZZLE_SIZE_16);
        this.id = UUID.randomUUID().toString();
        PuzzleTools.LOGGER.debug("Puzzle creation with ID: "+this.id);
        PuzzleTools.LOGGER.debug("Puzzle tiles: "+this.tiles.toString());
    }
    
  

    @JsonIgnore
    public Boolean isSolvable(){     
        if(Objects.isNull(this.solvable)){
            this.solvable = PuzzleTools.checkSolvable(this.tiles);
            return this.solvable;
        }
        return this.solvable;
    }

    @JsonIgnore
    public int getPuzzleSize() {
        return PuzzleTools.PUZZLE_SIZE_16;
    }
    
    public String toJson(){
        ObjectMapper mapper = new ObjectMapper();
        try {
          String json = mapper.writeValueAsString(this);
          return json;
        } catch (JsonProcessingException e) {
           e.printStackTrace();
        }
        return "";
    }

     @Override
    public String toString() {
        return "Puzzle=[id=" + id + ",values=" + this.tiles.toString() + ",solvable=" + this.solvable + "]";
    }
    
    
    public String getId(){
        return this.id;
    }

    public List<Integer> getTiles() {
        return tiles;
    }

    public Boolean getSolvable() {
        return solvable;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    public void setTiles(List<Integer> tiles) {
        this.tiles = tiles;
    }

    public void setSolvable(Boolean solvable) {
        this.solvable = solvable;
    }
    
}
