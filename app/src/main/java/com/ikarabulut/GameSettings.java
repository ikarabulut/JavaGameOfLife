package com.ikarabulut;

import java.util.Scanner;

public class GameSettings {
    private int evolutions;
    private int rows;
    private int columns;
    private String aliveSymbol;
    private String deadSymbol;

    private Scanner inputs;

    private GameDisplay display;

    public GameSettings(GameDisplay displayPrompts) {
        inputs = new Scanner(System.in);
        display = displayPrompts;
    }

    public GameSettings(String mockInput, GameDisplay displayPrompts) {
        inputs = new Scanner(mockInput);
        display = displayPrompts;
    }

    public void setEvolutions() {
        display.evolutionsPrompt();
        evolutions = inputs.nextInt();
    }

    public void setRows() {
        display.rowsPrompt();
        rows = inputs.nextInt();
    }

    public void setColumns() {
        display.columnsPrompt();
        columns = inputs.nextInt();
    }

    public void setAliveSymbol() {
        display.aliveSymbolPrompt();
        aliveSymbol = inputs.nextLine();
    }

    public void setDeadSymbol() {
        display.deadSymbolPrompt();
        deadSymbol = inputs.nextLine();
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
