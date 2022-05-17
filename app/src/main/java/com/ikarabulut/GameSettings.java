package com.ikarabulut;

import java.util.Scanner;

public class GameSettings {
    private int evolutions;
    private int rows;
    private int columns;
    private String aliveSymbol;
    private String deadSymbol;

    private Scanner evolutionsInput = new Scanner(System.in);
    private Scanner rowsInput = new Scanner(System.in);
    private Scanner columnsInput = new Scanner(System.in);
    private Scanner aliveSymbolInput = new Scanner(System.in);
    private Scanner deadSymbolInput = new Scanner(System.in);

    private GameDisplay display;

    public GameSettings(GameDisplay displayPrompts) {
        display = displayPrompts;
    }

    public void getAllSettings() {
        setEvolutions();
        setRows();
        setColumns();
        setAliveSymbol();
        setDeadSymbol();
    }

    public void setEvolutions() {
        display.evolutionsPrompt();
        evolutions = evolutionsInput.nextInt();
    }

    public void setRows() {
        display.rowsPrompt();
        rows = rowsInput.nextInt();
    }

    public void setColumns() {
        display.columnsPrompt();
        columns = columnsInput.nextInt();
    }

    public void setAliveSymbol() {
        display.aliveSymbolPrompt();
        aliveSymbol = aliveSymbolInput.nextLine();
    }

    public void setDeadSymbol() {
        display.deadSymbolPrompt();
        deadSymbol = deadSymbolInput.nextLine();
    }

    public int getEvolutions() {
        return evolutions;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public String getAliveSymbol() {
        return aliveSymbol;
    }

    public String getDeadSymbol() {
        return deadSymbol;
    }

}
