package com.PRODIGY_SD_04.model;

public class Sudoku {
    private int[][] grid;

    public Sudoku() {
        this.grid = new int[9][9]; // Initialize a 9x9 grid
    }

    public Sudoku(int[][] grid) {
        this.grid = grid;
    }

    public int[][] getGrid() {
        return grid;
    }

    public void setGrid(int[][] grid) {
        this.grid = grid;
    }
}
