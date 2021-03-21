/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rolmedo.tiles15.puzzle;
import com.rolmedo.tiles15.tools.PuzzleParams;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author ruben
 */
public class IDAStarHelper {
    
	public static ArrayList<String> getMoves(int position) {
		ArrayList<String> invalidMove = new ArrayList<String>();
		ArrayList<String> allMoves = new ArrayList<String>();
		ArrayList<String> validMoves = new ArrayList<String>();
		allMoves.add("D");
		allMoves.add("U");
		allMoves.add("R");
		allMoves.add("L");
                
		if (PuzzleParams.TILTES_SIZE == 16) {
			if (position < 4)
				invalidMove.add("D");
			if (position > 11)
				invalidMove.add("U");
			if (position % 4 == 0)
				invalidMove.add("R");
			if (position % 4 == 3)
				invalidMove.add("L");
		}
		for (String move : allMoves) {
			if (!invalidMove.contains(move))
				validMoves.add(move);
		}
		return validMoves;
	}

	public static PuzzleNode moveTiles(String move, PuzzleNode node) {
		PuzzleNode n = node;
		int position = PuzzleParams.findBlankPos(n.getPuzzle());
		int swapIndex = 0;
		ArrayList<Integer> newPuzzle = n.getPuzzle();
		
			if (move == "U")
				swapIndex = position + 4;
			if (move == "D")
				swapIndex = position - 4;
			if (move == "L")
				swapIndex = position + 1;
			if (move == "R")
				swapIndex = position - 1;

		
		int temp = newPuzzle.get(swapIndex);
                int temp2 = newPuzzle.get(position);
                newPuzzle.set(swapIndex, temp2);
                newPuzzle.set(position, temp);
		PuzzleNode newNode = new PuzzleNode(n.getCost() + 1, n.getmDistance(),
				n.getfValue(), newPuzzle);
		return newNode;

	}

	public static PuzzleNode backTrackMove(PuzzleNode node, String move) {
		int blankPosition = PuzzleParams.findBlankPos(node.getPuzzle());
		int swap = 0;
                        if (move == "L")
				swap = blankPosition - 1;
			if (move == "R")
				swap = blankPosition + 1;
			if (move == "U")
				swap = blankPosition - 4;
			if (move == "D")
				swap = blankPosition + 4;
		
		int temp = node.getPuzzle().get(swap);
                int temp2 = node.getPuzzle().get(blankPosition);
                node.getPuzzle().set(swap, temp2);
                node.getPuzzle().set(blankPosition, temp);
		return node;
	}


	public static String convertToString(ArrayList<Integer> puzzle) {
		String puzzleString = "";
		for (int i : puzzle) {
			puzzleString = puzzleString + i + ",";
		}
		return puzzleString;
	}

        //adapt to json
	public static void printArray(Set<String> pathVisited) {
        System.out.println("Total no of moves:"+pathVisited.size());
		for (String path : pathVisited) {
			String[] puzzle = path.split(",");
			 
				System.out.println(puzzle[0] + "\t" + puzzle[1] + "\t"
						+ puzzle[2] + "\t" + puzzle[3]);
				System.out.println(puzzle[4] + "\t" + puzzle[5] + "\t"
						+ puzzle[6] + "\t" + puzzle[7]);
				System.out.println(puzzle[8] + "\t" + puzzle[9] + "\t"
						+ puzzle[10] + "\t" + puzzle[11]);
				System.out.println(puzzle[12] + "\t" + puzzle[13] + "\t"
						+ puzzle[14] + "\t" + puzzle[15]);
				System.out.println();
				System.out.println("----------------------");
			
		}
	}
}