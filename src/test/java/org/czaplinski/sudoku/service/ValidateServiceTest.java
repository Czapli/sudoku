package org.czaplinski.sudoku.service;

import org.czaplinski.sudoku.domain.Board;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ValidateServiceTest {
@Autowired
ValidateService validate;
@Autowired
SudokuService service;
    @Test
    void validateNumber() {
        Board board = new Board();
        service.removeNumberFromPossibleLists(board,2,1,1);
        assertTrue(validate.validateNumber(board, 1,1,1));
        assertFalse(validate.validateNumber(board, 2,1,1));
    }
}