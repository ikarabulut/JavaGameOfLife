package com.ikarabulut;

public class Cell {
    private boolean isAlive;
    private String aliveSymbol;
    private String deadSymbol;

    public Cell(){
        isAlive = false;
        aliveSymbol = "O";
        deadSymbol = "-";
    }

    public boolean checkIfAlive() {
        return isAlive;
    }
    public void reviveMe() {
        isAlive = true;
    }

    public void die() {
        isAlive = false;
    }

    public String toString() {
        if (isAlive) {
            return aliveSymbol;
        } else {
            return deadSymbol;
        }
    }
}
