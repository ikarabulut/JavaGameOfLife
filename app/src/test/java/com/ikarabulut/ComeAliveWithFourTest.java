package com.ikarabulut;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComeAliveWithFourTest {

    ComeAliveWithFour gameRules;

    @BeforeEach
    void initializeRules1() {
        gameRules = new ComeAliveWithFour();
    }

    @Test
    @DisplayName("When a Dead Cell has 4 alive neighbors, it should be revived")
    void willBeAliveNextGeneration_DeadWith4() {
        int numOfAliveNeighborsPassed = 4;
        boolean isCurrentCellAlive = false;

        boolean willBeAlive = gameRules.willBeAliveNextGeneration(numOfAliveNeighborsPassed, isCurrentCellAlive);

        assertTrue(willBeAlive);
    }

    @Test
    @DisplayName("When a Dead Cell has 3 alive neighbors, it will stay dead")
    void willBeAliveNextGeneration_DeadWith3() {
        int numOfAliveNeighborsPassed = 3;
        boolean isCurrentCellAlive = false;

        boolean willBeAlive = gameRules.willBeAliveNextGeneration(numOfAliveNeighborsPassed, isCurrentCellAlive);

        assertFalse(willBeAlive);
    }

    @Test
    @DisplayName("When a Dead Cell has 5 alive neighbors, it will stay dead")
    void willBeAliveNextGeneration_DeadWith5() {
        int numOfAliveNeighborsPassed = 5;
        boolean isCurrentCellAlive = false;

        boolean willBeAlive = gameRules.willBeAliveNextGeneration(numOfAliveNeighborsPassed, isCurrentCellAlive);

        assertFalse(willBeAlive);
    }

    @Test
    @DisplayName("When an Alive Cell has 2 or 3 alive neighbors, it will stay alive")
    void willBeAliveNextGeneration_AliveWith2_3() {
        assertAll(
                () -> assertTrue(gameRules.willBeAliveNextGeneration(2, true)),
                () -> assertTrue(gameRules.willBeAliveNextGeneration(3, true))
        );
    }

    @Test
    @DisplayName("When an Alive Cell has 1 alive neighbor, it will die")
    void willBeAliveNextGeneration_AliveWith1() {
        int numOfAliveNeighborsPassed = 1;
        boolean isCurrentCellAlive = true;

        boolean willBeAlive = gameRules.willBeAliveNextGeneration(numOfAliveNeighborsPassed, isCurrentCellAlive);

        assertFalse(willBeAlive);
    }

    @Test
    @DisplayName("When an Alive Cell has 4 alive neighbors, it will die")
    void willBeAliveNextGeneration_AliveWith4() {
        int numOfAliveNeighborsPassed = 4;
        boolean isCurrentCellAlive = true;

        boolean willBeAlive = gameRules.willBeAliveNextGeneration(numOfAliveNeighborsPassed, isCurrentCellAlive);
        
        assertFalse(willBeAlive);
    }

}
