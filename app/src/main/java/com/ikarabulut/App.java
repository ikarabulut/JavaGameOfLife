package com.ikarabulut;

public class App {

    public static void main(String[] args) {
        GameDisplay gameDisplay = new GameDisplay();
        GameSettings gameSettings = new GameSettings(gameDisplay);
        gameSettings.getAllSettings();
        Game theGame = new Game(gameSettings);
    }

}
