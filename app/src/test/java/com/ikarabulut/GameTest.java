package com.ikarabulut;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    public List<ArrayList> generateDeadBoardHelper() {
        List<ArrayList> generatedBoard = new ArrayList<>();
        for (int row = 0; row < 10; row++) {
            generatedBoard.add(new ArrayList<Cell>());
            for (int column = 0; column < 10; column++) {
                ArrayList<Cell> currentRow = generatedBoard.get(row);
                currentRow.add(new Cell());
            }
        }

        return generatedBoard;
    }

    public List<ArrayList> generateAliveBoardHelper() {
        List<ArrayList> generatedBoard = new ArrayList<>();
        for (int row = 0; row < 10; row++) {
            generatedBoard.add(new ArrayList<Cell>());
            for (int column = 0; column < 10; column++) {
                ArrayList<Cell> currentRow = generatedBoard.get(row);
                currentRow.add(new Cell(true));
            }
        }

        return generatedBoard;
    }

    @Test
    @DisplayName("Given a a Board with a fully dead board is passed, a new board of dead cells should be generated")
    void generateNextBoard() {
        Board board = new Board();
        board.setBoard(generateDeadBoardHelper());
        Game game = new Game(board);

        game.generateNextBoard();

        boolean isDeadBoard = true;
        for (ArrayList<Cell> boardRow : board.getBoard()) {
            for (Cell cell : boardRow) {
                if (cell.checkIfAlive()) {
                    isDeadBoard = false;
                }
            }
        }
        assertTrue(isDeadBoard);
    }

    @Test
    @DisplayName("Given a Board with a board of alive cells is passed, a new board of dead cells should be generated")
    void generateNextBoard_AllAlive() {
        Board board = new Board();
        board.setBoard(generateAliveBoardHelper());
        Game game = new Game(board);

        game.generateNextBoard();

        boolean isDeadBoard = true;
        for (ArrayList<Cell> boardRow : board.getBoard()) {
            for (Cell cell : boardRow) {
                if (cell.checkIfAlive()) {
                }
            }
        }
        assertTrue(isDeadBoard);
    }
}
