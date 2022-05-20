package com.ikarabulut;

public class ComeAliveRandomly extends RuleSet {

    @Override
    protected boolean isFertileLand(int aliveNeighborsCount, boolean isAlive) {
        return (aliveNeighborsCount == 2 || aliveNeighborsCount == 3) && isAlive || !isAlive && deadCellFateRandomizer();
    }

    private boolean deadCellFateRandomizer() {
        return Math.random() > 0.5;
    }

}
