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
    @DisplayName("When 0 is passed to aliveCheck, false will return, meaning cell will die")
    void aliveCheck_0Passed() {
        boolean test = Rules.aliveCheck(0);
        assertFalse(test);
    }

    @Test
    @DisplayName("When 2 is passed to AliveCheck, True will return, meaning cell will survive")
    void aliveCheck_2Passed() {
        boolean test = Rules.aliveCheck(2);
        assertTrue(test);
    }

    @Test
    @DisplayName("When 3 is passed to aliveCheck, True will return, meaning cell will survive")
    void aliveCheck_3Passed() {
        boolean test = Rules.aliveCheck(3);
        assertTrue(test);
    }

    @Test
    @DisplayName("When 4 is passed to aliveCheck, False will return, meaning cell will die")
    void aliveCheck_4Passed() {
        boolean test = Rules.aliveCheck(4);
        assertFalse(test);
    }

    @Test
    @DisplayName("When 3 is passed to deadCheck, True will return, meaning cell will survive")
    void deadCheck_3Passed() {
        boolean test = Rules.deadCheck(3);
        assertTrue(test);
    }

    @Test
    @DisplayName("When 1 is passed to deadCheck, false will return, meaning cell stays dead")
    void deadCheck_1Passed() {
        boolean test = Rules.deadCheck(1);
        assertFalse(test);
    }

}
