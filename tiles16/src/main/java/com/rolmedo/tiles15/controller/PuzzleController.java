package com.rolmedo.tiles15.controller;

import com.rolmedo.tiles15.puzzle.PuzzleService;
import com.rolmedo.tiles15.puzzle.PuzzleTiles15;
import com.rolmedo.tiles15.request.SolvableRequest;
import com.rolmedo.tiles15.request.SolvableResponse;
import com.rolmedo.tiles15.tools.PuzzleTools;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.util.Map;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ruben
 */
@RestController
@RequestMapping("/api/puzzle/1/")
public class PuzzleController {
    
    @Autowired
    private PuzzleService puzzleService;
    
    @Operation(summary = "Generate Tiles 15 puzzle")
    @ApiResponses(value = { 
      @ApiResponse(responseCode = "200", description = "Puzzle Generated", 
            content = { @Content(mediaType = "application/json", 
            schema = @Schema(example = "")) })
    })
    @PostMapping(path = "/create-puzzle", produces = "application/json")
    public ResponseEntity<String> generatePuzzle(@RequestHeader Map<String, String> headers) {
        try{
            PuzzleTiles15 puzzle = PuzzleTools.generatePuzzle();
            puzzleService.saveOrUpdate(puzzle);
            String json = puzzle.toJson();
            return new ResponseEntity<String>(json, HttpStatus.OK);
        }catch(Exception ex){
           PuzzleTools.LOGGER.warn("Error creating puzzle "+ ex.getMessage() + "\n" + headers.toString());
            return new ResponseEntity<String>("", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @Operation(summary = "Check wheather the puzzle is resolvable")
    @ApiResponses(value = { 
         @ApiResponse(responseCode = "200", description = "Request correct", 
            content = { @Content(mediaType = "application/json", 
            schema = @Schema(implementation = SolvableRequest.class)) })
    })
    @PostMapping(path = "/is-solvable", produces = "application/json")
    public ResponseEntity<String> resolvablePuzzle(@RequestHeader Map<String, String> headers, @RequestBody SolvableRequest request) {
        
        try{
            if(request.checkIdFormat()){
                PuzzleTiles15 puzzle = puzzleService.getPuzzleById(request.getId());
                if(Objects.isNull(puzzle.getSolvable())){
                    puzzle.isSolvable();
                    puzzleService.saveOrUpdate(puzzle);
                }
                SolvableResponse sr = new SolvableResponse(puzzle.getId(),puzzle.getSolvable());
                return new ResponseEntity<String>(sr.toJson(), HttpStatus.OK);
            }else{
                 return new ResponseEntity<String>("", HttpStatus.BAD_REQUEST);
            }
        }catch(Exception ex){
           PuzzleTools.LOGGER.warn("Checking for puzzle "+ ex.getMessage() + "\n" + headers.toString());
           return new ResponseEntity<String>("", HttpStatus.NOT_FOUND);
        }
    }
}
