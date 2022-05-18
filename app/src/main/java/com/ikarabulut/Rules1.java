package com.ikarabulut;

public class Rules1 implements RuleSet {

    public boolean willBeAliveNextGeneration(int aliveNeighborsCount, boolean isAlive) {
        if (aliveNeighborsCount < 2) {
            return isUnderpopulated();
        } else if (isAlive && aliveNeighborsCount == 2
                || isAlive && aliveNeighborsCount == 3
                || !isAlive && aliveNeighborsCount == 4) {
            return isFertileLand();
        } else {
            return isOverpopulated();
        }
    }

    private boolean isUnderpopulated() { return false; }

    private boolean isFertileLand() { return true; }

    private boolean isOverpopulated() { return false; }

}
