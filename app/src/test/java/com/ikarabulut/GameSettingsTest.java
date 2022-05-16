package com.ikarabulut;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameSettingsTest {
    private GameDisplay displayPrompts;
    @BeforeEach
    void createGameDisplay() {
        displayPrompts = new GameDisplay();
    }
    @Test
    @DisplayName("When prompted for evolutions and 25 is passed, then row should be set to 25")
    void setEvolutions() {
        GameSettings settings = new GameSettings("25", displayPrompts);
        settings.setEvolutions();
        assertEquals(25, settings.getEvolutions());

    }

    @Test
    @DisplayName("When prompted for rows and 10 is passed, then rows should be set to 10")
    void setRows() {
        GameSettings settings = new GameSettings("10", displayPrompts);
        settings.setRows();
        assertEquals(10, settings.getRows());

    }

    @Test
    @DisplayName("When prompted for columns and 10 is passed, then columns should be set to 10")
    void setColumns() {
        GameSettings settings = new GameSettings("10", displayPrompts);
        settings.setColumns();
        assertEquals(10, settings.getColumns());

    }

    @Test
    @DisplayName("When prompted for alive symbol and X is, then aliveSymbol should be set to 10")
    void setAliveSymbol() {
        GameSettings settings = new GameSettings("X", displayPrompts);
        settings.setAliveSymbol();
        assertEquals("X", settings.getAliveSymbol());

    }

    @Test
    @DisplayName("When prompted for dead symbol and o is passed, then deadSymbol should be set to o")
    void setDeadSymbol() {
        GameSettings settings = new GameSettings("o", displayPrompts);
        settings.setDeadSymbol();
        assertEquals("o", settings.getDeadSymbol());

    }

}
