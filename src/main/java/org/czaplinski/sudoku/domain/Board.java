package org.czaplinski.sudoku.domain;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Row> rows;

    public Board() {
        rows = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            rows.add(new Row());
        }
    }

    public List<Filed> getRow(int numberOfRow) {
        return rows.get(numberOfRow).fileds;
    }

    public List<Filed> getColumn(int numberOfColumn) {
        List<Filed> column = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            column.add(rows.get(i).fileds.get(numberOfColumn));
        }
        return column;
    }

    public Filed getFiled(int numberOfRow, int numberOfColumn) {
        return rows.get(numberOfRow).fileds.get(numberOfColumn);
    }
    public void setNumberToFiled(int number, int numberOfRow, int numberOfColumn){
        getFiled(numberOfRow, numberOfColumn).setNumber(number);
    }
}
