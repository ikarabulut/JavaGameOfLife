package com.ikarabulut;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//1. If a living cell has less than two living neighbors, it is dead in
//   the next generation, as if by underpopulation.
//2. If a living cell has two or three living neighbors, it stays alive
//   in the next generation.
//3. If a living cell has more than three living neighbors, it is dead
//   in the next generation, as if by overcrowding.
//4. If a dead cell has exactly three living neighbors, it comes to
//   life in the next generation.

class RulesTest {
    @Test
    @DisplayName("When alive cell passes less than 2 alive neighbors, underpopulated will return false, meaning cell will die")
    void isUnderpopulated() {
        boolean test = Rules.aliveCheck(0);
        assertFalse(test);
    }

    @Test
    @DisplayName("When alive cell passes 2 alive neighbors, isFertileLand will return true, meaning cell will survive")
    void isFertileLand() {
        boolean test = Rules.aliveCheck(2);
        assertTrue(test);
    }

    @Test
    @DisplayName("When alive cell passes 3 alive neighbors, isFertileLand will return true, meaning cell will survive")
    void isFertileLand_3() {
        boolean test = Rules.aliveCheck(3);
        assertTrue(test);
    }

    @Test
    @DisplayName("When alive cell passes 4 alive neighbors, isOverpopulated will return false, meaning cell will die")
    void isOverpopulated() {
        boolean test = Rules.aliveCheck(4);
        assertFalse(test);
    }

    @Test
    @DisplayName("When dead cell passes 3 alive neighbors, isFertileLand will return true, meaning cell will survive")
    void isFertileLand_ForDeadCell() {
        boolean test = Rules.deadCheck(3);
        assertTrue(test);
    }

    @Test
    @DisplayName("When a dead cell passes anything other than 3 alive neighbors, false will return, meaning cell stays dead")
    void deadCheck_StaysFalse() {
        boolean test = Rules.deadCheck(1);
        assertFalse(test);
    }

}
