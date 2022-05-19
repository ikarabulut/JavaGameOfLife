package com.ikarabulut;

import java.util.Scanner;

public class GameSettings {
    private int evolutions = 25;
    private int rows = 10;
    private int columns = 10;
    private String aliveSymbol = "x";
    private String deadSymbol = "o";

    private RulesFactory rulesFactory;
    private RuleSet rules = new DefaultRules();

    private Scanner input = new Scanner(System.in);

    private int intSelection;

    private GameDisplay display;

    public GameSettings(GameDisplay displayPrompts) {
        display = displayPrompts;
        rulesFactory = new RulesFactory();
    }

    public void getAllSettings() throws InvalidSymbolException {
        setEvolutions();
        setRows();
        setColumns();
        setAliveSymbol();
        setDeadSymbol();
        setRuleSet();
    }

    public void setEvolutions() {
        display.evolutionsPrompt();
        try {
            evolutions = Integer.parseInt(input.nextLine());
        } catch (Exception e) {
            System.err.print("An error occurred, please enter an integer. Try again: ");
            setEvolutions();
        }
    }


    public void setRows() {
        display.rowsPrompt();
        try {
            intSelection = Integer.parseInt(input.nextLine());
        } catch (Exception ex) {
            System.err.print("Your input is invalid. Please try again: ");
            setRows();
        } finally {
            try {
                if (intSelection > 25) {
                    throw new IllegalArgumentException("Please limit the number of columns to under 25. Please re-enter your selection: ");
                } else {
                    rows = intSelection;
                }
            } catch (IllegalArgumentException ex) {
                System.err.print(ex.getMessage());
                setRows();
            }
        }
    }

    public void setColumns() {
        display.columnsPrompt();
        try {
            intSelection = Integer.parseInt(input.nextLine());
        } catch (Exception ex) {
            System.err.print("Your input is invalid. Please try again: ");
            setColumns();
        } finally {
            try {
                if (intSelection > 25) {
                    throw new IllegalArgumentException("Please limit the number of columns to under 25. Please re-enter your selection: ");
                } else {
                    columns = intSelection;
                }
            } catch (IllegalArgumentException ex) {
                System.err.print(ex.getMessage());
                setColumns();
            }
        }
    }

    public void setAliveSymbol() {
        display.aliveSymbolPrompt();
        String selection = input.nextLine();
        try {
            if (selection.length() > 1) {
                throw new InvalidSymbolException("Please limit the symbol to 1 character. Please try again: ");
            } else {
                aliveSymbol = selection;
            }
        } catch (InvalidSymbolException ex) {
            System.err.print(ex.getMessage());
            setAliveSymbol();
        }
    }

    public void setDeadSymbol() throws InvalidSymbolException {
        display.deadSymbolPrompt();
        String selection = input.nextLine();
        try {
            if (selection.length() > 1) {
                throw new InvalidSymbolException("Please limit the symbol to 1 character. Please try again: ");
            } else {
                deadSymbol = selection;
            }
        } catch (InvalidSymbolException ex) {
            System.err.print(ex.getMessage());
            setDeadSymbol();
        }
    }

    public void setRuleSet() {
        display.rulesPrompt();
        try {
            int ruleSelection = Integer.parseInt(input.nextLine());
            rules = rulesFactory.getRules(ruleSelection);
        } catch (NumberFormatException | InvalidRuleSelectionException ex) {
            System.err.print(ex.getMessage());
            setRuleSet();
        }
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

    public RuleSet getRules() {
        return rules;
    }

}
