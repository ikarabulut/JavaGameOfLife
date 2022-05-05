package com.ikarabulut;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.*;

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
    @DisplayName("A cell that is dead can be set to alive")
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
        public Board board;
        @BeforeEach
        void createBoard() {
            board = new Board(3,3);
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
            board.setAliveAt(0,0);
            board.setAliveAt(0,1);
            board.setAliveAt(0,2);
            board.setAliveAt(1,0);
            board.setAliveAt(1,2);
            board.setAliveAt(2,0);
            board.setAliveAt(2,1);
            board.setAliveAt(2,2);

            int numOfAliveNeighbors = board.getAliveNeighborsCountOf(1, 1);

            assertEquals(numOfAliveNeighbors, 8);
        }

        @Test
        @DisplayName("An alive cell on the left edge should register as an alive cell for a right edge cell")
        void getAliveNeighborsCountOfTest4() {
            Board largerBoard = new Board(5,5);
            largerBoard.setAliveAt(2, 0);

            int numOfAliveNeighbors = largerBoard.getAliveNeighborsCountOf(2, 4);

            assertEquals(numOfAliveNeighbors, 1);
        }

        @Test
        @DisplayName("An alive cell on the top left edge should register as an alive cell for a bottom right edge")
        void getAliveNeighborsCountOfTest5() {
            Board largerBoard = new Board(5, 5);
            largerBoard.setAliveAt(0,0);

            int numOfAliveNeighbors = largerBoard.getAliveNeighborsCountOf(4, 4);

            assertEquals(numOfAliveNeighbors, 1);
        }

        @Test
        @DisplayName("An alive cell on the bottom edge should register as an alive cell for a top edge cell")
        void getAliveNeighborsCountOfTest6() {
            Board largerBoard = new Board(5, 5);
            largerBoard.setAliveAt(4, 2);

            int numOfAliveNeighbors = largerBoard.getAliveNeighborsCountOf(0, 2);

            assertEquals(numOfAliveNeighbors, 1);
        }

        @Test
        @DisplayName("An alive cell on the bottom left edge should register as an alive cell for a top right cell")
        void getAliveNeighborsCountOfTest7() {
            Board largerBoard = new Board(5, 5);
            largerBoard.setAliveAt(4, 0);

            int numOfALiveNeighbors = largerBoard.getAliveNeighborsCountOf(0, 4);
        }




    }


}

