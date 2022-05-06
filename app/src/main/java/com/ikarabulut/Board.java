package com.ikarabulut;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Board {

    // CONSTRUCTORS
    private int rows;
    private int columns;
    private List<ArrayList> board;

    public Board() {
        rows = 10;
        columns = 10;
        board = generateDeadBoard();
    }

    public Board(int numOfRows, int numOfColumns) {
        rows = numOfRows;
        columns = numOfColumns;
        board = generateDeadBoard();
    }

    // PUBLIC METHODS
    public List<ArrayList> generateDeadBoard() {
        board = new ArrayList<ArrayList>();
        for (int i = 0; i < columns; i++) {
            board.add(new ArrayList<Cell>());
            for (int i2 = 0; i2 < rows; i2++) {
                ArrayList<Cell> currentRow = board.get(i);
                currentRow.add(new Cell());
            }
        }
        return board;
    }

    public void generateRandomBoard() {
        for ( ArrayList<Cell> boardRow : board) {
            for ( Cell cell : boardRow) {
                if (Math.random() > 0.5) {
                    cell.die();
                } else {
                    cell.reviveMe();
                }
            }
        }
    }

    public List<ArrayList> getBoard() {
        return board;
    }

    public void setAliveAt(int rowNum, int colNum) {
        Cell selectedCell = getCell(rowNum, colNum);
        selectedCell.reviveMe();
    }

    public boolean isCellAliveAt(int rowNum, int colNum) {
        Cell selectedCell = getCell(rowNum, colNum);
        return selectedCell.checkIfAlive();
    }

    public int getNumberOfAliveNeighbors(int rowNum,int colNum) {
        int numOfAliveNeighbors = 0;
        List<Cell> neighborsList = getNeighborsOf(rowNum, colNum);

        for (Cell neighbor : neighborsList) {
            if (neighbor.checkIfAlive()) {
                numOfAliveNeighbors++;
            }
        }
        return numOfAliveNeighbors;
    }

    // PRIVATE METHODS
    private List<Cell> getNeighborsOf(int rowNum, int colNum) {
        List<Cell> neighborsList = new ArrayList<>();

        neighborsList.add(topLeftNeighbor(rowNum, colNum));
        neighborsList.add(topNeighbor(rowNum, colNum));
        neighborsList.add(topRightNeighbor(rowNum, colNum));
        neighborsList.add(leftNeighbor(rowNum, colNum));
        neighborsList.add(rightNeighbor(rowNum, colNum));
        neighborsList.add(bottomLeftNeighbor(rowNum, colNum));
        neighborsList.add(bottomNeighbor(rowNum, colNum));
        neighborsList.add(bottomRightNeighbor(rowNum, colNum));

        return neighborsList;
    }

    private Cell topLeftNeighbor(int rowNum, int colNum) {
        Cell topLeftNeighbor;
        if (rowNum == 0 && colNum == 0) {
            topLeftNeighbor = getCell(rows - 1, columns - 1);
        } else if (rowNum == 0) {
            topLeftNeighbor = getCell(rows - 1, colNum - 1);
        } else {
            topLeftNeighbor = getCell(rowNum - 1, colNum - 1);
        }
        return topLeftNeighbor;
    }
    private Cell topNeighbor(int rowNum, int colNum) {
        Cell topNeighbor;
        if (rowNum == 0) {
            topNeighbor = getCell(rows - 1, colNum);
        } else {
            topNeighbor = getCell(rowNum - 1, colNum);
        }
        return topNeighbor;
    }

    private Cell topRightNeighbor(int rowNum, int colNum) {
        Cell topRightNeighbor;
        if (rowNum == 0 && colNum == columns - 1) {
            topRightNeighbor = getCell(rows - 1, 0);
        } else if (colNum == columns - 1) {
            topRightNeighbor = getCell(rowNum - 1, 0);
        } else if (rowNum == 0) {
            topRightNeighbor = getCell(rows - 1, colNum + 1);
        } else {
            topRightNeighbor = getCell(rowNum - 1, colNum + 1);
        }
        return topRightNeighbor;
    }

    private Cell leftNeighbor(int rowNum, int colNum) {
        Cell leftNeighbor;
        if (colNum == 0) {
            leftNeighbor = getCell(rowNum, columns - 1);
        } else {
            leftNeighbor = getCell(rowNum, colNum - 1);
        }
        return leftNeighbor;
    }

    private Cell rightNeighbor(int rowNum, int colNum) {
        Cell rightNeighbor;
        if (colNum == columns - 1) {
            rightNeighbor = getCell(rowNum, 0);
        } else {
            rightNeighbor = getCell(rowNum, colNum + 1);
        }
        return rightNeighbor;
    }

    private Cell bottomLeftNeighbor(int rowNum, int colNum) {
        Cell bottomLeftNeighbor;
        if (rowNum == rows - 1 && colNum == 0) {
            bottomLeftNeighbor = getCell(0, columns - 1);
        } else if (rowNum == rows - 1) {
            bottomLeftNeighbor = getCell(0, colNum - 1);
        } else if (colNum == 0) {
            bottomLeftNeighbor = getCell(rowNum + 1, columns - 1);
        } else {
            bottomLeftNeighbor = getCell(rowNum + 1, colNum - 1);
        }
        return bottomLeftNeighbor;
    }

    private Cell bottomNeighbor(int rowNum, int colNum) {
        Cell bottomNeighbor;
        if (rowNum == rows - 1) {
            bottomNeighbor = getCell(0, colNum);
        } else {
            bottomNeighbor = getCell(rowNum + 1, colNum);
        }
        return bottomNeighbor;
    }

    private Cell bottomRightNeighbor(int rowNum, int colNum) {
        Cell bottomRightNeighbor;
        if (rowNum == rows - 1 && colNum == columns - 1) {
            bottomRightNeighbor = getCell(0, 0);
        } else if (colNum == columns - 1) {
            bottomRightNeighbor = getCell(rowNum + 1, 0);
        } else if (rowNum == rows - 1) {
            bottomRightNeighbor = getCell(0, colNum + 1);
        } else {
            bottomRightNeighbor = getCell(rowNum + 1, colNum + 1);
        }
        return bottomRightNeighbor;
    }

    private Cell getCell(int rowNum, int colNum) {
        ArrayList<Cell> rowList = board.get(rowNum);
        Cell selectedCell = rowList.get(colNum);
        return selectedCell;
    }

}
