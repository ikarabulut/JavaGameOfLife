package com.ikarabulut;

public class Rules implements RuleSet {


    public boolean willBeAliveNextGeneration(int aliveNeighborsCount, boolean isAlive) {
        if (aliveNeighborsCount < 2) {
            return isUnderpopulated();
        } else if (isAlive && aliveNeighborsCount == 2 || aliveNeighborsCount == 3) {
            return isFertileLand();
        } else {
            return isOverpopulated();
        }
    }

    private boolean isUnderpopulated() {
        return false;
    }

    private boolean isFertileLand() {
        return true;
    }

    private boolean isOverpopulated() {
        return false;
    }

}
