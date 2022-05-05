package com.ikarabulut;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

class CellTest {
    @Test
    @DisplayName("When a cell is dead, its alive status should be false")
    void testDeadCellStatus() {
        Cell cell = new Cell();
        assertEquals(false, cell.checkIfAlive());
    }

    @Test
    @DisplayName("When a cell is revived, its alive status should be true")
    void testReviveMe() {
        Cell cell = new Cell();
        cell.revive();
        assertEquals(true, cell.checkIfAlive());
    }

    @Test
    @DisplayName("When a cell dies, its alive status should be false")
    void testDie() {
        Cell cell = new Cell();
        cell.die();
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
        cell.revive();
        assertEquals("O", cell.toString());
    }
}