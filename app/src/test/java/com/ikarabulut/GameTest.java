package com.ikarabulut;

import com.ikarabulut.UI.GameDisplay;
import com.ikarabulut.UI.GameSettings;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    private GameDisplay theDisplay;
    private GameSettings theSettings;

    @BeforeEach
    void createDisplayAndSettings() {
        theDisplay = new GameDisplay();
        theSettings = new GameSettings(theDisplay);
    }

    public Board generateDeadBoardHelper() {
        Board deadBoard = new Board();
        deadBoard.generateDeadBoard();
        return deadBoard;
    }

    public Board generateAliveBoardHelper() {
        Board aliveBoard = new Board();
        for (ArrayList<Cell> boardRow : aliveBoard.getBoard()) {
            for (Cell cell : boardRow) {
                cell.setIsAlive(true);
            }
        }
        return aliveBoard;
    }

    @Test
    @DisplayName("Given a a Board with a fully dead board is passed, a new board of dead cells should be generated")
    void generateNextBoard() {
        Board board = generateDeadBoardHelper();
        Game game = new Game(board, theSettings, theDisplay);

        Board result = game.generateNextBoard();

        boolean isDeadBoard = true;
        for (ArrayList<Cell> boardRow : result.getBoard()) {
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
        Board board = generateAliveBoardHelper();
        Game game = new Game(board, theSettings, theDisplay);

        Board result = game.generateNextBoard();

        boolean isDeadBoard = true;
        for (ArrayList<Cell> boardRow : result.getBoard()) {
            for (Cell cell : boardRow) {
                if (cell.checkIfAlive()) {
                    isDeadBoard = false;
                }
            }
        }
        assertTrue(isDeadBoard);
    }

    private Board createBoardWithSquare() {
        int rows = 10;
        int columns = 10;

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
        Game game = new Game(board, theSettings, theDisplay);

        Board result = game.generateNextBoard();

        assertTrue(result.isCellAliveAt(0, 0));
        assertTrue(result.isCellAliveAt(1, 0));
        assertTrue(result.isCellAliveAt(0, 1));
        assertTrue(result.isCellAliveAt(1, 1));
    }

}
