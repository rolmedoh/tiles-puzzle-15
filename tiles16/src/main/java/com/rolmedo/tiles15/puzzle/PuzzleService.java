/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rolmedo.tiles15.puzzle;

import com.rolmedo.tiles15.tools.PuzzleTools;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
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

    public List<PuzzleTiles15> getAllPuzzle() {
        List<PuzzleTiles15> puzzles = new ArrayList<>();
        puzzleRepository.findAll().forEach(puzzle -> puzzles.add(puzzle));
        return puzzles;
    }

    public PuzzleTiles15 getPuzzleById(String id) {    
        try{
            return puzzleRepository.findById(id).get();
        }catch(NoSuchElementException ex){
            PuzzleTools.LOGGER.info("DB error -> Element do not exists: ID " + id);
            return null;
        }
    }

    public void saveOrUpdate(PuzzleTiles15 puzzle) {
        puzzleRepository.save(puzzle);
    }

    public void delete(String id) {
        puzzleRepository.deleteById(id);
    }
}
