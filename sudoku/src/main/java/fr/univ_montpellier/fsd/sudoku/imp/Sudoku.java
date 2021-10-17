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
        final int total = n * (n + 1) / 2;
        for (int i = 0; i < this.n; i++) {
            int sum = 0;
            final Set<Integer> rowNumbers = new HashSet<>();
            for (int j = 0; j < this.n; j++) {
                int number = this.grid[i][j];
                rowNumbers.add(number);
                sum += number;
            }

            if(rowNumbers.size() != this.n || sum != total) return false;
        }

        for(int j = 0; j < this.n; j++) {
            int sum = 0;
            final Set<Integer> colNumbers = new HashSet<>();
            for(int i = 0; i < this.n; i++) {
                int number = this.grid[i][j];
                colNumbers.add(number);
                sum += number;
            }

            if(colNumbers.size() != this.n || sum != total) return false;
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
