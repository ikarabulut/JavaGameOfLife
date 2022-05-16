package com.ikarabulut;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameDisplayTest {
    @Test
    @DisplayName("When a new GameDisplay is generated, prompts should not be null")
    void setPrompts() {
        GameDisplay gameDisplay = new GameDisplay();

        assertAll (
                () -> assertNotNull(gameDisplay.welcomePrompt()),
                () -> assertNotNull(gameDisplay.gameSettingsPrompt()),
                () -> assertNotNull(gameDisplay.evolutionsPrompt()),
                () -> assertNotNull(gameDisplay.rowsPrompt()),
                () -> assertNotNull(gameDisplay.columnsPrompt()),
                () -> assertNotNull(gameDisplay.aliveSymbolPrompt()),
                () -> assertNotNull(gameDisplay.deadSymbolPrompt())
        );
    }

}
