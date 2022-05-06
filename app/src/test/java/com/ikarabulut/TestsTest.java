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

class TestsTest {
    @Test
    @DisplayName("When alive cell passes less than 2 alive neighbors, underpopulated will return false, meaning cell will die")
    void isUnderpopulated() {
        boolean test = Tests.aliveCheck(0);
        assertFalse(test);
    }

}
