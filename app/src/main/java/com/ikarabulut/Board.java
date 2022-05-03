package com.ikarabulut;

import java.util.ArrayList;
import java.util.Collections;

public class Board {

    public int rows;
    public int columns;
    public ArrayList<ArrayList> grid = new ArrayList<ArrayList>();

    public Board() {
        rows = 10;
        columns = 10;
    }

    public Board(int numOfRows, int numOfColumns) {
        rows = numOfRows;
        columns = numOfColumns;
    }

    public void setGrid() {
        for (int i = 0; i < rows; i++) {
            grid.add(new ArrayList<Object>(Collections.nCopies(columns, "X")));
        }
    }

    public ArrayList<ArrayList> getGrid() {
        return grid;
    }
}
