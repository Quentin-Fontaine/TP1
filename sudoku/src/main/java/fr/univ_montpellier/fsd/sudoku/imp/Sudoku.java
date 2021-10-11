package fr.univ_montpellier.fsd.sudoku.imp;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Sudoku {

	int n;
	int s;
	int[][] grid;

	/*
	 * Create an instance of the problem sudoku (nxn)
	 * 
	 */

	public Sudoku(int n) {
		this.n = n;
		this.s = (int) Math.sqrt(n);
		this.grid = new int[n][n];
	}

	/*
	 * check if this.grid is a correct sudoku solution.
	 * 
	 */

	private boolean solutionChecker() {

/*		// check the line
		int line = 0;
		int col = 0;
		int numCase = this.grid[line][col];
		for(int j=line+1; j < n; j++) {
			if (numCase == this.grid[line][j]) return false;
		}

		// check column
		for(int k=0; k < n; k++) {
			if (numCase == this.grid[k][col]) return false;
		}*/

		for (int i=0; i < n; i++) {

			// Set<> only accept different value.
			Set<Integer> tmp = new HashSet<>();

			// Check columns
			for (int j=0; j < n; j++) {
				tmp.add(this.grid[i][j]);
			}

			// Check all value different and reset tmp.
			if (tmp.size() != n) return false;
			tmp = new HashSet<>();

			// Check line
			for (int k=0; k < n; k++) {
				tmp.add(this.grid[k][i]);
			}

			if (tmp.size() != n) return false;

			// Check squares
			for (int l=0; l < n; l+=s) {
				tmp.add(this.grid[i][l]);
			}

			if (tmp.size() != n) return false;
		}
		return false;
	}

	/*
	 * Generate a random grid solution
	 * 
	 */

	private void generateSolution() {
		// TODO

	}

	/*
	 * Find a solution to the sudoku problem
	 * 
	 */
	public void findSolution() {

		// TODO
	}

	public static void main(String args[]) {
		new Sudoku(4).findSolution();

	}
}
