package com.ikarabulut;

import java.util.ArrayList;
import java.util.List;

public class Evolve {

    private Board board;
    private List<ArrayList> evolvedBoard;

    public Evolve(Board board) {
        this.board = board;
        this.evolvedBoard = new ArrayList<>();
    }

    public Evolve() {
        this.board = new Board();
        this.evolvedBoard = new ArrayList<>();
    }

    public List<ArrayList> generateNextBoard(List<ArrayList> evolvingBoard) {
        for (int row = 0; row < board.getRows(); row++) {
            evolvedBoard.add(new ArrayList<Cell>());
            for (int column = 0; column < board.getColumns(); column++) {
                ArrayList<Cell> currentRow = evolvedBoard.get(row);

                boolean nextGenerationStatus = Rules.determineFate(board.getNumberOfAliveNeighbors(row, column), board.isCellAliveAt(row, column));
                currentRow.add(new Cell(nextGenerationStatus));
            }
        }

        return evolvedBoard;
    }

}
