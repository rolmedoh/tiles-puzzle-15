/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rolmedo.tiles15.puzzle;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rolmedo.tiles15.request.SolvableRequest;
import static org.hamcrest.CoreMatchers.containsString;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
/**
 *
 * @author ruben
 */
@SpringBootTest
@AutoConfigureMockMvc
public class PuzzleControllerTest {
    
    @Autowired
    private MockMvc mockMvc;
    
     
    @BeforeAll
    public static void setUpClass() {
      
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void shouldReturnDefaultMessage() throws Exception {
		this.mockMvc.perform(post("/api/puzzle/1/create-puzzle").contentType(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("id")));
    }
    @Test
    public void shouldReturnNotFound() throws Exception {
		this.mockMvc.perform(post("/api/puzzle/1/is-solvable").content(new SolvableRequest("OOO").toJson()).contentType(MediaType.APPLICATION_JSON))
                        .andDo(print()).andExpect(status().isBadRequest());
    }
     @Test
    public void shouldReturnRight() throws Exception {
                MvcResult result = this.mockMvc.perform(post("/api/puzzle/1/create-puzzle"))
                          .andDo(print()).andExpect(status().isOk()).andReturn();
                ObjectMapper m = new ObjectMapper();
                PuzzleTiles15 puzzle = m.readValue(result.getResponse().getContentAsString(), PuzzleTiles15.class);
		this.mockMvc.perform(post("/api/puzzle/1/is-solvable").content(new SolvableRequest(puzzle.getId()).toJson()).contentType(MediaType.APPLICATION_JSON))
                        .andDo(print()).andExpect(status().isOk());
    }
}
