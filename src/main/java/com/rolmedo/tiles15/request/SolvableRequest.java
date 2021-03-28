/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rolmedo.tiles15.request;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rolmedo.tiles15.tools.PuzzleTools;
import java.util.UUID;

/**
 *
 * @author ruben
 */
public class SolvableRequest {
    
    private String id;
    
    public SolvableRequest(String id){
        this.id = id;
    }
     public SolvableRequest(){
 
    }
    
    public Boolean checkIdFormat(){
        try{
            UUID.fromString(id);
            return true;
        }catch(IllegalArgumentException ex){
            PuzzleTools.LOGGER.info("Puzzle ID invalid format " + id);
            return false;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
}
