package fr.univ_montpellier.fsd.sudoku.imp;

import java.time.Duration;
import java.time.Instant;
import java.util.*;

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
        for (int i = 0; i < n; i++) {

            // Set<> only accept different value.
            Set<Integer> tmp = new HashSet<>();

            // Check columns
            for (int j = 0; j < n; j++) {
                tmp.add(this.grid[i][j]);
            }

            // Check all value different and reset tmp.
            if (tmp.size() != n) return false;
            tmp = new HashSet<>();

            // Check line
            for (int k = 0; k < n; k++) {
                tmp.add(this.grid[k][i]);
            }

            if (tmp.size() != n) return false;

            // Check squares
            for (int l = 0; l < n; l += s) {
                tmp.add(this.grid[i][l]);
            }

            if (tmp.size() != n) return false;
        }

        return true;
    }

    /*
     * Generate a random grid solution
     *
     */

    private void generateSolution() {
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = random.nextInt(n) + 1;
            }
        }
    }

    /*
     * Find a solution to the sudoku problem
     *
     */
    public void findSolution() {
        do { generateSolution(); }
        while (!solutionChecker());
        displaySudoku();
    }

    public void displaySudoku() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("| " + this.grid[i][j] + " ");
                if ((j + 1) % s == 0) {
                    System.out.print("|   ");
                }
            }
            System.out.println();
            if ((i + 1) % s == 0) {
                System.out.println("---------------------------------------------");
            }
        }
    }

    public static void main(String args[]) {
        Sudoku sudoku = new Sudoku(4);
        sudoku.findSolution();
    }
}
