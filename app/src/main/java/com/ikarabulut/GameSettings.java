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

    private GameDisplay display;

    public GameSettings(GameDisplay displayPrompts) {
        display = displayPrompts;
        rulesFactory = new RulesFactory();
    }

    public void getAllSettings() {
        setEvolutions();
        setRows();
        setColumns();
        setAliveSymbol();
        setDeadSymbol();
        setRuleSet();
    }

    public void setEvolutions() {
        display.evolutionsPrompt();
        int retries = 3;

        while (retries > 0) {
            try {
                evolutions = Integer.parseInt(input.nextLine());
                return;
            } catch (Exception e) {
                System.err.print("An error occurred, please enter an integer. Try again: ");
                retries = retries - 1;
            }
            if (retries == 0) {
                System.err.print("You have failed to choose a valid number of evolutions. Game exiting");
                System.exit(1);
            }
        }
    }


    public void setRows() {
        display.rowsPrompt();
        int intSelection = 0;
        int retries = 3;

        while (retries > 0) {
            try {
                intSelection = Integer.parseInt(input.nextLine());
                if (intSelection > 25) {
                    throw new IllegalArgumentException("Please limit the number of rows to under 25. Please re-enter your selection: ");
                }
                rows = intSelection;
                return;
            } catch (Exception ex) {
                System.err.print("Your input is invalid. Please keep under 25 and try again: ");
                retries = retries - 1;
            }
            if (retries == 0) {
                System.err.print("You have failed to choose a valid number of rows. Game exiting");
                System.exit(1);
            }
        }
    }

    public void setColumns() {
        display.columnsPrompt();
        int intSelection = 0;
        int retries = 3;

        while (retries > 0) {
            try {
                intSelection = Integer.parseInt(input.nextLine());
                if (intSelection > 25) {
                    throw new IllegalArgumentException("Please limit the number of columns to under 25. Please re-enter your selection: ");
                }
                columns = intSelection;
                return;
            } catch (Exception ex) {
                System.err.print("Your input is invalid. Please keep under 25 and try again: ");
                retries = retries - 1;
            }
            if (retries == 0) {
                System.err.print("You have failed to choose a valid number of columns. Game exiting");
                System.exit(1);
            }
        }
    }

    public void setAliveSymbol() {
        display.aliveSymbolPrompt();
        int retries = 3;

        while (retries > 0) {
            try {
                String selection = input.nextLine();
                if (selection.length() > 1) {
                    throw new InvalidSymbolException("Please limit the symbol to 1 character. Please try again: ");
                }
                aliveSymbol = selection;
                return;
            } catch (InvalidSymbolException ex) {
                System.err.print(ex.getMessage());
                retries = retries - 1;
            }
            if (retries == 0) {
                System.err.print("You have failed to choose a valid alive symbol. Game exiting");
                System.exit(1);
            }
        }
    }

    public void setDeadSymbol() {
        display.deadSymbolPrompt();
        int retries = 3;

        while (retries > 0) {
            try {
                String selection = input.nextLine();
                if (selection.length() > 1) {
                    throw new InvalidSymbolException("Please limit the symbol to 1 character. Please try again: ");
                }
                deadSymbol = selection;
                return;
            } catch (InvalidSymbolException ex) {
                System.err.print(ex.getMessage());
                retries = retries - 1;
            }
            if (retries == 0) {
                System.err.print("You have failed to choose a valid dead symbol. Game exiting");
                System.exit(1);
            }
        }
    }

    public void setRuleSet() {
        display.rulesPrompt();
        int retries = 3;

        while (retries > 0) {
            try {
                int ruleSelection = Integer.parseInt(input.nextLine());
                rules = rulesFactory.getRules(ruleSelection);
                return;
            } catch (NumberFormatException | InvalidRuleSelectionException ex) {
                System.err.print(ex.getMessage());
                retries = retries - 1;
            }
            if (retries == 0) {
                System.err.print("You have failed to choose a valid rule set. Game exiting");
                System.exit(1);
            }
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
