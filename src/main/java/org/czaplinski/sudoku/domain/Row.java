package org.czaplinski.sudoku.domain;

import java.util.ArrayList;
import java.util.List;

public class Row{
    List<Filed> fileds;

    public Row() {
        fileds = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            fileds.add(new Filed());
        }
    }

    public List<Filed> getFileds() {
        return fileds;
    }
}
