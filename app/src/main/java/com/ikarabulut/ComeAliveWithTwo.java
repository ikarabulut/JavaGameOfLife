package com.ikarabulut;

public class ComeAliveWithTwo extends RuleSet {

    @Override
    protected boolean isFertileLand(int aliveNeighborsCount, boolean isAlive) {
        return (aliveNeighborsCount == 2 || aliveNeighborsCount == 3) && isAlive || aliveNeighborsCount == 2;
    }

}
