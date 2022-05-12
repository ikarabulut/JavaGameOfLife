package com.ikarabulut;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board currentBoard;
    private Board nextBoard;

    public Game(Board board) {
        currentBoard = board;
        nextBoard = new Board(board.getRows(), board.getColumns());

    }

    public List<ArrayList> getNextBoard() {
        return this.nextBoard.getBoard();
    }

    public void generateNextBoard() {
        for (int row = 0; row < currentBoard.getRows(); row++) {
            for (int column = 0; column < nextBoard.getColumns(); column++) {
                int currentCellNumOfAliveNeighbors = currentBoard.getNumberOfAliveNeighbors(row, column);
                boolean currentCellIsAlive = currentBoard.isCellAliveAt(row, column);
                boolean nextGenerationStatus = Rules.determineFate(currentCellNumOfAliveNeighbors, currentCellIsAlive);
                if (nextGenerationStatus) {
                    nextBoard.setAliveAt(row, column);
                } else {
                    nextBoard.setDeadAt(row, column);
                }
            }
        }
        currentBoard.setBoard(nextBoard.getBoard());
    }

}
