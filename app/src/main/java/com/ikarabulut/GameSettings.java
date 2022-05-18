package com.ikarabulut;

import java.util.Scanner;

public class GameSettings {
    private int evolutions = 25;
    private int rows = 10;
    private int columns = 10;
    private String aliveSymbol = "x";
    private String deadSymbol = "o";

    private Scanner input = new Scanner(System.in);

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
        evolutions = Integer.parseInt(input.nextLine());
    }

    public void setRows() {
        display.rowsPrompt();
        rows = Integer.parseInt(input.nextLine());
    }

    public void setColumns() {
        display.columnsPrompt();
        columns = Integer.parseInt(input.nextLine());
    }

    public void setAliveSymbol() {
        display.aliveSymbolPrompt();
        aliveSymbol = input.nextLine();
    }

    public void setDeadSymbol() {
        display.deadSymbolPrompt();
        deadSymbol = input.nextLine();
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
