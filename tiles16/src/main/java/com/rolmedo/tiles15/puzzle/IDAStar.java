/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rolmedo.tiles15.puzzle;

import com.rolmedo.tiles15.tools.PuzzleParams;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;

/**
 *
 * @author ruben
 */

public class IDAStar {
	int blankPosition = 0;
	// visitedNodes: to avoid the visiting parent node/ duplicate node
	HashMap<String, String> visitedNodes = new HashMap<String, String>();
	LinkedHashMap<String, String> pathNodes = new LinkedHashMap<String, String>();
	int visited = 0;
      /*Iterative deepening method */
	public Set<String> ida(PuzzleNode startNode) {
		visitedNodes.clear();
		PuzzleNode initNode = startNode;
		int fValueMin;
		/*fValueMin depth to run the program.
		IDA* method being called iteratively until the depth reaches*/
		for (fValueMin = initNode.getfValue(); fValueMin < 100; fValueMin++) {
                        System.out.println("Iteration:" + fValueMin);
			visitedNodes.clear();
			pathNodes.clear();
			// Depth First search 
			PuzzleNode nextNode = dfs(startNode, fValueMin, visitedNodes);
			/*Verifying the returned is goal state or not. If it is goal the goal exit loop*/
			if (nextNode != null && nextNode.equals(PuzzleParams.GOAL_STATE)) {
				System.out.println("Goal state Found::");
				System.out.println("Nodes Visited:" + visited);
				return pathNodes.keySet();
			}
			
		}
		System.out.println("Number of Nodes Visited:" + visited);
		return null;
	}

	public PuzzleNode dfs(PuzzleNode node, int fValueMin,
			HashMap<String, String> visitedNodes) {
		visited++;
		if (node != null) {
			// Keep track of visited node of each Ida iteration
			visitedNodes.put(IDAStarHelper.convertToString(node.getPuzzle()), null);
			pathNodes.put(IDAStarHelper.convertToString(node.getPuzzle()), null);
		}
		// verifying goal state or not
		if (node != null && node.equals(PuzzleParams.GOAL_STATE)) {
			return node;
		}
         /*Verifies node f value with Iterative IDA depth.
		if it reaches more value assuming no solution in this iteration.*/
		if (node.getfValue() > fValueMin) {
                        System.out.println("This iteration doesn't return solution");
			return null;
		}
		// Fetching valid moves to current puzzle.
		ArrayList<String> moves = getMoves(node.getPuzzle());
		PuzzleNode test = null;
		for (String move : moves) {
			// creating new puzzle for valid move.
			PuzzleNode newNode = IDAStarHelper.moveTiles(move, node);
			if (!visitedNodes.containsKey(IDAStarHelper
					.convertToString(newNode.getPuzzle()))) {
				// if new puzzele not visited already, run recursive dfs
				test = dfs(newNode, fValueMin, visitedNodes);
				if (test != null)
					return test;
				// visitedNodes.remove(IDAStarHelper.convertToString(node.puzzle));
				pathNodes.remove(IDAStarHelper.convertToString(node.getPuzzle()));
			}
             // If reaches max fValueMin. undoing the step.
                        System.out.println("fValue reached: going back");
			IDAStarHelper.backTrackMove(node, move);
		}

		return null;
	}
   /*This method is used to fetch all valid moves for given puzzle*/
	private ArrayList<String> getMoves(ArrayList<Integer> puzzle) {
		blankPosition = PuzzleParams.findBlankPos(puzzle);
		ArrayList<String> validMoves = IDAStarHelper.getMoves(blankPosition);
		return validMoves;
	}

}