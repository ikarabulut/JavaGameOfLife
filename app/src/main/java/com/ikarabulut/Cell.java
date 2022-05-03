package com.ikarabulut;

public class Cell {
    private boolean isAlive = false;

    public boolean checkIfAlive() {
        return isAlive;
    }
    public void reviveMe() {
        isAlive = true;
    }
}
