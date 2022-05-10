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
    @DisplayName("When 0, and true is passed to determineFate, false will return, meaning cell will die")
    void aliveCheck_0Passed() {
        boolean test = Rules.determineFate(0, true);
        assertFalse(test);
    }

    @Test
    @DisplayName("When 2 and true is passed to determineFate, True will return, meaning cell will survive")
    void aliveCheck_2Passed() {
        boolean test = Rules.determineFate(2, true);
        assertTrue(test);
    }

    @Test
    @DisplayName("When 3 and true is passed to determineFate, True will return, meaning cell will survive")
    void aliveCheck_3Passed() {
        boolean test = Rules.determineFate(3, true);
        assertTrue(test);
    }

    @Test
    @DisplayName("When 4 and true is passed to determineFate, False will return, meaning cell will die")
    void aliveCheck_4Passed() {
        boolean test = Rules.determineFate(4, true);
        assertFalse(test);
    }

    @Test
    @DisplayName("When 3 and false is passed to determineFate, True will return, meaning cell will survive")
    void deadCheck_3Passed() {
        boolean test = Rules.determineFate(3, true);
        assertTrue(test);
    }

    @Test
    @DisplayName("When 1 and false is passed to determineFate, false will return, meaning cell stays dead")
    void deadCheck_1Passed() {
        boolean test = Rules.determineFate(1, true);
        assertFalse(test);
    }

}
