/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rolmedo.tiles15.puzzle;

import com.rolmedo.tiles15.tools.PuzzleTools;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import org.junit.Ignore;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
/**
 *
 * @author ruben
 */
@SpringBootTest
public class PuzzleNodeTest {
          
    @Autowired
    private PuzzleService puzzleService;
    
    private String fakeId = "7341813d-e0eb-4d12-9cc4-1f7ca6ea41ce";
    
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
        PuzzleTiles15 expResult = null;
        PuzzleTiles15 result = PuzzleTools.generatePuzzle();
        puzzleService.saveOrUpdate(result);
        result.isSolvable();
        puzzleService.saveOrUpdate(result);
        assertNotEquals(expResult, result);
    }

    /**
     * Test of getPuzzle method, of class PuzzleNode.
     */
    @Test
    public void testGetPuzzles() {
        System.out.println("getPuzzles");
        PuzzleTiles15 expResult = null;
        PuzzleTiles15 result = null;
        try{
        for(int i = 0; i < 10; i++){
             result = PuzzleTools.generatePuzzle();
             result.isSolvable();        
             System.out.println(result.toString());
        }
        }catch(Exception ex){
            System.out.println("Error "+ ex.getLocalizedMessage());
        }
        assertNotEquals(expResult, result);
    }


    /**
     * Test of equals method, of class PuzzleNode.
     */
    @Test
    public void testEquals() {
        System.out.println("Retrieve object");
        Object obj = null;
        PuzzleTiles15 instance = null;
        instance = puzzleService.getPuzzleById(fakeId.toString());
        if(Objects.isNull(instance)){
            System.out.println("The puzzle with ID "+fakeId+" doesn't exists");
            assertEquals(instance, obj);
        }
    }
    
    @Test
    public void testEqualsObject() {
        System.out.println("Retrieve object");
        PuzzleTiles15 obj = null;
        PuzzleTiles15 instance = null;
        instance = PuzzleTools.generatePuzzle();
        puzzleService.saveOrUpdate(instance);
        obj = puzzleService.getPuzzleById(instance.getId());
        assertEquals(instance.id, obj.id);
    }
    
}
