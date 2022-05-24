package com.ikarabulut;

import com.ikarabulut.Rules.ComeAliveWithTwo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComeAliveWithTwoTest {

    private ComeAliveWithTwo gameRules;
    @BeforeEach
    void initializeRulesClass() {
        gameRules = new ComeAliveWithTwo();
    }
    @Test
    @DisplayName("A Dead Cell with exactly 2 alive neighbors, will come alive")
    void willBeAliveNextGeneration_Dead_With2Alive() {
        int aliveNeighborsCount = 2;
        boolean isCurrentCellAlive = false;

        boolean willBeAlive = gameRules.willBeAliveNextGeneration(aliveNeighborsCount, isCurrentCellAlive);

        assertTrue(willBeAlive);
    }

    @Test
    @DisplayName("When an Alive Cell has 2 alive neighbors passed, it is on fertile land, meaning it will survive for the next generation")
    void aliveCheck_2Passed() {
        int numOfAliveNeighborsPassed = 2;
        boolean isCurrentCellAlive = true;
        boolean willBeAlive = gameRules.willBeAliveNextGeneration(numOfAliveNeighborsPassed, isCurrentCellAlive);

        assertTrue(willBeAlive);
    }

    @Test
    @DisplayName("When an Alive Cell has 3 alive neighbors passed, it is on fertile land, meaning it will survive for the next generation")
    void aliveCheck_3Passed() {
        int numOfAliveNeighborsPassed = 3;
        boolean isCurrentCellAlive = true;
        boolean willBeAlive = gameRules.willBeAliveNextGeneration(numOfAliveNeighborsPassed, isCurrentCellAlive);

        assertTrue(willBeAlive);
    }

    @Test
    @DisplayName("When an Alive Cell has 4 alive neighbors passed, it is overpopulated, meaning it will not survive for the next generation")
    void aliveCheck_4Passed() {
        int numOfAliveNeighborsPassed = 4;
        boolean isCurrentCellAlive = true;
        boolean willBeAlive = gameRules.willBeAliveNextGeneration(numOfAliveNeighborsPassed, isCurrentCellAlive);

        assertFalse(willBeAlive);
    }

    @Test
    @DisplayName("When a Dead Cell has 3 alive neighbors passed, it will not be revived")
    void deadCheck_3Passed() {
        int numOfAliveNeighborsPassed = 3;
        boolean isCurrentCellAlive = false;
        boolean willBeAlive = gameRules.willBeAliveNextGeneration(numOfAliveNeighborsPassed, isCurrentCellAlive);

        assertFalse(willBeAlive);
    }

    @Test
    @DisplayName("When a Dead Cell has 1 alive neighbors passed, it is not on revivable land, meaning it will stay dead for the next generation")
    void deadCheck_1Passed() {
        int numOfAliveNeighborsPassed = 1;
        boolean isCurrentCellAlive = false;
        boolean willBeAlive = gameRules.willBeAliveNextGeneration(numOfAliveNeighborsPassed, isCurrentCellAlive);

        assertFalse(willBeAlive);
    }
}
