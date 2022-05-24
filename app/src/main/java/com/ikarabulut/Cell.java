package com.ikarabulut;

public class Cell {
    private boolean isAlive;

    public Cell(){
        isAlive = false;
    }

    public Cell(boolean isAlive){
        this.isAlive = isAlive;
    }

    public boolean checkIfAlive() {
        return isAlive;
    }
    public void setIsAlive(boolean aliveStatus) {
        isAlive = aliveStatus;
    }
}
