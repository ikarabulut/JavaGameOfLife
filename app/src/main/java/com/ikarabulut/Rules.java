package com.ikarabulut;

public class Rules implements RuleSet {

    private boolean isAliveNextGeneration;

    public boolean willBeAliveNextGeneration(int aliveNeighborsCount, boolean isAlive) {
        if (aliveNeighborsCount < 2) {
            isUnderpopulated();
        } else if (isAlive && aliveNeighborsCount == 2 || aliveNeighborsCount == 3) {
            isFertileLand();
        } else {
            isOverpopulated();
        }
        return isAliveNextGeneration;
    }

    public void isUnderpopulated() {
        isAliveNextGeneration = false;
    }

    public void isFertileLand() {
        isAliveNextGeneration = true;
    }

    public void isOverpopulated() {
        isAliveNextGeneration = false;
    }

}
