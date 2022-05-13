package com.ikarabulut;

public class Game {
    private Board board;
    private GameSettings gameSettings;

    public Game(Board theBoard, GameSettings theGameSettings) {
        board = theBoard;
        gameSettings = theGameSettings;
    }

    public void startGenerationLoops() {
        int numOfEvolutions = gameSettings.getEvolutions();

        for (int i=0; i<numOfEvolutions; i++) {
            generateNextBoard();
        }
    }

    public Board generateNextBoard() {
        int rows = board.getRows();
        int columns = board.getColumns();
        Board nextBoard = new Board(rows, columns);

        for (int row=0; row<rows; row++) {
            for (int column=0; column<columns; column++) {
                Cell cell = board.getCell(row, column);
                int aliveNeighbors = board.getNumberOfAliveNeighbors(row, column);
                boolean isAliveNextGeneration = Rules.willBeAliveNextGeneration(aliveNeighbors, cell.checkIfAlive());
                if (isAliveNextGeneration) {
                    nextBoard.setAliveAt(row, column);
                }
            }
        }

        board = nextBoard;
        return nextBoard;
    }
}
