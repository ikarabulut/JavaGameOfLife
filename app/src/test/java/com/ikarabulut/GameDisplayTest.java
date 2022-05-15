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
                () -> assertNotNull(gameDisplay.getWelcomePrompt()),
                () -> assertNotNull(gameDisplay.getGameSettingsPrompt()),
                () -> assertNotNull(gameDisplay.getEvolutionsPrompt()),
                () -> assertNotNull(gameDisplay.getRowsPrompt()),
                () -> assertNotNull(gameDisplay.getColumnsPrompt()),
                () -> assertNotNull(gameDisplay.getAliveSymbolPrompt()),
                () -> assertNotNull(gameDisplay.getDeadSymbolPrompt())
        );
    }

}
