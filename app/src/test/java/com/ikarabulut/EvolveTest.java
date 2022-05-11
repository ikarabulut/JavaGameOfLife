package com.ikarabulut;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EvolveTest {
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

    @Test
    @DisplayName("Given a board of dead cells is passed, a new board of dead cells should be generated")
    void generateNextBoard() {
        Evolve evolve = new Evolve();
        List<ArrayList> evolvingBoard = generateDeadBoardHelper();
        List<ArrayList> evolvedBoard = evolve.generateNextBoard(evolvingBoard);

        boolean isDeadBoard = true;
        for (ArrayList<Cell> boardRow : evolvedBoard) {
            for (Cell cell : boardRow) {
                if (cell.checkIfAlive()) {
                    isDeadBoard = false;
                }
            }
        }
        assertTrue(isDeadBoard);
    }

}
