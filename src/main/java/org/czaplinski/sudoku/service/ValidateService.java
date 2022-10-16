package org.czaplinski.sudoku.service;

import org.czaplinski.sudoku.domain.Board;
import org.springframework.stereotype.Service;

@Service
public class ValidateService {
    public boolean validateNumber(Board board, int number, int row, int column) {
        int boxRow = row - row % 3;
        int boxColumn = column - column % 3;
        boolean numberIsGood = true;
        for (int i = 0; i < 9; i++) {
            board.getFiled(i, column).getPossibleNumbers().forEach(System.out::print);
            if (!board.getFiled(i, column).getPossibleNumbers().contains(number)) {
                numberIsGood = false;
            }
            System.out.println();
            board.getFiled(row, i).getPossibleNumbers().forEach(System.out::print);
            if (!board.getFiled(row, i).getPossibleNumbers().contains(number)) {
                numberIsGood = false;
            }
            System.out.println();
        }
        for (int i = boxRow; i < boxRow + 3; i++) {
            for (int j = boxColumn; j < boxColumn + 3; j++) {
                board.getFiled(i, j).getPossibleNumbers().forEach(System.out::print);
                if (!board.getFiled(i, j).getPossibleNumbers().contains(number)) {
                    numberIsGood = false;
                }
                System.out.println();
            }
        }
        return numberIsGood;
    }
}
