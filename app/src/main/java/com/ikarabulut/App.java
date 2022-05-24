package com.ikarabulut;

public class App {

    public static void main(String[] args) {
        GameDisplay gameDisplay = new GameDisplay();
        GameSettings gameSettings = new GameSettings(gameDisplay);
        gameSettings.getAllSettings();
        Board theBoard = new Board(gameSettings.getRows(), gameSettings.getColumns());
        theBoard.generateRandomBoard();
        Game theGame = new Game(theBoard, gameSettings, gameDisplay);
        theGame.startEvolutions();
    }

}
