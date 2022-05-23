package com.ikarabulut;

public class RuleSet {

    public boolean willBeAliveNextGeneration(int aliveNeighborsCount, boolean isAlive) {
        return isFertileLand(aliveNeighborsCount, isAlive);
    }


    protected boolean isFertileLand(int aliveNeighborsCount, boolean isAlive) {
        if (isAlive) {
            return aliveNeighborsCount == 2 || aliveNeighborsCount == 3;
        } else
            return aliveNeighborsCount == 3;
    }

}
