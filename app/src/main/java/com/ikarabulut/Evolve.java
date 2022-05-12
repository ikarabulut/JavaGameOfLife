package com.ikarabulut;

import java.util.ArrayList;
import java.util.List;

public class Evolve {
    private Board board;
    private Board nextBoard;

    public Evolve(Board board) {
        this.board = board;
        this.nextBoard = new Board(board.getRows(), board.getColumns());
    }

    public List<ArrayList> getNextBoard() {
        return this.nextBoard.getBoard();
    }

    public void generateNextBoard() {
        for (int row = 0; row < board.getRows(); row++) {
            for (int column = 0; column < board.getColumns(); column++) {
                int currentCellNumOfAliveNeighbors = board.getNumberOfAliveNeighbors(row, column);
                boolean currentCellIsAlive = board.isCellAliveAt(row, column);
                boolean nextGenerationStatus = Rules.determineFate(currentCellNumOfAliveNeighbors, currentCellIsAlive);
                if (nextGenerationStatus) {
                    nextBoard.setAliveAt(row, column);
                } else {
                    nextBoard.setDeadAt(row, column);
                }
            }
        }
    }

}
