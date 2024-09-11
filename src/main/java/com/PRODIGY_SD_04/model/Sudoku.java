package com.PRODIGY_SD_04.model;

public class Sudoku {
    private int[][] grid = new int[9][9];

    // Getter for grid
    public int[][] getGrid() {
        return grid;
    }

    // Setter for grid
    public void setGrid(int[][] grid) {
        this.grid = grid;
    }

    // Initialize the grid with zeros (for first load)
    public void initializeEmptyGrid() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                grid[i][j] = 0;
            }
        }
    }
}
