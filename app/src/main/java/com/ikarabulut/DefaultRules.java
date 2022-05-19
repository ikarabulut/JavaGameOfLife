package com.ikarabulut;

public class DefaultRules implements RuleSet {


    public boolean willBeAliveNextGeneration(int aliveNeighborsCount, boolean isAlive) {
        if (aliveNeighborsCount < 2) {
            return isUnderpopulated();
        } else if (isAlive && aliveNeighborsCount == 2 || aliveNeighborsCount == 3) {
            return isFertileLand();
        } else {
            return isOverpopulated();
        }
    }


}
