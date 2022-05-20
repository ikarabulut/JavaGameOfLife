package com.ikarabulut;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComeAliveWithTwoTest {

    @Test
    @DisplayName("A Dead Cell with exactly 2 alive neighbors, will come alive")
    void willBeAliveNextGeneration_Dead_With2Alive() {
        ComeAliveWithTwo ruleTest = new ComeAliveWithTwo();
        int aliveNeighborsCount = 2;
        boolean isAlive = false;

        boolean test = ruleTest.willBeAliveNextGeneration(aliveNeighborsCount, isAlive);

        assertTrue(test);

    }

}
