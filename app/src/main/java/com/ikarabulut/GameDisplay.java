package com.ikarabulut;

import java.util.ArrayList;

public class GameDisplay {
    private String welcomePrompt;
    private String gameSettingsPrompt;
    private String evolutionsPrompt;
    private String rowsPrompt;
    private String columnsPrompt;
    private String aliveSymbolPrompt;
    private String deadSymbolPrompt;

    public GameDisplay() {
        setWelcomePrompt();
        setGameSettingsPrompt();
        setEvolutionsPrompt();
        setRowsPrompt();
        setColumnsPrompt();
        setAliveSymbolPrompt();
        setDeadSymbolPrompt();
    }

    public void displayBoard(Board theBoard) {
        for (ArrayList<ArrayList> row : theBoard.getBoard()) {
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

    //PRIVATE METHODS
    private void setWelcomePrompt() {
        welcomePrompt = "Hello welcome to Conways Game of Life";
    }

    private void setGameSettingsPrompt() {
        gameSettingsPrompt = "Would you like to play with the default game settings? (y/n)";
    }

    private void setEvolutionsPrompt() {
        evolutionsPrompt = "Please enter the number of evolution you would like to see:";
    }

    private void setRowsPrompt() {
        rowsPrompt = "Enter a number for the amount of rows you would like your board to have:";
    }

    private void setColumnsPrompt() {
        columnsPrompt = "Enter a number for the amount of columns you would like your board to have:";
    }

    private void setAliveSymbolPrompt() {
        aliveSymbolPrompt = "Enter a letter for your Alive Cell symbol";
    }

    private void setDeadSymbolPrompt() {
        deadSymbolPrompt = "Enter a letter for your Dead Cell symbol";
    }
}
