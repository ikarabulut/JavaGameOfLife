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
        cell.reviveMe();
        assertEquals(true, cell.checkIfAlive());
    }
}