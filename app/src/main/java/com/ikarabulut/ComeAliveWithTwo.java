package com.ikarabulut;

public class ComeAliveWithTwo extends RuleSet {

    @Override
    protected boolean isFertileLand(int aliveNeighborsCount, boolean isAlive) {
        if (isAlive) {
            return aliveNeighborsCount == 2 || aliveNeighborsCount == 3;
        } else {
            return aliveNeighborsCount == 2;
        }
    }

}
