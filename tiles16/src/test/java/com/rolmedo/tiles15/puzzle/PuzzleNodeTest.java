/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rolmedo.tiles15.puzzle;

import com.rolmedo.tiles15.tools.PuzzleTools;
import org.junit.Ignore;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author ruben
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PuzzleNodeTest {
          
    @Autowired
    private PuzzleService puzzleService;
    
    public PuzzleNodeTest() {
     
    }
    
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

    /**
     * Test of generatePuzzleNode method, of class PuzzleNode.
     */
    @Test
    public void testGeneratePuzzleNode() {
        System.out.println("generatePuzzleNode");
        Puzzle expResult = null;
        Puzzle result = PuzzleTools.generatePuzzle(15);
        System.out.println("LLega "+result.toString());
        puzzleService.saveOrUpdate(result);
        System.out.println(result.toString());
        assertNotEquals(expResult, result);
    }

    /**
     * Test of getPuzzle method, of class PuzzleNode.
     */
    @Test
    public void testGetPuzzles() {
        System.out.println("getPuzzles");
        Puzzle expResult = null;
        Puzzle result = null;
        for(int i = 0; i < 10; i++){
             result = PuzzleTools.generatePuzzle(15);
             puzzleService.saveOrUpdate(result);
        }
        assertNotEquals(expResult, result);
    }


    /**
     * Test of equals method, of class PuzzleNode.
     */
    @Ignore
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        Puzzle instance = null;
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
