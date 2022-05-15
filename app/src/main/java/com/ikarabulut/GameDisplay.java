package com.ikarabulut;

public class GameDisplay {
    private GameSettings gameSettings;
    private Board gameBoard;
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

    public String getWelcomePrompt() {
        return welcomePrompt;
    }

    public String getGameSettingsPrompt() {
        return gameSettingsPrompt;
    }

    public String getEvolutionsPrompt() {
        return evolutionsPrompt;
    }

    public String getRowsPrompt() {
        return rowsPrompt;
    }

    public String getColumnsPrompt() {
        return columnsPrompt;
    }

    public String getAliveSymbolPrompt() {
        return aliveSymbolPrompt;
    }

    public String getDeadSymbolPrompt() {
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
