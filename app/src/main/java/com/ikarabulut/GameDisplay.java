package com.ikarabulut;

import java.util.ArrayList;
import java.util.List;


public class GameDisplay {
    private String welcomePrompt;
    private String gameSettingsPrompt;
    private String evolutionsPrompt;
    private String rowsPrompt;
    private String columnsPrompt;
    private String aliveSymbolPrompt;
    private String deadSymbolPrompt;

    private String rulesPrompt;

    public GameDisplay() {
        welcomePrompt = "Hello welcome to Conways Game of Life";
        gameSettingsPrompt = "Would you like to play with the default game settings? (y/n)";
        evolutionsPrompt = "Please enter the number of evolution you would like to see:";
        rowsPrompt = "Enter a number for the amount of rows you would like your board to have:";
        columnsPrompt = "Enter a number for the amount of columns you would like your board to have:";
        aliveSymbolPrompt = "Enter a letter for your Alive Cell symbol";
        deadSymbolPrompt = "Enter a letter for your Dead Cell symbol";
        rulesPrompt = "Which RuleSet would you like to play with?" + "\n"
                + "1: Alive Cell dies with less than 2 or more than 3 alive neighbors. Dead Cell comes to life with exactly 3 alive neighbors" + "\n"
                + "2: Alive Cell die with less than 2 or more than 3 alive neighbors. Dead Cell comes to life with exactly 4 alive neighbors" + "\n"
                + "Please enter the digit:";
    }

    public void displayBoard(Board theBoard, GameSettings theSettings) {
        List<ArrayList> boardToDisplay = theBoard.getBoard();
        for (List<Cell> row : boardToDisplay) {
            StringBuilder displayedRow = new StringBuilder();
            for (Cell cell : row) {
                if (cell.checkIfAlive()) {
                    displayedRow.append(theSettings.getAliveSymbol());
                } else {
                    displayedRow.append(theSettings.getDeadSymbol());
                }
                displayedRow.append(" ");
            }
            System.out.println(displayedRow);
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.flush();
    }

    public void welcomePrompt() {
        System.out.println(welcomePrompt);
    }

    public void gameSettingsPrompt() {
        System.out.println(gameSettingsPrompt);
    }

    public void evolutionsPrompt() {
        System.out.println(evolutionsPrompt);
    }

    public void rowsPrompt() {
        System.out.println(rowsPrompt);
    }

    public void columnsPrompt() {
        System.out.println(columnsPrompt);
    }

    public void aliveSymbolPrompt() {
        System.out.println(aliveSymbolPrompt);
    }

    public void deadSymbolPrompt() {
        System.out.println(deadSymbolPrompt);
    }

    public void rulesPrompt() {
        System.out.println(rulesPrompt);
    }

    public void displayGenerationNumber(int generation) {
        System.out.println("Generation " + generation);
    }


}
