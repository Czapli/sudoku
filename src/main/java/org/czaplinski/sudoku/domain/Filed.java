package org.czaplinski.sudoku.domain;

import java.util.ArrayList;
import java.util.List;

public class Filed {
    private Integer number;
    private List<Integer> possibleNumbers;

    public Filed() {
        number = null;
        possibleNumbers = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            possibleNumbers.add(i);
        }
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public List<Integer> getPossibleNumbers() {
        return possibleNumbers;
    }

    public void setPossibleNumbers(List<Integer> possibleNumbers) {
        this.possibleNumbers = possibleNumbers;
    }
}
