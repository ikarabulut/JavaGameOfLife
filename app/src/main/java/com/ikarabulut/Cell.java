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

    public Cell(boolean isAlive){
        this.isAlive = isAlive;
        aliveSymbol = "O";
        deadSymbol = "-";
    }

    public boolean checkIfAlive() {
        return isAlive;
    }
    public void setIsAlive(boolean aliveStatus) {
        isAlive = aliveStatus;
    }

    public String toString() {
        if (isAlive) {
            return aliveSymbol;
        } else {
            return deadSymbol;
        }
    }
}
