package com.ikarabulut;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class GameDisplayTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Test
    @DisplayName("When welcomePrompt is called, then the welcome prompt should be printed to the command line")
    void welcomePrompt() {
        GameDisplay gameDisplay = new GameDisplay();
        System.setOut(new PrintStream(outContent));
        gameDisplay.welcomePrompt();

        assertEquals("Hello welcome to Conways Game of Life", outContent.toString().trim());

        System.setOut(originalOut);
    }

    @Test
    @DisplayName("When gameSettingsPrompt is called, then the game setting prompt should be printed to the command line")
    void gameSettingsPrompt() {
        GameDisplay gameDisplay = new GameDisplay();
        System.setOut(new PrintStream(outContent));
        gameDisplay.gameSettingsPrompt();

        assertEquals("Would you like to play with the default game settings? (y/n)", outContent.toString().trim());

        System.setOut(originalOut);
    }

    @Test
    @DisplayName("When evolutionsPrompt is called, then the evolutions prompt should be printed to the command line")
    void evolutionsPrompt() {
        GameDisplay gameDisplay = new GameDisplay();
        System.setOut(new PrintStream(outContent));
        gameDisplay.evolutionsPrompt();

        assertEquals("Please enter the number of evolution you would like to see:", outContent.toString().trim());

        System.setOut(originalOut);
    }

    @Test
    @DisplayName("When rowsPrompt is called, then the rows prompt should be printed to the command line")
    void rowsPrompt() {
        GameDisplay gameDisplay = new GameDisplay();
        System.setOut(new PrintStream(outContent));
        gameDisplay.rowsPrompt();

        assertEquals("Enter a number for the amount of rows you would like your board to have:", outContent.toString().trim());

        System.setOut(originalOut);
    }

    @Test
    @DisplayName("When columnsPrompt is called, then the columns prompt should be printed to the command line")
    void columnsPrompt() {
        GameDisplay gameDisplay = new GameDisplay();
        System.setOut(new PrintStream(outContent));
        gameDisplay.columnsPrompt();

        assertEquals("Enter a number for the amount of columns you would like your board to have:", outContent.toString().trim());

        System.setOut(originalOut);
    }

    @Test
    @DisplayName("When aliveSymbolPrompt is called, then the alive symbol prompt should be printed to the command line")
    void aliveSymbolPrompt() {
        GameDisplay gameDisplay = new GameDisplay();
        System.setOut(new PrintStream(outContent));
        gameDisplay.aliveSymbolPrompt();

        assertEquals("Enter a letter for your Alive Cell symbol", outContent.toString().trim());

        System.setOut(originalOut);
    }

    @Test
    @DisplayName("When deadSymbolPrompt is called, then the dead symbol should be printed to the command line")
    void deadSymbolPrompt() {
        GameDisplay gameDisplay = new GameDisplay();
        System.setOut(new PrintStream(outContent));
        gameDisplay.deadSymbolPrompt();

        assertEquals("Enter a letter for your Dead Cell symbol", outContent.toString().trim());

        System.setOut(originalOut);
    }

    @Test
    @DisplayName("When rulesPrompt is called, then the rules prompt should be printed to the command line")
    void rulesPrompt() {
        GameDisplay gameDisplay = new GameDisplay();
        System.setOut(new PrintStream(outContent));
        gameDisplay.rulesPrompt();

        assertEquals("Which RuleSet would you like to play with?" + "\n"
                        + "1: Alive Cell dies with less than 2 or more than 3 alive neighbors. Dead Cell comes to life with exactly 3 alive neighbors" + "\n"
                        + "2: Alive Cell die with less than 2 or more than 3 alive neighbors. Dead Cell comes to life with exactly 4 alive neighbors" + "\n"
                        + "Please enter the digit:"
                , outContent.toString().trim());

        System.setOut(originalOut);
    }

}
