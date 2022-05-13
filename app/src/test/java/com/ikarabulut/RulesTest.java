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
    @DisplayName("When an Alive Cell has 0 alive neighbors passed, it is underpopulated, meaning it will not survive for the next generation")
    void aliveCheck_0Passed() {
        int numOfAliveNeighborsPassed = 0;
        boolean isAlive = true;
        boolean test = Rules.willBeAliveNextGeneration(numOfAliveNeighborsPassed, isAlive);
        assertFalse(test);
    }

    @Test
    @DisplayName("When an Alive Cell has 2 alive neighbors passed, it is on fertile land, meaning it will survive for the next generation")
    void aliveCheck_2Passed() {
        int numOfAliveNeighborsPassed = 2;
        boolean isAlive = true;
        boolean test = Rules.willBeAliveNextGeneration(numOfAliveNeighborsPassed, isAlive);
        assertTrue(test);
    }

    @Test
    @DisplayName("When an Alive Cell has 3 alive neighbors passed, it is on fertile land, meaning it will survive for the next generation")
    void aliveCheck_3Passed() {
        int numOfAliveNeighborsPassed = 3;
        boolean isAlive = true;
        boolean test = Rules.willBeAliveNextGeneration(numOfAliveNeighborsPassed, isAlive);
        assertTrue(test);
    }

    @Test
    @DisplayName("When an Alive Cell has 4 alive neighbors passed, it is overpopulated, meaning it will not survive for the next generation")
    void aliveCheck_4Passed() {
        int numOfAliveNeighborsPassed = 4;
        boolean isAlive = true;
        boolean test = Rules.willBeAliveNextGeneration(numOfAliveNeighborsPassed, isAlive);
        assertFalse(test);
    }

    @Test
    @DisplayName("When a Dead Cell has 3 alive neighbors passed, it is on revivable land, meaning it will come to life for the next generation")
    void deadCheck_3Passed() {
        int numOfAliveNeighborsPassed = 3;
        boolean isAlive = false;
        boolean test = Rules.willBeAliveNextGeneration(numOfAliveNeighborsPassed, isAlive);
        assertTrue(test);
    }

    @Test
    @DisplayName("When a Dead Cell has 1 alive neighbors passed, it is not on revivable land, meaning it will stay dead for the next generation")
    void deadCheck_1Passed() {
        int numOfAliveNeighborsPassed = 1;
        boolean isAlive = false;
        boolean test = Rules.willBeAliveNextGeneration(numOfAliveNeighborsPassed, isAlive);
        assertFalse(test);
    }

}
