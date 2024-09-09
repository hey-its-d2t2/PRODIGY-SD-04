package com.PRODIGY_SD_04.service;

import org.springframework.stereotype.Service;

@Service
public class SudokuSolverService {
    public boolean solveSudoku(int[][] grid) {
        return solve(grid, 0, 0);
    }

    private boolean solve(int[][] grid, int row, int col) {
        // If we reached the last row
        if (row == 9) return true;

        // Move to the next row if column exceeds 8
        if (col == 9) return solve(grid, row + 1, 0);

        // If the current cell is already filled, move to the next cell
        if (grid[row][col] != 0) return solve(grid, row, col + 1);

        // Try placing numbers 1-9 in the current cell
        for (int num = 1; num <= 9; num++) {
            if (isSafe(grid, row, col, num)) {
                grid[row][col] = num; // Place number
                if (solve(grid, row, col + 1)) return true; // Continue solving
                grid[row][col] = 0; // Backtrack if solution doesn't work
            }
        }
        return false; // Return false if no solution is found
    }

    private boolean isSafe(int[][] grid, int row, int col, int num) {
        // Check if the number is not repeated in the current row, column, or 3x3 sub-grid
        for (int x = 0; x < 9; x++) {
            if (grid[row][x] == num || grid[x][col] == num) return false;
            if (grid[row / 3 * 3 + x / 3][col / 3 * 3 + x % 3] == num) return false;
        }
        return true;
    }
}
