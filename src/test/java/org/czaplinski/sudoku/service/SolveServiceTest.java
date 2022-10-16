package org.czaplinski.sudoku.service;

import org.czaplinski.sudoku.domain.Board;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.stereotype.Service;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SolveServiceTest {
    @Autowired
    SudokuService service;

    @Test
    void createBoardTest() {
        Board board = new Board();
        board.getFiled(0, 0).setNumber(1);
        board.getFiled(0, 1).setNumber(2);
        board.getFiled(0, 2).setNumber(3);
        service.printBoard(board);
    }

    @Test
    void test() {
        Board board = new Board();
        int row = 5;
        int column = 5;
        int number = 1;
        int boxRow = row - row % 3;
        int boxColumn = column - column % 3;
        for (int i = 0; i < 9; i++) {
            board.getFiled(i, column).setNumber(number);
            board.getFiled(row, i).setNumber(number);
        }
        for (int i = boxRow; i < boxRow + 3; i++) {
            for (int j = boxColumn; j < boxColumn + 3 ; j++) {
                board.getFiled(i, j).setNumber(number);
            }
        }
        service.printBoard(board);
    }
}