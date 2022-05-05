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
    void setGridDefault() {
        Board board = new Board();
        List<ArrayList> generatedBoard = board.getGrid();

        assertAll("default grid size",
                () -> assertEquals(10, generatedBoard.size(), "10 rows are not being generated"),
                () -> assertEquals(10, generatedBoard.get(0).size(), "10 columns are not being generated")
        );
    }

    @Test
    @DisplayName("Given the arguments of 20,20 are passed, a 20X20 board is created")
    void setGridCustom() {
        Board board = new Board(20,20);
        List<ArrayList> generatedBoard = board.getGrid();

        assertAll("custom grid size",
                () -> assertEquals(20, generatedBoard.size(), "20 rows are not being generated"),
                () -> assertEquals(20, generatedBoard.get(0).size(), "20 columns are not being generated")
        );
    }

    @Test
    @DisplayName("Given no arguments are provided, when a grid is created, all cells will be dead")
    void setGridDefaultIsAllDead() {
        Board board = new Board();
        List<ArrayList> generatedBoard = board.getGrid();

        boolean isDeadBoard = true;
        for (ArrayList<Cell> boardRow : generatedBoard)
            for (Cell cell : boardRow) {
                if (cell.checkIfAlive() == true) {
                    isDeadBoard = false;
            }
        }

        assertTrue(isDeadBoard);
    }

    @Test
    @DisplayName("Given a random board gets generated, then the board will have alive and dead cells")
    void setRandomGrid() {
        Board board = new Board();
        board.setRandomGrid();
        List<ArrayList> randomBoard = board.getGrid();

        boolean isDeadBoard = true;
        for (ArrayList<Cell> boardRow : randomBoard)
            for (Cell cell : boardRow) {
                if (cell.checkIfAlive() == true) {
                    isDeadBoard = false;
                }
            }

        assertFalse(isDeadBoard);
    }

    @Test
    @DisplayName("The board can bring a cell to life at a given location")
    void setAliveAt() {
        Board board = new Board();

        Boolean cellStatus = board.isCellAliveAt(1, 1);
        assertFalse(cellStatus);

        board.setAliveAt(1, 1);
        cellStatus = board.isCellAliveAt(1, 1);

        assertTrue(cellStatus);

    }

    @Nested
    @DisplayName("Tests for getAliveNeighborsCountOf")
    class GetAliveNeighborsCountOf {
        private void setDeadBoard() {
            for ( ArrayList<Cell> gridRow : board.getGrid()) {
                for ( Cell cell : gridRow) {
                    cell.die();
                }
            }
        }

        private void setAliveBoard() {
            for ( ArrayList<Cell> gridRow : board.getGrid()) {
                for (Cell cell : gridRow) {
                    cell.reviveMe();
                }
            }
        }

        public Board board;
        @BeforeEach
        void createBoard() {
            board = new Board(3,3);
            setDeadBoard();
        }
        @Test
        @DisplayName("A cell with 0 alive neighbor should return 0 alive neighbor")
        void getAliveNeighborsCountOf() {
            int numOfAliveNeighbors = board.getAliveNeighborsCountOf(1,1);
            assertEquals(numOfAliveNeighbors, 0);
        }

        @Test
        @DisplayName("A cell with 1 alive neighbor should return 1 alive neighbor")
        void getAliveNeighborsCountOfTest1() {
            board.setAliveAt(0,1);

            int numOfAliveNeighbors = board.getAliveNeighborsCountOf(1, 1);

            assertEquals(numOfAliveNeighbors, 1);
        }

        @Test
        @DisplayName("A cell with 2 alive neighbors should return 2 alive neighbors")
        void getAliveNeighborsCountOfTest2() {
            board.setAliveAt(0,1);
            board.setAliveAt(0,2);

            int numOfAliveNeighbors = board.getAliveNeighborsCountOf(1,1);

            assertEquals(numOfAliveNeighbors, 2);
        }

        @Test
        @DisplayName("A cell with 8 alive neighbors should return 8 alive neighbors")
        void getAliveNeighborsCountOfTest3() {
            setAliveBoard();

            int numOfAliveNeighbors = board.getAliveNeighborsCountOf(1, 1);

            assertEquals(numOfAliveNeighbors, 8);
        }

        @Test
        @DisplayName("Should count neighbors that wrap from the right side of a row to the left side")
        void getAliveNeighborsCountOfTest4() {
            Board largerBoard = new Board(5,5);
            setDeadBoard();
            largerBoard.setAliveAt(2, 0);

            int numOfAliveNeighbors = largerBoard.getAliveNeighborsCountOf(2, 4);

            assertEquals(numOfAliveNeighbors, 1);
        }

        @Test
        @DisplayName("Should count neighbors that wrap diagonally from the top left to the bottom right of the board")
        void getAliveNeighborsCountOfTest5() {
            Board largerBoard = new Board(5, 5);
            setDeadBoard();
            largerBoard.setAliveAt(0,0);

            int numOfAliveNeighbors = largerBoard.getAliveNeighborsCountOf(4, 4);

            assertEquals(numOfAliveNeighbors, 1);
        }

        @Test
        @DisplayName("Should count neighbors that wrap from the top of a column to the bottom")
        void getAliveNeighborsCountOfTest6() {
            Board largerBoard = new Board(5, 5);
            setDeadBoard();
            largerBoard.setAliveAt(4, 2);

            int numOfAliveNeighbors = largerBoard.getAliveNeighborsCountOf(0, 2);

            assertEquals(numOfAliveNeighbors, 1);
        }

        @Test
        @DisplayName("Should count neighbors that wrap from the top right of a column to the bottom left")
        void getAliveNeighborsCountOfTest7() {
            Board largerBoard = new Board(5, 5);
            setDeadBoard();
            largerBoard.setAliveAt(4, 0);

            int numOfALiveNeighbors = largerBoard.getAliveNeighborsCountOf(0, 4);
        }




    }


}

