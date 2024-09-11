package com.PRODIGY_SD_04.controller;

import com.PRODIGY_SD_04.model.Sudoku;
import com.PRODIGY_SD_04.service.SudokuSolverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SudokuController {

    @Autowired
    private SudokuSolverService sudokuService;

    @GetMapping("/")
    public String home(Model model) {
        Sudoku sudoku = new Sudoku();
        sudoku.initializeEmptyGrid();
        model.addAttribute("sudoku", sudoku);
        return "sudoku";
    }

    @PostMapping("/solve")
    public String solve(@ModelAttribute("sudoku") Sudoku sudoku, Model model) {
        int[][] grid = sudoku.getGrid();
        boolean solved = sudokuService.solveSudoku(grid);
        sudoku.setGrid(grid);
        model.addAttribute("sudoku", sudoku);
        model.addAttribute("solved", solved);
        return "sudoku";
    }
}
