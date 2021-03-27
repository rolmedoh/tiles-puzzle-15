/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rolmedo.tiles15.puzzle;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ruben
 */
@Service
public class PuzzleService {
    
    @Autowired
    PuzzleRepository puzzleRepository;

    public List<Puzzle> getAllPuzzle() {
        List<Puzzle> puzzles = new ArrayList<Puzzle>();
        puzzleRepository.findAll().forEach(puzzle -> puzzles.add(puzzle));
        return puzzles;
    }

    public Puzzle getPuzzleById(String id) {
        return puzzleRepository.findById(id).get();
    }

    public void saveOrUpdate(Puzzle puzzle) {
         System.out.println("LLega 2"+puzzle);
        puzzleRepository.save(puzzle);
    }

    public void delete(String id) {
        puzzleRepository.deleteById(id);
    }
}
