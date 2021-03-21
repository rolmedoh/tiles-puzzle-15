/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rolmedo.tiles16.puzzle;

import java.util.ArrayList;
import org.junit.Ignore;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ruben
 */
public class PuzzleNodeTest {
    
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
        PuzzleNode expResult = null;
        PuzzleNode result = PuzzleNode.generatePuzzleNode();
        System.out.println(result.getPuzzle().toString());
        assertNotEquals(expResult, result);
    }

    /**
     * Test of getPuzzle method, of class PuzzleNode.
     */
    @Test
    public void testGetPuzzles() {
        System.out.println("getPuzzles");
        PuzzleNode expResult = null;
        PuzzleNode result = null;
        for(int i = 0; i < 10; i++){
             result = PuzzleNode.generatePuzzleNode();
             System.out.println(result.getPuzzle().toString() + " Puzzle Hash: " + result.hashCode());
        }
        assertNotEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class PuzzleNode.
     */
    @Ignore
    public void testHashCode() {
        System.out.println("hashCode");
        PuzzleNode instance = null;
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class PuzzleNode.
     */
    @Ignore
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        PuzzleNode instance = null;
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
