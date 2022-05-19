package com.ikarabulut;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.hamcrest.CoreMatchers.instanceOf;
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
        String input = "25";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        GameSettings settings = new GameSettings(displayPrompts);
        settings.setEvolutions();
        assertEquals(25, settings.getEvolutions());

    }

    @Test
    @DisplayName("When prompted for rows and 10 is passed, then rows should be set to 10")
    void setRows() {
        String input = "10";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        GameSettings settings = new GameSettings(displayPrompts);
        settings.setRows();

        assertEquals(10, settings.getRows());

    }

    @Test
    @DisplayName("When prompted for columns and 10 is passed, then columns should be set to 10")
    void setColumns() {
        String input = "10";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        GameSettings settings = new GameSettings(displayPrompts);
        settings.setColumns();

        assertEquals(10, settings.getColumns());

    }

    @Test
    @DisplayName("When prompted for alive symbol and X is, then aliveSymbol should be set to X")
    void setAliveSymbol() {
        String input = "X";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        GameSettings settings = new GameSettings(displayPrompts);
        settings.setAliveSymbol();
        assertEquals("X", settings.getAliveSymbol());

    }

    @Test
    @DisplayName("When prompted for dead symbol and o is passed, then deadSymbol should be set to o")
    void setDeadSymbol() throws InvalidSymbolException {
        String input = "o";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        GameSettings settings = new GameSettings(displayPrompts);
        settings.setDeadSymbol();

        assertEquals("o", settings.getDeadSymbol());

    }

    @Test
    @DisplayName("When prompted for rules and 1 is passed, then the rules carried out during the game will be the DefaultRules class")
    void setRuleSet_When1_RulesClass() {
        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        GameSettings settings = new GameSettings(displayPrompts);
        settings.setRuleSet();

        MatcherAssert.assertThat(settings.getRules(), instanceOf(DefaultRules.class));
    }

    @Test
    @DisplayName("When prompted for rules and 2 is passed, then the rules carried out during the game will be the ComeAliveWithFour class")
    void setRuleSet_When2_Rules1Class() {
        String input = "2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        GameSettings settings = new GameSettings(displayPrompts);
        settings.setRuleSet();

        MatcherAssert.assertThat(settings.getRules(), instanceOf(ComeAliveWithFour.class));
    }

}
