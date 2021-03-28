/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rolmedo.tiles15.request;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @author ruben
 */
public class SolvableResponse {
    private String id;
    private Boolean isSolvable;
    
    public SolvableResponse(String id, Boolean isSolvable){
        this.id = id;
        this.isSolvable = isSolvable;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getIsSolvable() {
        return isSolvable;
    }

    public void setIsSolvable(Boolean isSolvable) {
        this.isSolvable = isSolvable;
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
