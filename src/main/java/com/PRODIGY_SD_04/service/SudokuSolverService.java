package com.PRODIGY_SD_04.service;

import org.springframework.stereotype.Service;

@Service
public class SudokuSolverService {

    public boolean solveSudoku(int[][] grid) {
        return solve(grid);
    }

    private boolean solve(int[][] grid) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (grid[row][col] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (isSafe(grid, row, col, num)) {
                            grid[row][col] = num;
                            if (solve(grid)) {
                                return true;
                            }
                            grid[row][col] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isSafe(int[][] grid, int row, int col, int num) {
        for (int x = 0; x < 9; x++) {
            if (grid[row][x] == num || grid[x][col] == num ||
                    grid[row - row % 3 + x / 3][col - col % 3 + x % 3] == num) {
                return false;
            }
        }
        return true;
    }
}
