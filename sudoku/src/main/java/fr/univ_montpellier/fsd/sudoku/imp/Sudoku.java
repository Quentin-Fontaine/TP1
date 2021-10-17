package fr.univ_montpellier.fsd.sudoku.imp;

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
		return checkColRow(false) && checkColRow(true) && checkSquare();
	}

	private boolean checkColRow(boolean isColumn) {
		for(int i = 0; i < this.n; i++) {
			Set<Integer> numbers = new HashSet<>();
			for(int j = 0; j < this.n; j++) {
				numbers.add(isColumn ? this.grid[j][i] : this.grid[i][j]);
			}
			if(numbers.size() != this.n) return false;
		}
		return true;
	}

	private boolean checkSquare() {
		for (int i = 0; i < this.n; i += this.s) {
			for (int j = 0; j < this.n; j += this.s) {
				Set<Integer> numbers = new HashSet<>();
				for (int k = i; k < i + this.s; k++) {
					for (int l = j; l < j + this.s; l++) {
						numbers.add(this.grid[k][l]);
					}
				}
				if(numbers.size() != this.n) return false;
			}
		}
		return true;
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
