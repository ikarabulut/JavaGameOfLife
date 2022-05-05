package com.ikarabulut;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Board {

    private int rows;
    private int columns;
    private List<ArrayList> grid;

    public Board() {
        rows = 10;
        columns = 10;
        grid = setGrid();
    }

    public Board(int numOfRows, int numOfColumns) {
        rows = numOfRows;
        columns = numOfColumns;
        grid = setGrid();
    }

    public List<ArrayList> setGrid() {
        grid = new ArrayList<ArrayList>();
        for (int i = 0; i < columns; i++) {
            grid.add(new ArrayList<Cell>());
            for (int i2 = 0; i2 < rows; i2++) {
                ArrayList<Cell> currentRow = grid.get(i);
                currentRow.add(new Cell());
            }
        }
        return grid;
    }

    public void setRandomGrid() {
        for ( ArrayList<Cell> gridRow : grid) {
            for ( Cell cell : gridRow) {
                if (Math.random() > 0.5) {
                    cell.die();
                } else {
                    cell.reviveMe();
                }
            }
        }
    }

    public List<ArrayList> getGrid() {
        return grid;
    }
}
