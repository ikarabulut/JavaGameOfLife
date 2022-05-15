package com.ikarabulut;

import java.util.List;
import java.util.ArrayList;

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
        List<ArrayList> generatedBoard = new ArrayList<>();
        for (int row = 0; row < rows; row++) {
            generatedBoard.add(new ArrayList<Cell>());
            for (int column = 0; column < columns; column++) {
                ArrayList<Cell> currentRow = generatedBoard.get(row);
                currentRow.add(new Cell());
            }
        }
        return generatedBoard;
    }

    public void generateRandomBoard() {
        for (ArrayList<Cell> boardRow : board) {
            for (Cell cell : boardRow) {
                if (Math.random() > 0.5) {
                    cell.setIsAlive(true);
                } else {
                    cell.setIsAlive(false);
                }
            }
        }
    }

    public List<ArrayList> getBoard() {
        return board;
    }

    //TODO: Remove this, its not used
    public void setBoard(List<ArrayList> newBoard) { board = newBoard; }

    public int getRows() { return rows; };

    public int getColumns() { return columns; }

    public void setAliveAt(int row, int col) {
        Cell selectedCell = getCell(row, col);
        selectedCell.setIsAlive(true);
    }

    public void setDeadAt(int row, int col) {
        Cell selectedCell = getCell(row, col);
        selectedCell.setIsAlive(false);
    }

    public boolean isCellAliveAt(int row, int col) {
        Cell selectedCell = getCell(row, col);
        return selectedCell.checkIfAlive();
    }

    public int getNumberOfAliveNeighbors(int row, int col) {
        int numOfAliveNeighbors = 0;
        List<Cell> neighborsList = getNeighborsOf(row, col);

        for (Cell neighbor : neighborsList) {
            if (neighbor.checkIfAlive()) {
                numOfAliveNeighbors++;
            }
        }
        return numOfAliveNeighbors;
    }

    // PRIVATE METHODS
    private List<Cell> getNeighborsOf(int row, int col) {
        List<Cell> neighborsList = new ArrayList<>();

        neighborsList.add(topLeftNeighbor(row, col));
        neighborsList.add(topNeighbor(row, col));
        neighborsList.add(topRightNeighbor(row, col));
        neighborsList.add(leftNeighbor(row, col));
        neighborsList.add(rightNeighbor(row, col));
        neighborsList.add(bottomLeftNeighbor(row, col));
        neighborsList.add(bottomNeighbor(row, col));
        neighborsList.add(bottomRightNeighbor(row, col));

        return neighborsList;
    }

    private Cell topLeftNeighbor(int row, int col) {
        Cell topLeftNeighbor;
        if (row == 0 && col == 0) {
            topLeftNeighbor = getCell(rows - 1, columns - 1);
        } else if (row == 0) {
            topLeftNeighbor = getCell(rows - 1, col - 1);
        } else if (col == 0) {
            topLeftNeighbor = getCell(row - 1, columns - 1);
        } else {
            topLeftNeighbor = getCell(row - 1, col - 1);
        }
        return topLeftNeighbor;
    }

    private Cell topNeighbor(int row, int col) {
        Cell topNeighbor;
        if (row == 0) {
            topNeighbor = getCell(rows - 1, col);
        } else {
            topNeighbor = getCell(row - 1, col);
        }
        return topNeighbor;
    }

    private Cell topRightNeighbor(int row, int col) {
        Cell topRightNeighbor;
        if (row == 0 && col == columns - 1) {
            topRightNeighbor = getCell(rows - 1, 0);
        } else if (col == columns - 1) {
            topRightNeighbor = getCell(row - 1, 0);
        } else if (row == 0) {
            topRightNeighbor = getCell(rows - 1, col + 1);
        } else {
            topRightNeighbor = getCell(row - 1, col + 1);
        }
        return topRightNeighbor;
    }

    private Cell leftNeighbor(int row, int col) {
        Cell leftNeighbor;
        if (col == 0) {
            leftNeighbor = getCell(row, columns - 1);
        } else {
            leftNeighbor = getCell(row, col - 1);
        }
        return leftNeighbor;
    }

    private Cell rightNeighbor(int row, int col) {
        Cell rightNeighbor;
        if (col == columns - 1) {
            rightNeighbor = getCell(row, 0);
        } else {
            rightNeighbor = getCell(row, col + 1);
        }
        return rightNeighbor;
    }

    private Cell bottomLeftNeighbor(int row, int col) {
        Cell bottomLeftNeighbor;
        if (row == rows - 1 && col == 0) {
            bottomLeftNeighbor = getCell(0, columns - 1);
        } else if (row == rows - 1) {
            bottomLeftNeighbor = getCell(0, col - 1);
        } else if (col == 0) {
            bottomLeftNeighbor = getCell(row + 1, columns - 1);
        } else {
            bottomLeftNeighbor = getCell(row + 1, col - 1);
        }
        return bottomLeftNeighbor;
    }

    private Cell bottomNeighbor(int row, int col) {
        Cell bottomNeighbor;
        if (row == rows - 1) {
            bottomNeighbor = getCell(0, col);
        } else {
            bottomNeighbor = getCell(row + 1, col);
        }
        return bottomNeighbor;
    }

    private Cell bottomRightNeighbor(int row, int col) {
        Cell bottomRightNeighbor;
        if (row == rows - 1 && col == columns - 1) {
            bottomRightNeighbor = getCell(0, 0);
        } else if (col == columns - 1) {
            bottomRightNeighbor = getCell(row + 1, 0);
        } else if (row == rows - 1) {
            bottomRightNeighbor = getCell(0, col + 1);
        } else {
            bottomRightNeighbor = getCell(row + 1, col + 1);
        }
        return bottomRightNeighbor;
    }

    //TODO: Move this to the public methods
    public Cell getCell(int row, int col) {
        ArrayList<Cell> rowList = board.get(row);
        return rowList.get(col);
    }

}
