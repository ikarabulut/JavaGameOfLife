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

    public GameDisplay() {
        welcomePrompt = "Hello welcome to Conways Game of Life";
        gameSettingsPrompt = "Would you like to play with the default game settings? (y/n)";
        evolutionsPrompt = "Please enter the number of evolution you would like to see:";
        rowsPrompt = "Enter a number for the amount of rows you would like your board to have:";
        columnsPrompt = "Enter a number for the amount of columns you would like your board to have:";
        aliveSymbolPrompt = "Enter a letter for your Alive Cell symbol";
        deadSymbolPrompt = "Enter a letter for your Dead Cell symbol";
    }

    public void displayBoard(Board theBoard) {
        List<ArrayList> boardToDisplay = theBoard.getBoard();
        for (List<ArrayList> row : boardToDisplay) {
            System.out.println(row);
        }
    }

    public String welcomePrompt() {
        System.out.println(welcomePrompt);
        return welcomePrompt;
    }

    public String gameSettingsPrompt() {
        System.out.println(gameSettingsPrompt);
        return gameSettingsPrompt;
    }

    public String evolutionsPrompt() {
        System.out.println(evolutionsPrompt);
        return evolutionsPrompt;
    }

    public String rowsPrompt() {
        System.out.println(rowsPrompt);
        return rowsPrompt;
    }

    public String columnsPrompt() {
        System.out.println(columnsPrompt);
        return columnsPrompt;
    }

    public String aliveSymbolPrompt() {
        System.out.println(aliveSymbolPrompt);
        return aliveSymbolPrompt;
    }

    public String deadSymbolPrompt() {
        System.out.println(deadSymbolPrompt);
        return deadSymbolPrompt;
    }

}
