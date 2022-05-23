package com.ikarabulut;

public class ComeAliveRandomly extends RuleSet {

    @Override
    protected boolean isFertileLand(int aliveNeighborsCount, boolean isAlive) {
        if (isAlive) {
            return aliveNeighborsCount == 2 || aliveNeighborsCount == 3;
        } else {
            return deadCellFateRandomizer();
        }
    }

    private boolean deadCellFateRandomizer() {
        return Math.random() > 0.5;
    }

}
