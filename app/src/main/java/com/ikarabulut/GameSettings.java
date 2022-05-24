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
        String errorMessage = "An error occurred, please enter an integer. Try again: ";

        while (retries > 0) {
            try {
                evolutions = Integer.parseInt(input.nextLine());
                return;
            } catch (Exception e) {
                retries = catchCustomErrorMessage(retries, errorMessage);
            }
            if (retries == 0) {
                tooManyInvalidEntries();
            }
        }
    }

    public void setRows() {
        display.rowsPrompt();
        int intSelection = 0;
        int retries = 3;
        String errorMessage = "Your input is invalid. Please keep under 25 and try again: ";

        while (retries > 0) {
            try {
                intSelection = Integer.parseInt(input.nextLine());
                rows = rowColumnInputChecker(intSelection);
                break;
            } catch (Exception ex) {
                retries = catchCustomErrorMessage(retries, errorMessage);
            }
            if (retries == 0) {
                tooManyInvalidEntries();
            }
        }
    }

    public void setColumns() {
        display.columnsPrompt();
        int intSelection = 0;
        int retries = 3;
        String errorMessage = "Your input is invalid. Please keep under 25 and try again: ";

        while (retries > 0) {
            try {
                intSelection = Integer.parseInt(input.nextLine());
                columns = rowColumnInputChecker(intSelection);
                break;
            } catch (Exception ex) {
                retries = catchCustomErrorMessage(retries, errorMessage);
            }
            if (retries == 0) {
                tooManyInvalidEntries();
            }
        }
    }

    public void setAliveSymbol() {
        display.aliveSymbolPrompt();
        int retries = 3;

        while (retries > 0) {
            try {
                String selection = input.nextLine();
                aliveSymbol = symbolInputChecker(selection);
                break;
            } catch (InvalidSymbolException ex) {
                retries = catchException(retries, ex);
            }
            if (retries == 0) {
                tooManyInvalidEntries();
            }
        }
    }

    public void setDeadSymbol() {
        display.deadSymbolPrompt();
        int retries = 3;

        while (retries > 0) {
            try {
                String selection = input.nextLine();
                deadSymbol = symbolInputChecker(selection);
                break;
            } catch (InvalidSymbolException ex) {
                retries = catchException(retries, ex);
            }
            if (retries == 0) {
                tooManyInvalidEntries();
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
                break;
            } catch (NumberFormatException | InvalidRuleSelectionException ex) {
                retries = catchException(retries, ex);
            }
            if (retries == 0) {
                tooManyInvalidEntries();
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

    private void tooManyInvalidEntries() {
        System.err.print("You have failed to choose a valid number of evolutions. Game exiting");
        System.exit(1);
    }

    private int rowColumnInputChecker(int intSelection) {
        if (intSelection > 25) {
            throw new IllegalArgumentException("Please limit this input to under 25. Please re-enter your selection: ");
        }
        return intSelection;
    }

    private String symbolInputChecker(String selection) {
        if (selection.length() > 1) {
            throw new InvalidSymbolException("Please limit the symbol to 1 character. Please try again: ");
        }
        return selection;
    }

    private int catchException(int retries, Exception ex) {
        System.err.print(ex.getMessage());
        return retries - 1;
    }

    private int catchCustomErrorMessage(int retries, String errorMessage) {
        System.err.print(errorMessage);
        return retries - 1;
    }

}
