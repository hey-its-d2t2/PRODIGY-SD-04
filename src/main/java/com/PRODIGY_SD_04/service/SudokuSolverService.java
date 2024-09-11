package com.PRODIGY_SD_04.service;

import org.springframework.stereotype.Service;

@Service
public class SudokuSolverService {

    // Public method to solve the Sudoku puzzle
    public boolean solveSudoku(int[][] board) {
        return solve(board);
    }

    // Recursive backtracking method to solve the board
    private boolean solve(int[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == 0) { // Empty cell
                    for (int num = 1; num <= 9; num++) { // Try numbers 1-9
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;
                            if (solve(board)) { // Recursive call
                                return true;
                            }
                            board[row][col] = 0; // Backtrack if solution is incorrect
                        }
                    }
                    return false; // Trigger backtracking
                }
            }
        }
        return true; // Puzzle solved
    }

    // Helper method to check if placing a number is valid
    private boolean isValid(int[][] board, int row, int col, int num) {
        // Check the row for duplicate
        for (int x = 0; x < 9; x++) {
            if (board[row][x] == num) {
                return false;
            }
        }

        // Check the column for duplicate
        for (int x = 0; x < 9; x++) {
            if (board[x][col] == num) {
                return false;
            }
        }

        // Check the 3x3 subgrid for duplicate
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int x = startRow; x < startRow + 3; x++) {
            for (int y = startCol; y < startCol + 3; y++) {
                if (board[x][y] == num) {
                    return false;
                }
            }
        }

        return true; // Valid move
    }
}
