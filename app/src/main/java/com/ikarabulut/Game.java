package com.ikarabulut;

public class Game {
    private Board board;
    private GameSettings gameSettings;

    private GameDisplay gameDisplay;

    public Game(Board theBoard, GameSettings theGameSettings, GameDisplay theDisplay) {
        gameSettings = theGameSettings;
        board = theBoard;
        gameDisplay = theDisplay;
    }

    public void startEvolutions() {
        int numOfEvolutions = gameSettings.getEvolutions();

        for (int i = 0; i <= numOfEvolutions; i++) {
            generateNextBoard();
            gameDisplay.displayGenerationNumber(i);
            gameDisplay.displayBoard(board, gameSettings);
        }
    }

    public Board generateNextBoard() {
        RuleSet rules = gameSettings.getRules();
        int rows = gameSettings.getRows();
        int columns = gameSettings.getColumns();
        Board nextBoard = new Board(rows, columns);

        for (int row=0; row<rows; row++) {
            for (int column=0; column<columns; column++) {
                Cell cell = board.getCell(row, column);
                int aliveNeighbors = board.getNumberOfAliveNeighbors(row, column);
                boolean isAliveNextGeneration = rules.willBeAliveNextGeneration(aliveNeighbors, cell.checkIfAlive());
                if (isAliveNextGeneration) {
                    nextBoard.setAliveAt(row, column);
                }
            }
        }

        board = nextBoard;
        return nextBoard;
    }
}
