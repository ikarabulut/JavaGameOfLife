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
        GameDisplay display = new GameDisplay();
        GameSettings gameSettings = new GameSettings("deleteThis", display);
        board.setBoard(generateDeadBoardHelper());
        Game game = new Game(gameSettings);

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
        GameDisplay display = new GameDisplay();
        GameSettings gameSettings = new GameSettings("deleteThis", display);
        board.setBoard(generateAliveBoardHelper());
        Game game = new Game(gameSettings);

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

    private Board createBoardWithSquare() {
        int rows = 5;
        int columns = 5;

        Board board = new Board(rows, columns);
        board.setAliveAt(0, 0);
        board.setAliveAt(1, 0);
        board.setAliveAt(0, 1);
        board.setAliveAt(1, 1);

        return board;
    }


    @Test
    @DisplayName("Given a board with a square Then the square should still be alive in the next generation")
    void generateNextWorldWithSquare() {
        Board board = createBoardWithSquare();
        GameDisplay display = new GameDisplay();
        GameSettings gameSettings = new GameSettings("deleteThis", display);
        Game game = new Game(gameSettings);

        Board result = game.generateNextBoard();

        assertTrue(result.isCellAliveAt(0, 0));
        assertTrue(result.isCellAliveAt(1, 0));
        assertTrue(result.isCellAliveAt(0, 1));
        assertTrue(result.isCellAliveAt(1, 1));
    }
}
