package com.ikarabulut;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class BoardTest {

    @Test
    @DisplayName("Given no arguments, a 10x10 board is created by default")
    void setGrid_NoArgumentsPassed_10x10BoardIsGenerated() {
        Board board = new Board();
        List<ArrayList> generatedBoard = board.getBoard();

        assertAll("default grid size",
                () -> assertEquals(10, generatedBoard.size(), "10 rows are not being generated"),
                () -> assertEquals(10, generatedBoard.get(0).size(), "10 columns are not being generated")
        );
    }

    @Test
    @DisplayName("Given the arguments of 20,20 are passed, a 20X20 board is created")
    void setGrid_20x20ArgumentsArePassed_20x20BoardIsGenerated() {
        Board board = new Board(20, 20);
        List<ArrayList> generatedBoard = board.getBoard();

        assertAll("custom grid size",
                () -> assertEquals(20, generatedBoard.size(), "20 rows are not being generated"),
                () -> assertEquals(20, generatedBoard.get(0).size(), "20 columns are not being generated")
        );
    }

    @Test
    @DisplayName("Given no arguments are provided, when a grid is created, all cells will be dead")
    void setGrid_NoArgumentsArePassed_BoardGeneratedIsAllDead() {
        Board board = new Board();
        List<ArrayList> generatedBoard = board.getBoard();

        boolean isDeadBoard = true;
        for (ArrayList<Cell> boardRow : generatedBoard)
            for (Cell cell : boardRow) {
                if (cell.checkIfAlive()) {
                    isDeadBoard = false;
            }
        }

        assertTrue(isDeadBoard);
    }

    @Test
    @DisplayName("Given a random board gets generated, then the board will have alive and dead cells")
    void setRandomGrid_WhenCalled_BoardWillUpdateToAliveAndDeadCells() {
        Board board = new Board();
        board.generateRandomBoard();
        List<ArrayList> randomBoard = board.getBoard();

        boolean isDeadBoard = true;
        for (ArrayList<Cell> boardRow : randomBoard)
            for (Cell cell : boardRow) {
                if (cell.checkIfAlive()) {
                    isDeadBoard = false;
                }
            }

        assertFalse(isDeadBoard);
    }

    @Test
    @DisplayName("The board can bring a cell to life at a given location")
    void setAliveAt_When1_1IsPassed_ReturnsTheCellObjectAt1_1() {
        Board board = new Board();

        Boolean cellStatus = board.isCellAliveAt(1, 1);
        assertFalse(cellStatus);

        board.setAliveAt(1, 1);
        cellStatus = board.isCellAliveAt(1, 1);

        assertTrue(cellStatus);

    }

    @Nested
    @DisplayName("willCellSurviveAt()")
    class WillCellSurviveAt {
        private void setDeadBoard() {
            for ( ArrayList<Cell> boardRow : board.getBoard()) {
                for ( Cell cell : boardRow) {
                    cell.die();
                }
            }
        }

        public Board board;
        @BeforeEach
        void createBoard() {
            board = new Board();
        }

        @Test
        @DisplayName("Alive Cell with less than 2 alive neighbors should not be alive next generation")
        void willCellSurviveAt_LessThan2() {
            setDeadBoard();
            board.setAliveAt(0, 1);
            board.setAliveAt(0, 0);

            assertFalse(board.willSurviveAt(0, 1));
        }

        @Test
        @DisplayName("Alive Cell with 2 alive neighbors should be alive next generation")
        void willCellSurviveAt_With2() {
            setDeadBoard();
            board.setAliveAt(0, 1);
            board.setAliveAt(0, 0);
            board.setAliveAt(1, 0);

            assertTrue(board.willSurviveAt(0, 1));
        }

        @Test
        @DisplayName("Alive Cell with 3 alive neighbors should be alive next generation")
        void willCellSurviveAt_With3() {
            setDeadBoard();
            board.setAliveAt(0, 1);
            board.setAliveAt(0, 0);
            board.setAliveAt(1, 0);
            board.setAliveAt(0, 2);

            assertTrue(board.willSurviveAt(0, 1));
        }

        @Test
        @DisplayName("Alive Cell with 4 alive neighbors should be dead next generation")
        void willCellSurviveAt_With4() {
            setDeadBoard();
            board.setAliveAt(0, 1);
            board.setAliveAt(0, 0);
            board.setAliveAt(1, 0);
            board.setAliveAt(0, 2);
            board.setAliveAt(1, 2);

            assertFalse(board.willSurviveAt(0, 1));
        }

        @Test
        @DisplayName("Dead Cell with 3 alive neighbors should be alive next generation")
        void willCellSurviveAt_DeadWith3() {
            setDeadBoard();
            board.setAliveAt(0, 0);
            board.setAliveAt(1, 0);
            board.setAliveAt(0, 2);

            assertTrue(board.willSurviveAt(0, 1));
        }

        @Test
        @DisplayName("Dead Cell with 2 alive neighbors should be dead next generation")
        void willCellSurviveAt_DeadWith2() {
            setDeadBoard();
            board.setAliveAt(0, 0);
            board.setAliveAt(1, 0);

            assertFalse(board.willSurviveAt(0, 1));
        }
    }

    @Nested
    @DisplayName("getNumberOfAliveNeighbors()")
    class GetNumberOfAliveNeighbors {
        private void setDeadBoard() {
            for ( ArrayList<Cell> boardRow : board.getBoard()) {
                for ( Cell cell : boardRow) {
                    cell.die();
                }
            }
        }

        private void setAliveBoard() {
            for ( ArrayList<Cell> boardRow : board.getBoard()) {
                for (Cell cell : boardRow) {
                    cell.revive();
                }
            }
        }

        public Board board;
        @BeforeEach
        void createBoard() {
            board = new Board(3, 3);
            setDeadBoard();
        }
        @Test
        @DisplayName("A cell with 0 alive neighbor should return 0 alive neighbor")
        void getNumberOfAliveNeighbors_WhenNoNeighborsAreAlive_Returns0() {
            int numOfAliveNeighbors = board.getNumberOfAliveNeighbors(1, 1);

            assertEquals(numOfAliveNeighbors, 0);
        }

        @Test
        @DisplayName("A cell with 1 alive neighbor should return 1 alive neighbor")
        void getNumberOfAliveNeighbors_When1NeighborIsAlive_Returns1() {
            board.setAliveAt(0, 1);

            int numOfAliveNeighbors = board.getNumberOfAliveNeighbors(1, 1);

            assertEquals(numOfAliveNeighbors, 1);
        }

        @Test
        @DisplayName("A cell with 2 alive neighbors should return 2 alive neighbors")
        void getNumberOfAliveNeighbors_When2NeighborsAreAlive_Returns2() {
            board.setAliveAt(0, 1);
            board.setAliveAt(0, 2);

            int numOfAliveNeighbors = board.getNumberOfAliveNeighbors(1, 1);

            assertEquals(numOfAliveNeighbors, 2);
        }

        @Test
        @DisplayName("A cell with 8 alive neighbors should return 8 alive neighbors")
        void getNumberOfAliveNeighbors_WhenAllNeighborsAreAlive_Returns8() {
            setAliveBoard();

            int numOfAliveNeighbors = board.getNumberOfAliveNeighbors(1, 1);

            assertEquals(numOfAliveNeighbors, 8);
        }

        @Test
        @DisplayName("Should count neighbors that wrap from the right side of a row to the left side")
        void getNumberOfAliveNeighbors_WhenCellIsOnRightEdge_ReturnsAliveCellsFromLeftEdge() {
            Board largerBoard = new Board(5, 5);
            setDeadBoard();
            largerBoard.setAliveAt(2, 0);

            int numOfAliveNeighbors = largerBoard.getNumberOfAliveNeighbors(2, 4);

            assertEquals(numOfAliveNeighbors, 1);
        }

        @Test
        @DisplayName("Should count neighbors that wrap diagonally from the top left to the bottom right of the board")
        void getNumberOfAliveNeighbors_WhenCellIsBottomRightEdge_ReturnsAliveCellsFromTopRightEdge() {
            Board largerBoard = new Board(5, 5);
            setDeadBoard();
            largerBoard.setAliveAt(0, 0);

            int numOfAliveNeighbors = largerBoard.getNumberOfAliveNeighbors(4, 4);

            assertEquals(numOfAliveNeighbors, 1);
        }

        @Test
        @DisplayName("Should count neighbors that wrap from the top of a column to the bottom")
        void getNumberOfAliveNeighbors_WhenCellIsOnBottomEdge_ReturnsAliveNeighborsFromTop() {
            Board largerBoard = new Board(5, 5);
            setDeadBoard();
            largerBoard.setAliveAt(4, 2);

            int numOfAliveNeighbors = largerBoard.getNumberOfAliveNeighbors(0, 2);

            assertEquals(numOfAliveNeighbors, 1);
        }

        @Test
        @DisplayName("Should count neighbors that wrap from the top right of a column to the bottom left")
        void getNumberOfAliveNeighbors_WhenCellIsTopRight_ReturnsAliveNeighborsFromBottomLeftEdge() {
            Board largerBoard = new Board(5, 5);
            setDeadBoard();
            largerBoard.setAliveAt(4, 0);

            int numOfALiveNeighbors = largerBoard.getNumberOfAliveNeighbors(0, 4);

            assertEquals(numOfALiveNeighbors, 1);
        }
        
    }

}
