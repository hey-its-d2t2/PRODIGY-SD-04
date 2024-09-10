package com.PRODIGY_SD_04.controller;

import com.PRODIGY_SD_04.model.Sudoku;
import com.PRODIGY_SD_04.service.SudokuSolverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class SudokuController {

    @Autowired
    private SudokuSolverService sudokuSolverService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("sudoku", new Sudoku());
        return "sudoku";
    }

    @PostMapping("/solve")
    public String solveSudoku(@ModelAttribute Sudoku sudoku, Model model) {
        boolean solved = sudokuSolverService.solveSudoku(sudoku.getGrid());
        model.addAttribute("solved", solved);
        model.addAttribute("sudoku", sudoku);
        return "sudoku";
    }
}   
