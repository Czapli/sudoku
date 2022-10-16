package org.czaplinski.sudoku.service;

import org.czaplinski.sudoku.domain.Board;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SudokuServiceTest {
    @Autowired
    private SudokuService sudokuService;

    @Test
    void removeNumberFromPossibleListsTest() {
        //given
        Board board = new Board();

        //when
        sudokuService.removeNumberFromPossibleLists(board, 1, 5, 5);

        //then

        assertFalse(board.getFiled(5, 5).getPossibleNumbers().contains(1));
        assertFalse(board.getFiled(4, 4).getPossibleNumbers().contains(1));
        assertFalse(board.getFiled(1, 5).getPossibleNumbers().contains(1));
        assertFalse(board.getFiled(5, 1).getPossibleNumbers().contains(1));
    }

    @Test
    void addNumberProperToBoardTest() {
        //given
        Board board = new Board();

        //when
        sudokuService.addNumberToBoard(board, 1, 5, 5);

        //then
        sudokuService.printBoard(board);
        assertEquals(1, board.getFiled(5,5).getNumber());
        assertFalse(board.getFiled(3, 3).getPossibleNumbers().contains(1));
        assertFalse(board.getFiled(4, 4).getPossibleNumbers().contains(1));
        assertFalse(board.getFiled(1, 5).getPossibleNumbers().contains(1));
        assertFalse(board.getFiled(5, 1).getPossibleNumbers().contains(1));
    }
    @Test
    void addNumberWrongToBoardTest(){
        //Given
        Board board = new Board();
        //then
        boolean shouldBeTrue = sudokuService.addNumberToBoard(board, 1, 1, 1);
        boolean shouldBeFalse1 = sudokuService.addNumberToBoard(board, 1, 1, 2);
        boolean shouldBeFalse2 = sudokuService.addNumberToBoard(board, 1, 2, 1);
        boolean shouldBeFalse3 = sudokuService.addNumberToBoard(board, 1, 0, 0);
        //when
//        assertTrue(shouldBeTrue);
//        assertFalse(shouldBeFalse1);
//        assertFalse(shouldBeFalse2);
//        assertFalse(shouldBeFalse3);
        sudokuService.printBoard(board);
    }
}