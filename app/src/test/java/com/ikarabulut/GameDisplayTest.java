package com.ikarabulut;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class GameDisplayTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private static GameDisplay gameDisplay;

    @BeforeAll
    static void setByteArrayOutputStream() {
        gameDisplay = new GameDisplay();
    }

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @AfterAll
    static void tearDownObjects() {
        gameDisplay = null;
    }

    @Test
    @DisplayName("When welcomePrompt is called, then the welcome prompt should be printed to the command line")
    void welcomePrompt() {
        gameDisplay.welcomePrompt();

        assertEquals("Hello welcome to Conways Game of Life", outputStreamCaptor.toString()
                .trim());
    }

    @Test
    @DisplayName("When gameSettingsPrompt is called, then the game setting prompt should be printed to the command line")
    void gameSettingsPrompt() {
        gameDisplay.gameSettingsPrompt();

        assertEquals("Would you like to play with the default game settings? (y/n)", outputStreamCaptor.toString()
                .trim());
    }

    @Test
    @DisplayName("When evolutionsPrompt is called, then the evolutions prompt should be printed to the command line")
    void evolutionsPrompt() {
        gameDisplay.evolutionsPrompt();

        assertEquals("Please enter the number of evolution you would like to see:", outputStreamCaptor.toString()
                .trim());
    }

    @Test
    @DisplayName("When rowsPrompt is called, then the rows prompt should be printed to the command line")
    void rowsPrompt() {
        gameDisplay.rowsPrompt();

        assertEquals("Enter a number for the amount of rows you would like your board to have:", outputStreamCaptor.toString()
                .trim());
    }

    @Test
    @DisplayName("When columnsPrompt is called, then the columns prompt should be printed to the command line")
    void columnsPrompt() {
        gameDisplay.columnsPrompt();

        assertEquals("Enter a number for the amount of columns you would like your board to have:", outputStreamCaptor.toString()
                .trim());
    }

    @Test
    @DisplayName("When aliveSymbolPrompt is called, then the alive symbol prompt should be printed to the command line")
    void aliveSymbolPrompt() {
        gameDisplay.aliveSymbolPrompt();

        assertEquals("Enter a letter for your Alive Cell symbol", outputStreamCaptor.toString()
                .trim());
    }

    @Test
    @DisplayName("When deadSymbolPrompt is called, then the dead symbol should be printed to the command line")
    void deadSymbolPrompt() {
        gameDisplay.deadSymbolPrompt();

        assertEquals("Enter a letter for your Dead Cell symbol", outputStreamCaptor.toString()
                .trim());
    }

    @Test
    @DisplayName("When rulesPrompt is called, then the rules prompt should be printed to the command line")
    void rulesPrompt() {
        gameDisplay.rulesPrompt();

        assertEquals("Which RuleSet would you like to play with?" + "\n"
                        + "1: Alive Cell dies with less than 2 or more than 3 alive neighbors. Dead Cell comes to life with exactly 3 alive neighbors" + "\n"
                        + "2: Alive Cell dies with less than 2 or more than 3 alive neighbors. Dead Cell comes to life with exactly 4 alive neighbors" + "\n"
                        + "3: Alive Cell dies with less than 2 or more than 3 alive neighbors. Dead Cell comes to life with exactly 2 alive neighbors" + "\n"
                        + "4: Alive Cell dies with less than 2 or more than 3 alive neighbors. Dead Cell comes to life randomly" + "\n"
                        + "Please enter the digit:"
                , outputStreamCaptor.toString()
                        .trim());
    }

}
