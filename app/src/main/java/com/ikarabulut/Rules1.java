package com.ikarabulut;

public class Rules1 implements RuleSet {

    private boolean isAliveNextGeneration;
    public boolean willBeAliveNextGeneration(int aliveNeighborsCount, boolean isAlive) {
        if (aliveNeighborsCount < 2) {
            isUnderpopulated();
        } else if (isAlive && aliveNeighborsCount == 2
                || isAlive && aliveNeighborsCount == 3
                || !isAlive && aliveNeighborsCount == 4) {
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
