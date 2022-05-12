package com.ikarabulut;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board currentBoard;

    public Game(Board board) {
        currentBoard = board;
    }

    public void generateNextBoard() {
        List<ArrayList> nextBoard = new ArrayList<>();
        for (int row = 0; row < currentBoard.getRows(); row++) {
            nextBoard.add(new ArrayList<Cell>());
            for (int column = 0; column < currentBoard.getColumns(); column++) {
                ArrayList<Cell> currentRow = nextBoard.get(row);
                int currentCellNumOfAliveNeighbors = currentBoard.getNumberOfAliveNeighbors(row, column);
                boolean currentCellIsAlive = currentBoard.isCellAliveAt(row, column);
                boolean willBeAliveNextGeneration = Rules.willBeAliveNextGeneration(currentCellNumOfAliveNeighbors, currentCellIsAlive);
                currentRow.add(new Cell(willBeAliveNextGeneration));
            }
        }
        currentBoard.setBoard(nextBoard);
    }

}
