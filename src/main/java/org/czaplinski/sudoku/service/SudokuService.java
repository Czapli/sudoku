package org.czaplinski.sudoku.service;

import org.czaplinski.sudoku.domain.Board;
import org.springframework.stereotype.Service;

@Service
public class SudokuService {
    private final ValidateService validate;
    private final SolveService solve;

    public SudokuService(ValidateService validate, SolveService solve) {
        this.validate = validate;
        this.solve = solve;
    }

    public boolean addNumberToBoard(Board board, int number, int row, int column) {
        if (validate.validateNumber(board, number, row, column)) {
            removeNumberFromPossibleLists(board, number, row, column);
            board.setNumberToFiled(number, row, column);
            return true;
        }
        return false;
    }

    public void removeNumberFromPossibleLists(Board board, int number, int row, int column) {
        int boxRow = row - row % 3;
        int boxColumn = column - column % 3;
        for (int i = 0; i < 9; i++) {
            board.getFiled(i, column).getPossibleNumbers().remove((Integer)number);
            board.getFiled(row, i).getPossibleNumbers().remove((Integer)number);
        }
        for (int i = boxRow; i < boxRow + 3; i++) {
            for (int j = boxColumn; j < boxColumn +3; j++) {
                board.getFiled(i, j).getPossibleNumbers().remove((Integer) number);
            }
        }
    }

    public void printBoard(Board board) {
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                String number;
                if (board.getFiled(row, column).getNumber() == null) {
                    number = " ";
                } else {
                    number = String.valueOf(board.getFiled(row, column).getNumber());
                }
                System.out.print("|" + number + (column == 8 ? "|" : ""));
            }
            System.out.println();
        }
        System.out.println();
    }
}
