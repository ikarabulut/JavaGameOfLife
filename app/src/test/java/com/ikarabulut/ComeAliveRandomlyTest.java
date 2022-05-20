package com.ikarabulut;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComeAliveRandomlyTest {
    private ComeAliveRandomly gameRules;

    @BeforeEach
    void initializeRulesClass() {
        gameRules = new ComeAliveRandomly();
    }

    @Test
    @DisplayName("When an Alive Cell has 0 alive neighbors passed, it is underpopulated, meaning it will not survive for the next generation")
    void aliveCheck_0Passed() {
        int numOfAliveNeighborsPassed = 0;
        boolean isAlive = true;
        boolean test = gameRules.willBeAliveNextGeneration(numOfAliveNeighborsPassed, isAlive);

        assertFalse(test);
    }

    @Test
    @DisplayName("When an Alive Cell has 2 alive neighbors passed, it is on fertile land, meaning it will survive for the next generation")
    void aliveCheck_2Passed() {
        int numOfAliveNeighborsPassed = 2;
        boolean isAlive = true;
        boolean test = gameRules.willBeAliveNextGeneration(numOfAliveNeighborsPassed, isAlive);

        assertTrue(test);
    }

    @Test
    @DisplayName("When an Alive Cell has 3 alive neighbors passed, it is on fertile land, meaning it will survive for the next generation")
    void aliveCheck_3Passed() {
        int numOfAliveNeighborsPassed = 3;
        boolean isAlive = true;
        boolean test = gameRules.willBeAliveNextGeneration(numOfAliveNeighborsPassed, isAlive);

        assertTrue(test);
    }

    @Test
    @DisplayName("When an Alive Cell has 4 alive neighbors passed, it is overpopulated, meaning it will not survive for the next generation")
    void aliveCheck_4Passed() {
        int numOfAliveNeighborsPassed = 4;
        boolean isAlive = true;
        boolean test = gameRules.willBeAliveNextGeneration(numOfAliveNeighborsPassed, isAlive);

        assertFalse(test);
    }

}
