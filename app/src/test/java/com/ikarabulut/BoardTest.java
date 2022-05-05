package com.ikarabulut;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
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
        for (ArrayList<Cell> boardRow : generatedBoard) {
            for (Cell cell : boardRow) {
                assertFalse(cell.checkIfAlive());
            }
        }
    }

}