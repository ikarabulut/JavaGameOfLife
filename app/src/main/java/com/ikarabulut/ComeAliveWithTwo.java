package com.ikarabulut;

public class ComeAliveWithTwo extends RuleSet {

    @Override
    public boolean willBeAliveNextGeneration(int aliveNeighborsCount, boolean isAlive) {
        return super.willBeAliveNextGeneration(aliveNeighborsCount, isAlive);
    }

    @Override
    protected boolean isFertileLand(int aliveNeighborsCount, boolean isAlive) {
        return (aliveNeighborsCount == 2 || aliveNeighborsCount == 3) && isAlive || aliveNeighborsCount == 2;
    }

}
