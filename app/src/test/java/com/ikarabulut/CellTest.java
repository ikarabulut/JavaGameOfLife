package com.ikarabulut;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

class CellTest {
    @Test
    @DisplayName("When a cell is dead, its alive status should be false")
    void testDeadCellStatus() {
        Cell cell = new Cell();
        assertFalse(cell.checkIfAlive());
    }

    @Test
    @DisplayName("When a cell is revived, its alive status should be true")
    void testReviveMe() {
        Cell cell = new Cell();
        cell.setIsAlive(true);
        assertTrue(cell.checkIfAlive());
    }

    @Test
    @DisplayName("When a cell status is set to false, its alive status should be false")
    void testDie() {
        Cell cell = new Cell();
        cell.setIsAlive(false);
        assertFalse(cell.checkIfAlive());
    }

    @Test
    @DisplayName("When no arguments are passed, and the cell is alive, it will return O")
    void testAliveToString() {
        Cell cell = new Cell();
        assertEquals("-", cell.toString());
    }

    @Test
    @DisplayName("When no arguments are passed, and the cell is alive, it will return -")
    void testDeadToString() {
        Cell cell = new Cell();
        cell.setIsAlive(true);
        assertEquals("O", cell.toString());
    }
}
