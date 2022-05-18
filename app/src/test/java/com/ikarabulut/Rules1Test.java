package com.ikarabulut;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Rules1Test {

    Rules1 gameRules;

    @BeforeEach
    void initializeRules1() {
        gameRules = new Rules1();
    }

    @Test
    @DisplayName("When a Dead Cell has 4 alive neighbors, it should be revived")
    void willBeAliveNextGeneration_DeadWith4() {
        assertTrue(gameRules.willBeAliveNextGeneration(4, false));
    }

    @Test
    @DisplayName("When a Dead Cell has 3 alive neighbors, it will stay dead")
    void willBeAliveNextGeneration_DeadWith3() {
        assertFalse(gameRules.willBeAliveNextGeneration(3, false));
    }

    @Test
    @DisplayName("When a Dead Cell has 5 alive neighbors, it will stay dead")
    void willBeAliveNextGeneration_DeadWith5() {
        assertFalse(gameRules.willBeAliveNextGeneration(5, false));
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
        assertFalse(gameRules.willBeAliveNextGeneration(1, true));
    }

    @Test
    @DisplayName("When an Alive Cell has 4 alive neighbors, it will die")
    void willBeAliveNextGeneration_AliveWith4() {
        assertFalse(gameRules.willBeAliveNextGeneration(4, true));
    }

}
